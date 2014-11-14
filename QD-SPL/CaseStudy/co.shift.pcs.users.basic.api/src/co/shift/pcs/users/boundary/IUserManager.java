package co.shift.pcs.users.boundary;

import java.util.List;

import javax.ejb.Remote;
import co.shift.pcs.to.UserTO;

@Remote
public interface IUserManager {

//	public boolean addUser(UserTO user) throws Exception;

//	public boolean deleteUser(UserTO user) throws Exception;

	public List<UserTO> getAllUsers();

	public List<UserTO> getUsersFromProject(int projectID);

	public UserTO getProjectManager(int projectID);

	public UserTO authenticate(String userID, String password) throws Exception;
	
	public UserTO authenticateSecure(String userID, String password) throws Exception;
}
