package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import domainmetamodel.Simple
import domainmetamodel.Association
import java.util.List
import co.shift.generators.domain.DomainCodeUtilities

class DTOTemplate {

	def static generate (BusinessEntity be, String packageName, List<Association> associations) '''
		package co.shift.«packageName.toLowerCase()».to;
		
		import java.util.List;
		import java.io.Serializable;
		import java.util.Date;
		import java.math.BigDecimal;
		
		public class «be.name.toFirstUpper»TO implements Serializable {
			
			private static final long serialVersionUID = 1L;
		«FOR attribute : be.attributes»
			
				private «DomainCodeUtilities.getType(attribute)» «attribute.name.toLowerCase»;
				
				public «DomainCodeUtilities.getType(attribute)» get«attribute.name.toFirstUpper»() {
					return this.«attribute.name.toLowerCase»;
				}
				
				public void set«attribute.name.toFirstUpper»(«DomainCodeUtilities.getType(attribute)» «attribute.name.toLowerCase») {
					this.«attribute.name.toLowerCase» = «attribute.name.toLowerCase»;
				}				
		«ENDFOR»
			
			«FOR association : be.associations»
			«IF (association instanceof Simple)»
				«val relatedEntity = association.relatedEntity»
				private «DomainCodeUtilities.getType(DomainCodeUtilities.getID(relatedEntity))» «association.name.toLowerCase»;
				
				public «DomainCodeUtilities.getType(DomainCodeUtilities.getID(relatedEntity))» get«association.name.toFirstUpper»() {
					return this.«association.name.toLowerCase»;
				}
				
				public void set«association.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(relatedEntity))» «association.name.toLowerCase») {
					this.«association.name.toLowerCase» = «association.name.toLowerCase»;
				}
			«ENDIF»
			«ENDFOR»
			
			«IF (DomainCodeUtilities.getDetailMultipleAssociations(be, associations) != null)» 
			«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				private «DomainCodeUtilities.getType(DomainCodeUtilities.getID(container))» «container.name.toLowerCase»;
				
				public «DomainCodeUtilities.getType(DomainCodeUtilities.getID(container))» get«container.name.toFirstUpper»() {
					return this.«container.name.toLowerCase»;
				}
				
				public void set«container.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(container))» «container.name.toLowerCase») {
					this.«container.name.toLowerCase» = «container.name.toLowerCase»;
				}
			«ENDFOR»
			«ENDIF»
			
			@Override
			public boolean equals(Object obj) {
				«be.name.toFirstUpper»TO o = («be.name.toFirstUpper»TO) obj;
				if (o != null)
				«IF (DomainCodeUtilities.getType(DomainCodeUtilities.getID(be)).equals("String"))»
					return «DomainCodeUtilities.getID(be).name.toLowerCase».equals(o.«DomainCodeUtilities.getID(be).name.toLowerCase»);
				«ENDIF»
				«IF (DomainCodeUtilities.getType(DomainCodeUtilities.getID(be)).equals("int"))»
					return «DomainCodeUtilities.getID(be).name.toLowerCase» == o.«DomainCodeUtilities.getID(be).name.toLowerCase»;
				«ENDIF»
				return false;
			}
			
			@Override
			public String toString() {
				«IF (!DomainCodeUtilities.getType(DomainCodeUtilities.getID(be)).equals("String"))»
					return "" + «DomainCodeUtilities.getID(be).name.toLowerCase»;
				«ELSE»
					return «DomainCodeUtilities.getID(be).name.toLowerCase»;
				«ENDIF»
			}
		}
	'''
}
