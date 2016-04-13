/**
 */
package applicabilitymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applicability Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.ApplicabilityModel#getQualitymodel <em>Qualitymodel</em>}</li>
 *   <li>{@link applicabilitymodel.ApplicabilityModel#getComponentSetStore <em>Component Set Store</em>}</li>
 *   <li>{@link applicabilitymodel.ApplicabilityModel#getApplicabilities <em>Applicabilities</em>}</li>
 * </ul>
 *
 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicabilityModel()
 * @model
 * @generated
 */
public interface ApplicabilityModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Qualitymodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualitymodel</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualitymodel</em>' containment reference.
	 * @see #setQualitymodel(InputModel)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicabilityModel_Qualitymodel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InputModel getQualitymodel();

	/**
	 * Sets the value of the '{@link applicabilitymodel.ApplicabilityModel#getQualitymodel <em>Qualitymodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualitymodel</em>' containment reference.
	 * @see #getQualitymodel()
	 * @generated
	 */
	void setQualitymodel(InputModel value);

	/**
	 * Returns the value of the '<em><b>Component Set Store</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Set Store</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Set Store</em>' containment reference.
	 * @see #setComponentSetStore(InputModel)
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicabilityModel_ComponentSetStore()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InputModel getComponentSetStore();

	/**
	 * Sets the value of the '{@link applicabilitymodel.ApplicabilityModel#getComponentSetStore <em>Component Set Store</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Set Store</em>' containment reference.
	 * @see #getComponentSetStore()
	 * @generated
	 */
	void setComponentSetStore(InputModel value);

	/**
	 * Returns the value of the '<em><b>Applicabilities</b></em>' containment reference list.
	 * The list contents are of type {@link applicabilitymodel.Applicability}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applicabilities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applicabilities</em>' containment reference list.
	 * @see applicabilitymodel.ApplicabilitymodelPackage#getApplicabilityModel_Applicabilities()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Applicability> getApplicabilities();

} // ApplicabilityModel
