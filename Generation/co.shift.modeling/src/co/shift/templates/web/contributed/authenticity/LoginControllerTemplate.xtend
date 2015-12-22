package co.shift.templates.web.contributed.authenticity

import domainmetamodel.BusinessEntity

class LoginControllerTemplate {
	
	def static generate(String packageName, BusinessEntity authEntity) '''
		package co.shift.«packageName.toLowerCase()».web.ext.authenticator;
		
		import co.shift.«packageName.toLowerCase()».web.AbstractController;
		import co.shift.«packageName.toLowerCase()».web.«packageName.toUpperCase»UI;
		import co.shift.«packageName.toLowerCase()».web.Registry;
		import co.shift.«packageName.toLowerCase()».web.client.ContentPanel;
		import co.shift.«packageName.toLowerCase()».web.client.MenuPanel;
		import co.shift.«packageName.toLowerCase()».to.«authEntity.name.toFirstUpper»TO;
		import co.shift.«packageName.toLowerCase()».«authEntity.name.toLowerCase».boundary.I«authEntity.name.toFirstUpper»Manager;
		import co.shift.«packageName.toLowerCase()».util.beanlocator.BeanLocator;
		
		public class LoginController extends AbstractController{

			private static LoginController controller;
		
			private I«authEntity.name.toFirstUpper»Manager «authEntity.name.toLowerCase»Manager;
		
			private LoginController() {
				doLookup();
			}
			
			private void doLookup() {
				«authEntity.name.toLowerCase»Manager = BeanLocator.lookup(
						I«authEntity.name.toFirstUpper»Manager.class,
						new BeanLocator().getGlobalJNDIName()
								.withAppName("co.shift.ear")
								.withModuleName("co.shift.ejb")
								.withBeanName("«authEntity.name.toFirstUpper»Manager")
								.withBusinessInterface(I«authEntity.name.toFirstUpper»Manager.class).asString());
			}
			
			public static LoginController getInstance() {
				if (controller == null) {
					controller = new LoginController();
					LoginForm uF = new LoginForm();
					Registry.register(LoginForm.ID, uF);
				}
				return controller;
			}
			
			public void showLoginForm() {
				LoginForm loginForm = Registry.get(LoginForm.ID);
				ContentPanel panel = Registry.get(«packageName.toUpperCase»UI.CONTENT_PANEL);
				panel.removeContent();
				panel.setContent(loginForm);
			}
			
			public void authenticate() {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					LoginForm lF = Registry.get(LoginForm.ID);
					String userID = lF.getTextField_1().getValue();
					String password = lF.getPasswordField_1().getValue();
					if (userID != null && !userID.equals("") && password != null
							&& !password.equals("")) {
						UserTO user = userManager.authenticate(userID, password);
		
						Registry.register(«packageName.toUpperCase»UI.USER, user);
						if (user != null) {
							MenuPanel menu = Registry.get(«packageName.toUpperCase»UI.MENU_PANEL);
							extendUI(menu, null);
						}
					} else
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
								"Please fill in all required fields (*)");
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
		}
	'''
}