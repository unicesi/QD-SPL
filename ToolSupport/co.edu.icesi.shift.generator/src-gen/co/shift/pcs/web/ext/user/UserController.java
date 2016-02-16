package co.shift.pcs.web.ext.user;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.PopupDateField;

import co.shift.pcs.web.ext.authorizer.AuthorizerController;

import co.shift.pcs.web.ext.project.ProjectController;
import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.web.ext.project.ProjectController;
import co.shift.pcs.web.ext.project.ProjectController;
import co.shift.pcs.web.AbstractController;
import co.shift.pcs.web.PCSUI;
import co.shift.pcs.web.Registry;
import co.shift.pcs.web.UIContributor;
import co.shift.pcs.web.ProcessContributor;
import co.shift.pcs.web.client.ContentPanel;
import co.shift.pcs.web.client.MenuPanel;
import co.shift.pcs.user.boundary.IUserManager;
import co.shift.pcs.util.beanlocator.BeanLocator;
import co.shift.pcs.to.UserTO;


public class UserController extends AbstractController {
	
	private static UserController controller;
	private static final int TAB_PROJECT = 0;
	
	private IUserManager userManager;
	
	private UserController() {
		doLookup();
	}
	
	private void doLookup() {
		userManager = BeanLocator.lookup(
				IUserManager.class,
				new BeanLocator().getGlobalJNDIName()
						.withAppName("co.shift.ear")
						.withModuleName("co.shift.ejb")
						.withBeanName("UserManager")
						.withBusinessInterface(IUserManager.class)
						.asString());
	}
	
	public void showUserForm() {
		UserForm userForm = Registry.get(UserForm.ID);
		
		listAllUser();

		ContentPanel panel = Registry.get(PCSUI.CONTENT_PANEL);
		panel.removeContent();
		panel.setContent(userForm);
	}
	
	public void removeDetailRecord() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			UserForm pF = Registry.get(UserForm.ID);
			UserTO user = (UserTO) pF.getTable_1().getValue();
			TabSheet tS = pF.getTabSheet_1();
			int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
			switch (selectedTab) {
			default:
				break;
			}

		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	
	public static UserController getInstance() {
		if (controller == null) {
			controller = new UserController();
			UserForm pF = new UserForm();
			Registry.register(UserForm.ID, pF);
			PopUpProjectUserForm uF = new PopUpProjectUserForm();
			Registry.register(PopUpProjectUserForm.ID, uF);
			UserManagerForm uMF = new UserManagerForm();
			Registry.register(UserManagerForm.ID, uMF);
		}
		return controller;
	}
	
	public List<UserTO> getUserFromProject(int projectId) {
		return userManager.getUserFromProject(projectId);
	}
	
	
	public UserTO getProjectManager(int projectId) {
		return userManager.getProjectManager(projectId);
	}
	
	public List<UserTO> getAllUsers() {
	return userManager.getAllUsers();
	}
	
	
	private void listAllUser() {
	List<UserTO> list = userManager.getAllUsers();
	UserForm pF = Registry.get(UserForm.ID);
	pF.getTable_1().removeAllItems();
	for (UserTO to : list) {
	Object data[] = { to.getCc(), to.getName(), to.getCellphone(), to.getPassword(),  };
	pF.getTable_1().addItem(data, to);
	}
	}
	
	
	public void listAllDetailsFromUser(ItemClickEvent event) {
		UserForm pF = Registry.get(UserForm.ID);
		UserTO user = (UserTO) event.getItemId();
		if (user != null) {
			pF.getTxtCc().setValue(""+user.getCc());
			pF.getTxtName().setValue(""+user.getName());
			pF.getTxtCellphone().setValue(""+user.getCellphone());
			pF.getTxtPassword().setValue(""+user.getPassword());
			listUserProject(user.getCc());
		} else
			pF.clearFormFields();
	}
	public void listUserProject(String userID) {
		List<ProjectTO> projects = ProjectController.getInstance()
				.getProjectFromUser(userID);
		UserForm pF = Registry.get(UserForm.ID);
		pF.getTable_2().removeAllItems();
		
		for (ProjectTO to : projects) {
			Object data[] = { 
				to.getId(), 
				to.getDescription(), 
				to.getName(), 
				to.getStartDate()
			};
			pF.getTable_2().addItem(data, to);
		}
	}
	
