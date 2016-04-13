/**
 */
package kernelmetamodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import kernelmetamodel.KernelmetamodelFactory;
import kernelmetamodel.Sort;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sort</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SortTest extends TestCase {

	/**
	 * The fixture for this Sort test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Sort fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SortTest.class);
	}

	/**
	 * Constructs a new Sort test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SortTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Sort test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Sort fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Sort test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Sort getFixture() {
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
		setFixture(KernelmetamodelFactory.eINSTANCE.createSort());
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

} //SortTest
