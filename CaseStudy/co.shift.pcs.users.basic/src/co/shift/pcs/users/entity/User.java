package co.shift.pcs.users.entity;

import java.io.Serializable;
import javax.persistence.*;

import co.shift.pcs.to.UserTO;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQueries({
	@NamedQuery(name = "users.deleteUser", query = "DELETE FROM User u WHERE u.idNumber=:uid"),
	@NamedQuery(name = "users.getAllUsers", query = "SELECT u FROM User u")})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idNumber;

	private String cellphone;

	private String name;
	
	private String password;

	public User() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTO toTO(){
		UserTO to = new UserTO();
		to.setCellphone(cellphone);
		to.setIdNumber(idNumber);
		to.setName(name);
		to.setPassword(password);
		return to;
	}
}