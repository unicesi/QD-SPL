/**
 */
package componentsetsmodel.impl;

import componentsetsmodel.*;

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
public class ComponentsetsmodelFactoryImpl extends EFactoryImpl implements ComponentsetsmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComponentsetsmodelFactory init() {
		try {
			ComponentsetsmodelFactory theComponentsetsmodelFactory = (ComponentsetsmodelFactory)EPackage.Registry.INSTANCE.getEFactory(ComponentsetsmodelPackage.eNS_URI);
			if (theComponentsetsmodelFactory != null) {
				return theComponentsetsmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComponentsetsmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentsetsmodelFactoryImpl() {
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
			case ComponentsetsmodelPackage.COMPONENT_SETS_MODEL: return createComponentSetsModel();
			case ComponentsetsmodelPackage.COMPONENT_SET: return createComponentSet();
			case ComponentsetsmodelPackage.COMPONENT: return createComponent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentSetsModel createComponentSetsModel() {
		ComponentSetsModelImpl componentSetsModel = new ComponentSetsModelImpl();
		return componentSetsModel;
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
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentsetsmodelPackage getComponentsetsmodelPackage() {
		return (ComponentsetsmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComponentsetsmodelPackage getPackage() {
		return ComponentsetsmodelPackage.eINSTANCE;
	}

} //ComponentsetsmodelFactoryImpl
