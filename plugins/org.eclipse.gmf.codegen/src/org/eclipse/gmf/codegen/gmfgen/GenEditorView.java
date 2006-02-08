/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Editor View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getEditorGen <em>Editor Gen</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getActionBarContributorClassName <em>Action Bar Contributor Class Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenEditorView()
 * @model
 * @generated
 */
public interface GenEditorView extends EObject {
	/**
	 * Returns the value of the '<em><b>Editor Gen</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator#getEditor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Gen</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Gen</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenEditorView_EditorGen()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator#getEditor
	 * @model opposite="editor" changeable="false"
	 * @generated
	 */
	GenEditorGenerator getEditorGen();

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenEditorView_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Action Bar Contributor Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Bar Contributor Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Bar Contributor Class Name</em>' attribute.
	 * @see #setActionBarContributorClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenEditorView_ActionBarContributorClassName()
	 * @model
	 * @generated
	 */
	String getActionBarContributorClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getActionBarContributorClassName <em>Action Bar Contributor Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Bar Contributor Class Name</em>' attribute.
	 * @see #getActionBarContributorClassName()
	 * @generated
	 */
	void setActionBarContributorClassName(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenEditorView_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenEditorView_ID()
	 * @model
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenEditorView#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getActionBarContributorQualifiedClassName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQualifiedClassName();

} // GenEditorView
