package co.shift.templates.web.basic

class UIContributorTemplate {
	
	def static generate(String packageName) '''
		package co.shift.«packageName.toLowerCase()».web;
		
		import com.vaadin.ui.Component;
		
		public interface UIContributor {
		
			/**
			 * Contributes new UI elements to the specified component using the specified data (optional).
			 * @param component to be extended
			 * @param data required for the contribution (optional)
			 * @throws Exception if there was a problem extending the component.
			 */
			public void contributeUITo(Component component, Object data) throws Exception;
		}
	'''
}