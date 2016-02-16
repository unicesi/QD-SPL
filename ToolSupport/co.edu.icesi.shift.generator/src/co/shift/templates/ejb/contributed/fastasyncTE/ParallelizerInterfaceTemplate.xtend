package co.shift.templates.ejb.contributed.fastasyncTE

import domainmetamodel.BusinessEntity
import domainmetamodel.ListAll

class ParallelizerInterfaceTemplate {
	
	def static generate (BusinessEntity be, String packageName) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;

		import java.util.List;
		import javax.ejb.Remote;

		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		
		@Remote
		public interface I«be.name.toFirstUpper»Parallelizer {
		
		«FOR contract : be.contracts»
			«IF (contract instanceof ListAll)»
				public List<«be.name.toFirstUpper»TO> «contract.name»(long pCount) throws Exception;
			«ENDIF»
		«ENDFOR»
		}
	'''
}