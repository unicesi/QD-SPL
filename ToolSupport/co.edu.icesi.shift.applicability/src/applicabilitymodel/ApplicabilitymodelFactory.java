/**
 */
package applicabilitymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see applicabilitymodel.ApplicabilitymodelPackage
 * @generated
 */
public interface ApplicabilitymodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ApplicabilitymodelFactory eINSTANCE = applicabilitymodel.impl.ApplicabilitymodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Applicability Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Applicability Model</em>'.
	 * @generated
	 */
	ApplicabilityModel createApplicabilityModel();

	/**
	 * Returns a new object of class '<em>Input Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Model</em>'.
	 * @generated
	 */
	InputModel createInputModel();

	/**
	 * Returns a new object of class '<em>Applicability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Applicability</em>'.
	 * @generated
	 */
	Applicability createApplicability();

	/**
	 * Returns a new object of class '<em>Quality Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quality Scenario</em>'.
	 * @generated
	 */
	QualityScenario createQualityScenario();

	/**
	 * Returns a new object of class '<em>Component Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Set</em>'.
	 * @generated
	 */
	ComponentSet createComponentSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ApplicabilitymodelPackage getApplicabilitymodelPackage();

} //ApplicabilitymodelFactory
