package co.shift.templates.ejb.contributed.authenticity

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities

class AttemptJPATemplate {
	
	def static generate (String packageName, BusinessEntity be) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity;
		
		import java.io.Serializable;
		import javax.persistence.*;
		
		@Entity
		@Table(name="Attempts")
		public class Attempt implements Serializable {
		«DomainCodeUtilities.addEntityName("co.shift."+packageName.toLowerCase()+"."+be.name.toLowerCase+".entity.Attempt")»
			private static final long serialVersionUID = 1L;
		«var beId = DomainCodeUtilities.getID(be)»
			@Id
			private «DomainCodeUtilities.getType(beId)» «be.name.toLowerCase»;
		
			private int attempts;
		
			public Attempt() {
			}
		
			public «DomainCodeUtilities.getType(beId)» get«be.name.toFirstUpper»() {
				return this.«be.name.toLowerCase»;
			}
		
			public void set«be.name.toFirstUpper»(«DomainCodeUtilities.getType(beId)» «be.name.toLowerCase») {
				this.user = «be.name.toLowerCase»;
			}
		
			public int getAttempts() {
				return this.attempts;
			}
		
			public void setAttempts(int attempts) {
				this.attempts = attempts;
			}
		
		}
	'''
}