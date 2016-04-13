/**
 */
package domainmetamodel.tests;

import domainmetamodel.DomainmetamodelFactory;
import domainmetamodel.ProblemSpace;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Problem Space</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProblemSpaceTest extends TestCase {

	/**
	 * The fixture for this Problem Space test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemSpace fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ProblemSpaceTest.class);
	}

	/**
	 * Constructs a new Problem Space test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemSpaceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Problem Space test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ProblemSpace fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Problem Space test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemSpace getFixture() {
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
		setFixture(DomainmetamodelFactory.eINSTANCE.createProblemSpace());
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

} //ProblemSpaceTest
