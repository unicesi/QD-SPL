/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.Applicability;
import applicabilitymodel.ApplicabilityModel;
import applicabilitymodel.ApplicabilitymodelFactory;
import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.ComponentSet;
import applicabilitymodel.InputModel;
import applicabilitymodel.QualityScenario;

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
public class ApplicabilitymodelPackageImpl extends EPackageImpl implements ApplicabilitymodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicabilityModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualityScenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentSetEClass = null;

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
	 * @see applicabilitymodel.ApplicabilitymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ApplicabilitymodelPackageImpl() {
		super(eNS_URI, ApplicabilitymodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ApplicabilitymodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ApplicabilitymodelPackage init() {
		if (isInited) return (ApplicabilitymodelPackage)EPackage.Registry.INSTANCE.getEPackage(ApplicabilitymodelPackage.eNS_URI);

		// Obtain or create and register package
		ApplicabilitymodelPackageImpl theApplicabilitymodelPackage = (ApplicabilitymodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ApplicabilitymodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ApplicabilitymodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theApplicabilitymodelPackage.createPackageContents();

		// Initialize created meta-data
		theApplicabilitymodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theApplicabilitymodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ApplicabilitymodelPackage.eNS_URI, theApplicabilitymodelPackage);
		return theApplicabilitymodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicabilityModel() {
		return applicabilityModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicabilityModel_Qualitymodel() {
		return (EReference)applicabilityModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicabilityModel_ComponentSetStore() {
		return (EReference)applicabilityModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicabilityModel_Applicabilities() {
		return (EReference)applicabilityModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputModel() {
		return inputModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputModel_Path() {
		return (EAttribute)inputModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicability() {
		return applicabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicability_Value() {
		return (EAttribute)applicabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicability_QualityScenario() {
		return (EReference)applicabilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicability_ComponentSets() {
		return (EReference)applicabilityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualityScenario() {
		return qualityScenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualityScenario_Id() {
		return (EAttribute)qualityScenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualityScenario_Name() {
		return (EAttribute)qualityScenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentSet() {
		return componentSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentSet_Id() {
		return (EAttribute)componentSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentSet_Name() {
		return (EAttribute)componentSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentSet_FilePath() {
		return (EAttribute)componentSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicabilitymodelFactory getApplicabilitymodelFactory() {
		return (ApplicabilitymodelFactory)getEFactoryInstance();
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
		applicabilityModelEClass = createEClass(APPLICABILITY_MODEL);
		createEReference(applicabilityModelEClass, APPLICABILITY_MODEL__QUALITYMODEL);
		createEReference(applicabilityModelEClass, APPLICABILITY_MODEL__COMPONENT_SET_STORE);
		createEReference(applicabilityModelEClass, APPLICABILITY_MODEL__APPLICABILITIES);

		inputModelEClass = createEClass(INPUT_MODEL);
		createEAttribute(inputModelEClass, INPUT_MODEL__PATH);

		applicabilityEClass = createEClass(APPLICABILITY);
		createEAttribute(applicabilityEClass, APPLICABILITY__VALUE);
		createEReference(applicabilityEClass, APPLICABILITY__QUALITY_SCENARIO);
		createEReference(applicabilityEClass, APPLICABILITY__COMPONENT_SETS);

		qualityScenarioEClass = createEClass(QUALITY_SCENARIO);
		createEAttribute(qualityScenarioEClass, QUALITY_SCENARIO__ID);
		createEAttribute(qualityScenarioEClass, QUALITY_SCENARIO__NAME);

		componentSetEClass = createEClass(COMPONENT_SET);
		createEAttribute(componentSetEClass, COMPONENT_SET__ID);
		createEAttribute(componentSetEClass, COMPONENT_SET__NAME);
		createEAttribute(componentSetEClass, COMPONENT_SET__FILE_PATH);
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
		initEClass(applicabilityModelEClass, ApplicabilityModel.class, "ApplicabilityModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicabilityModel_Qualitymodel(), this.getInputModel(), null, "qualitymodel", null, 1, 1, ApplicabilityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicabilityModel_ComponentSetStore(), this.getInputModel(), null, "componentSetStore", null, 1, 1, ApplicabilityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicabilityModel_Applicabilities(), this.getApplicability(), null, "applicabilities", null, 1, -1, ApplicabilityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputModelEClass, InputModel.class, "InputModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputModel_Path(), ecorePackage.getEString(), "path", null, 0, 1, InputModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(applicabilityEClass, Applicability.class, "Applicability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApplicability_Value(), ecorePackage.getEInt(), "value", null, 0, 1, Applicability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicability_QualityScenario(), this.getQualityScenario(), null, "qualityScenario", null, 1, 1, Applicability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicability_ComponentSets(), this.getComponentSet(), null, "componentSets", null, 0, -1, Applicability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualityScenarioEClass, QualityScenario.class, "QualityScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualityScenario_Id(), ecorePackage.getEString(), "id", null, 0, 1, QualityScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQualityScenario_Name(), ecorePackage.getEString(), "name", null, 0, 1, QualityScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentSetEClass, ComponentSet.class, "ComponentSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentSet_Id(), ecorePackage.getEString(), "id", null, 0, 1, ComponentSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentSet_Name(), ecorePackage.getEString(), "name", null, 0, 1, ComponentSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentSet_FilePath(), ecorePackage.getEString(), "filePath", null, 0, 1, ComponentSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ApplicabilitymodelPackageImpl
