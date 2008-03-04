/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenReferenceNewElementSpecImpl.java,v 1.5 2008/03/04 16:50:38 atikhomirov Exp $
 */
package org.eclipse.gmf.codegen.gmfgen.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenReferenceNewElementSpec;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Gen Reference New Element Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenReferenceNewElementSpecImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenReferenceNewElementSpecImpl#getFeatureSeqInitializer <em>Feature Seq Initializer</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.impl.GenReferenceNewElementSpecImpl#getNewElementInitializers <em>New Element Initializers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenReferenceNewElementSpecImpl extends EObjectImpl implements GenReferenceNewElementSpec {

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected GenFeature feature;

	/**
	 * The cached value of the '{@link #getNewElementInitializers() <em>New Element Initializers</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNewElementInitializers()
	 * @generated
	 * @ordered
	 */
	protected EList<GenFeatureSeqInitializer> newElementInitializers;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GenReferenceNewElementSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGenPackage.eINSTANCE.getGenReferenceNewElementSpec();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (GenFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(GenFeature newFeature) {
		GenFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GenFeatureSeqInitializer getFeatureSeqInitializer() {
		if (eContainerFeatureID != GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER) return null;
		return (GenFeatureSeqInitializer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatureSeqInitializer(GenFeatureSeqInitializer newFeatureSeqInitializer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFeatureSeqInitializer, GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureSeqInitializer(GenFeatureSeqInitializer newFeatureSeqInitializer) {
		if (newFeatureSeqInitializer != eInternalContainer() || (eContainerFeatureID != GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER && newFeatureSeqInitializer != null)) {
			if (EcoreUtil.isAncestor(this, newFeatureSeqInitializer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFeatureSeqInitializer != null)
				msgs = ((InternalEObject)newFeatureSeqInitializer).eInverseAdd(this, GMFGenPackage.GEN_FEATURE_SEQ_INITIALIZER__INITIALIZERS, GenFeatureSeqInitializer.class, msgs);
			msgs = basicSetFeatureSeqInitializer(newFeatureSeqInitializer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER, newFeatureSeqInitializer, newFeatureSeqInitializer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenFeatureSeqInitializer> getNewElementInitializers() {
		if (newElementInitializers == null) {
			newElementInitializers = new EObjectContainmentWithInverseEList<GenFeatureSeqInitializer>(GenFeatureSeqInitializer.class, this, GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS, GMFGenPackage.GEN_FEATURE_SEQ_INITIALIZER__CREATING_INITIALIZER);
		}
		return newElementInitializers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFeatureSeqInitializer((GenFeatureSeqInitializer)otherEnd, msgs);
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNewElementInitializers()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER:
				return basicSetFeatureSeqInitializer(null, msgs);
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return ((InternalEList<?>)getNewElementInitializers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER:
				return eInternalContainer().eInverseRemove(this, GMFGenPackage.GEN_FEATURE_SEQ_INITIALIZER__INITIALIZERS, GenFeatureSeqInitializer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER:
				return getFeatureSeqInitializer();
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return getNewElementInitializers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE:
				setFeature((GenFeature)newValue);
				return;
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER:
				setFeatureSeqInitializer((GenFeatureSeqInitializer)newValue);
				return;
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				getNewElementInitializers().clear();
				getNewElementInitializers().addAll((Collection<? extends GenFeatureSeqInitializer>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE:
				setFeature((GenFeature)null);
				return;
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER:
				setFeatureSeqInitializer((GenFeatureSeqInitializer)null);
				return;
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				getNewElementInitializers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE:
				return feature != null;
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__FEATURE_SEQ_INITIALIZER:
				return getFeatureSeqInitializer() != null;
			case GMFGenPackage.GEN_REFERENCE_NEW_ELEMENT_SPEC__NEW_ELEMENT_INITIALIZERS:
				return newElementInitializers != null && !newElementInitializers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // GenReferenceNewElementSpecImpl
