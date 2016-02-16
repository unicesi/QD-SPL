/**
 */
package qasvariabilitymodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import qasvariabilitymodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see qasvariabilitymodel.QasvariabilitymodelPackage
 * @generated
 */
public class QasvariabilitymodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QasvariabilitymodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QasvariabilitymodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QasvariabilitymodelPackage.eINSTANCE;
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
	protected QasvariabilitymodelSwitch<Adapter> modelSwitch =
		new QasvariabilitymodelSwitch<Adapter>() {
			@Override
			public Adapter caseQA(QA object) {
				return createQAAdapter();
			}
			@Override
			public Adapter caseContainableByQA(ContainableByQA object) {
				return createContainableByQAAdapter();
			}
			@Override
			public Adapter caseRootQA(RootQA object) {
				return createRootQAAdapter();
			}
			@Override
			public Adapter caseGroupedQA(GroupedQA object) {
				return createGroupedQAAdapter();
			}
			@Override
			public Adapter caseSolitaryQA(SolitaryQA object) {
				return createSolitaryQAAdapter();
			}
			@Override
			public Adapter caseQAGroup(QAGroup object) {
				return createQAGroupAdapter();
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
	 * Creates a new adapter for an object of class '{@link qasvariabilitymodel.QA <em>QA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see qasvariabilitymodel.QA
	 * @generated
	 */
	public Adapter createQAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link qasvariabilitymodel.ContainableByQA <em>Containable By QA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see qasvariabilitymodel.ContainableByQA
	 * @generated
	 */
	public Adapter createContainableByQAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link qasvariabilitymodel.RootQA <em>Root QA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see qasvariabilitymodel.RootQA
	 * @generated
	 */
	public Adapter createRootQAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link qasvariabilitymodel.GroupedQA <em>Grouped QA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see qasvariabilitymodel.GroupedQA
	 * @generated
	 */
	public Adapter createGroupedQAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link qasvariabilitymodel.SolitaryQA <em>Solitary QA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see qasvariabilitymodel.SolitaryQA
	 * @generated
	 */
	public Adapter createSolitaryQAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link qasvariabilitymodel.QAGroup <em>QA Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see qasvariabilitymodel.QAGroup
	 * @generated
	 */
	public Adapter createQAGroupAdapter() {
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

} //QasvariabilitymodelAdapterFactory
