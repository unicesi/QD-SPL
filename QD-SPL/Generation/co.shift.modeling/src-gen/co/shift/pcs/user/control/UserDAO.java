package co.shift.pcs.user.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.shift.pcs.to.UserTO;
import co.shift.pcs.user.control.PBECryptographyManager;


@Stateless
public class UserDAO implements IUserDAO {
	
	@PersistenceContext(unitName = "co.shift.pcs.user")
	private EntityManager em;
	
	@EJB
	private PBECryptographyManager cManager;
	

	public UserTO getProjectManager(int projectId){
		Query query = em
		.createNativeQuery("SELECT u.* FROM User u, Project p WHERE p.manager = u.cc AND p.id = "
				+ projectId);
		try {
			Object[] manager = (Object[]) query.getSingleResult();
			UserTO u = new UserTO();
			String tCc = (String) manager[0];
			String tName = (String) manager[1];
			String tCellphone = (String) manager[2];
			String tPassword = (String) manager[3];
			char[] eCcChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tCc);
			String eCc = new String(eCcChars);
			tCc = eCc;
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			char[] eCellphoneChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tCellphone);
			String eCellphone = new String(eCellphoneChars);
			tCellphone = eCellphone;
			char[] ePasswordChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tPassword);
			String ePassword = new String(ePasswordChars);
			tPassword = ePassword;
			
			
			u.setCc(tCc);
			u.setName(tName);
			u.setCellphone(tCellphone);
			u.setPassword(tPassword);
			return u;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<UserTO> getUserFromProject(int projectId){
		List<UserTO> users = new ArrayList<>();
		Query query = em
				.createNativeQuery("SELECT u.* FROM User u, ProjectUser pu WHERE u.cc = pu.user AND pu.project = "
						+ projectId);
		List<Object[]> foundUsers = query.getResultList();
		UserTO u = null;
		for (Object[] user : foundUsers) {
			u = new UserTO();
			String tCc = (String) user[0];
			String tName = (String) user[1];
			String tCellphone = (String) user[2];
			String tPassword = (String) user[3];
			char[] eCcChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tCc);
			String eCc = new String(eCcChars);
			tCc = eCc;
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			char[] eCellphoneChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tCellphone);
			String eCellphone = new String(eCellphoneChars);
			tCellphone = eCellphone;
			char[] ePasswordChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tPassword);
			String ePassword = new String(ePasswordChars);
			tPassword = ePassword;
			
			
			u.setCc(tCc);
			u.setName(tName);
			u.setCellphone(tCellphone);
			u.setPassword(tPassword);
			users.add(u);
		}
		return users;
	}
	}
