package co.shift.templates.ejb.contributed.authenticity

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities
import co.shift.generators.domain.DomainParams

class AuthImplTemplate {
	
	private static String className = new Object(){}.class.enclosingClass.simpleName

	def static generate (String packageName, BusinessEntity authEntity) '''
		««« Establece la plantilla actual para contribución.
		«DomainCodeUtilities.beginTemplate(className)»
		package co.shift.«packageName.toLowerCase()».authorization.boundary;
		
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
		
		import co.shift.«packageName.toLowerCase()».to.RoleTO;
		import co.shift.«packageName.toLowerCase()».to.ServiceTO;
		import co.shift.«packageName.toLowerCase()».to.«authEntity.name.toFirstUpper»TO;
		import co.shift.«packageName.toLowerCase()».authorization.entity.Role;
		import co.shift.«packageName.toLowerCase()».authorization.entity.Service;
		import co.shift.«packageName.toLowerCase()».authorization.entity.«authEntity.name.toFirstUpper»Role;
		import co.shift.«packageName.toLowerCase()».authorization.entity.«authEntity.name.toFirstUpper»RolePK;
««« Jcifuentes: Comentado
«««		«DomainCodeUtilities.extendContribution("_r_2_10_12_13", DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_IMPORT, packageName)»
		«DomainCodeUtilities.beginSection(DomainParams.SECT_IMPORTS)»
		«DomainCodeUtilities.contribute2Template(1, packageName)»
		«DomainCodeUtilities.endSection»
		
		@Stateless
		public class AuthorizationManager implements IAuthorizationManager {
			
			@PersistenceContext(unitName = "«packageName»")
			private EntityManager em;
			
««« Jcifuentes: Comentado
«««			«val attribute2 = DomainCodeUtilities.extendContribution("_r_2_10_12_13", DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_ATTRIBUTE)»
«««			«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
«««				«attribute2»
«««			«ENDIF»
		«DomainCodeUtilities.beginSection(DomainParams.SECT_ATTRIBUTES)»
		«DomainCodeUtilities.contribute2Template(1)»
		«DomainCodeUtilities.endSection»
			
		«var authId = DomainCodeUtilities.getID(authEntity)»
			public List<RoleTO> get«authEntity.name.toFirstUpper»Roles(«DomainCodeUtilities.getType(authId)» «authId.name.toLowerCase») {
				List<RoleTO> «authEntity.name.toLowerCase»Roles = new ArrayList<>();
				TypedQuery<Role> query = em.createNamedQuery("auth.get«authEntity.name.toFirstUpper»Roles",
						Role.class);
««« Jcifuentes: Validaciones como la siguiente no deberían hacerse. Esto deberia
««« utilizar el mecanismo de los contribuyentes.Por ejemplo, todo este IF deberia
««« reemplazarse por una linea como la siguiente (habiendo marcado previamente la
««« seccion de METHODS):
««« 	«DomainCodeUtilities.contribute2Template(1)»
				«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»
				char[] eCCChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, «authId.name.toLowerCase»);
				String eCCName = new String(eCCChars);
				«authId.name.toLowerCase» = eCCName;
				«ENDIF»
				query.setParameter("«authEntity.name.toLowerCase»id", «authId.name.toLowerCase»);
				List<Role> found«authEntity.name.toFirstUpper»Roles = query.getResultList();
				for (Role role : found«authEntity.name.toFirstUpper»Roles) {
					RoleTO to = new RoleTO();
					«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
					char[] eNameChars = cManager.doFinal(
					PBECryptographyManager.DECRYPT, role.getName());
					String eName = new String(eNameChars);
					to.setName(eName);
					char[] eDesriptionChars = cManager.doFinal(
					PBECryptographyManager.DECRYPT, role.getDescription());
					String eDescription = new String(eDesriptionChars);
					to.setDescription(eDescription);
					«ELSE»
					to.setName(role.getName());
					to.setDescription(role.getDescription());
					«ENDIF»
					«authEntity.name.toLowerCase»Roles.add(to);
				}
				return «authEntity.name.toLowerCase»Roles;
			}
			
			public List<RoleTO> getAllRoles() {
				List<RoleTO> roles = new ArrayList<>();
				TypedQuery<Role> query = em.createNamedQuery("auth.getAllRoles",
						Role.class);
				List<Role> foundRoles = query.getResultList();
				for (Role role : foundRoles) {
					«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
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
					«ELSE»
					roles.add(role.toTO());
					«ENDIF»
				}
				return roles;
			}
			
			public List<ServiceTO> getAllServices() {
				List<ServiceTO> services = new ArrayList<>();
				TypedQuery<Service> query = em.createNamedQuery("auth.getAllServices",
						Service.class);
				List<Service> foundServices = query.getResultList();
				for (Service service : foundServices) {
					«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
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
					«ELSE»
					services.add(service.toTO());
					«ENDIF»
				}
				return services;
			}
			
			public List<ServiceTO> getRoleServices(String roleName) {
				List<ServiceTO> roleServices = new ArrayList<>();
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eUNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, roleName);
				String eUName = new String(eUNameChars);
				roleName = eUName;
				«ENDIF»
				Role foundRole = em.find(Role.class, roleName);
				if (foundRole != null) {
					List<Service> foundServices = foundRole.getServices();
					for (Service service : foundServices) {
						«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
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
						«ELSE»
						roleServices.add(service.toTO());
						«ENDIF»
					}
				}
				return roleServices;
			}
			
			public boolean createRole (RoleTO role) throws Exception {
				Role newRole = new Role();
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, role.getName());
				String eName = new String(eNameChars);
				role.setName(eName);
				char[] eDesriptionChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, role.getDescription());
				String eDescription = new String(eDesriptionChars);
				role.setDescription(eDescription);
				«ENDIF»
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
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, newRole.getName());
				String eName = new String(eNameChars);
				newRole.setName(eName);
				char[] eDesriptionChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, newRole.getDescription());
				String eDescription = new String(eDesriptionChars);
				newRole.setDescription(eDescription);
				«ENDIF»
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
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, role.getName());
				String eName = new String(eNameChars);
				role.setName(eName);
				char[] eDesriptionChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, role.getDescription());
				String eDescription = new String(eDesriptionChars);
				role.setDescription(eDescription);
				«ENDIF»
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
			
			public boolean addRoleTo«authEntity.name.toFirstUpper» («DomainCodeUtilities.getType(authId)» user, RoleTO role) throws Exception {
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, role.getName());
				String eName = new String(eNameChars);
				role.setName(eName);
				«IF DomainCodeUtilities.getType(authId).equals("String")»
				char[] eUNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, user);
				String eUName = new String(eUNameChars);
				user = eUName;
				«ENDIF»
				«ENDIF»
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
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, role.getName());
				String eName = new String(eNameChars);
				role.setName(eName);
				«IF DomainCodeUtilities.getType(authId).equals("String")»
				char[] eUNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, user.get«DomainCodeUtilities.getID(authEntity).name.toFirstUpper»());
				String eUName = new String(eUNameChars);
				user.set«DomainCodeUtilities.getID(authEntity).name.toFirstUpper»(eUName);
				«ENDIF»
				«ENDIF»
				Role foundRole = em.find(Role.class, role.getName());

				«authEntity.name.toFirstUpper»RolePK pk = new «authEntity.name.toFirstUpper»RolePK();
				pk.setRole(role.getName());
				pk.set«authEntity.name.toFirstUpper»(«authEntity.name.toLowerCase».get«DomainCodeUtilities.getID(authEntity).name.toFirstUpper»());
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
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, roleName);
				String eName = new String(eNameChars);
				roleName = eName;
				char[] eUNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, service.getName());
				String eUName = new String(eUNameChars);
				service.setName(eUName);
				«ENDIF»
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
				«IF (DomainCodeUtilities.isQASelected("_r_2_10_12_13"))»
				char[] eNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, role.getName());
				String eName = new String(eNameChars);
				role.setName(eName);
				char[] eUNameChars = cManager.doFinal(
				PBECryptographyManager.ENCRYPT, service.getName());
				String eUName = new String(eUNameChars);
				service.setName(eUName);
				«ENDIF»
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
			
			public List<ServiceTO> get«authEntity.name.toFirstUpper»Services («DomainCodeUtilities.getType(authId)» «authId.name.toLowerCase») {
				List<RoleTO> «authEntity.name.toLowerCase»Roles = get«authEntity.name.toFirstUpper»Roles(«authId.name.toLowerCase»);
				Set<ServiceTO> «authEntity.name.toLowerCase»ServicesHash = new HashSet<>();
				for (RoleTO roleTO : «authEntity.name.toLowerCase»Roles) {
					«authEntity.name.toLowerCase»ServicesHash.addAll(getRoleServices(roleTO.getName()));
				}
				return new ArrayList<>(«authEntity.name.toLowerCase»ServicesHash);
			}
		}
		«DomainCodeUtilities.endTemplate»
	'''
}