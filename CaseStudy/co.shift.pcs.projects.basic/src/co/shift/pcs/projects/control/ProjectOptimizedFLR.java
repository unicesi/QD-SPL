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
 * Session Bean implementation class ProjectOptimizedFLR
 */
@Stateless
public class ProjectOptimizedFLR implements IProjectOptimizedFLR {

	@Resource(name = "ProjectsCaseStudy")
	private DataSource ds;

	@Override
	public List<ProjectTO> getProducts(int start, int maxResults) {
		List<ProjectTO> projects = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			resultSet = stmt.executeQuery("SELECT p.* FROM Projects p");
			if (start != 0)
				resultSet.absolute(start);
			int i = 0;
			ProjectTO p;
			while (resultSet.next() && i < maxResults) {
				p = new ProjectTO();
				p.setId(resultSet.getInt(1));
				p.setName(resultSet.getString(2));
				p.setDescription(resultSet.getString(3));
				p.setStartDate(resultSet.getDate(4));
				projects.add(p);
				i++;
			}
			return projects;
		} catch (SQLException ex) {
			return null;
		}
	}
}
