/**
 */
package domainmetamodelm2m.tests;

import domainmetamodelm2m.Domainmetamodelm2mFactory;
import domainmetamodelm2m.ListAll;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>List All</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ListAllTest extends ContractsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ListAllTest.class);
	}

	/**
	 * Constructs a new List All test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListAllTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this List All test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ListAll getFixture() {
		return (ListAll)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Domainmetamodelm2mFactory.eINSTANCE.createListAll());
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

} //ListAllTest
