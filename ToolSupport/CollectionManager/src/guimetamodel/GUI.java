/**
 */
package guimetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GUI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link guimetamodel.GUI#getSystemName <em>System Name</em>}</li>
 *   <li>{@link guimetamodel.GUI#getName <em>Name</em>}</li>
 *   <li>{@link guimetamodel.GUI#getMainview <em>Mainview</em>}</li>
 * </ul>
 *
 * @see guimetamodel.GuimetamodelPackage#getGUI()
 * @model
 * @generated
 */
public interface GUI extends EObject {
	/**
	 * Returns the value of the '<em><b>System Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Name</em>' attribute.
	 * @see #setSystemName(String)
	 * @see guimetamodel.GuimetamodelPackage#getGUI_SystemName()
	 * @model
	 * @generated
	 */
	String getSystemName();

	/**
	 * Sets the value of the '{@link guimetamodel.GUI#getSystemName <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Name</em>' attribute.
	 * @see #getSystemName()
	 * @generated
	 */
	void setSystemName(String value);

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
	 * @see guimetamodel.GuimetamodelPackage#getGUI_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link guimetamodel.GUI#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mainview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mainview</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mainview</em>' containment reference.
	 * @see #setMainview(MainView)
	 * @see guimetamodel.GuimetamodelPackage#getGUI_Mainview()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MainView getMainview();

	/**
	 * Sets the value of the '{@link guimetamodel.GUI#getMainview <em>Mainview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mainview</em>' containment reference.
	 * @see #getMainview()
	 * @generated
	 */
	void setMainview(MainView value);

} // GUI
