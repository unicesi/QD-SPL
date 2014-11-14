package co.shift.templates.web.basic

class ProcessContributorTemplate {
	
	def static generate(String packageName) '''
		package co.shift.«packageName.toLowerCase()».web;
		
		public interface ProcessContributor {

			/**
			 * Contributes a process using the specified data (optional).
			 * @param data required by the extension process (optional)
			 * @throws Exception if there was a problem extending the process
			 */
			public void contributeProcess(Object data) throws Exception;
		}
	'''
}