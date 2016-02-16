package co.shift.pcs.user.boundary;

import java.util.List;
import javax.ejb.Remote;

import co.shift.pcs.to.UserTO;

@Remote
public interface IUserManager {
	
	public List<UserTO> getAllUsers();
	
	
	public boolean createUser(UserTO user) throws Exception;
	
	public UserTO getProjectManager(int projectId);
	
	public List<UserTO> getUserFromProject(int projectId);
	
	public UserTO authenticate(String userCc, String password) throws Exception;
}
