/**
 */
package domainmetamodelm2m.tests;

import domainmetamodelm2m.Domainmetamodelm2mFactory;
import domainmetamodelm2m.Retrieve;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Retrieve</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RetrieveTest extends ContractsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RetrieveTest.class);
	}

	/**
	 * Constructs a new Retrieve test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetrieveTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Retrieve test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Retrieve getFixture() {
		return (Retrieve)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Domainmetamodelm2mFactory.eINSTANCE.createRetrieve());
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

} //RetrieveTest
