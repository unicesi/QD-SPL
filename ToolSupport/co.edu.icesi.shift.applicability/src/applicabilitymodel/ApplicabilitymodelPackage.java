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
	 * The meta object id for the '{@link applicabilitymodel.impl.ApplicabilityModelImpl <em>Applicability Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.ApplicabilityModelImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getApplicabilityModel()
	 * @generated
	 */
	int APPLICABILITY_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Qualitymodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY_MODEL__QUALITYMODEL = 0;

	/**
	 * The feature id for the '<em><b>Component Set Store</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY_MODEL__COMPONENT_SET_STORE = 1;

	/**
	 * The feature id for the '<em><b>Applicabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY_MODEL__APPLICABILITIES = 2;

	/**
	 * The number of structural features of the '<em>Applicability Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Applicability Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link applicabilitymodel.impl.InputModelImpl <em>Input Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.InputModelImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getInputModel()
	 * @generated
	 */
	int INPUT_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_MODEL__PATH = 0;

	/**
	 * The number of structural features of the '<em>Input Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Input Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link applicabilitymodel.impl.ApplicabilityImpl <em>Applicability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.ApplicabilityImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getApplicability()
	 * @generated
	 */
	int APPLICABILITY = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Quality Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY__QUALITY_SCENARIO = 1;

	/**
	 * The feature id for the '<em><b>Component Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY__COMPONENT_SETS = 2;

	/**
	 * The number of structural features of the '<em>Applicability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Applicability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICABILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link applicabilitymodel.impl.QualityScenarioImpl <em>Quality Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.QualityScenarioImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getQualityScenario()
	 * @generated
	 */
	int QUALITY_SCENARIO = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SCENARIO__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SCENARIO__NAME = 1;

	/**
	 * The number of structural features of the '<em>Quality Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SCENARIO_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Quality Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITY_SCENARIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link applicabilitymodel.impl.ComponentSetImpl <em>Component Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see applicabilitymodel.impl.ComponentSetImpl
	 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getComponentSet()
	 * @generated
	 */
	int COMPONENT_SET = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET__NAME = 1;

	/**
	 * The feature id for the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET__FILE_PATH = 2;

	/**
	 * The number of structural features of the '<em>Component Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Component Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link applicabilitymodel.ApplicabilityModel <em>Applicability Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Applicability Model</em>'.
	 * @see applicabilitymodel.ApplicabilityModel
	 * @generated
	 */
	EClass getApplicabilityModel();

	/**
	 * Returns the meta object for the containment reference '{@link applicabilitymodel.ApplicabilityModel#getQualitymodel <em>Qualitymodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Qualitymodel</em>'.
	 * @see applicabilitymodel.ApplicabilityModel#getQualitymodel()
	 * @see #getApplicabilityModel()
	 * @generated
	 */
	EReference getApplicabilityModel_Qualitymodel();

	/**
	 * Returns the meta object for the containment reference '{@link applicabilitymodel.ApplicabilityModel#getComponentSetStore <em>Component Set Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Component Set Store</em>'.
	 * @see applicabilitymodel.ApplicabilityModel#getComponentSetStore()
	 * @see #getApplicabilityModel()
	 * @generated
	 */
	EReference getApplicabilityModel_ComponentSetStore();

	/**
	 * Returns the meta object for the containment reference list '{@link applicabilitymodel.ApplicabilityModel#getApplicabilities <em>Applicabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Applicabilities</em>'.
	 * @see applicabilitymodel.ApplicabilityModel#getApplicabilities()
	 * @see #getApplicabilityModel()
	 * @generated
	 */
	EReference getApplicabilityModel_Applicabilities();

	/**
	 * Returns the meta object for class '{@link applicabilitymodel.InputModel <em>Input Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Model</em>'.
	 * @see applicabilitymodel.InputModel
	 * @generated
	 */
	EClass getInputModel();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.InputModel#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see applicabilitymodel.InputModel#getPath()
	 * @see #getInputModel()
	 * @generated
	 */
	EAttribute getInputModel_Path();

	/**
	 * Returns the meta object for class '{@link applicabilitymodel.Applicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Applicability</em>'.
	 * @see applicabilitymodel.Applicability
	 * @generated
	 */
	EClass getApplicability();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.Applicability#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see applicabilitymodel.Applicability#getValue()
	 * @see #getApplicability()
	 * @generated
	 */
	EAttribute getApplicability_Value();

	/**
	 * Returns the meta object for the containment reference '{@link applicabilitymodel.Applicability#getQualityScenario <em>Quality Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Quality Scenario</em>'.
	 * @see applicabilitymodel.Applicability#getQualityScenario()
	 * @see #getApplicability()
	 * @generated
	 */
	EReference getApplicability_QualityScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link applicabilitymodel.Applicability#getComponentSets <em>Component Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Sets</em>'.
	 * @see applicabilitymodel.Applicability#getComponentSets()
	 * @see #getApplicability()
	 * @generated
	 */
	EReference getApplicability_ComponentSets();

	/**
	 * Returns the meta object for class '{@link applicabilitymodel.QualityScenario <em>Quality Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quality Scenario</em>'.
	 * @see applicabilitymodel.QualityScenario
	 * @generated
	 */
	EClass getQualityScenario();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.QualityScenario#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see applicabilitymodel.QualityScenario#getId()
	 * @see #getQualityScenario()
	 * @generated
	 */
	EAttribute getQualityScenario_Id();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.QualityScenario#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see applicabilitymodel.QualityScenario#getName()
	 * @see #getQualityScenario()
	 * @generated
	 */
	EAttribute getQualityScenario_Name();

	/**
	 * Returns the meta object for class '{@link applicabilitymodel.ComponentSet <em>Component Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Set</em>'.
	 * @see applicabilitymodel.ComponentSet
	 * @generated
	 */
	EClass getComponentSet();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.ComponentSet#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see applicabilitymodel.ComponentSet#getId()
	 * @see #getComponentSet()
	 * @generated
	 */
	EAttribute getComponentSet_Id();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.ComponentSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see applicabilitymodel.ComponentSet#getName()
	 * @see #getComponentSet()
	 * @generated
	 */
	EAttribute getComponentSet_Name();

	/**
	 * Returns the meta object for the attribute '{@link applicabilitymodel.ComponentSet#getFilePath <em>File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Path</em>'.
	 * @see applicabilitymodel.ComponentSet#getFilePath()
	 * @see #getComponentSet()
	 * @generated
	 */
	EAttribute getComponentSet_FilePath();

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
		 * The meta object literal for the '{@link applicabilitymodel.impl.ApplicabilityModelImpl <em>Applicability Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.ApplicabilityModelImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getApplicabilityModel()
		 * @generated
		 */
		EClass APPLICABILITY_MODEL = eINSTANCE.getApplicabilityModel();

		/**
		 * The meta object literal for the '<em><b>Qualitymodel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICABILITY_MODEL__QUALITYMODEL = eINSTANCE.getApplicabilityModel_Qualitymodel();

		/**
		 * The meta object literal for the '<em><b>Component Set Store</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICABILITY_MODEL__COMPONENT_SET_STORE = eINSTANCE.getApplicabilityModel_ComponentSetStore();

		/**
		 * The meta object literal for the '<em><b>Applicabilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICABILITY_MODEL__APPLICABILITIES = eINSTANCE.getApplicabilityModel_Applicabilities();

		/**
		 * The meta object literal for the '{@link applicabilitymodel.impl.InputModelImpl <em>Input Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.InputModelImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getInputModel()
		 * @generated
		 */
		EClass INPUT_MODEL = eINSTANCE.getInputModel();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_MODEL__PATH = eINSTANCE.getInputModel_Path();

		/**
		 * The meta object literal for the '{@link applicabilitymodel.impl.ApplicabilityImpl <em>Applicability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.ApplicabilityImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getApplicability()
		 * @generated
		 */
		EClass APPLICABILITY = eINSTANCE.getApplicability();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICABILITY__VALUE = eINSTANCE.getApplicability_Value();

		/**
		 * The meta object literal for the '<em><b>Quality Scenario</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICABILITY__QUALITY_SCENARIO = eINSTANCE.getApplicability_QualityScenario();

		/**
		 * The meta object literal for the '<em><b>Component Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICABILITY__COMPONENT_SETS = eINSTANCE.getApplicability_ComponentSets();

		/**
		 * The meta object literal for the '{@link applicabilitymodel.impl.QualityScenarioImpl <em>Quality Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.QualityScenarioImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getQualityScenario()
		 * @generated
		 */
		EClass QUALITY_SCENARIO = eINSTANCE.getQualityScenario();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY_SCENARIO__ID = eINSTANCE.getQualityScenario_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITY_SCENARIO__NAME = eINSTANCE.getQualityScenario_Name();

		/**
		 * The meta object literal for the '{@link applicabilitymodel.impl.ComponentSetImpl <em>Component Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see applicabilitymodel.impl.ComponentSetImpl
		 * @see applicabilitymodel.impl.ApplicabilitymodelPackageImpl#getComponentSet()
		 * @generated
		 */
		EClass COMPONENT_SET = eINSTANCE.getComponentSet();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_SET__ID = eINSTANCE.getComponentSet_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_SET__NAME = eINSTANCE.getComponentSet_Name();

		/**
		 * The meta object literal for the '<em><b>File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_SET__FILE_PATH = eINSTANCE.getComponentSet_FilePath();

	}

} //ApplicabilitymodelPackage
