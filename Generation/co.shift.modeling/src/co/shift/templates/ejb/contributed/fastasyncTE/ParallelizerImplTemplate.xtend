package co.shift.templates.ejb.contributed.fastasyncTE

import domainmetamodel.BusinessEntity
import domainmetamodel.ListAll

class ParallelizerImplTemplate {
	
	def static generate (BusinessEntity be, String packageName) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;
		
		import java.util.LinkedList;
		import java.util.List;
		import java.util.concurrent.ExecutionException;
		import java.util.concurrent.Future;
		
		import javax.ejb.EJB;
		import javax.ejb.Stateless;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		
		@Stateless
		public class «be.name.toFirstUpper»Parallelizer implements I«be.name.toFirstUpper»Parallelizer {
		
		@EJB
		«be.name.toFirstUpper»AsyncWorker worker;
		
		«FOR contract : be.contracts»
			«IF (contract instanceof ListAll)»
				public List<«be.name.toFirstUpper»TO> «contract.name»(long pCount) throws Exception {					
					List<Future<List<«be.name.toFirstUpper»TO>>> futures = new LinkedList<>();
					List<«be.name.toFirstUpper»TO> «be.name.toLowerCase»s = new LinkedList<>();
					int start = 0;
					int maxResults = 1;
					int iterations = (int) (pCount / maxResults);
					for (int i = 0; i < iterations; i++) {
						futures.add(worker.«contract.name»(start, maxResults));
						start += maxResults;
					}
					for (Future<List<«be.name.toFirstUpper»TO>> future : futures) {
						try {
							«be.name.toLowerCase»s.addAll(future.get());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return «be.name.toLowerCase»s;
				}
			«ENDIF»
		«ENDFOR»
		}
	'''
}