package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import java.util.List
import domainmetamodel.Association
import co.shift.generators.domain.DomainCodeGenerator

class DAOInterfaceTemplate {
	
	def static generate(BusinessEntity be, String packageName, List<Association> associations) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;
		
		import java.util.List;
		import javax.ejb.Remote;
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		
		@Remote
		public interface I«be.name.toFirstUpper»DAO {
			
			«FOR association : DomainCodeGenerator.getDetailSimpleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public «be.name»TO get«container.name.toFirstUpper»«association.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
			toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
			«ENDFOR»
			
			«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public List<«be.name»TO> get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
			toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
			«ENDFOR»
		}
	'''
}