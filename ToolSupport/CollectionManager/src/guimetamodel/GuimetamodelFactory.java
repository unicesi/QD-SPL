/**
 */
package guimetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see guimetamodel.GuimetamodelPackage
 * @generated
 */
public interface GuimetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GuimetamodelFactory eINSTANCE = guimetamodel.impl.GuimetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>GUI</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>GUI</em>'.
	 * @generated
	 */
	GUI createGUI();

	/**
	 * Returns a new object of class '<em>Main View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Main View</em>'.
	 * @generated
	 */
	MainView createMainView();

	/**
	 * Returns a new object of class '<em>List View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List View</em>'.
	 * @generated
	 */
	ListView createListView();

	/**
	 * Returns a new object of class '<em>Order View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Order View</em>'.
	 * @generated
	 */
	OrderView createOrderView();

	/**
	 * Returns a new object of class '<em>Info View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Info View</em>'.
	 * @generated
	 */
	InfoView createInfoView();

	/**
	 * Returns a new object of class '<em>Create View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create View</em>'.
	 * @generated
	 */
	CreateView createCreateView();

	/**
	 * Returns a new object of class '<em>Info Single View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Info Single View</em>'.
	 * @generated
	 */
	InfoSingleView createInfoSingleView();

	/**
	 * Returns a new object of class '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View</em>'.
	 * @generated
	 */
	View createView();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GuimetamodelPackage getGuimetamodelPackage();

} //GuimetamodelFactory
