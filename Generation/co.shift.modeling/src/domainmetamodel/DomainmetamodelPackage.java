/**
 */
package domainmetamodel;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see domainmetamodel.DomainmetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface DomainmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domainmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://domainmetamodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "domainmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DomainmetamodelPackage eINSTANCE = domainmetamodel.impl.DomainmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.BusinessImpl <em>Business</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.BusinessImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getBusiness()
	 * @generated
	 */
	int BUSINESS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS__ENTITIES = 1;

	/**
	 * The number of structural features of the '<em>Business</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Business</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.BusinessEntityImpl <em>Business Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.BusinessEntityImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getBusinessEntity()
	 * @generated
	 */
	int BUSINESS_ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__ATTRIBUTES = 1;

	/**
	 * The feature id for the '<em><b>Contracts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__CONTRACTS = 2;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__ASSOCIATIONS = 3;

	/**
	 * The feature id for the '<em><b>Is Authenticable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__IS_AUTHENTICABLE = 4;

	/**
	 * The number of structural features of the '<em>Business Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Business Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.AttributeImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_REQUIRED = 2;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_DEFAULT = 3;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.AssociationImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 3;

	/**
	 * The feature id for the '<em><b>Associated Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ASSOCIATED_ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.SimpleImpl <em>Simple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.SimpleImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getSimple()
	 * @generated
	 */
	int SIMPLE = 4;

	/**
	 * The feature id for the '<em><b>Associated Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE__ASSOCIATED_ENTITY = ASSOCIATION__ASSOCIATED_ENTITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE__NAME = ASSOCIATION__NAME;

	/**
	 * The feature id for the '<em><b>Related Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE__RELATED_ENTITY = ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FEATURE_COUNT = ASSOCIATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_OPERATION_COUNT = ASSOCIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.MultipleImpl <em>Multiple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.MultipleImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getMultiple()
	 * @generated
	 */
	int MULTIPLE = 5;

	/**
	 * The feature id for the '<em><b>Associated Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE__ASSOCIATED_ENTITY = ASSOCIATION__ASSOCIATED_ENTITY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE__NAME = ASSOCIATION__NAME;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE__ENTITY = ASSOCIATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Multiple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_FEATURE_COUNT = ASSOCIATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Multiple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLE_OPERATION_COUNT = ASSOCIATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.ContractsImpl <em>Contracts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.ContractsImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getContracts()
	 * @generated
	 */
	int CONTRACTS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACTS__NAME = 0;

	/**
	 * The number of structural features of the '<em>Contracts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Contracts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.CreateImpl <em>Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.CreateImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getCreate()
	 * @generated
	 */
	int CREATE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE__NAME = CONTRACTS__NAME;

	/**
	 * The number of structural features of the '<em>Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_FEATURE_COUNT = CONTRACTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OPERATION_COUNT = CONTRACTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.UpdateImpl <em>Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.UpdateImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getUpdate()
	 * @generated
	 */
	int UPDATE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE__NAME = CONTRACTS__NAME;

	/**
	 * The number of structural features of the '<em>Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_FEATURE_COUNT = CONTRACTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Update</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPDATE_OPERATION_COUNT = CONTRACTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.RetrieveImpl <em>Retrieve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.RetrieveImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getRetrieve()
	 * @generated
	 */
	int RETRIEVE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETRIEVE__NAME = CONTRACTS__NAME;

	/**
	 * The number of structural features of the '<em>Retrieve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETRIEVE_FEATURE_COUNT = CONTRACTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Retrieve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETRIEVE_OPERATION_COUNT = CONTRACTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.DeleteImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getDelete()
	 * @generated
	 */
	int DELETE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE__NAME = CONTRACTS__NAME;

	/**
	 * The number of structural features of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FEATURE_COUNT = CONTRACTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Delete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_OPERATION_COUNT = CONTRACTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.ListAllImpl <em>List All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.ListAllImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getListAll()
	 * @generated
	 */
	int LIST_ALL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ALL__NAME = CONTRACTS__NAME;

	/**
	 * The number of structural features of the '<em>List All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ALL_FEATURE_COUNT = CONTRACTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>List All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ALL_OPERATION_COUNT = CONTRACTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.AuthenticateImpl <em>Authenticate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.AuthenticateImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAuthenticate()
	 * @generated
	 */
	int AUTHENTICATE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATE__NAME = CONTRACTS__NAME;

	/**
	 * The number of structural features of the '<em>Authenticate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATE_FEATURE_COUNT = CONTRACTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Authenticate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHENTICATE_OPERATION_COUNT = CONTRACTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.ContractElementsImpl <em>Contract Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.ContractElementsImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getContractElements()
	 * @generated
	 */
	int CONTRACT_ELEMENTS = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_ELEMENTS__NAME = CONTRACTS__NAME;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_ELEMENTS__ASSOCIATION = CONTRACTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contract Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_ELEMENTS_FEATURE_COUNT = CONTRACTS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Contract Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRACT_ELEMENTS_OPERATION_COUNT = CONTRACTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.ListElementsImpl <em>List Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.ListElementsImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getListElements()
	 * @generated
	 */
	int LIST_ELEMENTS = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ELEMENTS__NAME = CONTRACT_ELEMENTS__NAME;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ELEMENTS__ASSOCIATION = CONTRACT_ELEMENTS__ASSOCIATION;

	/**
	 * The number of structural features of the '<em>List Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ELEMENTS_FEATURE_COUNT = CONTRACT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>List Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_ELEMENTS_OPERATION_COUNT = CONTRACT_ELEMENTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.AddElementImpl <em>Add Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.AddElementImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAddElement()
	 * @generated
	 */
	int ADD_ELEMENT = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ELEMENT__NAME = CONTRACT_ELEMENTS__NAME;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ELEMENT__ASSOCIATION = CONTRACT_ELEMENTS__ASSOCIATION;

	/**
	 * The number of structural features of the '<em>Add Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ELEMENT_FEATURE_COUNT = CONTRACT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Add Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ELEMENT_OPERATION_COUNT = CONTRACT_ELEMENTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.impl.DeleteElementImpl <em>Delete Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.impl.DeleteElementImpl
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getDeleteElement()
	 * @generated
	 */
	int DELETE_ELEMENT = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ELEMENT__NAME = CONTRACT_ELEMENTS__NAME;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ELEMENT__ASSOCIATION = CONTRACT_ELEMENTS__ASSOCIATION;

	/**
	 * The number of structural features of the '<em>Delete Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ELEMENT_FEATURE_COUNT = CONTRACT_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Delete Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_ELEMENT_OPERATION_COUNT = CONTRACT_ELEMENTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link domainmetamodel.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodel.DataType
	 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 17;


	/**
	 * Returns the meta object for class '{@link domainmetamodel.Business <em>Business</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business</em>'.
	 * @see domainmetamodel.Business
	 * @generated
	 */
	EClass getBusiness();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.Business#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodel.Business#getName()
	 * @see #getBusiness()
	 * @generated
	 */
	EAttribute getBusiness_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodel.Business#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see domainmetamodel.Business#getEntities()
	 * @see #getBusiness()
	 * @generated
	 */
	EReference getBusiness_Entities();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.BusinessEntity <em>Business Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Entity</em>'.
	 * @see domainmetamodel.BusinessEntity
	 * @generated
	 */
	EClass getBusinessEntity();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.BusinessEntity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodel.BusinessEntity#getName()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EAttribute getBusinessEntity_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodel.BusinessEntity#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see domainmetamodel.BusinessEntity#getAttributes()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EReference getBusinessEntity_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodel.BusinessEntity#getContracts <em>Contracts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contracts</em>'.
	 * @see domainmetamodel.BusinessEntity#getContracts()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EReference getBusinessEntity_Contracts();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodel.BusinessEntity#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see domainmetamodel.BusinessEntity#getAssociations()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EReference getBusinessEntity_Associations();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.BusinessEntity#isIsAuthenticable <em>Is Authenticable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Authenticable</em>'.
	 * @see domainmetamodel.BusinessEntity#isIsAuthenticable()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EAttribute getBusinessEntity_IsAuthenticable();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see domainmetamodel.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodel.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.Attribute#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see domainmetamodel.Attribute#getDataType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_DataType();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.Attribute#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see domainmetamodel.Attribute#isIsRequired()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_IsRequired();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.Attribute#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see domainmetamodel.Attribute#isIsDefault()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_IsDefault();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see domainmetamodel.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the reference '{@link domainmetamodel.Association#getAssociatedEntity <em>Associated Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Entity</em>'.
	 * @see domainmetamodel.Association#getAssociatedEntity()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_AssociatedEntity();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.Association#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodel.Association#getName()
	 * @see #getAssociation()
	 * @generated
	 */
	EAttribute getAssociation_Name();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Simple <em>Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple</em>'.
	 * @see domainmetamodel.Simple
	 * @generated
	 */
	EClass getSimple();

	/**
	 * Returns the meta object for the reference '{@link domainmetamodel.Simple#getRelatedEntity <em>Related Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Entity</em>'.
	 * @see domainmetamodel.Simple#getRelatedEntity()
	 * @see #getSimple()
	 * @generated
	 */
	EReference getSimple_RelatedEntity();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Multiple <em>Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple</em>'.
	 * @see domainmetamodel.Multiple
	 * @generated
	 */
	EClass getMultiple();

	/**
	 * Returns the meta object for the reference '{@link domainmetamodel.Multiple#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see domainmetamodel.Multiple#getEntity()
	 * @see #getMultiple()
	 * @generated
	 */
	EReference getMultiple_Entity();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Contracts <em>Contracts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contracts</em>'.
	 * @see domainmetamodel.Contracts
	 * @generated
	 */
	EClass getContracts();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodel.Contracts#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodel.Contracts#getName()
	 * @see #getContracts()
	 * @generated
	 */
	EAttribute getContracts_Name();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Create <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create</em>'.
	 * @see domainmetamodel.Create
	 * @generated
	 */
	EClass getCreate();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Update <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update</em>'.
	 * @see domainmetamodel.Update
	 * @generated
	 */
	EClass getUpdate();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Retrieve <em>Retrieve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Retrieve</em>'.
	 * @see domainmetamodel.Retrieve
	 * @generated
	 */
	EClass getRetrieve();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see domainmetamodel.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.ListAll <em>List All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List All</em>'.
	 * @see domainmetamodel.ListAll
	 * @generated
	 */
	EClass getListAll();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.Authenticate <em>Authenticate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Authenticate</em>'.
	 * @see domainmetamodel.Authenticate
	 * @generated
	 */
	EClass getAuthenticate();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.ContractElements <em>Contract Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contract Elements</em>'.
	 * @see domainmetamodel.ContractElements
	 * @generated
	 */
	EClass getContractElements();

	/**
	 * Returns the meta object for the reference '{@link domainmetamodel.ContractElements#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see domainmetamodel.ContractElements#getAssociation()
	 * @see #getContractElements()
	 * @generated
	 */
	EReference getContractElements_Association();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.ListElements <em>List Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Elements</em>'.
	 * @see domainmetamodel.ListElements
	 * @generated
	 */
	EClass getListElements();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.AddElement <em>Add Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Element</em>'.
	 * @see domainmetamodel.AddElement
	 * @generated
	 */
	EClass getAddElement();

	/**
	 * Returns the meta object for class '{@link domainmetamodel.DeleteElement <em>Delete Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Element</em>'.
	 * @see domainmetamodel.DeleteElement
	 * @generated
	 */
	EClass getDeleteElement();

	/**
	 * Returns the meta object for enum '{@link domainmetamodel.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see domainmetamodel.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomainmetamodelFactory getDomainmetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.BusinessImpl <em>Business</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.BusinessImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getBusiness()
		 * @generated
		 */
		EClass BUSINESS = eINSTANCE.getBusiness();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS__NAME = eINSTANCE.getBusiness_Name();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS__ENTITIES = eINSTANCE.getBusiness_Entities();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.BusinessEntityImpl <em>Business Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.BusinessEntityImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getBusinessEntity()
		 * @generated
		 */
		EClass BUSINESS_ENTITY = eINSTANCE.getBusinessEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_ENTITY__NAME = eINSTANCE.getBusinessEntity_Name();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_ENTITY__ATTRIBUTES = eINSTANCE.getBusinessEntity_Attributes();

		/**
		 * The meta object literal for the '<em><b>Contracts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_ENTITY__CONTRACTS = eINSTANCE.getBusinessEntity_Contracts();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_ENTITY__ASSOCIATIONS = eINSTANCE.getBusinessEntity_Associations();

		/**
		 * The meta object literal for the '<em><b>Is Authenticable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_ENTITY__IS_AUTHENTICABLE = eINSTANCE.getBusinessEntity_IsAuthenticable();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.AttributeImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAttribute()
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
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__DATA_TYPE = eINSTANCE.getAttribute_DataType();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__IS_REQUIRED = eINSTANCE.getAttribute_IsRequired();

		/**
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__IS_DEFAULT = eINSTANCE.getAttribute_IsDefault();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.AssociationImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Associated Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__ASSOCIATED_ENTITY = eINSTANCE.getAssociation_AssociatedEntity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION__NAME = eINSTANCE.getAssociation_Name();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.SimpleImpl <em>Simple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.SimpleImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getSimple()
		 * @generated
		 */
		EClass SIMPLE = eINSTANCE.getSimple();

		/**
		 * The meta object literal for the '<em><b>Related Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE__RELATED_ENTITY = eINSTANCE.getSimple_RelatedEntity();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.MultipleImpl <em>Multiple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.MultipleImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getMultiple()
		 * @generated
		 */
		EClass MULTIPLE = eINSTANCE.getMultiple();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLE__ENTITY = eINSTANCE.getMultiple_Entity();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.ContractsImpl <em>Contracts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.ContractsImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getContracts()
		 * @generated
		 */
		EClass CONTRACTS = eINSTANCE.getContracts();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRACTS__NAME = eINSTANCE.getContracts_Name();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.CreateImpl <em>Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.CreateImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getCreate()
		 * @generated
		 */
		EClass CREATE = eINSTANCE.getCreate();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.UpdateImpl <em>Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.UpdateImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getUpdate()
		 * @generated
		 */
		EClass UPDATE = eINSTANCE.getUpdate();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.RetrieveImpl <em>Retrieve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.RetrieveImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getRetrieve()
		 * @generated
		 */
		EClass RETRIEVE = eINSTANCE.getRetrieve();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.DeleteImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getDelete()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDelete();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.ListAllImpl <em>List All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.ListAllImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getListAll()
		 * @generated
		 */
		EClass LIST_ALL = eINSTANCE.getListAll();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.AuthenticateImpl <em>Authenticate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.AuthenticateImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAuthenticate()
		 * @generated
		 */
		EClass AUTHENTICATE = eINSTANCE.getAuthenticate();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.ContractElementsImpl <em>Contract Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.ContractElementsImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getContractElements()
		 * @generated
		 */
		EClass CONTRACT_ELEMENTS = eINSTANCE.getContractElements();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRACT_ELEMENTS__ASSOCIATION = eINSTANCE.getContractElements_Association();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.ListElementsImpl <em>List Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.ListElementsImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getListElements()
		 * @generated
		 */
		EClass LIST_ELEMENTS = eINSTANCE.getListElements();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.AddElementImpl <em>Add Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.AddElementImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getAddElement()
		 * @generated
		 */
		EClass ADD_ELEMENT = eINSTANCE.getAddElement();

		/**
		 * The meta object literal for the '{@link domainmetamodel.impl.DeleteElementImpl <em>Delete Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.impl.DeleteElementImpl
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getDeleteElement()
		 * @generated
		 */
		EClass DELETE_ELEMENT = eINSTANCE.getDeleteElement();

		/**
		 * The meta object literal for the '{@link domainmetamodel.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodel.DataType
		 * @see domainmetamodel.impl.DomainmetamodelPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

	}

} //DomainmetamodelPackage
