/**
 */
package applicabilitymodel.util;

import applicabilitymodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see applicabilitymodel.ApplicabilitymodelPackage
 * @generated
 */
public class ApplicabilitymodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ApplicabilitymodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicabilitymodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ApplicabilitymodelPackage.eINSTANCE;
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
	protected ApplicabilitymodelSwitch<Adapter> modelSwitch =
		new ApplicabilitymodelSwitch<Adapter>() {
			@Override
			public Adapter caseApplicabilityModel(ApplicabilityModel object) {
				return createApplicabilityModelAdapter();
			}
			@Override
			public Adapter caseInputModel(InputModel object) {
				return createInputModelAdapter();
			}
			@Override
			public Adapter caseApplicability(Applicability object) {
				return createApplicabilityAdapter();
			}
			@Override
			public Adapter caseQualityScenario(QualityScenario object) {
				return createQualityScenarioAdapter();
			}
			@Override
			public Adapter caseComponentSet(ComponentSet object) {
				return createComponentSetAdapter();
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
	 * Creates a new adapter for an object of class '{@link applicabilitymodel.ApplicabilityModel <em>Applicability Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see applicabilitymodel.ApplicabilityModel
	 * @generated
	 */
	public Adapter createApplicabilityModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link applicabilitymodel.InputModel <em>Input Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see applicabilitymodel.InputModel
	 * @generated
	 */
	public Adapter createInputModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link applicabilitymodel.Applicability <em>Applicability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see applicabilitymodel.Applicability
	 * @generated
	 */
	public Adapter createApplicabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link applicabilitymodel.QualityScenario <em>Quality Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see applicabilitymodel.QualityScenario
	 * @generated
	 */
	public Adapter createQualityScenarioAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link applicabilitymodel.ComponentSet <em>Component Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see applicabilitymodel.ComponentSet
	 * @generated
	 */
	public Adapter createComponentSetAdapter() {
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

} //ApplicabilitymodelAdapterFactory
