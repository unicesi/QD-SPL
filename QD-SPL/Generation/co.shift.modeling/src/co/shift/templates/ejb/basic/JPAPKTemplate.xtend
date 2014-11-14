package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import java.util.List
import domainmetamodel.Association
import org.eclipse.xtext.generator.IFileSystemAccess
import co.shift.generators.domain.DomainCodeGenerator

class JPAPKTemplate {
	
	def static generate (BusinessEntity be, String packageName, BusinessEntity relation, List<Association> associations, IFileSystemAccess fsa) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		@Embeddable
		public class «relation.name.toFirstUpper»«be.name.toFirstUpper»PK implements Serializable {
			
			private static final long serialVersionUID = 1L;

			«var beId = DomainCodeGenerator.getID(be)»
			private «DomainCodeGenerator.getType(beId)» «beId.name.toLowerCase»;
			
			«var relationId = DomainCodeGenerator.getID(relation)»
			private «DomainCodeGenerator.getType(relationId)» «relationId.name.toLowerCase»;
			
			public «relation.name.toFirstUpper»«be.name.toFirstUpper»PK() {
			}
			
			public «DomainCodeGenerator.getType(beId)» get«beId.name.toFirstUpper»() {
				return this.«beId.name.toLowerCase»;
			}
		
			public void set«beId.name.toFirstUpper»(«DomainCodeGenerator.getType(beId)» «beId.name.toLowerCase») {
				this.«beId.name.toLowerCase» = «beId.name.toLowerCase»;
			}
			
			public «DomainCodeGenerator.getType(relationId)» get«relationId.name.toFirstUpper»() {
				return this.«relationId.name.toLowerCase»;
			}
		
			public void set«relationId.name.toFirstUpper»(«DomainCodeGenerator.getType(relationId)» «relationId.name.toLowerCase») {
				this.«relationId.name.toLowerCase» = «relationId.name.toLowerCase»;
			}
			
			public boolean equals(Object other) {
				if (this == other) {
					return true;
				}
				if (!(other instanceof «relation.name.toFirstUpper»«be.name.toFirstUpper»PK)) {
					return false;
				}
				«relation.name.toFirstUpper»«be.name.toFirstUpper»PK castOther = («relation.name.toFirstUpper»«be.name.toFirstUpper»PK)other;
				return 
					«IF DomainCodeGenerator.getType(beId).equals("String")»
					this.«beId.name.toLowerCase».equals(castOther.«beId.name.toLowerCase»)
					«ELSE»
					this.«beId.name.toLowerCase» == castOther.«beId.name.toLowerCase»
					«ENDIF»
					&& 
					«IF DomainCodeGenerator.getType(relationId).equals("String")»
					this.«relationId.name.toLowerCase».equals(castOther.«relationId.name.toLowerCase»)
					«ELSE»
					this.«relationId.name.toLowerCase» == castOther.«relationId.name.toLowerCase»
					«ENDIF»
					;
			}
			
			public int hashCode() {
				final int prime = 31;
				int hash = 17;
				«IF DomainCodeGenerator.getType(beId).equals("String")»
				hash = hash * prime + this.«beId.name.toLowerCase».hashCode();
				«ELSE»
				hash = hash * prime + this.«beId.name.toLowerCase»;
				«ENDIF»
				«IF DomainCodeGenerator.getType(relationId).equals("String")»
				hash = hash * prime + this.«relationId.name.toLowerCase».hashCode();
				«ELSE»
				hash = hash * prime + this.«relationId.name.toLowerCase»;
				«ENDIF»
				
				return hash;
			}
		}
	'''
}