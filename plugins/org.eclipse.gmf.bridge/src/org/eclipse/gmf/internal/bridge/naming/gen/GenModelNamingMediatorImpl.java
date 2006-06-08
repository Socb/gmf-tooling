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
package org.eclipse.gmf.internal.bridge.naming.gen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.common.IncrementalNamesDispenser;
import org.eclipse.gmf.common.NamesDispenser;
import org.eclipse.gmf.internal.bridge.naming.ClassNamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.DefaultNamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.DesignNamingStrategy;
import org.eclipse.gmf.internal.bridge.naming.NamingStrategy;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.CompartmentMapping;
import org.eclipse.gmf.mappings.LabelMapping;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.NodeMapping;

/**
 * @author artem
 */
public class GenModelNamingMediatorImpl implements GenModelNamingMediator {

	private NamesDispenser myDispenser;

	private NamingStrategy myViewFactory;

	private NamingStrategy myEditPart;

	private NamingStrategy myItemSemanticPolicy;

	private NamingStrategy myCanonicalPolicy;

	private NamingStrategy myNodeGraphicalPolicy;

	private NamingStrategy myTextViewFactory;

	private NamingStrategy myEditHelper;

	private NamingStrategy myEditHelperAdvice;

	public GenModelNamingMediatorImpl() {
		this(new IncrementalNamesDispenser());
	}

	public GenModelNamingMediatorImpl(NamesDispenser dispenser) {
		myDispenser = dispenser;
		setViewFactory(createNamingStrategy(GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX));
		setEditPart(createNamingStrategy(GenCommonBase.EDIT_PART_SUFFIX));
		setItemSemanticPolicy(createNamingStrategy(GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX));
		setCanonicalPolicy(createNamingStrategy(GenChildContainer.CANONICAL_EDIT_POLICY_SUFFIX));
		setNodeGraphicalPolicy(createNamingStrategy(GenNode.GRAPHICAL_NODE_EDIT_POLICY_SUFFIX));
		setEditHelper(createNamingStrategy(MetamodelType.EDIT_HELPER_SUFFIX));
		setEditHelperAdvice(createNamingStrategy(SpecializationType.EDIT_HELPER_ADVICE_SUFFIX));
	}

	protected NamingStrategy createNamingStrategy(String suffixPart) {
		// prefix stack
		NamingStrategy pns = new DefaultNamingStrategy(null, null, null, null);
		pns = new DesignNamingStrategy(null, null, pns, null);
		pns = new ClassNamingStrategy(null, null, pns, null);
		// primary stack
		NamingStrategy ns = new DefaultNamingStrategy(suffixPart, myDispenser, null, pns);
		ns = new DesignNamingStrategy(suffixPart, myDispenser, ns, pns);
		ns = new ClassNamingStrategy(suffixPart, myDispenser, ns, pns);
		return ns;
	}

	public void setViewFactory(NamingStrategy viewFactory) {
		myViewFactory = viewFactory;
	}

	public NamingStrategy getViewFactory() {
		return myViewFactory;
	}

	public void setEditPart(NamingStrategy editPart) {
		myEditPart = editPart;
	}

	public NamingStrategy getEditPart() {
		return myEditPart;
	}

	public void setItemSemanticPolicy(NamingStrategy itemSemanticPolicy) {
		myItemSemanticPolicy = itemSemanticPolicy;
	}

	public NamingStrategy getItemSemanticPolicy() {
		return myItemSemanticPolicy;
	}

	public void setCanonicalPolicy(NamingStrategy canonicalPolicy) {
		myCanonicalPolicy = canonicalPolicy;
	}

	public NamingStrategy getCanonicalPolicy() {
		return myCanonicalPolicy;
	}

	public void setTextViewFactory(NamingStrategy textViewFactory) {
		myTextViewFactory = textViewFactory;
	}

	public NamingStrategy getTextViewFactory() {
		return myTextViewFactory;
	}

	private void setNodeGraphicalPolicy(NamingStrategy nodeGraphicalPolicy) {
		myNodeGraphicalPolicy = nodeGraphicalPolicy;
	}

	private NamingStrategy getNodeGraphicalPolicy() {
		return myNodeGraphicalPolicy;
	}

	public void setEditHelper(NamingStrategy editHelper) {
		this.myEditHelper = editHelper;
	}

	public NamingStrategy getEditHelper() {
		return myEditHelper;
	}

	public void setEditHelperAdvice(NamingStrategy editHelperAdvice) {
		this.myEditHelperAdvice = editHelperAdvice;
	}

	public NamingStrategy getEditHelperAdvice() {
		return myEditHelperAdvice;
	}

