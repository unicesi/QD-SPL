package co.shift.pcs.users.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Attempts database table.
 * 
 */
@Entity
@Table(name="Attempts")
public class Attempt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String user;

	private int attempts;

	public Attempt() {
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getAttempts() {
		return this.attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

}