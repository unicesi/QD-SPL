package co.shift.pcs.users.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.shift.pcs.to.UserTO;
import co.shift.pcs.users.entity.Attempt;
import co.shift.pcs.users.entity.User;

@Stateless
public class LockoutManager {

	private static final int MAX_ATTEMPTS = 5;

	@PersistenceContext(unitName = "co.shift.pcs.users")
	private EntityManager em;

	public UserTO authenticate(String userID, String password) throws Exception {
		int attempts = getAttempts(userID);
		if (attempts < MAX_ATTEMPTS) {
			User foundUser = em.find(User.class, userID);
			if (foundUser != null) {
				if (foundUser.getPassword().equals(password)){
					setAttempts(userID, 0);
					return foundUser.toTO();
				}
				else {
					attempts++;
					setAttempts(userID, attempts);
					throw new Exception("Incorrect password. You have "
							+ (MAX_ATTEMPTS - attempts + 1) + " attempts left");
				}
			} else
				throw new Exception("User doesn't exists");
		} else
			throw new Exception(
					"Your account has been locked due too many attempts");
	}

	private int getAttempts(String userId) {
		Attempt attempts = em.find(Attempt.class, userId);
		if (attempts == null) {
			Attempt newAttempt = new Attempt();
			newAttempt.setUser(userId);
			newAttempt.setAttempts(0);
			em.persist(newAttempt);
			em.flush();
			return 0;
		} else
			return attempts.getAttempts();
	}

	private void setAttempts(String userId, int newAttempts) {
		Attempt attempts = em.find(Attempt.class, userId);
		attempts.setAttempts(newAttempts);
		em.merge(attempts);
		em.flush();
	}
}
