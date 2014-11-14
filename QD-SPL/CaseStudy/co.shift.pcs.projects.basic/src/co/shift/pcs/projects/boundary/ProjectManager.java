package co.shift.pcs.projects.boundary;

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

import co.shift.pcs.projects.control.IProjectBasicFLR;
import co.shift.pcs.projects.control.IProjectOptimizedFLR;
import co.shift.pcs.projects.control.IProjectParallelizer;
import co.shift.pcs.projects.entity.Project;
import co.shift.pcs.projects.entity.ProjectUser;
import co.shift.pcs.projects.entity.ProjectUserPK;
import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.util.boundary.Boundary;

@Boundary(responsibility = "Define basic Project services")
@Stateless
public class ProjectManager implements IProjectManager {

	@PersistenceContext(unitName = "co.shift.pcs.projects")
	private EntityManager em;

	@EJB
	private IProjectBasicFLR basicFLR;

	@EJB
	private IProjectOptimizedFLR optimizedFLR;
	
	@EJB
	private IProjectParallelizer parallelizer;

	@Override
	public boolean createProject(ProjectTO project) throws Exception {
		Project newProject = new Project();
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

	@Override
	public boolean updateProject(ProjectTO project) throws Exception {
		Project foundProject = em.find(Project.class, project.getId());
		if (foundProject == null)
			throw new Exception("Project Doesn't Exists");
		else {
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

	@Override
	public boolean deleteProject(ProjectTO project) throws Exception {
		Project foundProject = em.find(Project.class, project.getId());
		if (foundProject == null)
			throw new Exception("Project Doesn't Exists");
		else {
			TypedQuery<Project> query = em.createNamedQuery(
					"projects.deleteProject", Project.class);
			query.setParameter("pid", project.getId());
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

	@Override
	public List<ProjectTO> getAllProjects() {
		List<ProjectTO> projects = new ArrayList<>();
		TypedQuery<Project> query = em.createNamedQuery(
				"projects.getAllProjects", Project.class);
		List<Project> foundProducts = query.getResultList();
		for (Project project : foundProducts) {
			projects.add(project.toTO());
		}
		return projects;
	}

	@Override
	public boolean addUserToProject(UserTO user, int projectID)
			throws Exception {
		Project project = em.find(Project.class, projectID);
		ProjectUserPK pk = new ProjectUserPK();
		pk.setProject(projectID);
		pk.setUser(user.getIdNumber());

		ProjectUser pU = em.find(ProjectUser.class, pk);
		if (pU == null) {
			pU = new ProjectUser();
			pU.setId(pk);
			pU.setProjectBean(project);
			project.getProjectUsers().add(pU);

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

	@Override
	public boolean removeUserFromProject(UserTO user, int projectID)
			throws Exception {
		Project project = em.find(Project.class, projectID);

		if (!project.getManager().equals(user.getIdNumber())) {
			ProjectUserPK pk = new ProjectUserPK();
			pk.setProject(projectID);
			pk.setUser(user.getIdNumber());
			ProjectUser pU = em.find(ProjectUser.class, pk);
			project.getProjectUsers().remove(pU);

			try {
				em.merge(project);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		} else
			throw new Exception(
					"User cannot be removed from project because is its manager");
	}

	@Override
	public boolean setProjectManager(UserTO manager, int projectID) {
		Project project = em.find(Project.class, projectID);
		project.setManager(manager.getIdNumber());

		try {
			em.merge(project);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			return false;
		}
	}

	@Override
	public List<ProjectTO> getAllProjectsBasicFLR() {
		try {
			return basicFLR.getAllProjects();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ProjectTO> getAllProjectsOptimizedFLR(int start, int maxResults) {
		return optimizedFLR.getProducts(start, maxResults);
	}

	@Override
	public List<ProjectTO> getAllProjectsParallelizer() {
		Query query = em
				.createNativeQuery("SELECT COUNT(p.id) FROM Projects p");
		long projectsCount = (long) query.getSingleResult();
		return parallelizer.getAllProjects(projectsCount);
	}
}
