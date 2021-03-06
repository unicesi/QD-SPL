/**
 */
package domainmetamodelm2m;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodelm2m.Multiple#getEntity <em>Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getMultiple()
 * @model
 * @generated
 */
public interface Multiple extends Association {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(BusinessEntity)
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getMultiple_Entity()
	 * @model required="true"
	 * @generated
	 */
	BusinessEntity getEntity();

	/**
	 * Sets the value of the '{@link domainmetamodelm2m.Multiple#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(BusinessEntity value);

} // Multiple
