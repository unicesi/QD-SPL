package co.shift.pcs.user.control;

import java.util.List;
import javax.ejb.Remote;
import co.shift.pcs.to.UserTO;

@Remote
public interface IUserDAO {
	
	public UserTO getProjectManager(int projectId);
	
	public List<UserTO> getUserFromProject(int projectId);
}
