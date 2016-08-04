/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.ApplicabilitymodelPackage;
import applicabilitymodel.RequiredVariant;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Variant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link applicabilitymodel.impl.RequiredVariantImpl#getVariantName <em>Variant Name</em>}</li>
 *   <li>{@link applicabilitymodel.impl.RequiredVariantImpl#getSelectionRequired <em>Selection Required</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequiredVariantImpl extends MinimalEObjectImpl.Container implements RequiredVariant {
	/**
	 * The default value of the '{@link #getVariantName() <em>Variant Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariantName()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIANT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariantName() <em>Variant Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariantName()
	 * @generated
	 * @ordered
	 */
	protected String variantName = VARIANT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelectionRequired() <em>Selection Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionRequired()
	 * @generated
	 * @ordered
	 */
	protected static final int SELECTION_REQUIRED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSelectionRequired() <em>Selection Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectionRequired()
	 * @generated
	 * @ordered
	 */
	protected int selectionRequired = SELECTION_REQUIRED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredVariantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplicabilitymodelPackage.Literals.REQUIRED_VARIANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariantName() {
		return variantName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariantName(String newVariantName) {
		String oldVariantName = variantName;
		variantName = newVariantName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.REQUIRED_VARIANT__VARIANT_NAME, oldVariantName, variantName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSelectionRequired() {
		return selectionRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectionRequired(int newSelectionRequired) {
		int oldSelectionRequired = selectionRequired;
		selectionRequired = newSelectionRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplicabilitymodelPackage.REQUIRED_VARIANT__SELECTION_REQUIRED, oldSelectionRequired, selectionRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__VARIANT_NAME:
				return getVariantName();
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__SELECTION_REQUIRED:
				return getSelectionRequired();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__VARIANT_NAME:
				setVariantName((String)newValue);
				return;
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__SELECTION_REQUIRED:
				setSelectionRequired((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__VARIANT_NAME:
				setVariantName(VARIANT_NAME_EDEFAULT);
				return;
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__SELECTION_REQUIRED:
				setSelectionRequired(SELECTION_REQUIRED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__VARIANT_NAME:
				return VARIANT_NAME_EDEFAULT == null ? variantName != null : !VARIANT_NAME_EDEFAULT.equals(variantName);
			case ApplicabilitymodelPackage.REQUIRED_VARIANT__SELECTION_REQUIRED:
				return selectionRequired != SELECTION_REQUIRED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (variantName: ");
		result.append(variantName);
		result.append(", selectionRequired: ");
		result.append(selectionRequired);
		result.append(')');
		return result.toString();
	}

} //RequiredVariantImpl
