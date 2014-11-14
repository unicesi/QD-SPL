package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import domainmetamodel.AddElement
import domainmetamodel.DeleteElement
import domainmetamodel.ListElements
import domainmetamodel.ContractElements
import java.util.ArrayList
import java.util.List
import domainmetamodel.Association
import domainmetamodel.Simple
import co.shift.generators.domain.DomainCodeGenerator
import domainmetamodel.ListAll
import domainmetamodel.Contracts
import domainmetamodel.Create
import domainmetamodel.Update
import domainmetamodel.Delete
import org.eclipse.xtext.generator.IFileSystemAccess

class BoundaryImplTemplate {
	
	static ArrayList<String> importTOs = new ArrayList;
	
	def static generate(BusinessEntity be, String packageName, List<Association> associations, IFileSystemAccess fsa) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».boundary;
		
		import java.util.ArrayList;
		import java.util.List;
		
		import javax.ejb.EJB;
		import javax.ejb.Stateless;
		import javax.persistence.EntityManager;
		import javax.persistence.NoResultException;
		import javax.persistence.PersistenceContext;
		import javax.persistence.Query;
		import javax.persistence.TypedQuery;
		
		import org.eclipse.persistence.exceptions.DatabaseException;
		«IF ((DomainCodeGenerator.getDetailMultipleAssociations(be, associations) != null && !DomainCodeGenerator.isDetail(be))
			)»
		import co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control.I«be.name.toFirstUpper»DAO;
		«ENDIF»
		
		import co.shift.«packageName.toLowerCase()».to.«be.name»TO;
		«FOR contract : be.contracts»
			«IF (contract instanceof AddElement || contract instanceof DeleteElement || contract instanceof ListElements)»
				«val relatedEntity = (contract as ContractElements).association.entity»
				«IF (!importTOs.contains(relatedEntity.name))»
					import co.shift.«packageName.toLowerCase()».to.«relatedEntity.name»TO;
					«val result = importTOs.add(relatedEntity.name)»
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		«IF (DomainCodeGenerator.getDetailMultipleAssociations(be, associations) != null && !DomainCodeGenerator.isDetail(be))»
		«DomainCodeGenerator.extendContribution("_r_1", DomainCodeGenerator.CONTRIBUTE_TO_IMPORT, packageName, be.name)»
		«ENDIF»
		
		«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_IMPORT, packageName, be.name)»
		«var authContribution = DomainCodeGenerator.extendContribution("_r_2_11_15_17", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, be.name.toLowerCase+""+DomainCodeGenerator.getID(be).name.toFirstUpper)»
					
		«IF (be.isIsAuthenticable && authContribution != null && !authContribution.equals(""))»
		«DomainCodeGenerator.extendContribution("_r_2_11_15_17", DomainCodeGenerator.CONTRIBUTE_TO_IMPORT, packageName, be.name)»
		«ENDIF»
		
		import co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity.«be.name.toFirstUpper»;
		«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
		«val container = association.eContainer as BusinessEntity»
		«IF (!DomainCodeGenerator.isDetail(be))»
		import co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity.«container.name.toFirstUpper + be.name.toFirstUpper»;
		import co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity.«container.name.toFirstUpper + be.name.toFirstUpper»PK;
		«ENDIF»
		«ENDFOR»
		
