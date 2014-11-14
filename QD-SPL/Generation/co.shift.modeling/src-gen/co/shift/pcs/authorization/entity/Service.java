package co.shift.pcs.authorization.entity;

import java.io.Serializable;
import javax.persistence.*;

import co.shift.pcs.to.ServiceTO;

import java.util.List;

@Entity
@Table(name = "Services")
@NamedQueries({ @NamedQuery(name = "auth.getAllServices", query = "SELECT s FROM Service s") })
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String description;

	// bi-directional many-to-many association to Role
//	@ManyToMany
//	@JoinTable(name = "Rights", joinColumns = { @JoinColumn(name = "service") }, inverseJoinColumns = { @JoinColumn(name = "role") })
	@ManyToMany(mappedBy = "services")
	private List<Role> roles;

	public Service() {
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

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		Service service = (Service) obj;
		if (service != null)
			return service.name.equals(name);
		return false;
	}

	public ServiceTO toTO() {
		ServiceTO to = new ServiceTO();
		to.setDescription(description);
		to.setName(name);
		return to;
	}
}
