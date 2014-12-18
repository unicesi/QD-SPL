package co.shift.pcs.web.ext.project;

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

import co.shift.pcs.web.ext.user.UserController;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.web.ext.user.UserController;
import co.shift.pcs.web.ext.user.UserManagerForm;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.web.ext.risk.RiskController;
import co.shift.pcs.to.RiskTO;
import co.shift.pcs.web.ext.risk.RiskController;
import co.shift.pcs.web.ext.risk.RiskPriorityRiskForm;
import co.shift.pcs.to.RiskTO;
import co.shift.pcs.web.ext.user.UserController;
import co.shift.pcs.web.ext.user.PopUpProjectUserForm;
import co.shift.pcs.web.ext.risk.PopUpRiskForm;
import co.shift.pcs.web.AbstractController;
import co.shift.pcs.web.PCSUI;
import co.shift.pcs.web.Registry;
import co.shift.pcs.web.UIContributor;
import co.shift.pcs.web.ProcessContributor;
import co.shift.pcs.web.client.ContentPanel;
import co.shift.pcs.web.client.MenuPanel;
import co.shift.pcs.project.boundary.IProjectManager;
import co.shift.pcs.util.beanlocator.BeanLocator;
import co.shift.pcs.to.ProjectTO;


public class ProjectController extends AbstractController {
	
	private static ProjectController controller;
	private static final int TAB_USER = 0;
	private static final int TAB_RISK = 1;
	
	private IProjectManager projectManager;
	
	private ProjectController() {
		doLookup();
	}
	
	private void doLookup() {
		projectManager = BeanLocator.lookup(
				IProjectManager.class,
				new BeanLocator().getGlobalJNDIName()
						.withAppName("co.shift.ear")
						.withModuleName("co.shift.ejb")
						.withBeanName("ProjectManager")
						.withBusinessInterface(IProjectManager.class)
						.asString());
	}
	
	public void showProjectForm() {
		ProjectForm projectForm = Registry.get(ProjectForm.ID);
		
		listAllProject();

		ContentPanel panel = Registry.get(PCSUI.CONTENT_PANEL);
		panel.removeContent();
		panel.setContent(projectForm);
	}
	
	public void removeDetailRecord() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			TabSheet tS = pF.getTabSheet_1();
			int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
			switch (selectedTab) {
			case TAB_USER:
				try {
					// String obtained from ClassName - MethodName
					extendProcess(AuthorizerController.ID, "Project - RemoveUser");
					
					UserTO user = (UserTO) pF.getTable_2().getValue();
					if (user != null) {
						removeUserFromProject(ui, project, user);
					} else
						((PCSUI) Registry.get(PCSUI.UI)).showNotification(
								PCSUI.MSG_ERR,
								"Please select the user to be removed");
				} catch (Exception e) {
					ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
				}
				break;
			case TAB_RISK:
				try {
					// String obtained from ClassName - MethodName
					extendProcess(AuthorizerController.ID, "Project - RemoveRisk");
					
					RiskTO risk = (RiskTO) pF.getTable_3().getValue();
					if (risk != null) {
						deleteRiskFromProject(ui, risk);
					} else
						((PCSUI) Registry.get(PCSUI.UI)).showNotification(
								PCSUI.MSG_ERR,
								"Please select the risk to be removed");
				} catch (Exception e) {
					ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
				}
				break;
			default:
				break;
			}

		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	
	public static ProjectController getInstance() {
		if (controller == null) {
			controller = new ProjectController();
			ProjectForm pF = new ProjectForm();
			Registry.register(ProjectForm.ID, pF);
		}
		return controller;
	}
	
	public List<ProjectTO> getProjectFromUser(String userCc) {
		return projectManager.getProjectFromUser(userCc);
	}
	
	
	
