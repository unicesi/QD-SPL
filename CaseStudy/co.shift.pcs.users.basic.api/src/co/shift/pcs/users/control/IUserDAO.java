package co.shift.pcs.users.control;

import java.util.List;

import javax.ejb.Remote;

import co.shift.pcs.to.UserTO;

@Remote
public interface IUserDAO {

	public List<UserTO> getUsersFromProject(int projectID);
	
	public UserTO getProjectManager(int projectID);
}
