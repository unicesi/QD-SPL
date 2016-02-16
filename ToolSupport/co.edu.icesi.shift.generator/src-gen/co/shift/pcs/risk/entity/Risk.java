package co.shift.pcs.risk.entity;

import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import javax.persistence.*;
import java.io.Serializable;

import co.shift.pcs.to.RiskTO;

@Entity
@Table(name = "Risk")
@NamedQueries({
	@NamedQuery(name = "risk.deleteRisk", query = "DELETE FROM Risk p WHERE p.id=:id")
	,
	@NamedQuery(name = "risk.getProjectRisk", query = "SELECT r FROM Risk r WHERE r.project=:id")
})
public class Risk implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
private int id;

public int getId() {
	return this.id;
}

public void setId(int id) {
	this.id = id;
}				
private String description;

public String getDescription() {
	return this.description;
}

public void setDescription(String description) {
	this.description = description;
}				
private double impact;

public double getImpact() {
	return this.impact;
}

public void setImpact(double impact) {
	this.impact = impact;
}				
private String name;

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}				
private double probability;

public double getProbability() {
	return this.probability;
}

public void setProbability(double probability) {
	this.probability = probability;
}				
	
	
	private int project;
	
	public int getProject() {
		return this.project;
	}
	
	public void setProject(int project) {
		this.project = project;
	}
	
	@Override
	public boolean equals(Object obj) {
		Risk o = (Risk) obj;
		if (o != null)
		return id == o.id;
		return false;
	}
	
	public RiskTO toTO() {
		RiskTO to = new RiskTO();
		to.setId(id);
		to.setDescription(description);
		to.setImpact(impact);
		to.setName(name);
		to.setProbability(probability);
		to.setProject(project);
		return to;
	}
}
