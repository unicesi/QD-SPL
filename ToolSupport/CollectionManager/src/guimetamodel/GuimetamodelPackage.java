/**
 */
package guimetamodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see guimetamodel.GuimetamodelFactory
 * @model kind="package"
 * @generated
 */
public interface GuimetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "guimetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://guimetamodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "guimetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GuimetamodelPackage eINSTANCE = guimetamodel.impl.GuimetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link guimetamodel.impl.GUIImpl <em>GUI</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.GUIImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getGUI()
	 * @generated
	 */
	int GUI = 0;

	/**
	 * The feature id for the '<em><b>System Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI__SYSTEM_NAME = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI__NAME = 1;

	/**
	 * The feature id for the '<em><b>Mainview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI__MAINVIEW = 2;

	/**
	 * The number of structural features of the '<em>GUI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>GUI</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUI_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link guimetamodel.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.ViewImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 7;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__NAME = 1;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link guimetamodel.impl.MainViewImpl <em>Main View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.MainViewImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getMainView()
	 * @generated
	 */
	int MAIN_VIEW = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_VIEW__TITLE = VIEW__TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_VIEW__NAME = VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Orderview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_VIEW__ORDERVIEW = VIEW_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Listview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_VIEW__LISTVIEW = VIEW_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Infoview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_VIEW__INFOVIEW = VIEW_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Main View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_VIEW_FEATURE_COUNT = VIEW_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Main View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_VIEW_OPERATION_COUNT = VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link guimetamodel.impl.ListViewImpl <em>List View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.ListViewImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getListView()
	 * @generated
	 */
	int LIST_VIEW = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VIEW__TITLE = VIEW__TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VIEW__NAME = VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Createview</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VIEW__CREATEVIEW = VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VIEW_FEATURE_COUNT = VIEW_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>List View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_VIEW_OPERATION_COUNT = VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link guimetamodel.impl.OrderViewImpl <em>Order View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.OrderViewImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getOrderView()
	 * @generated
	 */
	int ORDER_VIEW = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_VIEW__TITLE = VIEW__TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_VIEW__NAME = VIEW__NAME;

	/**
	 * The number of structural features of the '<em>Order View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_VIEW_FEATURE_COUNT = VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Order View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_VIEW_OPERATION_COUNT = VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link guimetamodel.impl.InfoViewImpl <em>Info View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.InfoViewImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getInfoView()
	 * @generated
	 */
	int INFO_VIEW = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_VIEW__TITLE = VIEW__TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_VIEW__NAME = VIEW__NAME;

	/**
	 * The number of structural features of the '<em>Info View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_VIEW_FEATURE_COUNT = VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Info View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_VIEW_OPERATION_COUNT = VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link guimetamodel.impl.CreateViewImpl <em>Create View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.CreateViewImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getCreateView()
	 * @generated
	 */
	int CREATE_VIEW = 5;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VIEW__TITLE = VIEW__TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VIEW__NAME = VIEW__NAME;

	/**
	 * The number of structural features of the '<em>Create View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VIEW_FEATURE_COUNT = VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Create View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_VIEW_OPERATION_COUNT = VIEW_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link guimetamodel.impl.InfoSingleViewImpl <em>Info Single View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see guimetamodel.impl.InfoSingleViewImpl
	 * @see guimetamodel.impl.GuimetamodelPackageImpl#getInfoSingleView()
	 * @generated
	 */
	int INFO_SINGLE_VIEW = 6;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_SINGLE_VIEW__TITLE = INFO_VIEW__TITLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_SINGLE_VIEW__NAME = INFO_VIEW__NAME;

	/**
	 * The number of structural features of the '<em>Info Single View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_SINGLE_VIEW_FEATURE_COUNT = INFO_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Info Single View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFO_SINGLE_VIEW_OPERATION_COUNT = INFO_VIEW_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link guimetamodel.GUI <em>GUI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GUI</em>'.
	 * @see guimetamodel.GUI
	 * @generated
	 */
	EClass getGUI();

	/**
	 * Returns the meta object for the attribute '{@link guimetamodel.GUI#getSystemName <em>System Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Name</em>'.
	 * @see guimetamodel.GUI#getSystemName()
	 * @see #getGUI()
	 * @generated
	 */
	EAttribute getGUI_SystemName();

	/**
	 * Returns the meta object for the attribute '{@link guimetamodel.GUI#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see guimetamodel.GUI#getName()
	 * @see #getGUI()
	 * @generated
	 */
	EAttribute getGUI_Name();

	/**
	 * Returns the meta object for the containment reference '{@link guimetamodel.GUI#getMainview <em>Mainview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mainview</em>'.
	 * @see guimetamodel.GUI#getMainview()
	 * @see #getGUI()
	 * @generated
	 */
	EReference getGUI_Mainview();

	/**
	 * Returns the meta object for class '{@link guimetamodel.MainView <em>Main View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Main View</em>'.
	 * @see guimetamodel.MainView
	 * @generated
	 */
	EClass getMainView();

	/**
	 * Returns the meta object for the containment reference '{@link guimetamodel.MainView#getOrderview <em>Orderview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Orderview</em>'.
	 * @see guimetamodel.MainView#getOrderview()
	 * @see #getMainView()
	 * @generated
	 */
	EReference getMainView_Orderview();

	/**
	 * Returns the meta object for the containment reference '{@link guimetamodel.MainView#getListview <em>Listview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Listview</em>'.
	 * @see guimetamodel.MainView#getListview()
	 * @see #getMainView()
	 * @generated
	 */
	EReference getMainView_Listview();

	/**
	 * Returns the meta object for the containment reference '{@link guimetamodel.MainView#getInfoview <em>Infoview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Infoview</em>'.
	 * @see guimetamodel.MainView#getInfoview()
	 * @see #getMainView()
	 * @generated
	 */
	EReference getMainView_Infoview();

	/**
	 * Returns the meta object for class '{@link guimetamodel.ListView <em>List View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List View</em>'.
	 * @see guimetamodel.ListView
	 * @generated
	 */
	EClass getListView();

	/**
	 * Returns the meta object for the containment reference '{@link guimetamodel.ListView#getCreateview <em>Createview</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Createview</em>'.
	 * @see guimetamodel.ListView#getCreateview()
	 * @see #getListView()
	 * @generated
	 */
	EReference getListView_Createview();

	/**
	 * Returns the meta object for class '{@link guimetamodel.OrderView <em>Order View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order View</em>'.
	 * @see guimetamodel.OrderView
	 * @generated
	 */
	EClass getOrderView();

	/**
	 * Returns the meta object for class '{@link guimetamodel.InfoView <em>Info View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info View</em>'.
	 * @see guimetamodel.InfoView
	 * @generated
	 */
	EClass getInfoView();

	/**
	 * Returns the meta object for class '{@link guimetamodel.CreateView <em>Create View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create View</em>'.
	 * @see guimetamodel.CreateView
	 * @generated
	 */
	EClass getCreateView();

	/**
	 * Returns the meta object for class '{@link guimetamodel.InfoSingleView <em>Info Single View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Info Single View</em>'.
	 * @see guimetamodel.InfoSingleView
	 * @generated
	 */
	EClass getInfoSingleView();

	/**
	 * Returns the meta object for class '{@link guimetamodel.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see guimetamodel.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link guimetamodel.View#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see guimetamodel.View#getTitle()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Title();

	/**
	 * Returns the meta object for the attribute '{@link guimetamodel.View#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see guimetamodel.View#getName()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GuimetamodelFactory getGuimetamodelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link guimetamodel.impl.GUIImpl <em>GUI</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.GUIImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getGUI()
		 * @generated
		 */
		EClass GUI = eINSTANCE.getGUI();

		/**
		 * The meta object literal for the '<em><b>System Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUI__SYSTEM_NAME = eINSTANCE.getGUI_SystemName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUI__NAME = eINSTANCE.getGUI_Name();

		/**
		 * The meta object literal for the '<em><b>Mainview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUI__MAINVIEW = eINSTANCE.getGUI_Mainview();

		/**
		 * The meta object literal for the '{@link guimetamodel.impl.MainViewImpl <em>Main View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.MainViewImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getMainView()
		 * @generated
		 */
		EClass MAIN_VIEW = eINSTANCE.getMainView();

		/**
		 * The meta object literal for the '<em><b>Orderview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN_VIEW__ORDERVIEW = eINSTANCE.getMainView_Orderview();

		/**
		 * The meta object literal for the '<em><b>Listview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN_VIEW__LISTVIEW = eINSTANCE.getMainView_Listview();

		/**
		 * The meta object literal for the '<em><b>Infoview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN_VIEW__INFOVIEW = eINSTANCE.getMainView_Infoview();

		/**
		 * The meta object literal for the '{@link guimetamodel.impl.ListViewImpl <em>List View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.ListViewImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getListView()
		 * @generated
		 */
		EClass LIST_VIEW = eINSTANCE.getListView();

		/**
		 * The meta object literal for the '<em><b>Createview</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_VIEW__CREATEVIEW = eINSTANCE.getListView_Createview();

		/**
		 * The meta object literal for the '{@link guimetamodel.impl.OrderViewImpl <em>Order View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.OrderViewImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getOrderView()
		 * @generated
		 */
		EClass ORDER_VIEW = eINSTANCE.getOrderView();

		/**
		 * The meta object literal for the '{@link guimetamodel.impl.InfoViewImpl <em>Info View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.InfoViewImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getInfoView()
		 * @generated
		 */
		EClass INFO_VIEW = eINSTANCE.getInfoView();

		/**
		 * The meta object literal for the '{@link guimetamodel.impl.CreateViewImpl <em>Create View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.CreateViewImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getCreateView()
		 * @generated
		 */
		EClass CREATE_VIEW = eINSTANCE.getCreateView();

		/**
		 * The meta object literal for the '{@link guimetamodel.impl.InfoSingleViewImpl <em>Info Single View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.InfoSingleViewImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getInfoSingleView()
		 * @generated
		 */
		EClass INFO_SINGLE_VIEW = eINSTANCE.getInfoSingleView();

		/**
		 * The meta object literal for the '{@link guimetamodel.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see guimetamodel.impl.ViewImpl
		 * @see guimetamodel.impl.GuimetamodelPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__TITLE = eINSTANCE.getView_Title();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__NAME = eINSTANCE.getView_Name();

	}

} //GuimetamodelPackage
