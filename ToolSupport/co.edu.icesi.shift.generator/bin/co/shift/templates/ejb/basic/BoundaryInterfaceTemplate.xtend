package co.shift.templates.ejb.basic

import co.shift.generators.domain.DomainCodeUtilities
import co.shift.generators.domain.DomainParams
import domainmetamodel.AddElement
import domainmetamodel.Association
import domainmetamodel.BusinessEntity
import domainmetamodel.ContractElements
import domainmetamodel.Contracts
import domainmetamodel.Create
import domainmetamodel.Delete
import domainmetamodel.DeleteElement
import domainmetamodel.ListAll
import domainmetamodel.ListElements
import domainmetamodel.Simple
import domainmetamodel.Update
import java.util.ArrayList
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess

class BoundaryInterfaceTemplate {

	static ArrayList<String> importTOs = new ArrayList;
	private static String className = new Object(){}.class.enclosingClass.simpleName
	
	def static generate(BusinessEntity be, String packageName, List<Association> associations, IFileSystemAccess fsa) '''
		««« Establece la plantilla actual para contribución.
		«DomainCodeUtilities.beginTemplate(className)»
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
««« Jcifuentes: Comentado
«««					«DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_BI, contract, be)»
«««					Establece la sección actual para contribución
					«DomainCodeUtilities.beginSection(DomainParams.SECT_METHODS)»
					«DomainCodeUtilities.contribute2Template(1, contract, be)»
					«DomainCodeUtilities.endSection»
««« Jcifuentes: Comentado. Esto fue llevado a la plantilla DomainCodeGenerator
«««					«DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, packageName, be)»
				«ENDIF»
				«IF (contract instanceof AddElement || contract instanceof DeleteElement)»
					«val relatedEntity = (contract as ContractElements).association.entity»
					«IF !DomainCodeUtilities.hasZeroAssociations(relatedEntity)»
					«val type = DomainCodeUtilities.getID(be).dataType.literal»
					public boolean «(contract as ContractElements).name»(«relatedEntity.name»TO «relatedEntity.name.toLowerCase», «DomainCodeUtilities.getType(
			type)» «be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper») throws Exception;
					«ENDIF»
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
					«val type = DomainCodeUtilities.getID(be).dataType.literal»
					public boolean set«be.name.toFirstUpper»«association.name.toFirstUpper»(«relatedEntity.name»TO «association.name.
			toLowerCase», «DomainCodeUtilities.getType(type)» «be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper») throws Exception;
				«ENDIF»
			«ENDFOR»
			«FOR association : DomainCodeUtilities.getDetailSimpleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeUtilities.getID(container).dataType.literal»
				public «be.name»TO get«container.name.toFirstUpper»«association.name.toFirstUpper»(«DomainCodeUtilities.getType(type)» «container.name.
			toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»);
			«ENDFOR»
«««			Siempre hay que mostrar todos los elementos del detalle. NO es necesario crear un ListElements
			«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeUtilities.getID(container).dataType.literal»
				public List<«be.name»TO> get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«DomainCodeUtilities.getType(type)» «container.name.
			toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»);
			«ENDFOR»
			
			«IF (be.isIsAuthenticable)»
				«val type = DomainCodeUtilities.getID(be).dataType.literal»
				public «be.name»TO authenticate(«DomainCodeUtilities.getType(type)» «be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper», String password) throws Exception;
			«ENDIF»
		}
		«DomainCodeUtilities.endTemplate»
	'''
}
