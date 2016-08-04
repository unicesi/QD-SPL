/**
 */
package componentsetsmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see componentsetsmodel.ComponentsetsmodelPackage
 * @generated
 */
public interface ComponentsetsmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComponentsetsmodelFactory eINSTANCE = componentsetsmodel.impl.ComponentsetsmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Component Sets Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Sets Model</em>'.
	 * @generated
	 */
	ComponentSetsModel createComponentSetsModel();

	/**
	 * Returns a new object of class '<em>Component Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Set</em>'.
	 * @generated
	 */
	ComponentSet createComponentSet();

	/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
	Component createComponent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComponentsetsmodelPackage getComponentsetsmodelPackage();

} //ComponentsetsmodelFactory
