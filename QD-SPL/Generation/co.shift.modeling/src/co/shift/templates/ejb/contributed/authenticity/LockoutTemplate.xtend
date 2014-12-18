package co.shift.templates.ejb.contributed.authenticity

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities

class LockoutTemplate {
	
	def static generate (String packageName, BusinessEntity be) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;
		
		import javax.ejb.Stateless;
		import javax.persistence.EntityManager;
		import javax.persistence.PersistenceContext;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		import co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity.Attempt;
		import co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity.«be.name.toFirstUpper»;
		
		@Stateless
		public class LockoutManager {
		
			private static final int MAX_ATTEMPTS = 5;
		
			@PersistenceContext(unitName = "«packageName.toLowerCase()»")
			private EntityManager em;
		
			«var beId = DomainCodeUtilities.getID(be)»
			public «be.name.toFirstUpper»TO authenticate(«DomainCodeUtilities.getType(beId)» «beId.name.toLowerCase»ID, String password) throws Exception {
				int attempts = getAttempts(«beId.name.toLowerCase»ID);
				if (attempts < MAX_ATTEMPTS) {
					«be.name.toFirstUpper» found«be.name.toFirstUpper» = em.find(«be.name.toFirstUpper».class, «beId.name.toLowerCase»ID);
					if (found«be.name.toFirstUpper» != null) {
						if (found«be.name.toFirstUpper».getPassword().equals(password)){
							setAttempts(«beId.name.toLowerCase»ID, 0);
							return found«be.name.toFirstUpper».toTO();
						}
						else {
							attempts++;
							setAttempts(«beId.name.toLowerCase»ID, attempts);
							throw new Exception("Incorrect password. You have "
									+ (MAX_ATTEMPTS - attempts + 1) + " attempts left");
						}
					} else
						throw new Exception("«be.name.toFirstUpper» doesn't exists");
				} else
					throw new Exception(
							"Your account has been locked due too many attempts");
			}
		
			private int getAttempts(«DomainCodeUtilities.getType(beId)» «beId.name.toLowerCase»ID) {
				Attempt attempts = em.find(Attempt.class, «beId.name.toLowerCase»ID);
				if (attempts == null) {
					Attempt newAttempt = new Attempt();
					newAttempt.set«be.name.toFirstUpper»(«beId.name.toLowerCase»ID);
					newAttempt.setAttempts(0);
					em.persist(newAttempt);
					em.flush();
					return 0;
				} else
					return attempts.getAttempts();
			}
		
			private void setAttempts(«DomainCodeUtilities.getType(beId)» «beId.name.toLowerCase»ID, int newAttempts) {
				Attempt attempts = em.find(Attempt.class, «beId.name.toLowerCase»ID);
				attempts.setAttempts(newAttempts);
				em.merge(attempts);
				em.flush();
			}
		}
	'''
}