package co.shift.contributors.authenticity;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;
import co.shift.templates.ejb.contributed.authenticity.AuthImplTemplate;
import co.shift.templates.ejb.contributed.authenticity.AuthInterfaceTemplate;
import co.shift.templates.ejb.contributed.authenticity.AuthJPATemplate;
import co.shift.templates.ejb.contributed.authenticity.AuthTOTemplate;
import domainmetamodel.BusinessEntity;


public class Authenticator implements Contribution{

	@Override
	public String contributeToBusinessInterface(Object... data) {
		return "";
	}

	@Override
	public String contributeToBusinessImpl(Object... data) {
		return "";
	}

	@Override
	public String contributeToImport(Object... data) {
		return "";
	}

	@Override
	public String contributeToAtribute(Object... data) {
		return "";
	}

	@Override
	public String contributeToWeb(Object... data) {
		return "";
	}

	@Override
	public void generate(Object... data) {
		IFileSystemAccess fsa = (IFileSystemAccess) data[0];
		String appName = (String) data[1];
		BusinessEntity authBe = (BusinessEntity) data[2];
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/boundary/IAuthorizationManager.java",
				AuthInterfaceTemplate.generate(appName, authBe));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/boundary/AuthorizationManager.java",
				AuthImplTemplate.generate(appName, authBe));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/to/RoleTO.java",
				AuthTOTemplate.generateRoleTO(appName));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/to/ServiceTO.java",
				AuthTOTemplate.generateServiceTO(appName));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/entity/Role.java",
				AuthJPATemplate.generateRoleEntity(appName, authBe));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/entity/Service.java",
				AuthJPATemplate.generateServiceEntity(appName));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/entity/"+Utilities.toFisrtUpper(authBe.getName())+"Role.java",
				AuthJPATemplate.generateAuthRoleEntity(appName, authBe));
		fsa.generateFile(
				"/co/shift/" + appName.toLowerCase() + "/authorization/entity/"+Utilities.toFisrtUpper(authBe.getName())+"RolePK.java",
				AuthJPATemplate.generateAuthRolePKEntity(appName, authBe));
	}

}
