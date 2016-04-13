/**
 */
package problemSpaceMetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import problemSpaceMetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProblemSpaceMetamodelFactoryImpl extends EFactoryImpl implements ProblemSpaceMetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProblemSpaceMetamodelFactory init() {
		try {
			ProblemSpaceMetamodelFactory theProblemSpaceMetamodelFactory = (ProblemSpaceMetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(ProblemSpaceMetamodelPackage.eNS_URI);
			if (theProblemSpaceMetamodelFactory != null) {
				return theProblemSpaceMetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProblemSpaceMetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemSpaceMetamodelFactoryImpl() {
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
			case ProblemSpaceMetamodelPackage.PROBLEM_SPACE: return createProblemSpace();
			case ProblemSpaceMetamodelPackage.CHARACTERISTIC: return createCharacteristic();
			case ProblemSpaceMetamodelPackage.ENTITY: return createEntity();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemSpace createProblemSpace() {
		ProblemSpaceImpl problemSpace = new ProblemSpaceImpl();
		return problemSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Characteristic createCharacteristic() {
		CharacteristicImpl characteristic = new CharacteristicImpl();
		return characteristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity createEntity() {
		EntityImpl entity = new EntityImpl();
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProblemSpaceMetamodelPackage getProblemSpaceMetamodelPackage() {
		return (ProblemSpaceMetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProblemSpaceMetamodelPackage getPackage() {
		return ProblemSpaceMetamodelPackage.eINSTANCE;
	}

} //ProblemSpaceMetamodelFactoryImpl
