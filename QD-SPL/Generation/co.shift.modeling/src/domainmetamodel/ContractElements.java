/**
 */
package domainmetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodel.ContractElements#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodel.DomainmetamodelPackage#getContractElements()
 * @model abstract="true"
 * @generated
 */
public interface ContractElements extends Contracts {
	/**
	 * Returns the value of the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' reference.
	 * @see #setAssociation(Multiple)
	 * @see domainmetamodel.DomainmetamodelPackage#getContractElements_Association()
	 * @model required="true"
	 * @generated
	 */
	Multiple getAssociation();

	/**
	 * Sets the value of the '{@link domainmetamodel.ContractElements#getAssociation <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(Multiple value);

} // ContractElements
