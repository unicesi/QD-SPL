package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import domainmetamodel.Create
import domainmetamodel.Update
import domainmetamodel.Delete
import domainmetamodel.ListAll
import domainmetamodel.AddElement
import domainmetamodel.Contracts
import domainmetamodel.DeleteElement
import domainmetamodel.ContractElements
import domainmetamodel.ListElements
import java.util.ArrayList
import domainmetamodel.Association
import java.util.List
import domainmetamodel.Simple
import co.shift.generators.domain.DomainCodeGenerator
import org.eclipse.xtext.generator.IFileSystemAccess

class BoundaryInterfaceTemplate {

	static ArrayList<String> importTOs = new ArrayList;

	def static generate(BusinessEntity be, String packageName, List<Association> associations, IFileSystemAccess fsa) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».boundary;
		
		import java.util.List;
		import javax.ejb.Remote;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name»TO;
		«FOR contract : be.contracts»
			«IF (contract instanceof AddElement || contract instanceof DeleteElement || contract instanceof ListElements)»
				«val relatedEntity = (contract as ContractElements).association.entity»
				«IF (!importTOs.contains(relatedEntity.name))»
					import co.shift.«packageName.toLowerCase()».to.«relatedEntity.name»TO;
					«val result = importTOs.add(relatedEntity.name)»
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		@Remote
		public interface I«be.name»Manager {
			«FOR contract : be.contracts»
				
				«IF (contract instanceof Create || contract instanceof Update || contract instanceof Delete)»
					public boolean «(contract as Contracts).name»(«be.name»TO «be.name.toLowerCase()») throws Exception;
				«ENDIF»
				«IF (contract instanceof ListAll)»
					«DomainCodeGenerator.extendContribution("_r_1", DomainCodeGenerator.CONTRIBUTE_TO_BI, contract, be)»
					«DomainCodeGenerator.extendContribution("_r_1", DomainCodeGenerator.CONTRIBUTE_TO_GENERATION, fsa, packageName, be)»
«««					 public List<«be.name»TO> «(contract as Contracts).name»();
				«ENDIF»
				«IF (contract instanceof AddElement || contract instanceof DeleteElement)»
					«val relatedEntity = (contract as ContractElements).association.entity»
					«val type = DomainCodeGenerator.getID(be).dataType.literal»
					public boolean «(contract as ContractElements).name»(«relatedEntity.name»TO «relatedEntity.name.toLowerCase», «DomainCodeGenerator.getType(
			type)» «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper») throws Exception;
				«ENDIF»
«««				«IF (contract instanceof ListElements)»
«««					«val relatedEntity = (contract as ListElements).association.entity»
«««					«val type = getID(relatedEntity).dataType.literal»
«««					public List<«be.name»TO> «contract.name»(«getType(type)» «relatedEntity.name.
«««			toLowerCase»«getID(relatedEntity).name.toFirstUpper»);
«««				«ENDIF»
			«ENDFOR»
			«FOR association : be.associations»
				
				«IF (association instanceof Simple)»
					«val relatedEntity = association.relatedEntity»
					«val type = DomainCodeGenerator.getID(be).dataType.literal»
					public boolean set«be.name.toFirstUpper»«association.name.toFirstUpper»(«relatedEntity.name»TO «association.name.
			toLowerCase», «DomainCodeGenerator.getType(type)» «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper») throws Exception;
				«ENDIF»
			«ENDFOR»
			«FOR association : DomainCodeGenerator.getDetailSimpleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public «be.name»TO get«container.name.toFirstUpper»«association.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
			toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
			«ENDFOR»
			
«««			Siempre hay que mostrar todos los elementos del detalle. NO es necesario crear un ListElements
			«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public List<«be.name»TO> get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
			toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
			«ENDFOR»
			
			«IF (be.isIsAuthenticable)»
				«val type = DomainCodeGenerator.getID(be).dataType.literal»
				public «be.name»TO authenticate(«DomainCodeGenerator.getType(type)» «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper», String password) throws Exception;
			«ENDIF»
		}
	'''
}
