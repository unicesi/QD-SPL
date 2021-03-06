/**
 */
package domainmetamodelm2m.impl;

import domainmetamodelm2m.BusinessEntity;
import domainmetamodelm2m.Domainmetamodelm2mPackage;
import domainmetamodelm2m.Simple;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link domainmetamodelm2m.impl.SimpleImpl#getRelatedEntity <em>Related Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleImpl extends AssociationImpl implements Simple {
	/**
	 * The cached value of the '{@link #getRelatedEntity() <em>Related Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedEntity()
	 * @generated
	 * @ordered
	 */
	protected BusinessEntity relatedEntity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Domainmetamodelm2mPackage.Literals.SIMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessEntity getRelatedEntity() {
		if (relatedEntity != null && relatedEntity.eIsProxy()) {
			InternalEObject oldRelatedEntity = (InternalEObject)relatedEntity;
			relatedEntity = (BusinessEntity)eResolveProxy(oldRelatedEntity);
			if (relatedEntity != oldRelatedEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Domainmetamodelm2mPackage.SIMPLE__RELATED_ENTITY, oldRelatedEntity, relatedEntity));
			}
		}
		return relatedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessEntity basicGetRelatedEntity() {
		return relatedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedEntity(BusinessEntity newRelatedEntity) {
		BusinessEntity oldRelatedEntity = relatedEntity;
		relatedEntity = newRelatedEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Domainmetamodelm2mPackage.SIMPLE__RELATED_ENTITY, oldRelatedEntity, relatedEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Domainmetamodelm2mPackage.SIMPLE__RELATED_ENTITY:
				if (resolve) return getRelatedEntity();
				return basicGetRelatedEntity();
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
			case Domainmetamodelm2mPackage.SIMPLE__RELATED_ENTITY:
				setRelatedEntity((BusinessEntity)newValue);
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
			case Domainmetamodelm2mPackage.SIMPLE__RELATED_ENTITY:
				setRelatedEntity((BusinessEntity)null);
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
			case Domainmetamodelm2mPackage.SIMPLE__RELATED_ENTITY:
				return relatedEntity != null;
		}
		return super.eIsSet(featureID);
	}

} //SimpleImpl
