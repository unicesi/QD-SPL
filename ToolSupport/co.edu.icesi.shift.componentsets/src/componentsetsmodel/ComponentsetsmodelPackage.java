/**
 */
package componentsetsmodel;

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
 * @see componentsetsmodel.ComponentsetsmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentsetsmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "componentsetsmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://componentsetsmodel/componentsetsmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "componentsetsmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsetsmodelPackage eINSTANCE = componentsetsmodel.impl.ComponentsetsmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link componentsetsmodel.impl.ComponentSetsModelImpl <em>Component Sets Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see componentsetsmodel.impl.ComponentSetsModelImpl
	 * @see componentsetsmodel.impl.ComponentsetsmodelPackageImpl#getComponentSetsModel()
	 * @generated
	 */
	int COMPONENT_SETS_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Componentsets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SETS_MODEL__COMPONENTSETS = 0;

	/**
	 * The number of structural features of the '<em>Component Sets Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SETS_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Component Sets Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SETS_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link componentsetsmodel.impl.ComponentSetImpl <em>Component Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see componentsetsmodel.impl.ComponentSetImpl
	 * @see componentsetsmodel.impl.ComponentsetsmodelPackageImpl#getComponentSet()
	 * @generated
	 */
	int COMPONENT_SET = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET__COMPONENTS = 1;

	/**
	 * The number of structural features of the '<em>Component Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Component Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link componentsetsmodel.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see componentsetsmodel.impl.ComponentImpl
	 * @see componentsetsmodel.impl.ComponentsetsmodelPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__FILE_PATH = 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link componentsetsmodel.ComponentSetsModel <em>Component Sets Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Sets Model</em>'.
	 * @see componentsetsmodel.ComponentSetsModel
	 * @generated
	 */
	EClass getComponentSetsModel();

	/**
	 * Returns the meta object for the containment reference list '{@link componentsetsmodel.ComponentSetsModel#getComponentsets <em>Componentsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Componentsets</em>'.
	 * @see componentsetsmodel.ComponentSetsModel#getComponentsets()
	 * @see #getComponentSetsModel()
	 * @generated
	 */
	EReference getComponentSetsModel_Componentsets();

	/**
	 * Returns the meta object for class '{@link componentsetsmodel.ComponentSet <em>Component Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Set</em>'.
	 * @see componentsetsmodel.ComponentSet
	 * @generated
	 */
	EClass getComponentSet();

	/**
	 * Returns the meta object for the attribute '{@link componentsetsmodel.ComponentSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see componentsetsmodel.ComponentSet#getName()
	 * @see #getComponentSet()
	 * @generated
	 */
	EAttribute getComponentSet_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link componentsetsmodel.ComponentSet#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see componentsetsmodel.ComponentSet#getComponents()
	 * @see #getComponentSet()
	 * @generated
	 */
	EReference getComponentSet_Components();

	/**
	 * Returns the meta object for class '{@link componentsetsmodel.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see componentsetsmodel.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link componentsetsmodel.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see componentsetsmodel.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Name();

	/**
	 * Returns the meta object for the attribute '{@link componentsetsmodel.Component#getFilePath <em>File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Path</em>'.
	 * @see componentsetsmodel.Component#getFilePath()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_FilePath();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComponentsetsmodelFactory getComponentsetsmodelFactory();

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
		 * The meta object literal for the '{@link componentsetsmodel.impl.ComponentSetsModelImpl <em>Component Sets Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see componentsetsmodel.impl.ComponentSetsModelImpl
		 * @see componentsetsmodel.impl.ComponentsetsmodelPackageImpl#getComponentSetsModel()
		 * @generated
		 */
		EClass COMPONENT_SETS_MODEL = eINSTANCE.getComponentSetsModel();

		/**
		 * The meta object literal for the '<em><b>Componentsets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_SETS_MODEL__COMPONENTSETS = eINSTANCE.getComponentSetsModel_Componentsets();

		/**
		 * The meta object literal for the '{@link componentsetsmodel.impl.ComponentSetImpl <em>Component Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see componentsetsmodel.impl.ComponentSetImpl
		 * @see componentsetsmodel.impl.ComponentsetsmodelPackageImpl#getComponentSet()
		 * @generated
		 */
		EClass COMPONENT_SET = eINSTANCE.getComponentSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_SET__NAME = eINSTANCE.getComponentSet_Name();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_SET__COMPONENTS = eINSTANCE.getComponentSet_Components();

		/**
		 * The meta object literal for the '{@link componentsetsmodel.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see componentsetsmodel.impl.ComponentImpl
		 * @see componentsetsmodel.impl.ComponentsetsmodelPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

		/**
		 * The meta object literal for the '<em><b>File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__FILE_PATH = eINSTANCE.getComponent_FilePath();

	}

} //ComponentsetsmodelPackage
