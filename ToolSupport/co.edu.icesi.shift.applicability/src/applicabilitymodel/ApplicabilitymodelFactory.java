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
	 * Returns a new object of class '<em>Decision Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decision Model</em>'.
	 * @generated
	 */
	DecisionModel createDecisionModel();

	/**
	 * Returns a new object of class '<em>Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decision</em>'.
	 * @generated
	 */
	Decision createDecision();

	/**
	 * Returns a new object of class '<em>Required Variant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Required Variant</em>'.
	 * @generated
	 */
	RequiredVariant createRequiredVariant();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ApplicabilitymodelPackage getApplicabilitymodelPackage();

} //ApplicabilitymodelFactory
