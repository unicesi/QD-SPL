/**
 */
package guimetamodel.tests;

import guimetamodel.GuimetamodelFactory;
import guimetamodel.MainView;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Main View</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MainViewTest extends ViewTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MainViewTest.class);
	}

	/**
	 * Constructs a new Main View test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MainViewTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Main View test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MainView getFixture() {
		return (MainView)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GuimetamodelFactory.eINSTANCE.createMainView());
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

} //MainViewTest
