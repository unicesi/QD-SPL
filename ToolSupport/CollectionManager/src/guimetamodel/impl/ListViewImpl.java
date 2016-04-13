/**
 */
package guimetamodel.impl;

import guimetamodel.CreateView;
import guimetamodel.GuimetamodelPackage;
import guimetamodel.ListView;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link guimetamodel.impl.ListViewImpl#getCreateview <em>Createview</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListViewImpl extends ViewImpl implements ListView {
	/**
	 * The cached value of the '{@link #getCreateview() <em>Createview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateview()
	 * @generated
	 * @ordered
	 */
	protected CreateView createview;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GuimetamodelPackage.Literals.LIST_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateView getCreateview() {
		return createview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCreateview(CreateView newCreateview, NotificationChain msgs) {
		CreateView oldCreateview = createview;
		createview = newCreateview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.LIST_VIEW__CREATEVIEW, oldCreateview, newCreateview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateview(CreateView newCreateview) {
		if (newCreateview != createview) {
			NotificationChain msgs = null;
			if (createview != null)
				msgs = ((InternalEObject)createview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.LIST_VIEW__CREATEVIEW, null, msgs);
			if (newCreateview != null)
				msgs = ((InternalEObject)newCreateview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.LIST_VIEW__CREATEVIEW, null, msgs);
			msgs = basicSetCreateview(newCreateview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.LIST_VIEW__CREATEVIEW, newCreateview, newCreateview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GuimetamodelPackage.LIST_VIEW__CREATEVIEW:
				return basicSetCreateview(null, msgs);
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
			case GuimetamodelPackage.LIST_VIEW__CREATEVIEW:
				return getCreateview();
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
			case GuimetamodelPackage.LIST_VIEW__CREATEVIEW:
				setCreateview((CreateView)newValue);
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
			case GuimetamodelPackage.LIST_VIEW__CREATEVIEW:
				setCreateview((CreateView)null);
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
			case GuimetamodelPackage.LIST_VIEW__CREATEVIEW:
				return createview != null;
		}
		return super.eIsSet(featureID);
	}

} //ListViewImpl
