/**
 */
package applicabilitymodel.tests;

import applicabilitymodel.ApplicabilitymodelFactory;
import applicabilitymodel.RequiredVariant;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Required Variant</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequiredVariantTest extends TestCase {

	/**
	 * The fixture for this Required Variant test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredVariant fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RequiredVariantTest.class);
	}

	/**
	 * Constructs a new Required Variant test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredVariantTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Required Variant test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RequiredVariant fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Required Variant test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredVariant getFixture() {
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
		setFixture(ApplicabilitymodelFactory.eINSTANCE.createRequiredVariant());
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

} //RequiredVariantTest
