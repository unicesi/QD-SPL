package co.shift.templates.web.basic

import domainmetamodel.BusinessEntity
import java.util.List
import co.shift.generators.domain.DomainCodeGenerator

class UIControllerTemplate {
	
	def static generate(String packageName, BusinessEntity authEntity, List<BusinessEntity> bes) '''
		package co.shift.«packageName.toLowerCase()».web;
		
		import java.util.List;

		import com.vaadin.ui.Component;
		
		import co.shift.«packageName.toLowerCase()».web.ext.authenticator.LoginController;
		import co.shift.«packageName.toLowerCase()».web.client.MenuPanel;
		import co.shift.«packageName.toLowerCase()».to.«authEntity.name.toFirstUpper»TO;
		«FOR be : bes»
		import co.shift.«packageName.toLowerCase()».web.ext.«be.name.toLowerCase».«be.name.toFirstUpper»Controller;
		«ENDFOR»
		«var authorizerSelected = DomainCodeGenerator.isQASelected("_r_2_11_15_16")»
		«IF authorizerSelected»
		import co.shift.«packageName.toLowerCase()».web.ext.authorizer.AuthorizerController;
		import co.shift.«packageName.toLowerCase()».to.ServiceTO;
		«ENDIF»
		
		public class UIController implements UIContributor {

			private static UIController controller;
		
			private UIController() {
				init();
			}
			
			private void init() {
				/********** Controller Instantiation ***********/
				LoginController.getInstance().showLoginForm();
		
				«FOR be : bes»
				«be.name.toFirstUpper»Controller.getInstance();
				«ENDFOR»
				«IF authorizerSelected»
				AuthorizerController authController = AuthorizerController
						.getInstance();
				«ENDIF»
		
				/********** Contributors Configuration ***********/
				// Adds menu UI contributor to Login
				LoginController.getInstance().addContributor(this);
		
				«IF authorizerSelected»		
				// Adds authorization check for every action
				«FOR be : bes»
				«be.name.toFirstUpper»Controller.getInstance().addContributor(
						AuthorizerController.ID, authController);
				«ENDFOR»
				«ENDIF»
			}
			
			public static UIController getInstance() {
				if (controller == null)
					controller = new UIController();
				return controller;
			}
			
			@Override
			public void contributeUITo(Component component, Object data)
					throws Exception {
				«authEntity.name.toFirstUpper»TO user = Registry.get(«packageName.toUpperCase»UI.USER);
				
				«IF authorizerSelected»
				List<ServiceTO> userServices = AuthorizerController.getInstance()
						.get«authEntity.name.toFirstUpper»Services(user.get«DomainCodeGenerator.getID(authEntity).name.toFirstUpper»());
				Registry.register(«packageName.toUpperCase»UI.USER_SERVICES, userServices);
				«ENDIF»
				MenuPanel menu = (MenuPanel) component;
				«var isFirst = 0»
				«var t = bes.add(authEntity)»
				«FOR be : bes»
				«IF DomainCodeGenerator.isMaster(be)»
				«IF isFirst == 0»
				«be.name.toFirstUpper»Controller.getInstance().show«be.name.toFirstUpper»Form();
				«var c = isFirst++»
				«ENDIF»
				menu.addMenu("«be.name.toFirstUpper»", «be.name.toFirstUpper»Controller.getInstance()
						.get«be.name.toFirstUpper»Command(), true);
				«ENDIF»
				«ENDFOR»
				«IF authorizerSelected»
				if (AuthorizerController.getInstance().hasAdminRole(user.get«DomainCodeGenerator.getID(authEntity).name.toFirstUpper»())) {
					menu.addMenu("Authorizer", AuthorizerController.getInstance()
							.getAuthCommand(), true);	
				}
				«ENDIF»
			}
		}
	'''
}