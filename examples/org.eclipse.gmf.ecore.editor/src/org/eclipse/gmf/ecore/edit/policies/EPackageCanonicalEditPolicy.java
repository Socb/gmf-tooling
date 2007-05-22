/*
 * Copyright (c) 2006, 2007 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.ecore.edit.parts.EAnnotation2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EAnnotationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EAttributeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EClass2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EClassEditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataType2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EDataTypeEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnum2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumEditPart;
import org.eclipse.gmf.ecore.edit.parts.EEnumLiteralEditPart;
import org.eclipse.gmf.ecore.edit.parts.EOperationEditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EPackage3EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReference2EditPart;
import org.eclipse.gmf.ecore.edit.parts.EReferenceEditPart;
import org.eclipse.gmf.ecore.edit.parts.EStringToStringMapEntryEditPart;
import org.eclipse.gmf.ecore.part.EcoreDiagramUpdater;
import org.eclipse.gmf.ecore.part.EcoreLinkDescriptor;
import org.eclipse.gmf.ecore.part.EcoreNodeDescriptor;
import org.eclipse.gmf.ecore.part.EcoreVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EPackageCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = EcoreDiagramUpdater.getEPackage_1000SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((EcoreNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		if (EcoreDiagramUpdater.isShortcutOrphaned(view)) {
			return true;
		}
		int visualID = EcoreVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case EClassEditPart.VISUAL_ID:
		case EPackage2EditPart.VISUAL_ID:
		case EAnnotationEditPart.VISUAL_ID:
		case EDataTypeEditPart.VISUAL_ID:
		case EEnumEditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement()) || visualID != EcoreVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(EcorePackage.eINSTANCE.getEPackage_EClassifiers());
			myFeaturesToSynchronize.add(EcorePackage.eINSTANCE.getEPackage_ESubpackages());
			myFeaturesToSynchronize.add(EcorePackage.eINSTANCE.getEModelElement_EAnnotations());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private Collection refreshConnections() {
		Map domain2NotationMap = new HashMap();
		Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			int diagramLinkVisualID = EcoreVisualIDRegistry.getVisualID(nextDiagramLink);
			for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator.hasNext();) {
				EcoreLinkDescriptor nextLinkDescriptor = (EcoreLinkDescriptor) LinkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					linksIterator.remove();
					LinkDescriptorsIterator.remove();
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection collectAllLinks(View view, Map domain2NotationMap) {
		Collection result = new LinkedList();
		switch (EcoreVisualIDRegistry.getVisualID(view)) {
		case EClassEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEClass_2001ContainedLinks(view));
			break;
		}
		case EPackage2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEPackage_2002ContainedLinks(view));
			break;
		}
		case EAnnotationEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEAnnotation_2003ContainedLinks(view));
			break;
		}
		case EDataTypeEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEDataType_2004ContainedLinks(view));
			break;
		}
		case EEnumEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEEnum_2005ContainedLinks(view));
			break;
		}
		case EAttributeEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEAttribute_3001ContainedLinks(view));
			break;
		}
		case EOperationEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEOperation_3002ContainedLinks(view));
			break;
		}
		case EAnnotation2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEAnnotation_3003ContainedLinks(view));
			break;
		}
		case EClass2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEClass_3004ContainedLinks(view));
			break;
		}
		case EPackage3EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEPackage_3005ContainedLinks(view));
			break;
		}
		case EDataType2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEDataType_3006ContainedLinks(view));
			break;
		}
		case EEnum2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEEnum_3007ContainedLinks(view));
			break;
		}
		case EStringToStringMapEntryEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEStringToStringMapEntry_3008ContainedLinks(view));
			break;
		}
		case EEnumLiteralEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEEnumLiteral_3009ContainedLinks(view));
			break;
		}
		case EReferenceEditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEReference_4002ContainedLinks(view));
			break;
		}
		case EReference2EditPart.VISUAL_ID: {
			domain2NotationMap.put(view.getElement(), view);
			result.addAll(EcoreDiagramUpdater.getEReference_4003ContainedLinks(view));
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors, Map domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
			final EcoreLinkDescriptor nextLinkDescriptor = (EcoreLinkDescriptor) linkDescriptorsIterator.next();
			EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
			EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND,
					false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement, Map domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}
}
