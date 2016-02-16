package co.shift.pcs.project.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class ProjectUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectUserPK id;
	
	@ManyToOne
	@JoinColumn(name="projectId", insertable=false, updatable=false)
	private Project projectBean;
	
	public ProjectUser() {
	}
	
	public ProjectUserPK getId() {
		return this.id;
	}

	public void setId(ProjectUserPK id) {
		this.id = id;
	}
	
	public Project getProjectBean() {
		return this.projectBean;
	}

	public void setProjectBean(Project projectBean) {
		this.projectBean = projectBean;
	}
}
