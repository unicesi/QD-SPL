package co.shift.pcs.users.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.DatabaseException;

import co.shift.pcs.to.UserTO;
import co.shift.pcs.users.control.IUserDAO;
import co.shift.pcs.users.control.LockoutManager;
import co.shift.pcs.users.control.PBECryptographyManager;
import co.shift.pcs.users.entity.User;
import co.shift.pcs.util.boundary.Boundary;

@Boundary(responsibility = "Define basic User services")
@Stateless
public class UserManager implements IUserManager {

	@PersistenceContext(unitName = "co.shift.pcs.users")
	private EntityManager em;

	@EJB
	private IUserDAO userDAO;

	@EJB
	private PBECryptographyManager cManager;

	@EJB
	private LockoutManager lockOut;

	// @Override
	// public boolean addUser(UserTO user) throws Exception {
	// User newUser = em.find(User.class, user.getIdNumber());
	// if (newUser == null) {
	// newUser = new User();
	// newUser.setCellphone(user.getCellphone());
	// newUser.setIdNumber(user.getIdNumber());
	// newUser.setName(user.getName());
	//
	// try {
	// em.persist(newUser);
	// em.flush();
	// return true;
	// } catch (DatabaseException e) {
	// throw new Exception(e.getMessage());
	// }
	// } else
	// return true;
	// }

	// @Override
	// public boolean deleteUser(UserTO user) throws Exception {
	// User foundUser = em.find(User.class, user.getIdNumber());
	// if (foundUser == null)
	// throw new Exception("User Doesn't Exists");
	// else {
	// TypedQuery<User> query = em.createNamedQuery("users.deleteUser",
	// User.class);
	// query.setParameter("uid", user.getIdNumber());
	// try {
	// query.executeUpdate();
	// return true;
	// } catch (NoResultException e) {
	// throw new Exception("User Cannot Be Found");
	// }
	// }
	// }

	@Override
	public List<UserTO> getAllUsers() {
		List<UserTO> users = new ArrayList<>();
		TypedQuery<User> query = em.createNamedQuery("users.getAllUsers",
				User.class);
		List<User> foundUsers = query.getResultList();
		for (User project : foundUsers) {
			users.add(project.toTO());
		}
		return users;
	}

	@Override
	public List<UserTO> getUsersFromProject(int projectID) {
		return userDAO.getUsersFromProject(projectID);
	}

	@Override
	public UserTO getProjectManager(int projectID) {
		return userDAO.getProjectManager(projectID);
	}

	@Override
	public UserTO authenticate(String userID, String password) throws Exception {
		// User foundUser = em.find(User.class, userID);
		// if (foundUser != null) {
		// if (foundUser.getPassword().equals(password))
		// return foundUser.toTO();
		// else
		// throw new Exception("Incorrect password");
		// } else
		// throw new Exception("User doesn't exists");
		return lockOut.authenticate(userID, password);
	}

	@Override
	public UserTO authenticateSecure(String userID, String password)
			throws Exception {
		char[] eIdChars = cManager.doFinal(PBECryptographyManager.ENCRYPT,
				userID);
		String eId = new String(eIdChars);
		User foundUser = em.find(User.class, eId);

		if (foundUser != null) {
			char[] ePasswordChars = cManager.doFinal(
					PBECryptographyManager.ENCRYPT, password);
			String ePassword = new String(ePasswordChars);

			if (foundUser.getPassword().equals(ePassword))
				return foundUser.toTO();
			else
				throw new Exception("Incorrect password");
		} else
			throw new Exception("User doesn't exists");
	}
}
