package co.shift.generators.domain

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import domainmetamodel.BusinessEntity
import co.shift.templates.ejb.basic.BoundaryInterfaceTemplate
import domainmetamodel.Business
import domainmetamodel.Association
import java.util.List
import java.util.ArrayList
import co.shift.templates.ejb.basic.DTOTemplate
import co.shift.qualiyatributes.ImplMapping
import co.shift.templates.ejb.basic.BoundaryImplTemplate
import co.shift.templates.ejb.basic.DAOInterfaceTemplate
import co.shift.templates.ejb.basic.DAOImplTemplate
import co.shift.templates.ejb.basic.JPATemplate
import co.shift.templates.web.basic.AbstractControllerTemplate
import co.shift.templates.web.basic.UITemplate
import co.shift.templates.web.basic.ProcessContributorTemplate
import co.shift.templates.web.basic.RegistryTemplate
import co.shift.templates.web.basic.UIContributorTemplate
import co.shift.templates.web.basic.UIControllerTemplate
import co.shift.templates.web.basic.ContentPanelTemplate
import co.shift.templates.web.basic.MenuPaneTemplate
import co.shift.templates.web.basic.BeanLocatorTemplate
import co.shift.templates.web.basic.GlobalJNDITemplate
import co.shift.templates.web.contributed.authenticity.LoginFormTemplate
import co.shift.templates.web.contributed.authenticity.LoginControllerTemplate
import co.shift.templates.web.basic.FormTemplate
import co.shift.templates.web.basic.WebControllerTemplate
import co.shift.templates.database.basic.MERScriptTemplate
import co.shift.templates.web.basic.PersistenceTemplate
import co.shift.templates.database.basic.InsertsScriptTemplate

class DomainCodeGenerator implements IGenerator {

//	public val final static CONTRIBUTE_TO_BI = "BusinessInterface";
//	public val final static CONTRIBUTE_TO_BIMPL = "BusinessImplementation";
//	public val final static CONTRIBUTE_TO_WEB = "Web";
//	public val final static CONTRIBUTE_TO_IMPORT = "Imports";
//	public val final static CONTRIBUTE_TO_ATTRIBUTE = "Attributes";
//	public val final static CONTRIBUTE_TO_GENERATION = "Generate";

//	var static HashMap<String, Contribution> selectedContributors;
//	var List<BusinessEntity> businessEntities;

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		ImplMapping.performMapping
//		val QAParser qas = new QAParser()
		var BusinessEntity authEntity

//		selectedContributors = qas.parseSelectedFeatures
//		businessEntities = new ArrayList
		DomainCodeUtilities.init

		var appName = ""
		var name = ""
		var List<Association> associations = new ArrayList
		for (k : input.allContents.toIterable) {
			if (k instanceof Business) {
				val b = k as Business
				appName = b.name
				associations = DomainCodeUtilities.getBusinessAssociations(b)
			}
			if (k instanceof BusinessEntity) {
				val be = k as BusinessEntity
				
				if(be.isIsAuthenticable) {
					authEntity = be;
				}else{
					DomainCodeUtilities.addBusinessEntity(be);
				}
				
				name = be.name.toFirstUpper
				fsa.generateFile("/co/shift/" + appName.toLowerCase + "/to/" + name + "TO.java",
					DTOTemplate::generate(be, appName, associations))
				fsa.generateFile(
					"/co/shift/" + appName.toLowerCase + "/" + name.toLowerCase + "/boundary/I" + name + "Manager.java",
					BoundaryInterfaceTemplate::generate(be, appName, associations, fsa))
				fsa.generateFile(
					"/co/shift/" + appName.toLowerCase + "/" + name.toLowerCase + "/boundary/" + name + "Manager.java",
					BoundaryImplTemplate::generate(be, appName, associations, fsa))
				fsa.generateFile(
					"/co/shift/" + appName.toLowerCase + "/" + name.toLowerCase + "/entity/" + name + ".java",
					JPATemplate::generate(be, appName, associations, fsa))
					
				if ((DomainCodeUtilities.getDetailMultipleAssociations(be, associations).size > 0 && !DomainCodeUtilities.hasZeroAssociations(be)) || DomainCodeUtilities.getDetailSimpleAssociations(be, associations).size > 0) {
					fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/" + name.toLowerCase + "/control/I" + name + "DAO.java",
						DAOInterfaceTemplate::generate(be, appName, associations))
					fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/" + name.toLowerCase + "/control/" + name + "DAO.java",
						DAOImplTemplate::generate(be, appName, associations))
				}
				
				if(DomainCodeUtilities.isMaster(be)){
					fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/ext/" + be.name.toLowerCase + "/"+name+"Form.java",
						FormTemplate::generate(appName, be))
				}
					fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/ext/" + be.name.toLowerCase + "/"+name+"Controller.java",
						WebControllerTemplate::generate(appName, be, associations, fsa))
			}	
		}
		DomainCodeUtilities.extendContribution("_r_2_11", DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, appName, authEntity);
		DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, appName)
		
		//---------Web Generation-----------
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/AbstractController.java",
						AbstractControllerTemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/"+appName.toUpperCase+"UI.java",
						UITemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/ProcessContributor.java",
						ProcessContributorTemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/Registry.java",
						RegistryTemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/UIContributor.java",
						UIContributorTemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/UIController.java",
						UIControllerTemplate::generate(appName, authEntity, DomainCodeUtilities.getBusinessEntities))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/client/ContentPanel.java",
						ContentPanelTemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/client/MenuPanel.java",
						MenuPaneTemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/util/beanlocator/BeanLocator.java",
						BeanLocatorTemplate::generate(appName))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/util/beanlocator/GlobalJNDIName.java",
						GlobalJNDITemplate::generate(appName))
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/web/ext/authenticator/LoginForm.java",
				LoginFormTemplate.generate(appName));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/web/ext/authenticator/LoginController.java",
				LoginControllerTemplate.generate(appName, authEntity));
				
		fsa.generateFile("/co/shift/" + appName.toLowerCase + "/ejb/persistence/persistence.xml",
			PersistenceTemplate::generate(appName))
		//---------DataBase Script Generation-----------
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/database/ScriptOne.sql",
						MERScriptTemplate::generate(appName, authEntity, associations))
		fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/database/InsertsScript.sql",
						InsertsScriptTemplate::generate(appName, authEntity))
						
		DomainCodeUtilities.runScript(appName)
	}
	
