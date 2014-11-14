package co.shift.pcs.project.entity;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class UserProjectPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String cc;
	
	public UserProjectPK() {
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCc() {
		return this.cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserProjectPK)) {
			return false;
		}
		UserProjectPK castOther = (UserProjectPK)other;
		return 
			this.id == castOther.id
			&& 
			this.cc.equals(castOther.cc)
			;
	}
	
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.cc.hashCode();
		
		return hash;
	}
}
