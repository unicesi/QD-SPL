package co.shift.pcs.web;

import java.util.List;

import com.vaadin.ui.Component;

import co.shift.pcs.web.ext.authenticator.LoginController;
import co.shift.pcs.web.client.MenuPanel;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.web.ext.project.ProjectController;
import co.shift.pcs.web.ext.risk.RiskController;
import co.shift.pcs.web.ext.authorizer.AuthorizerController;
import co.shift.pcs.to.ServiceTO;

public class UIController implements UIContributor {

	private static UIController controller;

	private UIController() {
		init();
	}
	
	private void init() {
		/********** Controller Instantiation ***********/
		LoginController.getInstance().showLoginForm();

		ProjectController.getInstance();
		RiskController.getInstance();
		AuthorizerController authController = AuthorizerController
				.getInstance();

		/********** Contributors Configuration ***********/
		// Adds menu UI contributor to Login
		LoginController.getInstance().addContributor(this);

		// Adds authorization check for every action
		ProjectController.getInstance().addContributor(
				AuthorizerController.ID, authController);
		RiskController.getInstance().addContributor(
				AuthorizerController.ID, authController);
	}
	
	public static UIController getInstance() {
		if (controller == null)
			controller = new UIController();
		return controller;
	}
	
	@Override
	public void contributeUITo(Component component, Object data)
			throws Exception {
		UserTO user = Registry.get(PCSUI.USER);
		
		List<ServiceTO> userServices = AuthorizerController.getInstance()
				.getUserServices(user.getCc());
		Registry.register(PCSUI.USER_SERVICES, userServices);
		MenuPanel menu = (MenuPanel) component;
		ProjectController.getInstance().showProjectForm();
		menu.addMenu("Project", ProjectController.getInstance()
				.getProjectCommand(), true);
		menu.addMenu("User", UserController.getInstance()
				.getUserCommand(), true);
		if (AuthorizerController.getInstance().hasAdminRole(user.Cc())) {
			menu.addMenu("Authorizer", AuthorizerController.getInstance()
					.getAuthCommand(), true);	
		}
	}
}
