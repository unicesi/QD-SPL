/**
 */
package guimetamodel.tests;

import guimetamodel.GuimetamodelFactory;
import guimetamodel.InfoView;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Info View</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfoViewTest extends ViewTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InfoViewTest.class);
	}

	/**
	 * Constructs a new Info View test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoViewTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Info View test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InfoView getFixture() {
		return (InfoView)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GuimetamodelFactory.eINSTANCE.createInfoView());
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

} //InfoViewTest