	public void createUser() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "User - Create");
			
			UserForm pF = Registry.get(UserForm.ID);
			String cc = pF.getTxtCc().getValue();
			String name = pF.getTxtName().getValue();
			String cellphone = pF.getTxtCellphone().getValue();
			String password = pF.getTxtPassword().getValue();

			if (
			cc != null && !cc.equals("")
			&&
						name != null && !name.equals("")
			&&
						cellphone != null && !cellphone.equals("")
			&&
						password != null && !password.equals("")
			) {
				UserTO user = new UserTO();
				user.setCc(cc);
				user.setName(name);
				user.setCellphone(cellphone);
				user.setPassword(password);

				if (userManager.createUser(user)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Creation process executed successfully");
					
					listAllUser();
					UserForm userForm = Registry.get(UserForm.ID);
					userForm.clearFormFields();
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
	
	
	public void popUpAddDetailForm() {
		UserForm pF = Registry.get(UserForm.ID);
		UserTO user = (UserTO) pF.getTable_1().getValue();
		PCSUI ui = Registry.get(PCSUI.UI);
		
		if (user != null) {
			TabSheet tS = pF.getTabSheet_1();
			int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
			switch (selectedTab) {
			default:
				break;
			}
		} else
			ui.showNotification(PCSUI.MSG_ERR, "Please select a user");
	}
		
	public Command getUserCommand() {
		return new Command() {
		
			private static final long serialVersionUID = 1L;
		
			@Override
			public void menuSelected(MenuItem selectedItem) {
				showUserForm();
			}
		};
	}
	
	
	public void addUserToProject(int project) {
		PopUpProjectUserForm pF = Registry.get(PopUpProjectUserForm.ID);
		try{		
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - AddUser");
			
			String cc = pF.getTextField_1().getValue();
			String name = pF.getTextField_2().getValue();
			String cellphone = pF.getTextField_3().getValue();
			String password = pF.getTextField_4().getValue();
			
			if (
				cc != null && !cc.equals("")
				&&
								name != null && !name.equals("")
				&&
								cellphone != null && !cellphone.equals("")
				&&
								password != null && !password.equals("")
				) {
					UserTO user = new UserTO();
					user.setCc(cc);						
					user.setName(name);						
					user.setCellphone(cellphone);						
					user.setPassword(password);						
					if (ProjectController.getInstance().addUserToProject(user, project))
						pF.clearFormFields();
				} else
					((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
						"Please fill in all required fields (*)");
				} catch (Exception e) {
					((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
						"Please fill in all required fields (*)");
				}
			}
			
			
	public void populateUserCombo(List<UserTO> list) {
		PopUpProjectUserForm uF = Registry.get(PopUpProjectUserForm.ID);
		ComboBox combo = uF.getComboBox_1();
		combo.removeAllItems();
		
		for (UserTO to : list) {
			combo.addItem(to);
		}
	}
	
	public void updateProjectUsersFormFields() {
		PopUpProjectUserForm uF = Registry.get(PopUpProjectUserForm.ID);
		ComboBox combo = uF.getComboBox_1();
		UserTO user = (UserTO) combo.getValue();
		if (user != null) {
			TextField txtCc = uF.getTextField_1();
			txtCc.setValue(user.getCc());
			TextField txtName = uF.getTextField_2();
			txtName.setValue(user.getName());
			TextField txtCellphone = uF.getTextField_3();
			txtCellphone.setValue(user.getCellphone());
			TextField txtPassword = uF.getTextField_4();
			txtPassword.setValue(user.getPassword());
		}
	}
	
	public void updateManagerFormFields() {
		UserManagerForm uMF = Registry.get(UserManagerForm.ID);
		ComboBox combo = uMF.getComboBox_1();
		UserTO user = (UserTO) combo.getValue();
		if (user != null) {
			uMF.getTextField_1().setValue(user.getCc());
			uMF.getTextField_2().setValue(user.getName());
			uMF.getTextField_3().setValue(user.getCellphone());
			uMF.getTextField_4().setValue(user.getPassword());
		}
	}

	public void setProjectManager(int project) {
		ProjectController.getInstance().setProjectManager(project);
	}

	public void populateUserManagerCombo(List<UserTO> list, UserTO manager) {
		UserManagerForm uMF = Registry.get(UserManagerForm.ID);
		ComboBox combo = uMF.getComboBox_1();
		combo.removeAllItems();
		UserTO uManager = null;
		for (UserTO to : list) {
			if (to.equals(manager))
				uManager = to;
			combo.addItem(to);
		}
		
		if (uMF.getProject() > 0) {
			if (uManager != null)
				combo.setValue(uManager);
		}
	}
	
}
