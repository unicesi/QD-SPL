package co.shift.pcs.basic.ext.projects;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TabSheet;

import co.shift.pcs.basic.ext.authorizer.AuthorizerController;
import co.shift.pcs.basic.ext.risks.PopUpRiskForm;
import co.shift.pcs.basic.ext.risks.RiskFormController;
import co.shift.pcs.basic.ext.users.PopUpUserForm;
import co.shift.pcs.basic.ext.users.UserFormController;
import co.shift.pcs.basic.ext.users.UserManagerForm;
import co.shift.pcs.basic.web.AbstractController;
import co.shift.pcs.basic.web.PCSUI;
import co.shift.pcs.basic.web.Registry;
import co.shift.pcs.basic.web.UIContributor;
import co.shift.pcs.basic.web.client.ContentPanel;
import co.shift.pcs.basic.web.client.MenuPanel;
import co.shift.pcs.projects.boundary.IProjectManager;
import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.to.RiskTO;
import co.shift.pcs.to.UserTO;
import co.shift.pcs.util.beanlocator.BeanLocator;

public class ProjectFormController extends AbstractController {

	private static ProjectFormController controller;
	private static final int TAB_USERS = 0;
	private static final int TAB_RISKS = 1;

	private IProjectManager projectManager;

	private ProjectFormController() {
		doLookup();
	}

	private void doLookup() {
		projectManager = BeanLocator.lookup(
				IProjectManager.class,
				new BeanLocator().getGlobalJNDIName()
						.withAppName("co.shift.pcs.basic.ear")
						.withModuleName("co.shift.pcs.projects.basic")
						.withBeanName("ProjectManager")
						.withBusinessInterface(IProjectManager.class)
						.asString());
	}

	public void showProjectForm() {
		ProjectForm projectForm = Registry.get(ProjectForm.ID);
		listAllProjectsOptimized(); // OPTIMIZED

		ContentPanel panel = Registry.get(PCSUI.CONTENT_PANEL);
		panel.removeContent();
		panel.setContent(projectForm);
	}

	/**
	 * 
	 * @return
	 */
	public static ProjectFormController getInstance() {
		if (controller == null) {
			controller = new ProjectFormController();
			ProjectForm pF = new ProjectForm();
			Registry.register(ProjectForm.ID, pF);
		}
		return controller;
	}

	// ECB & BasicFLR
	private void listAllProjects() {
		// ECB
		// List<ProjectTO> projects = projectManager.getAllProjects();

		// BasicFLR
		// List<ProjectTO> projects = projectManager.getAllProjectsBasicFLR();

		// Parallelizer
		List<ProjectTO> projects = projectManager.getAllProjectsParallelizer();

		ProjectForm pF = Registry.get(ProjectForm.ID);
		pF.getTable_1().removeAllItems();

		for (ProjectTO projectTO : projects) {
			Object data[] = { projectTO.getId(), projectTO.getName() };
			pF.getTable_1().addItem(data, projectTO);
		}
	}

	// OptimizedFLR
	private void listAllProjectsOptimized() {
		List<ProjectTO> projects = null;
		int start = 0, maxResults = 1;
		ProjectForm pF = Registry.get(ProjectForm.ID);
		pF.getTable_1().removeAllItems();
		do {
			projects = projectManager.getAllProjectsOptimizedFLR(start,
					maxResults);
			new ProjectListUpdater(pF, projects).start();
			start += maxResults;
		} while (projects.size() > 0);
	}

	// ProjectForm events
	public void listAllDetailsFromProject(ItemClickEvent event) {
		ProjectForm pF = Registry.get(ProjectForm.ID);
		ProjectTO project = (ProjectTO) event.getItemId();
		if (project != null) {
			pF.getTextField_1().setValue(project.getName());
			pF.getTextArea_1().setValue(project.getDescription());
			pF.getPopupDateField_1().setValue(project.getStartDate());

			listProjectUsers(project.getId());
			listProjectRisks(project.getId());

			UserTO manager = UserFormController.getInstance()
					.getProjectManager(project.getId());
			if (manager != null)
				pF.updateManagerFields(manager);
			else
				pF.clearManagerFields();
		} else
			pF.clearFormFields();
	}

	private void listProjectUsers(int projectID) {
		List<UserTO> users = UserFormController.getInstance()
				.getUsersFromProject(projectID);
		ProjectForm pF = Registry.get(ProjectForm.ID);
		pF.getTable_2().removeAllItems();

		for (UserTO userTO : users) {
			Object data[] = { userTO.getName(), userTO.getIdNumber(),
					userTO.getCellphone() };
			pF.getTable_2().addItem(data, userTO);
		}
	}

	public void listProjectRisks(int projectID) {
		List<RiskTO> risks = RiskFormController.getInstance()
				.getRisksFromProject(projectID);
		ProjectForm pF = Registry.get(ProjectForm.ID);
		pF.getTable_3().removeAllItems();
		BigDecimal aHundred = new BigDecimal(100);
		for (RiskTO riskTO : risks) {
			Object data[] = { riskTO.getId(), riskTO.getName(),
					riskTO.getDescription(),
					riskTO.getImpact().multiply(aHundred),
					riskTO.getProbability().multiply(aHundred) };
			pF.getTable_3().addItem(data, riskTO);
		}
	}

