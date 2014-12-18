/**
 */
package domainmetamodelm2m.util;

import domainmetamodelm2m.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see domainmetamodelm2m.Domainmetamodelm2mPackage
 * @generated
 */
public class Domainmetamodelm2mAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Domainmetamodelm2mPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domainmetamodelm2mAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Domainmetamodelm2mPackage.eINSTANCE;
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
	protected Domainmetamodelm2mSwitch<Adapter> modelSwitch =
		new Domainmetamodelm2mSwitch<Adapter>() {
			@Override
			public Adapter caseBusiness(Business object) {
				return createBusinessAdapter();
			}
			@Override
			public Adapter caseBusinessEntity(BusinessEntity object) {
				return createBusinessEntityAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseAssociation(Association object) {
				return createAssociationAdapter();
			}
			@Override
			public Adapter caseSimple(Simple object) {
				return createSimpleAdapter();
			}
			@Override
			public Adapter caseMultiple(Multiple object) {
				return createMultipleAdapter();
			}
			@Override
			public Adapter caseContracts(Contracts object) {
				return createContractsAdapter();
			}
			@Override
			public Adapter caseCreate(Create object) {
				return createCreateAdapter();
			}
			@Override
			public Adapter caseUpdate(Update object) {
				return createUpdateAdapter();
			}
			@Override
			public Adapter caseRetrieve(Retrieve object) {
				return createRetrieveAdapter();
			}
			@Override
			public Adapter caseDelete(Delete object) {
				return createDeleteAdapter();
			}
			@Override
			public Adapter caseListAll(ListAll object) {
				return createListAllAdapter();
			}
			@Override
			public Adapter caseContractElements(ContractElements object) {
				return createContractElementsAdapter();
			}
			@Override
			public Adapter caseListElements(ListElements object) {
				return createListElementsAdapter();
			}
			@Override
			public Adapter caseAddElement(AddElement object) {
				return createAddElementAdapter();
			}
			@Override
			public Adapter caseDeleteElement(DeleteElement object) {
				return createDeleteElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Business <em>Business</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Business
	 * @generated
	 */
	public Adapter createBusinessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.BusinessEntity <em>Business Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.BusinessEntity
	 * @generated
	 */
	public Adapter createBusinessEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Association
	 * @generated
	 */
	public Adapter createAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Simple <em>Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Simple
	 * @generated
	 */
	public Adapter createSimpleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Multiple <em>Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Multiple
	 * @generated
	 */
	public Adapter createMultipleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Contracts <em>Contracts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Contracts
	 * @generated
	 */
	public Adapter createContractsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Create <em>Create</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Create
	 * @generated
	 */
	public Adapter createCreateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Update <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Update
	 * @generated
	 */
	public Adapter createUpdateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Retrieve <em>Retrieve</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Retrieve
	 * @generated
	 */
	public Adapter createRetrieveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.Delete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.Delete
	 * @generated
	 */
	public Adapter createDeleteAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.ListAll <em>List All</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.ListAll
	 * @generated
	 */
	public Adapter createListAllAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.ContractElements <em>Contract Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.ContractElements
	 * @generated
	 */
	public Adapter createContractElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.ListElements <em>List Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.ListElements
	 * @generated
	 */
	public Adapter createListElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.AddElement <em>Add Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.AddElement
	 * @generated
	 */
	public Adapter createAddElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link domainmetamodelm2m.DeleteElement <em>Delete Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see domainmetamodelm2m.DeleteElement
	 * @generated
	 */
	public Adapter createDeleteElementAdapter() {
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

} //Domainmetamodelm2mAdapterFactory
