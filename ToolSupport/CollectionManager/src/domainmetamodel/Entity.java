/**
 */
package domainmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link domainmetamodel.Entity#getName <em>Name</em>}</li>
 *   <li>{@link domainmetamodel.Entity#getCharacteristic <em>Characteristic</em>}</li>
 * </ul>
 *
 * @see domainmetamodel.DomainmetamodelPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends EObject {
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
	 * @see domainmetamodel.DomainmetamodelPackage#getEntity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link domainmetamodel.Entity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Characteristic</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodel.Characteristic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characteristic</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristic</em>' containment reference list.
	 * @see domainmetamodel.DomainmetamodelPackage#getEntity_Characteristic()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Characteristic> getCharacteristic();

} // Entity
