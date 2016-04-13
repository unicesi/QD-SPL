/**
 */
package kernelmetamodel.impl;

import kernelmetamodel.Attribute;
import kernelmetamodel.Element;
import kernelmetamodel.Kernel;
import kernelmetamodel.KernelmetamodelFactory;
import kernelmetamodel.KernelmetamodelPackage;
import kernelmetamodel.Sort;
import kernelmetamodel.SortAlgorithm;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KernelmetamodelFactoryImpl extends EFactoryImpl implements KernelmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static KernelmetamodelFactory init() {
		try {
			KernelmetamodelFactory theKernelmetamodelFactory = (KernelmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(KernelmetamodelPackage.eNS_URI);
			if (theKernelmetamodelFactory != null) {
				return theKernelmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new KernelmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelmetamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case KernelmetamodelPackage.KERNEL: return createKernel();
			case KernelmetamodelPackage.SYSTEM: return createSystem();
			case KernelmetamodelPackage.ELEMENT: return createElement();
			case KernelmetamodelPackage.ATTRIBUTE: return createAttribute();
			case KernelmetamodelPackage.SORT: return createSort();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case KernelmetamodelPackage.SORT_ALGORITHM:
				return createSortAlgorithmFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case KernelmetamodelPackage.SORT_ALGORITHM:
				return convertSortAlgorithmToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Kernel createKernel() {
		KernelImpl kernel = new KernelImpl();
		return kernel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public kernelmetamodel.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sort createSort() {
		SortImpl sort = new SortImpl();
		return sort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortAlgorithm createSortAlgorithmFromString(EDataType eDataType, String initialValue) {
		SortAlgorithm result = SortAlgorithm.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSortAlgorithmToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelmetamodelPackage getKernelmetamodelPackage() {
		return (KernelmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static KernelmetamodelPackage getPackage() {
		return KernelmetamodelPackage.eINSTANCE;
	}

} //KernelmetamodelFactoryImpl
