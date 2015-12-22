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
import domainmetamodelm2m.DataType;
import domainmetamodelm2m.Delete;
import domainmetamodelm2m.DeleteElement;
import domainmetamodelm2m.Domainmetamodelm2mFactory;
import domainmetamodelm2m.Domainmetamodelm2mPackage;

import domainmetamodelm2m.ListAll;
import domainmetamodelm2m.ListElements;
import domainmetamodelm2m.Multiple;
import domainmetamodelm2m.Retrieve;
import domainmetamodelm2m.Simple;
import domainmetamodelm2m.Update;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Domainmetamodelm2mPackageImpl extends EPackageImpl implements Domainmetamodelm2mPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessEntityEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multipleEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractsEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass retrieveEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listAllEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractElementsEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listElementsEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteElementEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Domainmetamodelm2mPackageImpl() {
		super(eNS_URI, Domainmetamodelm2mFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Domainmetamodelm2mPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Domainmetamodelm2mPackage init() {
		if (isInited) return (Domainmetamodelm2mPackage)EPackage.Registry.INSTANCE.getEPackage(Domainmetamodelm2mPackage.eNS_URI);

		// Obtain or create and register package
		Domainmetamodelm2mPackageImpl theDomainmetamodelm2mPackage = (Domainmetamodelm2mPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Domainmetamodelm2mPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Domainmetamodelm2mPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDomainmetamodelm2mPackage.createPackageContents();

		// Initialize created meta-data
		theDomainmetamodelm2mPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomainmetamodelm2mPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Domainmetamodelm2mPackage.eNS_URI, theDomainmetamodelm2mPackage);
		return theDomainmetamodelm2mPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusiness() {
		return businessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusiness_Entities() {
		return (EReference)businessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusiness_Name() {
		return (EAttribute)businessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusiness__IsQASelected__String() {
		return businessEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusiness__CreateCryptManager__EModelElement() {
		return businessEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusiness__CreateAuthorizationBoundary__EModelElement() {
		return businessEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusiness__CreateAuthorizationEntities__EModelElement() {
		return businessEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessEntity() {
		return businessEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessEntity_Name() {
		return (EAttribute)businessEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessEntity_IsAuthenticable() {
		return (EAttribute)businessEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessEntity_Attributes() {
		return (EReference)businessEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessEntity_Associations() {
		return (EReference)businessEntityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessEntity_Contracts() {
		return (EReference)businessEntityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__NeedsDAO__Business() {
		return businessEntityEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__CreateDAO__Business_EModelElement() {
		return businessEntityEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__CreateEntity__Business_EModelElement() {
		return businessEntityEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__CreateBoundary__Business_EModelElement() {
		return businessEntityEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__IsAuthenticable() {
		return businessEntityEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__ConfigureMediumTE__EModelElement_Business() {
		return businessEntityEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__UpdateBoundaryAttributes__EModelElement_Business() {
		return businessEntityEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__ConfigureSyncTE__EModelElement_Business() {
		return businessEntityEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__ConfigureAsyncTE__EModelElement_Business() {
		return businessEntityEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBusinessEntity__ConfigureLockoutManager__EModelElement_Business() {
		return businessEntityEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Name() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_DataType() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_IsRequired() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_IsDefault() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Name() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimple() {
		return simpleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimple_RelatedEntity() {
		return (EReference)simpleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiple() {
		return multipleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiple_Entity() {
		return (EReference)multipleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContracts() {
		return contractsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContracts_Name() {
		return (EAttribute)contractsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreate() {
		return createEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdate() {
		return updateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRetrieve() {
		return retrieveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelete() {
		return deleteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListAll() {
		return listAllEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContractElements() {
		return contractElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContractElements_Association() {
		return (EReference)contractElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListElements() {
		return listElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddElement() {
		return addElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteElement() {
		return deleteElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataType() {
		return dataTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domainmetamodelm2mFactory getDomainmetamodelm2mFactory() {
		return (Domainmetamodelm2mFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		businessEClass = createEClass(BUSINESS);
		createEReference(businessEClass, BUSINESS__ENTITIES);
		createEAttribute(businessEClass, BUSINESS__NAME);
		createEOperation(businessEClass, BUSINESS___IS_QA_SELECTED__STRING);
		createEOperation(businessEClass, BUSINESS___CREATE_CRYPT_MANAGER__EMODELELEMENT);
		createEOperation(businessEClass, BUSINESS___CREATE_AUTHORIZATION_BOUNDARY__EMODELELEMENT);
		createEOperation(businessEClass, BUSINESS___CREATE_AUTHORIZATION_ENTITIES__EMODELELEMENT);

		businessEntityEClass = createEClass(BUSINESS_ENTITY);
		createEAttribute(businessEntityEClass, BUSINESS_ENTITY__NAME);
		createEAttribute(businessEntityEClass, BUSINESS_ENTITY__IS_AUTHENTICABLE);
		createEReference(businessEntityEClass, BUSINESS_ENTITY__ATTRIBUTES);
		createEReference(businessEntityEClass, BUSINESS_ENTITY__ASSOCIATIONS);
		createEReference(businessEntityEClass, BUSINESS_ENTITY__CONTRACTS);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___NEEDS_DAO__BUSINESS);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___CREATE_DAO__BUSINESS_EMODELELEMENT);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___CREATE_ENTITY__BUSINESS_EMODELELEMENT);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___CREATE_BOUNDARY__BUSINESS_EMODELELEMENT);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___IS_AUTHENTICABLE);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___CONFIGURE_MEDIUM_TE__EMODELELEMENT_BUSINESS);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___UPDATE_BOUNDARY_ATTRIBUTES__EMODELELEMENT_BUSINESS);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___CONFIGURE_SYNC_TE__EMODELELEMENT_BUSINESS);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___CONFIGURE_ASYNC_TE__EMODELELEMENT_BUSINESS);
		createEOperation(businessEntityEClass, BUSINESS_ENTITY___CONFIGURE_LOCKOUT_MANAGER__EMODELELEMENT_BUSINESS);

		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__NAME);
		createEAttribute(attributeEClass, ATTRIBUTE__DATA_TYPE);
		createEAttribute(attributeEClass, ATTRIBUTE__IS_REQUIRED);
		createEAttribute(attributeEClass, ATTRIBUTE__IS_DEFAULT);

		associationEClass = createEClass(ASSOCIATION);
		createEAttribute(associationEClass, ASSOCIATION__NAME);

		simpleEClass = createEClass(SIMPLE);
		createEReference(simpleEClass, SIMPLE__RELATED_ENTITY);

		multipleEClass = createEClass(MULTIPLE);
		createEReference(multipleEClass, MULTIPLE__ENTITY);

		contractsEClass = createEClass(CONTRACTS);
		createEAttribute(contractsEClass, CONTRACTS__NAME);

		createEClass = createEClass(CREATE);

		updateEClass = createEClass(UPDATE);

		retrieveEClass = createEClass(RETRIEVE);

		deleteEClass = createEClass(DELETE);

		listAllEClass = createEClass(LIST_ALL);

		contractElementsEClass = createEClass(CONTRACT_ELEMENTS);
		createEReference(contractElementsEClass, CONTRACT_ELEMENTS__ASSOCIATION);

		listElementsEClass = createEClass(LIST_ELEMENTS);

		addElementEClass = createEClass(ADD_ELEMENT);

		deleteElementEClass = createEClass(DELETE_ELEMENT);

		// Create enums
		dataTypeEEnum = createEEnum(DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		simpleEClass.getESuperTypes().add(this.getAssociation());
		multipleEClass.getESuperTypes().add(this.getAssociation());
		createEClass.getESuperTypes().add(this.getContracts());
		updateEClass.getESuperTypes().add(this.getContracts());
		retrieveEClass.getESuperTypes().add(this.getContracts());
		deleteEClass.getESuperTypes().add(this.getContracts());
		listAllEClass.getESuperTypes().add(this.getContracts());
		contractElementsEClass.getESuperTypes().add(this.getContracts());
		listElementsEClass.getESuperTypes().add(this.getContractElements());
		addElementEClass.getESuperTypes().add(this.getContractElements());
		deleteElementEClass.getESuperTypes().add(this.getContractElements());

		// Initialize classes, features, and operations; add parameters
		initEClass(businessEClass, Business.class, "Business", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusiness_Entities(), this.getBusinessEntity(), null, "entities", null, 0, -1, Business.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusiness_Name(), ecorePackage.getEString(), "name", null, 1, 1, Business.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getBusiness__IsQASelected__String(), ecorePackage.getEBoolean(), "isQASelected", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "key", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusiness__CreateCryptManager__EModelElement(), null, "createCryptManager", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusiness__CreateAuthorizationBoundary__EModelElement(), null, "createAuthorizationBoundary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusiness__CreateAuthorizationEntities__EModelElement(), null, "createAuthorizationEntities", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(businessEntityEClass, BusinessEntity.class, "BusinessEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBusinessEntity_Name(), ecorePackage.getEString(), "name", null, 1, 1, BusinessEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessEntity_IsAuthenticable(), ecorePackage.getEBoolean(), "isAuthenticable", null, 1, 1, BusinessEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessEntity_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, BusinessEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessEntity_Associations(), this.getAssociation(), null, "associations", null, 0, -1, BusinessEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessEntity_Contracts(), this.getContracts(), null, "contracts", null, 0, -1, BusinessEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getBusinessEntity__NeedsDAO__Business(), ecorePackage.getEBoolean(), "needsDAO", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__CreateDAO__Business_EModelElement(), null, "createDAO", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "dao", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__CreateEntity__Business_EModelElement(), null, "createEntity", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "entity", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__CreateBoundary__Business_EModelElement(), null, "createBoundary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "boundary", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getBusinessEntity__IsAuthenticable(), ecorePackage.getEBoolean(), "isAuthenticable", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__ConfigureMediumTE__EModelElement_Business(), null, "configureMediumTE", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__UpdateBoundaryAttributes__EModelElement_Business(), null, "updateBoundaryAttributes", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__ConfigureSyncTE__EModelElement_Business(), null, "configureSyncTE", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__ConfigureAsyncTE__EModelElement_Business(), null, "configureAsyncTE", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBusinessEntity__ConfigureLockoutManager__EModelElement_Business(), null, "configureLockoutManager", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEModelElement(), "pack", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBusiness(), "b", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_DataType(), this.getDataType(), "dataType", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_IsRequired(), ecorePackage.getEBoolean(), "isRequired", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_IsDefault(), ecorePackage.getEBoolean(), "isDefault", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleEClass, Simple.class, "Simple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimple_RelatedEntity(), this.getBusinessEntity(), null, "relatedEntity", null, 1, 1, Simple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multipleEClass, Multiple.class, "Multiple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiple_Entity(), this.getBusinessEntity(), null, "entity", null, 1, 1, Multiple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contractsEClass, Contracts.class, "Contracts", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContracts_Name(), ecorePackage.getEString(), "name", null, 1, 1, Contracts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createEClass, Create.class, "Create", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateEClass, Update.class, "Update", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(retrieveEClass, Retrieve.class, "Retrieve", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteEClass, Delete.class, "Delete", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(listAllEClass, ListAll.class, "ListAll", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contractElementsEClass, ContractElements.class, "ContractElements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContractElements_Association(), this.getMultiple(), null, "association", null, 1, 1, ContractElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listElementsEClass, ListElements.class, "ListElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addElementEClass, AddElement.class, "AddElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteElementEClass, DeleteElement.class, "DeleteElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(dataTypeEEnum, DataType.class, "DataType");
		addEEnumLiteral(dataTypeEEnum, DataType.INT);
		addEEnumLiteral(dataTypeEEnum, DataType.STRING);
		addEEnumLiteral(dataTypeEEnum, DataType.BOOLEAN);
		addEEnumLiteral(dataTypeEEnum, DataType.DATE);
		addEEnumLiteral(dataTypeEEnum, DataType.OBJECT);
		addEEnumLiteral(dataTypeEEnum, DataType.COLLECTION);
		addEEnumLiteral(dataTypeEEnum, DataType.VOID);
		addEEnumLiteral(dataTypeEEnum, DataType.DOUBLE);

		// Create resource
		createResource(eNS_URI);
	}

} //Domainmetamodelm2mPackageImpl
