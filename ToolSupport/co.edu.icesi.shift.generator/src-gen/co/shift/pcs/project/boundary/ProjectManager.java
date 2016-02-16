package co.shift.pcs.project.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.DatabaseException;
import co.shift.pcs.project.control.IProjectDAO;

import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.to.RiskTO;

import co.shift.pcs.project.control.IProjectBasicFLR;


import co.shift.pcs.security.PBECryptographyManager;

			

import co.shift.pcs.project.entity.Project;
import co.shift.pcs.project.entity.ProjectUser;
import co.shift.pcs.project.entity.ProjectUserPK;

@Stateless
public class ProjectManager implements IProjectManager {
	
	@PersistenceContext(unitName = "pcs")
	private EntityManager em;
	
	@EJB
	private IProjectDAO projectDAO;
	
	
	@EJB
	private IProjectBasicFLR basicFLR;
	
	@EJB
	private PBECryptographyManager cManager;
	
	
	public boolean createProject(ProjectTO project) throws Exception {
	char[] eDescriptionChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, project.getDescription());
	String eDescription = new String(eDescriptionChars);
	project.setDescription(eDescription);
	char[] eNameChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, project.getName());
	String eName = new String(eNameChars);
	project.setName(eName);
	
	
		Project foundProject = em.find(Project.class, project.getId());
		if (foundProject != null)
			throw new Exception("Project Alredy Exists");
		else {
			Project newProject = new Project();
			newProject.setId(project.getId());
			newProject.setDescription(project.getDescription());
			newProject.setName(project.getName());
			newProject.setStartDate(project.getStartDate());
			try {
				em.persist(newProject);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		}
	}
	public boolean updateProject(ProjectTO project) throws Exception {
		char[] eDescriptionChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, project.getDescription());
		String eDescription = new String(eDescriptionChars);
		project.setDescription(eDescription);
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, project.getName());
		String eName = new String(eNameChars);
		project.setName(eName);
		
		
		Project foundProject = em.find(Project.class, project.getId());
		if (foundProject == null)
			throw new Exception("Project Doesn't Exists");
		else {
			foundProject.setId(project.getId());
			foundProject.setDescription(project.getDescription());
			foundProject.setName(project.getName());
			foundProject.setStartDate(project.getStartDate());
		try {
			em.merge(foundProject);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			return false;
		}
	}
	}
	public List<ProjectTO> getAllProjects() {
	try {
	return basicFLR.getAllProjects();
	} catch (Exception e) {
	return null;
	}
	}
	
	public boolean addUserToProject(UserTO user, int projectId) throws Exception {
		char[] eCcChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, user.getCc());
		String eCc = new String(eCcChars);
		user.setCc(eCc);
		
		
		Project project = em.find(Project.class, projectId);
		ProjectUserPK pk = new ProjectUserPK();
		pk.setProjectId(projectId);
		pk.setUserCc(user.getCc());

		ProjectUser pU = em.find(ProjectUser.class, pk);
		if (pU == null) {
			pU = new ProjectUser();
			pU.setId(pk);
			pU.setProjectBean(project);
			project.getProjectUser().add(pU);

			try {
				em.merge(project);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		} else
			throw new Exception("User alredy exists in project");
	}					
	public boolean deleteProject(ProjectTO project) throws Exception {
		
		
		Project foundProject = em.find(Project.class, project.getId());
		if (foundProject == null)
			throw new Exception("Project Doesn't Exists");
		else {
			TypedQuery<Project> query = em.createNamedQuery(
				"project.deleteProject", Project.class);
			query.setParameter("id", project.getId());
			try {
				query.executeUpdate();
				return true;
			} catch (NoResultException e) {
				throw new Exception("Project Cannot Be Found");
			} catch (DatabaseException e) {
				throw new Exception("Project With Associated Data Cannot Be Deleted");
			}
		}
	}
	public boolean removeUserFromProject(UserTO user, int projectId) throws Exception {
		char[] eCcChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, user.getCc());
		String eCc = new String(eCcChars);
		user.setCc(eCc);
		
		
		Project project = em.find(Project.class, projectId);

		ProjectUserPK pk = new ProjectUserPK();
		pk.setProjectId(projectId);
		pk.setUserCc(user.getCc());
		ProjectUser pU = em.find(ProjectUser.class, pk);
		project.getProjectUser().remove(pU);

		try {
			em.merge(project);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			return false;
		}
	}
	public boolean setProjectManager(UserTO manager, int projectId) throws Exception {
		char[] eCcChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, manager.getCc());
		String eCc = new String(eCcChars);
		manager.setCc(eCc);
		
		
		Project project = em.find(Project.class, projectId);
		project.setManager(manager.getCc());

		try {
			em.merge(project);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			return false;
		}
	}
	public boolean setProjectPriorityRisk(RiskTO priorityrisk, int projectId) throws Exception {
		
		
		Project project = em.find(Project.class, projectId);
		project.setPriorityRisk(priorityrisk.getId());

		try {
			em.merge(project);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			return false;
		}
	}
	public List<ProjectTO> getProjectFromUser(String userCc) {
	char[] eCcChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, userCc);
	String eCc = new String(eCcChars);
	userCc = eCc;
	
	
	return projectDAO.getProjectFromUser(userCc);
	}
}
