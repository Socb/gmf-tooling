/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * org.eclipse.draw2d.Figure
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getMaximumSize <em>Maximum Size</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getMinimumSize <em>Minimum Size</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getPreferredSize <em>Preferred Size</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getFont <em>Font</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getInsets <em>Insets</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getBorder <em>Border</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.Figure#getReferencingElements <em>Referencing Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Figure extends FigureMarker, Identity {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.gmfgraph.FigureMarker}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.gmfgraph.FigureMarker#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_Children()
	 * @see org.eclipse.gmf.gmfgraph.FigureMarker#getParent
	 * @model type="org.eclipse.gmf.gmfgraph.FigureMarker" opposite="parent" containment="true"
	 * @generated
	 */
	EList getChildren();

	/**
	 * Returns the value of the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreground Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreground Color</em>' containment reference.
	 * @see #setForegroundColor(Color)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_ForegroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getForegroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getForegroundColor <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color</em>' containment reference.
	 * @see #getForegroundColor()
	 * @generated
	 */
	void setForegroundColor(Color value);

	/**
	 * Returns the value of the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color</em>' containment reference.
	 * @see #setBackgroundColor(Color)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_BackgroundColor()
	 * @model containment="true"
	 * @generated
	 */
	Color getBackgroundColor();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getBackgroundColor <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color</em>' containment reference.
	 * @see #getBackgroundColor()
	 * @generated
	 */
	void setBackgroundColor(Color value);

	/**
	 * Returns the value of the '<em><b>Maximum Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Size</em>' containment reference.
	 * @see #setMaximumSize(Dimension)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_MaximumSize()
	 * @model containment="true"
	 * @generated
	 */
	Dimension getMaximumSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getMaximumSize <em>Maximum Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Size</em>' containment reference.
	 * @see #getMaximumSize()
	 * @generated
	 */
	void setMaximumSize(Dimension value);

	/**
	 * Returns the value of the '<em><b>Minimum Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Size</em>' containment reference.
	 * @see #setMinimumSize(Dimension)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_MinimumSize()
	 * @model containment="true"
	 * @generated
	 */
	Dimension getMinimumSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getMinimumSize <em>Minimum Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Size</em>' containment reference.
	 * @see #getMinimumSize()
	 * @generated
	 */
	void setMinimumSize(Dimension value);

	/**
	 * Returns the value of the '<em><b>Preferred Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferred Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Size</em>' containment reference.
	 * @see #setPreferredSize(Dimension)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_PreferredSize()
	 * @model containment="true"
	 * @generated
	 */
	Dimension getPreferredSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getPreferredSize <em>Preferred Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Size</em>' containment reference.
	 * @see #getPreferredSize()
	 * @generated
	 */
	void setPreferredSize(Dimension value);

	/**
	 * Returns the value of the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font</em>' containment reference.
	 * @see #setFont(Font)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_Font()
	 * @model containment="true"
	 * @generated
	 */
	Font getFont();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getFont <em>Font</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font</em>' containment reference.
	 * @see #getFont()
	 * @generated
	 */
	void setFont(Font value);

	/**
	 * Returns the value of the '<em><b>Insets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insets</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insets</em>' containment reference.
	 * @see #setInsets(Insets)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_Insets()
	 * @model containment="true"
	 * @generated
	 */
	Insets getInsets();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getInsets <em>Insets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Insets</em>' containment reference.
	 * @see #getInsets()
	 * @generated
	 */
	void setInsets(Insets value);

	/**
	 * Returns the value of the '<em><b>Border</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Border</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Border</em>' containment reference.
	 * @see #setBorder(Border)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_Border()
	 * @model containment="true"
	 * @generated
	 */
	Border getBorder();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getBorder <em>Border</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Border</em>' containment reference.
	 * @see #getBorder()
	 * @generated
	 */
	void setBorder(Border value);

	/**
	 * Returns the value of the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' containment reference.
	 * @see #setLocation(Point)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_Location()
	 * @model containment="true"
	 * @generated
	 */
	Point getLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getLocation <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' containment reference.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(Point value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' containment reference.
	 * @see #setSize(Point)
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_Size()
	 * @model containment="true"
	 * @generated
	 */
	Point getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.gmfgraph.Figure#getSize <em>Size</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' containment reference.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(Point value);

	/**
	 * Returns the value of the '<em><b>Referencing Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.gmfgraph.DiagramElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.gmfgraph.DiagramElement#getFigure <em>Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencing Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencing Elements</em>' reference list.
	 * @see org.eclipse.gmf.gmfgraph.GMFGraphPackage#getFigure_ReferencingElements()
	 * @see org.eclipse.gmf.gmfgraph.DiagramElement#getFigure
	 * @model type="org.eclipse.gmf.gmfgraph.DiagramElement" opposite="figure"
	 * @generated
	 */
	EList getReferencingElements();

} // Figure
