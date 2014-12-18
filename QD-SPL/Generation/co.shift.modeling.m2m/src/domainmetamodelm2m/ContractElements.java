/**
 */
package domainmetamodelm2m;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contract Elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodelm2m.ContractElements#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getContractElements()
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
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getContractElements_Association()
	 * @model required="true"
	 * @generated
	 */
	Multiple getAssociation();

	/**
	 * Sets the value of the '{@link domainmetamodelm2m.ContractElements#getAssociation <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(Multiple value);

} // ContractElements
