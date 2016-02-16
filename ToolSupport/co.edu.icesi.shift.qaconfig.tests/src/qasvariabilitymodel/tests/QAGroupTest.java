/**
 */
package qasvariabilitymodel.tests;

import junit.textui.TestRunner;

import qasvariabilitymodel.QAGroup;
import qasvariabilitymodel.QasvariabilitymodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>QA Group</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class QAGroupTest extends ContainableByQATest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(QAGroupTest.class);
	}

	/**
	 * Constructs a new QA Group test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QAGroupTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this QA Group test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected QAGroup getFixture() {
		return (QAGroup)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(QasvariabilitymodelFactory.eINSTANCE.createQAGroup());
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

} //QAGroupTest
