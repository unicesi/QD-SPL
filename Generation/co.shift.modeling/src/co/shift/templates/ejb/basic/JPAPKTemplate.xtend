package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import java.util.List
import domainmetamodel.Association
import org.eclipse.xtext.generator.IFileSystemAccess
import co.shift.generators.domain.DomainCodeUtilities

class JPAPKTemplate {
	
	def static generate (BusinessEntity be, String packageName, BusinessEntity relation, List<Association> associations, IFileSystemAccess fsa) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		@Embeddable
		public class «be.name.toFirstUpper»«relation.name.toFirstUpper»PK implements Serializable {
		«DomainCodeUtilities.addEntityName("co.shift."+packageName.toLowerCase()+"."+be.name.toLowerCase+".entity."+relation.name.toFirstUpper+be.name.toFirstUpper)»
		«DomainCodeUtilities.addEntityName("co.shift."+packageName.toLowerCase()+"."+be.name.toLowerCase+".entity."+relation.name.toFirstUpper+be.name.toFirstUpper+"PK")»
			
			private static final long serialVersionUID = 1L;

			«var beId = DomainCodeUtilities.getID(be)»
			private «DomainCodeUtilities.getWrapperType(beId)» «be.name.toLowerCase»«beId.name.toFirstUpper»;
			
			«var relationId = DomainCodeUtilities.getID(relation)»
			private «DomainCodeUtilities.getWrapperType(relationId)» «relation.name.toLowerCase»«relationId.name.toFirstUpper»;
			
			public «be.name.toFirstUpper»«relation.name.toFirstUpper»PK() {
			}
			
			public «DomainCodeUtilities.getWrapperType(beId)» get«be.name.toFirstUpper»«beId.name.toFirstUpper»() {
				return this.«be.name.toLowerCase»«beId.name.toFirstUpper»;
			}
		
			public void set«be.name.toFirstUpper»«beId.name.toFirstUpper»(«DomainCodeUtilities.getWrapperType(beId)» «be.name.toLowerCase»«beId.name.toFirstUpper») {
				this.«be.name.toLowerCase»«beId.name.toFirstUpper» = «be.name.toLowerCase»«beId.name.toFirstUpper»;
			}
			
			public «DomainCodeUtilities.getWrapperType(relationId)» get«relation.name.toFirstUpper»«relationId.name.toFirstUpper»() {
				return this.«relation.name.toLowerCase»«relationId.name.toFirstUpper»;
			}
		
			public void set«relation.name.toFirstUpper»«relationId.name.toFirstUpper»(«DomainCodeUtilities.getWrapperType(relationId)» «relation.name.toLowerCase»«relationId.name.toFirstUpper») {
				this.«relation.name.toLowerCase»«relationId.name.toFirstUpper» = «relation.name.toLowerCase»«relationId.name.toFirstUpper»;
			}
			
			public boolean equals(Object other) {
				if (this == other) {
					return true;
				}
				if (!(other instanceof «be.name.toFirstUpper»«relation.name.toFirstUpper»PK)) {
					return false;
				}
				«be.name.toFirstUpper»«relation.name.toFirstUpper»PK castOther = («be.name.toFirstUpper»«relation.name.toFirstUpper»PK)other;
				return 
					«IF DomainCodeUtilities.getType(beId).equals("String")»
					this.«be.name.toLowerCase»«beId.name.toFirstUpper».equals(castOther.«be.name.toLowerCase»«beId.name.toFirstUpper»)
					«ELSE»
					this.«be.name.toLowerCase»«beId.name.toFirstUpper» == castOther.«be.name.toLowerCase»«beId.name.toFirstUpper»
					«ENDIF»
					&& 
					«IF DomainCodeUtilities.getType(relationId).equals("String")»
					this.«relation.name.toLowerCase»«relationId.name.toFirstUpper».equals(castOther.«relation.name.toLowerCase»«relationId.name.toFirstUpper»)
					«ELSE»
					this.«relation.name.toLowerCase»«relationId.name.toFirstUpper» == castOther.«relation.name.toLowerCase»«relationId.name.toFirstUpper»
					«ENDIF»
					;
			}
			
			public int hashCode() {
				final int prime = 31;
				int hash = 17;
				«IF DomainCodeUtilities.getType(beId).equals("String")»
				hash = hash * prime + this.«be.name.toLowerCase»«beId.name.toFirstUpper».hashCode();
				«ELSE»
				hash = hash * prime + this.«be.name.toLowerCase»«beId.name.toFirstUpper»;
				«ENDIF»
				«IF DomainCodeUtilities.getType(relationId).equals("String")»
				hash = hash * prime + this.«relation.name.toLowerCase»«relationId.name.toFirstUpper».hashCode();
				«ELSE»
				hash = hash * prime + this.«relation.name.toLowerCase»«relationId.name.toFirstUpper»;
				«ENDIF»
				
				return hash;
			}
		}
	'''
}