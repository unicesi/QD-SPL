/**
 */
package domainmetamodelm2m.impl;

import domainmetamodelm2m.AddElement;
import domainmetamodelm2m.Association;
import domainmetamodelm2m.Attribute;
import domainmetamodelm2m.Business;
import domainmetamodelm2m.BusinessEntity;
import domainmetamodelm2m.ContractElements;
import domainmetamodelm2m.Contracts;
import domainmetamodelm2m.Create;
import domainmetamodelm2m.Delete;
import domainmetamodelm2m.DeleteElement;
import domainmetamodelm2m.Domainmetamodelm2mPackage;
import domainmetamodelm2m.ListAll;
import domainmetamodelm2m.Simple;
import domainmetamodelm2m.Update;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

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
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

import co.shift.utilities.DomainCodeUtilities;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Business Entity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link domainmetamodelm2m.impl.BusinessEntityImpl#getName <em>Name</em>}</li>
 *   <li>{@link domainmetamodelm2m.impl.BusinessEntityImpl#isIsAuthenticable <em>Is Authenticable</em>}</li>
 *   <li>{@link domainmetamodelm2m.impl.BusinessEntityImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link domainmetamodelm2m.impl.BusinessEntityImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link domainmetamodelm2m.impl.BusinessEntityImpl#getContracts <em>Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessEntityImpl extends MinimalEObjectImpl.Container implements
		BusinessEntity {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAuthenticable() <em>Is Authenticable</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isIsAuthenticable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_AUTHENTICABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAuthenticable() <em>Is Authenticable</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isIsAuthenticable()
	 * @generated
	 * @ordered
	 */
	protected boolean isAuthenticable = IS_AUTHENTICABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> associations;

	/**
	 * The cached value of the '{@link #getContracts() <em>Contracts</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContracts()
	 * @generated
	 * @ordered
	 */
	protected EList<Contracts> contracts;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Domainmetamodelm2mPackage.Literals.BUSINESS_ENTITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Domainmetamodelm2mPackage.BUSINESS_ENTITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAuthenticable() {
		return isAuthenticable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAuthenticable(boolean newIsAuthenticable) {
		boolean oldIsAuthenticable = isAuthenticable;
		isAuthenticable = newIsAuthenticable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Domainmetamodelm2mPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE, oldIsAuthenticable, isAuthenticable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, Domainmetamodelm2mPackage.BUSINESS_ENTITY__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList<Association>(Association.class, this, Domainmetamodelm2mPackage.BUSINESS_ENTITY__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contracts> getContracts() {
		if (contracts == null) {
			contracts = new EObjectContainmentEList<Contracts>(Contracts.class, this, Domainmetamodelm2mPackage.BUSINESS_ENTITY__CONTRACTS);
		}
		return contracts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean needsDAO(Business b) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		if ((DomainCodeUtilities.getDetailMultipleAssociations(this, b) != null && !DomainCodeUtilities
				.hasZeroAssociations(this))
				|| DomainCodeUtilities.getDetailSimpleAssociations(this, b)
						.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void createDAO(Business b, EModelElement dao) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		org.eclipse.uml2.uml.Class daoC = (org.eclipse.uml2.uml.Class) dao;

		// Types
		PrimitiveType rType = daoC.getPackage().createOwnedPrimitiveType(
				DomainCodeUtilities.toFisrtUpper(name) + "TO");
		PrimitiveType rLType = daoC.getPackage().createOwnedPrimitiveType(
				"List<" + DomainCodeUtilities.toFisrtUpper(name) + "TO>");

		// Attributes
		daoC.getPackage().createOwnedClass("EntityManager", false);
		daoC.createOwnedAttribute("em",
				findType(daoC.getPackage(), "EntityManager"));

		if (b.isQASelected("_r_2_10_12_13")) {
			Package root = daoC.getPackage().getNestingPackage();
			Package security = root.getNestedPackage("co.shift." + b.getName()
					+ ".security");

			daoC.createAssociation(true, AggregationKind.NONE_LITERAL,
					"cManager", 1, 1,
					createType(security, "PBECryptographyManager"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}

		// Methods
		for (Association association : DomainCodeUtilities
				.getDetailSimpleAssociations(this, b)) {
			BusinessEntity container = (BusinessEntity) association
					.eContainer();
			String type = DomainCodeUtilities.getID(container).getDataType()
					.getLiteral();
			EList<String> ownedParameterNames = new BasicEList<String>();
			ownedParameterNames.add(container.getName().toLowerCase());
			EList<Type> ownedParameterTypes = new BasicEList<Type>();
			Type pType = createType(daoC.getPackage(), type);

			ownedParameterTypes.add(pType);
			daoC.createOwnedOperation(
					"get"
							+ DomainCodeUtilities.toFisrtUpper(container
									.getName())
							+ DomainCodeUtilities.toFisrtUpper(association
									.getName()), ownedParameterNames,
					ownedParameterTypes, rType);
		}

		for (Association association : DomainCodeUtilities
				.getDetailMultipleAssociations(this, b)) {
			BusinessEntity container = (BusinessEntity) association
					.eContainer();
			String type = DomainCodeUtilities.getID(container).getDataType()
					.getLiteral();
			EList<String> ownedParameterNames = new BasicEList<String>();
			ownedParameterNames.add(container.getName().toLowerCase());
			EList<Type> ownedParameterTypes = new BasicEList<Type>();
			Type pType = createType(daoC.getPackage(), type);

			ownedParameterTypes.add(pType);
			daoC.createOwnedOperation(
					"get"
							+ DomainCodeUtilities.toFisrtUpper(name)
							+ "From"
							+ DomainCodeUtilities.toFisrtUpper(container
									.getName()), ownedParameterNames,
					ownedParameterTypes, rLType);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void createEntity(Business b, EModelElement entity) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		org.eclipse.uml2.uml.Class entityC = (org.eclipse.uml2.uml.Class) entity;
		for (Attribute a : attributes) {
			String type = a.getDataType().getLiteral();
			// get
			entityC.createOwnedOperation(
					"get" + DomainCodeUtilities.toFisrtUpper(a.getName()),
					null, null, createType(entityC.getPackage(), type));

			// set
			EList<String> ownedParameterNames = new BasicEList<String>();
			ownedParameterNames.add(a.getName().toLowerCase());
			EList<Type> ownedParameterTypes = new BasicEList<Type>();
			Type pType = createType(entityC.getPackage(), type);

			ownedParameterTypes.add(pType);
			entityC.createOwnedOperation(
					"set" + DomainCodeUtilities.toFisrtUpper(a.getName()),
					ownedParameterNames, ownedParameterTypes, null);
		}
		// associations
		for (Association a : associations) {
			if (a instanceof Simple) {
				BusinessEntity relBe = ((Simple) a).getRelatedEntity();
				String type = DomainCodeUtilities.getType(DomainCodeUtilities
						.getID(relBe));
				Type pType = createType(entityC.getPackage(), type);
				entityC.createOwnedAttribute(a.getName().toLowerCase(), pType);

				// get
				entityC.createOwnedOperation(
						"get" + DomainCodeUtilities.toFisrtUpper(a.getName()),
						null, null, createType(entityC.getPackage(), type));

				// set
				EList<String> ownedParameterNames = new BasicEList<String>();
				ownedParameterNames.add(a.getName().toLowerCase());
				EList<Type> ownedParameterTypes = new BasicEList<Type>();

				ownedParameterTypes.add(pType);
				entityC.createOwnedOperation(
						"set" + DomainCodeUtilities.toFisrtUpper(a.getName()),
						ownedParameterNames, ownedParameterTypes, null);
			}
		}

		for (Association a : DomainCodeUtilities.getDetailMultipleAssociations(
				this, b)) {
			if (DomainCodeUtilities.hasZeroAssociations(this)) {
				BusinessEntity relBe = (BusinessEntity) a.eContainer();
				String type = DomainCodeUtilities.getType(DomainCodeUtilities
						.getID(relBe));
				Type pType = createType(entityC.getPackage(), type);
				entityC.createOwnedAttribute(relBe.getName().toLowerCase(),
						pType);

				// get
				entityC.createOwnedOperation(
						"get"
								+ DomainCodeUtilities.toFisrtUpper(relBe
										.getName()), null, null,
						createType(entityC.getPackage(), type));

				// set
				EList<String> ownedParameterNames = new BasicEList<String>();
				ownedParameterNames.add(relBe.getName().toLowerCase());
				EList<Type> ownedParameterTypes = new BasicEList<Type>();

				ownedParameterTypes.add(pType);
				entityC.createOwnedOperation(
						"set"
								+ DomainCodeUtilities.toFisrtUpper(relBe
										.getName()), ownedParameterNames,
						ownedParameterTypes, null);
			}
		}

		for (Contracts c : contracts) {
			if (c instanceof DeleteElement) {
				BusinessEntity container = ((DeleteElement) c).getAssociation()
						.getEntity();
				if (!DomainCodeUtilities.hasZeroAssociations(container)) {
					// create PK
					createJPAPK(entityC.getPackage(), container);
					createJPA(entityC.getPackage(), container);
				}
			}
		}

		// equals
		EList<String> ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("obj");
		EList<Type> ownedParameterTypes = new BasicEList<Type>();

		ownedParameterTypes.add(createType(entityC.getPackage(), "Object"));
		entityC.createOwnedOperation("equals", ownedParameterNames,
				ownedParameterTypes,
				createType(entityC.getPackage(), "boolean"));

		// toTO
		entityC.createOwnedOperation(
				"toTO",
				null,
				null,
				createType(entityC.getPackage(),
						DomainCodeUtilities.toFisrtUpper(name) + "TO"));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void createBoundary(Business b, EModelElement boundary) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		org.eclipse.uml2.uml.Class boundaryC = (org.eclipse.uml2.uml.Class) boundary;

		if (isAuthenticable && b.isQASelected("_r_2_11_15_17")) {
			// association with LockoutManager
		}
		if (b.isQASelected("_r_2_10_12_13")) {
			Package root = boundaryC.getPackage().getNestingPackage();
			Package security = root.getNestedPackage("co.shift." + b.getName()
					+ ".security");

			boundaryC.createAssociation(true, AggregationKind.NONE_LITERAL,
					"cManager", 1, 1,
					createType(security, "PBECryptographyManager"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}
		if (needsDAO(b)) {
			Package root = boundaryC.getPackage().getNestingPackage();
			Package control = root.getNestedPackage("co.shift." + b.getName()
					+ "." + name.toLowerCase() + ".control");

			boundaryC.createAssociation(
					true,
					AggregationKind.NONE_LITERAL,
					name.toLowerCase() + "DAO",
					1,
					1,
					createType(control, DomainCodeUtilities.toFisrtUpper(name)
							+ "DAO"), true, AggregationKind.NONE_LITERAL, "",
					1, 1);
		}
		for (Contracts contract : contracts) {
			if (contract instanceof Create || contract instanceof Update
					|| contract instanceof Delete) {
				EList<String> ownedParameterNames = new BasicEList<String>();
				ownedParameterNames.add(name.toLowerCase());
				EList<Type> ownedParameterTypes = new BasicEList<Type>();
				ownedParameterTypes.add(createType(boundaryC.getPackage(),
						DomainCodeUtilities.toFisrtUpper(name) + "TO"));

				boundaryC.createOwnedOperation(contract.getName(),
						ownedParameterNames, ownedParameterTypes,
						createType(boundaryC.getPackage(), "boolean"));
			}
			if (contract instanceof ListAll) {
				// validar cual variante de TE se eligio para el contrato y
				// generar las clases involucradas
				if (b.isQASelected("_r_1_3_4") || b.isQASelected("_r_1_3_5")
						|| b.isQASelected("_r_1_3_6_7_9")) { // NormalTE,
																// MediumTE,
																// AsynTE
					boundaryC
							.createOwnedOperation(
									contract.getName(),
									null,
									null,
									createType(
											boundaryC.getPackage(),
											"List<"
													+ DomainCodeUtilities
															.toFisrtUpper(this
																	.getName())
													+ "TO>"));

				}
				if (b.isQASelected("_r_1_3_6_7_8")) { // SyncTE
					EList<String> ownedParameterNames = new BasicEList<String>();
					ownedParameterNames.add("start");
					ownedParameterNames.add("maxResults");
					EList<Type> ownedParameterTypes = new BasicEList<Type>();
					ownedParameterTypes.add(createType(boundaryC.getPackage(),
							"int"));
					ownedParameterTypes.add(createType(boundaryC.getPackage(),
							"int"));

					boundaryC
							.createOwnedOperation(
									contract.getName(),
									ownedParameterNames,
									ownedParameterTypes,
									createType(
											boundaryC.getPackage(),
											"List<"
													+ DomainCodeUtilities
															.toFisrtUpper(this
																	.getName())
													+ "TO>"));
				}
			}
			if (contract instanceof AddElement
					|| contract instanceof DeleteElement) {
				BusinessEntity relatedEntity = ((ContractElements) contract)
						.getAssociation().getEntity();
				if (!DomainCodeUtilities.hasZeroAssociations(relatedEntity)) {
					String type = DomainCodeUtilities.getID(this).getDataType()
							.getLiteral();
					EList<String> ownedParameterNames = new BasicEList<String>();
					ownedParameterNames.add(relatedEntity.getName()
							.toLowerCase());
					ownedParameterNames.add(name.toLowerCase()
							+ DomainCodeUtilities
									.toFisrtUpper(DomainCodeUtilities.getID(
											this).getName()));
					EList<Type> ownedParameterTypes = new BasicEList<Type>();
					ownedParameterTypes.add(createType(
							boundaryC.getPackage(),
							DomainCodeUtilities.toFisrtUpper(relatedEntity
									.getName()) + "TO"));
					ownedParameterTypes.add(createType(boundaryC.getPackage(),
							type));

					boundaryC.createOwnedOperation(contract.getName(),
							ownedParameterNames, ownedParameterTypes,
							createType(boundaryC.getPackage(), "boolean"));
				}
			}
		}
		for (Association association : associations) {
			if (association instanceof Simple) {
				BusinessEntity relatedEntity = ((Simple) association)
						.getRelatedEntity();
				String type = DomainCodeUtilities.getID(this).getDataType()
						.getLiteral();

				EList<String> ownedParameterNames = new BasicEList<String>();
				ownedParameterNames.add(association.getName().toLowerCase());
				ownedParameterNames.add(name.toLowerCase()
						+ DomainCodeUtilities.toFisrtUpper(DomainCodeUtilities
								.getID(this).getName()));
				EList<Type> ownedParameterTypes = new BasicEList<Type>();
				ownedParameterTypes.add(createType(
						boundaryC.getPackage(),
						DomainCodeUtilities.toFisrtUpper(relatedEntity
								.getName()) + "TO"));
				ownedParameterTypes
						.add(createType(boundaryC.getPackage(), type));

				boundaryC.createOwnedOperation(
						"set"
								+ DomainCodeUtilities.toFisrtUpper(name)
								+ DomainCodeUtilities.toFisrtUpper(association
										.getName()), ownedParameterNames,
						ownedParameterTypes,
						createType(boundaryC.getPackage(), "boolean"));
			}
		}
		for (Association association : DomainCodeUtilities
				.getDetailSimpleAssociations(this, b)) {
			BusinessEntity container = (BusinessEntity) association
					.eContainer();
			String type = DomainCodeUtilities.getID(container).getDataType()
					.getLiteral();

			EList<String> ownedParameterNames = new BasicEList<String>();
			ownedParameterNames.add(container.getName().toLowerCase()
					+ DomainCodeUtilities.toFisrtUpper(DomainCodeUtilities
							.getID(container).getName()));
			EList<Type> ownedParameterTypes = new BasicEList<Type>();
			ownedParameterTypes.add(createType(boundaryC.getPackage(), type));

			boundaryC.createOwnedOperation(
					"get"
							+ DomainCodeUtilities.toFisrtUpper(container
									.getName())
							+ DomainCodeUtilities.toFisrtUpper(association
									.getName()),
					ownedParameterNames,
					ownedParameterTypes,
					createType(boundaryC.getPackage(),
							DomainCodeUtilities.toFisrtUpper(name) + "TO"));
		}
		for (Association association : DomainCodeUtilities
				.getDetailMultipleAssociations(this, b)) {
			BusinessEntity container = (BusinessEntity) association
					.eContainer();
			String type = DomainCodeUtilities.getID(container).getDataType()
					.getLiteral();

			EList<String> ownedParameterNames = new BasicEList<String>();
			ownedParameterNames.add(container.getName().toLowerCase()
					+ DomainCodeUtilities.toFisrtUpper(DomainCodeUtilities
							.getID(container).getName()));
			EList<Type> ownedParameterTypes = new BasicEList<Type>();
			ownedParameterTypes.add(createType(boundaryC.getPackage(), type));

			boundaryC.createOwnedOperation(
					"get"
							+ DomainCodeUtilities.toFisrtUpper(name)
							+ "From"
							+ DomainCodeUtilities.toFisrtUpper(container
									.getName()),
					ownedParameterNames,
					ownedParameterTypes,
					createType(boundaryC.getPackage(), "List<"
							+ DomainCodeUtilities.toFisrtUpper(name) + "TO>"));
		}
		if (isAuthenticable) {
			String type = DomainCodeUtilities.getID(this).getDataType()
					.getLiteral();

			EList<String> ownedParameterNames = new BasicEList<String>();
			ownedParameterNames.add(name.toLowerCase()
					+ DomainCodeUtilities.toFisrtUpper(DomainCodeUtilities
							.getID(this).getName()));
			ownedParameterNames.add("password");
			EList<Type> ownedParameterTypes = new BasicEList<Type>();
			ownedParameterTypes.add(createType(boundaryC.getPackage(), type));
			ownedParameterTypes
					.add(createType(boundaryC.getPackage(), "string"));

			boundaryC.createOwnedOperation(
					"authenticate",
					ownedParameterNames,
					ownedParameterTypes,
					createType(boundaryC.getPackage(),
							DomainCodeUtilities.toFisrtUpper(name) + "TO"));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isAuthenticable() {
		return isAuthenticable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void configureMediumTE(EModelElement pack, Business b) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package packC = (Package) pack;
		Class flr = packC.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(name) + "BasicFLR", false);

		flr.createOwnedAttribute("ds", createType(packC, "DataSource"));

		if (b.isQASelected("_r_2_10_12_13")) {
			Package root = flr.getPackage().getNestingPackage();
			Package security = root.getNestedPackage("co.shift." + b.getName()
					+ ".security");

			flr.createAssociation(true, AggregationKind.NONE_LITERAL,
					"cManager", 1, 1,
					createType(security, "PBECryptographyManager"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}

		for (Contracts contract : contracts) {
			if (contract instanceof ListAll) {
				flr.createOwnedOperation(
						contract.getName(),
						null,
						null,
						createType(
								packC,
								"List<"
										+ DomainCodeUtilities
												.toFisrtUpper(name) + "TO>"));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void updateBoundaryAttributes(EModelElement pack, Business b) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package root = (Package) pack;
		Package boundaryP = root.getNestedPackage("co.shift." + b.getName()
				+ "." + name.toLowerCase() + ".boundary");
		Class boundary = (Class) boundaryP.getOwnedMember(DomainCodeUtilities
				.toFisrtUpper(name) + "Manager");

		if (b.isQASelected("_r_1_3_5")) { // MediumTE
			boundary.createAssociation(
					true,
					AggregationKind.NONE_LITERAL,
					name.toLowerCase() + "BasicFLR",
					1,
					1,
					createType(boundaryP,
							DomainCodeUtilities.toFisrtUpper(name) + "BasicFLR"),
					true, AggregationKind.NONE_LITERAL, "", 1, 1);
		}
		if (b.isQASelected("_r_1_3_6_7_8")) { // SyncTE
			boundary.createAssociation(
					true,
					AggregationKind.NONE_LITERAL,
					name.toLowerCase() + "OptimizedFLR",
					1,
					1,
					createType(boundaryP,
							DomainCodeUtilities.toFisrtUpper(name)
									+ "OptimizedFLR"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}
		if (b.isQASelected("_r_1_3_6_7_9")) { // AsyncTE
			boundary.createAssociation(
					true,
					AggregationKind.NONE_LITERAL,
					name.toLowerCase() + "Parallelizer",
					1,
					1,
					createType(boundaryP,
							DomainCodeUtilities.toFisrtUpper(name)
									+ "Parallelizer"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}
		if(b.isQASelected("_r_2_11_15_17") && isAuthenticable){
			boundary.createAssociation(
					true,
					AggregationKind.NONE_LITERAL,
					name.toLowerCase() + "LockOut",
					1,
					1,
					createType(boundaryP, DomainCodeUtilities.toFisrtUpper(name)
							+ "LockoutManager"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void configureSyncTE(EModelElement pack, Business b) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package packC = (Package) pack;
		Class flr = packC.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(name) + "OptimizedFLR", false);

		flr.createOwnedAttribute("ds", createType(packC, "DataSource"));

		if (b.isQASelected("_r_2_10_12_13")) {
			Package root = flr.getPackage().getNestingPackage();
			Package security = root.getNestedPackage("co.shift." + b.getName()
					+ ".security");

			flr.createAssociation(true, AggregationKind.NONE_LITERAL,
					"cManager", 1, 1,
					createType(security, "PBECryptographyManager"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}

		for (Contracts contract : contracts) {
			if (contract instanceof ListAll) {
				EList<String> ownedParameterNames = new BasicEList<String>();
				ownedParameterNames.add("start");
				ownedParameterNames.add("maxResults");
				EList<Type> ownedParameterTypes = new BasicEList<Type>();
				ownedParameterTypes.add(createType(packC, "int"));
				ownedParameterTypes.add(createType(packC, "int"));

				flr.createOwnedOperation(
						contract.getName(),
						ownedParameterNames,
						ownedParameterTypes,
						createType(
								packC,
								"List<"
										+ DomainCodeUtilities
												.toFisrtUpper(name) + "TO>"));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void configureAsyncTE(EModelElement pack, Business b) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package packC = (Package) pack;
		Class asyncW = packC.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(name) + "AsyncWorker", false);

		asyncW.createOwnedAttribute("ds", createType(packC, "DataSource"));

		if (b.isQASelected("_r_2_10_12_13")) {
			Package root = asyncW.getPackage().getNestingPackage();
			Package security = root.getNestedPackage("co.shift." + b.getName()
					+ ".security");

			asyncW.createAssociation(true, AggregationKind.NONE_LITERAL,
					"cManager", 1, 1,
					createType(security, "PBECryptographyManager"), true,
					AggregationKind.NONE_LITERAL, "", 1, 1);
		}

		for (Contracts contract : contracts) {
			if (contract instanceof ListAll) {
				EList<String> ownedParameterNames = new BasicEList<String>();
				ownedParameterNames.add("start");
				ownedParameterNames.add("maxResults");
				EList<Type> ownedParameterTypes = new BasicEList<Type>();
				ownedParameterTypes.add(createType(packC, "int"));
				ownedParameterTypes.add(createType(packC, "int"));

				asyncW.createOwnedOperation(
						contract.getName(),
						ownedParameterNames,
						ownedParameterTypes,
						createType(
								packC,
								"Future<List<"
										+ DomainCodeUtilities
												.toFisrtUpper(name) + "TO>>"));
			}
		}

		Class parallel = packC.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(name) + "Parallelizer", false);

		parallel.createAssociation(
				true,
				AggregationKind.NONE_LITERAL,
				"worker",
				1,
				1,
				createType(packC, DomainCodeUtilities.toFisrtUpper(name)
						+ "AsyncWorker"), true, AggregationKind.NONE_LITERAL,
				"", 1, 1);

		for (Contracts contract : contracts) {
			if (contract instanceof ListAll) {
				EList<String> ownedParameterNames = new BasicEList<String>();
				ownedParameterNames.add("pCount");
				EList<Type> ownedParameterTypes = new BasicEList<Type>();
				ownedParameterTypes.add(createType(packC, "long"));

				parallel.createOwnedOperation(
						contract.getName(),
						ownedParameterNames,
						ownedParameterTypes,
						createType(
								packC,
								"List<"
										+ DomainCodeUtilities
												.toFisrtUpper(name) + "TO>"));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void configureLockoutManager(EModelElement pack, Business b) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		Package packC = (Package) pack;
		Class flr = packC.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(name) + "LockoutManager",
				false);

		Property att = flr.createOwnedAttribute("MAX_ATTEMPTS",
				createType(packC, "int"));
		att.setIsStatic(true);
		att.setIsReadOnly(true);
		att.setDefault("5");

		flr.createOwnedAttribute("em", createType(packC, "EntityManager"));

		EList<String> ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(DomainCodeUtilities.getID(this).getName()
				.toLowerCase());
		ownedParameterNames.add("password");
		EList<Type> ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(DomainCodeUtilities.getID(this))));
		ownedParameterTypes.add(createType(packC, "string"));

		flr.createOwnedOperation(
				"authenticate",
				ownedParameterNames,
				ownedParameterTypes,
				createType(packC, DomainCodeUtilities.toFisrtUpper(name) + "TO"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(DomainCodeUtilities.getID(this).getName()
				.toLowerCase());
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(DomainCodeUtilities.getID(this))));

		flr.createOwnedOperation("getAttempts", ownedParameterNames,
				ownedParameterTypes, createType(packC, "int"));

		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(DomainCodeUtilities.getID(this).getName()
				.toLowerCase());
		ownedParameterNames.add("newAttempts");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(packC,
				DomainCodeUtilities.getType(DomainCodeUtilities.getID(this))));
		ownedParameterTypes.add(createType(packC, "int"));

		flr.createOwnedOperation("setAttempts", ownedParameterNames,
				ownedParameterTypes);
	}

	/**
	 * 
	 * @generated NOT
	 */
	private Class createJPA(Package pack, BusinessEntity relation) {
		Class jpa = pack.createOwnedClass(
				DomainCodeUtilities.toFisrtUpper(name)
						+ DomainCodeUtilities.toFisrtUpper(relation.getName()),
				false);

		// PK relation
		jpa.createAssociation(
				true,
				AggregationKind.NONE_LITERAL,
				"id",
				1,
				1,
				createType(pack, DomainCodeUtilities.toFisrtUpper(name)
						+ DomainCodeUtilities.toFisrtUpper(relation.getName())
						+ "PK"), true, AggregationKind.NONE_LITERAL, "", 1, 1);

		// ManyToOne relation
		jpa.createAssociation(true, AggregationKind.NONE_LITERAL,
				name.toLowerCase() + "Bean", 1, 1,
				createType(pack, DomainCodeUtilities.toFisrtUpper(name)), true,
				AggregationKind.NONE_LITERAL, "", 0, 10);

		// Constructor
		jpa.createOwnedOperation(DomainCodeUtilities.toFisrtUpper(name)
				+ DomainCodeUtilities.toFisrtUpper(relation.getName()), null,
				null, null);

		// getId
		jpa.createOwnedOperation(
				"getId",
				null,
				null,
				createType(pack, DomainCodeUtilities.toFisrtUpper(name)
						+ DomainCodeUtilities.toFisrtUpper(relation.getName())
						+ "PK"));

		// setId
		EList<String> ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("id");
		EList<Type> ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(
				pack,
				DomainCodeUtilities.toFisrtUpper(name)
						+ DomainCodeUtilities.toFisrtUpper(relation.getName())
						+ "PK"));
		jpa.createOwnedOperation("setId", ownedParameterNames,
				ownedParameterTypes, null);

		// getBean
		jpa.createOwnedOperation("get" + DomainCodeUtilities.toFisrtUpper(name)
				+ "Bean", null, null,
				createType(pack, DomainCodeUtilities.toFisrtUpper(name)));

		// setBean
		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(name.toLowerCase() + "Bean");
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(pack,
				DomainCodeUtilities.toFisrtUpper(name)));
		jpa.createOwnedOperation("set" + DomainCodeUtilities.toFisrtUpper(name)
				+ "Bean", ownedParameterNames, ownedParameterTypes, null);

		return jpa;
	}

	/**
	 * 
	 * @generated NOT
	 */
	private Class createJPAPK(Package pack, BusinessEntity relation) {
		Class pk = pack.createOwnedClass(DomainCodeUtilities.toFisrtUpper(name)
				+ DomainCodeUtilities.toFisrtUpper(relation.getName()) + "PK",
				false);

		Attribute beId = DomainCodeUtilities.getID(this);
		Attribute relId = DomainCodeUtilities.getID(relation);
		String typeA = DomainCodeUtilities.getType(beId);
		String typeB = DomainCodeUtilities.getType(relId);

		// attributes
		pk.createOwnedAttribute(
				name.toLowerCase()
						+ DomainCodeUtilities.toFisrtUpper(beId.getName()),
				createType(pack, typeA));

		pk.createOwnedAttribute(relation.getName().toLowerCase()
				+ DomainCodeUtilities.toFisrtUpper(relId.getName()),
				createType(pack, typeB));

		pk.createOwnedOperation(DomainCodeUtilities.toFisrtUpper(name)
				+ DomainCodeUtilities.toFisrtUpper(relation.getName()) + "PK",
				null, null, null);

		// getA
		pk.createOwnedOperation("get" + DomainCodeUtilities.toFisrtUpper(name)
				+ DomainCodeUtilities.toFisrtUpper(beId.getName()), null, null,
				createType(pack, typeA));

		// setA
		EList<String> ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(name.toLowerCase()
				+ DomainCodeUtilities.toFisrtUpper(beId.getName()));
		EList<Type> ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(pack, typeA));
		pk.createOwnedOperation("set" + DomainCodeUtilities.toFisrtUpper(name)
				+ DomainCodeUtilities.toFisrtUpper(beId.getName()),
				ownedParameterNames, ownedParameterTypes, null);

		// getB
		pk.createOwnedOperation(
				"get" + DomainCodeUtilities.toFisrtUpper(relation.getName())
						+ DomainCodeUtilities.toFisrtUpper(relId.getName()),
				null, null, createType(pack, typeB));

		// setB
		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add(relation.getName().toLowerCase()
				+ DomainCodeUtilities.toFisrtUpper(relId.getName()));
		ownedParameterTypes = new BasicEList<Type>();
		ownedParameterTypes.add(createType(pack, typeB));
		pk.createOwnedOperation(
				"set" + DomainCodeUtilities.toFisrtUpper(relation.getName())
						+ DomainCodeUtilities.toFisrtUpper(relId.getName()),
				ownedParameterNames, ownedParameterTypes, null);

		// equals
		ownedParameterNames = new BasicEList<String>();
		ownedParameterNames.add("obj");
		ownedParameterTypes = new BasicEList<Type>();

		ownedParameterTypes.add(createType(pack, "Object"));
		pk.createOwnedOperation("equals", ownedParameterNames,
				ownedParameterTypes, createType(pack, "boolean"));

		// hashCode
		ownedParameterNames = new BasicEList<String>();
		pk.createOwnedOperation("equals", null, null, createType(pack, "int"));

		return pk;
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
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__CONTRACTS:
				return ((InternalEList<?>)getContracts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__NAME:
				return getName();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				return isIsAuthenticable();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ATTRIBUTES:
				return getAttributes();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				return getAssociations();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__CONTRACTS:
				return getContracts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__NAME:
				setName((String)newValue);
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				setIsAuthenticable((Boolean)newValue);
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__CONTRACTS:
				getContracts().clear();
				getContracts().addAll((Collection<? extends Contracts>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				setIsAuthenticable(IS_AUTHENTICABLE_EDEFAULT);
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ATTRIBUTES:
				getAttributes().clear();
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__CONTRACTS:
				getContracts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				return isAuthenticable != IS_AUTHENTICABLE_EDEFAULT;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY__CONTRACTS:
				return contracts != null && !contracts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments)
			throws InvocationTargetException {
		switch (operationID) {
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___NEEDS_DAO__BUSINESS:
				return needsDAO((Business)arguments.get(0));
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___CREATE_DAO__BUSINESS_EMODELELEMENT:
				createDAO((Business)arguments.get(0), (EModelElement)arguments.get(1));
				return null;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___CREATE_ENTITY__BUSINESS_EMODELELEMENT:
				createEntity((Business)arguments.get(0), (EModelElement)arguments.get(1));
				return null;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___CREATE_BOUNDARY__BUSINESS_EMODELELEMENT:
				createBoundary((Business)arguments.get(0), (EModelElement)arguments.get(1));
				return null;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___IS_AUTHENTICABLE:
				return isAuthenticable();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___CONFIGURE_MEDIUM_TE__EMODELELEMENT_BUSINESS:
				configureMediumTE((EModelElement)arguments.get(0), (Business)arguments.get(1));
				return null;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___UPDATE_BOUNDARY_ATTRIBUTES__EMODELELEMENT_BUSINESS:
				updateBoundaryAttributes((EModelElement)arguments.get(0), (Business)arguments.get(1));
				return null;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___CONFIGURE_SYNC_TE__EMODELELEMENT_BUSINESS:
				configureSyncTE((EModelElement)arguments.get(0), (Business)arguments.get(1));
				return null;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___CONFIGURE_ASYNC_TE__EMODELELEMENT_BUSINESS:
				configureAsyncTE((EModelElement)arguments.get(0), (Business)arguments.get(1));
				return null;
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY___CONFIGURE_LOCKOUT_MANAGER__EMODELELEMENT_BUSINESS:
				configureLockoutManager((EModelElement)arguments.get(0), (Business)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

} // BusinessEntityImpl
