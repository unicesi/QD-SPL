package co.shift.templates.ejb.contributed.authenticity

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeGenerator

class AuthImplTemplate {
	
	def static generate (String packageName, BusinessEntity authEntity) '''
		package co.shift.«packageName.toLowerCase()».authorization.boundary;
		
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
		
		import co.shift.«packageName.toLowerCase()».to.RoleTO;
		import co.shift.«packageName.toLowerCase()».to.ServiceTO;
		import co.shift.«packageName.toLowerCase()».to.«authEntity.name.toFirstUpper»TO;
		import co.shift.«packageName.toLowerCase()».authorization.entity.Role;
		import co.shift.«packageName.toLowerCase()».authorization.entity.Service;
		import co.shift.«packageName.toLowerCase()».authorization.entity.«authEntity.name.toFirstUpper»Role;
		import co.shift.«packageName.toLowerCase()».authorization.entity.«authEntity.name.toFirstUpper»RolePK;
		
		@Stateless
		public class AuthorizationManager implements IAuthorizationManager {
			
			@PersistenceContext(unitName = "co.shift.«packageName.toLowerCase()».authorization")
			private EntityManager em;
			
		«var authId = DomainCodeGenerator.getID(authEntity)»
			public List<RoleTO> get«authEntity.name.toFirstUpper»Roles(«DomainCodeGenerator.getType(authId)» «authId.name.toLowerCase») {
				List<RoleTO> «authEntity.name.toLowerCase»Roles = new ArrayList<>();
				TypedQuery<Role> query = em.createNamedQuery("auth.get«authEntity.name.toFirstUpper»Roles",
						Role.class);
				query.setParameter("«authEntity.name.toLowerCase»id", «authId.name.toLowerCase»);
				List<Role> found«authEntity.name.toFirstUpper»Roles = query.getResultList();
				for (Role role : found«authEntity.name.toFirstUpper»Roles) {
					«authEntity.name.toLowerCase»Roles.add(role.toTO());
				}
				return «authEntity.name.toLowerCase»Roles;
			}
			
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
			
			public boolean createRole (RoleTO role) throws Exception {
				Role newRole = new Role();
				newRole.setDescription(role.getDescription());
				newRole.setName(role.getName());
				newRole.setServices(null);
				newRole.set«authEntity.name.toFirstUpper»Roles(null);
		
				try {
					em.persist(newRole);
					em.flush();
					return true;
				} catch (DatabaseException e) {
					return false;
				}
			}
			
			public boolean updateRole (RoleTO newRole) throws Exception {
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
			
			public boolean addRoleTo«authEntity.name.toFirstUpper» («DomainCodeGenerator.getType(authId)» user, RoleTO role) throws Exception {
				Role foundRole = em.find(Role.class, role.getName());
				«authEntity.name.toFirstUpper»RolePK pk = new «authEntity.name.toFirstUpper»RolePK();
				pk.setRole(role.getName());
				pk.set«authEntity.name.toFirstUpper»(user);
		
				«authEntity.name.toFirstUpper»Role uR = em.find(«authEntity.name.toFirstUpper»Role.class, pk);
				if (uR == null) {
					uR = new «authEntity.name.toFirstUpper»Role();
					uR.setId(pk);
					uR.setRoleBean(foundRole);
					foundRole.get«authEntity.name.toFirstUpper»Roles().add(uR);
		
					try {
						em.merge(foundRole);
						em.flush();
						return true;
					} catch (DatabaseException e) {
						return false;
					}
				} else
					throw new Exception("Role alredy related to «authEntity.name.toLowerCase»");
			}
			
			public boolean removeRoleFrom«authEntity.name.toFirstUpper» («authEntity.name.toFirstUpper»TO user, RoleTO role) throws Exception {
				Role foundRole = em.find(Role.class, role.getName());

				«authEntity.name.toFirstUpper»RolePK pk = new «authEntity.name.toFirstUpper»RolePK();
				pk.setRole(role.getName());
				pk.set«authEntity.name.toFirstUpper»(«authEntity.name.toLowerCase».get«DomainCodeGenerator.getID(authEntity).name.toFirstUpper»());
				«authEntity.name.toFirstUpper»Role uR = em.find(«authEntity.name.toFirstUpper»Role.class, pk);
				foundRole.get«authEntity.name.toFirstUpper»Roles().remove(uR);
		
				try {
					em.merge(foundRole);
					em.flush();
					return true;
				} catch (DatabaseException e) {
					return false;
				}
			}
			
			public boolean addServiceToRole (String roleName, ServiceTO service) throws Exception {
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
			
			public List<ServiceTO> get«authEntity.name.toFirstUpper»Services («DomainCodeGenerator.getType(authId)» «authId.name.toLowerCase») {
				List<RoleTO> «authEntity.name.toLowerCase»Roles = get«authEntity.name.toFirstUpper»Roles(«authId.name.toLowerCase»);
				Set<ServiceTO> «authEntity.name.toLowerCase»ServicesHash = new HashSet<>();
				for (RoleTO roleTO : «authEntity.name.toLowerCase»Roles) {
					«authEntity.name.toLowerCase»ServicesHash.addAll(getRoleServices(roleTO.getName()));
				}
				return new ArrayList<>(«authEntity.name.toLowerCase»ServicesHash);
			}
		}
	'''
}