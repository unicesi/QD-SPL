/**
 */
package guimetamodel.tests;

import guimetamodel.GuimetamodelFactory;
import guimetamodel.InfoSingleView;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Info Single View</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InfoSingleViewTest extends InfoViewTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InfoSingleViewTest.class);
	}

	/**
	 * Constructs a new Info Single View test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoSingleViewTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Info Single View test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InfoSingleView getFixture() {
		return (InfoSingleView)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GuimetamodelFactory.eINSTANCE.createInfoSingleView());
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

} //InfoSingleViewTest
