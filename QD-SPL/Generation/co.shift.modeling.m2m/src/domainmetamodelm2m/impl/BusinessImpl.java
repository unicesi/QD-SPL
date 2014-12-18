/**
 */
package domainmetamodelm2m.impl;

import domainmetamodelm2m.Attribute;
import domainmetamodelm2m.Business;
import domainmetamodelm2m.BusinessEntity;
import domainmetamodelm2m.Domainmetamodelm2mPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Class;

import co.shift.qualiyatributes.QAParser;
import co.shift.utilities.DomainCodeUtilities;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Business</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link domainmetamodelm2m.impl.BusinessImpl#getEntities <em>Entities
 * </em>}</li>
 * <li>{@link domainmetamodelm2m.impl.BusinessImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BusinessImpl extends MinimalEObjectImpl.Container implements
		Business {
	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<BusinessEntity> entities;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BusinessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Domainmetamodelm2mPackage.Literals.BUSINESS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<BusinessEntity> getEntities() {
		if (entities == null) {
			entities = new EObjectContainmentEList<BusinessEntity>(
					BusinessEntity.class, this,
					Domainmetamodelm2mPackage.BUSINESS__ENTITIES);
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Domainmetamodelm2mPackage.BUSINESS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isQASelected(String key) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		QAParser parser = new QAParser();
		HashMap<String, Boolean> map = parser.parseSelectedFeatures();
		return map.get(key) != null ? map.get(key) : false;
		// return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void createCryptManager(EModelElement pack) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package packC = (Package) pack;
		Class c = packC.createOwnedClass("PBECryptographyManager", false);
		c.createOwnedAttribute("pbeKeySpec", createType(packC, "PBEKeySpec"));
		c.createOwnedAttribute("pbeParamSpec",
				createType(packC, "PBEParameterSpec"));
		c.createOwnedAttribute("keyFac", createType(packC, "SecretKeyFactory"));
		c.createOwnedAttribute("pbeKey", createType(packC, "SecretKey"));
		c.createOwnedAttribute("pbeCipher", createType(packC, "Cipher"));
		Property enc = c.createOwnedAttribute("ENCRYPT",
				createType(packC, "int"));
		enc.setIsStatic(true);
		enc.setIsReadOnly(true);
		enc.setDefault("Cipher.ENCRYPT_MODE");
		Property dec = c.createOwnedAttribute("DECRYPT",
				createType(packC, "int"));
		dec.setIsStatic(true);
		dec.setIsReadOnly(true);
		dec.setDefault("Cipher.DECRYPT_MODE");
		c.createOwnedAttribute("salt", createType(packC, "byte[]"));
		Property count = c.createOwnedAttribute("COUNT",
				createType(packC, "int"));
		count.setIsStatic(true);
		count.setIsReadOnly(true);
		count.setDefault("20");

		c.createOwnedOperation("PBECryptographyManager", null, null);

		EList<String> ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("mode");
		ownedParameterNames.add("text");
		EList<Type> ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "int"));
		ownedParameterTypes.add(createType(packC, "string"));
		c.createOwnedOperation("doFinal", ownedParameterNames,
				ownedParameterTypes, createType(packC, "char[]"));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void createAuthorizationBoundary(EModelElement pack) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package packC = (Package) pack;
		Class man = packC.createOwnedClass("AuthorizationManager", false);

		man.createOwnedAttribute("em", createType(packC, "EntityManager"));

		BusinessEntity auth = getAuthEntity();

		if (isQASelected("_r_2_10_12_13")) {
			Package boundary = packC.getNestingPackage().getNestedPackage(
					"co.shift." + name.toLowerCase() + "."
							+ auth.getName().toLowerCase() + ".boundary");

			man.createAssociation(true, AggregationKind.NONE_LITERAL,
					"cManager", 1, 1,
					createType(boundary, "PBECryptographyManager"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}

		Attribute authId = DomainCodeUtilities.getID(auth);

		EList<String> ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(auth.getName().toLowerCase()
				+ DomainCodeUtilities.toFisrtUpper(authId.getName()));
		EList<Type> ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(authId)));
		man.createOwnedOperation(
				"get" + DomainCodeUtilities.toFisrtUpper(auth.getName())
						+ "Roles", ownedParameterNames, ownedParameterTypes,
				createType(packC, "List<RoleTO>"));

		man.createOwnedOperation("getAllRoles", null, null,
				createType(packC, "List<RoleTO>"));

		man.createOwnedOperation("getAllServices", null, null,
				createType(packC, "List<ServiceTO>"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("roleName");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "string"));
		man.createOwnedOperation("getRoleServices", ownedParameterNames,
				ownedParameterTypes, createType(packC, "List<ServiceTO>"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("role");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "RoleTO"));
		man.createOwnedOperation("createRole", ownedParameterNames,
				ownedParameterTypes, createType(packC, "boolean"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("role");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "RoleTO"));
		man.createOwnedOperation("updateRole", ownedParameterNames,
				ownedParameterTypes, createType(packC, "boolean"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("role");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "RoleTO"));
		man.createOwnedOperation("deleteRole", ownedParameterNames,
				ownedParameterTypes, createType(packC, "boolean"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("user");
		ownedParameterNames.add("role");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(authId)));
		ownedParameterTypes.add(createType(packC, "RoleTO"));
		man.createOwnedOperation(
				"addRoleTo" + DomainCodeUtilities.toFisrtUpper(auth.getName()),
				ownedParameterNames, ownedParameterTypes,
				createType(packC, "boolean"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("user");
		ownedParameterNames.add("role");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(authId)));
		ownedParameterTypes.add(createType(packC, "RoleTO"));
		man.createOwnedOperation(
				"removeRoleFrom"
						+ DomainCodeUtilities.toFisrtUpper(auth.getName()),
				ownedParameterNames, ownedParameterTypes,
				createType(packC, "boolean"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("roleName");
		ownedParameterNames.add("service");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "string"));
		ownedParameterTypes.add(createType(packC, "ServiceTO"));
		man.createOwnedOperation("addServiceToRole", ownedParameterNames,
				ownedParameterTypes, createType(packC, "boolean"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("role");
		ownedParameterNames.add("service");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "RoleTO"));
		ownedParameterTypes.add(createType(packC, "ServiceTO"));
		man.createOwnedOperation("removeServiceFromRole", ownedParameterNames,
				ownedParameterTypes, createType(packC, "boolean"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(auth.getName().toLowerCase()
				+ DomainCodeUtilities.toFisrtUpper(authId.getName()));
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(authId)));
		man.createOwnedOperation("getUserServices", ownedParameterNames,
				ownedParameterTypes, createType(packC, "List<ServiceTO>"));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	private BusinessEntity getAuthEntity() {
		for (BusinessEntity be : entities) {
			if (be.isAuthenticable())
				return be;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void createAuthorizationEntities(EModelElement pack) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package packC = (Package) pack;
		BusinessEntity auth = getAuthEntity();
		Attribute authId = DomainCodeUtilities.getID(auth);

		Class role = packC.createOwnedClass("Role", false);

		role.createOwnedAttribute("name", createType(packC, "string"));
		role.createOwnedAttribute("description", createType(packC, "string"));

		role.createOwnedOperation("getName", null, null,
				createType(packC, "string"));

		EList<String> ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("name");
		EList<Type> ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "string"));
		role.createOwnedOperation("setName", ownedParameterNames,
				ownedParameterTypes);

		role.createOwnedOperation("getDescription", null, null,
				createType(packC, "string"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("description");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "string"));
		role.createOwnedOperation("setDescription", ownedParameterNames,
				ownedParameterTypes);

		role.createOwnedOperation("toTO", null, null,
				createType(packC, "RoleTO"));

		Class service = packC.createOwnedClass("Service", false);

		service.createOwnedAttribute("name", createType(packC, "string"));
		service.createOwnedAttribute("description", createType(packC, "string"));

		service.createOwnedOperation("getName", null, null,
				createType(packC, "string"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("name");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "string"));
		service.createOwnedOperation("setName", ownedParameterNames,
				ownedParameterTypes);

		service.createOwnedOperation("getDescription", null, null,
				createType(packC, "string"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("description");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "string"));
		service.createOwnedOperation("setDescription", ownedParameterNames,
				ownedParameterTypes);

		service.createOwnedOperation("toTO", null, null,
				createType(packC, "ServiceTO"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("obj");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "Object"));
		service.createOwnedOperation("equals", ownedParameterNames,
				ownedParameterTypes, createType(packC, "boolean"));

		Class userRolePK = packC.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(auth.getName()) + "RolePK",
				false);

		userRolePK.createOwnedAttribute(auth.getName().toLowerCase(),
				createType(packC, DomainCodeUtilities.getType(authId)));
		userRolePK.createOwnedAttribute("role", createType(packC, "string"));

		userRolePK.createOwnedOperation(
				"get" + DomainCodeUtilities.toFisrtUpper(auth.getName()), null,
				null, createType(packC, DomainCodeUtilities.getType(authId)));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(auth.getName().toLowerCase());
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(authId)));
		userRolePK.createOwnedOperation(
				"set" + DomainCodeUtilities.toFisrtUpper(auth.getName()),
				ownedParameterNames, ownedParameterTypes);

		userRolePK.createOwnedOperation("getRole", null, null,
				createType(packC, "string"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("role");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "string"));
		userRolePK.createOwnedOperation("setRole", ownedParameterNames,
				ownedParameterTypes);

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("obj");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "Object"));
		userRolePK.createOwnedOperation("equals", ownedParameterNames,
				ownedParameterTypes, createType(packC, "boolean"));

		userRolePK.createOwnedOperation("hashCode", null, null,
				createType(packC, "int"));

		Class userRole = packC.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(auth.getName()) + "Role",
				false);

		userRole.createAssociation(
				true,
				AggregationKind.NONE_LITERAL,
				"id",
				1,
				1,
				createType(packC,
						DomainCodeUtilities.toFisrtUpper(auth.getName())
								+ "RolePK"), true,
				AggregationKind.NONE_LITERAL, "", 1, 1);

		userRole.createAssociation(true, AggregationKind.NONE_LITERAL,
				"roleBean", 1, 1, createType(packC, "Role"), true,
				AggregationKind.NONE_LITERAL, "", 1, 1);

		userRole.createOwnedOperation(
				"getId",
				null,
				null,
				createType(packC,
						DomainCodeUtilities.toFisrtUpper(auth.getName())
								+ "RolePK"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("id");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.toFisrtUpper(auth.getName()) + "RolePK"));
		userRole.createOwnedOperation("setId", ownedParameterNames,
				ownedParameterTypes);

		userRole.createOwnedOperation("getRoleBean", null, null,
				createType(packC, "Role"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("roleBean");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "Role"));
		userRole.createOwnedOperation("setRoleBean", ownedParameterNames,
				ownedParameterTypes);

		// ---
		role.createAssociation(true, AggregationKind.NONE_LITERAL, "services",
				0, 10, createType(packC, "Service"), true,
				AggregationKind.NONE_LITERAL, "roles", 0, 10);

		role.createAssociation(
				true,
				AggregationKind.NONE_LITERAL,
				auth.getName().toLowerCase() + "Roles",
				0,
				10,
				createType(packC,
						DomainCodeUtilities.toFisrtUpper(auth.getName())
								+ "Role"), true, AggregationKind.NONE_LITERAL,
				"", 1, 1);

		Package entity = packC.getNestingPackage().getNestedPackage(
				"co.shift." + name.toLowerCase() + "."
						+ auth.getName().toLowerCase() + ".entity");

		Class att = entity.createOwnedClass("Attempt", false);
		att.createOwnedAttribute(auth.getName().toLowerCase(),
				createType(packC, DomainCodeUtilities.getType(authId)));
		att.createOwnedAttribute("attempts", createType(packC, "int"));

		att.createOwnedOperation(
				"get" + DomainCodeUtilities.toFisrtUpper(auth.getName()), null,
				null, createType(packC, DomainCodeUtilities.getType(authId)));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(auth.getName().toLowerCase());
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(authId)));
		att.createOwnedOperation(
				"set" + DomainCodeUtilities.toFisrtUpper(auth.getName()),
				ownedParameterNames, ownedParameterTypes);

		att.createOwnedOperation("getAttempts", null, null,
				createType(packC, "int"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("attempts");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC, "int"));
		att.createOwnedOperation("setAttempts", ownedParameterNames,
				ownedParameterTypes);
	}

	/**
	 * 
	 * @generated NOT
	 */
	private void createAuthorizationTOs(Package pack) {

	}

	/**
	 * 
	 * @generated NOT
	 */
	private Type findType(Package pack, String name) {
		for (Type t : pack.getOwnedTypes()) {
			if (t.getName() != null && t.getName().equals(name))
				return t;
		}
		return null;
	}

	/**
	 * 
	 * @generated NOT
	 */
	private Type createType(Package pack, String name) {
		Type t = findType(pack, name);
		if (t != null)
			return t;
		else {
			t = pack.createOwnedPrimitiveType(name);
			return t;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Domainmetamodelm2mPackage.BUSINESS__ENTITIES:
			return ((InternalEList<?>) getEntities()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Domainmetamodelm2mPackage.BUSINESS__ENTITIES:
			return getEntities();
		case Domainmetamodelm2mPackage.BUSINESS__NAME:
			return getName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Domainmetamodelm2mPackage.BUSINESS__ENTITIES:
			getEntities().clear();
			getEntities().addAll(
					(Collection<? extends BusinessEntity>) newValue);
			return;
		case Domainmetamodelm2mPackage.BUSINESS__NAME:
			setName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Domainmetamodelm2mPackage.BUSINESS__ENTITIES:
			getEntities().clear();
			return;
		case Domainmetamodelm2mPackage.BUSINESS__NAME:
			setName(NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Domainmetamodelm2mPackage.BUSINESS__ENTITIES:
			return entities != null && !entities.isEmpty();
		case Domainmetamodelm2mPackage.BUSINESS__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
		case Domainmetamodelm2mPackage.BUSINESS___IS_QA_SELECTED__STRING:
			return isQASelected((String) arguments.get(0));
		case Domainmetamodelm2mPackage.BUSINESS___CREATE_CRYPT_MANAGER__EMODELELEMENT:
			createCryptManager((EModelElement) arguments.get(0));
			return null;
		case Domainmetamodelm2mPackage.BUSINESS___CREATE_AUTHORIZATION_BOUNDARY__EMODELELEMENT:
			createAuthorizationBoundary((EModelElement) arguments.get(0));
			return null;
		case Domainmetamodelm2mPackage.BUSINESS___CREATE_AUTHORIZATION_ENTITIES__EMODELELEMENT:
			createAuthorizationEntities((EModelElement) arguments.get(0));
			return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // BusinessImpl
