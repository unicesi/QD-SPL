package co.shift.pcs.risks.boundary;

import java.util.List;

import javax.ejb.Remote;

import co.shift.pcs.to.RiskTO;

@Remote
public interface IRiskManager {

	public boolean addRisk(RiskTO risk) throws Exception;

	public boolean deleteRisk(RiskTO risk) throws Exception;
	
	public List<RiskTO> getRisksFromProject(int projectID);
}
