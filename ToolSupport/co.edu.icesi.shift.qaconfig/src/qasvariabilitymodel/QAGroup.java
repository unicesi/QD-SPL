/**
 */
package qasvariabilitymodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QA Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link qasvariabilitymodel.QAGroup#getName <em>Name</em>}</li>
 *   <li>{@link qasvariabilitymodel.QAGroup#getMin <em>Min</em>}</li>
 *   <li>{@link qasvariabilitymodel.QAGroup#getMax <em>Max</em>}</li>
 *   <li>{@link qasvariabilitymodel.QAGroup#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQAGroup()
 * @model
 * @generated
 */
public interface QAGroup extends ContainableByQA {
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
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQAGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link qasvariabilitymodel.QAGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(int)
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQAGroup_Min()
	 * @model
	 * @generated
	 */
	int getMin();

	/**
	 * Sets the value of the '{@link qasvariabilitymodel.QAGroup#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(int value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(int)
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQAGroup_Max()
	 * @model
	 * @generated
	 */
	int getMax();

	/**
	 * Sets the value of the '{@link qasvariabilitymodel.QAGroup#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(int value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link qasvariabilitymodel.GroupedQA}.
	 * It is bidirectional and its opposite is '{@link qasvariabilitymodel.GroupedQA#getParentFeature <em>Parent Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#getQAGroup_Children()
	 * @see qasvariabilitymodel.GroupedQA#getParentFeature
	 * @model opposite="parentFeature" containment="true"
	 * @generated
	 */
	EList<GroupedQA> getChildren();

} // QAGroup
