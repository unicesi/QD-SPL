/**
 */
package guimetamodel.util;

import guimetamodel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see guimetamodel.GuimetamodelPackage
 * @generated
 */
public class GuimetamodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GuimetamodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuimetamodelSwitch() {
		if (modelPackage == null) {
			modelPackage = GuimetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GuimetamodelPackage.GUI: {
				GUI gui = (GUI)theEObject;
				T result = caseGUI(gui);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GuimetamodelPackage.MAIN_VIEW: {
				MainView mainView = (MainView)theEObject;
				T result = caseMainView(mainView);
				if (result == null) result = caseView(mainView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GuimetamodelPackage.LIST_VIEW: {
				ListView listView = (ListView)theEObject;
				T result = caseListView(listView);
				if (result == null) result = caseView(listView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GuimetamodelPackage.ORDER_VIEW: {
				OrderView orderView = (OrderView)theEObject;
				T result = caseOrderView(orderView);
				if (result == null) result = caseView(orderView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GuimetamodelPackage.INFO_VIEW: {
				InfoView infoView = (InfoView)theEObject;
				T result = caseInfoView(infoView);
				if (result == null) result = caseView(infoView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GuimetamodelPackage.CREATE_VIEW: {
				CreateView createView = (CreateView)theEObject;
				T result = caseCreateView(createView);
				if (result == null) result = caseView(createView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GuimetamodelPackage.INFO_SINGLE_VIEW: {
				InfoSingleView infoSingleView = (InfoSingleView)theEObject;
				T result = caseInfoSingleView(infoSingleView);
				if (result == null) result = caseInfoView(infoSingleView);
				if (result == null) result = caseView(infoSingleView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GuimetamodelPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GUI</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GUI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGUI(GUI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Main View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Main View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMainView(MainView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListView(ListView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Order View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Order View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderView(OrderView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Info View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfoView(InfoView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateView(CreateView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Info Single View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info Single View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInfoSingleView(InfoSingleView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GuimetamodelSwitch
