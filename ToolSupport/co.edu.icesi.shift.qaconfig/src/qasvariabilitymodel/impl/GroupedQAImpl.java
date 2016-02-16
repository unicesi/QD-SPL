/**
 */
package qasvariabilitymodel.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import qasvariabilitymodel.GroupedQA;
import qasvariabilitymodel.QAGroup;
import qasvariabilitymodel.QasvariabilitymodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grouped QA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link qasvariabilitymodel.impl.GroupedQAImpl#getParentFeature <em>Parent Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupedQAImpl extends QAImpl implements GroupedQA {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupedQAImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QasvariabilitymodelPackage.Literals.GROUPED_QA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QAGroup getParentFeature() {
		if (eContainerFeatureID() != QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE) return null;
		return (QAGroup)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE, msgs);
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
			case QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE:
				return eBasicSetContainer(null, QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE, msgs);
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
			case QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE:
				return eInternalContainer().eInverseRemove(this, QasvariabilitymodelPackage.QA_GROUP__CHILDREN, QAGroup.class, msgs);
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
			case QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE:
				return getParentFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QasvariabilitymodelPackage.GROUPED_QA__PARENT_FEATURE:
				return getParentFeature() != null;
		}
		return super.eIsSet(featureID);
	}

} //GroupedQAImpl
