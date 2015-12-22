package co.shift.pcs.authorization.boundary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.DatabaseException;

import co.shift.pcs.to.RoleTO;
import co.shift.pcs.to.ServiceTO;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.authorization.entity.Role;
import co.shift.pcs.authorization.entity.Service;
import co.shift.pcs.authorization.entity.UserRole;
import co.shift.pcs.authorization.entity.UserRolePK;
import co.shift.pcs.security.PBECryptographyManager;


@Stateless
public class AuthorizationManager implements IAuthorizationManager {
	
	@PersistenceContext(unitName = "pcs")
	private EntityManager em;
	
	@EJB
	private PBECryptographyManager cManager;
	
	
	public List<RoleTO> getUserRoles(String cc) {
		List<RoleTO> userRoles = new ArrayList<>();
		TypedQuery<Role> query = em.createNamedQuery("auth.getUserRoles",
				Role.class);
		char[] eCCChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, cc);
		String eCCName = new String(eCCChars);
		cc = eCCName;
		query.setParameter("userid", cc);
		List<Role> foundUserRoles = query.getResultList();
		for (Role role : foundUserRoles) {
			RoleTO to = new RoleTO();
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, role.getName());
			String eName = new String(eNameChars);
			to.setName(eName);
			char[] eDesriptionChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, role.getDescription());
			String eDescription = new String(eDesriptionChars);
			to.setDescription(eDescription);
			userRoles.add(to);
		}
		return userRoles;
	}
	
	public List<RoleTO> getAllRoles() {
		List<RoleTO> roles = new ArrayList<>();
		TypedQuery<Role> query = em.createNamedQuery("auth.getAllRoles",
				Role.class);
		List<Role> foundRoles = query.getResultList();
		for (Role role : foundRoles) {
			RoleTO to = new RoleTO();
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, role.getName());
			String eName = new String(eNameChars);
			to.setName(eName);
			char[] eDesriptionChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, role.getDescription());
			String eDescription = new String(eDesriptionChars);
			to.setDescription(eDescription);
			roles.add(to);
		}
		return roles;
	}
	
	public List<ServiceTO> getAllServices() {
		List<ServiceTO> services = new ArrayList<>();
		TypedQuery<Service> query = em.createNamedQuery("auth.getAllServices",
				Service.class);
		List<Service> foundServices = query.getResultList();
		for (Service service : foundServices) {
			ServiceTO to = new ServiceTO();
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, service.getName());
			String eName = new String(eNameChars);
			to.setName(eName);
			char[] eDesriptionChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, service.getDescription());
			String eDescription = new String(eDesriptionChars);
			to.setDescription(eDescription);
			services.add(to);
		}
		return services;
	}
	
	public List<ServiceTO> getRoleServices(String roleName) {
		List<ServiceTO> roleServices = new ArrayList<>();
		char[] eUNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, roleName);
		String eUName = new String(eUNameChars);
		roleName = eUName;
		Role foundRole = em.find(Role.class, roleName);
		if (foundRole != null) {
			List<Service> foundServices = foundRole.getServices();
			for (Service service : foundServices) {
				ServiceTO to = new ServiceTO();
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.DECRYPT, service.getName());
				String eName = new String(eNameChars);
				to.setName(eName);
				char[] eDesriptionChars = cManager.doFinal(
				PBECryptographyManager.DECRYPT, service.getDescription());
				String eDescription = new String(eDesriptionChars);
				to.setDescription(eDescription);
				roleServices.add(to);
			}
		}
		return roleServices;
	}
	
	public boolean createRole (RoleTO role) throws Exception {
		Role newRole = new Role();
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, role.getName());
		String eName = new String(eNameChars);
		role.setName(eName);
		char[] eDesriptionChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, role.getDescription());
		String eDescription = new String(eDesriptionChars);
		role.setDescription(eDescription);
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
	
	public boolean updateRole (RoleTO newRole) throws Exception {
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, newRole.getName());
		String eName = new String(eNameChars);
		newRole.setName(eName);
		char[] eDesriptionChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, newRole.getDescription());
		String eDescription = new String(eDesriptionChars);
		newRole.setDescription(eDescription);
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

	public boolean deleteRole (RoleTO role) throws Exception {
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, role.getName());
		String eName = new String(eNameChars);
		role.setName(eName);
		char[] eDesriptionChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, role.getDescription());
		String eDescription = new String(eDesriptionChars);
		role.setDescription(eDescription);
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
	
	public boolean addRoleToUser (String user, RoleTO role) throws Exception {
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, role.getName());
		String eName = new String(eNameChars);
		role.setName(eName);
		char[] eUNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, user);
		String eUName = new String(eUNameChars);
		user = eUName;
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
	
	public boolean removeRoleFromUser (UserTO user, RoleTO role) throws Exception {
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, role.getName());
		String eName = new String(eNameChars);
		role.setName(eName);
		char[] eUNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, user.getCc());
		String eUName = new String(eUNameChars);
		user.setCc(eUName);
		Role foundRole = em.find(Role.class, role.getName());

		UserRolePK pk = new UserRolePK();
		pk.setRole(role.getName());
		pk.setUser(user.getCc());
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
	
	public boolean addServiceToRole (String roleName, ServiceTO service) throws Exception {
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, roleName);
		String eName = new String(eNameChars);
		roleName = eName;
		char[] eUNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, service.getName());
		String eUName = new String(eUNameChars);
		service.setName(eUName);
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
	
	public boolean removeServiceFromRole (RoleTO role, ServiceTO service) throws Exception {
		char[] eNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, role.getName());
		String eName = new String(eNameChars);
		role.setName(eName);
		char[] eUNameChars = cManager.doFinal(
		PBECryptographyManager.ENCRYPT, service.getName());
		String eUName = new String(eUNameChars);
		service.setName(eUName);
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
	
	public List<ServiceTO> getUserServices (String cc) {
		List<RoleTO> userRoles = getUserRoles(cc);
		Set<ServiceTO> userServicesHash = new HashSet<>();
		for (RoleTO roleTO : userRoles) {
			userServicesHash.addAll(getRoleServices(roleTO.getName()));
		}
		return new ArrayList<>(userServicesHash);
	}
}
