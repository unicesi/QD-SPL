/**
 */
package kernelmetamodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import kernelmetamodel.Kernel;
import kernelmetamodel.KernelmetamodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Kernel</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class KernelTest extends TestCase {

	/**
	 * The fixture for this Kernel test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Kernel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(KernelTest.class);
	}

	/**
	 * Constructs a new Kernel test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Kernel test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Kernel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Kernel test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Kernel getFixture() {
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
		setFixture(KernelmetamodelFactory.eINSTANCE.createKernel());
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

} //KernelTest
