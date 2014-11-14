package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import java.util.List
import domainmetamodel.Association
import co.shift.generators.domain.DomainCodeGenerator

class DAOImplTemplate {
	
	def static generate (BusinessEntity be, String packageName, List<Association> associations) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;
		
		import java.util.ArrayList;
		import java.util.Date;
		import java.util.List;
		
		import javax.ejb.EJB;
		import javax.ejb.Stateless;
		import javax.persistence.EntityManager;
		import javax.persistence.NoResultException;
		import javax.persistence.PersistenceContext;
		import javax.persistence.Query;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_IMPORT, packageName, be.name)»
		
		@Stateless
		public class «be.name.toFirstUpper»DAO implements I«be.name.toFirstUpper»DAO {
			
			@PersistenceContext(unitName = "co.shift.pcs.«be.name.toLowerCase»")
			private EntityManager em;
			
			«val attribute2 = DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_ATTRIBUTE)»
			«IF (attribute2 != null && !attribute2.equals(""))»
				«attribute2»
			«ENDIF»
		
			«FOR association : DomainCodeGenerator.getDetailSimpleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public «be.name»TO get«container.name.toFirstUpper»«association.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
				toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»){
					Query query = em
					.createNativeQuery("SELECT u.* FROM «be.name.toFirstUpper» u, «container.name.toFirstUpper» p WHERE p.«association.name.toLowerCase» = u.«DomainCodeGenerator.getID(be).name.toLowerCase» AND p.«DomainCodeGenerator.getID(container).name.toLowerCase» = "
							+ «container.name.toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
					try {
						Object[] «association.name.toLowerCase» = (Object[]) query.getSingleResult();
						«be.name.toFirstUpper»TO u = new «be.name.toFirstUpper»TO();
						«var i=0»
						«FOR attribute : be.attributes»
							«DomainCodeGenerator.getType(attribute)» t«attribute.name.toFirstUpper» = («DomainCodeGenerator.getType(attribute)») «association.name.toLowerCase»[«i»];
							«var c = i++»
						«ENDFOR»
						«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 3)»
						«FOR attribute : be.attributes»
						u.set«attribute.name.toFirstUpper»(t«attribute.name.toFirstUpper»);
						«ENDFOR»
						return u;
					} catch (NoResultException e) {
						return null;
					}
				}
			«ENDFOR»
			
			«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public List<«be.name.toFirstUpper»TO> get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
				toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»){
					List<«be.name.toFirstUpper»TO> «be.name.toLowerCase»s = new ArrayList<>();
					Query query = em
							.createNativeQuery("SELECT u.* FROM «be.name.toFirstUpper» u, «container.name.toFirstUpper»«be.name.toFirstUpper» pu WHERE u.«DomainCodeGenerator.getID(be).name.toLowerCase» = pu.«be.name.toLowerCase» AND pu.«container.name.toLowerCase» = "
									+ «container.name.toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
					List<Object[]> found«be.name.toFirstUpper»s = query.getResultList();
					«be.name.toFirstUpper»TO u = null;
					for (Object[] «be.name.toLowerCase» : found«be.name.toFirstUpper»s) {
						u = new «be.name.toFirstUpper»TO();
						«var i=0»
						«FOR attribute : be.attributes»
							«DomainCodeGenerator.getType(attribute)» t«attribute.name.toFirstUpper» = («DomainCodeGenerator.getType(attribute)») «be.name.toLowerCase»[«i»];
							«var c = i++»
						«ENDFOR»
						«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 3)»
						«FOR attribute : be.attributes»
						u.set«attribute.name.toFirstUpper»(t«attribute.name.toFirstUpper»);
						«ENDFOR»
						«be.name.toLowerCase»s.add(u);
					}
					return «be.name.toLowerCase»s;
				}
			«ENDFOR»
			}
	'''
}