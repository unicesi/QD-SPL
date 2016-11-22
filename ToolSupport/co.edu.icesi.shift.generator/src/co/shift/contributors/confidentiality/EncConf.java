package co.shift.contributors.confidentiality;

import co.shift.generators.domain.DomainCodeGenerator;
import co.shift.generators.domain.DomainCodeUtilities;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.generator.IFileSystemAccess;

import co.shift.contributors.Contribution;
import co.shift.contributors.util.Utilities;

import co.shift.templates.ejb.contributed.confidentiality.PBECryptographyTemplate;
import domainmetamodel.AddElement;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;
import domainmetamodel.Create;
import domainmetamodel.Delete;
import domainmetamodel.DeleteElement;
import domainmetamodel.Simple;
import domainmetamodel.Update;


public class EncConf implements Contribution {

	public EncConf(){
		
	}
	
	@Override
	public String contributeToBusinessInterface(Object ... data) {
		return "";
	}

	@Override
	/**
	 * Este metodo puede mejorar, convirtiéndolo en varios métodos, uno por
	 * cada tipo de contrato, a no ser que todos los contributeToBusinessImpl
	 * manejaran esta estructura... (?)
	 */
	public String contributeToBusinessImpl(Object ... data) {
		Contracts contract = (Contracts) data[0];
		BusinessEntity be = (BusinessEntity) data[1];
		BusinessEntity rBe = (BusinessEntity) data[2];
		String aName = (String) data[3];
		Association asso = (Association) data[4];
		Integer multipleAssociation = (Integer) data[5];
		Boolean isAuth = (Boolean) data[6];
		Integer teVariation = (Integer) data[7];
		
		//Create,Update Contracts
		if (contract instanceof Create || contract instanceof Update) {
			EList<Attribute> attributes = be.getAttributes();
			String text = "";
			for (Attribute attribute : attributes) {
				String name = Utilities.toFisrtUpper(attribute.getName());
				if (attribute.getDataType().getName().equals("string")) {
					text +=	"char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
							"PBECryptographyManager.ENCRYPT, "+be.getName().toLowerCase()+".get"+name+"());" + "\n" +
					"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
					be.getName().toLowerCase()+".set"+name+"(e"+name+");\n";
				}
			}
			return text;
		}
		
		//Detele Contracts
		if (contract instanceof Delete) {
			Attribute id = DomainCodeUtilities.getID(be);
			String name = Utilities.toFisrtUpper(id.getName());
			if (id.getDataType().getName().equals("string")) {
				return "char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, "+be.getName().toLowerCase()+".get"+name+"());" + "\n" +
				"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
				be.getName().toLowerCase()+".set"+name+"(e"+name+");\n";
			}
			return "";
		}
		
		//AddElement,DeleteElement Contracts
		if (contract instanceof AddElement || contract instanceof DeleteElement) {
			String text = "";
			Attribute id = DomainCodeUtilities.getID(be);
			String name = Utilities.toFisrtUpper(id.getName());
			if (id.getDataType().getName().equals("string")) {
				text += "char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, "+be.getName().toLowerCase()+""+name+");" + "\n" +
				"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
				be.getName().toLowerCase()+""+name+" = e"+name+";\n";
			}
			
			Attribute rId = DomainCodeUtilities.getID(rBe);
			String rName = Utilities.toFisrtUpper(rId.getName());
			if (rId.getDataType().getName().equals("string")) {
				text += "char[] e"+rName+"Chars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, "+rBe.getName().toLowerCase()+".get"+rName+"());" + "\n" +
				"String e"+rName+" = new String(e"+rName+"Chars);" + "\n" +
				rBe.getName().toLowerCase()+".set"+rName+"(e"+rName+");\n";
			}
			return text;
		}
		
		//Simple Associations
		if (asso instanceof Simple) {
			String text = "";
			Attribute id = DomainCodeUtilities.getID(be);
			String name = Utilities.toFisrtUpper(id.getName());
			if (id.getDataType().getName().equals("string")) {
				text += "char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, "+be.getName().toLowerCase()+""+name+");" + "\n" +
				"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
				be.getName().toLowerCase()+""+name+" = e"+name+";\n";
			}
			
			Attribute rId = DomainCodeUtilities.getID(rBe);
			String rName = Utilities.toFisrtUpper(rId.getName());
			if (rId.getDataType().getName().equals("string")) {
				text += "char[] e"+rName+"Chars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, "+aName+".get"+rName+"());" + "\n" +
				"String e"+rName+" = new String(e"+rName+"Chars);" + "\n" +
				aName+".set"+rName+"(e"+rName+");\n";
			}
			return text;
		}
		
		//Associations for Detail Entities
		if (multipleAssociation != null && multipleAssociation == 1) {
			Attribute id = DomainCodeUtilities.getID(rBe);
			String name = Utilities.toFisrtUpper(id.getName());
			if (id.getDataType().getName().equals("string")) {
				return "char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, "+rBe.getName().toLowerCase()+""+name+");" + "\n" +
				"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
				rBe.getName().toLowerCase()+""+name+" = e"+name+";\n";
			}
			return "";
		}
		
		//Authorization
		if (isAuth != null && isAuth) {
			String text = "";
			Attribute id = DomainCodeUtilities.getID(be);
			String name = Utilities.toFisrtUpper(id.getName());
			if (id.getDataType().getName().equals("string")) {
				text += "char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, "+be.getName().toLowerCase()+""+name+");" + "\n" +
				"String e"+name+" = new String(e"+name+"Chars);";// + "\n" +
//				be.getName().toLowerCase()+""+name+" = e"+name+";\n";
			}
			
			text += "char[] ePasswordChars = cManager.doFinal(" + "\n" +
						"PBECryptographyManager.ENCRYPT, password);" + "\n" +
				"String ePassword = new String(ePasswordChars);";// + "\n" +
//				"password = ePassword;\n";
			return text;
		}
		
		//NommalTE Variation
		if (teVariation != null && teVariation == 1) {
			EList<Attribute> attributes = be.getAttributes();
			String text = "";
			for (Attribute attribute : attributes) {
				String name = Utilities.toFisrtUpper(attribute.getName());
				if (attribute.getDataType().getName().equals("string")) {
					text +=	"char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
							"PBECryptographyManager.DECRYPT, "+be.getName().toLowerCase()+".get"+name+"());" + "\n" +
					"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
//					be.getName().toLowerCase()+".set"+name+"(e"+name+");\n";
					"to.set"+name+"(e"+name+");\n";
				}else{
					text += "to.set"+name+"("+be.getName().toLowerCase()+".get"+name+"());\n";
				}
			}
			return text;
		}
		
		//MediumTE,FastSyncTE,FastAsyncTE Variations
		if (teVariation != null && teVariation == 2) {
			EList<Attribute> attributes = be.getAttributes();
			String text = "";
			for (Attribute attribute : attributes) {
				String name = Utilities.toFisrtUpper(attribute.getName());
				if (attribute.getDataType().getName().equals("string")) {
					text +=	"char[] e"+name+"Chars = cManager.doFinal(" + "\n" +
					"PBECryptographyManager.DECRYPT, t"+name+");" + "\n" +
					"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
					"t"+name+" = e"+name+";\n";
				}
			}
			return text;
		}
		
		//DAO
		if (teVariation != null && teVariation == 3) {
			EList<Attribute> attributes = be.getAttributes();
			String text = "";
			for (Attribute attribute : attributes) {
				String name = Utilities.toFisrtUpper(attribute.getName());
				if (attribute.getDataType().getName().equals("string")) {
					text +=	"char[] e"+name+"Chars = PBECryptographyManager.doFinal(" + "\n" +
					"PBECryptographyManager.DECRYPT, t"+name+");" + "\n" +
					"String e"+name+" = new String(e"+name+"Chars);" + "\n" +
					"t"+name+" = e"+name+";\n";
				}
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
		IFileSystemAccess fsa = (IFileSystemAccess) data[0];
		String appName = (String) data[1];
		fsa.generateFile("/co/shift/" + appName.toLowerCase() + "/security/PBECryptographyManager.java",
				PBECryptographyTemplate.generate(appName));
	}

	@Override
	public String contributeToBusinessImport(Object... data) {
		String packageName = (String) data[0];
		return "import co.shift."+packageName.toLowerCase()+".security.PBECryptographyManager;\n";
	}

	@Override
	public String contributeToBusinessAtribute(Object... data) {
		return	"@EJB\n" + 
				"private PBECryptographyManager cManager;\n";
	}

	@Override
	public String contributeToWebImport(Object... data) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String contributeToWebAttribute(Object... data) {
		// TODO Auto-generated method stub
		return "";
	}

}
