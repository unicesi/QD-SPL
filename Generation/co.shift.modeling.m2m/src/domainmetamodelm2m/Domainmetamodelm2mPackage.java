/**
 */
package domainmetamodelm2m;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see domainmetamodelm2m.Domainmetamodelm2mFactory
 * @model kind="package"
 * @generated
 */
public interface Domainmetamodelm2mPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "domainmetamodelm2m";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://domainmetamodelm2m/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "domainmetamodelm2m";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Domainmetamodelm2mPackage eINSTANCE = domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl.init();

	/**
	 * The meta object id for the '{@link domainmetamodelm2m.impl.BusinessImpl <em>Business</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.BusinessImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getBusiness()
	 * @generated
	 */
	int BUSINESS = 0;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS__ENTITIES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS__NAME = 1;

	/**
	 * The number of structural features of the '<em>Business</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Is QA Selected</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS___IS_QA_SELECTED__STRING = 0;

	/**
	 * The operation id for the '<em>Create Crypt Manager</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS___CREATE_CRYPT_MANAGER__EMODELELEMENT = 1;

	/**
	 * The operation id for the '<em>Create Authorization Boundary</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS___CREATE_AUTHORIZATION_BOUNDARY__EMODELELEMENT = 2;

	/**
	 * The operation id for the '<em>Create Authorization Entities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS___CREATE_AUTHORIZATION_ENTITIES__EMODELELEMENT = 3;

	/**
	 * The number of operations of the '<em>Business</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_OPERATION_COUNT = 4;


	/**
	 * The meta object id for the '{@link domainmetamodelm2m.impl.BusinessEntityImpl <em>Business Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.BusinessEntityImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getBusinessEntity()
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
	 * The feature id for the '<em><b>Is Authenticable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__IS_AUTHENTICABLE = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__ATTRIBUTES = 2;

	/**
	 * The feature id for the '<em><b>Associations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__ASSOCIATIONS = 3;

	/**
	 * The feature id for the '<em><b>Contracts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY__CONTRACTS = 4;

	/**
	 * The number of structural features of the '<em>Business Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Needs DAO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___NEEDS_DAO__BUSINESS = 0;

	/**
	 * The operation id for the '<em>Create DAO</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___CREATE_DAO__BUSINESS_EMODELELEMENT = 1;

	/**
	 * The operation id for the '<em>Create Entity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___CREATE_ENTITY__BUSINESS_EMODELELEMENT = 2;

	/**
	 * The operation id for the '<em>Create Boundary</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___CREATE_BOUNDARY__BUSINESS_EMODELELEMENT = 3;

	/**
	 * The operation id for the '<em>Is Authenticable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___IS_AUTHENTICABLE = 4;

	/**
	 * The operation id for the '<em>Configure Medium TE</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___CONFIGURE_MEDIUM_TE__EMODELELEMENT_BUSINESS = 5;

	/**
	 * The operation id for the '<em>Update Boundary Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___UPDATE_BOUNDARY_ATTRIBUTES__EMODELELEMENT_BUSINESS = 6;

	/**
	 * The operation id for the '<em>Configure Sync TE</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___CONFIGURE_SYNC_TE__EMODELELEMENT_BUSINESS = 7;

	/**
	 * The operation id for the '<em>Configure Async TE</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___CONFIGURE_ASYNC_TE__EMODELELEMENT_BUSINESS = 8;

	/**
	 * The operation id for the '<em>Configure Lockout Manager</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY___CONFIGURE_LOCKOUT_MANAGER__EMODELELEMENT_BUSINESS = 9;

	/**
	 * The number of operations of the '<em>Business Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_ENTITY_OPERATION_COUNT = 10;

	/**
	 * The meta object id for the '{@link domainmetamodelm2m.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.AttributeImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getAttribute()
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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.AssociationImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link domainmetamodelm2m.impl.SimpleImpl <em>Simple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.SimpleImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getSimple()
	 * @generated
	 */
	int SIMPLE = 4;

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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.MultipleImpl <em>Multiple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.MultipleImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getMultiple()
	 * @generated
	 */
	int MULTIPLE = 5;

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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.ContractsImpl <em>Contracts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.ContractsImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getContracts()
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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.CreateImpl <em>Create</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.CreateImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getCreate()
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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.UpdateImpl <em>Update</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.UpdateImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getUpdate()
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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.RetrieveImpl <em>Retrieve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.RetrieveImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getRetrieve()
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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.DeleteImpl <em>Delete</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.DeleteImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getDelete()
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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.ListAllImpl <em>List All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.ListAllImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getListAll()
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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.ContractElementsImpl <em>Contract Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.ContractElementsImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getContractElements()
	 * @generated
	 */
	int CONTRACT_ELEMENTS = 12;

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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.ListElementsImpl <em>List Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.ListElementsImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getListElements()
	 * @generated
	 */
	int LIST_ELEMENTS = 13;

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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.AddElementImpl <em>Add Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.AddElementImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getAddElement()
	 * @generated
	 */
	int ADD_ELEMENT = 14;

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
	 * The meta object id for the '{@link domainmetamodelm2m.impl.DeleteElementImpl <em>Delete Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.impl.DeleteElementImpl
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getDeleteElement()
	 * @generated
	 */
	int DELETE_ELEMENT = 15;

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
	 * The meta object id for the '{@link domainmetamodelm2m.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see domainmetamodelm2m.DataType
	 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 16;


	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Business <em>Business</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business</em>'.
	 * @see domainmetamodelm2m.Business
	 * @generated
	 */
	EClass getBusiness();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodelm2m.Business#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see domainmetamodelm2m.Business#getEntities()
	 * @see #getBusiness()
	 * @generated
	 */
	EReference getBusiness_Entities();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.Business#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodelm2m.Business#getName()
	 * @see #getBusiness()
	 * @generated
	 */
	EAttribute getBusiness_Name();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.Business#isQASelected(java.lang.String) <em>Is QA Selected</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is QA Selected</em>' operation.
	 * @see domainmetamodelm2m.Business#isQASelected(java.lang.String)
	 * @generated
	 */
	EOperation getBusiness__IsQASelected__String();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.Business#createCryptManager(org.eclipse.emf.ecore.EModelElement) <em>Create Crypt Manager</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Crypt Manager</em>' operation.
	 * @see domainmetamodelm2m.Business#createCryptManager(org.eclipse.emf.ecore.EModelElement)
	 * @generated
	 */
	EOperation getBusiness__CreateCryptManager__EModelElement();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.Business#createAuthorizationBoundary(org.eclipse.emf.ecore.EModelElement) <em>Create Authorization Boundary</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Authorization Boundary</em>' operation.
	 * @see domainmetamodelm2m.Business#createAuthorizationBoundary(org.eclipse.emf.ecore.EModelElement)
	 * @generated
	 */
	EOperation getBusiness__CreateAuthorizationBoundary__EModelElement();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.Business#createAuthorizationEntities(org.eclipse.emf.ecore.EModelElement) <em>Create Authorization Entities</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Authorization Entities</em>' operation.
	 * @see domainmetamodelm2m.Business#createAuthorizationEntities(org.eclipse.emf.ecore.EModelElement)
	 * @generated
	 */
	EOperation getBusiness__CreateAuthorizationEntities__EModelElement();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.BusinessEntity <em>Business Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Entity</em>'.
	 * @see domainmetamodelm2m.BusinessEntity
	 * @generated
	 */
	EClass getBusinessEntity();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.BusinessEntity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodelm2m.BusinessEntity#getName()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EAttribute getBusinessEntity_Name();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.BusinessEntity#isIsAuthenticable <em>Is Authenticable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Authenticable</em>'.
	 * @see domainmetamodelm2m.BusinessEntity#isIsAuthenticable()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EAttribute getBusinessEntity_IsAuthenticable();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodelm2m.BusinessEntity#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see domainmetamodelm2m.BusinessEntity#getAttributes()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EReference getBusinessEntity_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodelm2m.BusinessEntity#getAssociations <em>Associations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Associations</em>'.
	 * @see domainmetamodelm2m.BusinessEntity#getAssociations()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EReference getBusinessEntity_Associations();

	/**
	 * Returns the meta object for the containment reference list '{@link domainmetamodelm2m.BusinessEntity#getContracts <em>Contracts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contracts</em>'.
	 * @see domainmetamodelm2m.BusinessEntity#getContracts()
	 * @see #getBusinessEntity()
	 * @generated
	 */
	EReference getBusinessEntity_Contracts();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#needsDAO(domainmetamodelm2m.Business) <em>Needs DAO</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Needs DAO</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#needsDAO(domainmetamodelm2m.Business)
	 * @generated
	 */
	EOperation getBusinessEntity__NeedsDAO__Business();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#createDAO(domainmetamodelm2m.Business, org.eclipse.emf.ecore.EModelElement) <em>Create DAO</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create DAO</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#createDAO(domainmetamodelm2m.Business, org.eclipse.emf.ecore.EModelElement)
	 * @generated
	 */
	EOperation getBusinessEntity__CreateDAO__Business_EModelElement();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#createEntity(domainmetamodelm2m.Business, org.eclipse.emf.ecore.EModelElement) <em>Create Entity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Entity</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#createEntity(domainmetamodelm2m.Business, org.eclipse.emf.ecore.EModelElement)
	 * @generated
	 */
	EOperation getBusinessEntity__CreateEntity__Business_EModelElement();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#createBoundary(domainmetamodelm2m.Business, org.eclipse.emf.ecore.EModelElement) <em>Create Boundary</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Create Boundary</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#createBoundary(domainmetamodelm2m.Business, org.eclipse.emf.ecore.EModelElement)
	 * @generated
	 */
	EOperation getBusinessEntity__CreateBoundary__Business_EModelElement();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#isAuthenticable() <em>Is Authenticable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Authenticable</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#isAuthenticable()
	 * @generated
	 */
	EOperation getBusinessEntity__IsAuthenticable();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#configureMediumTE(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business) <em>Configure Medium TE</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Configure Medium TE</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#configureMediumTE(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business)
	 * @generated
	 */
	EOperation getBusinessEntity__ConfigureMediumTE__EModelElement_Business();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#updateBoundaryAttributes(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business) <em>Update Boundary Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Update Boundary Attributes</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#updateBoundaryAttributes(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business)
	 * @generated
	 */
	EOperation getBusinessEntity__UpdateBoundaryAttributes__EModelElement_Business();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#configureSyncTE(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business) <em>Configure Sync TE</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Configure Sync TE</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#configureSyncTE(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business)
	 * @generated
	 */
	EOperation getBusinessEntity__ConfigureSyncTE__EModelElement_Business();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#configureAsyncTE(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business) <em>Configure Async TE</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Configure Async TE</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#configureAsyncTE(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business)
	 * @generated
	 */
	EOperation getBusinessEntity__ConfigureAsyncTE__EModelElement_Business();

	/**
	 * Returns the meta object for the '{@link domainmetamodelm2m.BusinessEntity#configureLockoutManager(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business) <em>Configure Lockout Manager</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Configure Lockout Manager</em>' operation.
	 * @see domainmetamodelm2m.BusinessEntity#configureLockoutManager(org.eclipse.emf.ecore.EModelElement, domainmetamodelm2m.Business)
	 * @generated
	 */
	EOperation getBusinessEntity__ConfigureLockoutManager__EModelElement_Business();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see domainmetamodelm2m.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodelm2m.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.Attribute#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see domainmetamodelm2m.Attribute#getDataType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_DataType();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.Attribute#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see domainmetamodelm2m.Attribute#isIsRequired()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_IsRequired();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.Attribute#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see domainmetamodelm2m.Attribute#isIsDefault()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_IsDefault();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see domainmetamodelm2m.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.Association#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodelm2m.Association#getName()
	 * @see #getAssociation()
	 * @generated
	 */
	EAttribute getAssociation_Name();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Simple <em>Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple</em>'.
	 * @see domainmetamodelm2m.Simple
	 * @generated
	 */
	EClass getSimple();

	/**
	 * Returns the meta object for the reference '{@link domainmetamodelm2m.Simple#getRelatedEntity <em>Related Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Related Entity</em>'.
	 * @see domainmetamodelm2m.Simple#getRelatedEntity()
	 * @see #getSimple()
	 * @generated
	 */
	EReference getSimple_RelatedEntity();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Multiple <em>Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiple</em>'.
	 * @see domainmetamodelm2m.Multiple
	 * @generated
	 */
	EClass getMultiple();

	/**
	 * Returns the meta object for the reference '{@link domainmetamodelm2m.Multiple#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see domainmetamodelm2m.Multiple#getEntity()
	 * @see #getMultiple()
	 * @generated
	 */
	EReference getMultiple_Entity();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Contracts <em>Contracts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contracts</em>'.
	 * @see domainmetamodelm2m.Contracts
	 * @generated
	 */
	EClass getContracts();

	/**
	 * Returns the meta object for the attribute '{@link domainmetamodelm2m.Contracts#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see domainmetamodelm2m.Contracts#getName()
	 * @see #getContracts()
	 * @generated
	 */
	EAttribute getContracts_Name();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Create <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create</em>'.
	 * @see domainmetamodelm2m.Create
	 * @generated
	 */
	EClass getCreate();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Update <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Update</em>'.
	 * @see domainmetamodelm2m.Update
	 * @generated
	 */
	EClass getUpdate();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Retrieve <em>Retrieve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Retrieve</em>'.
	 * @see domainmetamodelm2m.Retrieve
	 * @generated
	 */
	EClass getRetrieve();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete</em>'.
	 * @see domainmetamodelm2m.Delete
	 * @generated
	 */
	EClass getDelete();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.ListAll <em>List All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List All</em>'.
	 * @see domainmetamodelm2m.ListAll
	 * @generated
	 */
	EClass getListAll();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.ContractElements <em>Contract Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contract Elements</em>'.
	 * @see domainmetamodelm2m.ContractElements
	 * @generated
	 */
	EClass getContractElements();

	/**
	 * Returns the meta object for the reference '{@link domainmetamodelm2m.ContractElements#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see domainmetamodelm2m.ContractElements#getAssociation()
	 * @see #getContractElements()
	 * @generated
	 */
	EReference getContractElements_Association();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.ListElements <em>List Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Elements</em>'.
	 * @see domainmetamodelm2m.ListElements
	 * @generated
	 */
	EClass getListElements();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.AddElement <em>Add Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Element</em>'.
	 * @see domainmetamodelm2m.AddElement
	 * @generated
	 */
	EClass getAddElement();

	/**
	 * Returns the meta object for class '{@link domainmetamodelm2m.DeleteElement <em>Delete Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete Element</em>'.
	 * @see domainmetamodelm2m.DeleteElement
	 * @generated
	 */
	EClass getDeleteElement();

	/**
	 * Returns the meta object for enum '{@link domainmetamodelm2m.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see domainmetamodelm2m.DataType
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
	Domainmetamodelm2mFactory getDomainmetamodelm2mFactory();

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
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.BusinessImpl <em>Business</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.BusinessImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getBusiness()
		 * @generated
		 */
		EClass BUSINESS = eINSTANCE.getBusiness();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS__ENTITIES = eINSTANCE.getBusiness_Entities();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS__NAME = eINSTANCE.getBusiness_Name();

		/**
		 * The meta object literal for the '<em><b>Is QA Selected</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS___IS_QA_SELECTED__STRING = eINSTANCE.getBusiness__IsQASelected__String();

		/**
		 * The meta object literal for the '<em><b>Create Crypt Manager</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS___CREATE_CRYPT_MANAGER__EMODELELEMENT = eINSTANCE.getBusiness__CreateCryptManager__EModelElement();

		/**
		 * The meta object literal for the '<em><b>Create Authorization Boundary</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS___CREATE_AUTHORIZATION_BOUNDARY__EMODELELEMENT = eINSTANCE.getBusiness__CreateAuthorizationBoundary__EModelElement();

		/**
		 * The meta object literal for the '<em><b>Create Authorization Entities</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS___CREATE_AUTHORIZATION_ENTITIES__EMODELELEMENT = eINSTANCE.getBusiness__CreateAuthorizationEntities__EModelElement();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.BusinessEntityImpl <em>Business Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.BusinessEntityImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getBusinessEntity()
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
		 * The meta object literal for the '<em><b>Is Authenticable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_ENTITY__IS_AUTHENTICABLE = eINSTANCE.getBusinessEntity_IsAuthenticable();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_ENTITY__ATTRIBUTES = eINSTANCE.getBusinessEntity_Attributes();

		/**
		 * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_ENTITY__ASSOCIATIONS = eINSTANCE.getBusinessEntity_Associations();

		/**
		 * The meta object literal for the '<em><b>Contracts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_ENTITY__CONTRACTS = eINSTANCE.getBusinessEntity_Contracts();

		/**
		 * The meta object literal for the '<em><b>Needs DAO</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___NEEDS_DAO__BUSINESS = eINSTANCE.getBusinessEntity__NeedsDAO__Business();

		/**
		 * The meta object literal for the '<em><b>Create DAO</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___CREATE_DAO__BUSINESS_EMODELELEMENT = eINSTANCE.getBusinessEntity__CreateDAO__Business_EModelElement();

		/**
		 * The meta object literal for the '<em><b>Create Entity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___CREATE_ENTITY__BUSINESS_EMODELELEMENT = eINSTANCE.getBusinessEntity__CreateEntity__Business_EModelElement();

		/**
		 * The meta object literal for the '<em><b>Create Boundary</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___CREATE_BOUNDARY__BUSINESS_EMODELELEMENT = eINSTANCE.getBusinessEntity__CreateBoundary__Business_EModelElement();

		/**
		 * The meta object literal for the '<em><b>Is Authenticable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___IS_AUTHENTICABLE = eINSTANCE.getBusinessEntity__IsAuthenticable();

		/**
		 * The meta object literal for the '<em><b>Configure Medium TE</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___CONFIGURE_MEDIUM_TE__EMODELELEMENT_BUSINESS = eINSTANCE.getBusinessEntity__ConfigureMediumTE__EModelElement_Business();

		/**
		 * The meta object literal for the '<em><b>Update Boundary Attributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___UPDATE_BOUNDARY_ATTRIBUTES__EMODELELEMENT_BUSINESS = eINSTANCE.getBusinessEntity__UpdateBoundaryAttributes__EModelElement_Business();

		/**
		 * The meta object literal for the '<em><b>Configure Sync TE</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___CONFIGURE_SYNC_TE__EMODELELEMENT_BUSINESS = eINSTANCE.getBusinessEntity__ConfigureSyncTE__EModelElement_Business();

		/**
		 * The meta object literal for the '<em><b>Configure Async TE</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___CONFIGURE_ASYNC_TE__EMODELELEMENT_BUSINESS = eINSTANCE.getBusinessEntity__ConfigureAsyncTE__EModelElement_Business();

		/**
		 * The meta object literal for the '<em><b>Configure Lockout Manager</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BUSINESS_ENTITY___CONFIGURE_LOCKOUT_MANAGER__EMODELELEMENT_BUSINESS = eINSTANCE.getBusinessEntity__ConfigureLockoutManager__EModelElement_Business();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.AttributeImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getAttribute()
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
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.AssociationImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION__NAME = eINSTANCE.getAssociation_Name();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.SimpleImpl <em>Simple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.SimpleImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getSimple()
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
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.MultipleImpl <em>Multiple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.MultipleImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getMultiple()
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
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.ContractsImpl <em>Contracts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.ContractsImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getContracts()
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
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.CreateImpl <em>Create</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.CreateImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getCreate()
		 * @generated
		 */
		EClass CREATE = eINSTANCE.getCreate();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.UpdateImpl <em>Update</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.UpdateImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getUpdate()
		 * @generated
		 */
		EClass UPDATE = eINSTANCE.getUpdate();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.RetrieveImpl <em>Retrieve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.RetrieveImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getRetrieve()
		 * @generated
		 */
		EClass RETRIEVE = eINSTANCE.getRetrieve();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.DeleteImpl <em>Delete</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.DeleteImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getDelete()
		 * @generated
		 */
		EClass DELETE = eINSTANCE.getDelete();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.ListAllImpl <em>List All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.ListAllImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getListAll()
		 * @generated
		 */
		EClass LIST_ALL = eINSTANCE.getListAll();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.ContractElementsImpl <em>Contract Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.ContractElementsImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getContractElements()
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
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.ListElementsImpl <em>List Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.ListElementsImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getListElements()
		 * @generated
		 */
		EClass LIST_ELEMENTS = eINSTANCE.getListElements();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.AddElementImpl <em>Add Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.AddElementImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getAddElement()
		 * @generated
		 */
		EClass ADD_ELEMENT = eINSTANCE.getAddElement();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.impl.DeleteElementImpl <em>Delete Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.impl.DeleteElementImpl
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getDeleteElement()
		 * @generated
		 */
		EClass DELETE_ELEMENT = eINSTANCE.getDeleteElement();

		/**
		 * The meta object literal for the '{@link domainmetamodelm2m.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see domainmetamodelm2m.DataType
		 * @see domainmetamodelm2m.impl.Domainmetamodelm2mPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

	}

} //Domainmetamodelm2mPackage
