package co.shift.pcs.projects.control;

import java.util.List;

import javax.ejb.Remote;

import co.shift.pcs.to.ProjectTO;

@Remote
public interface IProjectOptimizedFLR {

	public List<ProjectTO> getProducts(int start, int maxResults);
}
