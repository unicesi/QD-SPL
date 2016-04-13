/**
 */
package guimetamodel.tests;

import guimetamodel.GuimetamodelFactory;
import guimetamodel.OrderView;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Order View</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrderViewTest extends ViewTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OrderViewTest.class);
	}

	/**
	 * Constructs a new Order View test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderViewTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Order View test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OrderView getFixture() {
		return (OrderView)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GuimetamodelFactory.eINSTANCE.createOrderView());
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

} //OrderViewTest
