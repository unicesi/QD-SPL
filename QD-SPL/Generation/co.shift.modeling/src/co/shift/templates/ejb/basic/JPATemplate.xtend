package co.shift.templates.ejb.basic

import domainmetamodel.BusinessEntity
import domainmetamodel.Simple
import domainmetamodel.Association
import java.util.List
import co.shift.generators.domain.DomainCodeGenerator
import domainmetamodel.Delete
import domainmetamodel.Attribute
import domainmetamodel.ListAll
import org.eclipse.xtext.generator.IFileSystemAccess

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
			«var Attribute id = DomainCodeGenerator.getID(be)»
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
			«var sizeDos = DomainCodeGenerator.getDetailMultipleAssociations(be, associations).size»
			«IF (DomainCodeGenerator.isDetail(be))» 
				«IF sizeDos > 0»
				,
				«ENDIF»
				«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
				«var putComa = comaDos ++»
				«val container = association.eContainer as BusinessEntity»
				@NamedQuery(name = "«be.name.toLowerCase».get«container.name.toFirstUpper»«be.name.toFirstUpper»", query = "SELECT r FROM «be.name.toFirstUpper» r WHERE r.«container.name.toLowerCase»=:id")«IF comaDos < sizeDos - 1»,«ENDIF»
				«ENDFOR»
			«ENDIF»
		})
		public class «be.name.toFirstUpper» implements Serializable {
			
			private static final long serialVersionUID = 1L;
		«FOR attribute : be.attributes»
				«IF attribute.name.equals(id.name)»
				@Id
				«ENDIF»
				«IF DomainCodeGenerator.getType(attribute).equals("Date")»
				@Temporal(TemporalType.DATE)
				«ENDIF»
				private «DomainCodeGenerator.getType(attribute)» «attribute.name.toLowerCase»;
				
				public «DomainCodeGenerator.getType(attribute)» get«attribute.name.toFirstUpper»() {
					return this.«attribute.name.toLowerCase»;
				}
				
				public void set«attribute.name.toFirstUpper»(«DomainCodeGenerator.getType(attribute)» «attribute.name.toLowerCase») {
					this.«attribute.name.toLowerCase» = «attribute.name.toLowerCase»;
				}				
		«ENDFOR»
			
			«FOR association : be.associations»
			«IF (association instanceof Simple)»
				«val relatedEntity = association.relatedEntity»
				private «DomainCodeGenerator.getType(DomainCodeGenerator.getID(relatedEntity))» «association.name.toLowerCase»;
				
				public «DomainCodeGenerator.getType(DomainCodeGenerator.getID(relatedEntity))» get«association.name.toFirstUpper»() {
					return this.«association.name.toLowerCase»;
				}
				
				public void set«association.name.toFirstUpper»(«DomainCodeGenerator.getType(DomainCodeGenerator.getID(relatedEntity))» «association.name.toLowerCase») {
					this.«association.name.toLowerCase» = «association.name.toLowerCase»;
				}
			«ENDIF»
			«ENDFOR»
			
			«FOR association : DomainCodeGenerator.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
			«IF (DomainCodeGenerator.isDetail(be))» 
				private «DomainCodeGenerator.getType(DomainCodeGenerator.getID(container))» «container.name.toLowerCase»;
				
				public «DomainCodeGenerator.getType(DomainCodeGenerator.getID(container))» get«container.name.toFirstUpper»() {
					return this.«container.name.toLowerCase»;
				}
				
				public void set«container.name.toFirstUpper»(«DomainCodeGenerator.getType(DomainCodeGenerator.getID(container))» «container.name.toLowerCase») {
					this.«container.name.toLowerCase» = «container.name.toLowerCase»;
				}
			«ELSE»
				@OneToMany(mappedBy = "«be.name.toLowerCase»Bean", orphanRemoval = true)
				private List<«container.name.toFirstUpper»«be.name.toFirstUpper»> «container.name.toLowerCase»«be.name.toFirstUpper»;
				
				public List<«container.name.toFirstUpper»«be.name.toFirstUpper»> get«container.name.toFirstUpper»«be.name.toFirstUpper»() {
					return this.«container.name.toLowerCase»«be.name.toFirstUpper»;
				}
				
				public void set«container.name.toFirstUpper»«be.name.toFirstUpper»(List<«container.name.toFirstUpper»«be.name.toFirstUpper»> «container.name.toLowerCase»«be.name.toFirstUpper») {
					this.«container.name.toLowerCase»«be.name.toFirstUpper» = «container.name.toLowerCase»«be.name.toFirstUpper»;
				}
				
				«fsa.generateFile(
					"/co/shift/" + packageName.toLowerCase + "/" + be.name.toLowerCase + "/entity/" + container.name.toFirstUpper + be.name.toFirstUpper + ".java",
					JPAPKEncapTemplate.generate(be, packageName, container.name.toFirstUpper+be.name.toFirstUpper, associations, fsa))»
				«fsa.generateFile(
					"/co/shift/" + packageName.toLowerCase + "/" + be.name.toLowerCase + "/entity/" + container.name.toFirstUpper + be.name.toFirstUpper + "PK.java",
					JPAPKTemplate.generate(be, packageName, container, associations, fsa))»
			«ENDIF»
			«ENDFOR»
			
			@Override
			public boolean equals(Object obj) {
				«be.name.toFirstUpper» o = («be.name.toFirstUpper») obj;
				if (o != null)
				«IF (DomainCodeGenerator.getType(DomainCodeGenerator.getID(be)).equals("String"))»
					return «DomainCodeGenerator.getID(be).name.toLowerCase».equals(o.«DomainCodeGenerator.getID(be).name.toLowerCase»);
				«ENDIF»
				«IF (DomainCodeGenerator.getType(DomainCodeGenerator.getID(be)).equals("int"))»
					return «DomainCodeGenerator.getID(be).name.toLowerCase» == o.«DomainCodeGenerator.getID(be).name.toLowerCase»;
				«ENDIF»
				return false;
			}
			
			public «be.name.toFirstUpper»TO toTO() {
				«be.name.toFirstUpper»TO to = new «be.name.toFirstUpper»TO();
				«FOR attribute : be.attributes»
					to.set«attribute.name.toFirstUpper»(«attribute.name.toLowerCase»);
				«ENDFOR»
				return to;
			}
		}
	'''
}
