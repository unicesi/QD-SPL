package co.shift.pcs.project.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class UserProject implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserProjectPK id;
	
	@ManyToOne
	@JoinColumn(name="project", insertable=false, updatable=false)
	private Project projectBean;
	
	public UserProject() {
	}
	
	public UserProjectPK getId() {
		return this.id;
	}

	public void setId(UserProjectPK id) {
		this.id = id;
	}
	
	public Project getProjectBean() {
		return this.projectBean;
	}

	public void setProjectBean(Project projectBean) {
		this.projectBean = projectBean;
	}
}
