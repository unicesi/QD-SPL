package co.shift.templates.ejb.contributed.authenticity

class AuthTOTemplate {
	
		def static generateRoleTO (String packageName) '''
		package co.shift.«packageName.toLowerCase()».to;
		
		import java.io.Serializable;
		import java.util.List;
		
		public class RoleTO implements Serializable {
			private static final long serialVersionUID = 1L;
		
			private String name;
		
			private String description;
		
			//bi-directional many-to-many association to Service
			private List<ServiceTO> services;
		
			public RoleTO() {
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
		
			public List<ServiceTO> getServices() {
				return this.services;
			}
		
			public void setServices(List<ServiceTO> services) {
				this.services = services;
			}
		
			@Override
			public String toString() {
				return name;
			}
			
			@Override
			public boolean equals(Object obj) {
				RoleTO role = (RoleTO) obj;
				if (role != null)
					return role.name.equals(name);
				return false;
			}
		}
		'''
		
		def static generateServiceTO (String packageName) '''
			package co.shift.«packageName.toLowerCase()».to;
			
			import java.io.Serializable;
			
			public class ServiceTO implements Serializable {
				private static final long serialVersionUID = 1L;
				
				private String name;
				
				private String description;
				
				public ServiceTO() {
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
				
				@Override
				public String toString() {
					return name;
				}
				
				@Override
				public boolean equals(Object obj) {
					ServiceTO service = (ServiceTO) obj;
					if (service != null)
						return service.name.equals(name);
					return false;
				}
			}
		'''
}