	public void createProject() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {

			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - Add");

			ProjectForm pF = Registry.get(ProjectForm.ID);
			String name = pF.getTextField_1().getValue();
			String description = pF.getTextArea_1().getValue();
			Date startDate = pF.getPopupDateField_1().getValue();

			if (name != null && !name.equals("") && description != null
					&& !description.equals("") && startDate != null) {
				ProjectTO project = new ProjectTO();
				project.setName(name);
				project.setDescription(description);
				project.setStartDate(startDate);

				if (projectManager.createProject(project)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Creation process executed successfully");
					listAllProjectsOptimized(); // OPTIMIZED
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

			extendProcess(AuthorizerController.ID, "Project - Update");

			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			if (project != null) {
				project.setName(pF.getTextField_1().getValue());
				project.setDescription(pF.getTextArea_1().getValue());
				project.setStartDate(pF.getPopupDateField_1().getValue());

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

	public void deleteProject() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {

			extendProcess(AuthorizerController.ID, "Project - Delete");

			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			if (project != null) {
				if (projectManager.deleteProject(project)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"Delete process executed successfully");
					listAllProjects();
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

	public boolean addUserToProject(UserTO user, int projectID) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			if (projectManager.addUserToProject(user, projectID)) {
				ui.showNotification(PCSUI.MSG_NOT, "User " + user.getIdNumber()
						+ " added to Project " + projectID);
				ui.closeSubWindow();
				listProjectUsers(projectID);
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

	public void removeDetailRecord() {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			TabSheet tS = pF.getTabSheet_1();
			int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
			switch (selectedTab) {
			case TAB_USERS:
				try {
					extendProcess(AuthorizerController.ID,
							"Project - RemoveUser");

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
			case TAB_RISKS:
				try {
					extendProcess(AuthorizerController.ID,
							"Project - RemoveRisk");

					RiskTO risk = (RiskTO) pF.getTable_3().getValue();
					if (risk != null)
						removeRiskFromProject(ui, risk);
					else
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

	private void removeUserFromProject(PCSUI ui, ProjectTO project, UserTO user)
			throws Exception {
		if (projectManager.removeUserFromProject(user, project.getId())) {
			ui.showNotification(PCSUI.MSG_NOT, "User " + user.getIdNumber()
					+ " removed from Project " + project.getId());
			ui.closeSubWindow();
			listProjectUsers(project.getId());
		} else {
			ui.showNotification(PCSUI.MSG_ERR,
					"User cannot be removed from project");
		}
	}

	private void removeRiskFromProject(PCSUI ui, RiskTO risk) throws Exception {
		try {
			if (RiskFormController.getInstance().deleteRisk(risk)) {
				ui.showNotification(PCSUI.MSG_NOT, "Risk " + risk.getId()
						+ " removed from Project " + risk.getProject());
				ui.closeSubWindow();
				listProjectRisks(risk.getProject());
			} else {
				ui.showNotification(PCSUI.MSG_ERR,
						"Risk cannot be removed from project");
			}
		} catch (Exception e) {
			ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
		}
	}

	public void setProjectManager(int projectID) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			UserManagerForm uMF = Registry.get(UserManagerForm.ID);
			ComboBox combo = uMF.getComboBox_1();
			UserTO manager = (UserTO) combo.getValue();
			if (manager != null) {
				if (projectManager.setProjectManager(manager, projectID)) {
					ui.showNotification(PCSUI.MSG_NOT,
							"User " + manager.getIdNumber()
									+ " was set as manager of Project "
									+ projectID);
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
			extendProcess(AuthorizerController.ID, "Project - SetManager");

			ProjectForm pF = Registry.get(ProjectForm.ID);
			ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
			if (project != null) {
				UserManagerForm uMF = Registry.get(UserManagerForm.ID);
				List<UserTO> users = UserFormController.getInstance()
						.getUsersFromProject(project.getId());
				uMF.setProjectID(project.getId());
				uMF.clearManagerFields();
				UserTO manager = UserFormController.getInstance()
						.getProjectManager(project.getId());
				// uMF.populateUsers(users, manager);
				UserFormController.getInstance().populateUserManagerCombo(
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

	public void popUpAddDetailForm() {
		ProjectForm pF = Registry.get(ProjectForm.ID);
		ProjectTO project = (ProjectTO) pF.getTable_1().getValue();
		PCSUI ui = Registry.get(PCSUI.UI);

		if (project != null) {
			TabSheet tS = pF.getTabSheet_1();
			int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
			switch (selectedTab) {
			case TAB_USERS:
				try {
					extendProcess(AuthorizerController.ID, "Project - AddUser");

					PopUpUserForm uF = Registry.get(PopUpUserForm.ID);
					List<UserTO> users = UserFormController.getInstance()
							.getAllUsers();
					// uF.populateUsers(users);
					UserFormController.getInstance().populateUsersCombo(users);
					uF.setProjectID(project.getId());
					((PCSUI) Registry.get(PCSUI.UI)).openSubWindow("User", uF);
				} catch (Exception e) {
					ui.showNotification(PCSUI.MSG_ERR, e.getMessage());
				}
				break;
			case TAB_RISKS:
				try {
					extendProcess(AuthorizerController.ID, "Project - AddRisk");

					PopUpRiskForm rF = Registry.get(PopUpRiskForm.ID);
					rF.setProjectID(project.getId());
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
