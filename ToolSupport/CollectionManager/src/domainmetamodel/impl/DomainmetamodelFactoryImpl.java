/**
 */
package domainmetamodel.impl;

import domainmetamodel.*;

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
public class DomainmetamodelFactoryImpl extends EFactoryImpl implements DomainmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DomainmetamodelFactory init() {
		try {
			DomainmetamodelFactory theDomainmetamodelFactory = (DomainmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(DomainmetamodelPackage.eNS_URI);
			if (theDomainmetamodelFactory != null) {
				return theDomainmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DomainmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainmetamodelFactoryImpl() {
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
			case DomainmetamodelPackage.PROBLEM_SPACE: return createProblemSpace();
			case DomainmetamodelPackage.ENTITY: return createEntity();
			case DomainmetamodelPackage.CHARACTERISTIC: return createCharacteristic();
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
	public Entity createEntity() {
		EntityImpl entity = new EntityImpl();
		return entity;
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
	public DomainmetamodelPackage getDomainmetamodelPackage() {
		return (DomainmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DomainmetamodelPackage getPackage() {
		return DomainmetamodelPackage.eINSTANCE;
	}

} //DomainmetamodelFactoryImpl
