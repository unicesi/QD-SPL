/**
 */
package applicabilitymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applicability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.Applicability#getValue <em>Value</em>}</li>
 *   <li>{@link applicabilitymodel.Applicability#getQualityScenario <em>Quality Scenario</em>}</li>
 *   <li>{@link applicabilitymodel.Applicability#getComponentSets <em>Component Sets</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicability()
 * @model
 * @generated
 */
public interface Applicability extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicability_Value()
	 * @model
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link applicabilitymodel.Applicability#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Returns the value of the '<em><b>Quality Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Scenario</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Scenario</em>' containment reference.
	 * @see #setQualityScenario(QualityScenario)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicability_QualityScenario()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QualityScenario getQualityScenario();

	/**
	 * Sets the value of the '{@link applicabilitymodel.Applicability#getQualityScenario <em>Quality Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Scenario</em>' containment reference.
	 * @see #getQualityScenario()
	 * @generated
	 */
	void setQualityScenario(QualityScenario value);

	/**
	 * Returns the value of the '<em><b>Component Sets</b></em>' containment reference list.
	 * The list contents are of type {@link applicabilitymodel.ComponentSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Sets</em>' containment reference list.
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicability_ComponentSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentSet> getComponentSets();

} // Applicability
