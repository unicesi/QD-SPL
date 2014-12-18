package co.shift.pcs.user.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.shift.pcs.to.UserTO;
import co.shift.pcs.user.entity.Attempt;
import co.shift.pcs.user.entity.User;

@Stateless
public class LockoutManager {

	private static final int MAX_ATTEMPTS = 5;

	@PersistenceContext(unitName = "pcs")
	private EntityManager em;

	public UserTO authenticate(String ccID, String password) throws Exception {
		int attempts = getAttempts(ccID);
		if (attempts < MAX_ATTEMPTS) {
			User foundUser = em.find(User.class, ccID);
			if (foundUser != null) {
				if (foundUser.getPassword().equals(password)){
					setAttempts(ccID, 0);
					return foundUser.toTO();
				}
				else {
					attempts++;
					setAttempts(ccID, attempts);
					throw new Exception("Incorrect password. You have "
							+ (MAX_ATTEMPTS - attempts + 1) + " attempts left");
				}
			} else
				throw new Exception("User doesn't exists");
		} else
			throw new Exception(
					"Your account has been locked due too many attempts");
	}

	private int getAttempts(String ccID) {
		Attempt attempts = em.find(Attempt.class, ccID);
		if (attempts == null) {
			Attempt newAttempt = new Attempt();
			newAttempt.setUser(ccID);
			newAttempt.setAttempts(0);
			em.persist(newAttempt);
			em.flush();
			return 0;
		} else
			return attempts.getAttempts();
	}

	private void setAttempts(String ccID, int newAttempts) {
		Attempt attempts = em.find(Attempt.class, ccID);
		attempts.setAttempts(newAttempts);
		em.merge(attempts);
		em.flush();
	}
}
