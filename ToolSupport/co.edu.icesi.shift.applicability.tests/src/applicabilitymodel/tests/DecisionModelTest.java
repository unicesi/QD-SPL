/**
 */
package applicabilitymodel.tests;

import applicabilitymodel.ApplicabilitymodelFactory;
import applicabilitymodel.DecisionModel;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Decision Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DecisionModelTest extends TestCase {

	/**
	 * The fixture for this Decision Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecisionModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DecisionModelTest.class);
	}

	/**
	 * Constructs a new Decision Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Decision Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(DecisionModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Decision Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecisionModel getFixture() {
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
		setFixture(ApplicabilitymodelFactory.eINSTANCE.createDecisionModel());
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

} //DecisionModelTest
