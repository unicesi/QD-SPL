/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.ApplicabilitymodelFactory;
import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.Decision;
import applicabilitymodel.DecisionModel;

import componentsetsmodel.ComponentsetsmodelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import qasvariabilitymodel.QasvariabilitymodelPackage;

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
	private EClass decisionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decisionEClass = null;

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

		// Initialize simple dependencies
		ComponentsetsmodelPackage.eINSTANCE.eClass();
		QasvariabilitymodelPackage.eINSTANCE.eClass();

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
	public EClass getDecisionModel() {
		return decisionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecisionModel_Qualitymodel() {
		return (EReference)decisionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecisionModel_ComponentSetsModel() {
		return (EReference)decisionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecisionModel_Decisions() {
		return (EReference)decisionModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecision() {
		return decisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecision_QaVariant() {
		return (EReference)decisionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecision_ComponentSet() {
		return (EReference)decisionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDecision_RequiresVariantSelected() {
		return (EAttribute)decisionEClass.getEStructuralFeatures().get(2);
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
		decisionModelEClass = createEClass(DECISION_MODEL);
		createEReference(decisionModelEClass, DECISION_MODEL__QUALITYMODEL);
		createEReference(decisionModelEClass, DECISION_MODEL__COMPONENT_SETS_MODEL);
		createEReference(decisionModelEClass, DECISION_MODEL__DECISIONS);

		decisionEClass = createEClass(DECISION);
		createEReference(decisionEClass, DECISION__QA_VARIANT);
		createEReference(decisionEClass, DECISION__COMPONENT_SET);
		createEAttribute(decisionEClass, DECISION__REQUIRES_VARIANT_SELECTED);
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

		// Obtain other dependent packages
		QasvariabilitymodelPackage theQasvariabilitymodelPackage = (QasvariabilitymodelPackage)EPackage.Registry.INSTANCE.getEPackage(QasvariabilitymodelPackage.eNS_URI);
		ComponentsetsmodelPackage theComponentsetsmodelPackage = (ComponentsetsmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ComponentsetsmodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(decisionModelEClass, DecisionModel.class, "DecisionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecisionModel_Qualitymodel(), theQasvariabilitymodelPackage.getRootQA(), null, "qualitymodel", null, 1, 1, DecisionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDecisionModel_ComponentSetsModel(), theComponentsetsmodelPackage.getComponentSetsModel(), null, "componentSetsModel", null, 1, 1, DecisionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDecisionModel_Decisions(), this.getDecision(), null, "decisions", null, 1, -1, DecisionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decisionEClass, Decision.class, "Decision", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecision_QaVariant(), theQasvariabilitymodelPackage.getQA(), null, "qaVariant", null, 1, 1, Decision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDecision_ComponentSet(), theComponentsetsmodelPackage.getComponentSet(), null, "componentSet", null, 1, 1, Decision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDecision_RequiresVariantSelected(), ecorePackage.getEInt(), "requiresVariantSelected", "0", 1, 1, Decision.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ApplicabilitymodelPackageImpl
