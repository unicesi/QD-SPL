/**
 */
package problemSpaceMetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link problemSpaceMetamodel.ProblemSpace#getName <em>Name</em>}</li>
 *   <li>{@link problemSpaceMetamodel.ProblemSpace#getEntity <em>Entity</em>}</li>
 * </ul>
 *
 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage#getProblemSpace()
 * @model
 * @generated
 */
public interface ProblemSpace extends EObject {
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
	 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage#getProblemSpace_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link problemSpaceMetamodel.ProblemSpace#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Entity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' containment reference.
	 * @see #setEntity(Entity)
	 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage#getProblemSpace_Entity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Entity getEntity();

	/**
	 * Sets the value of the '{@link problemSpaceMetamodel.ProblemSpace#getEntity <em>Entity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' containment reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity value);

} // ProblemSpace
