/**
 */
package componentsetsmodel.impl;

import componentsetsmodel.ComponentSet;
import componentsetsmodel.ComponentSetsModel;
import componentsetsmodel.ComponentsetsmodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Sets Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link componentsetsmodel.impl.ComponentSetsModelImpl#getComponentsets <em>Componentsets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentSetsModelImpl extends MinimalEObjectImpl.Container implements ComponentSetsModel {
	/**
	 * The cached value of the '{@link #getComponentsets() <em>Componentsets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentsets()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentSet> componentsets;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentSetsModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsetsmodelPackage.Literals.COMPONENT_SETS_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentSet> getComponentsets() {
		if (componentsets == null) {
			componentsets = new EObjectContainmentEList<ComponentSet>(ComponentSet.class, this, ComponentsetsmodelPackage.COMPONENT_SETS_MODEL__COMPONENTSETS);
		}
		return componentsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsetsmodelPackage.COMPONENT_SETS_MODEL__COMPONENTSETS:
				return ((InternalEList<?>)getComponentsets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsetsmodelPackage.COMPONENT_SETS_MODEL__COMPONENTSETS:
				return getComponentsets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentsetsmodelPackage.COMPONENT_SETS_MODEL__COMPONENTSETS:
				getComponentsets().clear();
				getComponentsets().addAll((Collection<? extends ComponentSet>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentsetsmodelPackage.COMPONENT_SETS_MODEL__COMPONENTSETS:
				getComponentsets().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentsetsmodelPackage.COMPONENT_SETS_MODEL__COMPONENTSETS:
				return componentsets != null && !componentsets.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentSetsModelImpl
