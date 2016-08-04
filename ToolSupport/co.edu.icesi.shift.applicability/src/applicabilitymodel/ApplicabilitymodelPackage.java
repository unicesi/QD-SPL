/**
 */
package applicabilitymodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see applicabilitymodel.ApplicabilitymodelFactory
 * @model kind="package"
 * @generated
 */
public interface ApplicabilitymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "applicabilitymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://applicabilitymodel/applicabilitymodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "applicabilitymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ApplicabilitymodelPackage eINSTANCE = applicabilitymodel.impl.ApplicabilitymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link applicabilitymodel.impl.DecisionModelImpl <em>Decision Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.DecisionModelImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getDecisionModel()
	 * @generated
	 */
	int DECISION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Decision Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL__DECISION_MODEL_NAME = 0;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL__DECISIONS = 1;

	/**
	 * The number of structural features of the '<em>Decision Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Decision Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link applicabilitymodel.impl.DecisionImpl <em>Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.DecisionImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getDecision()
	 * @generated
	 */
	int DECISION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Component Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__COMPONENT_SET = 1;

	/**
	 * The feature id for the '<em><b>Required Variants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__REQUIRED_VARIANTS = 2;

	/**
	 * The number of structural features of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link applicabilitymodel.impl.RequiredVariantImpl <em>Required Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.RequiredVariantImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getRequiredVariant()
	 * @generated
	 */
	int REQUIRED_VARIANT = 2;

	/**
	 * The feature id for the '<em><b>Variant Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_VARIANT__VARIANT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Selection Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_VARIANT__SELECTION_REQUIRED = 1;

	/**
	 * The number of structural features of the '<em>Required Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_VARIANT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Required Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_VARIANT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link applicabilitymodel.DecisionModel <em>Decision Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision Model</em>'.
	 * @see applicabilitymodel.DecisionModel
	 * @generated
	 */
	EClass getDecisionModel();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.DecisionModel#getDecisionModelName <em>Decision Model Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decision Model Name</em>'.
	 * @see applicabilitymodel.DecisionModel#getDecisionModelName()
	 * @see #getDecisionModel()
	 * @generated
	 */
	EAttribute getDecisionModel_DecisionModelName();

	/**
	 * Returns the meta object for the containment reference list '{@link applicabilitymodel.DecisionModel#getDecisions <em>Decisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decisions</em>'.
	 * @see applicabilitymodel.DecisionModel#getDecisions()
	 * @see #getDecisionModel()
	 * @generated
	 */
	EReference getDecisionModel_Decisions();

	/**
	 * Returns the meta object for class '{@link applicabilitymodel.Decision <em>Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision</em>'.
	 * @see applicabilitymodel.Decision
	 * @generated
	 */
	EClass getDecision();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.Decision#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see applicabilitymodel.Decision#getName()
	 * @see #getDecision()
	 * @generated
	 */
	EAttribute getDecision_Name();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.Decision#getComponentSet <em>Component Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Set</em>'.
	 * @see applicabilitymodel.Decision#getComponentSet()
	 * @see #getDecision()
	 * @generated
	 */
	EAttribute getDecision_ComponentSet();

	/**
	 * Returns the meta object for the containment reference list '{@link applicabilitymodel.Decision#getRequiredVariants <em>Required Variants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Required Variants</em>'.
	 * @see applicabilitymodel.Decision#getRequiredVariants()
	 * @see #getDecision()
	 * @generated
	 */
	EReference getDecision_RequiredVariants();

	/**
	 * Returns the meta object for class '{@link applicabilitymodel.RequiredVariant <em>Required Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Variant</em>'.
	 * @see applicabilitymodel.RequiredVariant
	 * @generated
	 */
	EClass getRequiredVariant();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.RequiredVariant#getVariantName <em>Variant Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variant Name</em>'.
	 * @see applicabilitymodel.RequiredVariant#getVariantName()
	 * @see #getRequiredVariant()
	 * @generated
	 */
	EAttribute getRequiredVariant_VariantName();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.RequiredVariant#getSelectionRequired <em>Selection Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection Required</em>'.
	 * @see applicabilitymodel.RequiredVariant#getSelectionRequired()
	 * @see #getRequiredVariant()
	 * @generated
	 */
	EAttribute getRequiredVariant_SelectionRequired();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ApplicabilitymodelFactory getApplicabilitymodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link applicabilitymodel.impl.DecisionModelImpl <em>Decision Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.DecisionModelImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getDecisionModel()
		 * @generated
		 */
		EClass DECISION_MODEL = eINSTANCE.getDecisionModel();

		/**
		 * The meta object literal for the '<em><b>Decision Model Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION_MODEL__DECISION_MODEL_NAME = eINSTANCE.getDecisionModel_DecisionModelName();

		/**
		 * The meta object literal for the '<em><b>Decisions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION_MODEL__DECISIONS = eINSTANCE.getDecisionModel_Decisions();

		/**
		 * The meta object literal for the '{@link applicabilitymodel.impl.DecisionImpl <em>Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.DecisionImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getDecision()
		 * @generated
		 */
		EClass DECISION = eINSTANCE.getDecision();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION__NAME = eINSTANCE.getDecision_Name();

		/**
		 * The meta object literal for the '<em><b>Component Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION__COMPONENT_SET = eINSTANCE.getDecision_ComponentSet();

		/**
		 * The meta object literal for the '<em><b>Required Variants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION__REQUIRED_VARIANTS = eINSTANCE.getDecision_RequiredVariants();

		/**
		 * The meta object literal for the '{@link applicabilitymodel.impl.RequiredVariantImpl <em>Required Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.RequiredVariantImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getRequiredVariant()
		 * @generated
		 */
		EClass REQUIRED_VARIANT = eINSTANCE.getRequiredVariant();

		/**
		 * The meta object literal for the '<em><b>Variant Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRED_VARIANT__VARIANT_NAME = eINSTANCE.getRequiredVariant_VariantName();

		/**
		 * The meta object literal for the '<em><b>Selection Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRED_VARIANT__SELECTION_REQUIRED = eINSTANCE.getRequiredVariant_SelectionRequired();

	}

} //ApplicabilitymodelPackage
