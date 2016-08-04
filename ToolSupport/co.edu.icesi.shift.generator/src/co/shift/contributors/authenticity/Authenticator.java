package co.shift.contributors.authenticity;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;
import co.shift.templates.database.contributed.authenticity.AuthenticatorScriptTemplate;
import co.shift.templates.ejb.contributed.authenticity.AuthImplTemplate;
import co.shift.templates.ejb.contributed.authenticity.AuthInterfaceTemplate;
import co.shift.templates.ejb.contributed.authenticity.AuthJPATemplate;
import co.shift.templates.ejb.contributed.authenticity.AuthTOTemplate;
import co.shift.templates.web.basic.PopUpMasterDetailTemplate;
import co.shift.templates.web.basic.PopUpMasterTemplate;
import co.shift.templates.web.contributed.authenticity.AuthorizerControllerTemplate;
import co.shift.templates.web.contributed.authenticity.AuthorizerFormTemplate;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.DataType;
import domainmetamodel.DomainmetamodelFactory;
import domainmetamodel.DomainmetamodelPackage;

public class Authenticator implements Contribution {

	@Override
	public String contributeToBusinessInterface(Object... data) {
		return "";
	}

	@Override
	public String contributeToBusinessImpl(Object... data) {
		return "";
	}

	@Override
	public String contributeToBusinessImport(Object... data) {
		return "";
	}

	@Override
	public String contributeToBusinessAtribute(Object... data) {
		return "";
	}

	@Override
	public String contributeToWebImpl(Object... data) {
		String service = (String) data[0];
		return "extendProcess(AuthorizerController.ID, \"" + service + "\");";
	}

	@Override
	public void generate(Object... data) {
		IFileSystemAccess fsa = (IFileSystemAccess) data[0];
		String appName = (String) data[1];
		BusinessEntity authBe = (BusinessEntity) data[2];
		//JCifuentes: Se incluye este IF para que esta clase sea responsable de esta validacion
		if(!authBe.isIsAuthenticable()) return;
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/authorization/boundary/IAuthorizationManager.java",
				AuthInterfaceTemplate.generate(appName, authBe));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/authorization/boundary/AuthorizationManager.java",
				AuthImplTemplate.generate(appName, authBe));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/to/RoleTO.java", AuthTOTemplate.generateRoleTO(appName));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/to/ServiceTO.java",
				AuthTOTemplate.generateServiceTO(appName));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/authorization/entity/Role.java",
				AuthJPATemplate.generateRoleEntity(appName, authBe));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/authorization/entity/Service.java",
				AuthJPATemplate.generateServiceEntity(appName));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/entity/"
						+ Utilities.toFisrtUpper(authBe.getName())
						+ "Role.java",
				AuthJPATemplate.generateAuthRoleEntity(appName, authBe));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/entity/"
						+ Utilities.toFisrtUpper(authBe.getName())
						+ "RolePK.java",
				AuthJPATemplate.generateAuthRolePKEntity(appName, authBe));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/web/ext/authorizer/AuthorizerForm.java",
				AuthorizerFormTemplate.generate(appName, authBe));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/web/ext/authorizer/AuthorizerController.java",
				AuthorizerControllerTemplate.generate(appName, authBe));
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/web/ext/authorizer/PopUpRoleForm.java", PopUpMasterTemplate
				.generate(appName, "authorizer", createRole(),
						"AuthorizerController"));
		BusinessEntity role = createRole();
		BusinessEntity service = createService();
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase()
						+ "/web/ext/authorizer/PopUpRoleServiceForm.java",
				PopUpMasterDetailTemplate.generate(
						appName,
						"authorizer",
						role,
						service,
						"AuthorizerController",
						"add" + Utilities.toFisrtUpper(service.getName())
								+ "To" + Utilities.toFisrtUpper(role.getName()),
						"PopUp" + Utilities.toFisrtUpper(role.getName())
								+ Utilities.toFisrtUpper(service.getName()),
								"update"+Utilities.toFisrtUpper(role.getName())+Utilities.toFisrtUpper(service.getName())+"sFormFields"));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase()
						+ "/web/ext/authorizer/PopUp"
						+ Utilities.toFisrtUpper(authBe.getName())
						+ "RoleForm.java", PopUpMasterDetailTemplate.generate(
						appName, "authorizer", authBe, role,
						"AuthorizerController",
						"add" + Utilities.toFisrtUpper(role.getName()) + "To"
								+ Utilities.toFisrtUpper(authBe.getName()),
						"PopUp" + Utilities.toFisrtUpper(authBe.getName())
								+ Utilities.toFisrtUpper(role.getName()),
								"update"+Utilities.toFisrtUpper(authBe.getName())+Utilities.toFisrtUpper(role.getName())+"sFormFields"));
		
		//---------DataBase Script Generation-----------
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/web/database/ScriptTwo.sql",
				AuthenticatorScriptTemplate.generate(appName, authBe));
	}

	private BusinessEntity createRole() {
		@SuppressWarnings("unused")
		DomainmetamodelPackage pack = DomainmetamodelPackage.eINSTANCE;
		DomainmetamodelFactory factory = DomainmetamodelFactory.eINSTANCE;
		BusinessEntity be = factory.createBusinessEntity();
		be.setIsAuthenticable(false);
		be.setName("Role");

		Attribute name = factory.createAttribute();
		name.setName("Name");
		name.setDataType(DataType.STRING);
		name.setIsDefault(true);
		name.setIsRequired(true);

		Attribute desc = factory.createAttribute();
		desc.setName("Description");
		desc.setDataType(DataType.STRING);
		desc.setIsDefault(false);
		desc.setIsRequired(true);
		be.getAttributes().add(name);
		be.getAttributes().add(desc);

		return be;
	}

	private BusinessEntity createService() {
		@SuppressWarnings("unused")
		DomainmetamodelPackage pack = DomainmetamodelPackage.eINSTANCE;
		DomainmetamodelFactory factory = DomainmetamodelFactory.eINSTANCE;
		BusinessEntity be = factory.createBusinessEntity();
		be.setIsAuthenticable(false);
		be.setName("Service");

		Attribute name = factory.createAttribute();
		name.setName("Name");
		name.setDataType(DataType.STRING);
		name.setIsDefault(true);
		name.setIsRequired(true);

		Attribute desc = factory.createAttribute();
		desc.setName("Description");
		desc.setDataType(DataType.STRING);
		desc.setIsDefault(false);
		desc.setIsRequired(true);
		be.getAttributes().add(name);
		be.getAttributes().add(desc);

		return be;
	}

	@Override
	public String contributeToWebImport(Object... data) {
		String appName = (String) data[0];
		return "import co.shift." + appName
				+ ".web.ext.authorizer.AuthorizerController;";
	}

	@Override
	public String contributeToWebAttribute(Object... data) {
		// TODO Auto-generated method stub
		return null;
	}
}
