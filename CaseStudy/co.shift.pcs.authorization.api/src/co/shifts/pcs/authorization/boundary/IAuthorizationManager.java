package co.shifts.pcs.authorization.boundary;

import java.util.List;

import javax.ejb.Remote;

import co.shift.pcs.to.RoleTO;
import co.shift.pcs.to.ServiceTO;
import co.shift.pcs.to.UserTO;

@Remote
public interface IAuthorizationManager {

	public List<RoleTO> getUserRoles(String userID);
	
	public List<RoleTO> getAllRoles();
	
	public List<ServiceTO> getAllServices();
	
	public List<ServiceTO> getRoleServices(String roleName);
	
	public boolean createRole (RoleTO role) throws Exception;
	
	public boolean updateRole (RoleTO newRole) throws Exception;

	public boolean deleteRole (RoleTO role) throws Exception;
	
	public boolean addRoleToUser (String user, RoleTO role) throws Exception;
	
	public boolean removeRoleFromUser (UserTO user, RoleTO role) throws Exception;
	
	public boolean addServiceToRole (String roleName, ServiceTO service) throws Exception;
	
	public boolean removeServiceFromRole (RoleTO role, ServiceTO service) throws Exception;
	
	public List<ServiceTO> getUserServices (String userId);
}
