package co.shift.pcs.projects.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import co.shift.pcs.to.ProjectTO;

/**
 * Session Bean implementation class ProjectBasicFLR
 */
@Stateless
public class ProjectBasicFLR implements IProjectBasicFLR {

	@Resource(name = "ProjectsCaseStudy")
	private DataSource ds;

	public List<ProjectTO> getAllProjects() throws Exception {
		List<ProjectTO> projects = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			resultSet = stmt.executeQuery("SELECT p.* FROM Projects p");
			ProjectTO p;
			while (resultSet.next()) {
				p = new ProjectTO();
				p.setId(resultSet.getInt(1));
				p.setName(resultSet.getString(2));
				p.setDescription(resultSet.getString(3));
				p.setStartDate(resultSet.getDate(4));
				projects.add(p);
			}
			return projects;
		} catch (SQLException ex) {
			throw new Exception(ex.getMessage());
		}
	}
}
