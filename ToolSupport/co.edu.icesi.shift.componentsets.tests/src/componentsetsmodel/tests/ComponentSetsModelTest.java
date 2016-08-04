/**
 */
package componentsetsmodel.tests;

import componentsetsmodel.ComponentSetsModel;
import componentsetsmodel.ComponentsetsmodelFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Component Sets Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentSetsModelTest extends TestCase {

	/**
	 * The fixture for this Component Sets Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentSetsModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ComponentSetsModelTest.class);
	}

	/**
	 * Constructs a new Component Sets Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSetsModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Component Sets Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ComponentSetsModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Component Sets Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentSetsModel getFixture() {
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
		setFixture(ComponentsetsmodelFactory.eINSTANCE.createComponentSetsModel());
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

} //ComponentSetsModelTest
