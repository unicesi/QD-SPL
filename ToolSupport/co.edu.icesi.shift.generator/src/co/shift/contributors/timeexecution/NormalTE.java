package co.shift.contributors.timeexecution;

import co.shift.generators.domain.DomainCodeUtilities;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;


public class NormalTE implements Contribution {

	public NormalTE(){
		
	}
	
	@Override
	public String contributeToBusinessInterface(Object ... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		return "public List<" + be.getName() + "TO> "
				+ contract.getName() + "();";
	}

	@Override
	public String contributeToBusinessImpl(Object ... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		return "public List<" + be.getName() + "TO> "
				+ contract.getName() + "() {"
				+ "\n" + "List<" + be.getName() + "TO> "+be.getName().toLowerCase()+"s = new ArrayList<>();"
				+ "\n" + "TypedQuery<"+Utilities.toFisrtUpper(be.getName())+"> query = em.createNamedQuery("
				+ "\n" + "		\""+be.getName().toLowerCase()+"."+contract.getName()+"\", "+Utilities.toFisrtUpper(be.getName())+".class);"
				+ "\n" + "List<"+Utilities.toFisrtUpper(be.getName())+"> found"+Utilities.toFisrtUpper(be.getName())+"s = query.getResultList();"
				+ "\n" + "for ("+Utilities.toFisrtUpper(be.getName())+" "+be.getName().toLowerCase()+" : found"+Utilities.toFisrtUpper(be.getName())+"s) {"
				+ "\n" + ""+Utilities.toFisrtUpper(be.getName())+"TO to = new "+Utilities.toFisrtUpper(be.getName())+"TO();"
				+ "\n" + DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 1)
				+ "\n" + be.getName().toLowerCase()+"s.add(to);" 
				+ "\n" + "}" 
				+ "\n" + "return "+be.getName().toLowerCase()+"s;"
				+ "\n" + "}";
	}

	@Override
	public String contributeToWebImpl(Object ... data) {
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
		// TODO Auto-generated method stub

	}

	@Override
	public String contributeToBusinessImport(Object... data) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String contributeToBusinessAtribute(Object... data) {
		// TODO Auto-generated method stub
		return "";
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