«««		@Boundary(responsibility = "Define basic Project services")
		@Stateless
		public class «be.name.toFirstUpper»Manager implements I«be.name.toFirstUpper»Manager {
			
			@PersistenceContext(unitName = "co.shift.«packageName.toLowerCase()».«be.name.toLowerCase»")
			private EntityManager em;
			
			«IF (//DomainCodeGenerator.getDetailSimpleAssociations(be, associations) != null || 
				(DomainCodeGenerator.getDetailMultipleAssociations(be, associations) != null && !DomainCodeGenerator.isDetail(be))
			)»
			@EJB
			private I«be.name.toFirstUpper»DAO «be.name.toLowerCase»DAO;
			«ENDIF»
			
			«IF (be.isIsAuthenticable && authContribution != null && !authContribution.equals(""))»
			«DomainCodeGenerator.extendContribution("_r_2_11_15_17", DomainCodeGenerator.CONTRIBUTE_TO_ATTRIBUTE)»
			«ENDIF»
			
			«val attribute = DomainCodeGenerator.extendContribution("_r_1", DomainCodeGenerator.CONTRIBUTE_TO_ATTRIBUTE, be.name)»
			«IF (attribute != null && !attribute.equals("") && (DomainCodeGenerator.getDetailMultipleAssociations(be, associations) != null && !DomainCodeGenerator.isDetail(be)))»
				«attribute»
			«ENDIF»
			«val attribute2 = DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_ATTRIBUTE)»
			«IF (attribute2 != null && !attribute2.equals(""))»
				«attribute2»
				«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_GENERATION, fsa, packageName, be)»
			«ENDIF»
			
			«FOR contract : be.contracts»
«««				Create contract
				«IF (contract instanceof Create)»
					public boolean «(contract as Contracts).name»(«be.name»TO «be.name.toLowerCase()») throws Exception {
					«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, contract, be, null, null, null, null, null, 0)»
						«var id = DomainCodeGenerator.getID(be)»
						«be.name.toFirstUpper» found«be.name.toFirstUpper» = em.find(«be.name.toFirstUpper».class, «be.name.toLowerCase».get«id.name.toFirstUpper»());
						if (found«be.name.toFirstUpper» != null)
							throw new Exception("«be.name.toFirstUpper» Alredy Exists");
						else {
							«be.name.toFirstUpper» new«be.name.toFirstUpper» = new «be.name.toFirstUpper»();
							«FOR a : be.attributes»
							new«be.name.toFirstUpper».set«a.name.toFirstUpper()»(«be.name.toLowerCase()».get«a.name.toFirstUpper()»());
							«ENDFOR»
						
							try {
								em.persist(new«be.name.toFirstUpper»);
								em.flush();
								return true;
							} catch (DatabaseException e) {
								return false;
							}
						}
					}
				«ENDIF»
				«««				Update contract
				«IF (contract instanceof Update)»
					public boolean «(contract as Contracts).name»(«be.name»TO «be.name.toLowerCase()») throws Exception {
						«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, contract, be, null, null, null, null, null, 0)»
						«var id = DomainCodeGenerator.getID(be)»
						«be.name.toFirstUpper» found«be.name.toFirstUpper» = em.find(«be.name.toFirstUpper».class, «be.name.toLowerCase».get«id.name.toFirstUpper»());
						if (found«be.name.toFirstUpper» == null)
							throw new Exception("«be.name.toFirstUpper» Doesn't Exists");
						else {
							«FOR a : be.attributes»
							found«be.name.toFirstUpper».set«a.name.toFirstUpper()»(«be.name.toLowerCase()».get«a.name.toFirstUpper()»());
							«ENDFOR»
						try {
							em.merge(found«be.name.toFirstUpper»);
							em.flush();
							return true;
						} catch (DatabaseException e) {
							return false;
						}
					}
					}
				«ENDIF»
				«««				Delete contract
				«IF (contract instanceof Delete)»
					public boolean «(contract as Contracts).name»(«be.name»TO «be.name.toLowerCase()») throws Exception {
						«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, contract, be, null, null, null, null, null, 0)»
						«var id = DomainCodeGenerator.getID(be)»
						«be.name.toFirstUpper» found«be.name.toFirstUpper» = em.find(«be.name.toFirstUpper».class, «be.name.toLowerCase».get«id.name.toFirstUpper»());
						if (found«be.name.toFirstUpper» == null)
							throw new Exception("«be.name.toFirstUpper» Doesn't Exists");
						else {
							TypedQuery<«be.name.toFirstUpper»> query = em.createNamedQuery(
								"«be.name.toLowerCase».delete«be.name.toFirstUpper»", «be.name.toFirstUpper».class);
							query.setParameter("id", «be.name.toLowerCase».get«id.name.toFirstUpper»());
							try {
								query.executeUpdate();
								return true;
							} catch (NoResultException e) {
								throw new Exception("«be.name.toFirstUpper» Cannot Be Found");
							} catch (DatabaseException e) {
								throw new Exception("«be.name.toFirstUpper» With Associated Data Cannot Be Deleted");
							}
						}
					}
				«ENDIF»
