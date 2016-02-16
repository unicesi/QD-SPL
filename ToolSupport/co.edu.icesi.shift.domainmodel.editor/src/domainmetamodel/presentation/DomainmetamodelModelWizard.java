package domainmetamodel.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import domainmetamodel.DomainmetamodelFactory;
import domainmetamodel.DomainmetamodelPackage;
import domainmetamodel.Multiple;
import domainmetamodel.Simple;
import domainmetamodel.presentation.DomainMetamodelEditorPlugin;
import domainmetamodel.provider.DomainMetamodelEditPlugin;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.Business;
import domainmetamodel.BusinessEntity;
import domainmetamodel.ContractElements;
import domainmetamodel.Contracts;
import domainmetamodel.DataType;

public class DomainmetamodelModelWizard extends Wizard implements INewWizard {
	/**
	 * The supported extensions for created files.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS =
		Collections.unmodifiableList(Arrays.asList(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
		DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainmetamodelPackage domainmetamodelPackage = DomainmetamodelPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainmetamodelFactory domainmetamodelFactory = domainmetamodelPackage.getDomainmetamodelFactory();

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainmetamodelModelWizardNewFileCreationPage newFileCreationPage;

	/**
	 * This is the initial object creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainmetamodelModelWizardInitialObjectCreationPage initialObjectCreationPage;

	/**
	 * Remember the selection during initialization for populating the default container.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List<String> initialObjectNames;

	/**
	 * This just records the information.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(DomainMetamodelEditorPlugin.INSTANCE.getImage("full/wizban/NewDomainmetamodel")));
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : domainmetamodelPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					if (!eClass.isAbstract()) {
						initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return initialObjectNames;
	}

	/**
	 * Create a new model.
	 * <!-- begin-user-doc -->
	 * *** Modified by JCifuentes - This function creates a default domain Model 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObject createInitialModel() {
		//Si el usuario no ha seleccionado que se genere un modelo por defecto
		if (!this.initialObjectCreationPage.bdefaultDomainModel.getSelection()){
			EClass eClass = (EClass)domainmetamodelPackage.getEClassifier(initialObjectCreationPage.getInitialObjectName());
			EObject rootObject = domainmetamodelFactory.create(eClass);
			return rootObject;
		}
		//Si el usuario ha seleccionado que se genere un modelo por defecto
		Business business;
		BusinessEntity beUser, beProject, beRisk;
		Attribute attribute;
		Contracts contract;
		ContractElements contractElement;
		Association association;
		Multiple multiple;
		Simple simple;
		EList<BusinessEntity> bEntities;
		EList<Attribute> attributes;
		EList<Contracts> contracts;
		EList<Association> associations;
		
		//Crea la raíz
		business = domainmetamodelFactory.createBusiness();
		business.setName("pcs");
		
		//Crea las entidades user, project y risk
		beProject = domainmetamodelFactory.createBusinessEntity();
		beProject.setIsAuthenticable(false);
		beProject.setName("Project");		
		beUser = domainmetamodelFactory.createBusinessEntity();
		beUser.setIsAuthenticable(true);
		beUser.setName("User");
		beRisk = domainmetamodelFactory.createBusinessEntity();
		beRisk.setIsAuthenticable(false);
		beRisk.setName("Risk");

		//Las asigna como entidades del sistema
		bEntities = business.getEntities();
		bEntities.add(beProject);
		bEntities.add(beUser);
		bEntities.add(beRisk);
		
		//crea los atributos de project
		attributes = beProject.getAttributes();
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("id");
		attribute.setIsRequired(true);
		attribute.setIsDefault(true);
		attributes.add(attribute);
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("description");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attributes.add(attribute);
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("name");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attributes.add(attribute);
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("startDate");
		attribute.setDataType(DataType.DATE);
		attribute.setIsRequired(true);
		attributes.add(attribute);

		//Crea los contratos de project
		contracts = beProject.getContracts();
		associations = beProject.getAssociations();

		contract = domainmetamodelFactory.createCreate();
		contract.setName("createProject");
		contracts.add(contract);
				
		contract = domainmetamodelFactory.createUpdate();
		contract.setName("updateProject");
		contracts.add(contract);

		contract = domainmetamodelFactory.createListAll();
		contract.setName("getAllProjects");
		contracts.add(contract);

		multiple = domainmetamodelFactory.createMultiple();
		multiple.setAssociatedEntity(beUser);
		multiple.setName("users");
		multiple.setEntity(beUser);
		associations.add(multiple);

		contractElement = domainmetamodelFactory.createAddElement();
		contractElement.setName("addUserToProject");
		contractElement.setAssociation(multiple);
		contracts.add(contractElement);

		contract = domainmetamodelFactory.createDelete();
		contract.setName("deleteProject");
		contracts.add(contract);

		contractElement = domainmetamodelFactory.createDeleteElement();
		contractElement.setName("removeUserFromProject");
		contractElement.setAssociation(multiple);
		contracts.add(contractElement);
		
		multiple = domainmetamodelFactory.createMultiple();
		multiple.setAssociatedEntity(beRisk);
		multiple.setName("risks");
		multiple.setEntity(beRisk);
		associations.add(multiple);
		
		contractElement = domainmetamodelFactory.createDeleteElement();
		contractElement.setName("deleteRiskFromProject");
		contractElement.setAssociation(multiple);
		contracts.add(contractElement);

		contractElement = domainmetamodelFactory.createAddElement();
		contractElement.setName("addRiskToProject");
		contractElement.setAssociation(multiple);
		contracts.add(contractElement);

		
		//Crea las asociaciones de project
		
		simple = domainmetamodelFactory.createSimple();
		simple.setAssociatedEntity(beUser);
		simple.setName("manager");
		simple.setRelatedEntity(beUser);
		associations.add(simple);

		simple = domainmetamodelFactory.createSimple();
		simple.setAssociatedEntity(beRisk);
		simple.setName("priorityRisk");
		simple.setRelatedEntity(beRisk);
		associations.add(simple);

		//crea los atributos de user
		attributes = beUser.getAttributes();
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("cc");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attribute.setIsDefault(true);
		attributes.add(attribute);
		
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("name");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attributes.add(attribute);

		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("cellphone");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attributes.add(attribute);

		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("password");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attributes.add(attribute);

		//Crea los contratos de user
		contracts = beUser.getContracts();
		contract = domainmetamodelFactory.createListAll();
		contract.setName("getAllUsers");
		contracts.add(contract);

		contract = domainmetamodelFactory.createCreate();
		contract.setName("createUser");
		contracts.add(contract);
		
		//Crea las asociaciones de user
		associations = beUser.getAssociations();
		multiple = domainmetamodelFactory.createMultiple();
		multiple.setAssociatedEntity(beProject);
		multiple.setName("projects");
		multiple.setEntity(beProject);
		associations.add(multiple);

		//crea los atributos de risk
		attributes = beRisk.getAttributes();
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("id");
		attribute.setIsRequired(true);
		attribute.setIsDefault(true);
		attributes.add(attribute);

		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("description");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attributes.add(attribute);
		
		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("impact");
		attribute.setDataType(DataType.DOUBLE);
		attribute.setIsRequired(true);
		attributes.add(attribute);

		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("name");
		attribute.setDataType(DataType.STRING);
		attribute.setIsRequired(true);
		attributes.add(attribute);

		attribute = domainmetamodelFactory.createAttribute();
		attribute.setName("probability");
		attribute.setDataType(DataType.DOUBLE);
		attribute.setIsRequired(true);
		attributes.add(attribute);

		//Crea los contratos de Risk
		contracts = beRisk.getContracts();
		contract = domainmetamodelFactory.createCreate();
		contract.setName("addRisk");
		contracts.add(contract);

		contract = domainmetamodelFactory.createDelete();
		contract.setName("removeRisk");
		contracts.add(contract);

		return business;
	}

	/**
	 * Do the work after everything is specified.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation =
				new WorkspaceModifyOperation() {
					@Override
					protected void execute(IProgressMonitor progressMonitor) {
						try {
							// Create a resource set
							//
							ResourceSet resourceSet = new ResourceSetImpl();

							// Get the URI of the model file.
							//
							URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);

							// Create a resource for this file.
							//
							Resource resource = resourceSet.createResource(fileURI);

							// Add the initial model object to the contents.
							//
							EObject rootObject = createInitialModel();
							if (rootObject != null) {
								resource.getContents().add(rootObject);
							}

							// Save the contents of the resource to the file system.
							//
							Map<Object, Object> options = new HashMap<Object, Object>();
							options.put(XMLResource.OPTION_ENCODING, initialObjectCreationPage.getEncoding());
							resource.save(options);
						}
						catch (Exception exception) {
							DomainMetamodelEditorPlugin.INSTANCE.log(exception);
						}
						finally {
							progressMonitor.done();
						}
					}
				};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
						 }
					 });
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor
					(new FileEditorInput(modelFile),
					 workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());					 	 
			}
			catch (PartInitException exception) {
				MessageDialog.openError(workbenchWindow.getShell(), DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			DomainMetamodelEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class DomainmetamodelModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public DomainmetamodelModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
			super(pageId, selection);
		}

		/**
		 * The framework calls this to see if the file is correct.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		protected boolean validatePage() {
			if (super.validatePage()) {
				String extension = new Path(getFileName()).getFileExtension();
				if (extension == null || !FILE_EXTENSIONS.contains(extension)) {
					String key = FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension";
					setErrorMessage(DomainMetamodelEditorPlugin.INSTANCE.getString(key, new Object [] { FORMATTED_FILE_EXTENSIONS }));
					return false;
				}
				return true;
			}
			return false;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
		}
	}

	/**
	 * This is the page where the type of object to create is selected.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class DomainmetamodelModelWizardInitialObjectCreationPage extends WizardPage {
		/**
		 * <!-- Jcifuentes -->
		 */
		protected Button bdefaultDomainModel;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Combo initialObjectField;

