/**
 */
package kernelmetamodel.impl;

import kernelmetamodel.Attribute;
import kernelmetamodel.KernelmetamodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link kernelmetamodel.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link kernelmetamodel.impl.AttributeImpl#isIsIdentifier <em>Is Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends MinimalEObjectImpl.Container implements Attribute {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsIdentifier() <em>Is Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_IDENTIFIER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsIdentifier() <em>Is Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsIdentifier()
	 * @generated
	 * @ordered
	 */
	protected boolean isIdentifier = IS_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KernelmetamodelPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelmetamodelPackage.ATTRIBUTE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsIdentifier() {
		return isIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsIdentifier(boolean newIsIdentifier) {
		boolean oldIsIdentifier = isIdentifier;
		isIdentifier = newIsIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelmetamodelPackage.ATTRIBUTE__IS_IDENTIFIER, oldIsIdentifier, isIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelmetamodelPackage.ATTRIBUTE__NAME:
				return getName();
			case KernelmetamodelPackage.ATTRIBUTE__IS_IDENTIFIER:
				return isIsIdentifier();
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
			case KernelmetamodelPackage.ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case KernelmetamodelPackage.ATTRIBUTE__IS_IDENTIFIER:
				setIsIdentifier((Boolean)newValue);
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
			case KernelmetamodelPackage.ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KernelmetamodelPackage.ATTRIBUTE__IS_IDENTIFIER:
				setIsIdentifier(IS_IDENTIFIER_EDEFAULT);
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
			case KernelmetamodelPackage.ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KernelmetamodelPackage.ATTRIBUTE__IS_IDENTIFIER:
				return isIdentifier != IS_IDENTIFIER_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", isIdentifier: ");
		result.append(isIdentifier);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
