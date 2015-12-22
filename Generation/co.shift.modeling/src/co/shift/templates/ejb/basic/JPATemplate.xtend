package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import domainmetamodel.Simple
import domainmetamodel.Association
import java.util.List
import co.shift.generators.domain.DomainCodeUtilities
import domainmetamodel.Delete
import domainmetamodel.Attribute
import domainmetamodel.ListAll
import org.eclipse.xtext.generator.IFileSystemAccess
import domainmetamodel.DeleteElement
import java.util.ArrayList

class JPATemplate {

	def static generate (BusinessEntity be, String packageName, List<Association> associations, IFileSystemAccess fsa) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».entity;
		
		import java.util.List;
		import java.io.Serializable;
		import java.util.Date;
		import java.math.BigDecimal;
		
		import javax.persistence.*;
		import java.io.Serializable;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		
		@Entity
		@Table(name = "«be.name.toFirstUpper»")
		@NamedQueries({
			«var coma = 0»
			«var size = be.contracts.size»
			«var Attribute id = DomainCodeUtilities.getID(be)»
			«FOR contract : be.contracts»
				«IF contract instanceof Delete»
					«var putComa = coma ++»
					@NamedQuery(name = "«be.name.toLowerCase».delete«be.name.toFirstUpper»", query = "DELETE FROM «be.name.toFirstUpper» p WHERE p.«id.name»=:id")«IF coma < size - 1»,«ENDIF»
				«ENDIF»
				«IF contract instanceof ListAll»
					«var putComa = coma ++»
					«var c = contract»
					@NamedQuery(name = "«be.name.toLowerCase».«c.name»", query = "SELECT p FROM «be.name.toFirstUpper» p")«IF coma < size - 1»,«ENDIF»
				«ENDIF»
				«IF !(contract instanceof ListAll) && !(contract instanceof Delete)»
					«var sizeM = size--»
				«ENDIF»
			«ENDFOR»
			«var comaDos = 0»
			«var sizeDos = DomainCodeUtilities.getDetailMultipleAssociations(be, associations).size»
			«IF (DomainCodeUtilities.hasZeroAssociations(be))» 
				«IF sizeDos > 0»
				,
				«ENDIF»
				«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
				«var putComa = comaDos ++»
				«val container = association.eContainer as BusinessEntity»
				@NamedQuery(name = "«be.name.toLowerCase».get«container.name.toFirstUpper»«be.name.toFirstUpper»", query = "SELECT r FROM «be.name.toFirstUpper» r WHERE r.«container.name.toLowerCase»=:id")«IF comaDos < sizeDos - 1»,«ENDIF»
				«ENDFOR»
			«ENDIF»
		})
		public class «be.name.toFirstUpper» implements Serializable {
		«DomainCodeUtilities.addEntityName("co.shift."+packageName.toLowerCase()+"."+be.name.toLowerCase+".entity."+be.name.toFirstUpper)»	
			private static final long serialVersionUID = 1L;
		«FOR attribute : be.attributes»
				«IF attribute.name.equals(id.name)»
				@Id
				«ENDIF»
				«IF DomainCodeUtilities.getType(attribute).equals("Date")»
				@Temporal(TemporalType.DATE)
				«ENDIF»
				private «DomainCodeUtilities.getType(attribute)» «attribute.name.toLowerCase»;
				
				public «DomainCodeUtilities.getType(attribute)» get«attribute.name.toFirstUpper»() {
					return this.«attribute.name.toLowerCase»;
				}
				
				public void set«attribute.name.toFirstUpper»(«DomainCodeUtilities.getType(attribute)» «attribute.name.toLowerCase») {
					this.«attribute.name.toLowerCase» = «attribute.name.toLowerCase»;
				}				
		«ENDFOR»
			
			«FOR association : be.associations»
			«IF (association instanceof Simple)»
				«val relatedEntity = association.relatedEntity»
				private «DomainCodeUtilities.getWrapperType(DomainCodeUtilities.getID(relatedEntity))» «association.name.toLowerCase»;
				
				public «DomainCodeUtilities.getWrapperType(DomainCodeUtilities.getID(relatedEntity))» get«association.name.toFirstUpper»() {
					return this.«association.name.toLowerCase»;
				}
				
