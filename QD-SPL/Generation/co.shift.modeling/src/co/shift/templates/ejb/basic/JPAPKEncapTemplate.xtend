package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import java.util.List
import domainmetamodel.Association
import org.eclipse.xtext.generator.IFileSystemAccess

class JPAPKEncapTemplate {
	
	def static generate (BusinessEntity be, String packageName, String className, List<Association> associations, IFileSystemAccess fsa) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		@Entity
		public class «className» implements Serializable {
			
			private static final long serialVersionUID = 1L;

			@EmbeddedId
			private «className»PK id;
			
			@ManyToOne
			@JoinColumn(name="«be.name.toLowerCase»", insertable=false, updatable=false)
			private «be.name.toFirstUpper» «be.name.toLowerCase»Bean;
			
			public «className»() {
			}
			
			public «className»PK getId() {
				return this.id;
			}
		
			public void setId(«className»PK id) {
				this.id = id;
			}
			
			public «be.name.toFirstUpper» get«be.name.toFirstUpper»Bean() {
				return this.«be.name.toLowerCase»Bean;
			}
		
			public void set«be.name.toFirstUpper»Bean(«be.name.toFirstUpper» «be.name.toLowerCase»Bean) {
				this.«be.name.toLowerCase»Bean = «be.name.toLowerCase»Bean;
			}
		}
	'''
}