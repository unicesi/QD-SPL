package co.shift.pcs.project.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ProjectUserPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer projectId;
	
	private String userCc;
	
	public ProjectUserPK() {
	}
	
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public String getUserCc() {
		return this.userCc;
	}

	public void setUserCc(String userCc) {
		this.userCc = userCc;
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
			this.projectId == castOther.projectId
			&& 
			this.userCc.equals(castOther.userCc)
			;
	}
	
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.projectId;
		hash = hash * prime + this.userCc.hashCode();
		
		return hash;
	}
}
