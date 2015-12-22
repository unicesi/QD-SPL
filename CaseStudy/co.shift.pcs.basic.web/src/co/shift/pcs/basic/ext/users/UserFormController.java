package co.shift.pcs.basic.ext.users;

import java.util.List;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;

import co.shift.pcs.basic.ext.projects.ProjectFormController;
import co.shift.pcs.basic.web.PCSUI;
import co.shift.pcs.basic.web.Registry;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.users.boundary.IUserManager;
import co.shift.pcs.util.beanlocator.BeanLocator;

public class UserFormController {

	private static UserFormController controller;

	private IUserManager userManager;

	private UserFormController() {
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

	public static UserFormController getInstance() {
		if (controller == null) {
			controller = new UserFormController();
			PopUpUserForm uF = new PopUpUserForm();
			Registry.register(PopUpUserForm.ID, uF);
			UserManagerForm uMF = new UserManagerForm();
			Registry.register(UserManagerForm.ID, uMF);
		}
		return controller;
	}

	public List<UserTO> getUsersFromProject(int projectID) {
		return userManager.getUsersFromProject(projectID);
	}

//	public boolean addUser(UserTO user) throws Exception {
//		try {
//			return userManager.addUser(user);
//		} catch (Exception e) {
//			throw e;
//		}
//	}

	public List<UserTO> getAllUsers() {
		return userManager.getAllUsers();
	}

	public UserTO getProjectManager(int projectID) {
		return userManager.getProjectManager(projectID);
	}

	// ManagerForm Events
	public void updateManagerFormFields() {
		UserManagerForm uMF = Registry.get(UserManagerForm.ID);
		ComboBox combo = uMF.getComboBox_1();
		UserTO user = (UserTO) combo.getValue();
		if (user != null) {
			uMF.getTextField_1().setValue(user.getName());
		}
	}

	public void setProjectManager(int projectID) {
		ProjectFormController.getInstance().setProjectManager(projectID);
	}

	public void populateUserManagerCombo(List<UserTO> users, UserTO manager) {
		UserManagerForm uMF = Registry.get(UserManagerForm.ID);
		ComboBox combo = uMF.getComboBox_1();
		combo.removeAllItems();
		UserTO uManager = null;
		for (UserTO userTO : users) {
			if (userTO.equals(manager))
				uManager = userTO;
			combo.addItem(userTO);
		}

		if (uMF.getProjectID() > 0) {
			if (uManager != null)
				combo.setValue(uManager);
		}
	}

	// UserForm Events
	public void addUserToProject(int projectID) {
		PopUpUserForm uF = Registry.get(PopUpUserForm.ID);
		String cc = uF.getTextField_1().getValue();
		String name = uF.getTextField_2().getValue();
		String cellphone = uF.getTextField_3().getValue();

		if (cc != null && !cc.equals("") && name != null && !name.equals("")) {
			UserTO user = new UserTO();
			user.setIdNumber(cc);
			user.setCellphone(cellphone);
			user.setName(name);
			if (ProjectFormController.getInstance().addUserToProject(user,
					projectID))
				uF.clearFormFields();
		} else
			((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
					"Please fill in all required fields (*)");
	}

	public void updateUserFormFields() {
		PopUpUserForm uF = Registry.get(PopUpUserForm.ID);
		ComboBox combo = uF.getComboBox_1();
		UserTO user = (UserTO) combo.getValue();
		TextField tx1 = uF.getTextField_1();
		TextField tx2 = uF.getTextField_2();
		TextField tx3 = uF.getTextField_3();
		if (user != null) {
			tx1.setValue(user.getIdNumber());
			tx2.setValue(user.getName());
			tx3.setValue(user.getCellphone());
		}
	}

	public void populateUsersCombo(List<UserTO> users) {
		PopUpUserForm uF = Registry.get(PopUpUserForm.ID);
		ComboBox combo = uF.getComboBox_1();
		combo.removeAllItems();

		for (UserTO userTO : users) {
			combo.addItem(userTO);
		}
	}
}
