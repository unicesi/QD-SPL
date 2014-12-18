package co.shift.templates.ejb.contributed.authenticity

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities

class AuthInterfaceTemplate {
	
	def static generate (String packageName, BusinessEntity authEntity) '''
		package co.shift.«packageName.toLowerCase()».authorization.boundary;
		
		import java.util.List;

		import javax.ejb.Remote;
		
		import co.shift.«packageName.toLowerCase()».to.RoleTO;
		import co.shift.«packageName.toLowerCase()».to.ServiceTO;
		import co.shift.«packageName.toLowerCase()».to.«authEntity.name.toFirstUpper»TO;
		
		@Remote
		public interface IAuthorizationManager {
		
		«var authId = DomainCodeUtilities.getID(authEntity)»
			public List<RoleTO> get«authEntity.name.toFirstUpper»Roles(«DomainCodeUtilities.getType(authId)» «authId.name.toLowerCase»);
			
			public List<RoleTO> getAllRoles();
			
			public List<ServiceTO> getAllServices();
			
			public List<ServiceTO> getRoleServices(String roleName);
			
			public boolean createRole (RoleTO role) throws Exception;
			
			public boolean updateRole (RoleTO newRole) throws Exception;
		
			public boolean deleteRole (RoleTO role) throws Exception;
			
			public boolean addRoleTo«authEntity.name.toFirstUpper» («DomainCodeUtilities.getType(authId)» user, RoleTO role) throws Exception;
			
			public boolean removeRoleFrom«authEntity.name.toFirstUpper» («authEntity.name.toFirstUpper»TO user, RoleTO role) throws Exception;
			
			public boolean addServiceToRole (String roleName, ServiceTO service) throws Exception;
			
			public boolean removeServiceFromRole (RoleTO role, ServiceTO service) throws Exception;
			
			public List<ServiceTO> get«authEntity.name.toFirstUpper»Services («DomainCodeUtilities.getType(authId)» «authId.name.toLowerCase»);
		}
	'''
}