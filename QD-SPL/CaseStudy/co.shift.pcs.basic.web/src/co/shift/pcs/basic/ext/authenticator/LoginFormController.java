package co.shift.pcs.basic.ext.authenticator;

import co.shift.pcs.basic.web.AbstractController;
import co.shift.pcs.basic.web.PCSUI;
import co.shift.pcs.basic.web.Registry;
import co.shift.pcs.basic.web.client.ContentPanel;
import co.shift.pcs.basic.web.client.MenuPanel;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.users.boundary.IUserManager;
import co.shift.pcs.util.beanlocator.BeanLocator;

public class LoginFormController extends AbstractController{

	private static LoginFormController controller;

	private IUserManager userManager;

	private LoginFormController() {
		doLookup();
	}

	private void doLookup() {
		userManager = BeanLocator.lookup(
				IUserManager.class,
				new BeanLocator().getGlobalJNDIName()
						.withAppName("co.shift.pcs.basic.ear")
						.withModuleName("co.shift.pcs.users.basic")
						.withBeanName("UserManager")
						.withBusinessInterface(IUserManager.class).asString());
	}

	public static LoginFormController getInstance() {
		if (controller == null) {
			controller = new LoginFormController();
			LoginForm uF = new LoginForm();
			Registry.register(LoginForm.ID, uF);
		}
		return controller;
	}

	public void showLoginForm() {
		LoginForm loginForm = Registry.get(LoginForm.ID);
		ContentPanel panel = Registry.get(PCSUI.CONTENT_PANEL);
		panel.removeContent();
		panel.setContent(loginForm);
	}

	public void authenticate() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			LoginForm lF = Registry.get(LoginForm.ID);
			String userID = lF.getTextField_1().getValue();
			String password = lF.getPasswordField_1().getValue();
			if (userID != null && !userID.equals("") && password != null
					&& !password.equals("")) {
				// Regular
				UserTO user = userManager.authenticate(userID, password);
				// Secure
				// UserTO user = userManager.authenticateSecure(userID,
				// password);

				Registry.register(PCSUI.USER, user);
				if (user != null) {
					MenuPanel menu = Registry.get(PCSUI.MENU_PANEL);
					extendUI(menu, null);
				}
			} else
				ui.showNotification(PCSUI.MSG_ERR,
						"Please fill in all required fields (*)");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
}
