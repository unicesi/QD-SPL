package co.shift.pcs.risk.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.eclipse.persistence.exceptions.DatabaseException;

import co.shift.pcs.to.RiskTO;


import co.shift.pcs.risk.control.PBECryptographyManager;

			

import co.shift.pcs.risk.entity.Risk;

@Stateless
public class RiskManager implements IRiskManager {
	
	@PersistenceContext(unitName = "co.shift.pcs.risk")
	private EntityManager em;
	
	
	
	@EJB
	private PBECryptographyManager cManager;
	
	
	public boolean addRisk(RiskTO risk) throws Exception {
	char[] eDescriptionChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, risk.getDescription());
	String eDescription = new String(eDescriptionChars);
	risk.setDescription(eDescription);
	char[] eNameChars = cManager.doFinal(
	PBECryptographyManager.ENCRYPT, risk.getName());
	String eName = new String(eNameChars);
	risk.setName(eName);
	
	
		Risk foundRisk = em.find(Risk.class, risk.getId());
		if (foundRisk != null)
			throw new Exception("Risk Alredy Exists");
		else {
			Risk newRisk = new Risk();
			newRisk.setId(risk.getId());
			newRisk.setDescription(risk.getDescription());
			newRisk.setImpact(risk.getImpact());
			newRisk.setName(risk.getName());
			newRisk.setProbability(risk.getProbability());
		
			try {
				em.persist(newRisk);
				em.flush();
				return true;
			} catch (DatabaseException e) {
				return false;
			}
		}
	}
	public boolean removeRisk(RiskTO risk) throws Exception {
		
		
		Risk foundRisk = em.find(Risk.class, risk.getId());
		if (foundRisk == null)
			throw new Exception("Risk Doesn't Exists");
		else {
			TypedQuery<Risk> query = em.createNamedQuery(
				"risk.deleteRisk", Risk.class);
			query.setParameter("id", risk.getId());
			try {
				query.executeUpdate();
				return true;
			} catch (NoResultException e) {
				throw new Exception("Risk Cannot Be Found");
			} catch (DatabaseException e) {
				throw new Exception("Risk With Associated Data Cannot Be Deleted");
			}
		}
	}
	public List<RiskTO> getRiskFromProject(int projectId) {
	List<RiskTO> toRisks = new ArrayList<>();
	TypedQuery<Risk> query = em.createNamedQuery("risk.getProjectRisk",
			Risk.class);
	query.setParameter("id", projectId);
	try {
		List<Risk> foundRisks = query.getResultList();
		for (Risk risk : foundRisks) {
			char[] eDescriptionChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, risk.getDescription());
			String eDescription = new String(eDescriptionChars);
			risk.setDescription(eDescription);
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, risk.getName());
			String eName = new String(eNameChars);
			risk.setName(eName);
			
			
			toRisks.add(risk.toTO());
		}
		return toRisks;
	} catch (NoResultException e) {
		return null;
	}
	}
}
