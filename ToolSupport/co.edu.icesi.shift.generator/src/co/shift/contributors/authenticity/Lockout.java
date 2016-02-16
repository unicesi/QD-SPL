package co.shift.contributors.authenticity;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;
import co.shift.generators.domain.DomainCodeUtilities;
import co.shift.templates.database.contributed.authenticity.LockoutScriptTemplate;
import co.shift.templates.ejb.contributed.authenticity.AttemptJPATemplate;
import co.shift.templates.ejb.contributed.authenticity.LockoutTemplate;
import domainmetamodel.BusinessEntity;

public class Lockout implements Contribution {

	@Override
	public String contributeToBusinessInterface(Object... data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String contributeToBusinessImpl(Object... data) {
		String id = (String) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		String txt = "";
		if (DomainCodeUtilities.isQASelected("_r_2_10_12_13")){
			txt = Utilities.toFisrtUpper(be.getName())+"TO to = lockOut.authenticate(e" + Utilities.toFisrtUpper(DomainCodeUtilities.getID(be).getName()) + ", ePassword);" + "\n" +
				"if (to != null) {"  + "\n" +
				"to.set"+Utilities.toFisrtUpper(DomainCodeUtilities.getID(be).getName())+"("+id+");"  + "\n" +
				"to.setPassword(password);"  + "\n" +
				"} return to;";
		}else{
			txt = "return lockOut.authenticate("+be.getName().toLowerCase()+Utilities.toFisrtUpper(DomainCodeUtilities.getID(be).getName()) +", password);";
		}
		return txt;
	}

	@Override
	public String contributeToBusinessImport(Object... data) {
		String packageName = (String) data[0];
		String beName = (String) data[1];
		return "import co.shift." + packageName.toLowerCase() + "."
				+ beName.toLowerCase() + ".control.LockoutManager;";
	}

	@Override
	public String contributeToBusinessAtribute(Object... data) {
		return "@EJB" + "\n" + "private LockoutManager lockOut;";
	}

	@Override
	public String contributeToWebImpl(Object... data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generate(Object... data) {
		IFileSystemAccess fsa = (IFileSystemAccess) data[0];
		String appName = (String) data[1];
		BusinessEntity be = (BusinessEntity) data[2];
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/"
				+ be.getName().toLowerCase() + "/control/LockoutManager.java",
				LockoutTemplate.generate(appName, be));
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/"
				+ be.getName().toLowerCase() + "/entity/Attempt.java",
				AttemptJPATemplate.generate(appName, be));

		// ---------DataBase Script Generation-----------
		fsa.generateFile("/co/shift/" + appName.toLowerCase()
				+ "/web/database/ScriptThree.sql",
				LockoutScriptTemplate.generate(appName, be));
	}

	@Override
	public String contributeToWebImport(Object... data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String contributeToWebAttribute(Object... data) {
		// TODO Auto-generated method stub
		return null;
	}

}
