package co.shift.pcs.project.control;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.shift.pcs.to.ProjectTO;

@Stateless
public class ProjectParallelizer implements IProjectParallelizer {

@EJB
ProjectAsyncWorker worker;

public List<ProjectTO> getAllProjects(long pCount) throws Exception {					
	List<Future<List<ProjectTO>>> futures = new LinkedList<>();
	List<ProjectTO> projects = new LinkedList<>();
	int start = 0;
	int maxResults = 1;
	int iterations = (int) (pCount / maxResults);
	for (int i = 0; i < iterations; i++) {
		futures.add(worker.getAllProjects(start, maxResults));
		start += maxResults;
	}
	for (Future<List<ProjectTO>> future : futures) {
		try {
			projects.addAll(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return projects;
}
}
