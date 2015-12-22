package co.shift.pcs.risks.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.DatabaseException;

import co.shift.pcs.risks.entity.Risk;
import co.shift.pcs.to.RiskTO;

/**
 * Session Bean implementation class RiskManager
 */
@Stateless
public class RiskManager implements IRiskManager {

    @PersistenceContext(unitName = "co.shift.pcs.risks")
	private EntityManager em;

	@Override
	public boolean addRisk(RiskTO risk) throws Exception {
		Risk newRisk = new Risk();
		newRisk.setDescription(risk.getDescription());
		newRisk.setImpact(risk.getImpact());
		newRisk.setName(risk.getName());
		newRisk.setProbability(risk.getProbability());
		newRisk.setProject(risk.getProject());
		
		try {
			em.persist(newRisk);
			em.flush();
			return true;
		} catch (DatabaseException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean deleteRisk(RiskTO risk) throws Exception {
		Risk foundRisk = em.find(Risk.class, risk.getId());
		if(foundRisk == null)
			throw new Exception("Risk Doesn't Exists");
		else{
			TypedQuery<Risk> query = em.createNamedQuery("risks.deleteRisk",
					Risk.class);
			query.setParameter("rid", risk.getId());
			try {
				query.executeUpdate();
				return true;
			} catch (NoResultException e) {
				throw new Exception("User Cannot Be Found");
			}
		}
	}

	@Override
	public List<RiskTO> getRisksFromProject(int projectID) {
		List<RiskTO> toRisks = new ArrayList<>();
		TypedQuery<Risk> query = em.createNamedQuery("risks.getProjectRisks",
				Risk.class);
		query.setParameter("pid", projectID);
		try {
			List<Risk> foundRisks = query.getResultList();
			for (Risk risk : foundRisks) {
				toRisks.add(risk.toTO());
			}
			return toRisks;
		} catch (NoResultException e) {
			return null;
		}
	}

}
