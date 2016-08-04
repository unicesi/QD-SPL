/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.Decision;
import applicabilitymodel.DecisionModel;

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
 * An implementation of the model object '<em><b>Decision Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.impl.DecisionModelImpl#getDecisionModelName <em>Decision Model Name</em>}</li>
 *   <li>{@link applicabilitymodel.impl.DecisionModelImpl#getDecisions <em>Decisions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecisionModelImpl extends MinimalEObjectImpl.Container implements DecisionModel {
	/**
	 * The default value of the '{@link #getDecisionModelName() <em>Decision Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisionModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String DECISION_MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDecisionModelName() <em>Decision Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisionModelName()
	 * @generated
	 * @ordered
	 */
	protected String decisionModelName = DECISION_MODEL_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDecisions() <em>Decisions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisions()
	 * @generated
	 * @ordered
	 */
	protected EList<Decision> decisions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecisionModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicabilitymodelPackage.Literals.DECISION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDecisionModelName() {
		return decisionModelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecisionModelName(String newDecisionModelName) {
		String oldDecisionModelName = decisionModelName;
		decisionModelName = newDecisionModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION_MODEL__DECISION_MODEL_NAME, oldDecisionModelName, decisionModelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Decision> getDecisions() {
		if (decisions == null) {
			decisions = new EObjectContainmentEList<Decision>(Decision.class, this, ApplicabilitymodelPackage.DECISION_MODEL__DECISIONS);
		}
		return decisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISIONS:
				return ((InternalEList<?>)getDecisions()).basicRemove(otherEnd, msgs);
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
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISION_MODEL_NAME:
				return getDecisionModelName();
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISIONS:
				return getDecisions();
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
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISION_MODEL_NAME:
				setDecisionModelName((String)newValue);
				return;
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISIONS:
				getDecisions().clear();
				getDecisions().addAll((Collection<? extends Decision>)newValue);
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
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISION_MODEL_NAME:
				setDecisionModelName(DECISION_MODEL_NAME_EDEFAULT);
				return;
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISIONS:
				getDecisions().clear();
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
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISION_MODEL_NAME:
				return DECISION_MODEL_NAME_EDEFAULT == null ? decisionModelName != null : !DECISION_MODEL_NAME_EDEFAULT.equals(decisionModelName);
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISIONS:
				return decisions != null && !decisions.isEmpty();
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
		result.append(" (decisionModelName: ");
		result.append(decisionModelName);
		result.append(')');
		return result.toString();
	}

} //DecisionModelImpl
