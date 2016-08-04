/**
 */
package componentsetsmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Sets Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link componentsetsmodel.ComponentSetsModel#getComponentsets <em>Componentsets</em>}</li>
 * </ul>
 *
 * @see componentsetsmodel.ComponentsetsmodelPackage#getComponentSetsModel()
 * @model
 * @generated
 */
public interface ComponentSetsModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Componentsets</b></em>' containment reference list.
	 * The list contents are of type {@link componentsetsmodel.ComponentSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Componentsets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Componentsets</em>' containment reference list.
	 * @see componentsetsmodel.ComponentsetsmodelPackage#getComponentSetsModel_Componentsets()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentSet> getComponentsets();

} // ComponentSetsModel
