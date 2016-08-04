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
			case ApplicabilitymodelPackage.DECISION_MODEL: return createDecisionModel();
			case ApplicabilitymodelPackage.DECISION: return createDecision();
			case ApplicabilitymodelPackage.REQUIRED_VARIANT: return createRequiredVariant();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionModel createDecisionModel() {
		DecisionModelImpl decisionModel = new DecisionModelImpl();
		return decisionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decision createDecision() {
		DecisionImpl decision = new DecisionImpl();
		return decision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredVariant createRequiredVariant() {
		RequiredVariantImpl requiredVariant = new RequiredVariantImpl();
		return requiredVariant;
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
