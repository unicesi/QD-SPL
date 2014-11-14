package co.shift.pcs.project.boundary;

import java.util.List;
import javax.ejb.Remote;

import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.to.UserTO;

@Remote
public interface IProjectManager {
	
	public boolean createProject(ProjectTO project) throws Exception;
	
	public boolean updateProject(ProjectTO project) throws Exception;
	
	public List<ProjectTO> getAllProjects();
	
	
	public boolean addUserToProject(UserTO user, int projectId) throws Exception;
	
	public boolean deleteProject(ProjectTO project) throws Exception;
	
	public boolean removeUserFromProject(UserTO user, int projectId) throws Exception;
	
	
	public boolean setProjectManager(UserTO manager, int projectId) throws Exception;
	
	
	public List<ProjectTO> getProjectFromUser(String userCc);
	
}
