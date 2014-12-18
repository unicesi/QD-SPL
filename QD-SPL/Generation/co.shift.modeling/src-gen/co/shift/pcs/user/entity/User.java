package co.shift.pcs.user.entity;

import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import javax.persistence.*;
import java.io.Serializable;

import co.shift.pcs.to.UserTO;

@Entity
@Table(name = "User")
@NamedQueries({
	@NamedQuery(name = "user.getAllUsers", query = "SELECT p FROM User p")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
@Id
private String cc;

public String getCc() {
	return this.cc;
}

public void setCc(String cc) {
	this.cc = cc;
}				
private String name;

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}				
private String cellphone;

public String getCellphone() {
	return this.cellphone;
}

public void setCellphone(String cellphone) {
	this.cellphone = cellphone;
}				
private String password;

public String getPassword() {
	return this.password;
}

public void setPassword(String password) {
	this.password = password;
}				
	
	
	
	@Override
	public boolean equals(Object obj) {
		User o = (User) obj;
		if (o != null)
		return cc.equals(o.cc);
		return false;
	}
	
	public UserTO toTO() {
		UserTO to = new UserTO();
		to.setCc(cc);
		to.setName(name);
		to.setCellphone(cellphone);
		to.setPassword(password);
		return to;
	}
}
