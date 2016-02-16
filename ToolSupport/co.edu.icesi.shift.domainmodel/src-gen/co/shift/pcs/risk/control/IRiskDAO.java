package co.shift.pcs.risk.control;

import java.util.List;
import javax.ejb.Remote;
import co.shift.pcs.to.RiskTO;

@Remote
public interface IRiskDAO {
	
	public RiskTO getProjectPriorityRisk(int projectId);
	
	public List<RiskTO> getRiskFromProject(int projectId);
}
