package co.shift.pcs.projects.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import co.shift.pcs.to.ProjectTO;

@Stateless
public class ProjectAsyncWorker {

	@Resource(name = "ProjectsCaseStudy")
	private DataSource ds;

	@Asynchronous
	public Future<List<ProjectTO>> getAllProjects(int start, int maxResults) {
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
			return new AsyncResult<List<ProjectTO>>(projects);
		} catch (SQLException ex) {
			return null;
		}

	}
}
