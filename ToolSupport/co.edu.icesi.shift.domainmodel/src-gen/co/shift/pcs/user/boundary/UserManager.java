package co.shift.pcs.user.boundary;

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
import co.shift.pcs.user.control.IUserDAO;

import co.shift.pcs.to.UserTO;

import co.shift.pcs.user.control.IUserBasicFLR;


import co.shift.pcs.security.PBECryptographyManager;

			
import co.shift.pcs.user.control.LockoutManager;


import co.shift.pcs.user.entity.User;

@Stateless
public class UserManager implements IUserManager {
	
	@PersistenceContext(unitName = "pcs")
	private EntityManager em;
	
	@EJB
	private IUserDAO userDAO;
	
	@EJB
	private LockoutManager lockOut;
	
	
	@EJB
	private IUserBasicFLR basicFLR;
	
	@EJB
	private PBECryptographyManager cManager;
	
	
	public List<UserTO> getAllUsers() {
	try {
	return basicFLR.getAllUsers();
	} catch (Exception e) {
	return null;
	}
	}
	
	public boolean createUser(UserTO user) throws Exception {
	char[] eCcChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, user.getCc());
	String eCc = new String(eCcChars);
	user.setCc(eCc);
	char[] eNameChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, user.getName());
	String eName = new String(eNameChars);
	user.setName(eName);
	char[] eCellphoneChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, user.getCellphone());
	String eCellphone = new String(eCellphoneChars);
	user.setCellphone(eCellphone);
	char[] ePasswordChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, user.getPassword());
	String ePassword = new String(ePasswordChars);
	user.setPassword(ePassword);
	
	
		User foundUser = em.find(User.class, user.getCc());
		if (foundUser != null)
			throw new Exception("User Alredy Exists");
		else {
			User newUser = new User();
			newUser.setCc(user.getCc());
			newUser.setName(user.getName());
			newUser.setCellphone(user.getCellphone());
			newUser.setPassword(user.getPassword());
			try {
				em.persist(newUser);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		}
	}
	public UserTO getProjectManager(int projectId) {
		
		
		return userDAO.getProjectManager(projectId);
	}
	public List<UserTO> getUserFromProject(int projectId) {
	
	
	return userDAO.getUserFromProject(projectId);
	}
	public UserTO authenticate(String userCc, String password) throws Exception {
		char[] eCcChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, userCc);
		String eCc = new String(eCcChars);char[] ePasswordChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, password);
		String ePassword = new String(ePasswordChars);
		
		UserTO to = lockOut.authenticate(eCc, ePassword);
		if (to != null) {
		to.setCc(userCc);
		to.setPassword(password);
		} return to;
		
	}
}
