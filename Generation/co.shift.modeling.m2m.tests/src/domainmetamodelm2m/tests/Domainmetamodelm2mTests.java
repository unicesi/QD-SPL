/**
 */
package domainmetamodelm2m.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>domainmetamodelm2m</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class Domainmetamodelm2mTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new Domainmetamodelm2mTests("domainmetamodelm2m Tests");
		suite.addTestSuite(BusinessTest.class);
		suite.addTestSuite(BusinessEntityTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domainmetamodelm2mTests(String name) {
		super(name);
	}

} //Domainmetamodelm2mTests
