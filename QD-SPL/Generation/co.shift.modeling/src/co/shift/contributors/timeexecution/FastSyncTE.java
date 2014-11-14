package co.shift.contributors.timeexecution;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;

import co.shift.templates.ejb.contributed.fastsyncTE.OptimizedFLRImplTemplate;
import co.shift.templates.ejb.contributed.fastsyncTE.OptimizedFLRInterfaceTemplate;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;


public class FastSyncTE implements Contribution {

	public FastSyncTE() {

	}

	@Override
	public String contributeToBusinessInterface(Object... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		return "public List<" + be.getName() + "TO> "
				+ contract.getName() + "(int start, int maxResults);";
	}

	@Override
	public String contributeToBusinessImpl(Object... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		return "public List<" + be.getName() + "TO> "
				+ contract.getName() + "(int start, int maxResults) {" + "\n" + 
				"try {" + "\n" + 
				"return optimizedFLR."+contract.getName()+"(start, maxResults);" + "\n" + 
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
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/" + be.getName().toLowerCase() + "/control/I" + be.getName() + "OptimizedFLR.java",
				OptimizedFLRInterfaceTemplate.generate(be, appName));
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/" + be.getName().toLowerCase() + "/control/" + be.getName() + "OptimizedFLR.java",
				OptimizedFLRImplTemplate.generate(be, appName));
	}

	@Override
	public String contributeToImport(Object... data) {
		String packageName = (String) data[0];
		String beName = (String) data[1];
		return "import co.shift."+packageName.toLowerCase()+"."+beName.toLowerCase()+".control.I"+Utilities.toFisrtUpper(beName)+"OptimizedFLR;";
	}

	@Override
	public String contributeToAtribute(Object... data) {
		String beName = (String) data[0];
		return	"@EJB" + "\n" + 
				"private I"+Utilities.toFisrtUpper(beName)+"OptimizedFLR optimizedFLR;";
	}

}
