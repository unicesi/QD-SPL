/**
 */
package qasvariabilitymodel.tests;

import junit.textui.TestRunner;

import qasvariabilitymodel.GroupedQA;
import qasvariabilitymodel.QasvariabilitymodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Grouped QA</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GroupedQATest extends QATest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GroupedQATest.class);
	}

	/**
	 * Constructs a new Grouped QA test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupedQATest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Grouped QA test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected GroupedQA getFixture() {
		return (GroupedQA)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(QasvariabilitymodelFactory.eINSTANCE.createGroupedQA());
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

} //GroupedQATest
