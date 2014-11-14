package co.shift.pcs.project.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.project.control.PBECryptographyManager;


@Stateless
public class ProjectDAO implements IProjectDAO {
	
	@PersistenceContext(unitName = "co.shift.pcs.project")
	private EntityManager em;
	
	@EJB
	private PBECryptographyManager cManager;
	

	
	public List<ProjectTO> getProjectFromUser(String userCc){
		List<ProjectTO> projects = new ArrayList<>();
		Query query = em
				.createNativeQuery("SELECT u.* FROM Project u, UserProject pu WHERE u.id = pu.project AND pu.user = "
						+ userCc);
		List<Object[]> foundProjects = query.getResultList();
		ProjectTO u = null;
		for (Object[] project : foundProjects) {
			u = new ProjectTO();
			int tId = (int) project[0];
			String tDescription = (String) project[1];
			String tName = (String) project[2];
			Date tStartDate = (Date) project[3];
			char[] eDescriptionChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tDescription);
			String eDescription = new String(eDescriptionChars);
			tDescription = eDescription;
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			
			
			u.setId(tId);
			u.setDescription(tDescription);
			u.setName(tName);
			u.setStartDate(tStartDate);
			projects.add(u);
		}
		return projects;
	}
	}
