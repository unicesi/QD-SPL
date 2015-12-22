/**
 */
package domainmetamodelm2m;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Business</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link domainmetamodelm2m.Business#getEntities <em>Entities</em>}</li>
 *   <li>{@link domainmetamodelm2m.Business#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusiness()
 * @model
 * @generated
 */
public interface Business extends EObject {
	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link domainmetamodelm2m.BusinessEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusiness_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<BusinessEntity> getEntities();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see domainmetamodelm2m.Domainmetamodelm2mPackage#getBusiness_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link domainmetamodelm2m.Business#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" keyRequired="true"
	 * @generated
	 */
	boolean isQASelected(String key);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true"
	 * @generated
	 */
	void createCryptManager(EModelElement pack);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true"
	 * @generated
	 */
	void createAuthorizationBoundary(EModelElement pack);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model packRequired="true"
	 * @generated
	 */
	void createAuthorizationEntities(EModelElement pack);

} // Business
