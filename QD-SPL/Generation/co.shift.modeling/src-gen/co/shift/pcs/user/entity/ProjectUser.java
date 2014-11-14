package co.shift.pcs.user.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class ProjectUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectUserPK id;
	
	@ManyToOne
	@JoinColumn(name="user", insertable=false, updatable=false)
	private User userBean;
	
	public ProjectUser() {
	}
	
	public ProjectUserPK getId() {
		return this.id;
	}

	public void setId(ProjectUserPK id) {
		this.id = id;
	}
	
	public User getUserBean() {
		return this.userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
}
