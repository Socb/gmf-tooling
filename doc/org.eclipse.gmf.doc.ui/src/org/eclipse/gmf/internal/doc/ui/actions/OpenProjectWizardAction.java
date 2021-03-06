/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.internal.doc.ui.actions;

import org.eclipse.gmf.internal.bridge.wizards.NewGMFProjectWizard;
import org.eclipse.gmf.internal.doc.ui.Activator;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.cheatsheets.ICheatSheetAction;
import org.eclipse.ui.cheatsheets.ICheatSheetManager;

public class OpenProjectWizardAction extends Action implements ICheatSheetAction {
	private static final int SIZING_WIZARD_WIDTH = 500;

	private static final int SIZING_WIZARD_HEIGHT = 500;

	/**
	 * @param text
	 */
	public OpenProjectWizardAction() {
		super("OpenProjectWizard"); //$NON-NLS-1$
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run() {
		run(new String[] {}, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.cheatsheets.ICheatSheetAction#run(java.lang.String[],
	 *      org.eclipse.ui.cheatsheets.ICheatSheetManager)
	 */
	public void run(String[] params, ICheatSheetManager manager) {
		String projectName = null;
		if (params != null && params.length > 0) {
			projectName = params[0];
		} else {
			projectName = "org.eclipse.gmf.examples.mindmap";
		}

		final NewGMFProjectWizard wizard = new NewGMFProjectWizard() {
			public boolean performFinish() {
				super.performFinish();
				// Project wizard now creates 'models' folder, otherwise create here
				return true;
			}
		};
		wizard.setInitialProjectName(projectName);
		wizard.setShowDashboard(false);

		// as IWorkbenchWizard
		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());

		WizardDialog dialog = new WizardDialog(Activator.getActiveWorkbenchShell(), wizard);
		dialog.create();
		dialog.getShell().setSize(Math.max(SIZING_WIZARD_WIDTH, dialog.getShell().getSize().x), SIZING_WIZARD_HEIGHT);
		dialog.open();
		notifyResult(dialog.getReturnCode() == Dialog.OK);

	}

}
