package co.shift.templates.web.basic

class AbstractControllerTemplate {
	
	def static generate(String packageName) '''
		package co.shift.«packageName.toLowerCase()».web;
		
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.List;
		import com.vaadin.ui.Component;
		
		public abstract class AbstractController {

			/**
			 * List of UI contributors.
			 */
			private List<UIContributor> uiContributors;
			/**
			 * List of process contributors.
			 */
			private HashMap<String, ProcessContributor> processContributors;
			
			/**
			 * Default constructor. Initializes the contributors' lists.
			 */
			public AbstractController() {
				uiContributors = new ArrayList<>();
				processContributors = new HashMap<>();
			}
		
			// UI Contributors
			
			/**
			 * Adds the specified UI contributor.
			 * @param contributor to be added
			 */
			public void addContributor(UIContributor contributor) {
				uiContributors.add(contributor);
			}
			
			/**
			 * Removes the specified UI contributor.
			 * @param contributor to be removed
			 */
			public void removeContributor(UIContributor contributor) {
				uiContributors.remove(contributor);
			}
			
			/**
			 * Gets the registered UI contributors.
			 * @return list of UI contributors.
			 */
			public List<UIContributor> getUIContributors() {
				return uiContributors;
			}
		
			/**
			 * Calls the contributeUITo method of the UI contributors.
			 * 
			 * @param component to be extended with additional UI components
			 * @param data required for the contribution (optional)
			 * @throws Exception if there was a problem extending the component
			 */
			public void extendUI(Component component, Object data) throws Exception {
				for (UIContributor contributor : uiContributors) {
					contributor.contributeUITo(component, data);
				}
			}
			
			// Process Contributors
			
			/**
			 * Adds the specified process contributor.
			 * @param key the key of the process contributor to be added
			 * @param contributor to be added 
			 */
			public void addContributor(String key, ProcessContributor contributor) {
				processContributors.put(key, contributor);
			}
			
			/**
			 * Removes the specified content contributor.
			 * @param contributor to be removed
			 */
			public void removeContributor(ProcessContributor contributor) {
				processContributors.remove(contributor);
			}
			
			/**
			 * Gets the registered process contributors.
			 * @return HashMap<String, ProcessContributor> containing a list of all process contributors
			 */
			public HashMap<String, ProcessContributor> getProcessContributors() {
				return processContributors;
			}
			
			/**
			 * Calls the contributeProcess method of the process contributors.
			 * @param data required by the extension process
			 * @throws Exception if there was a problem extending the process
			 */
			public void extendProcess(String key, Object data) throws Exception {
				processContributors.get(key).contributeProcess(data);
			}
		
		}
	'''
}