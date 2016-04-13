/**
 */
package kernelmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kernelmetamodel.System#getName <em>Name</em>}</li>
 *   <li>{@link kernelmetamodel.System#getElement <em>Element</em>}</li>
 *   <li>{@link kernelmetamodel.System#getSort <em>Sort</em>}</li>
 * </ul>
 *
 * @see kernelmetamodel.KernelmetamodelPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
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
	 * @see kernelmetamodel.KernelmetamodelPackage#getSystem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kernelmetamodel.System#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(Element)
	 * @see kernelmetamodel.KernelmetamodelPackage#getSystem_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Element getElement();

	/**
	 * Sets the value of the '{@link kernelmetamodel.System#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Element value);

	/**
	 * Returns the value of the '<em><b>Sort</b></em>' containment reference list.
	 * The list contents are of type {@link kernelmetamodel.Sort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sort</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sort</em>' containment reference list.
	 * @see kernelmetamodel.KernelmetamodelPackage#getSystem_Sort()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sort> getSort();

} // System
