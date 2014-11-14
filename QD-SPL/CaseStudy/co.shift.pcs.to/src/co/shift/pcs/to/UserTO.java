package co.shift.pcs.to;

import java.io.Serializable;

/**
 * The persistent class for the Users database table.
 * 
 */
public class UserTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idNumber;

	private String cellphone;

	private String name;
	
	private String password;

	public UserTO() {
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return idNumber;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		UserTO to = (UserTO) obj;
		if (to != null)
			return idNumber.equals(to.idNumber);
		return false;
	}
}