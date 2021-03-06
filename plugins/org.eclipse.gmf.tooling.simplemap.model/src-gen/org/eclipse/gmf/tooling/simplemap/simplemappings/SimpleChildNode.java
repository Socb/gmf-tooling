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
package org.eclipse.gmf.tooling.simplemap.simplemappings;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Child Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParentNode <em>Parent Node</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParentMapping <em>Parent Mapping</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParentMetaElement <em>Parent Meta Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleChildNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SimpleChildNode extends EObject {

	/**
	 * Returns the value of the '<em><b>Parent Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Node</em>' container reference.
	 * @see #setParentNode(SimpleParentNode)
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleChildNode_ParentNode()
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode#getChildren
	 * @model opposite="children" unsettable="true" transient="false"
	 * @generated
	 */
	SimpleParentNode getParentNode();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParentNode <em>Parent Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Node</em>' container reference.
	 * @see #getParentNode()
	 * @generated
	 */
	void setParentNode(SimpleParentNode value);

	/**
	 * Returns the value of the '<em><b>Parent Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Mapping</em>' reference.
	 * @see #setParentMapping(SimpleMapping)
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleChildNode_ParentMapping()
	 * @model transient="true"
	 * @generated
	 */
	SimpleMapping getParentMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParentMapping <em>Parent Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Mapping</em>' reference.
	 * @see #getParentMapping()
	 * @generated
	 */
	void setParentMapping(SimpleMapping value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(SimpleNode)
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleChildNode_Parent()
	 * @model
	 * @generated
	 */
	SimpleNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(SimpleNode value);

	/**
	 * Returns the value of the '<em><b>Parent Meta Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Meta Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Meta Element</em>' reference.
	 * @see #setParentMetaElement(EClass)
	 * @see org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage#getSimpleChildNode_ParentMetaElement()
	 * @model transient="true"
	 * @generated
	 */
	EClass getParentMetaElement();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode#getParentMetaElement <em>Parent Meta Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Meta Element</em>' reference.
	 * @see #getParentMetaElement()
	 * @generated
	 */
	void setParentMetaElement(EClass value);

} // SimpleChildNode
