/**
 */
package applicabilitymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.RequiredVariant#getVariantName <em>Variant Name</em>}</li>
 *   <li>{@link applicabilitymodel.RequiredVariant#getSelectionRequired <em>Selection Required</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getRequiredVariant()
 * @model
 * @generated
 */
public interface RequiredVariant extends EObject {
	/**
	 * Returns the value of the '<em><b>Variant Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variant Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variant Name</em>' attribute.
	 * @see #setVariantName(String)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getRequiredVariant_VariantName()
	 * @model required="true"
	 * @generated
	 */
	String getVariantName();

	/**
	 * Sets the value of the '{@link applicabilitymodel.RequiredVariant#getVariantName <em>Variant Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variant Name</em>' attribute.
	 * @see #getVariantName()
	 * @generated
	 */
	void setVariantName(String value);

	/**
	 * Returns the value of the '<em><b>Selection Required</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Required</em>' attribute.
	 * @see #setSelectionRequired(int)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getRequiredVariant_SelectionRequired()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getSelectionRequired();

	/**
	 * Sets the value of the '{@link applicabilitymodel.RequiredVariant#getSelectionRequired <em>Selection Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection Required</em>' attribute.
	 * @see #getSelectionRequired()
	 * @generated
	 */
	void setSelectionRequired(int value);

} // RequiredVariant
