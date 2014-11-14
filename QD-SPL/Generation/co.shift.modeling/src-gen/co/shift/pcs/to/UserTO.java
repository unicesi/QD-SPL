package co.shift.pcs.to;

import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

public class UserTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
		UserTO o = (UserTO) obj;
		if (o != null)
		return cc.equals(o.cc);
		return false;
	}
	
	@Override
	public String toString() {
		return cc;
	}
}
