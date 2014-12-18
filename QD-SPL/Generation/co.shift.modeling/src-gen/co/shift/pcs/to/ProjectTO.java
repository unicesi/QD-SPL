package co.shift.pcs.to;

import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class ProjectTO implements Serializable {
	
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

	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}				

	private Date startdate;
	
	public Date getStartDate() {
		return this.startdate;
	}
	
	public void setStartDate(Date startdate) {
		this.startdate = startdate;
	}				
	
	private String manager;
	
	public String getManager() {
		return this.manager;
	}
	
	public void setManager(String manager) {
		this.manager = manager;
	}
	private int priorityrisk;
	
	public int getPriorityRisk() {
		return this.priorityrisk;
	}
	
	public void setPriorityRisk(int priorityrisk) {
		this.priorityrisk = priorityrisk;
	}
	
	private String user;
	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public boolean equals(Object obj) {
		ProjectTO o = (ProjectTO) obj;
		if (o != null)
		return id == o.id;
		return false;
	}
	
	@Override
	public String toString() {
		return "" + id;
	}
}
