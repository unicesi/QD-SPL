/**
 */
package guimetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Main View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link guimetamodel.MainView#getOrderview <em>Orderview</em>}</li>
 *   <li>{@link guimetamodel.MainView#getListview <em>Listview</em>}</li>
 *   <li>{@link guimetamodel.MainView#getInfoview <em>Infoview</em>}</li>
 * </ul>
 *
 * @see guimetamodel.GuimetamodelPackage#getMainView()
 * @model
 * @generated
 */
public interface MainView extends View {
	/**
	 * Returns the value of the '<em><b>Orderview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orderview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orderview</em>' containment reference.
	 * @see #setOrderview(OrderView)
	 * @see guimetamodel.GuimetamodelPackage#getMainView_Orderview()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OrderView getOrderview();

	/**
	 * Sets the value of the '{@link guimetamodel.MainView#getOrderview <em>Orderview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orderview</em>' containment reference.
	 * @see #getOrderview()
	 * @generated
	 */
	void setOrderview(OrderView value);

	/**
	 * Returns the value of the '<em><b>Listview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Listview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Listview</em>' containment reference.
	 * @see #setListview(ListView)
	 * @see guimetamodel.GuimetamodelPackage#getMainView_Listview()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ListView getListview();

	/**
	 * Sets the value of the '{@link guimetamodel.MainView#getListview <em>Listview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listview</em>' containment reference.
	 * @see #getListview()
	 * @generated
	 */
	void setListview(ListView value);

	/**
	 * Returns the value of the '<em><b>Infoview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infoview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infoview</em>' containment reference.
	 * @see #setInfoview(InfoView)
	 * @see guimetamodel.GuimetamodelPackage#getMainView_Infoview()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InfoView getInfoview();

	/**
	 * Sets the value of the '{@link guimetamodel.MainView#getInfoview <em>Infoview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infoview</em>' containment reference.
	 * @see #getInfoview()
	 * @generated
	 */
	void setInfoview(InfoView value);

} // MainView
