/**
 */
package applicabilitymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.ComponentSet#getId <em>Id</em>}</li>
 *   <li>{@link applicabilitymodel.ComponentSet#getName <em>Name</em>}</li>
 *   <li>{@link applicabilitymodel.ComponentSet#getFilePath <em>File Path</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getComponentSet()
 * @model
 * @generated
 */
public interface ComponentSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getComponentSet_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link applicabilitymodel.ComponentSet#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getComponentSet_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link applicabilitymodel.ComponentSet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Path</em>' attribute.
	 * @see #setFilePath(String)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getComponentSet_FilePath()
	 * @model
	 * @generated
	 */
	String getFilePath();

	/**
	 * Sets the value of the '{@link applicabilitymodel.ComponentSet#getFilePath <em>File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Path</em>' attribute.
	 * @see #getFilePath()
	 * @generated
	 */
	void setFilePath(String value);

} // ComponentSet
