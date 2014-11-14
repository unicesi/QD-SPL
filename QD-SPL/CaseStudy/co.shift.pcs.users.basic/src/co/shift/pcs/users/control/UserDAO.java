package co.shift.pcs.users.control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.shift.pcs.to.UserTO;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
public class UserDAO implements IUserDAO {

	@PersistenceContext(unitName = "co.shift.pcs.users")
	private EntityManager em;

	@Override
	public List<UserTO> getUsersFromProject(int projectID) {
		List<UserTO> users = new ArrayList<>();
		Query query = em
				.createNativeQuery("SELECT u.* FROM Users u, ProjectUser pu WHERE u.idNumber = pu.user AND pu.project = "
						+ projectID);
		List<Object[]> foundUsers = query.getResultList();
		UserTO u = null;
		for (Object[] user : foundUsers) {
			u = new UserTO();
			u.setIdNumber((String) user[0]);
			u.setName((String) user[1]);
			u.setCellphone((String) user[2]);
			users.add(u);
		}
		return users;
	}

	@Override
	public UserTO getProjectManager(int projectID) {
		Query query = em
				.createNativeQuery("SELECT u.* FROM Users u, Projects p WHERE p.manager = u.idNumber AND p.id = "
						+ projectID);
		try {
			Object[] manager = (Object[]) query.getSingleResult();
			UserTO u = new UserTO();
			u.setIdNumber((String) manager[0]);
			u.setName((String) manager[1]);
			u.setCellphone((String) manager[2]);
			return u;
		} catch (NoResultException e) {
			return null;
		}
	}

}
