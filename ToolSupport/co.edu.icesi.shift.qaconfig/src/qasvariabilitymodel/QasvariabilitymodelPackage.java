/**
 */
package qasvariabilitymodel;

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
 * @see qasvariabilitymodel.QasvariabilitymodelFactory
 * @model kind="package"
 * @generated
 */
public interface QasvariabilitymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qasvariabilitymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://qasvariabilitymodel/qasvariabilitymodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qasvariabilitymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QasvariabilitymodelPackage eINSTANCE = qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link qasvariabilitymodel.impl.QAImpl <em>QA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see qasvariabilitymodel.impl.QAImpl
	 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getQA()
	 * @generated
	 */
	int QA = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA__NAME = 0;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA__SELECTED = 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA__CHILDREN = 2;

	/**
	 * The number of structural features of the '<em>QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link qasvariabilitymodel.impl.ContainableByQAImpl <em>Containable By QA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see qasvariabilitymodel.impl.ContainableByQAImpl
	 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getContainableByQA()
	 * @generated
	 */
	int CONTAINABLE_BY_QA = 1;

	/**
	 * The feature id for the '<em><b>Parent QA</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINABLE_BY_QA__PARENT_QA = 0;

	/**
	 * The number of structural features of the '<em>Containable By QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINABLE_BY_QA_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Containable By QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINABLE_BY_QA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link qasvariabilitymodel.impl.RootQAImpl <em>Root QA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see qasvariabilitymodel.impl.RootQAImpl
	 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getRootQA()
	 * @generated
	 */
	int ROOT_QA = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_QA__NAME = QA__NAME;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_QA__SELECTED = QA__SELECTED;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_QA__CHILDREN = QA__CHILDREN;

	/**
	 * The number of structural features of the '<em>Root QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_QA_FEATURE_COUNT = QA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Root QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_QA_OPERATION_COUNT = QA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link qasvariabilitymodel.impl.GroupedQAImpl <em>Grouped QA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see qasvariabilitymodel.impl.GroupedQAImpl
	 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getGroupedQA()
	 * @generated
	 */
	int GROUPED_QA = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_QA__NAME = QA__NAME;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_QA__SELECTED = QA__SELECTED;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_QA__CHILDREN = QA__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_QA__PARENT_FEATURE = QA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Grouped QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_QA_FEATURE_COUNT = QA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Grouped QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUPED_QA_OPERATION_COUNT = QA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link qasvariabilitymodel.impl.SolitaryQAImpl <em>Solitary QA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see qasvariabilitymodel.impl.SolitaryQAImpl
	 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getSolitaryQA()
	 * @generated
	 */
	int SOLITARY_QA = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLITARY_QA__NAME = QA__NAME;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLITARY_QA__SELECTED = QA__SELECTED;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLITARY_QA__CHILDREN = QA__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent QA</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLITARY_QA__PARENT_QA = QA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Solitary QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLITARY_QA_FEATURE_COUNT = QA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Solitary QA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLITARY_QA_OPERATION_COUNT = QA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link qasvariabilitymodel.impl.QAGroupImpl <em>QA Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see qasvariabilitymodel.impl.QAGroupImpl
	 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getQAGroup()
	 * @generated
	 */
	int QA_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Parent QA</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_GROUP__PARENT_QA = CONTAINABLE_BY_QA__PARENT_QA;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_GROUP__NAME = CONTAINABLE_BY_QA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_GROUP__MIN = CONTAINABLE_BY_QA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_GROUP__MAX = CONTAINABLE_BY_QA_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_GROUP__CHILDREN = CONTAINABLE_BY_QA_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>QA Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_GROUP_FEATURE_COUNT = CONTAINABLE_BY_QA_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>QA Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_GROUP_OPERATION_COUNT = CONTAINABLE_BY_QA_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link qasvariabilitymodel.QA <em>QA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QA</em>'.
	 * @see qasvariabilitymodel.QA
	 * @generated
	 */
	EClass getQA();

	/**
	 * Returns the meta object for the attribute '{@link qasvariabilitymodel.QA#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see qasvariabilitymodel.QA#getName()
	 * @see #getQA()
	 * @generated
	 */
	EAttribute getQA_Name();

	/**
	 * Returns the meta object for the attribute '{@link qasvariabilitymodel.QA#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see qasvariabilitymodel.QA#isSelected()
	 * @see #getQA()
	 * @generated
	 */
	EAttribute getQA_Selected();

	/**
	 * Returns the meta object for the containment reference list '{@link qasvariabilitymodel.QA#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see qasvariabilitymodel.QA#getChildren()
	 * @see #getQA()
	 * @generated
	 */
	EReference getQA_Children();

	/**
	 * Returns the meta object for class '{@link qasvariabilitymodel.ContainableByQA <em>Containable By QA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containable By QA</em>'.
	 * @see qasvariabilitymodel.ContainableByQA
	 * @generated
	 */
	EClass getContainableByQA();

	/**
	 * Returns the meta object for the container reference '{@link qasvariabilitymodel.ContainableByQA#getParentQA <em>Parent QA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent QA</em>'.
	 * @see qasvariabilitymodel.ContainableByQA#getParentQA()
	 * @see #getContainableByQA()
	 * @generated
	 */
	EReference getContainableByQA_ParentQA();

	/**
	 * Returns the meta object for class '{@link qasvariabilitymodel.RootQA <em>Root QA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root QA</em>'.
	 * @see qasvariabilitymodel.RootQA
	 * @generated
	 */
	EClass getRootQA();

	/**
	 * Returns the meta object for class '{@link qasvariabilitymodel.GroupedQA <em>Grouped QA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grouped QA</em>'.
	 * @see qasvariabilitymodel.GroupedQA
	 * @generated
	 */
	EClass getGroupedQA();

	/**
	 * Returns the meta object for the container reference '{@link qasvariabilitymodel.GroupedQA#getParentFeature <em>Parent Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Feature</em>'.
	 * @see qasvariabilitymodel.GroupedQA#getParentFeature()
	 * @see #getGroupedQA()
	 * @generated
	 */
	EReference getGroupedQA_ParentFeature();

	/**
	 * Returns the meta object for class '{@link qasvariabilitymodel.SolitaryQA <em>Solitary QA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solitary QA</em>'.
	 * @see qasvariabilitymodel.SolitaryQA
	 * @generated
	 */
	EClass getSolitaryQA();

	/**
	 * Returns the meta object for class '{@link qasvariabilitymodel.QAGroup <em>QA Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QA Group</em>'.
	 * @see qasvariabilitymodel.QAGroup
	 * @generated
	 */
	EClass getQAGroup();

	/**
	 * Returns the meta object for the attribute '{@link qasvariabilitymodel.QAGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see qasvariabilitymodel.QAGroup#getName()
	 * @see #getQAGroup()
	 * @generated
	 */
	EAttribute getQAGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link qasvariabilitymodel.QAGroup#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see qasvariabilitymodel.QAGroup#getMin()
	 * @see #getQAGroup()
	 * @generated
	 */
	EAttribute getQAGroup_Min();

	/**
	 * Returns the meta object for the attribute '{@link qasvariabilitymodel.QAGroup#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see qasvariabilitymodel.QAGroup#getMax()
	 * @see #getQAGroup()
	 * @generated
	 */
	EAttribute getQAGroup_Max();

	/**
	 * Returns the meta object for the containment reference list '{@link qasvariabilitymodel.QAGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see qasvariabilitymodel.QAGroup#getChildren()
	 * @see #getQAGroup()
	 * @generated
	 */
	EReference getQAGroup_Children();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QasvariabilitymodelFactory getQasvariabilitymodelFactory();

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
		 * The meta object literal for the '{@link qasvariabilitymodel.impl.QAImpl <em>QA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see qasvariabilitymodel.impl.QAImpl
		 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getQA()
		 * @generated
		 */
		EClass QA = eINSTANCE.getQA();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA__NAME = eINSTANCE.getQA_Name();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA__SELECTED = eINSTANCE.getQA_Selected();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QA__CHILDREN = eINSTANCE.getQA_Children();

		/**
		 * The meta object literal for the '{@link qasvariabilitymodel.impl.ContainableByQAImpl <em>Containable By QA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see qasvariabilitymodel.impl.ContainableByQAImpl
		 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getContainableByQA()
		 * @generated
		 */
		EClass CONTAINABLE_BY_QA = eINSTANCE.getContainableByQA();

		/**
		 * The meta object literal for the '<em><b>Parent QA</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINABLE_BY_QA__PARENT_QA = eINSTANCE.getContainableByQA_ParentQA();

		/**
		 * The meta object literal for the '{@link qasvariabilitymodel.impl.RootQAImpl <em>Root QA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see qasvariabilitymodel.impl.RootQAImpl
		 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getRootQA()
		 * @generated
		 */
		EClass ROOT_QA = eINSTANCE.getRootQA();

		/**
		 * The meta object literal for the '{@link qasvariabilitymodel.impl.GroupedQAImpl <em>Grouped QA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see qasvariabilitymodel.impl.GroupedQAImpl
		 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getGroupedQA()
		 * @generated
		 */
		EClass GROUPED_QA = eINSTANCE.getGroupedQA();

		/**
		 * The meta object literal for the '<em><b>Parent Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUPED_QA__PARENT_FEATURE = eINSTANCE.getGroupedQA_ParentFeature();

		/**
		 * The meta object literal for the '{@link qasvariabilitymodel.impl.SolitaryQAImpl <em>Solitary QA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see qasvariabilitymodel.impl.SolitaryQAImpl
		 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getSolitaryQA()
		 * @generated
		 */
		EClass SOLITARY_QA = eINSTANCE.getSolitaryQA();

		/**
		 * The meta object literal for the '{@link qasvariabilitymodel.impl.QAGroupImpl <em>QA Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see qasvariabilitymodel.impl.QAGroupImpl
		 * @see qasvariabilitymodel.impl.QasvariabilitymodelPackageImpl#getQAGroup()
		 * @generated
		 */
		EClass QA_GROUP = eINSTANCE.getQAGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA_GROUP__NAME = eINSTANCE.getQAGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA_GROUP__MIN = eINSTANCE.getQAGroup_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA_GROUP__MAX = eINSTANCE.getQAGroup_Max();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QA_GROUP__CHILDREN = eINSTANCE.getQAGroup_Children();

	}

} //QasvariabilitymodelPackage
