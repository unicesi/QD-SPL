package co.shift.pcs.user.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class ProjectUserPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String cc;
	
	private int id;
	
	public ProjectUserPK() {
	}
	
	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
			this.cc.equals(castOther.cc)
			&& 
			this.id == castOther.id
			;
	}
	
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cc.hashCode();
		hash = hash * prime + this.id;
		
		return hash;
	}
}
