/**
 */
package applicabilitymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.Decision#getName <em>Name</em>}</li>
 *   <li>{@link applicabilitymodel.Decision#getComponentSet <em>Component Set</em>}</li>
 *   <li>{@link applicabilitymodel.Decision#getRequiredVariants <em>Required Variants</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision()
 * @model
 * @generated
 */
public interface Decision extends EObject {
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
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link applicabilitymodel.Decision#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Component Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Set</em>' attribute.
	 * @see #setComponentSet(String)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision_ComponentSet()
	 * @model required="true"
	 * @generated
	 */
	String getComponentSet();

	/**
	 * Sets the value of the '{@link applicabilitymodel.Decision#getComponentSet <em>Component Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Set</em>' attribute.
	 * @see #getComponentSet()
	 * @generated
	 */
	void setComponentSet(String value);

	/**
	 * Returns the value of the '<em><b>Required Variants</b></em>' containment reference list.
	 * The list contents are of type {@link applicabilitymodel.RequiredVariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Variants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Variants</em>' containment reference list.
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision_RequiredVariants()
	 * @model containment="true"
	 * @generated
	 */
	EList<RequiredVariant> getRequiredVariants();

} // Decision