	public void feed(GenDiagram genDiagram, CanvasMapping cme) {
		genDiagram.setNotationViewFactoryClassName(getViewFactory().get(cme));
		myDispenser.add(genDiagram.getBaseExternalNodeLabelEditPartClassName());
		genDiagram.setEditPartClassName(getEditPart().get(cme));
		myDispenser.add(genDiagram.getBaseItemSemanticEditPolicyClassName());
		genDiagram.setItemSemanticEditPolicyClassName(getItemSemanticPolicy().get(cme));
		genDiagram.setCanonicalEditPolicyClassName(getCanonicalPolicy().get(cme));
		myDispenser.add(genDiagram.getBaseGraphicalNodeEditPolicyClassName());
		myDispenser.add(genDiagram.getBaseEditHelperClassName());
		feedElementType(genDiagram, cme);
	}

	public void feed(GenTopLevelNode genNode, NodeMapping nme) {
		genNode.setNotationViewFactoryClassName(getViewFactory().get(nme));
		genNode.setEditPartClassName(getEditPart().get(nme));
		genNode.setItemSemanticEditPolicyClassName(getItemSemanticPolicy().get(nme));
		genNode.setCanonicalEditPolicyClassName(getCanonicalPolicy().get(nme));
		genNode.setGraphicalNodeEditPolicyClassName(getNodeGraphicalPolicy().get(nme));
		feedElementType(genNode, nme);
	}

	public void feed(GenChildNode childNode, NodeMapping nme) {
		childNode.setNotationViewFactoryClassName(getViewFactory().get(nme));
		childNode.setEditPartClassName(getEditPart().get(nme));
		childNode.setItemSemanticEditPolicyClassName(getItemSemanticPolicy().get(nme));
		childNode.setCanonicalEditPolicyClassName(getCanonicalPolicy().get(nme));
		childNode.setGraphicalNodeEditPolicyClassName(getNodeGraphicalPolicy().get(nme));
		feedElementType(childNode, nme);
	}

	public void feed(GenLink genLink, LinkMapping lme) {
		genLink.setNotationViewFactoryClassName(getViewFactory().get(lme));
		genLink.setEditPartClassName(getEditPart().get(lme));
		genLink.setItemSemanticEditPolicyClassName(getItemSemanticPolicy().get(lme));
		feedElementType(genLink, lme);
	}

	public void feed(GenCompartment genCompartment, CompartmentMapping mapping) {
		genCompartment.setNotationViewFactoryClassName(getViewFactory().get(mapping));
		genCompartment.setEditPartClassName(getEditPart().get(mapping));
		genCompartment.setItemSemanticEditPolicyClassName(getItemSemanticPolicy().get(mapping));
		genCompartment.setCanonicalEditPolicyClassName(getCanonicalPolicy().get(mapping));
	}

	public void feed(GenNodeLabel label, LabelMapping labelMapping) {
		label.setNotationViewFactoryClassName(getViewFactory().get(labelMapping));
		label.setEditPartClassName(getEditPart().get(labelMapping));
		label.setItemSemanticEditPolicyClassName(getItemSemanticPolicy().get(labelMapping));
		feedElementType(label, labelMapping);
	}

	public void feed(GenLinkLabel label, LabelMapping labelMapping) {
		label.setNotationViewFactoryClassName(getViewFactory().get(labelMapping));
		label.setEditPartClassName(getEditPart().get(labelMapping));
		label.setItemSemanticEditPolicyClassName(getItemSemanticPolicy().get(labelMapping));
		feedElementType(label, labelMapping);
	}

	public void reset() {
		if (myDispenser != null) {
			myDispenser.clear();
		}
	}

	protected void feedElementType(GenCommonBase element, EObject mapping) {
		if (element.getElementType() instanceof MetamodelType) {
			MetamodelType type = (MetamodelType) element.getElementType();
			type.setEditHelperClassName(getName(getEditHelper(), mapping));
		} else if (element.getElementType() instanceof SpecializationType) {
			SpecializationType type = (SpecializationType) element.getElementType();
			type.setEditHelperAdviceClassName(getName(getEditHelperAdvice(), mapping));
		}
	}

	protected static String getName(NamingStrategy strategy, EObject mapping) {
		if (mapping instanceof CanvasMapping) {
			return strategy.get((CanvasMapping) mapping);
		} else if (mapping instanceof NodeMapping) {
			return strategy.get((NodeMapping) mapping);
		} else if (mapping instanceof LinkMapping) {
			return strategy.get((LinkMapping) mapping);
		} else if (mapping instanceof CompartmentMapping) {
			return strategy.get((CompartmentMapping) mapping);
		} else if (mapping instanceof LabelMapping) {
			return strategy.get((LabelMapping) mapping);
		}
		throw new IllegalArgumentException();
	}
}