		/**
		 * @generated
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 */
		protected List<String> encodings;

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Combo encodingField;

		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public DomainmetamodelModelWizardInitialObjectCreationPage(String pageId) {
			super(pageId);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			{
				GridLayout layout = new GridLayout();
				layout.numColumns = 1;
				layout.verticalSpacing = 12;
				composite.setLayout(layout);

				GridData data = new GridData();
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				data.horizontalAlignment = GridData.FILL;
				composite.setLayoutData(data);
			}

			Label containerLabel = new Label(composite, SWT.LEFT);
			{
				containerLabel.setText(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_ModelObject"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				containerLabel.setLayoutData(data);
			}

			initialObjectField = new Combo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				initialObjectField.setLayoutData(data);
			}

			for (String objectName : getInitialObjectNames()) {
				initialObjectField.add(getLabel(objectName));
			}

			/*JC: Modificado para seleccionar el objeto Business por defecto
			if (initialObjectField.getItemCount() == 1) {
				initialObjectField.select(0);
			}*/
			initialObjectField.select(initialObjectField.indexOf(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelEditorDefaultModelObject")));
			//JC: Fin modificación
			
			initialObjectField.addModifyListener(validator);

			Label encodingLabel = new Label(composite, SWT.LEFT);
			{
				encodingLabel.setText(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				encodingLabel.setLayoutData(data);
			}
			encodingField = new Combo(composite, SWT.BORDER);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				encodingField.setLayoutData(data);
			}

			for (String encoding : getEncodings()) {
				encodingField.add(encoding);
			}

			encodingField.select(0);
			encodingField.addModifyListener(validator);

			/*
			 * JC: Modificado para incluir un checkbox que indica si se crea un
			 * modelo qa por defecto
			 */
			bdefaultDomainModel = new Button(composite, SWT.CHECK);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				bdefaultDomainModel.setLayoutData(data);
			}
			bdefaultDomainModel.setText(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DefaultDomainModel"));
			//Fin modificación

			setPageComplete(validatePage());
			setControl(composite);
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected ModifyListener validator =
			new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					setPageComplete(validatePage());
				}
			};

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected boolean validatePage() {
			return getInitialObjectName() != null && getEncodings().contains(encodingField.getText());
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public void setVisible(boolean visible) {
			super.setVisible(visible);
			if (visible) {
				if (initialObjectField.getItemCount() == 1) {
					initialObjectField.clearSelection();
					encodingField.setFocus();
				}
				else {
					encodingField.clearSelection();
					initialObjectField.setFocus();
				}
			}
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public String getInitialObjectName() {
			String label = initialObjectField.getText();

			for (String name : getInitialObjectNames()) {
				if (getLabel(name).equals(label)) {
					return name;
				}
			}
			return null;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public String getEncoding() {
			return encodingField.getText();
		}

		/**
		 * Returns the label for the specified type name.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected String getLabel(String typeName) {
			try {
				return DomainMetamodelEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
			}
			catch(MissingResourceException mre) {
				DomainMetamodelEditorPlugin.INSTANCE.log(mre);
			}
			return typeName;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected Collection<String> getEncodings() {
			if (encodings == null) {
				encodings = new ArrayList<String>();
				for (StringTokenizer stringTokenizer = new StringTokenizer(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) {
					encodings.add(stringTokenizer.nextToken());
				}
			}
			return encodings;
		}
	}

	/**
	 * The framework calls this to create the contents of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
		@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		newFileCreationPage = new DomainmetamodelModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelModelWizard_label"));
		newFileCreationPage.setDescription(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelModelWizard_description"));
		newFileCreationPage.setFileName(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
		addPage(newFileCreationPage);

		// Try and get the resource selection to determine a current directory for the file dialog.
		//
		if (selection != null && !selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource)selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new DomainmetamodelModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_DomainmetamodelModelWizard_label"));
		initialObjectCreationPage.setDescription(DomainMetamodelEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
		addPage(initialObjectCreationPage);
	}

	/**
	 * Get the file from the page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile getModelFile() {
		return newFileCreationPage.getModelFile();
	}

}
