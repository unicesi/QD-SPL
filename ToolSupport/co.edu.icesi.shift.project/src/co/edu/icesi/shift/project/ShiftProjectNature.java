package co.edu.icesi.shift.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ShiftProjectNature implements IProjectNature {

	private IProject project;
	
	@Override
	public void configure() throws CoreException {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public IProject getProject() {
		// TODO Auto-generated method stub
		return project;
	}

	@Override
	public void setProject(IProject value) {
		// TODO Auto-generated method stub
		project = value;
	}

}
