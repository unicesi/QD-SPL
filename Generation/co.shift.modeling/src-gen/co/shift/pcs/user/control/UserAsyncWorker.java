package co.shift.pcs.user.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import co.shift.pcs.to.UserTO;
import co.shift.pcs.security.PBECryptographyManager;


@Stateless
public class UserAsyncWorker {

@Resource(name = "pcs")
private DataSource ds;

@EJB
private PBECryptographyManager cManager;


@Asynchronous
public Future<List<UserTO>> getAllUsers(int start, int maxResults) throws Exception {					
	List<UserTO> users = new ArrayList<>();
	Connection con = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	try {
		con = ds.getConnection();
		stmt = con.createStatement();
		resultSet = stmt.executeQuery("SELECT p.* FROM User p");
		if (start != 0)
			resultSet.absolute(start);
		int i = 0;
		UserTO p;
		while (resultSet.next()  && i < maxResults) {
			p = new UserTO();
			String tCc = resultSet.getString(1);
			String tName = resultSet.getString(2);
			String tCellphone = resultSet.getString(3);
			String tPassword = resultSet.getString(4);
			char[] eCcChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tCc);
			String eCc = new String(eCcChars);
			tCc = eCc;
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			char[] eCellphoneChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tCellphone);
			String eCellphone = new String(eCellphoneChars);
			tCellphone = eCellphone;
			char[] ePasswordChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tPassword);
			String ePassword = new String(ePasswordChars);
			tPassword = ePassword;
			
			
			p.setCc(tCc);
			p.setName(tName);
			p.setCellphone(tCellphone);
			p.setPassword(tPassword);
			users.add(p);
			i++;
		}
		return new AsyncResult<List<UserTO>>(users);
	} catch (SQLException ex) {
		return null;
	}
}
}
