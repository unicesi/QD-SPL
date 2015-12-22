package co.shift.pcs.basic.ext.risks;

import java.math.BigDecimal;
import java.util.List;

import co.shift.pcs.basic.ext.projects.ProjectFormController;
import co.shift.pcs.basic.web.PCSUI;
import co.shift.pcs.basic.web.Registry;
import co.shift.pcs.risks.boundary.IRiskManager;
import co.shift.pcs.to.RiskTO;
import co.shift.pcs.util.beanlocator.BeanLocator;

public class RiskFormController {

	private static RiskFormController controller;

	private IRiskManager riskManager;

	private RiskFormController() {
		doLookup();
	}

	private void doLookup() {
		riskManager = BeanLocator.lookup(
				IRiskManager.class,
				new BeanLocator().getGlobalJNDIName()
						.withAppName("co.shift.pcs.basic.ear")
						.withModuleName("co.shift.pcs.risks.basic")
						.withBeanName("RiskManager")
						.withBusinessInterface(IRiskManager.class).asString());
	}

	public static RiskFormController getInstance() {
		if (controller == null) {
			controller = new RiskFormController();
			PopUpRiskForm rF = new PopUpRiskForm();
			Registry.register(PopUpRiskForm.ID, rF);
		}
		return controller;
	}

	public List<RiskTO> getRisksFromProject(int projectID) {
		return riskManager.getRisksFromProject(projectID);
	}

	public boolean deleteRisk(RiskTO risk) throws Exception {
		try {
			return riskManager.deleteRisk(risk);
		} catch (Exception e) {
			throw e;
		}
	}

	// RiskForm Events
	private boolean addRiskToProject(RiskTO risk) {
		PCSUI ui = Registry.get(PCSUI.UI);
		try {
			if (riskManager.addRisk(risk)) {
				ui.showNotification(PCSUI.MSG_NOT, "Risk added to Project "
						+ risk.getProject());
				ui.closeSubWindow();
				ProjectFormController.getInstance().listProjectRisks(
						risk.getProject());
				return true;
			} else {
				ui.showNotification(PCSUI.MSG_ERR,
						"Risk cannot be added to project");
				return false;
			}
		} catch (Exception e) {
			((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
					e.getMessage());
			return false;
		}
	}

	public void addRiskToProject(int projectID) {
		PopUpRiskForm rF = Registry.get(PopUpRiskForm.ID);
		String name = rF.getTextField_2().getValue();
		String description = rF.getTextArea_1().getValue();
		String impactS = rF.getTextField_3().getValue();
		String probabilityS = rF.getTextField_4().getValue();

		if (name != null && !name.equals("") && description != null
				&& !description.equals("") && impactS != null
				&& !impactS.equals("") && probabilityS != null
				&& !probabilityS.equals("")) {
			BigDecimal divisor = new BigDecimal(100);
			BigDecimal impact = new BigDecimal(impactS);
			impact = impact.divide(divisor);
			BigDecimal probability = new BigDecimal(probabilityS);
			probability = probability.divide(divisor);
			RiskTO risk = new RiskTO();
			risk.setName(name);
			risk.setDescription(description);
			risk.setImpact(impact);
			risk.setProbability(probability);
			risk.setProject(projectID);
			if (addRiskToProject(risk))
				rF.clearFormFields();
		} else
			((PCSUI) Registry.get(PCSUI.UI)).showNotification(PCSUI.MSG_ERR,
					"Please fill in all required fields (*)");
	}
}
