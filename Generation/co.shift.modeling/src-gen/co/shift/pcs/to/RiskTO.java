package co.shift.pcs.to;

import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class RiskTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
		RiskTO o = (RiskTO) obj;
		if (o != null)
		return id == o.id;
		return false;
	}
	
	@Override
	public String toString() {
		return "" + id;
	}
}
