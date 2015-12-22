package co.shift.pcs.basic.ext.projects;

import java.util.List;

import co.shift.pcs.to.ProjectTO;

public class ProjectListUpdater extends Thread{

	private ProjectForm pF;
	private List<ProjectTO> projects;
	
	public ProjectListUpdater(ProjectForm pF, List<ProjectTO> projects){
		this.pF = pF;
		this.projects = projects;
	}
	
	@Override
	public void run() {
		if (projects.size() > 0) {
			for (ProjectTO projectTO : projects) {
				Object data[] = { projectTO.getId(), projectTO.getName() };
				pF.getTable_1().addItem(data, projectTO);
			}
		}
	}
}
