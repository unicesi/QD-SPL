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
	 * The feature id for the '<em><b>Qualitymodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL__QUALITYMODEL = 0;

	/**
	 * The feature id for the '<em><b>Component Sets Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL__COMPONENT_SETS_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL__DECISIONS = 2;

	/**
	 * The number of structural features of the '<em>Decision Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_MODEL_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Qa Variant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__QA_VARIANT = 0;

	/**
	 * The feature id for the '<em><b>Component Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__COMPONENT_SET = 1;

	/**
	 * The feature id for the '<em><b>Requires Variant Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION__REQUIRES_VARIANT_SELECTED = 2;

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
	 * Returns the meta object for class '{@link applicabilitymodel.DecisionModel <em>Decision Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision Model</em>'.
	 * @see applicabilitymodel.DecisionModel
	 * @generated
	 */
	EClass getDecisionModel();

	/**
	 * Returns the meta object for the containment reference '{@link applicabilitymodel.DecisionModel#getQualitymodel <em>Qualitymodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Qualitymodel</em>'.
	 * @see applicabilitymodel.DecisionModel#getQualitymodel()
	 * @see #getDecisionModel()
	 * @generated
	 */
	EReference getDecisionModel_Qualitymodel();

	/**
	 * Returns the meta object for the containment reference '{@link applicabilitymodel.DecisionModel#getComponentSetsModel <em>Component Sets Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Sets Model</em>'.
	 * @see applicabilitymodel.DecisionModel#getComponentSetsModel()
	 * @see #getDecisionModel()
	 * @generated
	 */
	EReference getDecisionModel_ComponentSetsModel();

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
	 * Returns the meta object for the containment reference '{@link applicabilitymodel.Decision#getQaVariant <em>Qa Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Qa Variant</em>'.
	 * @see applicabilitymodel.Decision#getQaVariant()
	 * @see #getDecision()
	 * @generated
	 */
	EReference getDecision_QaVariant();

	/**
	 * Returns the meta object for the containment reference '{@link applicabilitymodel.Decision#getComponentSet <em>Component Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Set</em>'.
	 * @see applicabilitymodel.Decision#getComponentSet()
	 * @see #getDecision()
	 * @generated
	 */
	EReference getDecision_ComponentSet();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.Decision#getRequiresVariantSelected <em>Requires Variant Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requires Variant Selected</em>'.
	 * @see applicabilitymodel.Decision#getRequiresVariantSelected()
	 * @see #getDecision()
	 * @generated
	 */
	EAttribute getDecision_RequiresVariantSelected();

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
		 * The meta object literal for the '<em><b>Qualitymodel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION_MODEL__QUALITYMODEL = eINSTANCE.getDecisionModel_Qualitymodel();

		/**
		 * The meta object literal for the '<em><b>Component Sets Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION_MODEL__COMPONENT_SETS_MODEL = eINSTANCE.getDecisionModel_ComponentSetsModel();

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
		 * The meta object literal for the '<em><b>Qa Variant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION__QA_VARIANT = eINSTANCE.getDecision_QaVariant();

		/**
		 * The meta object literal for the '<em><b>Component Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION__COMPONENT_SET = eINSTANCE.getDecision_ComponentSet();

		/**
		 * The meta object literal for the '<em><b>Requires Variant Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION__REQUIRES_VARIANT_SELECTED = eINSTANCE.getDecision_RequiresVariantSelected();

	}

} //ApplicabilitymodelPackage
