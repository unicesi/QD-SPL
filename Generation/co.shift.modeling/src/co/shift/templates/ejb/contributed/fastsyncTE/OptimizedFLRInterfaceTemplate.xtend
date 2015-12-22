package co.shift.templates.ejb.contributed.fastsyncTE

import domainmetamodel.BusinessEntity
import domainmetamodel.ListAll

class OptimizedFLRInterfaceTemplate {
	
	def static generate (BusinessEntity be, String packageName) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;

		import java.util.List;
		import javax.ejb.Remote;

		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		
		@Remote
		public interface I«be.name.toFirstUpper»OptimizedFLR {
		
		«FOR contract : be.contracts»
			«IF (contract instanceof ListAll)»
				public List<«be.name.toFirstUpper»TO> «contract.name»(int start, int maxResults) throws Exception;
			«ENDIF»
		«ENDFOR»
		}
	'''
}