//	def List<BusinessEntity> getBusinessEntities() {
//		businessEntities
//	}
//	
//	def void addBusinessEntity(BusinessEntity be) {
//		businessEntities.add(be)
//	}
//
//	def List<Association> getBusinessAssociations(Business b) {
//		var List<Association> associations = new ArrayList
//		for (be : b.entities) {
//			for (a : be.associations) {
//				associations.add(a)
//			}
//		}
//		associations
//	}
//
////Ubicar en una clase aparte
//	def static String extendContribution(String id, String phase, Object ... data) {
//
//		val List<Contribution> contributors = getSelectedVariants(id)
//		var String rules = ""
//		
//		if (phase.equals(CONTRIBUTE_TO_BI)) {
//			for(c : contributors) {
//				rules += c.contributeToBusinessInterface(data) + "\n\n"
//			}
//		}
//		if (phase.equals(CONTRIBUTE_TO_BIMPL)) {
//			for(c : contributors) {
//				rules += c.contributeToBusinessImpl(data) + "\n\n"
//			}
//		}
//		if (phase.equals(CONTRIBUTE_TO_WEB)) {
//			for(c : contributors) {
//				rules += c.contributeToWeb(data) + "\n\n"
//			}
//		}
//		if (phase.equals(CONTRIBUTE_TO_ATTRIBUTE)) {
//			for(c : contributors) {
//				rules += c.contributeToAtribute(data) + "\n\n"
//			}
//		}
//		if (phase.equals(CONTRIBUTE_TO_IMPORT)) {
//			for(c : contributors) {
//				rules += c.contributeToImport(data) + "\n\n"
//			}
//		}
//		if (phase.equals(CONTRIBUTE_TO_GENERATION)) {
//			for(c : contributors) {
//				c.generate(data);
//			}
//		}
//		
//		return rules
//	}
//
//	public def static boolean isQASelected (String prefixId) {
//		val i = selectedContributors.keySet.iterator
//		while (i.hasNext) {
//			val c = i.next
//			if (c.equals(prefixId))
//				return true
//		}
//		return false
//	}
//
//	private def static List<Contribution> getSelectedVariants(String variationPointPrefix) {
//		val List<Contribution> foundVariants = new ArrayList
//		val i = selectedContributors.keySet.iterator
//		while (i.hasNext) {
//			val c = i.next
//			if (c.startsWith(variationPointPrefix))
//				foundVariants.add(selectedContributors.get(c))
//		}
//		foundVariants
//	}
//	
//		//  Obtiene el atributo marcado como ID de la entidad
//	def static Attribute getID(BusinessEntity be) {
//		for (Attribute a : be.attributes.toList) {
//			if (a.isDefault == true)
//				return a;
//		}
//		null
//	}
//
////  Obtiene el tipo de dato en Java del literal
//	def static String getType(String literal) {
//		if (literal.equals("string"))
//			return "String";
//		if (literal.equals("date"))
//			return "Date";
//		if (literal.equals("object"))
//			return "Object";
//		if (literal.equals("collection"))
//			return "List";
//		return literal;
//	}
//	
//	def static String getType(Attribute attribute) {
//		val literal = attribute.dataType.literal;
//		if (literal.equals("string"))
//			return "String";
//		if (literal.equals("date"))
//			return "Date";
//		if (literal.equals("object"))
//			return "Object";
//		if (literal.equals("collection"))
//			return "List";
//		return literal;
//	}
//
////  Obtiene todas las asociaciones simples del modelo que relacionan la entidad be
//	def static List<Association> getDetailSimpleAssociations(BusinessEntity be, List<Association> list) {
//		val List<Association> associations = new ArrayList
//		for (a : list) {
//			if (a instanceof Simple) {
//				if (a.relatedEntity.name.equals(be.name)) {
//					associations.add(a)
//				}
//			}
//		}
//		associations
//	}
//
////  Obtiene todas las asociaciones multiples del modelo que relacionan la entidad be
//	def static List<Association> getDetailMultipleAssociations(BusinessEntity be, List<Association> list) {
//		val List<Association> associations = new ArrayList
//		for (a : list) {
//			if (a instanceof Multiple) {
//				if (a.entity.name.equals(be.name)) {
//					associations.add(a)
//				}
//			}
//		}
//		associations
//	}
//	
//	//  Determina si la entidad be es detalle o no
//	def static boolean isDetail(BusinessEntity be) {
//		be.associations.size == 0;
//	}
//	
//	def static boolean isMaster (BusinessEntity be) {
//		for( ass : be.associations) {
//			if (ass instanceof Multiple)
//				return true
//		}
//		return false
//	}
}
