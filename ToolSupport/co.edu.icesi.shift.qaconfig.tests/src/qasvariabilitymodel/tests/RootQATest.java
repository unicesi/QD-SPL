/**
 */
package qasvariabilitymodel.tests;

import junit.textui.TestRunner;

import qasvariabilitymodel.QasvariabilitymodelFactory;
import qasvariabilitymodel.RootQA;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Root QA</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RootQATest extends QATest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RootQATest.class);
	}

	/**
	 * Constructs a new Root QA test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootQATest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Root QA test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected RootQA getFixture() {
		return (RootQA)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(QasvariabilitymodelFactory.eINSTANCE.createRootQA());
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

} //RootQATest
