/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.taipan.Port;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies.TaiPanBaseItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class PortRegisterCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	public PortRegisterCreateCommand(CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		source = request.getSource();
		target = request.getTarget();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !(source instanceof Port)) {
			return false;
		}
		if (target != null && !(target instanceof Ship)) {
			return false;
		}
		if (getSource() != null && getTarget() != null) {
			return TaiPanBaseItemSemanticEditPolicy.LinkConstraints.canCreatePortRegister_4007(getSource(), getTarget());
		}
		return true; // link creation is in progress; only one end is defined
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		if (getSource() != null && getTarget() != null) {
			getSource().getRegister().add(getTarget());
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @generated
	 */
	protected Port getSource() {
		return (Port) source;
	}

	/**
	 * @generated
	 */
	protected Ship getTarget() {
		return (Ship) target;
	}
}
