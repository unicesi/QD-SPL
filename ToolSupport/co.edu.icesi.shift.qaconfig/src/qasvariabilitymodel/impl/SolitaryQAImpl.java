/**
 */
package qasvariabilitymodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import qasvariabilitymodel.ContainableByQA;
import qasvariabilitymodel.QA;
import qasvariabilitymodel.QasvariabilitymodelPackage;
import qasvariabilitymodel.SolitaryQA;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solitary QA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link qasvariabilitymodel.impl.SolitaryQAImpl#getParentQA <em>Parent QA</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolitaryQAImpl extends QAImpl implements SolitaryQA {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolitaryQAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QasvariabilitymodelPackage.Literals.SOLITARY_QA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QA getParentQA() {
		if (eContainerFeatureID() != QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA) return null;
		return (QA)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentQA(QA newParentQA, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentQA, QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentQA(QA newParentQA) {
		if (newParentQA != eInternalContainer() || (eContainerFeatureID() != QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA && newParentQA != null)) {
			if (EcoreUtil.isAncestor(this, newParentQA))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentQA != null)
				msgs = ((InternalEObject)newParentQA).eInverseAdd(this, QasvariabilitymodelPackage.QA__CHILDREN, QA.class, msgs);
			msgs = basicSetParentQA(newParentQA, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA, newParentQA, newParentQA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentQA((QA)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA:
				return basicSetParentQA(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA:
				return eInternalContainer().eInverseRemove(this, QasvariabilitymodelPackage.QA__CHILDREN, QA.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA:
				return getParentQA();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA:
				setParentQA((QA)newValue);
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
			case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA:
				setParentQA((QA)null);
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
			case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA:
				return getParentQA() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ContainableByQA.class) {
			switch (derivedFeatureID) {
				case QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA: return QasvariabilitymodelPackage.CONTAINABLE_BY_QA__PARENT_QA;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ContainableByQA.class) {
			switch (baseFeatureID) {
				case QasvariabilitymodelPackage.CONTAINABLE_BY_QA__PARENT_QA: return QasvariabilitymodelPackage.SOLITARY_QA__PARENT_QA;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SolitaryQAImpl
