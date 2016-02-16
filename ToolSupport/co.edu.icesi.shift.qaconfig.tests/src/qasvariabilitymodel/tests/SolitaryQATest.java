/**
 */
package qasvariabilitymodel.tests;

import junit.textui.TestRunner;

import qasvariabilitymodel.QasvariabilitymodelFactory;
import qasvariabilitymodel.SolitaryQA;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Solitary QA</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SolitaryQATest extends QATest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SolitaryQATest.class);
	}

	/**
	 * Constructs a new Solitary QA test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolitaryQATest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Solitary QA test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SolitaryQA getFixture() {
		return (SolitaryQA)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(QasvariabilitymodelFactory.eINSTANCE.createSolitaryQA());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SolitaryQATest
