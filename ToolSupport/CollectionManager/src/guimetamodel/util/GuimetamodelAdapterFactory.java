/**
 */
package guimetamodel.util;

import guimetamodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see guimetamodel.GuimetamodelPackage
 * @generated
 */
public class GuimetamodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GuimetamodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuimetamodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GuimetamodelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuimetamodelSwitch<Adapter> modelSwitch =
		new GuimetamodelSwitch<Adapter>() {
			@Override
			public Adapter caseGUI(GUI object) {
				return createGUIAdapter();
			}
			@Override
			public Adapter caseMainView(MainView object) {
				return createMainViewAdapter();
			}
			@Override
			public Adapter caseListView(ListView object) {
				return createListViewAdapter();
			}
			@Override
			public Adapter caseOrderView(OrderView object) {
				return createOrderViewAdapter();
			}
			@Override
			public Adapter caseInfoView(InfoView object) {
				return createInfoViewAdapter();
			}
			@Override
			public Adapter caseCreateView(CreateView object) {
				return createCreateViewAdapter();
			}
			@Override
			public Adapter caseInfoSingleView(InfoSingleView object) {
				return createInfoSingleViewAdapter();
			}
			@Override
			public Adapter caseView(View object) {
				return createViewAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.GUI <em>GUI</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.GUI
	 * @generated
	 */
	public Adapter createGUIAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.MainView <em>Main View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.MainView
	 * @generated
	 */
	public Adapter createMainViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.ListView <em>List View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.ListView
	 * @generated
	 */
	public Adapter createListViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.OrderView <em>Order View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.OrderView
	 * @generated
	 */
	public Adapter createOrderViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.InfoView <em>Info View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.InfoView
	 * @generated
	 */
	public Adapter createInfoViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.CreateView <em>Create View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.CreateView
	 * @generated
	 */
	public Adapter createCreateViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.InfoSingleView <em>Info Single View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.InfoSingleView
	 * @generated
	 */
	public Adapter createInfoSingleViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link guimetamodel.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see guimetamodel.View
	 * @generated
	 */
	public Adapter createViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GuimetamodelAdapterFactory
