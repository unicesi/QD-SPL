package co.shifts.pcs.authorization.boundary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.DatabaseException;

import co.shift.pcs.to.RoleTO;
import co.shift.pcs.to.ServiceTO;
import co.shift.pcs.to.UserTO;
import co.shifts.pcs.authorization.entity.Role;
import co.shifts.pcs.authorization.entity.Service;
import co.shifts.pcs.authorization.entity.UserRole;
import co.shifts.pcs.authorization.entity.UserRolePK;

/**
 * Session Bean implementation class AuthorizationManager
 */
@Stateless
public class AuthorizationManager implements IAuthorizationManager {

	@PersistenceContext(unitName = "co.shift.pcs.authorization")
	private EntityManager em;

	@Override
	public List<RoleTO> getUserRoles(String userID) {
		List<RoleTO> userRoles = new ArrayList<>();
		TypedQuery<Role> query = em.createNamedQuery("auth.getUserRoles",
				Role.class);
		query.setParameter("userid", userID);
		List<Role> foundUserRoles = query.getResultList();
		for (Role role : foundUserRoles) {
			userRoles.add(role.toTO());
		}
		return userRoles;
	}

	@Override
	public boolean createRole(RoleTO role) throws Exception {
		Role newRole = new Role();
		newRole.setDescription(role.getDescription());
		newRole.setName(role.getName());
		newRole.setServices(null);
		newRole.setUserRoles(null);

		try {
			em.persist(newRole);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			return false;
		}
	}

	@Override
	public boolean updateRole(RoleTO newRole) throws Exception {
		Role foundRole = em.find(Role.class, newRole.getName());
		if (foundRole == null)
			throw new Exception("Role Doesn't Exists");
		else {
			foundRole.setDescription(newRole.getDescription());

			try {
				em.merge(foundRole);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		}
	}

	@Override
	public boolean deleteRole(RoleTO role) throws Exception {
		Role foundRole = em.find(Role.class, role.getName());
		if (foundRole == null)
			throw new Exception("Role Doesn't Exists");
		else {
			TypedQuery<Role> query = em.createNamedQuery("auth.deleteRole",
					Role.class);
			query.setParameter("rid", role.getName());
			try {
				query.executeUpdate();
				return true;
			} catch (NoResultException e) {
				throw new Exception("Role Cannot Be Found");
			}
		}
	}

	@Override
	public boolean addRoleToUser(String user, RoleTO role) throws Exception {
		Role foundRole = em.find(Role.class, role.getName());
		UserRolePK pk = new UserRolePK();
		pk.setRole(role.getName());
		pk.setUser(user);

		UserRole uR = em.find(UserRole.class, pk);
		if (uR == null) {
			uR = new UserRole();
			uR.setId(pk);
			uR.setRoleBean(foundRole);
			foundRole.getUserRoles().add(uR);

			try {
				em.merge(foundRole);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		} else
			throw new Exception("Role alredy related to user");
	}

	@Override
	public boolean removeRoleFromUser(UserTO user, RoleTO role)
			throws Exception {
		Role foundRole = em.find(Role.class, role.getName());

		UserRolePK pk = new UserRolePK();
		pk.setRole(role.getName());
		pk.setUser(user.getIdNumber());
		UserRole uR = em.find(UserRole.class, pk);
		foundRole.getUserRoles().remove(uR);

		try {
			em.merge(foundRole);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			return false;
		}
	}

	@Override
	public boolean addServiceToRole(String roleName, ServiceTO service)
			throws Exception {
		Role foundRole = em.find(Role.class, roleName);
		Service foundService = em.find(Service.class, service.getName());

		if (!foundRole.getServices().contains(foundService)) {
			foundRole.getServices().add(foundService);

			try {
				em.merge(foundRole);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		} else
			throw new Exception("Service alredy related to role");
	}

	@Override
	public boolean removeServiceFromRole(RoleTO role, ServiceTO service)
			throws Exception {
		Role foundRole = em.find(Role.class, role.getName());
		Service foundService = em.find(Service.class, service.getName());

		if (foundRole.getServices().contains(foundService)) {
			foundRole.getServices().remove(foundService);

			try {
				em.merge(foundRole);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		} else
			throw new Exception("Service is not related to role");
	}

	@Override
	public List<RoleTO> getAllRoles() {
		List<RoleTO> roles = new ArrayList<>();
		TypedQuery<Role> query = em.createNamedQuery("auth.getAllRoles",
				Role.class);
		List<Role> foundRoles = query.getResultList();
		for (Role role : foundRoles) {
			roles.add(role.toTO());
		}
		return roles;
	}

	@Override
	public List<ServiceTO> getAllServices() {
		List<ServiceTO> services = new ArrayList<>();
		TypedQuery<Service> query = em.createNamedQuery("auth.getAllServices",
				Service.class);
		List<Service> foundServices = query.getResultList();
		for (Service service : foundServices) {
			services.add(service.toTO());
		}
		return services;
	}

	@Override
	public List<ServiceTO> getRoleServices(String roleName) {
		List<ServiceTO> roleServices = new ArrayList<>();
		Role foundRole = em.find(Role.class, roleName);
		if (foundRole != null) {
			List<Service> foundServices = foundRole.getServices();
			for (Service service : foundServices) {
				roleServices.add(service.toTO());
			}
		}
		return roleServices;
	}

	@Override
	public List<ServiceTO> getUserServices(String userId) {
		List<RoleTO> userRoles = getUserRoles(userId);
		Set<ServiceTO> userServicesHash = new HashSet<>();
		for (RoleTO roleTO : userRoles) {
			userServicesHash.addAll(getRoleServices(roleTO.getName()));
		}
		return new ArrayList<>(userServicesHash);
	}

}
