package co.shift.pcs.project.entity;

import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import javax.persistence.*;
import java.io.Serializable;

import co.shift.pcs.to.ProjectTO;

@Entity
@Table(name = "Project")
@NamedQueries({
	@NamedQuery(name = "project.getAllProjects", query = "SELECT p FROM Project p"),
	@NamedQuery(name = "project.deleteProject", query = "DELETE FROM Project p WHERE p.id=:id"),
})
public class Project implements Serializable {
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
private String name;

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}				
@Temporal(TemporalType.DATE)
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
	private Integer priorityrisk;
	
	public Integer getPriorityRisk() {
		return this.priorityrisk;
	}
	
	public void setPriorityRisk(Integer priorityrisk) {
		this.priorityrisk = priorityrisk;
	}
	
	@OneToMany(mappedBy = "projectBean", orphanRemoval = true)
	private List<ProjectUser> projectUser;
	
	public List<ProjectUser> getProjectUser() {
		return this.projectUser;
	}
	
	public void setProjectUser(List<ProjectUser> projectUser) {
		this.projectUser = projectUser;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Project o = (Project) obj;
		if (o != null)
		return id == o.id;
		return false;
	}
	
	public ProjectTO toTO() {
		ProjectTO to = new ProjectTO();
		to.setId(id);
		to.setDescription(description);
		to.setName(name);
		to.setStartDate(startdate);
		return to;
	}
}
