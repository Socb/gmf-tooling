/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author dstadnik
 */
public class ShipShape extends Figure {

	private WrapLabel label;

	private IFigure smallCargo;

	private IFigure largeCargo;

	public ShipShape() {
		GridLayout layout = new GridLayout(2, false);
		setLayoutManager(layout);
		add(new ImageFigure(getShipImage()), new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 1, 2));
		add(label = new WrapLabel(), new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false, 1, 1));
		add(smallCargo = new Figure(), new GridData(SWT.FILL, SWT.BEGINNING, true, false, 1, 1));
		smallCargo.setLayoutManager(new StackLayout());
		add(largeCargo = new Figure(), new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		largeCargo.setLayoutManager(new StackLayout());
	}

	protected Image getShipImage() {
		return getImageImage("images/ship.png"); //$NON-NLS-1$
	}

	protected Image getImageImage(String path) {
		Image image = JFaceResources.getImageRegistry().get(path);
		if (image == null) {
			ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.gmf.examples.taipan", path); //$NON-NLS-1$
			if (descriptor == null) {
				descriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			JFaceResources.getImageRegistry().put(path, image = descriptor.createImage());
		}
		return image;
	}

	public WrapLabel getLabel() {
		return label;
	}

	public IFigure getSmallCargo() {
		return smallCargo;
	}

	public IFigure getLargeCargo() {
		return largeCargo;
	}
}