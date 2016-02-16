package co.shift.pcs.project.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.security.PBECryptographyManager;


@Stateless
public class ProjectBasicFLR implements IProjectBasicFLR {

@Resource(name = "pcs")
private DataSource ds;

@EJB
private PBECryptographyManager cManager;


public List<ProjectTO> getAllProjects() throws Exception {					
	List<ProjectTO> projects = new ArrayList<>();
	Connection con = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	try {
		con = ds.getConnection();
		stmt = con.createStatement();
		resultSet = stmt.executeQuery("SELECT p.* FROM Project p");
		ProjectTO p;
		while (resultSet.next()) {
			p = new ProjectTO();
			int tId = resultSet.getInt(1);
			String tDescription = resultSet.getString(2);
			String tName = resultSet.getString(3);
			Date tStartDate = resultSet.getDate(4);
			char[] eDescriptionChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tDescription);
			String eDescription = new String(eDescriptionChars);
			tDescription = eDescription;
			char[] eNameChars = cManager.doFinal(
			PBECryptographyManager.DECRYPT, tName);
			String eName = new String(eNameChars);
			tName = eName;
			
			
			p.setId(tId);
			p.setDescription(tDescription);
			p.setName(tName);
			p.setStartDate(tStartDate);
			projects.add(p);
		}
		return projects;
	} catch (SQLException ex) {
		throw new Exception(ex.getMessage());
	}
}
}
