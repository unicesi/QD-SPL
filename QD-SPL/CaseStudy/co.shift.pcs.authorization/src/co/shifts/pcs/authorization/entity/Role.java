package co.shifts.pcs.authorization.entity;

import java.io.Serializable;
import javax.persistence.*;

import co.shift.pcs.to.RoleTO;
import co.shift.pcs.to.ServiceTO;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the Roles database table.
 * 
 */
@Entity
@Table(name = "Roles")
@NamedQueries({ @NamedQuery(name = "auth.getUserRoles", query = "SELECT r FROM Role r, UserRole ur WHERE r.name = ur.id.role AND ur.id.user = :userid"),
	@NamedQuery(name = "auth.deleteRole", query = "DELETE FROM Role r WHERE r.name=:rid"),
	@NamedQuery(name = "auth.getAllRoles", query = "SELECT r FROM Role r")})
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String description;

	// bi-directional many-to-many association to Service
//	@ManyToMany(mappedBy = "roles")
	@ManyToMany
	@JoinTable(name = "Rights", joinColumns = { @JoinColumn(name = "role") }, inverseJoinColumns = { @JoinColumn(name = "service") })
	private List<Service> services;

	// bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "roleBean", orphanRemoval = true)
	private List<UserRole> userRoles;

	public Role() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Service> getServices() {
		return this.services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public RoleTO toTO() {
		RoleTO to = new RoleTO();
		to.setDescription(description);
		to.setName(name);

		List<ServiceTO> servicesTO = new ArrayList<>();
		for (Service service : services) {
			servicesTO.add(service.toTO());
		}
		to.setServices(servicesTO);
		return to;
	}
}