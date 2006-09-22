/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.codegen.gmfgen;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Generated Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGeneratedType()
 * @model
 * @generated
 */
public final class GeneratedType extends AbstractEnumerator {
	/**
	 * The '<em><b>Abstract Navigator Item</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Abstract Navigator Item</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_NAVIGATOR_ITEM_LITERAL
	 * @model name="abstractNavigatorItem"
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_NAVIGATOR_ITEM = 0;

	/**
	 * The '<em><b>Abstract Navigator Item</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_NAVIGATOR_ITEM
	 * @generated
	 * @ordered
	 */
	public static final GeneratedType ABSTRACT_NAVIGATOR_ITEM_LITERAL = new GeneratedType(ABSTRACT_NAVIGATOR_ITEM, "abstractNavigatorItem", "abstractNavigatorItem");

	/**
	 * An array of all the '<em><b>Generated Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GeneratedType[] VALUES_ARRAY =
		new GeneratedType[] {
			ABSTRACT_NAVIGATOR_ITEM_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Generated Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Generated Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratedType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratedType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generated Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratedType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GeneratedType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generated Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratedType get(int value) {
		switch (value) {
			case ABSTRACT_NAVIGATOR_ITEM: return ABSTRACT_NAVIGATOR_ITEM_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private GeneratedType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //GeneratedType
