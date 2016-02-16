package co.edu.icesi.shift.project;

//import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewProjectWizard extends Wizard implements INewWizard {
	
	private WizardNewProjectCreationPage page;

	public NewProjectWizard() {
		// TODO Auto-generated constructor stub
		setWindowTitle("New Project");
	}

	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
		page = new WizardNewProjectCreationPage("From Scratch Project Wizard");
		page.setTitle("New Project");
		page.setDescription("Creates a new QA Driven SPL project");
		addPage(page);

	}
	
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performFinish() {
		try {
			// TODO Auto-generated method stub
			// See http://www.programcreek.com/2011/05/eclipse-jdt-tutorial-java-model/
			// 

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
/*			IResource co.edu.uniandes.mdspl.util.resource = root.findMember(new Path(locationName));
			if (!useDefaults && (!co.edu.uniandes.mdspl.util.resource.exists() || !(co.edu.uniandes.mdspl.util.resource instanceof IContainer))) {
					throw new Exception("Container \"" + locationName + "\" does not exist.");
			}
			
			IContainer container = (IContainer) co.edu.uniandes.mdspl.util.resource;
			final IProject project = container.getProject();*/
			//Crea un nuevo projecto
			final IProject project = root.getProject(page.getProjectName());
			project.create(null);
			project.open(null);
			IProjectDescription description = project.getDescription();
			
			//Map props = project.getPersistentProperties();
			
			
			description.setLocation(page.getLocationPath());
			//Associate nature
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length+1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = "co.edu.icesi.shift.project.shiftprojectnature";
			description.setNatureIds(newNatures);
//			project.setDescription(description, null);

			IFolder folder = project.getFolder("models");
			folder.create(true, true, null);
/*	
 * 
			folder = project.getFolder("src-gen");
			folder.create(true, true, null);

			//Importar src code
			IOverwriteQuery overwriteQuery = new IOverwriteQuery() {
		        public String queryOverwrite(String file) { return ALL; }
			};
			String srcPathParent = "/Applications/EclipseModeling_Mars/workspace/";
			String srcPathChild = "co.shift.modeling";

			ImportOperation  importOperation = new ImportOperation( project.getFullPath(), 
					new File(srcPathParent, srcPathChild), FileSystemStructureProvider.INSTANCE, overwriteQuery);
			importOperation.setCreateContainerStructure(false);
			importOperation.run(new NullProgressMonitor());
*/
/*
 * intento de introducir JRE
 * 			IPath path = new Path("src");
			folder = project.getFolder(path);
			folder.create(true, true, null);
			JavaCore.newSourceEntry(project.getFullPath().append(path));
			PreferenceConstants.getDefaultJRELibrary();

			project.set*/
/*
			folder = project.getFolder("src");
			folder.create(true, true, null);
			folder = project.getFolder("src/co");
			folder.create(true, true, null);
			folder = project.getFolder("src/co/shift");
			folder.create(true, true, null);
			folder = project.getFolder("src/co/shift/generators");
			folder.create(true, true, null);
			folder = project.getFolder("src/co/shift/generators/workflows");
			folder.create(true, true, null);

			//Crea el archivo destino
			IFile file = project.getFile("src/co/shift/generators/workflows/WF.mwe2");
			//obtiene los datos del archivo origen
			FileInputStream source = new FileInputStream("src/co/edu/icesi/shift/mainprojectplugin/WF.mwe2");
			file.create(source, true, null);*/

			return true;
		}catch (CoreException e) {
			// TODO Auto-generated catch block
			MessageDialog.openError(getShell(), "Error", e.getMessage());
			return false;
		}
	}

/*	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "co.edu.icesi.shift.crearpryplugin", IStatus.OK, message, null);
		throw new CoreException(status);
	}
*/
}
