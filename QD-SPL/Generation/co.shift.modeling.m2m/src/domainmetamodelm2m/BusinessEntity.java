/**
 */
package domainmetamodelm2m;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodelm2m.BusinessEntity#getName <em>Name</em>}</li>
 *   <li>{@link domainmetamodelm2m.BusinessEntity#isIsAuthenticable <em>Is Authenticable</em>}</li>
 *   <li>{@link domainmetamodelm2m.BusinessEntity#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link domainmetamodelm2m.BusinessEntity#getAssociations <em>Associations</em>}</li>
 *   <li>{@link domainmetamodelm2m.BusinessEntity#getContracts <em>Contracts</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusinessEntity()
 * @model
 * @generated
 */
public interface BusinessEntity extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusinessEntity_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link domainmetamodelm2m.BusinessEntity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Authenticable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Authenticable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Authenticable</em>' attribute.
	 * @see #setIsAuthenticable(boolean)
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusinessEntity_IsAuthenticable()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsAuthenticable();

	/**
	 * Sets the value of the '{@link domainmetamodelm2m.BusinessEntity#isIsAuthenticable <em>Is Authenticable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Authenticable</em>' attribute.
	 * @see #isIsAuthenticable()
	 * @generated
	 */
	void setIsAuthenticable(boolean value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodelm2m.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusinessEntity_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodelm2m.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusinessEntity_Associations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Association> getAssociations();

	/**
	 * Returns the value of the '<em><b>Contracts</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodelm2m.Contracts}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contracts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contracts</em>' containment reference list.
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusinessEntity_Contracts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Contracts> getContracts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" bRequired="true"
	 * @generated
	 */
	boolean needsDAO(Business b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model bRequired="true" daoRequired="true"
	 * @generated
	 */
	void createDAO(Business b, EModelElement dao);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model bRequired="true" entityRequired="true"
	 * @generated
	 */
	void createEntity(Business b, EModelElement entity);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model bRequired="true" boundaryRequired="true"
	 * @generated
	 */
	void createBoundary(Business b, EModelElement boundary);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAuthenticable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true" bRequired="true"
	 * @generated
	 */
	void configureMediumTE(EModelElement pack, Business b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true" bRequired="true"
	 * @generated
	 */
	void updateBoundaryAttributes(EModelElement pack, Business b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true" bRequired="true"
	 * @generated
	 */
	void configureSyncTE(EModelElement pack, Business b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true" bRequired="true"
	 * @generated
	 */
	void configureAsyncTE(EModelElement pack, Business b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true" bRequired="true"
	 * @generated
	 */
	void configureLockoutManager(EModelElement pack, Business b);

} // BusinessEntity