	public List<ProjectTO> getAllProjects() {
	 try {
	return projectManager.getAllProjects();
	} catch (Exception e) { return new ArrayList(); }
	}
	
	
	private void listAllProject() {
	 try {
	List<ProjectTO> list = projectManager.getAllProjects();
	ProjectForm pF = Registry.get(ProjectForm.ID);
	pF.getTable_1().removeAllItems();
	for (ProjectTO to : list) {
	Object data[] = { to.getId(), to.getDescription(), to.getName(), to.getStartDate(),  };
	pF.getTable_1().addItem(data, to);
	} } catch (Exception e) {}
	}
	
	
	public void listAllDetailsFromProject(ItemClickEvent event) {
		ProjectForm pF = Registry.get(ProjectForm.ID);
		ProjectTO project = (ProjectTO) event.getItemId();
		if (project != null) {
			pF.getTxtId().setValue(""+project.getId());
			pF.getTxtDescription().setValue(""+project.getDescription());
			pF.getTxtName().setValue(""+project.getName());
			pF.getTxtDStartDate().setValue(project.getStartDate());
			listProjectUser(project.getId());
			UserTO manager = UserController.getInstance()
					.getProjectManager(project.getId());
			if (manager != null)
				pF.updateManagerFields(manager);
			else
				pF.clearManagerFields();
			listProjectRisk(project.getId());
			RiskTO priorityrisk = RiskController.getInstance()
					.getProjectPriorityRisk(project.getId());
			if (priorityrisk != null)
				pF.updatePriorityRiskFields(priorityrisk);
			else
				pF.clearPriorityRiskFields();
		} else
			pF.clearFormFields();
	}
	public void listProjectUser(int projectID) {
		List<UserTO> users = UserController.getInstance()
				.getUserFromProject(projectID);
		ProjectForm pF = Registry.get(ProjectForm.ID);
		pF.getTable_2().removeAllItems();
		
		for (UserTO to : users) {
			Object data[] = { 
				to.getCc(), 
				to.getName(), 
				to.getCellphone(), 
				to.getPassword()
			};
			pF.getTable_2().addItem(data, to);
		}
	}
	public void listProjectRisk(int projectID) {
		List<RiskTO> risks = RiskController.getInstance()
				.getRiskFromProject(projectID);
		ProjectForm pF = Registry.get(ProjectForm.ID);
		pF.getTable_3().removeAllItems();
		
		for (RiskTO to : risks) {
			Object data[] = { 
				to.getId(), 
				to.getDescription(), 
				to.getImpact(), 
				to.getName(), 
				to.getProbability()
			};
			pF.getTable_3().addItem(data, to);
		}
	}
	
	public void createProject() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - Create");
			
			ProjectForm pF = Registry.get(ProjectForm.ID);
			int id = Integer.parseInt(pF.getTxtId().getValue());
			String description = pF.getTxtDescription().getValue();
			String name = pF.getTxtName().getValue();
			Date startdate = pF.getTxtDStartDate().getValue();

