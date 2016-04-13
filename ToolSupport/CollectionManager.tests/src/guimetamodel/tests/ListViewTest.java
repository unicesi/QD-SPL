/**
 */
package guimetamodel.tests;

import guimetamodel.GuimetamodelFactory;
import guimetamodel.ListView;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>List View</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ListViewTest extends ViewTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ListViewTest.class);
	}

	/**
	 * Constructs a new List View test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListViewTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this List View test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ListView getFixture() {
		return (ListView)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GuimetamodelFactory.eINSTANCE.createListView());
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

} //ListViewTest
