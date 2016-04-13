/**
 */
package problemSpaceMetamodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import problemSpaceMetamodel.Characteristic;
import problemSpaceMetamodel.Entity;
import problemSpaceMetamodel.ProblemSpace;
import problemSpaceMetamodel.ProblemSpaceMetamodelFactory;
import problemSpaceMetamodel.ProblemSpaceMetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProblemSpaceMetamodelPackageImpl extends EPackageImpl implements ProblemSpaceMetamodelPackage {
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
	private EClass characteristicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

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
	 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProblemSpaceMetamodelPackageImpl() {
		super(eNS_URI, ProblemSpaceMetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ProblemSpaceMetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProblemSpaceMetamodelPackage init() {
		if (isInited) return (ProblemSpaceMetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(ProblemSpaceMetamodelPackage.eNS_URI);

		// Obtain or create and register package
		ProblemSpaceMetamodelPackageImpl theProblemSpaceMetamodelPackage = (ProblemSpaceMetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ProblemSpaceMetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ProblemSpaceMetamodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theProblemSpaceMetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theProblemSpaceMetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProblemSpaceMetamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProblemSpaceMetamodelPackage.eNS_URI, theProblemSpaceMetamodelPackage);
		return theProblemSpaceMetamodelPackage;
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
	public EReference getEntity_Characteristics() {
		return (EReference)entityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemSpaceMetamodelFactory getProblemSpaceMetamodelFactory() {
		return (ProblemSpaceMetamodelFactory)getEFactoryInstance();
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

		characteristicEClass = createEClass(CHARACTERISTIC);
		createEAttribute(characteristicEClass, CHARACTERISTIC__NAME);

		entityEClass = createEClass(ENTITY);
		createEAttribute(entityEClass, ENTITY__NAME);
		createEReference(entityEClass, ENTITY__CHARACTERISTICS);
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

		initEClass(characteristicEClass, Characteristic.class, "Characteristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCharacteristic_Name(), ecorePackage.getEString(), "name", null, 0, 1, Characteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_Characteristics(), this.getCharacteristic(), null, "characteristics", null, 1, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ProblemSpaceMetamodelPackageImpl
