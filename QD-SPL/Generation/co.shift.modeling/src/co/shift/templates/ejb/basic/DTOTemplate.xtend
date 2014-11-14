package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import domainmetamodel.Simple
import domainmetamodel.Association
import java.util.List
import co.shift.generators.domain.DomainCodeGenerator

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
			
				private «DomainCodeGenerator.getType(attribute)» «attribute.name.toLowerCase»;
				
				public «DomainCodeGenerator.getType(attribute)» get«attribute.name.toFirstUpper»() {
					return this.«attribute.name.toLowerCase»;
				}
				
				public void set«attribute.name.toFirstUpper»(«DomainCodeGenerator.getType(attribute)» «attribute.name.toLowerCase») {
					this.«attribute.name.toLowerCase» = «attribute.name.toLowerCase»;
				}				
		«ENDFOR»
			
			«FOR association : be.associations»
			«IF (association instanceof Simple)»
				«val relatedEntity = association.relatedEntity»
				private «DomainCodeGenerator.getType(DomainCodeGenerator.getID(relatedEntity))» «association.name.toLowerCase»;
				
				public «DomainCodeGenerator.getType(DomainCodeGenerator.getID(relatedEntity))» get«association.name.toFirstUpper»() {
					return this.«association.name.toLowerCase»;
				}
				
				public void set«association.name.toFirstUpper»(«DomainCodeGenerator.getType(DomainCodeGenerator.getID(relatedEntity))» «association.name.toLowerCase») {
					this.«association.name.toLowerCase» = «association.name.toLowerCase»;
				}
			«ENDIF»
			«ENDFOR»
			
			«IF (DomainCodeGenerator.isDetail(be))» 
			«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				private «DomainCodeGenerator.getType(DomainCodeGenerator.getID(container))» «container.name.toLowerCase»;
				
				public «DomainCodeGenerator.getType(DomainCodeGenerator.getID(container))» get«container.name.toFirstUpper»() {
					return this.«container.name.toLowerCase»;
				}
				
				public void set«container.name.toFirstUpper»(«DomainCodeGenerator.getType(DomainCodeGenerator.getID(container))» «container.name.toLowerCase») {
					this.«container.name.toLowerCase» = «container.name.toLowerCase»;
				}
			«ENDFOR»
			«ENDIF»
			
			@Override
			public boolean equals(Object obj) {
				«be.name.toFirstUpper»TO o = («be.name.toFirstUpper»TO) obj;
				if (o != null)
				«IF (DomainCodeGenerator.getType(DomainCodeGenerator.getID(be)).equals("String"))»
					return «DomainCodeGenerator.getID(be).name.toLowerCase».equals(o.«DomainCodeGenerator.getID(be).name.toLowerCase»);
				«ENDIF»
				«IF (DomainCodeGenerator.getType(DomainCodeGenerator.getID(be)).equals("int"))»
					return «DomainCodeGenerator.getID(be).name.toLowerCase» == o.«DomainCodeGenerator.getID(be).name.toLowerCase»;
				«ENDIF»
				return false;
			}
			
			@Override
			public String toString() {
				«IF (!DomainCodeGenerator.getType(DomainCodeGenerator.getID(be)).equals("String"))»
					return "" + «DomainCodeGenerator.getID(be).name.toLowerCase»;
				«ELSE»
					return «DomainCodeGenerator.getID(be).name.toLowerCase»;
				«ENDIF»
			}
		}
	'''
}
