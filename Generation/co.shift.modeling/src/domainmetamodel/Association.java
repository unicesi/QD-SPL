/**
 */
package domainmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodel.Association#getAssociatedEntity <em>Associated Entity</em>}</li>
 *   <li>{@link domainmetamodel.Association#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodel.DomainmetamodelPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends EObject {
	/**
	 * Returns the value of the '<em><b>Associated Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Entity</em>' reference.
	 * @see #setAssociatedEntity(BusinessEntity)
	 * @see domainmetamodel.DomainmetamodelPackage#getAssociation_AssociatedEntity()
	 * @model
	 * @generated
	 */
	BusinessEntity getAssociatedEntity();

	/**
	 * Sets the value of the '{@link domainmetamodel.Association#getAssociatedEntity <em>Associated Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Entity</em>' reference.
	 * @see #getAssociatedEntity()
	 * @generated
	 */
	void setAssociatedEntity(BusinessEntity value);

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
	 * @see domainmetamodel.DomainmetamodelPackage#getAssociation_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link domainmetamodel.Association#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Association
