/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.Decision;
import applicabilitymodel.DecisionModel;

import componentsetsmodel.ComponentSetsModel;

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

import qasvariabilitymodel.RootQA;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decision Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.impl.DecisionModelImpl#getQualitymodel <em>Qualitymodel</em>}</li>
 *   <li>{@link applicabilitymodel.impl.DecisionModelImpl#getComponentSetsModel <em>Component Sets Model</em>}</li>
 *   <li>{@link applicabilitymodel.impl.DecisionModelImpl#getDecisions <em>Decisions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecisionModelImpl extends MinimalEObjectImpl.Container implements DecisionModel {
	/**
	 * The cached value of the '{@link #getQualitymodel() <em>Qualitymodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualitymodel()
	 * @generated
	 * @ordered
	 */
	protected RootQA qualitymodel;

	/**
	 * The cached value of the '{@link #getComponentSetsModel() <em>Component Sets Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentSetsModel()
	 * @generated
	 * @ordered
	 */
	protected ComponentSetsModel componentSetsModel;

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
	public RootQA getQualitymodel() {
		return qualitymodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQualitymodel(RootQA newQualitymodel, NotificationChain msgs) {
		RootQA oldQualitymodel = qualitymodel;
		qualitymodel = newQualitymodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL, oldQualitymodel, newQualitymodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualitymodel(RootQA newQualitymodel) {
		if (newQualitymodel != qualitymodel) {
			NotificationChain msgs = null;
			if (qualitymodel != null)
				msgs = ((InternalEObject)qualitymodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL, null, msgs);
			if (newQualitymodel != null)
				msgs = ((InternalEObject)newQualitymodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL, null, msgs);
			msgs = basicSetQualitymodel(newQualitymodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL, newQualitymodel, newQualitymodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSetsModel getComponentSetsModel() {
		return componentSetsModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentSetsModel(ComponentSetsModel newComponentSetsModel, NotificationChain msgs) {
		ComponentSetsModel oldComponentSetsModel = componentSetsModel;
		componentSetsModel = newComponentSetsModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL, oldComponentSetsModel, newComponentSetsModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentSetsModel(ComponentSetsModel newComponentSetsModel) {
		if (newComponentSetsModel != componentSetsModel) {
			NotificationChain msgs = null;
			if (componentSetsModel != null)
				msgs = ((InternalEObject)componentSetsModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL, null, msgs);
			if (newComponentSetsModel != null)
				msgs = ((InternalEObject)newComponentSetsModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL, null, msgs);
			msgs = basicSetComponentSetsModel(newComponentSetsModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL, newComponentSetsModel, newComponentSetsModel));
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
			case ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL:
				return basicSetQualitymodel(null, msgs);
			case ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL:
				return basicSetComponentSetsModel(null, msgs);
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
			case ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL:
				return getQualitymodel();
			case ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL:
				return getComponentSetsModel();
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
			case ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL:
				setQualitymodel((RootQA)newValue);
				return;
			case ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL:
				setComponentSetsModel((ComponentSetsModel)newValue);
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
			case ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL:
				setQualitymodel((RootQA)null);
				return;
			case ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL:
				setComponentSetsModel((ComponentSetsModel)null);
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
			case ApplicabilitymodelPackage.DECISION_MODEL__QUALITYMODEL:
				return qualitymodel != null;
			case ApplicabilitymodelPackage.DECISION_MODEL__COMPONENT_SETS_MODEL:
				return componentSetsModel != null;
			case ApplicabilitymodelPackage.DECISION_MODEL__DECISIONS:
				return decisions != null && !decisions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DecisionModelImpl
