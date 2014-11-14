package co.shift.pcs.basic.ext.authorizer;

import java.util.List;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

import co.shift.pcs.basic.ext.users.UserFormController;
import co.shift.pcs.basic.web.PCSUI;
import co.shift.pcs.basic.web.ProcessContributor;
import co.shift.pcs.basic.web.Registry;
import co.shift.pcs.basic.web.UIContributor;
import co.shift.pcs.basic.web.client.ContentPanel;
import co.shift.pcs.basic.web.client.MenuPanel;
import co.shift.pcs.to.RoleTO;
import co.shift.pcs.to.ServiceTO;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.util.beanlocator.BeanLocator;
import co.shifts.pcs.authorization.boundary.IAuthorizationManager;

public class AuthorizerController implements ProcessContributor {

	private static AuthorizerController controller;

	private IAuthorizationManager authManager;

	private static final int TAB_USERS = 0;
	private static final int TAB_ROLES = 1;

	public static final String ID = "AuthorizerController";

	private AuthorizerController() {
		doLookup();
	}

	private void doLookup() {
		authManager = BeanLocator.lookup(
				IAuthorizationManager.class,
				new BeanLocator().getGlobalJNDIName()
						.withAppName("co.shift.pcs.basic.ear")
						.withModuleName("co.shift.pcs.authorization")
						.withBeanName("AuthorizationManager")
						.withBusinessInterface(IAuthorizationManager.class)
						.asString());
	}

	public void showAuthForm() {
		AuthorizerForm authForm = Registry.get(AuthorizerForm.ID);
		ContentPanel panel = Registry.get(PCSUI.CONTENT_PANEL);
		listAllUsers();
		panel.removeContent();
		panel.setContent(authForm);
	}

	public static AuthorizerController getInstance() {
		if (controller == null) {
			controller = new AuthorizerController();
			AuthorizerForm aF = new AuthorizerForm();
			Registry.register(AuthorizerForm.ID, aF);
			PopUpUserRoleForm pURF = new PopUpUserRoleForm();
			Registry.register(PopUpUserRoleForm.ID, pURF);
			PopUpRoleForm pRF = new PopUpRoleForm();
			Registry.register(PopUpRoleForm.ID, pRF);
			PopUpRoleServiceForm pRSF = new PopUpRoleServiceForm();
			Registry.register(PopUpRoleServiceForm.ID, pRSF);
		}
		return controller;
	}

	public List<ServiceTO> getUserServices(String userId) {
		return authManager.getUserServices(userId);
	}

	public void authorize(ServiceTO service) throws Exception {
		// Cada vez que hay un cambio de rol o servicio se debe actualizar la
		// lista
		List<ServiceTO> userServices = Registry.get(PCSUI.USER_SERVICES);
		if (!userServices.contains(service))
			throw new Exception("User is not authorized to perform this task");
	}

	public void dataTableSheetEvent() {
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		int selectedTab = aF.getTsData().getTabPosition(
				aF.getTsData().getTab(aF.getTsData().getSelectedTab()));
		switch (selectedTab) {
		case 0:
			aF.getTsDetails().getTab(0).setEnabled(true);
			aF.getTsDetails().getTab(1).setEnabled(false);
			aF.getButton_6().setEnabled(true);
			aF.getButton_7().setEnabled(true);
			break;
		case 1:
			aF.getTsDetails().getTab(0).setEnabled(false);
			aF.getTsDetails().getTab(1).setEnabled(true);
			aF.getButton_6().setEnabled(true);
			aF.getButton_7().setEnabled(true);
			listAllRoles();
			break;
		case 2:
			aF.getTsDetails().getTab(0).setEnabled(false);
			aF.getTsDetails().getTab(1).setEnabled(false);
			aF.getButton_6().setEnabled(false);
			aF.getButton_7().setEnabled(false);
			listAllServices();
			break;
		}
	}

	private void listAllUsers() {
		List<UserTO> users = UserFormController.getInstance().getAllUsers();
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		aF.getTableUsers().removeAllItems();

		for (UserTO userTO : users) {
			Object data[] = { userTO.getIdNumber(), userTO.getName() };
			aF.getTableUsers().addItem(data, userTO);
		}
	}

	public void listAllRoles() {
		List<RoleTO> roles = authManager.getAllRoles();
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		aF.getTableRolesData().removeAllItems();

		for (RoleTO roleTO : roles) {
			Object data[] = { roleTO.getName(), roleTO.getDescription() };
			aF.getTableRolesData().addItem(data, roleTO);
		}
	}

	public void listUserRoles(String userName) {
		List<RoleTO> roles = authManager.getUserRoles(userName);
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		aF.getTableRolesDetails().removeAllItems();

		for (RoleTO roleTO : roles) {
			Object data[] = { roleTO.getName(), roleTO.getDescription() };
			aF.getTableRolesDetails().addItem(data, roleTO);
		}
	}

