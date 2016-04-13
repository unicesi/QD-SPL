/**
 */
package problemSpaceMetamodel;

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
 *   <li>{@link problemSpaceMetamodel.Entity#getName <em>Name</em>}</li>
 *   <li>{@link problemSpaceMetamodel.Entity#getCharacteristics <em>Characteristics</em>}</li>
 * </ul>
 *
 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage#getEntity()
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
	 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage#getEntity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link problemSpaceMetamodel.Entity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Characteristics</b></em>' containment reference list.
	 * The list contents are of type {@link problemSpaceMetamodel.Characteristic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characteristics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characteristics</em>' containment reference list.
	 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage#getEntity_Characteristics()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Characteristic> getCharacteristics();

} // Entity