«««				ListAll contract
				«IF (contract instanceof ListAll)»
					«DomainCodeGenerator.extendContribution("_r_1", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, contract, be)»
				«ENDIF»
«««				AddElement contract
				«IF (contract instanceof AddElement)»
					«val relatedEntity = (contract as ContractElements).association.entity»
					«val type = DomainCodeGenerator.getID(be).dataType.literal»
					public boolean «(contract as ContractElements).name»(«relatedEntity.name»TO «relatedEntity.name.toLowerCase», «DomainCodeGenerator.getType(
			type)» «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper») throws Exception {
						«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, contract, be, relatedEntity, null, null, null, null, 0)»
						«be.name.toFirstUpper» «be.name.toLowerCase» = em.find(«be.name.toFirstUpper».class, «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper»);
						«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper»PK pk = new «relatedEntity.name.toFirstUpper»«be.name.toFirstUpper»PK();
						pk.set«DomainCodeGenerator.getID(be).name.toFirstUpper»(«be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper»);
						pk.set«DomainCodeGenerator.getID(relatedEntity).name.toFirstUpper»(«relatedEntity.name.toLowerCase».get«DomainCodeGenerator.getID(relatedEntity).name.toFirstUpper»());

						«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper» pU = em.find(«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper».class, pk);
						if (pU == null) {
							pU = new «relatedEntity.name.toFirstUpper»«be.name.toFirstUpper»();
							pU.setId(pk);
							pU.set«be.name.toFirstUpper»Bean(«be.name.toLowerCase»);
							«be.name.toLowerCase».get«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper»().add(pU);

							try {
								em.merge(«be.name.toLowerCase»);
								em.flush();
								return true;
							} catch (DatabaseException e) {
								return false;
							}
						} else
							throw new Exception("«relatedEntity.name.toFirstUpper» alredy exists in «be.name.toLowerCase»");
					}
				«ENDIF»	
«««				DeleteElement contract
				«IF (contract instanceof DeleteElement)»
					«val relatedEntity = (contract as ContractElements).association.entity»
					«val type = DomainCodeGenerator.getID(be).dataType.literal»
					public boolean «(contract as ContractElements).name»(«relatedEntity.name»TO «relatedEntity.name.toLowerCase», «DomainCodeGenerator.getType(
			type)» «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper») throws Exception {
						«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, contract, be, relatedEntity, null, null, null, null, 0)»
						«be.name.toFirstUpper» «be.name.toLowerCase» = em.find(«be.name.toFirstUpper».class, «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper»);

						«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper»PK pk = new «relatedEntity.name.toFirstUpper»«be.name.toFirstUpper»PK();
						pk.set«DomainCodeGenerator.getID(be).name.toFirstUpper»(«be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper»);
						pk.set«DomainCodeGenerator.getID(relatedEntity).name.toFirstUpper»(«relatedEntity.name.toLowerCase».get«DomainCodeGenerator.getID(relatedEntity).name.toFirstUpper»());
						«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper» pU = em.find(«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper».class, pk);
						«be.name.toLowerCase».get«relatedEntity.name.toFirstUpper»«be.name.toFirstUpper»().remove(pU);

						try {
							em.merge(«be.name.toLowerCase»);
							em.flush();
							return true;
						} catch (DatabaseException e) {
							return false;
						}
					}
				«ENDIF»	
			«ENDFOR»
