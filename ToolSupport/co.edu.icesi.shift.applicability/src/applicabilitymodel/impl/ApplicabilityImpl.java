/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.Applicability;
import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.ComponentSet;
import applicabilitymodel.QualityScenario;

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
 * An implementation of the model object '<em><b>Applicability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.impl.ApplicabilityImpl#getValue <em>Value</em>}</li>
 *   <li>{@link applicabilitymodel.impl.ApplicabilityImpl#getQualityScenario <em>Quality Scenario</em>}</li>
 *   <li>{@link applicabilitymodel.impl.ApplicabilityImpl#getComponentSets <em>Component Sets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicabilityImpl extends MinimalEObjectImpl.Container implements Applicability {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQualityScenario() <em>Quality Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityScenario()
	 * @generated
	 * @ordered
	 */
	protected QualityScenario qualityScenario;

	/**
	 * The cached value of the '{@link #getComponentSets() <em>Component Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentSet> componentSets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicabilitymodelPackage.Literals.APPLICABILITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.APPLICABILITY__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityScenario getQualityScenario() {
		return qualityScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQualityScenario(QualityScenario newQualityScenario, NotificationChain msgs) {
		QualityScenario oldQualityScenario = qualityScenario;
		qualityScenario = newQualityScenario;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO, oldQualityScenario, newQualityScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityScenario(QualityScenario newQualityScenario) {
		if (newQualityScenario != qualityScenario) {
			NotificationChain msgs = null;
			if (qualityScenario != null)
				msgs = ((InternalEObject)qualityScenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO, null, msgs);
			if (newQualityScenario != null)
				msgs = ((InternalEObject)newQualityScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO, null, msgs);
			msgs = basicSetQualityScenario(newQualityScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO, newQualityScenario, newQualityScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentSet> getComponentSets() {
		if (componentSets == null) {
			componentSets = new EObjectContainmentEList<ComponentSet>(ComponentSet.class, this, ApplicabilitymodelPackage.APPLICABILITY__COMPONENT_SETS);
		}
		return componentSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO:
				return basicSetQualityScenario(null, msgs);
			case ApplicabilitymodelPackage.APPLICABILITY__COMPONENT_SETS:
				return ((InternalEList<?>)getComponentSets()).basicRemove(otherEnd, msgs);
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
			case ApplicabilitymodelPackage.APPLICABILITY__VALUE:
				return getValue();
			case ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO:
				return getQualityScenario();
			case ApplicabilitymodelPackage.APPLICABILITY__COMPONENT_SETS:
				return getComponentSets();
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
			case ApplicabilitymodelPackage.APPLICABILITY__VALUE:
				setValue((Integer)newValue);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO:
				setQualityScenario((QualityScenario)newValue);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY__COMPONENT_SETS:
				getComponentSets().clear();
				getComponentSets().addAll((Collection<? extends ComponentSet>)newValue);
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
			case ApplicabilitymodelPackage.APPLICABILITY__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO:
				setQualityScenario((QualityScenario)null);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY__COMPONENT_SETS:
				getComponentSets().clear();
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
			case ApplicabilitymodelPackage.APPLICABILITY__VALUE:
				return value != VALUE_EDEFAULT;
			case ApplicabilitymodelPackage.APPLICABILITY__QUALITY_SCENARIO:
				return qualityScenario != null;
			case ApplicabilitymodelPackage.APPLICABILITY__COMPONENT_SETS:
				return componentSets != null && !componentSets.isEmpty();
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ApplicabilityImpl
