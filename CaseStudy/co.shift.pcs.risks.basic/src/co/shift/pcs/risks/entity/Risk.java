package co.shift.pcs.risks.entity;

import java.io.Serializable;
import javax.persistence.*;

import co.shift.pcs.to.RiskTO;

import java.math.BigDecimal;

/**
 * The persistent class for the Risks database table.
 * 
 */
@Entity
@Table(name = "Risks")
@NamedQueries({
		@NamedQuery(name = "risks.deleteRisk", query = "DELETE FROM Risk r WHERE r.id=:rid"),
		@NamedQuery(name = "risks.getProjectRisks", query = "SELECT r FROM Risk r WHERE r.project=:pid") })
public class Risk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String description;

	private BigDecimal impact;

	private String name;

	private BigDecimal probability;

	private int project;

	public Risk() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getImpact() {
		return this.impact;
	}

	public void setImpact(BigDecimal impact) {
		this.impact = impact;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getProbability() {
		return this.probability;
	}

	public void setProbability(BigDecimal probability) {
		this.probability = probability;
	}

	public int getProject() {
		return this.project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public RiskTO toTO() {
		RiskTO to = new RiskTO();
		to.setDescription(description);
		to.setId(id);
		to.setImpact(impact);
		to.setName(name);
		to.setProbability(probability);
		to.setProject(project);
		return to;
	}
}