/**
 */
package guimetamodel.impl;

import guimetamodel.GuimetamodelPackage;
import guimetamodel.InfoView;
import guimetamodel.ListView;
import guimetamodel.MainView;
import guimetamodel.OrderView;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link guimetamodel.impl.MainViewImpl#getOrderview <em>Orderview</em>}</li>
 *   <li>{@link guimetamodel.impl.MainViewImpl#getListview <em>Listview</em>}</li>
 *   <li>{@link guimetamodel.impl.MainViewImpl#getInfoview <em>Infoview</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MainViewImpl extends ViewImpl implements MainView {
	/**
	 * The cached value of the '{@link #getOrderview() <em>Orderview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderview()
	 * @generated
	 * @ordered
	 */
	protected OrderView orderview;

	/**
	 * The cached value of the '{@link #getListview() <em>Listview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListview()
	 * @generated
	 * @ordered
	 */
	protected ListView listview;

	/**
	 * The cached value of the '{@link #getInfoview() <em>Infoview</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfoview()
	 * @generated
	 * @ordered
	 */
	protected InfoView infoview;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GuimetamodelPackage.Literals.MAIN_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderView getOrderview() {
		return orderview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOrderview(OrderView newOrderview, NotificationChain msgs) {
		OrderView oldOrderview = orderview;
		orderview = newOrderview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.MAIN_VIEW__ORDERVIEW, oldOrderview, newOrderview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderview(OrderView newOrderview) {
		if (newOrderview != orderview) {
			NotificationChain msgs = null;
			if (orderview != null)
				msgs = ((InternalEObject)orderview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.MAIN_VIEW__ORDERVIEW, null, msgs);
			if (newOrderview != null)
				msgs = ((InternalEObject)newOrderview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.MAIN_VIEW__ORDERVIEW, null, msgs);
			msgs = basicSetOrderview(newOrderview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.MAIN_VIEW__ORDERVIEW, newOrderview, newOrderview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListView getListview() {
		return listview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetListview(ListView newListview, NotificationChain msgs) {
		ListView oldListview = listview;
		listview = newListview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.MAIN_VIEW__LISTVIEW, oldListview, newListview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListview(ListView newListview) {
		if (newListview != listview) {
			NotificationChain msgs = null;
			if (listview != null)
				msgs = ((InternalEObject)listview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.MAIN_VIEW__LISTVIEW, null, msgs);
			if (newListview != null)
				msgs = ((InternalEObject)newListview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.MAIN_VIEW__LISTVIEW, null, msgs);
			msgs = basicSetListview(newListview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.MAIN_VIEW__LISTVIEW, newListview, newListview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoView getInfoview() {
		return infoview;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInfoview(InfoView newInfoview, NotificationChain msgs) {
		InfoView oldInfoview = infoview;
		infoview = newInfoview;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.MAIN_VIEW__INFOVIEW, oldInfoview, newInfoview);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfoview(InfoView newInfoview) {
		if (newInfoview != infoview) {
			NotificationChain msgs = null;
			if (infoview != null)
				msgs = ((InternalEObject)infoview).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.MAIN_VIEW__INFOVIEW, null, msgs);
			if (newInfoview != null)
				msgs = ((InternalEObject)newInfoview).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GuimetamodelPackage.MAIN_VIEW__INFOVIEW, null, msgs);
			msgs = basicSetInfoview(newInfoview, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GuimetamodelPackage.MAIN_VIEW__INFOVIEW, newInfoview, newInfoview));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GuimetamodelPackage.MAIN_VIEW__ORDERVIEW:
				return basicSetOrderview(null, msgs);
			case GuimetamodelPackage.MAIN_VIEW__LISTVIEW:
				return basicSetListview(null, msgs);
			case GuimetamodelPackage.MAIN_VIEW__INFOVIEW:
				return basicSetInfoview(null, msgs);
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
			case GuimetamodelPackage.MAIN_VIEW__ORDERVIEW:
				return getOrderview();
			case GuimetamodelPackage.MAIN_VIEW__LISTVIEW:
				return getListview();
			case GuimetamodelPackage.MAIN_VIEW__INFOVIEW:
				return getInfoview();
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
			case GuimetamodelPackage.MAIN_VIEW__ORDERVIEW:
				setOrderview((OrderView)newValue);
				return;
			case GuimetamodelPackage.MAIN_VIEW__LISTVIEW:
				setListview((ListView)newValue);
				return;
			case GuimetamodelPackage.MAIN_VIEW__INFOVIEW:
				setInfoview((InfoView)newValue);
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
			case GuimetamodelPackage.MAIN_VIEW__ORDERVIEW:
				setOrderview((OrderView)null);
				return;
			case GuimetamodelPackage.MAIN_VIEW__LISTVIEW:
				setListview((ListView)null);
				return;
			case GuimetamodelPackage.MAIN_VIEW__INFOVIEW:
				setInfoview((InfoView)null);
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
			case GuimetamodelPackage.MAIN_VIEW__ORDERVIEW:
				return orderview != null;
			case GuimetamodelPackage.MAIN_VIEW__LISTVIEW:
				return listview != null;
			case GuimetamodelPackage.MAIN_VIEW__INFOVIEW:
				return infoview != null;
		}
		return super.eIsSet(featureID);
	}

} //MainViewImpl
