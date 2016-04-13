/**
 */
package guimetamodel.impl;

import guimetamodel.CreateView;
import guimetamodel.GuimetamodelFactory;
import guimetamodel.GuimetamodelPackage;
import guimetamodel.InfoSingleView;
import guimetamodel.InfoView;
import guimetamodel.ListView;
import guimetamodel.MainView;
import guimetamodel.OrderView;
import guimetamodel.View;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GuimetamodelPackageImpl extends EPackageImpl implements GuimetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guiEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mainViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infoViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infoSingleViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see guimetamodel.GuimetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GuimetamodelPackageImpl() {
		super(eNS_URI, GuimetamodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GuimetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GuimetamodelPackage init() {
		if (isInited) return (GuimetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(GuimetamodelPackage.eNS_URI);

		// Obtain or create and register package
		GuimetamodelPackageImpl theGuimetamodelPackage = (GuimetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GuimetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GuimetamodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGuimetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theGuimetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGuimetamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GuimetamodelPackage.eNS_URI, theGuimetamodelPackage);
		return theGuimetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGUI() {
		return guiEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGUI_SystemName() {
		return (EAttribute)guiEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGUI_Name() {
		return (EAttribute)guiEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGUI_Mainview() {
		return (EReference)guiEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMainView() {
		return mainViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMainView_Orderview() {
		return (EReference)mainViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMainView_Listview() {
		return (EReference)mainViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMainView_Infoview() {
		return (EReference)mainViewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListView() {
		return listViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListView_Createview() {
		return (EReference)listViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderView() {
		return orderViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfoView() {
		return infoViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateView() {
		return createViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInfoSingleView() {
		return infoSingleViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getView() {
		return viewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_Title() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getView_Name() {
		return (EAttribute)viewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuimetamodelFactory getGuimetamodelFactory() {
		return (GuimetamodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		guiEClass = createEClass(GUI);
		createEAttribute(guiEClass, GUI__SYSTEM_NAME);
		createEAttribute(guiEClass, GUI__NAME);
		createEReference(guiEClass, GUI__MAINVIEW);

		mainViewEClass = createEClass(MAIN_VIEW);
		createEReference(mainViewEClass, MAIN_VIEW__ORDERVIEW);
		createEReference(mainViewEClass, MAIN_VIEW__LISTVIEW);
		createEReference(mainViewEClass, MAIN_VIEW__INFOVIEW);

		listViewEClass = createEClass(LIST_VIEW);
		createEReference(listViewEClass, LIST_VIEW__CREATEVIEW);

		orderViewEClass = createEClass(ORDER_VIEW);

		infoViewEClass = createEClass(INFO_VIEW);

		createViewEClass = createEClass(CREATE_VIEW);

		infoSingleViewEClass = createEClass(INFO_SINGLE_VIEW);

		viewEClass = createEClass(VIEW);
		createEAttribute(viewEClass, VIEW__TITLE);
		createEAttribute(viewEClass, VIEW__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mainViewEClass.getESuperTypes().add(this.getView());
		listViewEClass.getESuperTypes().add(this.getView());
		orderViewEClass.getESuperTypes().add(this.getView());
		infoViewEClass.getESuperTypes().add(this.getView());
		createViewEClass.getESuperTypes().add(this.getView());
		infoSingleViewEClass.getESuperTypes().add(this.getInfoView());

		// Initialize classes, features, and operations; add parameters
		initEClass(guiEClass, guimetamodel.GUI.class, "GUI", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGUI_SystemName(), ecorePackage.getEString(), "systemName", null, 0, 1, guimetamodel.GUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGUI_Name(), ecorePackage.getEString(), "name", null, 0, 1, guimetamodel.GUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGUI_Mainview(), this.getMainView(), null, "mainview", null, 1, 1, guimetamodel.GUI.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mainViewEClass, MainView.class, "MainView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMainView_Orderview(), this.getOrderView(), null, "orderview", null, 1, 1, MainView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMainView_Listview(), this.getListView(), null, "listview", null, 1, 1, MainView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMainView_Infoview(), this.getInfoView(), null, "infoview", null, 1, 1, MainView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listViewEClass, ListView.class, "ListView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListView_Createview(), this.getCreateView(), null, "createview", null, 1, 1, ListView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orderViewEClass, OrderView.class, "OrderView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(infoViewEClass, InfoView.class, "InfoView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createViewEClass, CreateView.class, "CreateView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(infoSingleViewEClass, InfoSingleView.class, "InfoSingleView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getView_Title(), ecorePackage.getEString(), "title", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getView_Name(), ecorePackage.getEString(), "name", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GuimetamodelPackageImpl
