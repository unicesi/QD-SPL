package co.shift.templates.web.contributed.authenticity

import co.shift.generators.domain.DomainCodeUtilities
import domainmetamodel.BusinessEntity
import domainmetamodel.ListAll

class AuthorizerControllerTemplate {
	
	def static generate(String packageName, BusinessEntity authEntity) '''
		«var beId = DomainCodeUtilities.getID(authEntity)»
		package co.shift.«packageName.toLowerCase()».web.ext.authorizer;
		
		import java.util.List;

		import com.vaadin.ui.ComboBox;
		import com.vaadin.ui.TabSheet;
		import com.vaadin.ui.TextField;
		import com.vaadin.ui.MenuBar.Command;
		import com.vaadin.ui.MenuBar.MenuItem;
		
		import co.shift.«packageName.toLowerCase()».web.ext.«authEntity.name.toLowerCase».«authEntity.name.toFirstUpper»Controller;
		import co.shift.«packageName.toLowerCase()».web.«packageName.toUpperCase»UI;
		import co.shift.«packageName.toLowerCase()».web.ProcessContributor;
		import co.shift.«packageName.toLowerCase()».web.Registry;
		import co.shift.«packageName.toLowerCase()».web.client.ContentPanel;
		import co.shift.«packageName.toLowerCase()».to.RoleTO;
		import co.shift.«packageName.toLowerCase()».to.ServiceTO;
		import co.shift.«packageName.toLowerCase()».to.«authEntity.name.toFirstUpper»TO;
		import co.shift.«packageName.toLowerCase()».util.beanlocator.BeanLocator;
		import co.shift.«packageName.toLowerCase()».authorization.boundary.IAuthorizationManager;
		
		public class AuthorizerController implements ProcessContributor {
			
			private static AuthorizerController controller;

			private IAuthorizationManager authManager;
		
			private static final int TAB_«authEntity.name.toUpperCase»S = 0;
			private static final int TAB_ROLES = 1;
		
			public static final String ID = "AuthorizerController";
		
			private AuthorizerController() {
				doLookup();
			}
			
			private void doLookup() {
				authManager = BeanLocator.lookup(
						IAuthorizationManager.class,
						new BeanLocator().getGlobalJNDIName()
								.withAppName("co.shift.ear")
								.withModuleName("co.shift.ejb")
								.withBeanName("AuthorizationManager")
								.withBusinessInterface(IAuthorizationManager.class)
								.asString());
			}
			
			public void showAuthForm() {
				AuthorizerForm authForm = Registry.get(AuthorizerForm.ID);
				ContentPanel panel = Registry.get(«packageName.toUpperCase»UI.CONTENT_PANEL);
				listAll«authEntity.name.toFirstUpper»s();
				panel.removeContent();
				panel.setContent(authForm);
			}
			
			public static AuthorizerController getInstance() {
				if (controller == null) {
					controller = new AuthorizerController();
					AuthorizerForm aF = new AuthorizerForm();
					Registry.register(AuthorizerForm.ID, aF);
					PopUp«authEntity.name.toFirstUpper»RoleForm pURF = new PopUp«authEntity.name.toFirstUpper»RoleForm();
					Registry.register(PopUp«authEntity.name.toFirstUpper»RoleForm.ID, pURF);
					PopUpRoleForm pRF = new PopUpRoleForm();
					Registry.register(PopUpRoleForm.ID, pRF);
					PopUpRoleServiceForm pRSF = new PopUpRoleServiceForm();
					Registry.register(PopUpRoleServiceForm.ID, pRSF);
				}
				return controller;
			}
			
			public List<ServiceTO> get«authEntity.name.toFirstUpper»Services(«DomainCodeUtilities.getType(beId)» «authEntity.name.toLowerCase») {
				return authManager.get«authEntity.name.toFirstUpper»Services(«authEntity.name.toLowerCase»);
			}
			
			public void authorize(ServiceTO service) throws Exception {
				UserTO to = Registry.get(PCSUI.USER);
				List<ServiceTO> «authEntity.name.toLowerCase»Services = authManager.get«authEntity.name.toFirstUpper»Services(to.get«DomainCodeUtilities.getID(authEntity).name.toFirstUpper»());
				if (!«authEntity.name.toLowerCase»Services.contains(service))
					throw new Exception("«authEntity.name.toFirstUpper» is not authorized to perform this task");
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
			
			private void listAll«authEntity.name.toFirstUpper»s() {
				«var con = DomainCodeUtilities.getContract(authEntity, ListAll).get(0)»
				List<«authEntity.name.toFirstUpper»TO> users = «authEntity.name.toFirstUpper»Controller.getInstance().«con.name»();
				AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
				aF.getTable«authEntity.name.toFirstUpper»s().removeAllItems();
				for («authEntity.name.toFirstUpper»TO userTO : users) {
					Object data[] = { userTO.get«beId.name.toFirstUpper»(), userTO.get«DomainCodeUtilities.getSecondAttribute(authEntity).name.toFirstUpper»() };
					aF.getTable«authEntity.name.toFirstUpper»s().addItem(data, userTO);
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
			
			public void list«authEntity.name.toFirstUpper»Roles(«DomainCodeUtilities.getType(beId)» «authEntity.name.toLowerCase») {
				List<RoleTO> roles = authManager.get«authEntity.name.toFirstUpper»Roles(«authEntity.name.toLowerCase»);
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
				((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).openSubWindow("Role", pRF);
			}
			
			public void popUpAddDetailForm() {
				AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
				TabSheet tS = aF.getTsDetails();
				int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
				switch (selectedTab) {
				case TAB_«authEntity.name.toUpperCase»S:
					«authEntity.name.toFirstUpper»TO user = («authEntity.name.toFirstUpper»TO) aF.getTable«authEntity.name.toFirstUpper»s().getValue();
					if (user != null) {
						PopUp«authEntity.name.toFirstUpper»RoleForm uRF = Registry.get(PopUp«authEntity.name.toFirstUpper»RoleForm.ID);
						List<RoleTO> roles = authManager.getAllRoles();
						populate«authEntity.name.toFirstUpper»RolesCombo(roles);
						uRF.set«authEntity.name.toFirstUpper»(user.get«beId.name.toFirstUpper»());
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).openSubWindow("Role", uRF);
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(
								«packageName.toUpperCase»UI.MSG_ERR, "Please select a «authEntity.name.toLowerCase»");
					break;
				case TAB_ROLES:
					RoleTO role = (RoleTO) aF.getTableRolesData().getValue();
					if (role != null) {
						PopUpRoleServiceForm rSF = Registry
								.get(PopUpRoleServiceForm.ID);
						List<ServiceTO> services = authManager.getAllServices();
						populateRoleServicesCombo(services);
						rSF.setRole(role.getName());
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).openSubWindow("Service", rSF);
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(
								«packageName.toUpperCase»UI.MSG_ERR, "Please select a role");
					break;
				default:
					break;
				}
			}
			
			public void createRole() {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					PopUpRoleForm pRF = Registry.get(PopUpRoleForm.ID);
					String name = pRF.getTextField_1().getValue();
					String description = pRF.getTextField_2().getValue();
		
					if (name != null && !name.equals("") && description != null
							&& !description.equals("")) {
						RoleTO role = new RoleTO();
						role.setName(name);
						role.setDescription(description);
		
						if (authManager.createRole(role)) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT,
									"Creation process executed successfully");
							listAllRoles();
							pRF.clearFormFields();
							ui.closeSubWindow();
						} else
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Creation process failed");
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI))
								.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
										"Please fill in all required fields (*)");
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
			
			public void deleteRole() {
				«packageName.toUpperCase»UI ui = («packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI);
				AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
				RoleTO role = (RoleTO) aF.getTableRolesData().getValue();
				if (role != null) {
					try {
						if (authManager.deleteRole(role)) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Role '" + role.getName() + "' removed sucessfully");
							listAllRoles();
						} else
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Role cannot be removed");
					} catch (Exception e) {
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
								"Role cannot be removed because it is associated to users and/or services");
					}
				} else
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
							"Please select a role to be removed");
			}
			
			public void removeDetailRecord() {
				«packageName.toUpperCase»UI ui = («packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI);
				AuthorizerForm aF = Registry.get(AuthorizerForm.ID);
				TabSheet tS = aF.getTsDetails();
				int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
				switch (selectedTab) {
				case TAB_«authEntity.name.toUpperCase»S:
					«authEntity.name.toFirstUpper»TO user = («authEntity.name.toFirstUpper»TO) aF.getTable«authEntity.name.toFirstUpper»s().getValue();
					if (user != null) {
						RoleTO role = (RoleTO) aF.getTableRolesDetails().getValue();
						if (role != null) {
							try {
								if (authManager.removeRoleFrom«authEntity.name.toFirstUpper»(user, role)) {
									ui.showNotification(
											«packageName.toUpperCase»UI.MSG_ERR,
											"Role '" + role.getName()
													+ "' removed from «authEntity.name.toLowerCase» "
													+ user.get«beId.name.toFirstUpper»());
									list«authEntity.name.toFirstUpper»Roles(user.get«beId.name.toFirstUpper»());
								} else
									ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
											"Role cannot be removed");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Please select a role to be removed");
					} else
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Please select a user");
					break;
				case TAB_ROLES:
					RoleTO role = (RoleTO) aF.getTableRolesData().getValue();
					if (role != null) {
						ServiceTO service = (ServiceTO) aF.getTableServicesDetails()
								.getValue();
						if (service != null) {
							try {
								if (authManager.removeServiceFromRole(role, service)) {
									ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Service '"
											+ service.getName()
											+ "' removed from role " + role.getName());
									listRoleServices(role.getName());
								} else
									ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
											"Role cannot be removed");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Please select a service to be removed");
					} else
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Please select a role");
					break;
				default:
					break;
				}
			}
			
			public boolean addRoleTo«authEntity.name.toFirstUpper»(«DomainCodeUtilities.getType(beId)» «authEntity.name.toLowerCase») {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					PopUp«authEntity.name.toFirstUpper»RoleForm uRF = Registry.get(PopUp«authEntity.name.toFirstUpper»RoleForm.ID);
					RoleTO role = (RoleTO) uRF.getComboBox_1().getValue();
					if (role != null) {
						if (authManager.addRoleTo«authEntity.name.toFirstUpper»(«authEntity.name.toLowerCase», role)) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT,
									"Role '" + role.getName() + "' added to «authEntity.name.toFirstUpper» '"
											+ «authEntity.name.toLowerCase» + "'");
							ui.closeSubWindow();
							list«authEntity.name.toFirstUpper»Roles(«authEntity.name.toLowerCase»);
							return true;
						} else {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Role cannot be added to «authEntity.name.toLowerCase»");
							return false;
						}
					} else
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Please select a role");
					return false;
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
					return false;
				}
			}
			
			public boolean addServiceToRole(String roleId) {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					PopUpRoleServiceForm rSF = Registry.get(PopUpRoleServiceForm.ID);
					ServiceTO service = (ServiceTO) rSF.getComboBox_1().getValue();
					if (service != null) {
						if (authManager.addServiceToRole(roleId, service)) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT,
									"Service '" + service.getName()
											+ "' added to Role '" + roleId + "'");
							ui.closeSubWindow();
							listRoleServices(roleId);
							return true;
						} else {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Service cannot be added to role");
							return false;
						}
					} else
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Please select a service");
					return false;
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
					return false;
				}
			}
			
			private void populate«authEntity.name.toFirstUpper»RolesCombo(List<RoleTO> roles) {
				PopUp«authEntity.name.toFirstUpper»RoleForm uRF = Registry.get(PopUp«authEntity.name.toFirstUpper»RoleForm.ID);
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
			
			public void update«authEntity.name.toFirstUpper»RolesFormFields() {
				PopUp«authEntity.name.toFirstUpper»RoleForm uRF = Registry.get(PopUp«authEntity.name.toFirstUpper»RoleForm.ID);
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
			
			public boolean hasAdminRole(«DomainCodeUtilities.getType(beId)» «authEntity.name.toLowerCase») {
				List<RoleTO> userRoles = authManager.get«authEntity.name.toFirstUpper»Roles(«authEntity.name.toLowerCase»);
				RoleTO adm = new RoleTO();
				adm.setName("admin");
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
	'''
}