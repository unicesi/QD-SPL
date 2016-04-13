/**
 */
package applicabilitymodel.impl;

import applicabilitymodel.*;

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
public class ApplicabilitymodelFactoryImpl extends EFactoryImpl implements ApplicabilitymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ApplicabilitymodelFactory init() {
		try {
			ApplicabilitymodelFactory theApplicabilitymodelFactory = (ApplicabilitymodelFactory)EPackage.Registry.INSTANCE.getEFactory(ApplicabilitymodelPackage.eNS_URI);
			if (theApplicabilitymodelFactory != null) {
				return theApplicabilitymodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ApplicabilitymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicabilitymodelFactoryImpl() {
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
			case ApplicabilitymodelPackage.APPLICABILITY_MODEL: return createApplicabilityModel();
			case ApplicabilitymodelPackage.INPUT_MODEL: return createInputModel();
			case ApplicabilitymodelPackage.APPLICABILITY: return createApplicability();
			case ApplicabilitymodelPackage.QUALITY_SCENARIO: return createQualityScenario();
			case ApplicabilitymodelPackage.COMPONENT_SET: return createComponentSet();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicabilityModel createApplicabilityModel() {
		ApplicabilityModelImpl applicabilityModel = new ApplicabilityModelImpl();
		return applicabilityModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputModel createInputModel() {
		InputModelImpl inputModel = new InputModelImpl();
		return inputModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Applicability createApplicability() {
		ApplicabilityImpl applicability = new ApplicabilityImpl();
		return applicability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityScenario createQualityScenario() {
		QualityScenarioImpl qualityScenario = new QualityScenarioImpl();
		return qualityScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSet createComponentSet() {
		ComponentSetImpl componentSet = new ComponentSetImpl();
		return componentSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicabilitymodelPackage getApplicabilitymodelPackage() {
		return (ApplicabilitymodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ApplicabilitymodelPackage getPackage() {
		return ApplicabilitymodelPackage.eINSTANCE;
	}

} //ApplicabilitymodelFactoryImpl
