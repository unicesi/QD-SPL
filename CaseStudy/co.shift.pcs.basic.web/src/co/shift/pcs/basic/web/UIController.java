package co.shift.pcs.basic.web;

import java.util.List;

import com.vaadin.ui.Component;

import co.shift.pcs.basic.ext.authenticator.LoginFormController;
import co.shift.pcs.basic.ext.authorizer.AuthorizerController;
import co.shift.pcs.basic.ext.projects.ProjectFormController;
import co.shift.pcs.basic.ext.risks.RiskFormController;
import co.shift.pcs.basic.ext.users.UserFormController;
import co.shift.pcs.basic.web.client.MenuPanel;
import co.shift.pcs.to.ServiceTO;
import co.shift.pcs.to.UserTO;

public class UIController implements UIContributor {

	private static UIController controller;

	private UIController() {
		init();
	}

	private void init() {
		/********** Controller Instantiation ***********/
		LoginFormController.getInstance().showLoginForm();

		UserFormController.getInstance();
		ProjectFormController.getInstance();
		RiskFormController.getInstance();
		AuthorizerController authController = AuthorizerController
				.getInstance();

		/********** Contributors Configuration ***********/
		// Adds menu UI contributor to Login
		LoginFormController.getInstance().addContributor(this);

		// Adds authorization check for every action
		ProjectFormController.getInstance().addContributor(
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
				.getUserServices(user.getIdNumber());
		Registry.register(PCSUI.USER_SERVICES, userServices);
		MenuPanel menu = (MenuPanel) component;
		menu.addMenu("Projects", ProjectFormController.getInstance()
				.getProjectCommand(), true);

		if (AuthorizerController.getInstance().hasAdminRole(user.getIdNumber())) {
			menu.addMenu("Authorizer", AuthorizerController.getInstance()
					.getAuthCommand(), true);	
		}
		ProjectFormController.getInstance().showProjectForm();
	}
}
