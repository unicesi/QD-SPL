/**
 */
package qasvariabilitymodel.presentation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xmi.XMLResource;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import org.eclipse.ui.actions.WorkspaceModifyOperation;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import qasvariabilitymodel.ContainableByQA;
import qasvariabilitymodel.GroupedQA;
import qasvariabilitymodel.QAGroup;
import qasvariabilitymodel.QasvariabilitymodelFactory;
import qasvariabilitymodel.QasvariabilitymodelPackage;
import qasvariabilitymodel.RootQA;
import qasvariabilitymodel.provider.QaconfigEditPlugin;


import org.eclipse.core.runtime.Path;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class QasvariabilitymodelModelWizard extends Wizard implements INewWizard {
	/**
	 * The supported extensions for created files.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS =
		Collections.unmodifiableList(Arrays.asList(QaconfigEditorPlugin.INSTANCE.getString("_UI_QasvariabilitymodelEditorFilenameExtensions").split("\\s*,\\s*")));

	/**
	 * A formatted list of supported file extensions, suitable for display.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS =
		QaconfigEditorPlugin.INSTANCE.getString("_UI_QasvariabilitymodelEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

	/**
	 * This caches an instance of the model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QasvariabilitymodelPackage qasvariabilitymodelPackage = QasvariabilitymodelPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QasvariabilitymodelFactory qasvariabilitymodelFactory = qasvariabilitymodelPackage.getQasvariabilitymodelFactory();

	/**
	 * This is the file creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QasvariabilitymodelModelWizardNewFileCreationPage newFileCreationPage;

	/**
	 * This is the initial object creation page.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QasvariabilitymodelModelWizardInitialObjectCreationPage initialObjectCreationPage;

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
		setWindowTitle(QaconfigEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(QaconfigEditorPlugin.INSTANCE.getImage("full/wizban/NewQasvariabilitymodel")));
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
			for (EClassifier eClassifier : qasvariabilitymodelPackage.getEClassifiers()) {
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
	 * *** Modified by JCifuentes - This function creates a default QA Model 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObject createInitialModel() {
		//Si el usuario no ha seleccionado que se genere un modelo por defecto
		if (!this.initialObjectCreationPage.bdefaultQAModel.getSelection()){
			EClass eClass = (EClass)qasvariabilitymodelPackage.getEClassifier(initialObjectCreationPage.getInitialObjectName());
			EObject eObject = qasvariabilitymodelFactory.create(eClass);
			return eObject;
		}
		//Si el usuario ha seleccionado que se genere un modelo por defecto
		RootQA rootQA;
		EList<ContainableByQA> qaGroups;
		QAGroup qaGroupTE, qaGroupSec, qaGroupTEHigh, qaGroupConf, qaGroupIA;
		EList<GroupedQA> groupedQAs;
		GroupedQA groupedQATE, groupedQATEHigh, groupedQAConf, groupedQAIA;
		
		//Creates root
		rootQA = qasvariabilitymodelFactory.createRootQA();
		rootQA.setName("QAs");
		rootQA.setSelected(true);

		//Creates group TimeExecution
		qaGroupTE = qasvariabilitymodelFactory.createQAGroup();
		qaGroupTE.setName("Time Execution");
		qaGroupTE.setMin(1);
		qaGroupTE.setMax(1);

		//Creates group Security
		qaGroupSec = qasvariabilitymodelFactory.createQAGroup();
		qaGroupSec.setName("Security");
		qaGroupSec.setMin(2);
		qaGroupSec.setMax(2);

		qaGroups = rootQA.getChildren();
		qaGroups.add(qaGroupTE);
		qaGroups.add(qaGroupSec);


		//Creates grouped QAs for TimeExecution
		groupedQAs = qaGroupTE.getChildren();
		groupedQATE = qasvariabilitymodelFactory.createGroupedQA();
		groupedQATE.setName("Normal");
		groupedQATE.setSelected(false);
		groupedQAs.add(groupedQATE);
		groupedQATE = qasvariabilitymodelFactory.createGroupedQA();
		groupedQATE.setName("Medium");
		groupedQATE.setSelected(false);
		groupedQAs.add(groupedQATE);
		groupedQATEHigh = qasvariabilitymodelFactory.createGroupedQA();
		groupedQATEHigh.setName("High");
		groupedQATEHigh.setSelected(false);
		groupedQAs.add(groupedQATEHigh);

		//Creates grouped QAs for Security
		groupedQAConf = qasvariabilitymodelFactory.createGroupedQA();
		groupedQAConf.setName("Confidentiality");
		groupedQAConf.setSelected(false);

		groupedQAIA = qasvariabilitymodelFactory.createGroupedQA();
		groupedQAIA.setName("Integrity & Authenticity");
		groupedQAIA.setSelected(false);

		groupedQAs = qaGroupSec.getChildren();
		groupedQAs.add(groupedQAConf);
		groupedQAs.add(groupedQAIA);
		
		//Creates High QA group
		qaGroupTEHigh = qasvariabilitymodelFactory.createQAGroup();
		qaGroupTEHigh.setName("High");
		qaGroupTEHigh.setMin(1);
		qaGroupTEHigh.setMax(1);
		groupedQATEHigh.getChildren().add(qaGroupTEHigh);

		//Creates Confidentiality QA group
		qaGroupConf = qasvariabilitymodelFactory.createQAGroup();
		qaGroupConf.setName("Confidentiality");
		qaGroupConf.setMin(1);
		qaGroupConf.setMax(1);
		groupedQAConf.getChildren().add(qaGroupConf);

		//Creates Integrity & Authenticity QA group
		qaGroupIA = qasvariabilitymodelFactory.createQAGroup();
		qaGroupIA.setName("Integrity & Authenticity");
		qaGroupIA.setMin(0);
		qaGroupIA.setMax(2);
		groupedQAIA.getChildren().add(qaGroupIA);

		//Creates grouped QAs for TE->High group
		groupedQAs = qaGroupTEHigh.getChildren();
		groupedQATEHigh = qasvariabilitymodelFactory.createGroupedQA();
		groupedQATEHigh.setName("Sync");
		groupedQATEHigh.setSelected(false);
		groupedQAs.add(groupedQATEHigh);

		groupedQATEHigh = qasvariabilitymodelFactory.createGroupedQA();
		groupedQATEHigh.setName("Async");
		groupedQATEHigh.setSelected(false);
		groupedQAs.add(groupedQATEHigh);
		
		//Creates grouped QAs for Sec->Conf group
		groupedQAs = qaGroupConf.getChildren();
		groupedQAConf = qasvariabilitymodelFactory.createGroupedQA();
		groupedQAConf.setName("Data Encrypted");
		groupedQAConf.setSelected(false);
		groupedQAs.add(groupedQAConf);

		groupedQAConf = qasvariabilitymodelFactory.createGroupedQA();
		groupedQAConf.setName("Data Unencrypted");
		groupedQAConf.setSelected(false);
		groupedQAs.add(groupedQAConf);
		
		//Creates grouped QAs for Sec->IA group
		groupedQAs = qaGroupIA.getChildren();
		groupedQAIA = qasvariabilitymodelFactory.createGroupedQA();
		groupedQAIA.setName("Authorization");
		groupedQAIA.setSelected(false);
		groupedQAs.add(groupedQAIA);

		groupedQAIA = qasvariabilitymodelFactory.createGroupedQA();
		groupedQAIA.setName("Authentication Lockout");
		groupedQAIA.setSelected(false);
		groupedQAs.add(groupedQAIA);

		return rootQA;
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
							QaconfigEditorPlugin.INSTANCE.log(exception);
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
				MessageDialog.openError(workbenchWindow.getShell(), QaconfigEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
				return false;
			}

			return true;
		}
		catch (Exception exception) {
			QaconfigEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public class QasvariabilitymodelModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public QasvariabilitymodelModelWizardNewFileCreationPage(String pageId, IStructuredSelection selection) {
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
					setErrorMessage(QaconfigEditorPlugin.INSTANCE.getString(key, new Object [] { FORMATTED_FILE_EXTENSIONS }));
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
	public class QasvariabilitymodelModelWizardInitialObjectCreationPage extends WizardPage {
		/**
		 * <!-- Jcifuentes -->
		 */
		protected Button bdefaultQAModel;

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
		public QasvariabilitymodelModelWizardInitialObjectCreationPage(String pageId) {
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
				containerLabel.setText(QaconfigEditorPlugin.INSTANCE.getString("_UI_ModelObject"));

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

			/*JC: Modificado para seleccionar el objeto RootQA por defecto
			if (initialObjectField.getItemCount() == 1) {
				initialObjectField.select(0);
			}*/
			initialObjectField.select(initialObjectField.indexOf(QaconfigEditorPlugin.INSTANCE.getString("_UI_QaconfigEditorDefaultModelObject")));
			//JC: Fin modificación

			initialObjectField.addModifyListener(validator);
			Label encodingLabel = new Label(composite, SWT.LEFT);
			{
				encodingLabel.setText(QaconfigEditorPlugin.INSTANCE.getString("_UI_XMLEncoding"));

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
			bdefaultQAModel = new Button(composite, SWT.CHECK);
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				bdefaultQAModel.setLayoutData(data);
			}
			bdefaultQAModel.setText(QaconfigEditorPlugin.INSTANCE.getString("_UI_DefaultQAModel"));
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
				return QaconfigEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
			}
			catch(MissingResourceException mre) {
				QaconfigEditorPlugin.INSTANCE.log(mre);
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
				for (StringTokenizer stringTokenizer = new StringTokenizer(QaconfigEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) {
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
		newFileCreationPage = new QasvariabilitymodelModelWizardNewFileCreationPage("Whatever", selection);
		newFileCreationPage.setTitle(QaconfigEditorPlugin.INSTANCE.getString("_UI_QasvariabilitymodelModelWizard_label"));
		newFileCreationPage.setDescription(QaconfigEditorPlugin.INSTANCE.getString("_UI_QasvariabilitymodelModelWizard_description"));
		newFileCreationPage.setFileName(QaconfigEditorPlugin.INSTANCE.getString("_UI_QasvariabilitymodelEditorFilenameDefaultBase") + "." + FILE_EXTENSIONS.get(0));
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
					String defaultModelBaseFilename = QaconfigEditorPlugin.INSTANCE.getString("_UI_QasvariabilitymodelEditorFilenameDefaultBase");
					String defaultModelFilenameExtension = FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename + "." + defaultModelFilenameExtension;
					for (int i = 1; ((IContainer)selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i + "." + defaultModelFilenameExtension;
					}
					newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		initialObjectCreationPage = new QasvariabilitymodelModelWizardInitialObjectCreationPage("Whatever2");
		initialObjectCreationPage.setTitle(QaconfigEditorPlugin.INSTANCE.getString("_UI_QasvariabilitymodelModelWizard_label"));
		initialObjectCreationPage.setDescription(QaconfigEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description"));
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
