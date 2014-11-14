/**
 */
package domainmetamodel.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import domainmetamodel.Association;
import domainmetamodel.BusinessEntity;
import domainmetamodel.DomainmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link domainmetamodel.impl.AssociationImpl#getAssociatedEntity <em>Associated Entity</em>}</li>
 *   <li>{@link domainmetamodel.impl.AssociationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends MinimalEObjectImpl.Container implements Association {
	/**
	 * The cached value of the '{@link #getAssociatedEntity() <em>Associated Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedEntity()
	 * @generated
	 * @ordered
	 */
	protected BusinessEntity associatedEntity;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainmetamodelPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BusinessEntity getAssociatedEntity() {
		if (associatedEntity != null && associatedEntity.eIsProxy()) {
			InternalEObject oldAssociatedEntity = (InternalEObject)associatedEntity;
			associatedEntity = (BusinessEntity)eResolveProxy(oldAssociatedEntity);
			if (associatedEntity != oldAssociatedEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomainmetamodelPackage.ASSOCIATION__ASSOCIATED_ENTITY, oldAssociatedEntity, associatedEntity));
			}
		}
		return associatedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessEntity basicGetAssociatedEntity() {
		return associatedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssociatedEntity(BusinessEntity newAssociatedEntity) {
		BusinessEntity oldAssociatedEntity = associatedEntity;
		associatedEntity = newAssociatedEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmetamodelPackage.ASSOCIATION__ASSOCIATED_ENTITY, oldAssociatedEntity, associatedEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmetamodelPackage.ASSOCIATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomainmetamodelPackage.ASSOCIATION__ASSOCIATED_ENTITY:
				if (resolve) return getAssociatedEntity();
				return basicGetAssociatedEntity();
			case DomainmetamodelPackage.ASSOCIATION__NAME:
				return getName();
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
			case DomainmetamodelPackage.ASSOCIATION__ASSOCIATED_ENTITY:
				setAssociatedEntity((BusinessEntity)newValue);
				return;
			case DomainmetamodelPackage.ASSOCIATION__NAME:
				setName((String)newValue);
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
			case DomainmetamodelPackage.ASSOCIATION__ASSOCIATED_ENTITY:
				setAssociatedEntity((BusinessEntity)null);
				return;
			case DomainmetamodelPackage.ASSOCIATION__NAME:
				setName(NAME_EDEFAULT);
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
			case DomainmetamodelPackage.ASSOCIATION__ASSOCIATED_ENTITY:
				return associatedEntity != null;
			case DomainmetamodelPackage.ASSOCIATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(')');
		return result.toString();
	}

} //AssociationImpl
