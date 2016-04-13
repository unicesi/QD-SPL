/**
 */
package guimetamodel.impl;

import guimetamodel.GUI;
import guimetamodel.GuimetamodelPackage;
import guimetamodel.MainView;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GUI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link guimetamodel.impl.GUIImpl#getSystemName <em>System Name</em>}</li>
 *   <li>{@link guimetamodel.impl.GUIImpl#getName <em>Name</em>}</li>
 *   <li>{@link guimetamodel.impl.GUIImpl#getMainview <em>Mainview</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GUIImpl extends MinimalEObjectImpl.Container implements GUI {
	/**
	 * The default value of the '{@link #getSystemName() <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemName()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemName() <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemName()
	 * @generated
	 * @ordered
	 */
	protected String systemName = SYSTEM_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getMainview() <em>Mainview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainview()
	 * @generated
	 * @ordered
	 */
	protected MainView mainview;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GUIImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GuimetamodelPackage.Literals.GUI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemName(String newSystemName) {
		String oldSystemName = systemName;
		systemName = newSystemName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.GUI__SYSTEM_NAME, oldSystemName, systemName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.GUI__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MainView getMainview() {
		return mainview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMainview(MainView newMainview, NotificationChain msgs) {
		MainView oldMainview = mainview;
		mainview = newMainview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.GUI__MAINVIEW, oldMainview, newMainview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainview(MainView newMainview) {
		if (newMainview != mainview) {
			NotificationChain msgs = null;
			if (mainview != null)
				msgs = ((InternalEObject)mainview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.GUI__MAINVIEW, null, msgs);
			if (newMainview != null)
				msgs = ((InternalEObject)newMainview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.GUI__MAINVIEW, null, msgs);
			msgs = basicSetMainview(newMainview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.GUI__MAINVIEW, newMainview, newMainview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GuimetamodelPackage.GUI__MAINVIEW:
				return basicSetMainview(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GuimetamodelPackage.GUI__SYSTEM_NAME:
				return getSystemName();
			case GuimetamodelPackage.GUI__NAME:
				return getName();
			case GuimetamodelPackage.GUI__MAINVIEW:
				return getMainview();
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
			case GuimetamodelPackage.GUI__SYSTEM_NAME:
				setSystemName((String)newValue);
				return;
			case GuimetamodelPackage.GUI__NAME:
				setName((String)newValue);
				return;
			case GuimetamodelPackage.GUI__MAINVIEW:
				setMainview((MainView)newValue);
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
			case GuimetamodelPackage.GUI__SYSTEM_NAME:
				setSystemName(SYSTEM_NAME_EDEFAULT);
				return;
			case GuimetamodelPackage.GUI__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GuimetamodelPackage.GUI__MAINVIEW:
				setMainview((MainView)null);
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
			case GuimetamodelPackage.GUI__SYSTEM_NAME:
				return SYSTEM_NAME_EDEFAULT == null ? systemName != null : !SYSTEM_NAME_EDEFAULT.equals(systemName);
			case GuimetamodelPackage.GUI__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GuimetamodelPackage.GUI__MAINVIEW:
				return mainview != null;
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
		result.append(" (systemName: ");
		result.append(systemName);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //GUIImpl
