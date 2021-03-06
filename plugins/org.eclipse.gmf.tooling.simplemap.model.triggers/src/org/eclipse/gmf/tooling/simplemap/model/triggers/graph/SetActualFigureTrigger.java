/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.model.triggers.graph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.tooling.simplemap.model.triggers.AbstractTrigger;

class SetActualFigureTrigger extends AbstractTrigger {

	private Figure newFigure;

	private Figure oldFigure;

	/**
	 * This trigger migrates compatible Figure attributes from oldFigure to newFigure
	 * @param domain
	 * @param oldFigure
	 * @param newFigure
	 */
	public SetActualFigureTrigger(TransactionalEditingDomain domain, Figure oldFigure, Figure newFigure) {
		super(domain);

		this.newFigure = newFigure;
		this.oldFigure = oldFigure;
	}

	@Override
	public void executeTrigger() {

		if (oldFigure == null || newFigure == null)
			return;

		//Containment references
		for (EReference reference : oldFigure.eClass().getEAllReferences())
			if (!reference.isDerived() && newFigure.eClass().getEAllReferences().contains(reference))
				newFigure.eSet(reference, oldFigure.eGet(reference));

		//Attributes
		for (EAttribute attribute : oldFigure.eClass().getEAllAttributes())
			if (newFigure.eClass().getEAllAttributes().contains(attribute))
				newFigure.eSet(attribute, oldFigure.eGet(attribute));

	}

}
