/**
 */
package domainmetamodel.tests;

import domainmetamodel.Authenticate;
import domainmetamodel.DomainmetamodelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Authenticate</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AuthenticateTest extends ContractsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AuthenticateTest.class);
	}

	/**
	 * Constructs a new Authenticate test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthenticateTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Authenticate test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Authenticate getFixture() {
		return (Authenticate)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(DomainmetamodelFactory.eINSTANCE.createAuthenticate());
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

} //AuthenticateTest
