/**
 */
package guimetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link guimetamodel.ListView#getCreateview <em>Createview</em>}</li>
 * </ul>
 *
 * @see guimetamodel.GuimetamodelPackage#getListView()
 * @model
 * @generated
 */
public interface ListView extends View {
	/**
	 * Returns the value of the '<em><b>Createview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Createview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Createview</em>' containment reference.
	 * @see #setCreateview(CreateView)
	 * @see guimetamodel.GuimetamodelPackage#getListView_Createview()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CreateView getCreateview();

	/**
	 * Sets the value of the '{@link guimetamodel.ListView#getCreateview <em>Createview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Createview</em>' containment reference.
	 * @see #getCreateview()
	 * @generated
	 */
	void setCreateview(CreateView value);

} // ListView
