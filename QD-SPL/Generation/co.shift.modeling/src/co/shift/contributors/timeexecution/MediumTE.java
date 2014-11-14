package co.shift.contributors.timeexecution;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;

import co.shift.templates.ejb.contributed.mediumTE.FLRImplTemplate;
import co.shift.templates.ejb.contributed.mediumTE.FLRInterfaceTemplate;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;


public class MediumTE implements Contribution {

	public MediumTE() {

	}

	@Override
	public String contributeToBusinessInterface(Object... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		return "public List<" + be.getName() + "TO> "
				+ contract.getName() + "();";
	}

	@Override
	public String contributeToBusinessImpl(Object... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		return "public List<" + be.getName() + "TO> "
				+ contract.getName() + "() {" + "\n" + 
				"try {" + "\n" + 
				"return basicFLR."+contract.getName()+"();" + "\n" + 
				"} catch (Exception e) {" + "\n" +  
				"return null;" + "\n" +  
				"}" + "\n" + 
				"}";
	}

	@Override
	public String contributeToWeb(Object... data) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void generate(Object ... data) {
		IFileSystemAccess fsa = (IFileSystemAccess) data[0];
		String appName = (String) data[1];
		BusinessEntity be = (BusinessEntity) data[2];
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/" + be.getName().toLowerCase() + "/control/I" + be.getName() + "BasicFLR.java",
				FLRInterfaceTemplate.generate(be, appName));
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/" + be.getName().toLowerCase() + "/control/" + be.getName() + "BasicFLR.java",
				FLRImplTemplate.generate(be, appName));
	}

	@Override
	public String contributeToImport(Object... data) {
		String packageName = (String) data[0];
		String beName = (String) data[1];
		return "import co.shift."+packageName.toLowerCase()+"."+beName.toLowerCase()+".control.I"+Utilities.toFisrtUpper(beName)+"BasicFLR;";
	}

	@Override
	public String contributeToAtribute(Object... data) {
		String beName = (String) data[0];
		return	"@EJB" + "\n" + 
				"private I"+Utilities.toFisrtUpper(beName)+"BasicFLR basicFLR;";
	}

}
