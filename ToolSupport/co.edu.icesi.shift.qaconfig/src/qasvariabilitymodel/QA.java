/**
 */
package qasvariabilitymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link qasvariabilitymodel.QA#getName <em>Name</em>}</li>
 *   <li>{@link qasvariabilitymodel.QA#isSelected <em>Selected</em>}</li>
 *   <li>{@link qasvariabilitymodel.QA#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQA()
 * @model
 * @generated
 */
public interface QA extends EObject {
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
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQA_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link qasvariabilitymodel.QA#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected</em>' attribute.
	 * @see #setSelected(boolean)
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQA_Selected()
	 * @model
	 * @generated
	 */
	boolean isSelected();

	/**
	 * Sets the value of the '{@link qasvariabilitymodel.QA#isSelected <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected</em>' attribute.
	 * @see #isSelected()
	 * @generated
	 */
	void setSelected(boolean value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link qasvariabilitymodel.ContainableByQA}.
	 * It is bidirectional and its opposite is '{@link qasvariabilitymodel.ContainableByQA#getParentQA <em>Parent QA</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQA_Children()
	 * @see qasvariabilitymodel.ContainableByQA#getParentQA
	 * @model opposite="parentQA" containment="true"
	 * @generated
	 */
	EList<ContainableByQA> getChildren();

} // QA
