/**
 */
package applicabilitymodel;

import componentsetsmodel.ComponentSetsModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import qasvariabilitymodel.RootQA;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.DecisionModel#getQualitymodel <em>Qualitymodel</em>}</li>
 *   <li>{@link applicabilitymodel.DecisionModel#getComponentSetsModel <em>Component Sets Model</em>}</li>
 *   <li>{@link applicabilitymodel.DecisionModel#getDecisions <em>Decisions</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecisionModel()
 * @model
 * @generated
 */
public interface DecisionModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Qualitymodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualitymodel</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualitymodel</em>' containment reference.
	 * @see #setQualitymodel(RootQA)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecisionModel_Qualitymodel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RootQA getQualitymodel();

	/**
	 * Sets the value of the '{@link applicabilitymodel.DecisionModel#getQualitymodel <em>Qualitymodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualitymodel</em>' containment reference.
	 * @see #getQualitymodel()
	 * @generated
	 */
	void setQualitymodel(RootQA value);

	/**
	 * Returns the value of the '<em><b>Component Sets Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Sets Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Sets Model</em>' containment reference.
	 * @see #setComponentSetsModel(ComponentSetsModel)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecisionModel_ComponentSetsModel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ComponentSetsModel getComponentSetsModel();

	/**
	 * Sets the value of the '{@link applicabilitymodel.DecisionModel#getComponentSetsModel <em>Component Sets Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Sets Model</em>' containment reference.
	 * @see #getComponentSetsModel()
	 * @generated
	 */
	void setComponentSetsModel(ComponentSetsModel value);

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
