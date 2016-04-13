/**
 */
package kernelmetamodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link kernelmetamodel.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link kernelmetamodel.Attribute#isIsIdentifier <em>Is Identifier</em>}</li>
 * </ul>
 *
 * @see kernelmetamodel.KernelmetamodelPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject {
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
	 * @see kernelmetamodel.KernelmetamodelPackage#getAttribute_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link kernelmetamodel.Attribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Identifier</em>' attribute.
	 * @see #setIsIdentifier(boolean)
	 * @see kernelmetamodel.KernelmetamodelPackage#getAttribute_IsIdentifier()
	 * @model
	 * @generated
	 */
	boolean isIsIdentifier();

	/**
	 * Sets the value of the '{@link kernelmetamodel.Attribute#isIsIdentifier <em>Is Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Identifier</em>' attribute.
	 * @see #isIsIdentifier()
	 * @generated
	 */
	void setIsIdentifier(boolean value);

} // Attribute
