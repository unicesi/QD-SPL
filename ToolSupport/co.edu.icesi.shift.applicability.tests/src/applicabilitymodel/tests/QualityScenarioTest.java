/**
 */
package applicabilitymodel.tests;

import applicabilitymodel.ApplicabilitymodelFactory;
import applicabilitymodel.QualityScenario;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Quality Scenario</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class QualityScenarioTest extends TestCase {

	/**
	 * The fixture for this Quality Scenario test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityScenario fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(QualityScenarioTest.class);
	}

	/**
	 * Constructs a new Quality Scenario test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityScenarioTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Quality Scenario test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(QualityScenario fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Quality Scenario test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityScenario getFixture() {
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
		setFixture(ApplicabilitymodelFactory.eINSTANCE.createQualityScenario());
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

} //QualityScenarioTest
