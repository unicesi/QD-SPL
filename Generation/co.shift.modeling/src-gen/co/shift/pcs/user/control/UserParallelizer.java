package co.shift.pcs.user.control;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import co.shift.pcs.to.UserTO;

@Stateless
public class UserParallelizer implements IUserParallelizer {

@EJB
UserAsyncWorker worker;

public List<UserTO> getAllUsers(long pCount) throws Exception {					
	List<Future<List<UserTO>>> futures = new LinkedList<>();
	List<UserTO> users = new LinkedList<>();
	int start = 0;
	int maxResults = 1;
	int iterations = (int) (pCount / maxResults);
	for (int i = 0; i < iterations; i++) {
		futures.add(worker.getAllUsers(start, maxResults));
		start += maxResults;
	}
	for (Future<List<UserTO>> future : futures) {
		try {
			users.addAll(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return users;
}
}
