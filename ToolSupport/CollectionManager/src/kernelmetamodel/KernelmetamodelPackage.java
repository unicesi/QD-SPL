/**
 */
package kernelmetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see kernelmetamodel.KernelmetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface KernelmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kernelmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://kernelmetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kernelmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KernelmetamodelPackage eINSTANCE = kernelmetamodel.impl.KernelmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link kernelmetamodel.impl.KernelImpl <em>Kernel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kernelmetamodel.impl.KernelImpl
	 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getKernel()
	 * @generated
	 */
	int KERNEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__SYSTEM = 1;

	/**
	 * The number of structural features of the '<em>Kernel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Kernel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kernelmetamodel.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kernelmetamodel.impl.SystemImpl
	 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Sort</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SORT = 2;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kernelmetamodel.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kernelmetamodel.impl.ElementImpl
	 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kernelmetamodel.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kernelmetamodel.impl.AttributeImpl
	 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Is Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_IDENTIFIER = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kernelmetamodel.impl.SortImpl <em>Sort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kernelmetamodel.impl.SortImpl
	 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getSort()
	 * @generated
	 */
	int SORT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT__ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Sort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Sort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link kernelmetamodel.SortAlgorithm <em>Sort Algorithm</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see kernelmetamodel.SortAlgorithm
	 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getSortAlgorithm()
	 * @generated
	 */
	int SORT_ALGORITHM = 5;


	/**
	 * Returns the meta object for class '{@link kernelmetamodel.Kernel <em>Kernel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Kernel</em>'.
	 * @see kernelmetamodel.Kernel
	 * @generated
	 */
	EClass getKernel();

	/**
	 * Returns the meta object for the attribute '{@link kernelmetamodel.Kernel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kernelmetamodel.Kernel#getName()
	 * @see #getKernel()
	 * @generated
	 */
	EAttribute getKernel_Name();

	/**
	 * Returns the meta object for the containment reference '{@link kernelmetamodel.Kernel#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>System</em>'.
	 * @see kernelmetamodel.Kernel#getSystem()
	 * @see #getKernel()
	 * @generated
	 */
	EReference getKernel_System();

	/**
	 * Returns the meta object for class '{@link kernelmetamodel.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see kernelmetamodel.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the attribute '{@link kernelmetamodel.System#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kernelmetamodel.System#getName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Name();

	/**
	 * Returns the meta object for the containment reference '{@link kernelmetamodel.System#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see kernelmetamodel.System#getElement()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Element();

	/**
	 * Returns the meta object for the containment reference list '{@link kernelmetamodel.System#getSort <em>Sort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sort</em>'.
	 * @see kernelmetamodel.System#getSort()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Sort();

	/**
	 * Returns the meta object for class '{@link kernelmetamodel.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see kernelmetamodel.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link kernelmetamodel.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kernelmetamodel.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link kernelmetamodel.Element#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see kernelmetamodel.Element#getAttribute()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Attribute();

	/**
	 * Returns the meta object for class '{@link kernelmetamodel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see kernelmetamodel.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link kernelmetamodel.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kernelmetamodel.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link kernelmetamodel.Attribute#isIsIdentifier <em>Is Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Identifier</em>'.
	 * @see kernelmetamodel.Attribute#isIsIdentifier()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_IsIdentifier();

	/**
	 * Returns the meta object for class '{@link kernelmetamodel.Sort <em>Sort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sort</em>'.
	 * @see kernelmetamodel.Sort
	 * @generated
	 */
	EClass getSort();

	/**
	 * Returns the meta object for the attribute '{@link kernelmetamodel.Sort#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see kernelmetamodel.Sort#getName()
	 * @see #getSort()
	 * @generated
	 */
	EAttribute getSort_Name();

	/**
	 * Returns the meta object for the attribute '{@link kernelmetamodel.Sort#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see kernelmetamodel.Sort#getAlgorithm()
	 * @see #getSort()
	 * @generated
	 */
	EAttribute getSort_Algorithm();

	/**
	 * Returns the meta object for the containment reference '{@link kernelmetamodel.Sort#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see kernelmetamodel.Sort#getAttribute()
	 * @see #getSort()
	 * @generated
	 */
	EReference getSort_Attribute();

	/**
	 * Returns the meta object for enum '{@link kernelmetamodel.SortAlgorithm <em>Sort Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sort Algorithm</em>'.
	 * @see kernelmetamodel.SortAlgorithm
	 * @generated
	 */
	EEnum getSortAlgorithm();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KernelmetamodelFactory getKernelmetamodelFactory();

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
		 * The meta object literal for the '{@link kernelmetamodel.impl.KernelImpl <em>Kernel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kernelmetamodel.impl.KernelImpl
		 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getKernel()
		 * @generated
		 */
		EClass KERNEL = eINSTANCE.getKernel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KERNEL__NAME = eINSTANCE.getKernel_Name();

		/**
		 * The meta object literal for the '<em><b>System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KERNEL__SYSTEM = eINSTANCE.getKernel_System();

		/**
		 * The meta object literal for the '{@link kernelmetamodel.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kernelmetamodel.impl.SystemImpl
		 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__NAME = eINSTANCE.getSystem_Name();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__ELEMENT = eINSTANCE.getSystem_Element();

		/**
		 * The meta object literal for the '<em><b>Sort</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__SORT = eINSTANCE.getSystem_Sort();

		/**
		 * The meta object literal for the '{@link kernelmetamodel.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kernelmetamodel.impl.ElementImpl
		 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ATTRIBUTE = eINSTANCE.getElement_Attribute();

		/**
		 * The meta object literal for the '{@link kernelmetamodel.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kernelmetamodel.impl.AttributeImpl
		 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Is Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__IS_IDENTIFIER = eINSTANCE.getAttribute_IsIdentifier();

		/**
		 * The meta object literal for the '{@link kernelmetamodel.impl.SortImpl <em>Sort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kernelmetamodel.impl.SortImpl
		 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getSort()
		 * @generated
		 */
		EClass SORT = eINSTANCE.getSort();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT__NAME = eINSTANCE.getSort_Name();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SORT__ALGORITHM = eINSTANCE.getSort_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SORT__ATTRIBUTE = eINSTANCE.getSort_Attribute();

		/**
		 * The meta object literal for the '{@link kernelmetamodel.SortAlgorithm <em>Sort Algorithm</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see kernelmetamodel.SortAlgorithm
		 * @see kernelmetamodel.impl.KernelmetamodelPackageImpl#getSortAlgorithm()
		 * @generated
		 */
		EEnum SORT_ALGORITHM = eINSTANCE.getSortAlgorithm();

	}

} //KernelmetamodelPackage
