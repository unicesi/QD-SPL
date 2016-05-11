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

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		ImplMapping.performMapping
		var BusinessEntity authEntity
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

		//DomainCodeUtilities.extendContribution(DomainCodeUtilities.VP_INTEGRITY_AUTHENTICITY, DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, appName, authEntity);
		DomainCodeUtilities.extendContribution("root","general", fsa, appName, authEntity)

		DomainCodeUtilities.extendContribution(DomainCodeUtilities.VP_CONFIDENTIALITY, DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, appName)
		//DomainCodeUtilities.extendContribution("root","general", fsa, appName)
		
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
		DomainCodeUtilities.end()
	}
}
