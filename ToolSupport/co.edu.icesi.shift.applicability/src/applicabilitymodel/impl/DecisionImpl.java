/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.Decision;
import applicabilitymodel.RequiredVariant;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.impl.DecisionImpl#getName <em>Name</em>}</li>
 *   <li>{@link applicabilitymodel.impl.DecisionImpl#getComponentSet <em>Component Set</em>}</li>
 *   <li>{@link applicabilitymodel.impl.DecisionImpl#getRequiredVariants <em>Required Variants</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecisionImpl extends MinimalEObjectImpl.Container implements Decision {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getComponentSet() <em>Component Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentSet()
	 * @generated
	 * @ordered
	 */
	protected static final String COMPONENT_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentSet() <em>Component Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentSet()
	 * @generated
	 * @ordered
	 */
	protected String componentSet = COMPONENT_SET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequiredVariants() <em>Required Variants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredVariants()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredVariant> requiredVariants;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComponentSet() {
		return componentSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentSet(String newComponentSet) {
		String oldComponentSet = componentSet;
		componentSet = newComponentSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION__COMPONENT_SET, oldComponentSet, componentSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredVariant> getRequiredVariants() {
		if (requiredVariants == null) {
			requiredVariants = new EObjectContainmentEList<RequiredVariant>(RequiredVariant.class, this, ApplicabilitymodelPackage.DECISION__REQUIRED_VARIANTS);
		}
		return requiredVariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION__REQUIRED_VARIANTS:
				return ((InternalEList<?>)getRequiredVariants()).basicRemove(otherEnd, msgs);
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
			case ApplicabilitymodelPackage.DECISION__NAME:
				return getName();
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				return getComponentSet();
			case ApplicabilitymodelPackage.DECISION__REQUIRED_VARIANTS:
				return getRequiredVariants();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION__NAME:
				setName((String)newValue);
				return;
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				setComponentSet((String)newValue);
				return;
			case ApplicabilitymodelPackage.DECISION__REQUIRED_VARIANTS:
				getRequiredVariants().clear();
				getRequiredVariants().addAll((Collection<? extends RequiredVariant>)newValue);
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
			case ApplicabilitymodelPackage.DECISION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				setComponentSet(COMPONENT_SET_EDEFAULT);
				return;
			case ApplicabilitymodelPackage.DECISION__REQUIRED_VARIANTS:
				getRequiredVariants().clear();
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
			case ApplicabilitymodelPackage.DECISION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ApplicabilitymodelPackage.DECISION__COMPONENT_SET:
				return COMPONENT_SET_EDEFAULT == null ? componentSet != null : !COMPONENT_SET_EDEFAULT.equals(componentSet);
			case ApplicabilitymodelPackage.DECISION__REQUIRED_VARIANTS:
				return requiredVariants != null && !requiredVariants.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", componentSet: ");
		result.append(componentSet);
		result.append(')');
		return result.toString();
	}

} //DecisionImpl
