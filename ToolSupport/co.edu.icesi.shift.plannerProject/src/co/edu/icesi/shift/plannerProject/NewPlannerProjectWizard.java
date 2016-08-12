package co.edu.icesi.shift.plannerProject;



//import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewPlannerProjectWizard extends Wizard implements INewWizard {
	
	private WizardNewProjectCreationPage page;

	public NewPlannerProjectWizard() {
		// TODO Auto-generated constructor stub
		setWindowTitle("New Project");
	}

	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
		page = new WizardNewProjectCreationPage("From Scratch Project Wizard");
		page.setTitle("New Project");
		page.setDescription("Creates a new planner project");
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
			//Crea un nuevo projecto
			final IProject project = root.getProject(page.getProjectName());
			project.create(null);
			project.open(null);
			
			//Map props = project.getPersistentProperties();
			
/*			//Crear el proyecto Java
			IProjectDescription description = project.getDescription();
			//description.setLocation(page.getLocationPath());
			//Associate nature
			description.setNatureIds(new String[]{JavaCore.NATURE_ID});
			project.setDescription(description, null);
			IJavaProject javaProject = JavaCore.create(project);
*/
			IFolder folder = project.getFolder("models");
			folder.create(true, true, null);
			folder = project.getFolder("src-gen");
			folder.create(true, true, null);		

			return true;
		}catch (CoreException e) {
			// TODO Auto-generated catch block
			MessageDialog.openError(getShell(), "Error", e.getMessage());
			return false;
		}
	}
/*
	@Override
	public boolean performFinish() {
		try {
			// TODO Auto-generated method stub
			// See http://www.programcreek.com/2011/05/eclipse-jdt-tutorial-java-model/
			// 

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
//			IResource co.edu.uniandes.mdspl.util.resource = root.findMember(new Path(locationName));
//			if (!useDefaults && (!co.edu.uniandes.mdspl.util.resource.exists() || !(co.edu.uniandes.mdspl.util.resource instanceof IContainer))) {
//					throw new Exception("Container \"" + locationName + "\" does not exist.");
//			}
			
//			IContainer container = (IContainer) co.edu.uniandes.mdspl.util.resource;
//			final IProject project = container.getProject();
			//Crea un nuevo projecto
			final IProject project = root.getProject(page.getProjectName());
			project.create(null);
			project.open(null);
			
			//Map props = project.getPersistentProperties();
			
			//Crear el proyecto Java
			IProjectDescription description = project.getDescription();
			//description.setLocation(page.getLocationPath());
			//Associate nature
			description.setNatureIds(new String[]{JavaCore.NATURE_ID});
			project.setDescription(description, null);
			IJavaProject javaProject = JavaCore.create(project);

			IFolder folder = project.getFolder("models");
			folder.create(true, true, null);
			folder = project.getFolder("src");
			folder.create(true, true, null);
			folder = project.getFolder("src-gen");
			folder.create(true, true, null);

			List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
			IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
			LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
			for (LibraryLocation element : locations) {
				 entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
			}
			//add libs to project class path
			javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);

			//javaProject.setOutputLocation(srcfolder.getFullPath(), null);
		

			return true;
		}catch (CoreException e) {
			// TODO Auto-generated catch block
			MessageDialog.openError(getShell(), "Error", e.getMessage());
			return false;
		}
	}
*/
/*	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "co.edu.icesi.shift.crearpryplugin", IStatus.OK, message, null);
		throw new CoreException(status);
	}
*/
}
