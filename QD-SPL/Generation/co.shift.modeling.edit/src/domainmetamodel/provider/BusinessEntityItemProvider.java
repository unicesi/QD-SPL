/**
 */
package domainmetamodel.provider;


import domainmetamodel.BusinessEntity;
import domainmetamodel.DomainmetamodelFactory;
import domainmetamodel.DomainmetamodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link domainmetamodel.BusinessEntity} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BusinessEntityItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessEntityItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addIsAuthenticablePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessEntity_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessEntity_name_feature", "_UI_BusinessEntity_type"),
				 DomainmetamodelPackage.Literals.BUSINESS_ENTITY__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Is Authenticable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIsAuthenticablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessEntity_isAuthenticable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessEntity_isAuthenticable_feature", "_UI_BusinessEntity_type"),
				 DomainmetamodelPackage.Literals.BUSINESS_ENTITY__IS_AUTHENTICABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__ATTRIBUTES);
			childrenFeatures.add(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS);
			childrenFeatures.add(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__ASSOCIATIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns BusinessEntity.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BusinessEntity"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BusinessEntity)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BusinessEntity_type") :
			getString("_UI_BusinessEntity_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(BusinessEntity.class)) {
			case DomainmetamodelPackage.BUSINESS_ENTITY__NAME:
			case DomainmetamodelPackage.BUSINESS_ENTITY__IS_AUTHENTICABLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DomainmetamodelPackage.BUSINESS_ENTITY__ATTRIBUTES:
			case DomainmetamodelPackage.BUSINESS_ENTITY__CONTRACTS:
			case DomainmetamodelPackage.BUSINESS_ENTITY__ASSOCIATIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__ATTRIBUTES,
				 DomainmetamodelFactory.eINSTANCE.createAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createCreate()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createUpdate()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createRetrieve()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createDelete()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createListAll()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createAuthenticate()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createListElements()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createAddElement()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__CONTRACTS,
				 DomainmetamodelFactory.eINSTANCE.createDeleteElement()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__ASSOCIATIONS,
				 DomainmetamodelFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__ASSOCIATIONS,
				 DomainmetamodelFactory.eINSTANCE.createSimple()));

		newChildDescriptors.add
			(createChildParameter
				(DomainmetamodelPackage.Literals.BUSINESS_ENTITY__ASSOCIATIONS,
				 DomainmetamodelFactory.eINSTANCE.createMultiple()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DomainMetamodelEditPlugin.INSTANCE;
	}

}
