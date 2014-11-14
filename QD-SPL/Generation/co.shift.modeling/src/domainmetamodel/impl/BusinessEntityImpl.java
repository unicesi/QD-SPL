/**
 */
package domainmetamodel.impl;


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

import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;
import domainmetamodel.DomainmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link domainmetamodel.impl.BusinessEntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link domainmetamodel.impl.BusinessEntityImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link domainmetamodel.impl.BusinessEntityImpl#getContracts <em>Contracts</em>}</li>
 *   <li>{@link domainmetamodel.impl.BusinessEntityImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link domainmetamodel.impl.BusinessEntityImpl#isIsAuthenticable <em>Is Authenticable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessEntityImpl extends MinimalEObjectImpl.Container implements BusinessEntity {
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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getContracts() <em>Contracts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContracts()
	 * @generated
	 * @ordered
	 */
	protected EList<Contracts> contracts;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> associations;

	/**
	 * The default value of the '{@link #isIsAuthenticable() <em>Is Authenticable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAuthenticable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_AUTHENTICABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAuthenticable() <em>Is Authenticable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAuthenticable()
	 * @generated
	 * @ordered
	 */
	protected boolean isAuthenticable = IS_AUTHENTICABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomainmetamodelPackage.Literals.BUSINESS_ENTITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmetamodelPackage.BUSINESS_ENTITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, DomainmetamodelPackage.BUSINESS_ENTITY__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Contracts> getContracts() {
		if (contracts == null) {
			contracts = new EObjectContainmentEList<Contracts>(Contracts.class, this, DomainmetamodelPackage.BUSINESS_ENTITY__CONTRACTS);
		}
		return contracts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Association> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList<Association>(Association.class, this, DomainmetamodelPackage.BUSINESS_ENTITY__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAuthenticable() {
		return isAuthenticable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAuthenticable(boolean newIsAuthenticable) {
		boolean oldIsAuthenticable = isAuthenticable;
		isAuthenticable = newIsAuthenticable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomainmetamodelPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE, oldIsAuthenticable, isAuthenticable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DomainmetamodelPackage.BUSINESS_ENTITY__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case DomainmetamodelPackage.BUSINESS_ENTITY__CONTRACTS:
				return ((InternalEList<?>)getContracts()).basicRemove(otherEnd, msgs);
			case DomainmetamodelPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
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
			case DomainmetamodelPackage.BUSINESS_ENTITY__NAME:
				return getName();
			case DomainmetamodelPackage.BUSINESS_ENTITY__ATTRIBUTES:
				return getAttributes();
			case DomainmetamodelPackage.BUSINESS_ENTITY__CONTRACTS:
				return getContracts();
			case DomainmetamodelPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				return getAssociations();
			case DomainmetamodelPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				return isIsAuthenticable();
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
			case DomainmetamodelPackage.BUSINESS_ENTITY__NAME:
				setName((String)newValue);
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__CONTRACTS:
				getContracts().clear();
				getContracts().addAll((Collection<? extends Contracts>)newValue);
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				setIsAuthenticable((Boolean)newValue);
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
			case DomainmetamodelPackage.BUSINESS_ENTITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__ATTRIBUTES:
				getAttributes().clear();
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__CONTRACTS:
				getContracts().clear();
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				setIsAuthenticable(IS_AUTHENTICABLE_EDEFAULT);
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
			case DomainmetamodelPackage.BUSINESS_ENTITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DomainmetamodelPackage.BUSINESS_ENTITY__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case DomainmetamodelPackage.BUSINESS_ENTITY__CONTRACTS:
				return contracts != null && !contracts.isEmpty();
			case DomainmetamodelPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case DomainmetamodelPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				return isAuthenticable != IS_AUTHENTICABLE_EDEFAULT;
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
		result.append(", isAuthenticable: ");
		result.append(isAuthenticable);
		result.append(')');
		return result.toString();
	}

} //BusinessEntityImpl
