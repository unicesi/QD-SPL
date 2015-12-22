package co.shifts.pcs.authorization.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserRole database table.
 * 
 */
@Entity
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRolePK id;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role", insertable=false, updatable=false)
	private Role roleBean;

	public UserRole() {
	}

	public UserRolePK getId() {
		return this.id;
	}

	public void setId(UserRolePK id) {
		this.id = id;
	}

	public Role getRoleBean() {
		return this.roleBean;
	}

	public void setRoleBean(Role roleBean) {
		this.roleBean = roleBean;
	}

}