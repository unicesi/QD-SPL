package co.shift.pcs.to;

import java.io.Serializable;
import java.util.Date;


/**
 * The DTO for the Projects database table.
 * 
 */
public class ProjectTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String description;
	
	private String manager;

	private String name;

	private Date startDate;

	public ProjectTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.description = manager;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		ProjectTO p = (ProjectTO) obj;
		if (p != null)
			return id == p.id;
		return false;
	}

}