	public void listRoleServices(String roleName) {
		List<ServiceTO> services = authManager.getRoleServices(roleName);
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		aF.getTableServicesDetails().removeAllItems();

		for (ServiceTO serviceTO : services) {
			Object data[] = { serviceTO.getName(), serviceTO.getDescription() };
			aF.getTableServicesDetails().addItem(data, serviceTO);
		}
	}

	public void listAllServices() {
		List<ServiceTO> services = authManager.getAllServices();
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		aF.getTableServicesData().removeAllItems();

		for (ServiceTO serviceTO : services) {
			Object data[] = { serviceTO.getName(), serviceTO.getDescription() };
			aF.getTableServicesData().addItem(data, serviceTO);
		}
	}

	public void popUpRoleForm() {
		PopUpRoleForm pRF = Registry.get(PopUpRoleForm.ID);
		((PCSUI) Registry.get(PCSUI.UI)).openSubWindow("Role", pRF);
	}

	public void popUpAddDetailForm() {
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		TabSheet tS = aF.getTsDetails();
		int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
		switch (selectedTab) {
		case TAB_USERS:
			UserTO user = (UserTO) aF.getTableUsers().getValue();
			if (user != null) {
				PopUpUserRoleForm uRF = Registry.get(PopUpUserRoleForm.ID);
				List<RoleTO> roles = authManager.getAllRoles();
				populateUserRolesCombo(roles);
				uRF.setUserId(user.getIdNumber());
				((PCSUI) Registry.get(PCSUI.UI)).openSubWindow("Role", uRF);
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR, "Please select a user");
			break;
		case TAB_ROLES:
			RoleTO role = (RoleTO) aF.getTableRolesData().getValue();
			if (role != null) {
				PopUpRoleServiceForm rSF = Registry
						.get(PopUpRoleServiceForm.ID);
				List<ServiceTO> services = authManager.getAllServices();
				populateRoleServicesCombo(services);
				rSF.setRoleName(role.getName());
				((PCSUI) Registry.get(PCSUI.UI)).openSubWindow("Service", rSF);
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR, "Please select a role");
			break;
		default:
			break;
		}
	}

	public void createRole() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			PopUpRoleForm pRF = Registry.get(PopUpRoleForm.ID);
			String name = pRF.getTextField_2().getValue();
			String description = pRF.getTextArea_1().getValue();

