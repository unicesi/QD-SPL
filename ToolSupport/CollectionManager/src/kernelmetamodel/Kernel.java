/**
 */
package kernelmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Kernel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kernelmetamodel.Kernel#getName <em>Name</em>}</li>
 *   <li>{@link kernelmetamodel.Kernel#getSystem <em>System</em>}</li>
 * </ul>
 *
 * @see kernelmetamodel.KernelmetamodelPackage#getKernel()
 * @model
 * @generated
 */
public interface Kernel extends EObject {
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
	 * @see kernelmetamodel.KernelmetamodelPackage#getKernel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kernelmetamodel.Kernel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' containment reference.
	 * @see #setSystem(kernelmetamodel.System)
	 * @see kernelmetamodel.KernelmetamodelPackage#getKernel_System()
	 * @model containment="true" required="true"
	 * @generated
	 */
	kernelmetamodel.System getSystem();

	/**
	 * Sets the value of the '{@link kernelmetamodel.Kernel#getSystem <em>System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' containment reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(kernelmetamodel.System value);

} // Kernel
