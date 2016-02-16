/**
 */
package qasvariabilitymodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grouped QA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link qasvariabilitymodel.GroupedQA#getParentFeature <em>Parent Feature</em>}</li>
 * </ul>
 *
 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getGroupedQA()
 * @model
 * @generated
 */
public interface GroupedQA extends QA {
	/**
	 * Returns the value of the '<em><b>Parent Feature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link qasvariabilitymodel.QAGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Feature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Feature</em>' container reference.
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getGroupedQA_ParentFeature()
	 * @see qasvariabilitymodel.QAGroup#getChildren
	 * @model opposite="children" required="true" transient="false" changeable="false"
	 * @generated
	 */
	QAGroup getParentFeature();

} // GroupedQA
