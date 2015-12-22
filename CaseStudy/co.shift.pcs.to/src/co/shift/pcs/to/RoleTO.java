package co.shift.pcs.to;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the Roles database table.
 * 
 */
public class RoleTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	//bi-directional many-to-many association to Service
	private List<ServiceTO> services;

	public RoleTO() {
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

	public List<ServiceTO> getServices() {
		return this.services;
	}

	public void setServices(List<ServiceTO> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		RoleTO role = (RoleTO) obj;
		if (role != null)
			return role.name.equals(name);
		return false;
	}
}