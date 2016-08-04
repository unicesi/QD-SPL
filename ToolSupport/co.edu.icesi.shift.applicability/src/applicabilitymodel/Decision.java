/**
 */
package applicabilitymodel;

import componentsetsmodel.ComponentSet;

import org.eclipse.emf.ecore.EObject;

import qasvariabilitymodel.QA;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.Decision#getQaVariant <em>Qa Variant</em>}</li>
 *   <li>{@link applicabilitymodel.Decision#getComponentSet <em>Component Set</em>}</li>
 *   <li>{@link applicabilitymodel.Decision#getRequiresVariantSelected <em>Requires Variant Selected</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision()
 * @model
 * @generated
 */
public interface Decision extends EObject {
	/**
	 * Returns the value of the '<em><b>Qa Variant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qa Variant</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qa Variant</em>' containment reference.
	 * @see #setQaVariant(QA)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision_QaVariant()
	 * @model containment="true" required="true"
	 * @generated
	 */
	QA getQaVariant();

	/**
	 * Sets the value of the '{@link applicabilitymodel.Decision#getQaVariant <em>Qa Variant</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qa Variant</em>' containment reference.
	 * @see #getQaVariant()
	 * @generated
	 */
	void setQaVariant(QA value);

	/**
	 * Returns the value of the '<em><b>Component Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Set</em>' containment reference.
	 * @see #setComponentSet(ComponentSet)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision_ComponentSet()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ComponentSet getComponentSet();

	/**
	 * Sets the value of the '{@link applicabilitymodel.Decision#getComponentSet <em>Component Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Set</em>' containment reference.
	 * @see #getComponentSet()
	 * @generated
	 */
	void setComponentSet(ComponentSet value);

	/**
	 * Returns the value of the '<em><b>Requires Variant Selected</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requires Variant Selected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires Variant Selected</em>' attribute.
	 * @see #setRequiresVariantSelected(int)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getDecision_RequiresVariantSelected()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getRequiresVariantSelected();

	/**
	 * Sets the value of the '{@link applicabilitymodel.Decision#getRequiresVariantSelected <em>Requires Variant Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requires Variant Selected</em>' attribute.
	 * @see #getRequiresVariantSelected()
	 * @generated
	 */
	void setRequiresVariantSelected(int value);

} // Decision
