/**
 */
package applicabilitymodel.tests;

import applicabilitymodel.Applicability;
import applicabilitymodel.ApplicabilitymodelFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Applicability</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplicabilityTest extends TestCase {

	/**
	 * The fixture for this Applicability test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Applicability fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ApplicabilityTest.class);
	}

	/**
	 * Constructs a new Applicability test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicabilityTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Applicability test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Applicability fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Applicability test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Applicability getFixture() {
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
		setFixture(ApplicabilitymodelFactory.eINSTANCE.createApplicability());
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

} //ApplicabilityTest
