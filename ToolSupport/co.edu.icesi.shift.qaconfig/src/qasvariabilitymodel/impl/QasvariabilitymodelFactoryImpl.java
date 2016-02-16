/**
 */
package qasvariabilitymodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import qasvariabilitymodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QasvariabilitymodelFactoryImpl extends EFactoryImpl implements QasvariabilitymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QasvariabilitymodelFactory init() {
		try {
			QasvariabilitymodelFactory theQasvariabilitymodelFactory = (QasvariabilitymodelFactory)EPackage.Registry.INSTANCE.getEFactory(QasvariabilitymodelPackage.eNS_URI);
			if (theQasvariabilitymodelFactory != null) {
				return theQasvariabilitymodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QasvariabilitymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QasvariabilitymodelFactoryImpl() {
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
			case QasvariabilitymodelPackage.QA: return createQA();
			case QasvariabilitymodelPackage.CONTAINABLE_BY_QA: return createContainableByQA();
			case QasvariabilitymodelPackage.ROOT_QA: return createRootQA();
			case QasvariabilitymodelPackage.GROUPED_QA: return createGroupedQA();
			case QasvariabilitymodelPackage.SOLITARY_QA: return createSolitaryQA();
			case QasvariabilitymodelPackage.QA_GROUP: return createQAGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QA createQA() {
		QAImpl qa = new QAImpl();
		return qa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainableByQA createContainableByQA() {
		ContainableByQAImpl containableByQA = new ContainableByQAImpl();
		return containableByQA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootQA createRootQA() {
		RootQAImpl rootQA = new RootQAImpl();
		return rootQA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupedQA createGroupedQA() {
		GroupedQAImpl groupedQA = new GroupedQAImpl();
		return groupedQA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolitaryQA createSolitaryQA() {
		SolitaryQAImpl solitaryQA = new SolitaryQAImpl();
		return solitaryQA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QAGroup createQAGroup() {
		QAGroupImpl qaGroup = new QAGroupImpl();
		return qaGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QasvariabilitymodelPackage getQasvariabilitymodelPackage() {
		return (QasvariabilitymodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QasvariabilitymodelPackage getPackage() {
		return QasvariabilitymodelPackage.eINSTANCE;
	}

} //QasvariabilitymodelFactoryImpl
