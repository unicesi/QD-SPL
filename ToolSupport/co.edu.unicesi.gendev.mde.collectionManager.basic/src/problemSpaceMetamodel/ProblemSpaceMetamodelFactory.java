/**
 */
package problemSpaceMetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see problemSpaceMetamodel.ProblemSpaceMetamodelPackage
 * @generated
 */
public interface ProblemSpaceMetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProblemSpaceMetamodelFactory eINSTANCE = problemSpaceMetamodel.impl.ProblemSpaceMetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Problem Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Problem Space</em>'.
	 * @generated
	 */
	ProblemSpace createProblemSpace();

	/**
	 * Returns a new object of class '<em>Characteristic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Characteristic</em>'.
	 * @generated
	 */
	Characteristic createCharacteristic();

	/**
	 * Returns a new object of class '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity</em>'.
	 * @generated
	 */
	Entity createEntity();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProblemSpaceMetamodelPackage getProblemSpaceMetamodelPackage();

} //ProblemSpaceMetamodelFactory
