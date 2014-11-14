package co.shift.contributors.authenticity;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.templates.ejb.contributed.authenticity.AttemptJPATemplate;
import co.shift.templates.ejb.contributed.authenticity.LockoutTemplate;
import domainmetamodel.BusinessEntity;

public class Lockout implements Contribution{

	@Override
	public String contributeToBusinessInterface(Object... data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String contributeToBusinessImpl(Object... data) {
		String id = (String) data[0];
		return "return lockOut.authenticate("+id+", password)";
	}

	@Override
	public String contributeToImport(Object... data) {
		String packageName = (String) data[0];
		String beName = (String) data[1];
		return "import co.shift."+packageName.toLowerCase()+"."+beName.toLowerCase()+".control.LockoutManager;";
	}

	@Override
	public String contributeToAtribute(Object... data) {
		return	"@EJB" + "\n" + 
				"private LockoutManager lockOut;";
	}

	@Override
	public String contributeToWeb(Object... data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generate(Object... data) {
		IFileSystemAccess fsa = (IFileSystemAccess) data[0];
		String appName = (String) data[1];
		BusinessEntity be = (BusinessEntity) data[2];
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/" + be.getName().toLowerCase() + "/control/LockoutManager.java",
				LockoutTemplate.generate(appName, be));
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/" + be.getName().toLowerCase() + "/entity/Attempt.java",
				AttemptJPATemplate.generate(appName, be));
	}

}
