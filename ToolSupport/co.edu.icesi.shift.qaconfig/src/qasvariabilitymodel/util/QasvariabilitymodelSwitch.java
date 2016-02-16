/**
 */
package qasvariabilitymodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import qasvariabilitymodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see qasvariabilitymodel.QasvariabilitymodelPackage
 * @generated
 */
public class QasvariabilitymodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QasvariabilitymodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QasvariabilitymodelSwitch() {
		if (modelPackage == null) {
			modelPackage = QasvariabilitymodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QasvariabilitymodelPackage.QA: {
				QA qa = (QA)theEObject;
				T result = caseQA(qa);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QasvariabilitymodelPackage.CONTAINABLE_BY_QA: {
				ContainableByQA containableByQA = (ContainableByQA)theEObject;
				T result = caseContainableByQA(containableByQA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QasvariabilitymodelPackage.ROOT_QA: {
				RootQA rootQA = (RootQA)theEObject;
				T result = caseRootQA(rootQA);
				if (result == null) result = caseQA(rootQA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QasvariabilitymodelPackage.GROUPED_QA: {
				GroupedQA groupedQA = (GroupedQA)theEObject;
				T result = caseGroupedQA(groupedQA);
				if (result == null) result = caseQA(groupedQA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QasvariabilitymodelPackage.SOLITARY_QA: {
				SolitaryQA solitaryQA = (SolitaryQA)theEObject;
				T result = caseSolitaryQA(solitaryQA);
				if (result == null) result = caseQA(solitaryQA);
				if (result == null) result = caseContainableByQA(solitaryQA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QasvariabilitymodelPackage.QA_GROUP: {
				QAGroup qaGroup = (QAGroup)theEObject;
				T result = caseQAGroup(qaGroup);
				if (result == null) result = caseContainableByQA(qaGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQA(QA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containable By QA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containable By QA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainableByQA(ContainableByQA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root QA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root QA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootQA(RootQA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grouped QA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grouped QA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroupedQA(GroupedQA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solitary QA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solitary QA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolitaryQA(SolitaryQA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QA Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QA Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQAGroup(QAGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QasvariabilitymodelSwitch
