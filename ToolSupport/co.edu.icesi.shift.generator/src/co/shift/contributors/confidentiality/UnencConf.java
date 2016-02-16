package co.shift.contributors.confidentiality;

import org.eclipse.emf.common.util.EList;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;

import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;


public class UnencConf implements Contribution {

	public UnencConf(){
		
	}
	
	@Override
	public String contributeToBusinessInterface(Object ... data) {
		return "";
	}

	@Override
	public String contributeToBusinessImpl(Object ... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		BusinessEntity rBe = (BusinessEntity) data[2];
		String aName = (String) data[3];
		Association asso = (Association) data[4];
		Integer multipleAssociation = (Integer) data[5];
		Boolean isAuth = (Boolean) data[6];
		Integer teVariation = (Integer) data[7];
		
		//NommalTE Variation
		if (teVariation != null && teVariation == 1) {
			EList<Attribute> attributes = be.getAttributes();
			String text = "";
			for (Attribute attribute : attributes) {
				String name = Utilities.toFisrtUpper(attribute.getName());
				text += "to.set"+name+"("+be.getName().toLowerCase()+".get"+name+"());\n";
			}
			return text;
		}
		
		return "";
	}

	@Override
	public String contributeToWebImpl(Object ... data) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void generate(Object ... data) {
		
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
