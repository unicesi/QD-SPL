/**
 */
package domainmetamodelm2m.impl;

import domainmetamodelm2m.*;

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
public class Domainmetamodelm2mFactoryImpl extends EFactoryImpl implements Domainmetamodelm2mFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Domainmetamodelm2mFactory init() {
		try {
			Domainmetamodelm2mFactory theDomainmetamodelm2mFactory = (Domainmetamodelm2mFactory)EPackage.Registry.INSTANCE.getEFactory(Domainmetamodelm2mPackage.eNS_URI);
			if (theDomainmetamodelm2mFactory != null) {
				return theDomainmetamodelm2mFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Domainmetamodelm2mFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domainmetamodelm2mFactoryImpl() {
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
			case Domainmetamodelm2mPackage.BUSINESS: return createBusiness();
			case Domainmetamodelm2mPackage.BUSINESS_ENTITY: return createBusinessEntity();
			case Domainmetamodelm2mPackage.ATTRIBUTE: return createAttribute();
			case Domainmetamodelm2mPackage.ASSOCIATION: return createAssociation();
			case Domainmetamodelm2mPackage.SIMPLE: return createSimple();
			case Domainmetamodelm2mPackage.MULTIPLE: return createMultiple();
			case Domainmetamodelm2mPackage.CREATE: return createCreate();
			case Domainmetamodelm2mPackage.UPDATE: return createUpdate();
			case Domainmetamodelm2mPackage.RETRIEVE: return createRetrieve();
			case Domainmetamodelm2mPackage.DELETE: return createDelete();
			case Domainmetamodelm2mPackage.LIST_ALL: return createListAll();
			case Domainmetamodelm2mPackage.LIST_ELEMENTS: return createListElements();
			case Domainmetamodelm2mPackage.ADD_ELEMENT: return createAddElement();
			case Domainmetamodelm2mPackage.DELETE_ELEMENT: return createDeleteElement();
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
			case Domainmetamodelm2mPackage.DATA_TYPE:
				return createDataTypeFromString(eDataType, initialValue);
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
			case Domainmetamodelm2mPackage.DATA_TYPE:
				return convertDataTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Business createBusiness() {
		BusinessImpl business = new BusinessImpl();
		return business;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessEntity createBusinessEntity() {
		BusinessEntityImpl businessEntity = new BusinessEntityImpl();
		return businessEntity;
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
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simple createSimple() {
		SimpleImpl simple = new SimpleImpl();
		return simple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Multiple createMultiple() {
		MultipleImpl multiple = new MultipleImpl();
		return multiple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Create createCreate() {
		CreateImpl create = new CreateImpl();
		return create;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Update createUpdate() {
		UpdateImpl update = new UpdateImpl();
		return update;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Retrieve createRetrieve() {
		RetrieveImpl retrieve = new RetrieveImpl();
		return retrieve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delete createDelete() {
		DeleteImpl delete = new DeleteImpl();
		return delete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListAll createListAll() {
		ListAllImpl listAll = new ListAllImpl();
		return listAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListElements createListElements() {
		ListElementsImpl listElements = new ListElementsImpl();
		return listElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddElement createAddElement() {
		AddElementImpl addElement = new AddElementImpl();
		return addElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteElement createDeleteElement() {
		DeleteElementImpl deleteElement = new DeleteElementImpl();
		return deleteElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataTypeFromString(EDataType eDataType, String initialValue) {
		DataType result = DataType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domainmetamodelm2mPackage getDomainmetamodelm2mPackage() {
		return (Domainmetamodelm2mPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Domainmetamodelm2mPackage getPackage() {
		return Domainmetamodelm2mPackage.eINSTANCE;
	}

} //Domainmetamodelm2mFactoryImpl
