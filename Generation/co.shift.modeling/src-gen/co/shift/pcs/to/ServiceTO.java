package co.shift.pcs.to;

import java.io.Serializable;

public class ServiceTO implements Serializable {
private static final long serialVersionUID = 1L;
		
private String name;
		
private String description;
		
public ServiceTO() {
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

@Override
public String toString() {
	return name;
}
		
@Override
public boolean equals(Object obj) {
	ServiceTO service = (ServiceTO) obj;
	if (service != null)
		return service.name.equals(name);
	return false;
}
		}
