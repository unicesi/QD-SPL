package co.shift.pcs.project.control;

import java.util.List;
import javax.ejb.Remote;

import co.shift.pcs.to.ProjectTO;

@Remote
public interface IProjectParallelizer {

public List<ProjectTO> getAllProjects(long pCount) throws Exception;
}