				public void set«association.name.toFirstUpper»(«DomainCodeUtilities.getWrapperType(DomainCodeUtilities.getID(relatedEntity))» «association.name.toLowerCase») {
					this.«association.name.toLowerCase» = «association.name.toLowerCase»;
				}
			«ENDIF»
			«ENDFOR»
			
			«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
«««			«FOR c : be.contracts»
«««			«IF c instanceof DeleteElement»
«««				«val container = c.association.entity»
				«val container = association.eContainer as BusinessEntity»
			«IF (DomainCodeUtilities.hasZeroAssociations(be))» 
				private «DomainCodeUtilities.getType(DomainCodeUtilities.getID(container))» «container.name.toLowerCase»;
				
				public «DomainCodeUtilities.getType(DomainCodeUtilities.getID(container))» get«container.name.toFirstUpper»() {
					return this.«container.name.toLowerCase»;
				}
				
				public void set«container.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(container))» «container.name.toLowerCase») {
					this.«container.name.toLowerCase» = «container.name.toLowerCase»;
				}
			«ENDIF»
			«ENDFOR» 
			«FOR c : be.contracts»
			«IF c instanceof DeleteElement»
			«val container = c.association.entity»
			«IF !DomainCodeUtilities.hasZeroAssociations(container)»
				@OneToMany(mappedBy = "«be.name.toLowerCase»Bean", orphanRemoval = true)
				private List<«be.name.toFirstUpper»«container.name.toFirstUpper»> «be.name.toLowerCase»«container.name.toFirstUpper»;
				
				public List<«be.name.toFirstUpper»«container.name.toFirstUpper»> get«be.name.toFirstUpper»«container.name.toFirstUpper»() {
					return this.«be.name.toLowerCase»«container.name.toFirstUpper»;
				}
				
				public void set«be.name.toFirstUpper»«container.name.toFirstUpper»(List<«be.name.toFirstUpper»«container.name.toFirstUpper»> «be.name.toLowerCase»«container.name.toFirstUpper») {
					this.«be.name.toLowerCase»«container.name.toFirstUpper» = «be.name.toLowerCase»«container.name.toFirstUpper»;
				}
				
				«fsa.generateFile(
					"/co/shift/" + packageName.toLowerCase + "/" + be.name.toLowerCase + "/entity/" + be.name.toFirstUpper + container.name.toFirstUpper + ".java",
					JPAPKEncapTemplate.generate(be, packageName, be.name.toFirstUpper+container.name.toFirstUpper, associations, fsa))»
				«fsa.generateFile(
					"/co/shift/" + packageName.toLowerCase + "/" + be.name.toLowerCase + "/entity/" + be.name.toFirstUpper + container.name.toFirstUpper + "PK.java",
					JPAPKTemplate.generate(be, packageName, container, associations, fsa))»
				«var BusinessEntity[] asso = newArrayList()»
				«var List<BusinessEntity> list = new ArrayList»
				«var addA = list.add(be)»
				«var addB = list.add(container)»
				«DomainCodeUtilities.addManyToManyAssociation(list.toArray(asso))»
			«ENDIF»
			«ENDIF»
«««			«ENDIF»
			«ENDFOR»
			
			@Override
			public boolean equals(Object obj) {
				«be.name.toFirstUpper» o = («be.name.toFirstUpper») obj;
				if (o != null)
				«IF (DomainCodeUtilities.getType(DomainCodeUtilities.getID(be)).equals("String"))»
					return «DomainCodeUtilities.getID(be).name.toLowerCase».equals(o.«DomainCodeUtilities.getID(be).name.toLowerCase»);
				«ENDIF»
				«IF (DomainCodeUtilities.getType(DomainCodeUtilities.getID(be)).equals("int"))»
					return «DomainCodeUtilities.getID(be).name.toLowerCase» == o.«DomainCodeUtilities.getID(be).name.toLowerCase»;
				«ENDIF»
				return false;
			}
			
			public «be.name.toFirstUpper»TO toTO() {
				«be.name.toFirstUpper»TO to = new «be.name.toFirstUpper»TO();
				«FOR attribute : be.attributes»
					to.set«attribute.name.toFirstUpper»(«attribute.name.toLowerCase»);
				«ENDFOR»
				«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
				«var container = association.eContainer as BusinessEntity»
				«IF (DomainCodeUtilities.hasZeroAssociations(be))» 
					to.set«container.name.toFirstUpper»(«container.name.toLowerCase»);
				«ENDIF»
				«ENDFOR»
				return to;
			}
		}
	'''
}
