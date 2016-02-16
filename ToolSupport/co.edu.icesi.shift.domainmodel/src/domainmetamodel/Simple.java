/**
 */
package domainmetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodel.Simple#getRelatedEntity <em>Related Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodel.DomainmetamodelPackage#getSimple()
 * @model
 * @generated
 */
public interface Simple extends Association {
	/**
	 * Returns the value of the '<em><b>Related Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Entity</em>' reference.
	 * @see #setRelatedEntity(BusinessEntity)
	 * @see domainmetamodel.DomainmetamodelPackage#getSimple_RelatedEntity()
	 * @model required="true"
	 * @generated
	 */
	BusinessEntity getRelatedEntity();

	/**
	 * Sets the value of the '{@link domainmetamodel.Simple#getRelatedEntity <em>Related Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Related Entity</em>' reference.
	 * @see #getRelatedEntity()
	 * @generated
	 */
	void setRelatedEntity(BusinessEntity value);

} // Simple
