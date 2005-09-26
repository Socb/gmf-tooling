/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.codegen.util;

import java.io.ByteArrayInputStream;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jmerge.JControlModel;
import org.eclipse.emf.codegen.jmerge.JMerger;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.diagramrt.DiagramRTPackage;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.TextEdit;

/**
 * Invokes JET templates to populate diagram editor project.
 * @author artem
 */
public class Generator implements Runnable {
	private final GenDiagram myDiagram;

	// myDestRoot.getJavaProject().getElementName() == myDestProject.getName()
	private IPackageFragmentRoot myDestRoot;

	private IProject myDestProject;

	private JControlModel myJControlModel;

	private CodeFormatter myCodeFormatter;

	private IProgressMonitor myProgress;

	public Generator(GenDiagram diagram) {
		myDiagram = diagram;
	}

	public void run(IProgressMonitor progress) throws InterruptedException {
		setProgressMonitor(progress);
		doRun();
	}

	public void run() {
		try {
			doRun();
		} catch (InterruptedException ex) {
		}
	}

	private void doRun() throws InterruptedException {
		try {
			setupProgressMonitor();
			initializeEditorProject();
			generatePalette();
			generateCanvasEditPart();
			generateEditPartFactory();
			generateEditor();
			for (Iterator it = myDiagram.getNodes().iterator(); it.hasNext();) {
				final GenNode next = (GenNode) it.next();
				generateNodeEditPart(next);
				generateNodeMetaInfoProvider(next);
				for (Iterator it2 = next.getChildNodes().iterator(); it2.hasNext();) {
					GenChildNode child = (GenChildNode) it2.next();
					generateNodeEditPart(child);
				}
			}
			for (Iterator it = myDiagram.getLinks().iterator(); it.hasNext();) {
				final GenLink next = (GenLink) it.next();
				generateLinkEditPart(next);
				generateLinkMetaInfoProvider(next);
			}
			generateCanvasMetaInfoProvider();
			generatePluginClass();
			generatePluginXml();
			generateInitDiagramFileAction();
			boolean isBasicRT = DiagramRTPackage.eNS_URI.equals(myDiagram.getDiagramRunTimeClass().getGenPackage().getEcorePackage().getNsURI());
			generateMetaInfoProviderAdapterFactory(isBasicRT);
		} catch (JETException ex) {
			ex.printStackTrace();
		} catch (CoreException ex) {
			ex.printStackTrace();
		} catch (UnexpectedBehaviourException ex) {
			ex.printStackTrace();
		} finally {
			myProgress.done();
		}
	}

	private void generateInitDiagramFileAction() throws JETException, InterruptedException {
		generate(
			EmitterFactory.getInitDiagramFileActionEmitter(),
			myDiagram.getEditorPackageName(),
			myDiagram.getInitDiagramFileActionClassName(),
			myDiagram);
	}

	/**
	 * Optionally, specify progressMonitor to use. Should be called prior to {@link #run()}
	 * @param progress
	 */
	public void setProgressMonitor(IProgressMonitor progress) {
		myProgress = progress;
	}

	private void setupProgressMonitor() {
		if (myProgress == null) {
			myProgress = new NullProgressMonitor();
			return;
			// no need to set it up
		}
		Counter c = new Counter(myDiagram);
		c.setAdditionalOperations(9); // init, palette, editor, plugin.xml, etc
		c.setOperationsPerNode(2);
		c.setOperationsPerChildNode(1);
		c.setOperationsPerLink(2);
		myProgress.beginTask(Messages.start, c.getTotal());
	}

	private IProgressMonitor getNextStepMonitor() throws InterruptedException {
		if (myProgress.isCanceled()) {
			throw new InterruptedException();
		}
		return new SubProgressMonitor(myProgress, 1);
	}

	private void initializeEditorProject() throws CoreException, UnexpectedBehaviourException, InterruptedException {
		myDestProject = ResourcesPlugin.getWorkspace().getRoot().getProject(myDiagram.getPluginID());
		final Path srcPath = new Path('/' + myDestProject.getName() + "/src"); //$NON-NLS-1$
		final Path projectLocation = null; // use default
		final List referencedProjects = createReferencedProjectsList();
		final int style = org.eclipse.emf.codegen.ecore.Generator.EMF_PLUGIN_PROJECT_STYLE;
		final List pluginVariables = createPluginVariablesList();
		final IProgressMonitor pm = getNextStepMonitor();

		org.eclipse.emf.codegen.ecore.Generator.createEMFProject(srcPath, projectLocation, referencedProjects, pm, style, pluginVariables);

		myDestRoot = JavaCore.create(myDestProject).findPackageFragmentRoot(srcPath);
		if (myDestRoot == null) {
			throw new UnexpectedBehaviourException("no source root can be found");
		}
	}

