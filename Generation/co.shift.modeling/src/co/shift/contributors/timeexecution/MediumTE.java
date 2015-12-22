package co.shift.contributors.timeexecution;

import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;

import co.shift.templates.ejb.contributed.mediumTE.FLRImplTemplate;
import co.shift.templates.ejb.contributed.mediumTE.FLRInterfaceTemplate;
import domainmetamodel.Attribute;
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
					+ "\n" + "List<"+Utilities.toFisrtUpper(be.getName())+"TO> list = "+be.getName().toLowerCase()+"Manager."+contract.getName()+"();"
					+ "\n" + ""+Utilities.toFisrtUpper(be.getName())+"Form pF = Registry.get("+Utilities.toFisrtUpper(be.getName())+"Form.ID);"
					+ "\n" + "pF.getTable_1().removeAllItems();"
					+ "\n" + "for ("+Utilities.toFisrtUpper(be.getName())+"TO to : list) {"
					+ "\n" + "Object data[] = { "+atts+" };"
					+ "\n" + "pF.getTable_1().addItem(data, to);"
					+ "\n" + "}"
					+ "\n" + "}";
		} else
			return "public List<"+Utilities.toFisrtUpper(be.getName())+"TO> "+contract.getName()+"() {"
					+ "\n" + "return "+be.getName().toLowerCase()+"Manager."+contract.getName()+"();"
					+ "\n" + "}";
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
	public String contributeToBusinessImport(Object... data) {
		String packageName = (String) data[0];
		String beName = (String) data[1];
		return "import co.shift."+packageName.toLowerCase()+"."+beName.toLowerCase()+".control.I"+Utilities.toFisrtUpper(beName)+"BasicFLR;";
	}

	@Override
	public String contributeToBusinessAtribute(Object... data) {
		String beName = (String) data[0];
		return	"@EJB" + "\n" + 
				"private I"+Utilities.toFisrtUpper(beName)+"BasicFLR basicFLR;";
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