			if (name != null && !name.equals("") && description != null
					&& !description.equals("")) {
				RoleTO role = new RoleTO();
				role.setName(name);
				role.setDescription(description);

				if (authManager.createRole(role)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Creation process executed successfully");
					listAllRoles();
					pRF.clearFormFields();
					ui.closeSubWindow();
				} else
					ui.showNotification(PCSUI.MSG_ERR,
							"Creation process failed");
			} else
				((PCSUI) Registry.get(PCSUI.UI))
						.showNotification(PCSUI.MSG_ERR,
								"Please fill in all required fields (*)");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}

	public void deleteRole() {
		PCSUI ui = (PCSUI) Registry.get(PCSUI.UI);
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		RoleTO role = (RoleTO) aF.getTableRolesData().getValue();
		if (role != null) {
			try {
				if (authManager.deleteRole(role)) {
					ui.showNotification(PCSUI.MSG_ERR,
							"Role '" + role.getName() + "' removed sucessfully");
					listAllRoles();
				} else
					ui.showNotification(PCSUI.MSG_ERR, "Role cannot be removed");
			} catch (Exception e) {
				ui.showNotification(PCSUI.MSG_ERR,
						"Role cannot be removed because it is associated to users and/or services");
			}
		} else
			ui.showNotification(PCSUI.MSG_ERR,
					"Please select a role to be removed");
	}

	public void removeDetailRecord() {
		PCSUI ui = (PCSUI) Registry.get(PCSUI.UI);
		AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
		TabSheet tS = aF.getTsDetails();
		int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
		switch (selectedTab) {
		case TAB_USERS:
			UserTO user = (UserTO) aF.getTableUsers().getValue();
			if (user != null) {
				RoleTO role = (RoleTO) aF.getTableRolesDetails().getValue();
				if (role != null) {
					try {
						if (authManager.removeRoleFromUser(user, role)) {
							ui.showNotification(
									PCSUI.MSG_ERR,
									"Role '" + role.getName()
											+ "' removed from user "
											+ user.getIdNumber());
							listUserRoles(user.getIdNumber());
						} else
							ui.showNotification(PCSUI.MSG_ERR,
									"Role cannot be removed");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					ui.showNotification(PCSUI.MSG_ERR,
							"Please select a role to be removed");
			} else
				ui.showNotification(PCSUI.MSG_ERR, "Please select a user");
			break;
		case TAB_ROLES:
			RoleTO role = (RoleTO) aF.getTableRolesData().getValue();
			if (role != null) {
				ServiceTO service = (ServiceTO) aF.getTableServicesDetails()
						.getValue();
				if (service != null) {
					try {
						if (authManager.removeServiceFromRole(role, service)) {
							ui.showNotification(PCSUI.MSG_ERR, "Service '"
									+ service.getName()
									+ "' removed from role " + role.getName());
							listRoleServices(role.getName());
						} else
							ui.showNotification(PCSUI.MSG_ERR,
									"Role cannot be removed");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					ui.showNotification(PCSUI.MSG_ERR,
							"Please select a service to be removed");
			} else
				ui.showNotification(PCSUI.MSG_ERR, "Please select a role");
			break;
		default:
			break;
		}
	}

	public boolean addRoleToUser(String userID) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			PopUpUserRoleForm uRF = Registry.get(PopUpUserRoleForm.ID);
			RoleTO role = (RoleTO) uRF.getComboBox_1().getValue();
			if (role != null) {
				if (authManager.addRoleToUser(userID, role)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Role '" + role.getName() + "' added to User '"
									+ userID + "'");
					ui.closeSubWindow();
					listUserRoles(userID);
					return true;
				} else {
					ui.showNotification(PCSUI.MSG_ERR,
							"Role cannot be added to user");
					return false;
				}
			} else
				ui.showNotification(PCSUI.MSG_ERR, "Please select a role");
			return false;
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
			return false;
		}
	}

	public boolean addServiceToRole(String roleId) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			PopUpRoleServiceForm rSF = Registry.get(PopUpRoleServiceForm.ID);
			ServiceTO service = (ServiceTO) rSF.getComboBox_1().getValue();
			if (service != null) {
				if (authManager.addServiceToRole(roleId, service)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Service '" + service.getName()
									+ "' added to Role '" + roleId + "'");
					ui.closeSubWindow();
					listRoleServices(roleId);
					return true;
				} else {
					ui.showNotification(PCSUI.MSG_ERR,
							"Service cannot be added to role");
					return false;
				}
			} else
				ui.showNotification(PCSUI.MSG_ERR, "Please select a service");
			return false;
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
			return false;
		}
	}

	private void populateUserRolesCombo(List<RoleTO> roles) {
		PopUpUserRoleForm uRF = Registry.get(PopUpUserRoleForm.ID);
		ComboBox combo = uRF.getComboBox_1();
		combo.removeAllItems();

		for (RoleTO roleTO : roles) {
			combo.addItem(roleTO);
		}
	}

	private void populateRoleServicesCombo(List<ServiceTO> services) {
		PopUpRoleServiceForm rSF = Registry.get(PopUpRoleServiceForm.ID);
		ComboBox combo = rSF.getComboBox_1();
		combo.removeAllItems();

		for (ServiceTO serviceTO : services) {
			combo.addItem(serviceTO);
		}
	}

	public void updateUserRolesFormFields() {
		PopUpUserRoleForm uRF = Registry.get(PopUpUserRoleForm.ID);
		ComboBox combo = uRF.getComboBox_1();
		RoleTO role = (RoleTO) combo.getValue();
		TextField tx1 = uRF.getTextField_1();
		TextField tx2 = uRF.getTextField_2();
		if (role != null) {
			tx1.setValue(role.getName());
			tx2.setValue(role.getDescription());
		}
	}

	public void updateRoleServicesFormFields() {
		PopUpRoleServiceForm rSF = Registry.get(PopUpRoleServiceForm.ID);
		ComboBox combo = rSF.getComboBox_1();
		ServiceTO service = (ServiceTO) combo.getValue();
		TextField tx1 = rSF.getTextField_1();
		TextField tx2 = rSF.getTextField_2();
		if (service != null) {
			tx1.setValue(service.getName());
			tx2.setValue(service.getDescription());
		}
	}

	public Command getAuthCommand() {
		return new Command() {

			private static final long serialVersionUID = 1L;

			@Override
			public void menuSelected(MenuItem selectedItem) {
				showAuthForm();
			}
		};
	}

	public boolean hasAdminRole(String userID) {
		List<RoleTO> userRoles = authManager.getUserRoles(userID);
		RoleTO adm = new RoleTO();
		adm.setName("Admin User"); // Se debe obtener de la BD?
		return userRoles.contains(adm);
	}

	@Override
	public void contributeProcess(Object data) throws Exception {
		String serviceName = (String) data;
		ServiceTO service = new ServiceTO();
		service.setName(serviceName);

		authorize(service);
	}
}
