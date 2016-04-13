/**
 */
package guimetamodel.impl;

import guimetamodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GuimetamodelFactoryImpl extends EFactoryImpl implements GuimetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GuimetamodelFactory init() {
		try {
			GuimetamodelFactory theGuimetamodelFactory = (GuimetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(GuimetamodelPackage.eNS_URI);
			if (theGuimetamodelFactory != null) {
				return theGuimetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GuimetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuimetamodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GuimetamodelPackage.GUI: return createGUI();
			case GuimetamodelPackage.MAIN_VIEW: return createMainView();
			case GuimetamodelPackage.LIST_VIEW: return createListView();
			case GuimetamodelPackage.ORDER_VIEW: return createOrderView();
			case GuimetamodelPackage.INFO_VIEW: return createInfoView();
			case GuimetamodelPackage.CREATE_VIEW: return createCreateView();
			case GuimetamodelPackage.INFO_SINGLE_VIEW: return createInfoSingleView();
			case GuimetamodelPackage.VIEW: return createView();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GUI createGUI() {
		GUIImpl gui = new GUIImpl();
		return gui;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MainView createMainView() {
		MainViewImpl mainView = new MainViewImpl();
		return mainView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListView createListView() {
		ListViewImpl listView = new ListViewImpl();
		return listView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderView createOrderView() {
		OrderViewImpl orderView = new OrderViewImpl();
		return orderView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoView createInfoView() {
		InfoViewImpl infoView = new InfoViewImpl();
		return infoView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateView createCreateView() {
		CreateViewImpl createView = new CreateViewImpl();
		return createView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfoSingleView createInfoSingleView() {
		InfoSingleViewImpl infoSingleView = new InfoSingleViewImpl();
		return infoSingleView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuimetamodelPackage getGuimetamodelPackage() {
		return (GuimetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GuimetamodelPackage getPackage() {
		return GuimetamodelPackage.eINSTANCE;
	}

} //GuimetamodelFactoryImpl
