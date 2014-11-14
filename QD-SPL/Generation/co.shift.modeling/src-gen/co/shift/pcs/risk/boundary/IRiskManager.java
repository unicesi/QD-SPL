package co.shift.pcs.risk.boundary;

import java.util.List;
import javax.ejb.Remote;

import co.shift.pcs.to.RiskTO;

@Remote
public interface IRiskManager {
	
	public boolean addRisk(RiskTO risk) throws Exception;
	
	public boolean removeRisk(RiskTO risk) throws Exception;
	
	public List<RiskTO> getRiskFromProject(int projectId);
	
}