	private List createPluginVariablesList() {
		return Collections.EMPTY_LIST;
	}

	private List createReferencedProjectsList() {
		return Collections.EMPTY_LIST;
	}

	private void generatePalette() throws JETException, InterruptedException {
		generate(
			EmitterFactory.getPaletteEmitter(),
			myDiagram.getPalette().getPackageName(),
			myDiagram.getPalette().getFactoryClassName(),
			myDiagram
		);
	}

	private void generateCanvasEditPart() throws JETException, InterruptedException {
		generate(
			EmitterFactory.getCanvasEditPartEmitter(),
			myDiagram.getEditPartsPackageName(),
			myDiagram.getEditPartClassName(),
			myDiagram
		);
	}

	private void generateEditPartFactory() throws JETException, InterruptedException {
		generate(
			EmitterFactory.getEditPartFactoryEmitter(),
			myDiagram.getEditPartsPackageName(),
			myDiagram.getEditPartFactoryClassName(),
			myDiagram
		);
	}

	private void generateNodeEditPart(GenNode genNode) throws JETException, InterruptedException {
		generate(
			EmitterFactory.getNodeEditPartEmitter(),
			myDiagram.getEditPartsPackageName(),
			genNode.getEditPartClassName(),
			genNode
		);
	}

	private void generateLinkEditPart(GenLink genLink) throws JETException, InterruptedException {
		generate(
			EmitterFactory.getLinkEditPartEmitter(),
			myDiagram.getEditPartsPackageName(),
			genLink.getEditPartClassName(),
			genLink
		);
	}

	private void generateEditor() throws JETException, InterruptedException {
		generate(
			EmitterFactory.getEditorEmitter(),
			myDiagram.getEditorPackageName(),
			myDiagram.getEditorClassName(), //$NON-NLS-1$
			myDiagram
		);
	}

	private void generatePluginClass() throws JETException, InterruptedException {
		generate(
			EmitterFactory.getPluginClassEmitter(),
			myDiagram.getEditorPackageName(), 
			myDiagram.getPluginClassName(),
			myDiagram
		);
	}

	private void generatePluginXml() throws JETException, InterruptedException {
		IProgressMonitor pm = getNextStepMonitor();
		try {
			pm.beginTask(Messages.pluginxml, 3);
			JETEmitter emitter = EmitterFactory.getPluginXmlEmitter();
			String genText = emitter.generate(new SubProgressMonitor(pm, 1), new Object[] { myDiagram });
			IFile f = myDestProject.getFile("plugin.xml"); //$NON-NLS-1$
			// FIXME merge!
			if (f.exists()) {
				f.setContents(new ByteArrayInputStream(genText.getBytes()), true, true, new SubProgressMonitor(pm, 1));
			} else {
				f.create(new ByteArrayInputStream(genText.getBytes()), true, new SubProgressMonitor(pm, 1));
			}
			f.getParent().refreshLocal(IResource.DEPTH_ONE, new SubProgressMonitor(pm, 1));
		} catch (CoreException ex) {
			ex.printStackTrace();
		} finally {
			pm.done();
		}
	}

	private void generateNodeMetaInfoProvider(GenNode genNode) throws JETException, InterruptedException {
		generate(
			EmitterFactory.getNodeMetaInfoProviderEmitter(),
			myDiagram.getEditProvidersPackageName(),
			genNode.getMetaInfoProviderClassName(),
			genNode
		);
	}

	private void generateLinkMetaInfoProvider(GenLink genLink) throws JETException, InterruptedException {
		generate(
			EmitterFactory.getLinkMetaInfoProviderEmitter(),
			myDiagram.getEditProvidersPackageName(),
			genLink.getMetaInfoProviderClassName(),
			genLink
		);
	}

	private void generateCanvasMetaInfoProvider() throws JETException, InterruptedException {
		generate(
			EmitterFactory.getCanvasMetaInfoProviderEmitter(),
			myDiagram.getEditProvidersPackageName(),
			myDiagram.getMetaInfoProviderClassName(),
			myDiagram
		);
	}

