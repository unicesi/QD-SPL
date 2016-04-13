/**
 */
package problemSpaceMetamodel;

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
 * @see problemSpaceMetamodel.ProblemSpaceMetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface ProblemSpaceMetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "problemSpaceMetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://problemSpaceMetamodel/problemSpaceMetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "problemSpaceMetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProblemSpaceMetamodelPackage eINSTANCE = problemSpaceMetamodel.impl.ProblemSpaceMetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link problemSpaceMetamodel.impl.ProblemSpaceImpl <em>Problem Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see problemSpaceMetamodel.impl.ProblemSpaceImpl
	 * @see problemSpaceMetamodel.impl.ProblemSpaceMetamodelPackageImpl#getProblemSpace()
	 * @generated
	 */
	int PROBLEM_SPACE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPACE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPACE__ENTITY = 1;

	/**
	 * The number of structural features of the '<em>Problem Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Problem Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_SPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link problemSpaceMetamodel.impl.CharacteristicImpl <em>Characteristic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see problemSpaceMetamodel.impl.CharacteristicImpl
	 * @see problemSpaceMetamodel.impl.ProblemSpaceMetamodelPackageImpl#getCharacteristic()
	 * @generated
	 */
	int CHARACTERISTIC = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC__NAME = 0;

	/**
	 * The number of structural features of the '<em>Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Characteristic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHARACTERISTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link problemSpaceMetamodel.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see problemSpaceMetamodel.impl.EntityImpl
	 * @see problemSpaceMetamodel.impl.ProblemSpaceMetamodelPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Characteristics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__CHARACTERISTICS = 1;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link problemSpaceMetamodel.ProblemSpace <em>Problem Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem Space</em>'.
	 * @see problemSpaceMetamodel.ProblemSpace
	 * @generated
	 */
	EClass getProblemSpace();

	/**
	 * Returns the meta object for the attribute '{@link problemSpaceMetamodel.ProblemSpace#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see problemSpaceMetamodel.ProblemSpace#getName()
	 * @see #getProblemSpace()
	 * @generated
	 */
	EAttribute getProblemSpace_Name();

	/**
	 * Returns the meta object for the containment reference '{@link problemSpaceMetamodel.ProblemSpace#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entity</em>'.
	 * @see problemSpaceMetamodel.ProblemSpace#getEntity()
	 * @see #getProblemSpace()
	 * @generated
	 */
	EReference getProblemSpace_Entity();

	/**
	 * Returns the meta object for class '{@link problemSpaceMetamodel.Characteristic <em>Characteristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Characteristic</em>'.
	 * @see problemSpaceMetamodel.Characteristic
	 * @generated
	 */
	EClass getCharacteristic();

	/**
	 * Returns the meta object for the attribute '{@link problemSpaceMetamodel.Characteristic#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see problemSpaceMetamodel.Characteristic#getName()
	 * @see #getCharacteristic()
	 * @generated
	 */
	EAttribute getCharacteristic_Name();

	/**
	 * Returns the meta object for class '{@link problemSpaceMetamodel.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see problemSpaceMetamodel.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the attribute '{@link problemSpaceMetamodel.Entity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see problemSpaceMetamodel.Entity#getName()
	 * @see #getEntity()
	 * @generated
	 */
	EAttribute getEntity_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link problemSpaceMetamodel.Entity#getCharacteristics <em>Characteristics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Characteristics</em>'.
	 * @see problemSpaceMetamodel.Entity#getCharacteristics()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Characteristics();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProblemSpaceMetamodelFactory getProblemSpaceMetamodelFactory();

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
		 * The meta object literal for the '{@link problemSpaceMetamodel.impl.ProblemSpaceImpl <em>Problem Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see problemSpaceMetamodel.impl.ProblemSpaceImpl
		 * @see problemSpaceMetamodel.impl.ProblemSpaceMetamodelPackageImpl#getProblemSpace()
		 * @generated
		 */
		EClass PROBLEM_SPACE = eINSTANCE.getProblemSpace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROBLEM_SPACE__NAME = eINSTANCE.getProblemSpace_Name();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM_SPACE__ENTITY = eINSTANCE.getProblemSpace_Entity();

		/**
		 * The meta object literal for the '{@link problemSpaceMetamodel.impl.CharacteristicImpl <em>Characteristic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see problemSpaceMetamodel.impl.CharacteristicImpl
		 * @see problemSpaceMetamodel.impl.ProblemSpaceMetamodelPackageImpl#getCharacteristic()
		 * @generated
		 */
		EClass CHARACTERISTIC = eINSTANCE.getCharacteristic();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHARACTERISTIC__NAME = eINSTANCE.getCharacteristic_Name();

		/**
		 * The meta object literal for the '{@link problemSpaceMetamodel.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see problemSpaceMetamodel.impl.EntityImpl
		 * @see problemSpaceMetamodel.impl.ProblemSpaceMetamodelPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

		/**
		 * The meta object literal for the '<em><b>Characteristics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__CHARACTERISTICS = eINSTANCE.getEntity_Characteristics();

	}

} //ProblemSpaceMetamodelPackage
