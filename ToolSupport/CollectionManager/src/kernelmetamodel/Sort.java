/**
 */
package kernelmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kernelmetamodel.Sort#getName <em>Name</em>}</li>
 *   <li>{@link kernelmetamodel.Sort#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link kernelmetamodel.Sort#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see kernelmetamodel.KernelmetamodelPackage#getSort()
 * @model
 * @generated
 */
public interface Sort extends EObject {
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
	 * @see kernelmetamodel.KernelmetamodelPackage#getSort_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kernelmetamodel.Sort#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * The literals are from the enumeration {@link kernelmetamodel.SortAlgorithm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see kernelmetamodel.SortAlgorithm
	 * @see #setAlgorithm(SortAlgorithm)
	 * @see kernelmetamodel.KernelmetamodelPackage#getSort_Algorithm()
	 * @model
	 * @generated
	 */
	SortAlgorithm getAlgorithm();

	/**
	 * Sets the value of the '{@link kernelmetamodel.Sort#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' attribute.
	 * @see kernelmetamodel.SortAlgorithm
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(SortAlgorithm value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(Attribute)
	 * @see kernelmetamodel.KernelmetamodelPackage#getSort_Attribute()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Attribute getAttribute();

	/**
	 * Sets the value of the '{@link kernelmetamodel.Sort#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(Attribute value);

} // Sort
