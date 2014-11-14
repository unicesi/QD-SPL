package co.shift.templates.ejb.contributed.authenticity

import domainmetamodel.BusinessEntity

class AuthJPATemplate {

	def static generateRoleEntity (String packageName, BusinessEntity authEntity) '''
		package co.shift.«packageName.toLowerCase()».authorization.entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		import co.shift.pcs.to.RoleTO;
		import co.shift.pcs.to.ServiceTO;
		
		import java.util.ArrayList;
		import java.util.List;
		
		@Entity
		@Table(name = "Roles")
		@NamedQueries({ @NamedQuery(name = "auth.get«authEntity.name.toFirstUpper»Roles", query = "SELECT r FROM Role r, «authEntity.name.toFirstUpper»Role ur WHERE r.name = ur.id.role AND ur.id.«authEntity.name.toLowerCase» = :«authEntity.name.toLowerCase»id"),
			@NamedQuery(name = "auth.deleteRole", query = "DELETE FROM Role r WHERE r.name=:rid"),
			@NamedQuery(name = "auth.getAllRoles", query = "SELECT r FROM Role r")})
		public class Role implements Serializable {
			private static final long serialVersionUID = 1L;
		
			@Id
			private String name;
		
			private String description;
		
			// bi-directional many-to-many association to Service
		//	@ManyToMany(mappedBy = "roles")
			@ManyToMany
			@JoinTable(name = "Rights", joinColumns = { @JoinColumn(name = "role") }, inverseJoinColumns = { @JoinColumn(name = "service") })
			private List<Service> services;
		
			// bi-directional many-to-one association to UserRole
			@OneToMany(mappedBy = "roleBean", orphanRemoval = true)
			private List<«authEntity.name.toFirstUpper»Role> «authEntity.name.toLowerCase»Roles;
		
			public Role() {
			}
		
			public String getName() {
				return this.name;
			}
		
			public void setName(String name) {
				this.name = name;
			}
		
			public String getDescription() {
				return this.description;
			}
		
			public void setDescription(String description) {
				this.description = description;
			}
		
			public List<Service> getServices() {
				return this.services;
			}
		
			public void setServices(List<Service> services) {
				this.services = services;
			}
		
			public List<«authEntity.name.toFirstUpper»Role> get«authEntity.name.toFirstUpper»Roles() {
				return this.«authEntity.name.toLowerCase»Roles;
			}
		
			public void set«authEntity.name.toFirstUpper»Roles(List<«authEntity.name.toFirstUpper»Role> «authEntity.name.toLowerCase»Roles) {
				this.«authEntity.name.toLowerCase»Roles = «authEntity.name.toLowerCase»Roles;
			}
		
			public RoleTO toTO() {
				RoleTO to = new RoleTO();
				to.setDescription(description);
				to.setName(name);
		
				List<ServiceTO> servicesTO = new ArrayList<>();
				for (Service service : services) {
					servicesTO.add(service.toTO());
				}
				to.setServices(servicesTO);
				return to;
			}
		}
	'''
	
	def static generateServiceEntity (String packageName) '''
		package co.shift.«packageName.toLowerCase()».authorization.entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		import co.shift.pcs.to.ServiceTO;
		
		import java.util.List;
		
		@Entity
		@Table(name = "Services")
		@NamedQueries({ @NamedQuery(name = "auth.getAllServices", query = "SELECT s FROM Service s") })
		public class Service implements Serializable {
			private static final long serialVersionUID = 1L;
		
			@Id
			private String name;
		
			private String description;
		
			// bi-directional many-to-many association to Role
		//	@ManyToMany
		//	@JoinTable(name = "Rights", joinColumns = { @JoinColumn(name = "service") }, inverseJoinColumns = { @JoinColumn(name = "role") })
			@ManyToMany(mappedBy = "services")
			private List<Role> roles;
		
			public Service() {
			}
		
			public String getName() {
				return this.name;
			}
		
			public void setName(String name) {
				this.name = name;
			}
		
			public String getDescription() {
				return this.description;
			}
		
			public void setDescription(String description) {
				this.description = description;
			}
		
			public List<Role> getRoles() {
				return this.roles;
			}
		
			public void setRoles(List<Role> roles) {
				this.roles = roles;
			}
		
			@Override
			public boolean equals(Object obj) {
				Service service = (Service) obj;
				if (service != null)
					return service.name.equals(name);
				return false;
			}
		
			public ServiceTO toTO() {
				ServiceTO to = new ServiceTO();
				to.setDescription(description);
				to.setName(name);
				return to;
			}
		}
	'''
	
	def static generateAuthRoleEntity (String packageName, BusinessEntity authEntity) '''
		package co.shift.«packageName.toLowerCase()».authorization.entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		@Entity
		public class «authEntity.name.toFirstUpper»Role implements Serializable {
			private static final long serialVersionUID = 1L;
		
			@EmbeddedId
			private «authEntity.name.toFirstUpper»RolePK id;
		
			//bi-directional many-to-one association to Role
			@ManyToOne
			@JoinColumn(name="role", insertable=false, updatable=false)
			private Role roleBean;
		
			public «authEntity.name.toFirstUpper»Role() {
			}
		
			public «authEntity.name.toFirstUpper»RolePK getId() {
				return this.id;
			}
		
			public void setId(«authEntity.name.toFirstUpper»RolePK id) {
				this.id = id;
			}
		
			public Role getRoleBean() {
				return this.roleBean;
			}
		
			public void setRoleBean(Role roleBean) {
				this.roleBean = roleBean;
			}
		
		}
	'''
	
	def static generateAuthRolePKEntity (String packageName, BusinessEntity authEntity) '''
		package co.shift.«packageName.toLowerCase()».authorization.entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		@Embeddable
		public class «authEntity.name.toFirstUpper»RolePK implements Serializable {
			//default serial version id, required for serializable classes.
			private static final long serialVersionUID = 1L;
		
			private String «authEntity.name.toLowerCase»;
		
			private String role;
		
			public «authEntity.name.toFirstUpper»RolePK() {
			}
			public String get«authEntity.name.toFirstUpper»() {
				return this.«authEntity.name.toLowerCase»;
			}
			public void set«authEntity.name.toFirstUpper»(String «authEntity.name.toLowerCase») {
				this.«authEntity.name.toLowerCase» = «authEntity.name.toLowerCase»;
			}
			public String getRole() {
				return this.role;
			}
			public void setRole(String role) {
				this.role = role;
			}
		
			public boolean equals(Object other) {
				if (this == other) {
					return true;
				}
				if (!(other instanceof «authEntity.name.toFirstUpper»RolePK)) {
					return false;
				}
				«authEntity.name.toFirstUpper»RolePK castOther = («authEntity.name.toFirstUpper»RolePK)other;
				return 
					this.«authEntity.name.toLowerCase».equals(castOther.«authEntity.name.toLowerCase»)
					&& this.role.equals(castOther.role);
			}
		
			public int hashCode() {
				final int prime = 31;
				int hash = 17;
				hash = hash * prime + this.«authEntity.name.toLowerCase».hashCode();
				hash = hash * prime + this.role.hashCode();
				
				return hash;
			}
		}
	'''
}
