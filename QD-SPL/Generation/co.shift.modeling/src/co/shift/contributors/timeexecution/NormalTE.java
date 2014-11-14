package co.shift.contributors.timeexecution;

import co.shift.generators.domain.DomainCodeGenerator;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;
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
				+ "\n" + DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 1)
				+ "\n" + be.getName().toLowerCase()+"s.add("+be.getName().toLowerCase()+".toTO());" 
				+ "\n" + "}" 
				+ "\n" + "return "+be.getName().toLowerCase()+"s;"
				+ "\n" + "}";
	}

	@Override
	public String contributeToWeb(Object ... data) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void generate(Object ... data) {
		// TODO Auto-generated method stub

	}

	@Override
	public String contributeToImport(Object... data) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String contributeToAtribute(Object... data) {
		// TODO Auto-generated method stub
		return "";
	}

}
