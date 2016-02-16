/**
 */
package qasvariabilitymodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import qasvariabilitymodel.QA;
import qasvariabilitymodel.QasvariabilitymodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>QA</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class QATest extends TestCase {

	/**
	 * The fixture for this QA test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QA fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(QATest.class);
	}

	/**
	 * Constructs a new QA test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QATest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this QA test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(QA fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this QA test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QA getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(QasvariabilitymodelFactory.eINSTANCE.createQA());
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

} //QATest
