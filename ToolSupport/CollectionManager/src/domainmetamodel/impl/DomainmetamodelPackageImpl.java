/**
 */
package domainmetamodel.impl;

import domainmetamodel.Characteristic;
import domainmetamodel.DomainmetamodelFactory;
import domainmetamodel.DomainmetamodelPackage;
import domainmetamodel.Entity;
import domainmetamodel.ProblemSpace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainmetamodelPackageImpl extends EPackageImpl implements DomainmetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass problemSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characteristicEClass = null;

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
	 * @see domainmetamodel.DomainmetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DomainmetamodelPackageImpl() {
		super(eNS_URI, DomainmetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DomainmetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DomainmetamodelPackage init() {
		if (isInited) return (DomainmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(DomainmetamodelPackage.eNS_URI);

		// Obtain or create and register package
		DomainmetamodelPackageImpl theDomainmetamodelPackage = (DomainmetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DomainmetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DomainmetamodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDomainmetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theDomainmetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDomainmetamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DomainmetamodelPackage.eNS_URI, theDomainmetamodelPackage);
		return theDomainmetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProblemSpace() {
		return problemSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProblemSpace_Name() {
		return (EAttribute)problemSpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProblemSpace_Entity() {
		return (EReference)problemSpaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntity_Name() {
		return (EAttribute)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_Characteristic() {
		return (EReference)entityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCharacteristic() {
		return characteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCharacteristic_Name() {
		return (EAttribute)characteristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainmetamodelFactory getDomainmetamodelFactory() {
		return (DomainmetamodelFactory)getEFactoryInstance();
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
		problemSpaceEClass = createEClass(PROBLEM_SPACE);
		createEAttribute(problemSpaceEClass, PROBLEM_SPACE__NAME);
		createEReference(problemSpaceEClass, PROBLEM_SPACE__ENTITY);

		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__NAME);
		createEReference(entityEClass, ENTITY__CHARACTERISTIC);

		characteristicEClass = createEClass(CHARACTERISTIC);
		createEAttribute(characteristicEClass, CHARACTERISTIC__NAME);
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

		// Initialize classes, features, and operations; add parameters
		initEClass(problemSpaceEClass, ProblemSpace.class, "ProblemSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProblemSpace_Name(), ecorePackage.getEString(), "name", null, 0, 1, ProblemSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblemSpace_Entity(), this.getEntity(), null, "entity", null, 1, 1, ProblemSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_Characteristic(), this.getCharacteristic(), null, "characteristic", null, 1, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(characteristicEClass, Characteristic.class, "Characteristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCharacteristic_Name(), ecorePackage.getEString(), "name", null, 0, 1, Characteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DomainmetamodelPackageImpl
