package co.shift.pcs.web.ext.risk;

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
import co.shift.pcs.web.ext.project.ProjectController;
import co.shift.pcs.web.AbstractController;
import co.shift.pcs.web.PCSUI;
import co.shift.pcs.web.Registry;
import co.shift.pcs.web.UIContributor;
import co.shift.pcs.web.ProcessContributor;
import co.shift.pcs.web.client.ContentPanel;
import co.shift.pcs.web.client.MenuPanel;
import co.shift.pcs.risk.boundary.IRiskManager;
import co.shift.pcs.util.beanlocator.BeanLocator;
import co.shift.pcs.to.RiskTO;


public class RiskController extends AbstractController {
	
	private static RiskController controller;
	
	private IRiskManager riskManager;
	
	private RiskController() {
		doLookup();
	}
	
	private void doLookup() {
		riskManager = BeanLocator.lookup(
				IRiskManager.class,
				new BeanLocator().getGlobalJNDIName()
						.withAppName("co.shift.ear")
						.withModuleName("co.shift.ejb")
						.withBeanName("RiskManager")
						.withBusinessInterface(IRiskManager.class)
						.asString());
	}
	
	
	public static RiskController getInstance() {
		if (controller == null) {
			controller = new RiskController();
			PopUpRiskForm uF = new PopUpRiskForm();
			Registry.register(PopUpRiskForm.ID, uF);
			RiskPriorityRiskForm uMF = new RiskPriorityRiskForm();
			Registry.register(RiskPriorityRiskForm.ID, uMF);
		}
		return controller;
	}
	
	public List<RiskTO> getRiskFromProject(int projectId) {
		return riskManager.getRiskFromProject(projectId);
	}
	
	
	public RiskTO getProjectPriorityRisk(int projectId) {
		return riskManager.getProjectPriorityRisk(projectId);
	}
	
	
	
	
	
	
	
	public boolean deleteRisk(RiskTO risk) throws Exception {
			try {
				return riskManager.removeRisk(risk);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void addRiskToProject(int project) {
		PopUpRiskForm pF = Registry.get(PopUpRiskForm.ID);
		try{		
			// String obtained from ClassName - MethodName
			extendProcess(AuthorizerController.ID, "Project - AddRisk");
			
			int id = Integer.parseInt(pF.getTextField_1().getValue());
			String description = pF.getTextField_2().getValue();
			double impact = Double.parseDouble(pF.getTextField_3().getValue());
			String name = pF.getTextField_4().getValue();
			double probability = Double.parseDouble(pF.getTextField_5().getValue());
			
			if (
				description != null && !description.equals("")
				&&
								name != null && !name.equals("")
				) {
					RiskTO risk = new RiskTO();
					risk.setId(id);						
					risk.setDescription(description);						
					risk.setImpact(impact);						
					risk.setName(name);						
					risk.setProbability(probability);						
					risk.setProject(project);
					if (addRiskToProject(risk))
						pF.clearFormFields();
				} else
					((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
						"Please fill in all required fields (*)");
				} catch (Exception e) {
					((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
						"Please fill in all required fields (*)");
				}
			}
			
			private boolean addRiskToProject(RiskTO risk) {
				PCSUI ui = Registry.get(PCSUI.UI);
				try {
					if (riskManager.addRisk(risk)) {
						ui.showNotification(PCSUI.MSG_NOT, "Risk added to Project "
								+ risk.getProject());
						ui.closeSubWindow();
						ProjectController.getInstance().listProjectRisk(
								risk.getProject());
						return true;
					} else {
						ui.showNotification(PCSUI.MSG_ERR,
								"Risk cannot be added to Project");
						return false;
					}
				} catch (Exception e) {
					((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
							e.getMessage());
					return false;
				}
			}
			
	
	public void updatePriorityRiskFormFields() {
		RiskPriorityRiskForm uMF = Registry.get(RiskPriorityRiskForm.ID);
		ComboBox combo = uMF.getComboBox_1();
		RiskTO risk = (RiskTO) combo.getValue();
		if (risk != null) {
			uMF.getTextField_1().setValue(""+risk.getId());
			uMF.getTextField_2().setValue(risk.getDescription());
			uMF.getTextField_3().setValue(""+risk.getImpact());
			uMF.getTextField_4().setValue(risk.getName());
			uMF.getTextField_5().setValue(""+risk.getProbability());
		}
	}

	public void setProjectPriorityRisk(int project) {
		ProjectController.getInstance().setProjectPriorityRisk(project);
	}

	public void populateRiskPriorityRiskCombo(List<RiskTO> list, RiskTO priorityrisk) {
		RiskPriorityRiskForm uMF = Registry.get(RiskPriorityRiskForm.ID);
		ComboBox combo = uMF.getComboBox_1();
		combo.removeAllItems();
		RiskTO uPriorityRisk = null;
		for (RiskTO to : list) {
			if (to.equals(priorityrisk))
				uPriorityRisk = to;
			combo.addItem(to);
		}
		
		if (uMF.getProject() > 0) {
			if (uPriorityRisk != null)
				combo.setValue(uPriorityRisk);
		}
	}
	
}
