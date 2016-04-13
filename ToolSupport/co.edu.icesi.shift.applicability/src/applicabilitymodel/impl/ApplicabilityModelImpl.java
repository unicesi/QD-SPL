/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.Applicability;
import applicabilitymodel.ApplicabilityModel;
import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.InputModel;

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
 * An implementation of the model object '<em><b>Applicability Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.impl.ApplicabilityModelImpl#getQualitymodel <em>Qualitymodel</em>}</li>
 *   <li>{@link applicabilitymodel.impl.ApplicabilityModelImpl#getComponentSetStore <em>Component Set Store</em>}</li>
 *   <li>{@link applicabilitymodel.impl.ApplicabilityModelImpl#getApplicabilities <em>Applicabilities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicabilityModelImpl extends MinimalEObjectImpl.Container implements ApplicabilityModel {
	/**
	 * The cached value of the '{@link #getQualitymodel() <em>Qualitymodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualitymodel()
	 * @generated
	 * @ordered
	 */
	protected InputModel qualitymodel;

	/**
	 * The cached value of the '{@link #getComponentSetStore() <em>Component Set Store</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentSetStore()
	 * @generated
	 * @ordered
	 */
	protected InputModel componentSetStore;

	/**
	 * The cached value of the '{@link #getApplicabilities() <em>Applicabilities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicabilities()
	 * @generated
	 * @ordered
	 */
	protected EList<Applicability> applicabilities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicabilityModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicabilitymodelPackage.Literals.APPLICABILITY_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputModel getQualitymodel() {
		return qualitymodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQualitymodel(InputModel newQualitymodel, NotificationChain msgs) {
		InputModel oldQualitymodel = qualitymodel;
		qualitymodel = newQualitymodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL, oldQualitymodel, newQualitymodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualitymodel(InputModel newQualitymodel) {
		if (newQualitymodel != qualitymodel) {
			NotificationChain msgs = null;
			if (qualitymodel != null)
				msgs = ((InternalEObject)qualitymodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL, null, msgs);
			if (newQualitymodel != null)
				msgs = ((InternalEObject)newQualitymodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL, null, msgs);
			msgs = basicSetQualitymodel(newQualitymodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL, newQualitymodel, newQualitymodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputModel getComponentSetStore() {
		return componentSetStore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComponentSetStore(InputModel newComponentSetStore, NotificationChain msgs) {
		InputModel oldComponentSetStore = componentSetStore;
		componentSetStore = newComponentSetStore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE, oldComponentSetStore, newComponentSetStore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentSetStore(InputModel newComponentSetStore) {
		if (newComponentSetStore != componentSetStore) {
			NotificationChain msgs = null;
			if (componentSetStore != null)
				msgs = ((InternalEObject)componentSetStore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE, null, msgs);
			if (newComponentSetStore != null)
				msgs = ((InternalEObject)newComponentSetStore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE, null, msgs);
			msgs = basicSetComponentSetStore(newComponentSetStore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE, newComponentSetStore, newComponentSetStore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Applicability> getApplicabilities() {
		if (applicabilities == null) {
			applicabilities = new EObjectContainmentEList<Applicability>(Applicability.class, this, ApplicabilitymodelPackage.APPLICABILITY_MODEL__APPLICABILITIES);
		}
		return applicabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL:
				return basicSetQualitymodel(null, msgs);
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE:
				return basicSetComponentSetStore(null, msgs);
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__APPLICABILITIES:
				return ((InternalEList<?>)getApplicabilities()).basicRemove(otherEnd, msgs);
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
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL:
				return getQualitymodel();
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE:
				return getComponentSetStore();
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__APPLICABILITIES:
				return getApplicabilities();
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
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL:
				setQualitymodel((InputModel)newValue);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE:
				setComponentSetStore((InputModel)newValue);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__APPLICABILITIES:
				getApplicabilities().clear();
				getApplicabilities().addAll((Collection<? extends Applicability>)newValue);
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
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL:
				setQualitymodel((InputModel)null);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE:
				setComponentSetStore((InputModel)null);
				return;
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__APPLICABILITIES:
				getApplicabilities().clear();
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
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__QUALITYMODEL:
				return qualitymodel != null;
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__COMPONENT_SET_STORE:
				return componentSetStore != null;
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL__APPLICABILITIES:
				return applicabilities != null && !applicabilities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ApplicabilityModelImpl
