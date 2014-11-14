package co.shift.pcs.to;

import java.io.Serializable;
import java.math.BigDecimal;

public class RiskTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String description;

	private BigDecimal impact;

	private String name;

	private BigDecimal probability;

	private int project;

	public RiskTO() {
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

}