			if (
			description != null && !description.equals("")
			&&
						name != null && !name.equals("")
			&&
						startdate != null
			) {
				ProjectTO project = new ProjectTO();
				project.setId(id);
				project.setDescription(description);
				project.setName(name);
				project.setStartDate(startdate);

				if (projectManager.createProject(project)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Creation process executed successfully");
					
					listAllProject();
					ProjectForm projectForm = Registry.get(ProjectForm.ID);
					projectForm.clearFormFields();
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
	public void updateProject() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - Update");
			
			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			if (project != null) {
				project.setId(Integer.parseInt(pF.getTxtId().getValue()));
				project.setDescription(pF.getTxtDescription().getValue());
				project.setName(pF.getTxtName().getValue());
				project.setStartDate(pF.getTxtDStartDate().getValue());

				if (projectManager.updateProject(project))
					ui.showNotification(PCSUI.MSG_NOT,
							"Updating process executed successfully");
				else
					ui.showNotification(PCSUI.MSG_ERR,
							"Updating process failed");
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR, "Please select a project to update");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	public boolean addUserToProject(UserTO user, int projectId) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			if (projectManager.addUserToProject(user, projectId)) {
				ui.showNotification(PCSUI.MSG_NOT, "User " + user.getCc()
						+ " added to Project " + projectId);
				ui.closeSubWindow();
				listProjectUser(projectId);
				return true;
			} else {
				ui.showNotification(PCSUI.MSG_ERR,
						"User cannot be added to project");
				return false;
			}
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
			return false;
		}
	}
	public void deleteProject() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - Delete");
			
			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			if (project != null) {
				if (projectManager.deleteProject(project)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Delete process executed successfully");
					
					listAllProject();
					ProjectForm projectForm = Registry.get(ProjectForm.ID);
					projectForm.clearFormFields();
				} else
					ui.showNotification(PCSUI.MSG_ERR, "Delete process failed");
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR, "Please select a project to delete");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	public void removeUserFromProject(PCSUI ui, ProjectTO project, UserTO user) {
		try {
			if (projectManager.removeUserFromProject(user, project.getId())) {
				ui.showNotification(PCSUI.MSG_NOT, "User " + user.getCc()
					+ " removed from Project " + project.getId());
			ui.closeSubWindow();
			listProjectUser(project.getId());
		} else {
			ui.showNotification(PCSUI.MSG_ERR,
					"User cannot be removed from project");
		}
	} catch (Exception e) {
		ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
	}
	}
	public void deleteRiskFromProject(PCSUI ui, RiskTO risk) {
		try {
			if (RiskController.getInstance().deleteRisk(risk)) {
				ui.showNotification(PCSUI.MSG_NOT, "Risk " + risk.getId()
					+ " removed from Project " + risk.getProject());
			ui.closeSubWindow();
			listProjectRisk(risk.getProject());
			} else {
				ui.showNotification(PCSUI.MSG_ERR,
					"Risk cannot be removed from project");
			}
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	
	public void setProjectManager(int project) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			UserManagerForm uMF = Registry.get(UserManagerForm.ID);
			ComboBox combo = uMF.getComboBox_1();
			UserTO manager = (UserTO) combo.getValue();
			if (manager != null) {
				if (projectManager.setProjectManager(manager, project)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"User " + manager.getCc()
									+ " was set as Manager of Project "
									+ project);
					ui.closeSubWindow();
					ProjectForm projectForm = Registry.get(ProjectForm.ID);
					projectForm.updateManagerFields(manager);
				} else {
					ui.showNotification(PCSUI.MSG_ERR,
							"User cannot be added to project");
				}
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR, "Please select the manager");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	
	public void popUpManagerForm() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - SetManager");
			
			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			if (project != null) {
				UserManagerForm uMF = Registry.get(UserManagerForm.ID);
				List<UserTO> users = UserController.getInstance()
						.getUserFromProject(project.getId());
				uMF.setProject(project.getId());
				uMF.clearFormFields();
				UserTO manager = UserController.getInstance()
						.getProjectManager(project.getId());
				// uMF.populateUsers(users, manager);
				UserController.getInstance().populateUserManagerCombo(
						users, manager);
				((PCSUI) Registry.get(PCSUI.UI)).openSubWindow(
						"Project Manager", uMF);
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR,
						"Please select a project to set its manager");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	public void setProjectPriorityRisk(int project) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			RiskPriorityRiskForm uMF = Registry.get(RiskPriorityRiskForm.ID);
			ComboBox combo = uMF.getComboBox_1();
			RiskTO priorityrisk = (RiskTO) combo.getValue();
			if (priorityrisk != null) {
				if (projectManager.setProjectPriorityRisk(priorityrisk, project)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Risk " + priorityrisk.getId()
									+ " was set as PriorityRisk of Project "
									+ project);
					ui.closeSubWindow();
					ProjectForm projectForm = Registry.get(ProjectForm.ID);
					projectForm.updatePriorityRiskFields(priorityrisk);
				} else {
					ui.showNotification(PCSUI.MSG_ERR,
							"Risk cannot be added to project");
				}
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR, "Please select the priorityrisk");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	
	public void popUpPriorityRiskForm() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - SetPriorityRisk");
			
			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			if (project != null) {
				RiskPriorityRiskForm uMF = Registry.get(RiskPriorityRiskForm.ID);
				List<RiskTO> risks = RiskController.getInstance()
						.getRiskFromProject(project.getId());
				uMF.setProject(project.getId());
				uMF.clearFormFields();
				RiskTO priorityrisk = RiskController.getInstance()
						.getProjectPriorityRisk(project.getId());
				// uMF.populateUsers(users, manager);
				RiskController.getInstance().populateRiskPriorityRiskCombo(
						risks, priorityrisk);
				((PCSUI) Registry.get(PCSUI.UI)).openSubWindow(
						"Project PriorityRisk", uMF);
			} else
				((PCSUI) Registry.get(PCSUI.UI)).showNotification(
						PCSUI.MSG_ERR,
						"Please select a project to set its priorityrisk");
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}
	
	public void popUpAddDetailForm() {
		ProjectForm pF = Registry.get(ProjectForm.ID);
		ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
		PCSUI ui = Registry.get(PCSUI.UI);
		
		if (project != null) {
			TabSheet tS = pF.getTabSheet_1();
			int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
			switch (selectedTab) {
			case TAB_USER:
				try {
					// String obtained from ClassName - MethodName
					extendProcess(AuthorizerController.ID, "Project - AddUser");
					

					PopUpProjectUserForm uF = Registry.get(PopUpProjectUserForm.ID);
					List<UserTO> users = UserController.getInstance()
							.getAllUsers();
					// uF.populateUsers(users);
					UserController.getInstance().populateUserCombo(users);
					uF.setProject(project.getId());
					((PCSUI) Registry.get(PCSUI.UI)).openSubWindow("User", uF);
				} catch (Exception e) {
					ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
				}
				break;
			case TAB_RISK:
				try {
					// String obtained from ClassName - MethodName
					extendProcess(AuthorizerController.ID, "Project - AddRisk");
					

		PopUpRiskForm rF = Registry.get(PopUpRiskForm.ID);
		rF.setProject(project.getId());
		((PCSUI) Registry.get(PCSUI.UI)).openSubWindow("Risk", rF);
				} catch (Exception e) {
					ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
				}
				break;
			default:
				break;
			}
		} else
			ui.showNotification(PCSUI.MSG_ERR, "Please select a project");
	}
		
	public Command getProjectCommand() {
		return new Command() {
		
			private static final long serialVersionUID = 1L;
		
			@Override
			public void menuSelected(MenuItem selectedItem) {
				showProjectForm();
			}
		};
	}
	
	
	
}
