/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.importer.ui.EMFModelWizard;
import org.eclipse.gmf.internal.bridge.genmodel.BasicGenModelAccess;
import org.eclipse.gmf.internal.bridge.genmodel.DummyGenModel;
import org.eclipse.gmf.internal.bridge.genmodel.FileGenModelAccess;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelAccess;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Interact with user to retrieve genmodel for the domain model. XXX detect
 * stale genmodels and reconcile them based on user's decision
 * 
 * @author artem
 */
class GenModelDetector {
	private GenModelAccess myGMAccess;

	private final IFile myPatternResource;

	public GenModelDetector(IFile patternResource) {
		assert patternResource != null;
		// seems acceptable to have IFile, resources and workspace when working
		// from UI
		myPatternResource = patternResource;
	}

	public IStatus find(Shell shell, Mapping mapping) {
		HashSet<EPackage> packages = new HashSet<EPackage>();
		for (Iterator it = EcoreUtil.ExternalCrossReferencer.find(mapping).keySet().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof EClass) {
				packages.add(((EClass) next).getEPackage());
			}
		}
		for (Iterator it = packages.iterator(); it.hasNext();) {
			EPackage next = (EPackage) it.next();
			if (next.getESuperPackage() != null && EcoreUtil.isAncestor(packages, next.getESuperPackage())) {
				it.remove();
			}
		}
		IFile workspaceFile;
		if (packages.isEmpty()) {
			myGMAccess = new GenModelAccess.Adapter(null);
			return Status.OK_STATUS;
		} else if (packages.size() == 1) {
			final EPackage solePack = packages.iterator().next();
			BasicGenModelAccess gma = new BasicGenModelAccess(solePack);
			gma.initDefault();
			if (gma.load(new ResourceSetImpl()).isOK()) {
				gma.unload();
				myGMAccess = gma;
				return Status.OK_STATUS;
			} else {
				workspaceFile = zzz(shell, packages);
			}
		} else {
			workspaceFile = askGenModelFile(shell, "Need genmodel to cover all referenced domain packages (" + packages.size() + ")");
		}
		if (workspaceFile == null) {
			return Status.CANCEL_STATUS;
		}
		myGMAccess = new FileGenModelAccess(workspaceFile);
		return Status.OK_STATUS;
	}

	/*
	 * Stolen from org.eclipse.emf.importer.ui.contribution.base.ModelImporterDetailPage$2#browseWorkspace
	 */
	private IFile askGenModelFile(Shell shell, String message) {
		ViewerFilter filter = new ViewerFilter() {
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return !(element instanceof IFile) || "genmodel".equals(((IFile) element).getFileExtension());
			}
		};
		IFile[] files = WorkspaceResourceDialog.openFileSelection(shell, null, message, false, new Object[] { myPatternResource.getParent() }, Collections.singletonList(filter));
		if (files.length > 0) {
			return files[0];
		}
		return null;
	}

	public GenModel get(ResourceSet resSet) {
		IStatus s = myGMAccess.load(resSet);
		if (!s.isOK()) {
			throw new IllegalStateException(s.getMessage());
		}
		return myGMAccess.model();
	}

	private IFile zzz(Shell shell, final Collection<EPackage> packages) {
		final IPath[] result = new IPath[1];
		final int LINK_RET_VAL = 178;
		int dlgRes = new LinkMessageDialog(shell, createDialogConfig()) {
			@Override
			protected void dispatchLinkSelected(String linkHref) {
				if ("link2".equals(linkHref)) {
					launchEMFWizard();
				} else if ("link1".equals(linkHref)) {
					createDefault();
				}
			}

			private void launchEMFWizard() {
				EMFModelWizard wizard = new EMFModelWizard() {
					@Override
					public boolean performFinish() {
						result[0] = genModelContainerPath.append(genModelFileName);
						return super.performFinish();
					}
				};
				wizard.init(PlatformUI.getWorkbench(), createSelectionForEMFWizard());
				if (WizardDialog.OK == new WizardDialog(getShell(), wizard).open()) {
					assert result[0] != null;
					closeWithCode(LINK_RET_VAL);
				}
				// else, just let user pick another link/button
			}

			@SuppressWarnings("unchecked")
			private void createDefault() {
				LinkedList<EPackage> pp = new LinkedList<EPackage>(packages);
				EPackage primaryPackage = pp.removeFirst();
				DummyGenModel gma = new DummyGenModel(primaryPackage, pp);
				// FIXME ask user for name of the plugin
				gma.setPluginID(myPatternResource.getProject().getName());
				GenModel model = gma.create();
				result[0] = createDefaultResourcePath();
				Resource res = new ResourceSetImpl().createResource(URI.createPlatformResourceURI(result[0].toString()));
				res.getContents().add(model);
				try {
					res.save(null);
					closeWithCode(LINK_RET_VAL);
				} catch (IOException ex) {
					CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("Can't save created genmodel", ex));
					// fall-through and wait for another user pick
				}
			}

			private void closeWithCode(int code) {
				setReturnCode(code);
				close();
			}
		}.open();
		if (dlgRes == 0) { // browse button
			if (packages.size() == 1) {
				EPackage pkg = packages.iterator().next();
				return askGenModelFile(shell, "Can't find genmodel for package " + pkg.getName() + "(" + pkg.getNsURI() + ")");
			} else {
				return askGenModelFile(shell, "Need genmodel to cover all referenced domain packages (" + packages.size() + ")");
			}
		} else if (dlgRes == LINK_RET_VAL) {
			assert result[0] != null;
			return ResourcesPlugin.getWorkspace().getRoot().getFile(result[0]);
		}
		assert dlgRes == MessageDialog.CANCEL;
		return null;
	}

	private StructuredSelection createSelectionForEMFWizard() {
		final IContainer parent = myPatternResource.getParent();
		IFile neighbour = parent.getFile(new Path(myPatternResource.getName()).removeFileExtension().addFileExtension("ecore"));
		if (neighbour.exists()) {
			return new StructuredSelection(neighbour);
		} else {
			return new StructuredSelection(myPatternResource);
		}
	}

	private IPath createDefaultResourcePath() {
		return myPatternResource.getFullPath().removeFileExtension().addFileExtension("genmodel");
	}

	private static LinkMessageDialog.Config createDialogConfig() {
		LinkMessageDialog.Config cfg = new LinkMessageDialog.Config();
		cfg.title = CodeGenUIPlugin.getBundleString("detectgenmodel.title");
		cfg.message = CodeGenUIPlugin.getBundleString("detectgenmodel.question");
		cfg.buttonLabels = new String[] { CodeGenUIPlugin.getBundleString("detectgenmodel.browse"), IDialogConstants.CANCEL_LABEL };
		cfg.imageType = MessageDialog.QUESTION;
		return cfg;
	}
}