«««			Simple Associations contracts
			«FOR association : be.associations»	
				«IF (association instanceof Simple)»
					«val relatedEntity = association.relatedEntity»
					«val type = DomainCodeGenerator.getID(be).dataType.literal»
					public boolean set«be.name.toFirstUpper»«association.name.toFirstUpper»(«relatedEntity.name»TO «association.name.
			toLowerCase», «DomainCodeGenerator.getType(type)» «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper») throws Exception {
						«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, be, relatedEntity, association.name, association, null, null, 0)»
						«be.name.toFirstUpper» «be.name.toLowerCase» = em.find(«be.name.toFirstUpper».class, «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper»);
						«be.name.toLowerCase».set«association.name.toFirstUpper»(«association.name.toLowerCase».get«DomainCodeGenerator.getID(relatedEntity).name.toFirstUpper»());

						try {
							em.merge(«be.name.toLowerCase»);
							em.flush();
							return true;
						} catch (DatabaseException e) {
							return false;
						}
					}
				«ENDIF»
			«ENDFOR»
«««			Simple Associations contracts for detail entities
			«FOR association : DomainCodeGenerator.getDetailSimpleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public «be.name»TO get«container.name.toFirstUpper»«association.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
			toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper») {
					«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, null, container, null, null, 1, null, 0)»
					return «be.name.toLowerCase»DAO.get«container.name.toFirstUpper»«association.name.toFirstUpper»(«container.name.
						toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
				}
			«ENDFOR»
«««			Multiple Associations contracts for detail entities
			«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeGenerator.getID(container).dataType.literal»
				public List<«be.name.toFirstUpper»TO> get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«DomainCodeGenerator.getType(type)» «container.name.
			toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper») {
				«IF !DomainCodeGenerator.isDetail(be)»
					«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, null, container, null, null, 1, null, 0)»
					return «be.name.toLowerCase»DAO.get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«container.name.
						toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
				«ELSE»
					List<«be.name.toFirstUpper»TO> to«be.name.toFirstUpper»s = new ArrayList<>();
					TypedQuery<«be.name.toFirstUpper»> query = em.createNamedQuery("«be.name.toLowerCase».get«container.name.toFirstUpper»«be.name.toFirstUpper»",
							«be.name.toFirstUpper».class);
					query.setParameter("id", «container.name.toLowerCase»«DomainCodeGenerator.getID(container).name.toFirstUpper»);
					try {
						List<«be.name.toFirstUpper»> found«be.name.toFirstUpper»s = query.getResultList();
						for («be.name.toFirstUpper» «be.name.toLowerCase» : found«be.name.toFirstUpper»s) {
							«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 1)»
							to«be.name.toFirstUpper»s.add(«be.name.toLowerCase».toTO());
						}
						return to«be.name.toFirstUpper»s;
					} catch (NoResultException e) {
						return null;
					}
				«ENDIF»
				}
			«ENDFOR»
«««			Authentication
			«IF (be.isIsAuthenticable)»
				«val type = DomainCodeGenerator.getID(be).dataType.literal»
				public «be.name.toFirstUpper»TO authenticate(«DomainCodeGenerator.getType(type)» «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper», String password) throws Exception {
					«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, true, 0)»
					«IF authContribution != null && !authContribution.equals("")»
					«authContribution»;
					«DomainCodeGenerator.extendContribution("_r_2_11_15_17", DomainCodeGenerator.CONTRIBUTE_TO_GENERATION, fsa, packageName, be)»
					«ELSE»
					User found«be.name.toFirstUpper» = em.find(«be.name.toFirstUpper».class, «be.name.toLowerCase»«DomainCodeGenerator.getID(be).name.toFirstUpper»);
					if (found«be.name.toFirstUpper» != null) {
						if (found«be.name.toFirstUpper».getPassword().equals(password))
							return found«be.name.toFirstUpper».toTO();
						else
							throw new Exception("Incorrect password");
					} else
						throw new Exception("«be.name.toFirstUpper» doesn't exists");
					«ENDIF»
				}
			«ENDIF»
		}
	'''
}