	private void generateMetaInfoProviderAdapterFactory(boolean isBasicRT) throws JETException, InterruptedException {
		generate(
			isBasicRT ? EmitterFactory.getMetaInfoProviderAF1Emitter() : EmitterFactory.getMetaInfoProviderAF2Emitter(), 
			myDiagram.getEditProvidersPackageName(),
			myDiagram.getMetaInfoFactoryClassName(),  //$NON-NLS-1$
			myDiagram
		);
	}

	/**
	 * NOTE: potential problem - packageName and className should match those specified in 
	 * the template. Besides, getQualifiedXXX helpers in diagram GenModel should also correctly
	 * return qualified class names.  
	 */
	private void generate(JETEmitter emitter, String packageName, String className, Object input) throws JETException, InterruptedException {
		IProgressMonitor pm = getNextStepMonitor();
		try {
			pm.beginTask(className, 4);
			String genText = emitter.generate(new SubProgressMonitor(pm, 1), new Object[] { input });
			IPackageFragment pf = myDestRoot.createPackageFragment(packageName, true, new SubProgressMonitor(pm, 1));
			ICompilationUnit cu = pf.getCompilationUnit(className + ".java"); //$NON-NLS-1$
			if (cu.exists()) {
				genText = merge(genText, cu.getSource(), new SubProgressMonitor(pm, 1));
			} else {
				pm.worked(1);
			}
			pf.createCompilationUnit(cu.getElementName(), formatCode(genText), true, new SubProgressMonitor(pm, 1));
		} catch (CoreException ex) {
			ex.printStackTrace();
		} finally {
			pm.done();
		}
	}

	private String merge(String generatedText, String oldContents, IProgressMonitor pm) {
		pm.beginTask(Messages.merge, 1);
		JMerger jMerge = new JMerger();
		jMerge.setControlModel(getJControlModel());
		jMerge.setSourceCompilationUnit(jMerge.createCompilationUnitForContents(generatedText));
		jMerge.setTargetCompilationUnit(jMerge.createCompilationUnitForContents(oldContents));
		jMerge.merge();
		pm.done();
		return jMerge.getTargetCompilationUnitContents();
	}

	private String formatCode(String text) {
		IDocument doc = new Document(text);
		TextEdit edit = getCodeFormatter().format(CodeFormatter.K_COMPILATION_UNIT, doc.get(), 0, doc.get().length(), 0, null);

		try {
			edit.apply(doc);
			text = doc.get();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return text;
	}

	private CodeFormatter getCodeFormatter() {
		if (myCodeFormatter == null) {
			myCodeFormatter = ToolFactory.createCodeFormatter(null);
		}
		return myCodeFormatter;
	}

	private JControlModel getJControlModel() {
		if (myJControlModel == null) {
			myJControlModel = new JControlModel(EmitterFactory.getJMergeControlFile().toString());
		}
		return myJControlModel;
	}

	private static final class Counter {
		private final GenDiagram myDiagram;
		private int myOpsPerNode = 1;
		private int myOpsPerLink = 1;
		private int myOpsPerChildNode = 1;
		private int myAdditionalOps = 0;

		Counter(GenDiagram diagram) {
			myDiagram = diagram;
		}

		public void setOperationsPerNode(int opsPerNode) {
			 myOpsPerNode = opsPerNode;
		}
		public void setOperationsPerLink(int opsPerLink) {
			myOpsPerLink = opsPerLink;
		}
		public void setOperationsPerChildNode(int opsPerChild) {
			myOpsPerChildNode = opsPerChild;
		}
		public void setAdditionalOperations(int additionalOps) {
			myAdditionalOps = additionalOps;
		}
		public int getTotal() {
			int rv = myAdditionalOps;
			rv += myDiagram.getNodes().size() * myOpsPerNode;
			rv += myDiagram.getLinks().size() * myOpsPerLink;
			rv += getChildNodeCount() * myOpsPerChildNode;
			return rv;  
		}

		private int getChildNodeCount() {
			int rv = 0;
			for (Iterator it = myDiagram.getNodes().iterator(); it.hasNext();) {
				rv += ((GenNode) it.next()).getChildNodes().size();
			}
			return rv;
		}
	}
}
