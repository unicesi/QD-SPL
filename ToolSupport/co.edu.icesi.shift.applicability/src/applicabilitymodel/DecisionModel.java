/**
 */
package applicabilitymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.DecisionModel#getDecisionModelName <em>Decision Model Name</em>}</li>
 *   <li>{@link applicabilitymodel.DecisionModel#getDecisions <em>Decisions</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecisionModel()
 * @model
 * @generated
 */
public interface DecisionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Decision Model Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decision Model Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decision Model Name</em>' attribute.
	 * @see #setDecisionModelName(String)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecisionModel_DecisionModelName()
	 * @model
	 * @generated
	 */
	String getDecisionModelName();

	/**
	 * Sets the value of the '{@link applicabilitymodel.DecisionModel#getDecisionModelName <em>Decision Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decision Model Name</em>' attribute.
	 * @see #getDecisionModelName()
	 * @generated
	 */
	void setDecisionModelName(String value);

	/**
	 * Returns the value of the '<em><b>Decisions</b></em>' containment reference list.
	 * The list contents are of type {@link applicabilitymodel.Decision}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decisions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decisions</em>' containment reference list.
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecisionModel_Decisions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Decision> getDecisions();

} // DecisionModel
