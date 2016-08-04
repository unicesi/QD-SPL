/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.Decision;

import componentsetsmodel.ComponentSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import qasvariabilitymodel.QA;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.impl.DecisionImpl#getQaVariant <em>Qa Variant</em>}</li>
 *   <li>{@link applicabilitymodel.impl.DecisionImpl#getComponentSet <em>Component Set</em>}</li>
 *   <li>{@link applicabilitymodel.impl.DecisionImpl#getRequiresVariantSelected <em>Requires Variant Selected</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecisionImpl extends MinimalEObjectImpl.Container implements Decision {
	/**
	 * The cached value of the '{@link #getQaVariant() <em>Qa Variant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQaVariant()
	 * @generated
	 * @ordered
	 */
	protected QA qaVariant;

	/**
	 * The cached value of the '{@link #getComponentSet() <em>Component Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentSet()
	 * @generated
	 * @ordered
	 */
	protected ComponentSet componentSet;

	/**
	 * The default value of the '{@link #getRequiresVariantSelected() <em>Requires Variant Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiresVariantSelected()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIRES_VARIANT_SELECTED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRequiresVariantSelected() <em>Requires Variant Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiresVariantSelected()
	 * @generated
	 * @ordered
	 */
	protected int requiresVariantSelected = REQUIRES_VARIANT_SELECTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicabilitymodelPackage.Literals.DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QA getQaVariant() {
		return qaVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQaVariant(QA newQaVariant, NotificationChain msgs) {
		QA oldQaVariant = qaVariant;
		qaVariant = newQaVariant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION__QA_VARIANT, oldQaVariant, newQaVariant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQaVariant(QA newQaVariant) {
		if (newQaVariant != qaVariant) {
			NotificationChain msgs = null;
			if (qaVariant != null)
				msgs = ((InternalEObject)qaVariant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION__QA_VARIANT, null, msgs);
			if (newQaVariant != null)
				msgs = ((InternalEObject)newQaVariant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION__QA_VARIANT, null, msgs);
			msgs = basicSetQaVariant(newQaVariant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION__QA_VARIANT, newQaVariant, newQaVariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSet getComponentSet() {
		return componentSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentSet(ComponentSet newComponentSet, NotificationChain msgs) {
		ComponentSet oldComponentSet = componentSet;
		componentSet = newComponentSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION__COMPONENT_SET, oldComponentSet, newComponentSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentSet(ComponentSet newComponentSet) {
		if (newComponentSet != componentSet) {
			NotificationChain msgs = null;
			if (componentSet != null)
				msgs = ((InternalEObject)componentSet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION__COMPONENT_SET, null, msgs);
			if (newComponentSet != null)
				msgs = ((InternalEObject)newComponentSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION__COMPONENT_SET, null, msgs);
			msgs = basicSetComponentSet(newComponentSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION__COMPONENT_SET, newComponentSet, newComponentSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRequiresVariantSelected() {
		return requiresVariantSelected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiresVariantSelected(int newRequiresVariantSelected) {
		int oldRequiresVariantSelected = requiresVariantSelected;
		requiresVariantSelected = newRequiresVariantSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION__REQUIRES_VARIANT_SELECTED, oldRequiresVariantSelected, requiresVariantSelected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION__QA_VARIANT:
				return basicSetQaVariant(null, msgs);
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				return basicSetComponentSet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION__QA_VARIANT:
				return getQaVariant();
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				return getComponentSet();
			case ApplicabilitymodelPackage.DECISION__REQUIRES_VARIANT_SELECTED:
				return getRequiresVariantSelected();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION__QA_VARIANT:
				setQaVariant((QA)newValue);
				return;
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				setComponentSet((ComponentSet)newValue);
				return;
			case ApplicabilitymodelPackage.DECISION__REQUIRES_VARIANT_SELECTED:
				setRequiresVariantSelected((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION__QA_VARIANT:
				setQaVariant((QA)null);
				return;
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				setComponentSet((ComponentSet)null);
				return;
			case ApplicabilitymodelPackage.DECISION__REQUIRES_VARIANT_SELECTED:
				setRequiresVariantSelected(REQUIRES_VARIANT_SELECTED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION__QA_VARIANT:
				return qaVariant != null;
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				return componentSet != null;
			case ApplicabilitymodelPackage.DECISION__REQUIRES_VARIANT_SELECTED:
				return requiresVariantSelected != REQUIRES_VARIANT_SELECTED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (requiresVariantSelected: ");
		result.append(requiresVariantSelected);
		result.append(')');
		return result.toString();
	}

} //DecisionImpl
