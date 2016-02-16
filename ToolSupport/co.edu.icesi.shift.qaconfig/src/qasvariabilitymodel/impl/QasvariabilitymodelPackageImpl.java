/**
 */
package qasvariabilitymodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import qasvariabilitymodel.ContainableByQA;
import qasvariabilitymodel.GroupedQA;
import qasvariabilitymodel.QAGroup;
import qasvariabilitymodel.QasvariabilitymodelFactory;
import qasvariabilitymodel.QasvariabilitymodelPackage;
import qasvariabilitymodel.RootQA;
import qasvariabilitymodel.SolitaryQA;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QasvariabilitymodelPackageImpl extends EPackageImpl implements QasvariabilitymodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containableByQAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootQAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupedQAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solitaryQAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qaGroupEClass = null;

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
	 * @see qasvariabilitymodel.QasvariabilitymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QasvariabilitymodelPackageImpl() {
		super(eNS_URI, QasvariabilitymodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QasvariabilitymodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QasvariabilitymodelPackage init() {
		if (isInited) return (QasvariabilitymodelPackage)EPackage.Registry.INSTANCE.getEPackage(QasvariabilitymodelPackage.eNS_URI);

		// Obtain or create and register package
		QasvariabilitymodelPackageImpl theQasvariabilitymodelPackage = (QasvariabilitymodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QasvariabilitymodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QasvariabilitymodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theQasvariabilitymodelPackage.createPackageContents();

		// Initialize created meta-data
		theQasvariabilitymodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQasvariabilitymodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QasvariabilitymodelPackage.eNS_URI, theQasvariabilitymodelPackage);
		return theQasvariabilitymodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQA() {
		return qaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQA_Name() {
		return (EAttribute)qaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQA_Selected() {
		return (EAttribute)qaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQA_Children() {
		return (EReference)qaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainableByQA() {
		return containableByQAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainableByQA_ParentQA() {
		return (EReference)containableByQAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootQA() {
		return rootQAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupedQA() {
		return groupedQAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupedQA_ParentFeature() {
		return (EReference)groupedQAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolitaryQA() {
		return solitaryQAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQAGroup() {
		return qaGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQAGroup_Name() {
		return (EAttribute)qaGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQAGroup_Min() {
		return (EAttribute)qaGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQAGroup_Max() {
		return (EAttribute)qaGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQAGroup_Children() {
		return (EReference)qaGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QasvariabilitymodelFactory getQasvariabilitymodelFactory() {
		return (QasvariabilitymodelFactory)getEFactoryInstance();
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
		qaEClass = createEClass(QA);
		createEAttribute(qaEClass, QA__NAME);
		createEAttribute(qaEClass, QA__SELECTED);
		createEReference(qaEClass, QA__CHILDREN);

		containableByQAEClass = createEClass(CONTAINABLE_BY_QA);
		createEReference(containableByQAEClass, CONTAINABLE_BY_QA__PARENT_QA);

		rootQAEClass = createEClass(ROOT_QA);

		groupedQAEClass = createEClass(GROUPED_QA);
		createEReference(groupedQAEClass, GROUPED_QA__PARENT_FEATURE);

		solitaryQAEClass = createEClass(SOLITARY_QA);

		qaGroupEClass = createEClass(QA_GROUP);
		createEAttribute(qaGroupEClass, QA_GROUP__NAME);
		createEAttribute(qaGroupEClass, QA_GROUP__MIN);
		createEAttribute(qaGroupEClass, QA_GROUP__MAX);
		createEReference(qaGroupEClass, QA_GROUP__CHILDREN);
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
		rootQAEClass.getESuperTypes().add(this.getQA());
		groupedQAEClass.getESuperTypes().add(this.getQA());
		solitaryQAEClass.getESuperTypes().add(this.getQA());
		solitaryQAEClass.getESuperTypes().add(this.getContainableByQA());
		qaGroupEClass.getESuperTypes().add(this.getContainableByQA());

		// Initialize classes, features, and operations; add parameters
		initEClass(qaEClass, qasvariabilitymodel.QA.class, "QA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQA_Name(), ecorePackage.getEString(), "name", null, 0, 1, qasvariabilitymodel.QA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQA_Selected(), ecorePackage.getEBoolean(), "selected", null, 0, 1, qasvariabilitymodel.QA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQA_Children(), this.getContainableByQA(), this.getContainableByQA_ParentQA(), "children", null, 0, -1, qasvariabilitymodel.QA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containableByQAEClass, ContainableByQA.class, "ContainableByQA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainableByQA_ParentQA(), this.getQA(), this.getQA_Children(), "parentQA", null, 1, 1, ContainableByQA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootQAEClass, RootQA.class, "RootQA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(groupedQAEClass, GroupedQA.class, "GroupedQA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroupedQA_ParentFeature(), this.getQAGroup(), this.getQAGroup_Children(), "parentFeature", null, 1, 1, GroupedQA.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solitaryQAEClass, SolitaryQA.class, "SolitaryQA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(qaGroupEClass, QAGroup.class, "QAGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQAGroup_Name(), ecorePackage.getEString(), "name", null, 0, 1, QAGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQAGroup_Min(), ecorePackage.getEInt(), "min", null, 0, 1, QAGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQAGroup_Max(), ecorePackage.getEInt(), "max", null, 0, 1, QAGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQAGroup_Children(), this.getGroupedQA(), this.getGroupedQA_ParentFeature(), "children", null, 0, -1, QAGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QasvariabilitymodelPackageImpl
