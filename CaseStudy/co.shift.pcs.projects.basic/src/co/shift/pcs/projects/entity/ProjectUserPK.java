package co.shift.pcs.projects.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ProjectUser database table.
 * 
 */
@Embeddable
public class ProjectUserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int project;

	private String user;

	public ProjectUserPK() {
	}
	public int getProject() {
		return this.project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public String getUser() {
		return this.user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjectUserPK)) {
			return false;
		}
		ProjectUserPK castOther = (ProjectUserPK)other;
		return 
			(this.project == castOther.project)
			&& this.user.equals(castOther.user);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.project;
		hash = hash * prime + this.user.hashCode();
		
		return hash;
	}
}