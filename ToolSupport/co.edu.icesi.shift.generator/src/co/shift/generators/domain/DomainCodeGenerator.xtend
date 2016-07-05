package co.shift.generators.domain

import co.shift.qualiyatributes.ImplMapping
import co.shift.templates.ejb.basic.BoundaryInterfaceTemplate
import co.shift.templates.ejb.basic.DTOTemplate
import domainmetamodel.Association
import domainmetamodel.Business
import domainmetamodel.BusinessEntity
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import co.shift.templates.ejb.basic.BoundaryImplTemplate
import co.shift.templates.ejb.basic.JPATemplate
import co.shift.templates.ejb.basic.DAOInterfaceTemplate
import co.shift.templates.ejb.basic.DAOImplTemplate

class DomainCodeGenerator implements IGenerator {

	private static String className = new Object(){}.class.enclosingClass.simpleName

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		ImplMapping.performMapping
		var BusinessEntity authEntity
		DomainCodeUtilities.init

		var appName = ""
		var name = ""
		var List<Association> associations = new ArrayList
		//Establece la plantilla actual
		DomainCodeUtilities.beginTemplate(className)
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
//Inicio Jcifuentes: En esta sección deberían incluirse todas las configuraciones para GENERATION
//Que David definio dentro de las plantillas. Anotar el origen en cada caso:
//FROM BoundaryInterfaceTemplate 
				DomainCodeUtilities.beginSection(DomainParams.SECT_GENERATE)
				DomainCodeUtilities.contribute2Template(1, fsa, appName, be);
//				DomainCodeUtilities.contribute(DomainParams.CONF_NORMAL_TE, 1, fsa, appName, be) //Esta ni siquiera hace nada, así se invoque
//				DomainCodeUtilities.contribute(DomainParams.CONF_MEDIUM_TE, 1, fsa, appName, be) //Genera los controles BasicFLR
//				DomainCodeUtilities.contribute(DomainParams.CONF_FASTSYNC_TE, 1, fsa, appName, be) //Genera los controles OptimizedFLR y el ListUpdater
//				DomainCodeUtilities.contribute(DomainParams.CONF_FASTASYNC_TE, 1, fsa, appName, be) //Genera los controles Parallelizer y AsyncWorker
//FROM DomainCodeGenerator (estaba abajo)
//				DomainCodeUtilities.contribute(DomainParams.CONF_AUTHENTIC_LOCKOUT, 1, fsa, appName, authEntity) //Genera los controles IAuthorizationManager.java y otros
//				DomainCodeUtilities.contribute(DomainParams.CONF_AUTHORIZATION, 1, fsa, appName, authEntity)
//				DomainCodeUtilities.contribute(DomainParams.CONF_DATA_ENCRYPTED, 1, fsa, appName)
//				DomainCodeUtilities.contribute(DomainParams.CONF_DATA_UNENCRYPTED, 1, fsa, appName)

				DomainCodeUtilities.endSection
//Fin Jcifuentes GENERATION

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
				
/*Inicio Jcifuentes (comentado)
				if(DomainCodeUtilities.isMaster(be)){
					fsa.generateFile(
						"/co/shift/" + appName.toLowerCase + "/web/ext/" + be.name.toLowerCase + "/"+name+"Form.java",
						FormTemplate::generate(appName, be))
				}
				fsa.generateFile(
					"/co/shift/" + appName.toLowerCase + "/web/ext/" + be.name.toLowerCase + "/"+name+"Controller.java",
					WebControllerTemplate::generate(appName, be, associations, fsa))
*///Fin JCifuentes
			}
		}

/*Inicio Jcifuentes (comentado)
		//Esto se cambió al nuevo esquema (contribute) y además se movió arriba
		//Llama a las contribuciones para integridad/autenticidad (lockout y authorization) 
		DomainCodeUtilities.extendContribution(DomainCodeUtilities.VP_INTEGRITY_AUTHENTICITY, DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, appName, authEntity);

		//Llama a las contribuciones para confidencialidad (encriptado, desencriptado)
		DomainCodeUtilities.extendContribution(DomainParams.VP_CONFIDENTIALITY, DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, appName)
*///Fin JCifuentes

/*Inicio Jcifuentes (comentado)		
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
						
		DomainCodeUtilities.runScript(appName)*/ //Fin jcifuentes
		DomainCodeUtilities.endTemplate
		DomainCodeUtilities.finish
	}
}
