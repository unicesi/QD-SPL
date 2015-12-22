/**
 */
package domainmetamodelm2m.tests;

import domainmetamodelm2m.DeleteElement;
import domainmetamodelm2m.Domainmetamodelm2mFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Delete Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeleteElementTest extends ContractElementsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DeleteElementTest.class);
	}

	/**
	 * Constructs a new Delete Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteElementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Delete Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DeleteElement getFixture() {
		return (DeleteElement)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(Domainmetamodelm2mFactory.eINSTANCE.createDeleteElement());
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

} //DeleteElementTest
