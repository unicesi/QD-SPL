/**
 */
package qasvariabilitymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containable By QA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link qasvariabilitymodel.ContainableByQA#getParentQA <em>Parent QA</em>}</li>
 * </ul>
 *
 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getContainableByQA()
 * @model
 * @generated
 */
public interface ContainableByQA extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent QA</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link qasvariabilitymodel.QA#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent QA</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent QA</em>' container reference.
	 * @see #setParentQA(QA)
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getContainableByQA_ParentQA()
	 * @see qasvariabilitymodel.QA#getChildren
	 * @model opposite="children" required="true" transient="false"
	 * @generated
	 */
	QA getParentQA();

	/**
	 * Sets the value of the '{@link qasvariabilitymodel.ContainableByQA#getParentQA <em>Parent QA</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent QA</em>' container reference.
	 * @see #getParentQA()
	 * @generated
	 */
	void setParentQA(QA value);

} // ContainableByQA
