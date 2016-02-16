/**
 */
package qasvariabilitymodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see qasvariabilitymodel.QasvariabilitymodelPackage
 * @generated
 */
public interface QasvariabilitymodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QasvariabilitymodelFactory eINSTANCE = qasvariabilitymodel.impl.QasvariabilitymodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>QA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QA</em>'.
	 * @generated
	 */
	QA createQA();

	/**
	 * Returns a new object of class '<em>Containable By QA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Containable By QA</em>'.
	 * @generated
	 */
	ContainableByQA createContainableByQA();

	/**
	 * Returns a new object of class '<em>Root QA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root QA</em>'.
	 * @generated
	 */
	RootQA createRootQA();

	/**
	 * Returns a new object of class '<em>Grouped QA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grouped QA</em>'.
	 * @generated
	 */
	GroupedQA createGroupedQA();

	/**
	 * Returns a new object of class '<em>Solitary QA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solitary QA</em>'.
	 * @generated
	 */
	SolitaryQA createSolitaryQA();

	/**
	 * Returns a new object of class '<em>QA Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QA Group</em>'.
	 * @generated
	 */
	QAGroup createQAGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QasvariabilitymodelPackage getQasvariabilitymodelPackage();

} //QasvariabilitymodelFactory
