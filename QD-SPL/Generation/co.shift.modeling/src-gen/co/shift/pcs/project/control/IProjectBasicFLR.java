package co.shift.pcs.project.control;

import java.util.List;
import javax.ejb.Remote;

import co.shift.pcs.to.ProjectTO;

@Remote
public interface IProjectBasicFLR {

public List<ProjectTO> getAllProjects() throws Exception;
}
