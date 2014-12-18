package co.shift.contributors.timeexecution;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;

import co.shift.templates.ejb.contributed.fastsyncTE.OptimizedFLRImplTemplate;
import co.shift.templates.ejb.contributed.fastsyncTE.OptimizedFLRInterfaceTemplate;
import co.shift.templates.web.contributed.syncTE.ListUpdaterTemplate;
import domainmetamodel.Attribute;
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
	public String contributeToWebImpl(Object... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		int opt = (Integer) data[2];
		if (opt == 0) {
			String atts = "";
			int length = be.getAttributes().size();
			int c = 0;
			for(int i = 0; i < length; i++) {
				Attribute a = be.getAttributes().get(i);
				if(c < length - 1)
					atts += "to.get"+Utilities.toFisrtUpper(a.getName())+"(), ";
				else
					atts += "to.get"+Utilities.toFisrtUpper(a.getName())+"()";				
			}
			return "private void listAll"+Utilities.toFisrtUpper(be.getName())+"() {"
					+ "\n" + "List<"+Utilities.toFisrtUpper(be.getName())+"TO> list = null;"
					+ "\n" + "int start = 0, maxResults = 1;"
					+ "\n" + ""+Utilities.toFisrtUpper(be.getName())+"Form pF = Registry.get("+Utilities.toFisrtUpper(be.getName())+"Form.ID);"
					+ "\n" + "pF.getTable_1().removeAllItems();"
					+ "\n" + "do {"
					+ "\n" + "list = "+be.getName().toLowerCase()+"Manager."+contract.getName()+"(start, maxResults);"
					+ "\n" + "new "+Utilities.toFisrtUpper(be.getName())+"ListUpdater(pF, list).start();"
					+ "\n" + "start += maxResults;"
					+ "\n" + "} while (list.size() > 0);"
					+ "\n" + "}";
		} else
			return "public List<"+Utilities.toFisrtUpper(be.getName())+"TO> "+contract.getName()+"() {"
					+ "\n" + "List<"+Utilities.toFisrtUpper(be.getName())+"TO> list = new ArrayList<>();"
					+ "\n" + "int start = 0, maxResults = 1, size = 0;"
					+ "\n" + ""+Utilities.toFisrtUpper(be.getName())+"Form pF = Registry.get("+Utilities.toFisrtUpper(be.getName())+"Form.ID);"
					+ "\n" + "pF.getTable_1().removeAllItems();"
					+ "\n" + "do {"
					+ "\n" + "List<"+Utilities.toFisrtUpper(be.getName())+"TO> aux = "+be.getName().toLowerCase()+"Manager."+contract.getName()+"(start, maxResults);"
					+ "\n" + "size = aux.size();"
					+ "\n" + "list.addAll(aux);"
					+ "\n" + "start += maxResults;"
					+ "\n" + "} while (size > 0);"
					+ "\n" + "return list;"
					+ "\n" + "}";
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
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/web/ext/" + be.getName() + "/" + be.getName() + "ListUpdater.java",
				ListUpdaterTemplate.generate(be, appName));
	}

	@Override
	public String contributeToBusinessImport(Object... data) {
		String packageName = (String) data[0];
		String beName = (String) data[1];
		return "import co.shift."+packageName.toLowerCase()+"."+beName.toLowerCase()+".control.I"+Utilities.toFisrtUpper(beName)+"OptimizedFLR;";
	}

	@Override
	public String contributeToBusinessAtribute(Object... data) {
		String beName = (String) data[0];
		return	"@EJB" + "\n" + 
				"private I"+Utilities.toFisrtUpper(beName)+"OptimizedFLR optimizedFLR;";
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
