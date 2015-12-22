/**
 */
package domainmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodel.BusinessEntity#getName <em>Name</em>}</li>
 *   <li>{@link domainmetamodel.BusinessEntity#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link domainmetamodel.BusinessEntity#getContracts <em>Contracts</em>}</li>
 *   <li>{@link domainmetamodel.BusinessEntity#getAssociations <em>Associations</em>}</li>
 *   <li>{@link domainmetamodel.BusinessEntity#isIsAuthenticable <em>Is Authenticable</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodel.DomainmetamodelPackage#getBusinessEntity()
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
	 * @see domainmetamodel.DomainmetamodelPackage#getBusinessEntity_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link domainmetamodel.BusinessEntity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodel.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see domainmetamodel.DomainmetamodelPackage#getBusinessEntity_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Contracts</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodel.Contracts}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contracts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contracts</em>' containment reference list.
	 * @see domainmetamodel.DomainmetamodelPackage#getBusinessEntity_Contracts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Contracts> getContracts();

	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodel.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see domainmetamodel.DomainmetamodelPackage#getBusinessEntity_Associations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Association> getAssociations();

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
	 * @see domainmetamodel.DomainmetamodelPackage#getBusinessEntity_IsAuthenticable()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsAuthenticable();

	/**
	 * Sets the value of the '{@link domainmetamodel.BusinessEntity#isIsAuthenticable <em>Is Authenticable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Authenticable</em>' attribute.
	 * @see #isIsAuthenticable()
	 * @generated
	 */
	void setIsAuthenticable(boolean value);

} // BusinessEntity
