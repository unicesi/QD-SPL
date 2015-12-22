package co.shift.pcs.projects.boundary;

import java.util.List;

import javax.ejb.Remote;
import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.to.UserTO;

@Remote
public interface IProjectManager {

	public boolean createProject(ProjectTO project) throws Exception;

	public boolean updateProject(ProjectTO project) throws Exception;

	public boolean deleteProject(ProjectTO project) throws Exception;
	
	public List<ProjectTO> getAllProjects();
	
	public boolean addUserToProject(UserTO user, int projectID) throws Exception;
	
	public boolean removeUserFromProject(UserTO user, int projectID) throws Exception;
	
	public boolean setProjectManager(UserTO manager, int projectID);
	
	public List<ProjectTO> getAllProjectsBasicFLR();
	
	public List<ProjectTO> getAllProjectsOptimizedFLR(int start, int maxResults);

	public List<ProjectTO> getAllProjectsParallelizer();
}
