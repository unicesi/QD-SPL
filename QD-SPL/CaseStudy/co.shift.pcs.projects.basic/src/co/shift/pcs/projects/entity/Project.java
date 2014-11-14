package co.shift.pcs.projects.entity;

import java.io.Serializable;
import javax.persistence.*;

import co.shift.pcs.to.ProjectTO;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Projects database table.
 * 
 */
@Entity
@Table(name = "Projects")
@NamedQueries({
		@NamedQuery(name = "projects.deleteProject", query = "DELETE FROM Project p WHERE p.id=:pid"),
		@NamedQuery(name = "projects.getAllProjects", query = "SELECT p FROM Project p") })
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String description;

	private String manager;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	// bi-directional many-to-one association to ProjectUser
	@OneToMany(mappedBy = "projectBean", orphanRemoval = true)
	private List<ProjectUser> projectUsers;

	public Project() {
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

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<ProjectUser> getProjectUsers() {
		return this.projectUsers;
	}

	public void setProjectUsers(List<ProjectUser> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public ProjectTO toTO() {
		ProjectTO to = new ProjectTO();
		to.setDescription(description);
		to.setId(id);
		to.setName(name);
		to.setStartDate(startDate);
		return to;
	}

	@Override
	public boolean equals(Object obj) {
		Project p = (Project) obj;
		if (p != null)
			return id == p.id;
		return false;
	}
}