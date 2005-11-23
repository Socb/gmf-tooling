/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.policies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.examples.taipan.Ship;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

/**
 * @generated
 */
public class CargoContainerCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		Ship modelElement = (Ship) ((View) getHost().getModel()).getElement();
		List result = new LinkedList();
		EObject nextValue;
		for (Iterator it = modelElement.getCargo().iterator(); it.hasNext();) {
			nextValue = (EObject) it.next();
			int nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, "");
			if (2001 == nodeVID) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected String getFactoryHint(IAdaptable elementAdapter) {
		return "";
	}
}
