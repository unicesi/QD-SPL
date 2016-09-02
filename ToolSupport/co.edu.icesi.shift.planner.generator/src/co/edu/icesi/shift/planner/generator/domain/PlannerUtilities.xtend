package co.edu.icesi.shift.planner.generator.domain

import co.shift.qualiyatributes.QAParser
import com.google.inject.Injector
import domainmetamodel.Association
import domainmetamodel.Attribute
import domainmetamodel.Business
import domainmetamodel.BusinessEntity
import domainmetamodel.Contracts
import domainmetamodel.DeleteElement
import domainmetamodel.Multiple
import domainmetamodel.Simple
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.lang.reflect.InvocationTargetException
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.sql.Connection
import java.sql.DriverManager
import java.util.ArrayList
import java.util.Deque
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.TreeSet
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Result
import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import org.eclipse.core.resources.ResourcesPlugin
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList

import static co.edu.icesi.shift.planner.generator.domain.PlannerUtilities.*
import org.eclipse.emf.ecore.resource.Resource

//import co.edu.icesi.shift.planner.generator.domain.DomainCodeSetup

//import org.eclipse.ui.handlers.HandlerUtil

class PlannerUtilities {
	//Estas variables se establecen desde el plugin o el workflow
	public static String GENERATION_DIR = ""; // = "/Users/daviddurangiraldo/Desktop/"
	public static String SRC_DIR = ""; // = "/Users/daviddurangiraldo/Desktop/"
	public var static Resource rQualityScenario;

	public val final static CONTRIBUTE_TO_BI = "BusinessInterface";
	public val final static CONTRIBUTE_TO_BIMPL = "BusinessImplementation";
	public val final static CONTRIBUTE_TO_WEB_IMPL = "WebImpl";
	public val final static CONTRIBUTE_TO_WEB_ATTRIBUTE = "WebAtt";
	public val final static CONTRIBUTE_TO_WEB_IMPORT = "WebImport";
	public val final static CONTRIBUTE_TO_BUSINESS_IMPORT = "Imports";
	public val final static CONTRIBUTE_TO_BUSINESS_ATTRIBUTE = "Attributes";
	public val final static CONTRIBUTE_TO_GENERATION = "Generate";

//Inicio jcifuentes
// Constante para configuración de QAs por defecto. Esta dependerá en realidad de
// los qas seleccionados por el configurador de qas
// Note: 0: Unselected, 1: Selected
// VP delimited by ";". Variants delimited by ","
// Note: "NormalTE,MediumTE,FastSyncTE,FastAsyncTE;Encrypted,Unencrypted;Authorization,AuthenticLockout"
	//public val final static selectedQAsConfig = "1,0,0,0,1,0,1,1";
	public var static Connection connection;
	public var static Injector injector;
	public var static Deque<String> curTemplate
	public var static Deque<String> curSection
	
	//private var static CURRENT_TEMPLATE = "";
	//private var static CURRENT_SECTION = "";
//	public var static CURRENT_QACONFIG = "";
	
	private var static List<String> featureCodes;
	private var static List<String> featureValues;
//Fin jcifuentes

	private var static HashSet<BusinessEntity> businessEntities;
	private var static TreeSet<String> entityNames;
	private var static TreeSet<String> services;
	private var static List<BusinessEntity[]> manyToMany;


	def static HashSet<BusinessEntity> getBusinessEntities() {
		businessEntities
	}

	def static void addBusinessEntity(BusinessEntity be) {
		businessEntities.add(be)
	}

	def static TreeSet<String> getEntityNames() {
		entityNames
	}

	def static void addEntityName(String name) {
		entityNames.add(name)
	}
	
	def static TreeSet<String> getServices() {
		services
	}

	def static void addService(String name) {
		services.add(name)
	}
	
	def static List<BusinessEntity[]> getManyToManyAssociations() {
		manyToMany
	}

	def static void addManyToManyAssociation(BusinessEntity[] asso) {
		manyToMany.add(asso)
	}

	def static List<Association> getBusinessAssociations(Business b) {
		var List<Association> associations = new ArrayList
		for (be : b.entities) {
			for (a : be.associations) {
				associations.add(a)
			}
		}
		associations
	}

	def static boolean hasRemoveContract(BusinessEntity be, BusinessEntity relBe) {
		for (c : be.contracts) {
			if (c instanceof DeleteElement) {
				var en = c.association.entity;
				if (en.name.equals(relBe.name))
					return true;
			}
		}
		return false;
	}

	def static List<Contracts> getContract(BusinessEntity be, Class contractClass) {
		var List<Contracts> list = new ArrayList<Contracts>()
		for (c : be.contracts) {
			var cName = c.class.name.split("[.]").get(2)
			var cName2 = cName.substring(0, cName.indexOf("Impl"))
			var ccName = contractClass.name.split("[.]").get(1)
			if (cName2.equals(ccName)) {
				list.add(c)
			}
		}
		return list;
	}

	def static Attribute getSecondAttribute(BusinessEntity be) {
		var beId = getID(be)
		for (a : be.attributes) {
			if (!a.name.equals(beId.name))
				return a
		}
		return null
	}

	def static init() {
		val QAParser qas = new QAParser()
		businessEntities = new HashSet
		entityNames = new TreeSet
		services = new TreeSet
		manyToMany = newArrayList()
		//Inicio Jcifuentes
		connection = GetConnection()
//		injector = new DomainCodeSetup().createInjectorAndDoEMFRegistration();
		//Get the feature codes from the database
		featureCodes = getFeatureCodesFromDB()
		//With the feature codes get its values from XML QA config
		//This is necessary because the xml has another features that are not
		//important for us, so we just get the values of our features of interest
		featureValues = qas.getSelectedFeatures(featureCodes)
		curTemplate = newLinkedList()
		curSection = newLinkedList()
		//Fin jcifuentes		
	}

	//Inicio Jcifuentes
    def static beginTemplate(String template){
    	curTemplate.push(template)
    	return ""
    }

    def static endTemplate(){
    	curTemplate.pop()
    	return ""
    }

    def static beginSection(String section){
    	curSection.push(section)
    	return ""
    }

    def static endSection(){
    	curSection.pop()
    	return ""
    }
    
    def static getCurTemplate(){
    	curTemplate.first
    }
    def static getCurSection(){
    	curSection.first
    }

	//Obtiene una conexión MySQL
	def static Connection GetConnection(){
		Class::forName("com.mysql.jdbc.Driver")
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver())
		DriverManager.getConnection("jdbc:mysql://localhost:3306/ReferenceModel", "root","root")
	}

	//Instrucciones finales para finalizar la generación
	def static finish() {
		connection.close()
	}

    /**
     * Get the list of feature codes of the variants configured on the database, like
     * '_r_1_3_4' for NORMAL_TE, and so on.
     * 
     * @return List<String> with the feature codes
     */
    def static getFeatureCodesFromDB(){
    	var featureCodes = new ArrayList<String>
 		var s = connection.createStatement()
 		var rs = s.executeQuery("SELECT DISTINCT A.FEATURE_CODE 
								FROM ReferenceModel.VARIANT A, ReferenceModel.CONFIGURATION_X_VARIANT B
								where A.variant_id = B.VARIANT_ID
								ORDER BY A.VARIANT_ID")
 		while(rs.next()){
 			featureCodes.add(rs.getString(1))
 		}
		return featureCodes;    	
    }


	/**
	 * Determines the contribution for the current template and section.
	 * The contribution can be a new file generation or
	 * a string fragment of code that will be placed on the current template and
	 * section.
	 * If the current user configuration does not correspond with any architect config
	 * on the database, no operation is done
	 */
 	def static String contribute2Template(int sequence, Object... data) {
 		var rules = ""
 		var clasemetodo = ""
		try{
	 		//Obtiene una cadena con la configuracion del usuario
	 		var stringSelectedFeatures = featureValues.toArray.toString.replace(" ", "").replace("[","").replace("]","");
	 		System.err.println("selectedFeatures: "+stringSelectedFeatures);
	
	 		var s = connection.createStatement()
	 		var rs = s.executeQuery("select A.FULL_CLASS_NAME, A.METHOD_NAME
								from ReferenceModel.TEMPL_SECT_CONFIG A
								where A.SEQUENCE ="+sequence+"
								and A.TEMPLATE = '"+getCurTemplate()+"'
								and A.SECTION = '"+getCurSection()+"'
								and A.CONFIGURATION in (
									select CV.CONFIGURATION
									from ReferenceModel.CONFIGURATION_X_VARIANT CV
									group by CV.CONFIGURATION_ID
									having '"+stringSelectedFeatures+"'	like 
													group_concat(selected separator ',') 
									)
								and A.CONFIGURATION not in (
									select CONFIGURATION_B
									from ReferenceModel.CONFIG_IMPACT
									where impact_type = 'EXCLUDE')
								and full_class_name is not null
								and method_name is not null")
	 		//Ejecuta cada fragmento encontrado
	 		while (rs.next()){
	 			//Obtiene el nombre de la clase
			    val cls = Class.forName(rs.getString(1))
				System.err.println("Clase "+rs.getString(1));
			    val obj = cls.newInstance()
			    //Obtiene el nombre del metodo
				System.err.println("Metodo "+rs.getString(2));
				clasemetodo = rs.getString(1)+"."+rs.getString(2)
				
				//System.err.println("Pasó 1");
				//Get the method and set the parameter types
			    val met = cls.getDeclaredMethod(rs.getString(2), {Class.forName("[Ljava.lang.Object;")})
				//Invokes the method passing the parameters (Object[] data)
				//System.err.println("Pasó 2");
				var Object[] datas = newArrayOfSize(1)
				datas.set(0, data)
			    //var result = met.invoke(obj, {data})//why this doesn't work?
				//System.err.println("Pasó 3");
			    var result = met.invoke(obj, datas)
				//System.err.println("Pasó 4");
			    if(result != null)
			    	rules += result.toString
			}
	    }
	    catch(Exception x){
	    	//x.printStackTrace
	    	System.err.println("Error invocando al metodo "+clasemetodo+": "+x.cause.toString)
	    	return ""
	    }
	    return rules
 	}


	
//Fin Jcifuentes


	//  Obtiene el atributo marcado como ID de la entidad
	def static Attribute getID(BusinessEntity be) {
		for (Attribute a : be.attributes.toList) {
			if (a.isDefault == true)
				return a;
		}
		null
	}

	//  Obtiene el tipo de dato en Java del literal
	def static String getType(String literal) {
		if (literal.equals("string"))
			return "String";
		if (literal.equals("date"))
			return "Date";
		if (literal.equals("object"))
			return "Object";
		if (literal.equals("collection"))
			return "List";
		return literal;
	}

	def static String getType(Attribute attribute) {
		val literal = attribute.dataType.literal;
		if (literal.equals("string"))
			return "String";
		if (literal.equals("date"))
			return "Date";
		if (literal.equals("object"))
			return "Object";
		if (literal.equals("collection"))
			return "List";
		return literal;
	}

	def static String getWrapperType(Attribute attribute) {
		val literal = attribute.dataType.literal;
		if (literal.equals("string"))
			return "String";
		if (literal.equals("date"))
			return "Date";
		if (literal.equals("object"))
			return "Object";
		if (literal.equals("collection"))
			return "List";
		if (literal.equals("int"))
			return "Integer";
		if (literal.equals("double"))
			return "Double";
		return literal;
	}

	def static boolean isDetailOf(BusinessEntity be, BusinessEntity relBe) {
		for (ass : relBe.associations) {
			if (ass instanceof Multiple) {
				if (ass.entity.name.equals(be.name))
					return true
			}
		}
		return false
	}

	//  Obtiene todas las asociaciones simples del modelo que relacionan la entidad be
	def static List<Association> getDetailSimpleAssociations(BusinessEntity be, List<Association> list) {
		val List<Association> associations = new ArrayList
		for (a : list) {
			if (a instanceof Simple) {
				if (a.relatedEntity.name.equals(be.name)) {
					associations.add(a)
				}
			}
		}
		associations
	}

	//  Obtiene todas las asociaciones multiples del modelo que relacionan la entidad be
	def static List<Association> getDetailMultipleAssociations(BusinessEntity be, List<Association> list) {
		val List<Association> associations = new ArrayList
		for (a : list) {
			if (a instanceof Multiple) {
				if (a.entity.name.equals(be.name)) {
					associations.add(a)
				}
			}
		}
		associations
	}

	//  Determina si la entidad be tiene asociasiones o no
	def static boolean hasZeroAssociations(BusinessEntity be) {
		be.associations.size == 0;
	}

	def static boolean isMaster(BusinessEntity be) {
		for (ass : be.associations) {
			if (ass instanceof Multiple)
				return true
		}
		return false
	}

	def static String removeAttributeContracts(String c) {
		var changes = ""
		changes = c.replace("int", "");
		changes = changes.replace("double", "");
		changes = changes.replace("char", "");
		changes = changes.replace("String", "");
		changes = changes.replace("Object", "");
		changes = changes.replace("Integer", "");
		changes = changes.replace("Double", "");
		changes = changes.replace("long", "");
		changes = changes.replace("Long", "");
		changes = changes.replace("byte", "");
		changes = changes.replace("Byte", "");

		return changes
	}

	def static String getMySqlEquivalent(String dataType) {
		if (dataType.equals("String"))
			return "VARCHAR(200)"
		if (dataType.equals("int"))
			return "INT"
		if (dataType.equals("Date"))
			return "DATE"
		if (dataType.equals("double"))
			return "DOUBLE"
		return "";
	}

	def static String isMySqlNull(Attribute att) {
		if (att.isIsRequired)
			return "NOT NULL"
		else
			return "NULL"
	}

	private def static boolean isOneToMany(BusinessEntity master, BusinessEntity detail) {
		for (a : master.associations) {
			if (a instanceof Multiple) {
				var relBe = a.entity
				if (relBe.name.equals(detail.name))
					return true
			}
		}
		return false
	}

//	private def static containsRelationship(List<BusinessEntity[]> manyToMany, BusinessEntity[] rel) {
//		for (mTm : manyToMany) {
//			if ((mTm.get(0).name.equals(rel.get(0).name) && mTm.get(1).name.equals(rel.get(1).name)) ||
//				(mTm.get(0).name.equals(rel.get(1).name) && mTm.get(1).name.equals(rel.get(0).name)))
//				return true
//		}
//		return false
//	}
//
//	def static List<BusinessEntity[]> getManyToManyAssociations(HashSet<BusinessEntity> list) {
//		var List<BusinessEntity[]> manyToMany = new ArrayList
//		var i = 0;
//		var j = 0;
//		var size = list.size
//		do {
//			var BusinessEntity a = list.get(i);
//			if (isMaster(a) && i + 1 < size) {
//				j = i + 1;
//				while (j < size) {
//					var BusinessEntity b = list.get(j);
//					if (isMaster(b)) {
//						if (isOneToMany(a, b) && isOneToMany(b, a)) {
//							var List<BusinessEntity> list1 = new ArrayList
//							list1.add(a)
//							list1.add(b)
//							var BusinessEntity[] data = newArrayList()
//							if (!containsRelationship(manyToMany, list1)) {
//								manyToMany.add(list1.toArray(data));
//							}
//						}
//					}
//					j++
//				}
//			}
//			i++
//		} while (i < size);
//
//		return manyToMany;
//	}

	def static void runScript(String packageName) {
		//JC: Se modifica temporalmente porque el valor obtenido aquí no funciona
		//var basePath = System.getProperty("user.dir")
		var basePath = ResourcesPlugin.workspace.root.location.toString+"/../workspace/co.edu.icesi.shift.generator"
		System.err.println("workspace: "+basePath)
		//VaadinProject Generation
		var BufferedWriter rootProjectWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/rootProject.sh")))
		rootProjectWriter.write("#!/bin/bash");
		rootProjectWriter.newLine
		rootProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=1.1")
		rootProjectWriter.flush
		rootProjectWriter.close
		
		//VaadinProject Input
		var BufferedWriter rootProjectInputWriter = new BufferedWriter(new FileWriter(basePath+"/files/rootProjectInput.txt"))
		rootProjectInputWriter.write("co.shift")
		rootProjectInputWriter.newLine
		rootProjectInputWriter.write("co.shift.root")
		rootProjectInputWriter.newLine
		rootProjectInputWriter.newLine
		rootProjectInputWriter.newLine
		rootProjectInputWriter.newLine
		rootProjectInputWriter.flush
		rootProjectInputWriter.close
		
		//VaadinProject Generation
		var BufferedWriter vaadinProjectWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/vaadinProject.sh")))
		vaadinProjectWriter.write("#!/bin/bash");
		vaadinProjectWriter.newLine
		vaadinProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=com.vaadin -DarchetypeArtifactId=vaadin-archetype-application -DarchetypeVersion=7.3.5")
		vaadinProjectWriter.flush
		vaadinProjectWriter.close
		
		//VaadinProject Input
		var BufferedWriter vaadinProjectInputWriter = new BufferedWriter(new FileWriter(basePath+"/files/vaadinProjectInput.txt"))
		vaadinProjectInputWriter.write("co.shift")
		vaadinProjectInputWriter.newLine
		vaadinProjectInputWriter.write("co.shift.web")
		vaadinProjectInputWriter.newLine
		vaadinProjectInputWriter.newLine
		vaadinProjectInputWriter.newLine
		vaadinProjectInputWriter.newLine
		vaadinProjectInputWriter.flush
		vaadinProjectInputWriter.close
		
		//EJB Project Generation
		var BufferedWriter ejbProjectWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/ejbProject.sh")))
		ejbProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=ejb-javaee6 -DarchetypeVersion=1.5")
		ejbProjectWriter.newLine
		ejbProjectWriter.flush
		ejbProjectWriter.close
		
		//EJB Project Input
		var BufferedWriter ejbProjectInputWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/ejbProjectInput.txt")))
		ejbProjectInputWriter.write("co.shift")
		ejbProjectInputWriter.newLine
		ejbProjectInputWriter.write("co.shift.ejb")
		ejbProjectInputWriter.newLine
		ejbProjectInputWriter.newLine
		ejbProjectInputWriter.newLine
		ejbProjectInputWriter.newLine
		ejbProjectInputWriter.flush
		ejbProjectInputWriter.close
		
		//EJB Client Project Generation
		var BufferedWriter ejbCProjectWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/ejbCProject.sh")))
		ejbCProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1")
		ejbCProjectWriter.newLine
		ejbCProjectWriter.flush
		ejbCProjectWriter.close
		
		//EJB Client Project Input
		var BufferedWriter ejbProjectCInputWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/ejbProjectCInput.txt")))
		ejbProjectCInputWriter.write("co.shift")
		ejbProjectCInputWriter.newLine
		ejbProjectCInputWriter.write("co.shift.ejb.api")
		ejbProjectCInputWriter.newLine
		ejbProjectCInputWriter.newLine
		ejbProjectCInputWriter.newLine
		ejbProjectCInputWriter.newLine
		ejbProjectCInputWriter.flush
		ejbProjectCInputWriter.close
		
		//EAR Project Generation
		var BufferedWriter earProjectWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/earProject.sh")))
		earProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=ear-javaee6 -DarchetypeVersion=1.5")
		earProjectWriter.newLine
		earProjectWriter.flush
		earProjectWriter.close
		
		//EAR Project Input
		var BufferedWriter earProjectInputWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/earProjectInput.txt")))
		earProjectInputWriter.write("co.shift")
		earProjectInputWriter.newLine
		earProjectInputWriter.write("co.shift.ear")
		earProjectInputWriter.newLine
		earProjectInputWriter.newLine
		earProjectInputWriter.newLine
		earProjectInputWriter.newLine
		earProjectInputWriter.flush
		earProjectInputWriter.close

		//GenScript composition
		var BufferedWriter genScriptWriter = new BufferedWriter(new FileWriter(new File(basePath+"/files/genScript.sh")))
		genScriptWriter.write("cd "+GENERATION_DIR)
		genScriptWriter.newLine
		basePath = basePath.replace(" ", "\\ ")
		genScriptWriter.write(basePath+"/files/rootProject.sh < "+basePath+"/files/rootProjectInput.txt")	
		genScriptWriter.newLine
		genScriptWriter.write("cd "+GENERATION_DIR + "co.shift.root/")
		genScriptWriter.newLine
		genScriptWriter.write(basePath+"/files/vaadinProject.sh < "+basePath+"/files/vaadinProjectInput.txt")	
		genScriptWriter.newLine
		genScriptWriter.write(basePath+"/files/ejbProject.sh < "+basePath+"/files/ejbProjectInput.txt")	
		genScriptWriter.newLine
		genScriptWriter.write(basePath+"/files/ejbCProject.sh < "+basePath+"/files/ejbProjectCInput.txt")	
		genScriptWriter.newLine
		genScriptWriter.write(basePath+"/files/earProject.sh < "+basePath+"/files/earProjectInput.txt")	
		genScriptWriter.newLine
		genScriptWriter.write("killall Terminal")	
		genScriptWriter.flush
		genScriptWriter.close	
		
		basePath = basePath.replace("\\ ", " ")	
		//Execute genScript
		var scriptPath = basePath + "/files/genScript.sh"
		var List<String> list = new ArrayList
//		list.add("/usr/bin/open")
		list.add("open")
		list.add("-W")
		list.add("-a")
		list.add("Terminal")
		list.add(scriptPath)
		var String[] data = newArrayList()
		var Process p = Runtime.getRuntime().exec(list.toArray(data));
		p.waitFor();

		fixWebPom(GENERATION_DIR +"co.shift.root/co.shift.web/pom.xml")
		fixEARPom(GENERATION_DIR +"co.shift.root/co.shift.ear/pom.xml")
		fixEJBPom(GENERATION_DIR +"co.shift.root/co.shift.ejb/pom.xml")
		fixAPIPom(GENERATION_DIR +"co.shift.root/co.shift.ejb.api/pom.xml")
		
		copySourceCode(packageName)
		mergeDBScripts(packageName)
		System.err.println("Projects Generation Completed")
	}
	
	def private static void fixWebPom(String filePath) {
		// get the factory
		var DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Using factory get an instance of document builder
		var DocumentBuilder db = dbf.newDocumentBuilder();
		// parse using builder to get DOM representation of the XML file
		var Document doc = db.parse(new FileInputStream(filePath));
		var Element docEle = doc.documentElement
		var NodeList nl = docEle.getElementsByTagName("dependencies");
		
		var Element dep = doc.createElement("dependency");
		
		var Element depGI = doc.createElement("groupId");
		depGI.appendChild(doc.createTextNode("co.shift"))
		var Element depAI = doc.createElement("artifactId");
		depAI.appendChild(doc.createTextNode("co.shift.ejb"))
		var Element depV = doc.createElement("version");
		depV.appendChild(doc.createTextNode("1.0-SNAPSHOT"))
		var Element depT = doc.createElement("type");
		depT.appendChild(doc.createTextNode("ejb"))
		var Element depS = doc.createElement("scope");
		depS.appendChild(doc.createTextNode("provided"))
		
		dep.appendChild(depGI)
		dep.appendChild(depAI)
		dep.appendChild(depV)
		dep.appendChild(depT)
		dep.appendChild(depS)
		
		nl.item(0).appendChild(dep)
		
		var Element depGF = doc.createElement("dependency");
		
		var Element depGFGI = doc.createElement("groupId");
		depGFGI.appendChild(doc.createTextNode("javax"))
		var Element depGFAI = doc.createElement("artifactId");
		depGFAI.appendChild(doc.createTextNode("javaee-api"))
		var Element depGFV = doc.createElement("version");
		depGFV.appendChild(doc.createTextNode("6.0"))
		var Element depGFS = doc.createElement("scope");
		depGFS.appendChild(doc.createTextNode("provided"))
		
		depGF.appendChild(depGFGI)
		depGF.appendChild(depGFAI)
		depGF.appendChild(depGFV)
		depGF.appendChild(depGFS)
		
		nl.item(0).appendChild(depGF)
		
		var Element depAPI = doc.createElement("dependency");
		
		var Element depAGI = doc.createElement("groupId");
		depAGI.appendChild(doc.createTextNode("co.shift"))
		var Element depAAI = doc.createElement("artifactId");
		depAAI.appendChild(doc.createTextNode("co.shift.ejb.api"))
		var Element depAV = doc.createElement("version");
		depAV.appendChild(doc.createTextNode("${pom.version}"))
		
		depAPI.appendChild(depAGI)
		depAPI.appendChild(depAAI)
		depAPI.appendChild(depAV)
		
		nl.item(0).appendChild(depAPI)
		
		//Java Version
		var NodeList source = docEle.getElementsByTagName("source");
		source.item(0).textContent = "1.7"
		var NodeList target = docEle.getElementsByTagName("target");
		target.item(0).textContent = "1.7"
		
		writeXML(doc, filePath)
	}
	
	def private static void fixEJBPom(String filePath) {
		// get the factory
		var DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Using factory get an instance of document builder
		var DocumentBuilder db = dbf.newDocumentBuilder();
		// parse using builder to get DOM representation of the XML file
		var Document doc = db.parse(new FileInputStream(filePath));
		var Element docEle = doc.documentElement
		var NodeList nl = docEle.getElementsByTagName("dependencies");
		
		var Element depEL = doc.createElement("dependency");
		
		var Element depGI = doc.createElement("groupId");
		depGI.appendChild(doc.createTextNode("org.eclipse.persistence"))
		var Element depAI = doc.createElement("artifactId");
		depAI.appendChild(doc.createTextNode("eclipselink"))
		var Element depV = doc.createElement("version");
		depV.appendChild(doc.createTextNode("2.4.2"))
		
		depEL.appendChild(depGI)
		depEL.appendChild(depAI)
		depEL.appendChild(depV)
		
		nl.item(0).appendChild(depEL)
		
		var Element depAPI = doc.createElement("dependency");
		
		var Element depAPIGI = doc.createElement("groupId");
		depAPIGI.appendChild(doc.createTextNode("co.shift"))
		var Element depAPIAI = doc.createElement("artifactId");
		depAPIAI.appendChild(doc.createTextNode("co.shift.ejb.api"))
		var Element depAPIV = doc.createElement("version");
		depAPIV.appendChild(doc.createTextNode("1.0-SNAPSHOT"))
		
		depAPI.appendChild(depAPIGI)
		depAPI.appendChild(depAPIAI)
		depAPI.appendChild(depAPIV)
		
		nl.item(0).appendChild(depAPI)
		
		var Element depSec = doc.createElement("dependency");
		
		var Element depSecGI = doc.createElement("groupId");
		depSecGI.appendChild(doc.createTextNode("commons-codec"))
		var Element depSecAI = doc.createElement("artifactId");
		depSecAI.appendChild(doc.createTextNode("commons-codec"))
		var Element depSecV = doc.createElement("version");
		depSecV.appendChild(doc.createTextNode("1.9"))
		
		depSec.appendChild(depSecGI)
		depSec.appendChild(depSecAI)
		depSec.appendChild(depSecV)
		
		nl.item(0).appendChild(depSec)
		
		//Java Version
		var NodeList source = docEle.getElementsByTagName("source");
		source.item(0).textContent = "1.7"
		var NodeList target = docEle.getElementsByTagName("target");
		target.item(0).textContent = "1.7"
		
		writeXML(doc, filePath)
	}
	
	def private static void fixAPIPom(String filePath) {
		// get the factory
		var DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Using factory get an instance of document builder
		var DocumentBuilder db = dbf.newDocumentBuilder();
		// parse using builder to get DOM representation of the XML file
		var Document doc = db.parse(new FileInputStream(filePath));
		var Element docEle = doc.documentElement
		var NodeList nl = docEle.getElementsByTagName("dependencies");
		
		var Element jar = doc.createElement("packaging");
		jar.appendChild(doc.createTextNode("jar"))
		docEle.appendChild(jar)
		
		var Element depGF = doc.createElement("dependency");
		
		var Element depGFGI = doc.createElement("groupId");
		depGFGI.appendChild(doc.createTextNode("javax"))
		var Element depGFAI = doc.createElement("artifactId");
		depGFAI.appendChild(doc.createTextNode("javaee-api"))
		var Element depGFV = doc.createElement("version");
		depGFV.appendChild(doc.createTextNode("6.0"))
		var Element depGFS = doc.createElement("scope");
		depGFS.appendChild(doc.createTextNode("provided"))
		
		depGF.appendChild(depGFGI)
		depGF.appendChild(depGFAI)
		depGF.appendChild(depGFV)
		depGF.appendChild(depGFS)
		
		nl.item(0).appendChild(depGF)
		
		writeXML(doc, filePath)
	}
	
	def private static void fixEARPom(String filePath) {
		// get the factory
		var DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Using factory get an instance of document builder
		var DocumentBuilder db = dbf.newDocumentBuilder();
		// parse using builder to get DOM representation of the XML file
		var Document doc = db.parse(new FileInputStream(filePath));
		var Element docEle = doc.documentElement
		
		var Element dependencies = doc.createElement("dependencies");
		var Element dep = doc.createElement("dependency");
//		var Attr color = doc.createAttribute("Color")
//		color.value = "Blue"
//		var Attr size = doc.createAttribute("Size")
//		color.value = "34"
//		e.attributeNode = color
//		e.attributeNode = size
		
//		e.appendChild(doc.createTextNode("Wtf"))
		var Element depGI = doc.createElement("groupId");
		depGI.appendChild(doc.createTextNode("co.shift"))
		var Element depAI = doc.createElement("artifactId");
		depAI.appendChild(doc.createTextNode("co.shift.ejb"))
		var Element depV = doc.createElement("version");
		depV.appendChild(doc.createTextNode("1.0-SNAPSHOT"))
		var Element depT = doc.createElement("type");
		depT.appendChild(doc.createTextNode("ejb"))
		
		dep.appendChild(depGI)
		dep.appendChild(depAI)
		dep.appendChild(depV)
		dep.appendChild(depT)
		dependencies.appendChild(dep)
		docEle.appendChild(dependencies)
		
		var Element dep2 = doc.createElement("dependency");
		var Element dep2GI = doc.createElement("groupId");
		dep2GI.appendChild(doc.createTextNode("co.shift"))
		var Element dep2AI = doc.createElement("artifactId");
		dep2AI.appendChild(doc.createTextNode("co.shift.ejb.api"))
		var Element dep2V = doc.createElement("version");
		dep2V.appendChild(doc.createTextNode("1.0-SNAPSHOT"))
		var Element dep2T = doc.createElement("type");
		dep2T.appendChild(doc.createTextNode("jar"))
		
		dep2.appendChild(dep2GI)
		dep2.appendChild(dep2AI)
		dep2.appendChild(dep2V)
		dep2.appendChild(dep2T)
		dependencies.appendChild(dep2)
		docEle.appendChild(dependencies)
		
		var NodeList nl = docEle.getElementsByTagName("configuration");
		//plugin with <artifactId>maven-ear-plugin</artifactId>
		var Node earPlugins = nl.item(1)
		
		var Element modules = doc.createElement("modules");
		var Element ejbModule = doc.createElement("ejbModule");
		
		var Element ejbGI = doc.createElement("groupId");
		ejbGI.appendChild(doc.createTextNode("co.shift"))
		var Element ejbAI = doc.createElement("artifactId");
		ejbAI.appendChild(doc.createTextNode("co.shift.ejb"))
		var Element ejbBFN = doc.createElement("bundleFileName");
		ejbBFN.appendChild(doc.createTextNode("co.shift.ejb"))
		
		ejbModule.appendChild(ejbGI)
		ejbModule.appendChild(ejbAI)
		ejbModule.appendChild(ejbBFN)
		modules.appendChild(ejbModule)
		
		var Element jarModule = doc.createElement("jarModule");
		
		var Element jarGI = doc.createElement("groupId");
		jarGI.appendChild(doc.createTextNode("co.shift"))
		var Element jarAI = doc.createElement("artifactId");
		jarAI.appendChild(doc.createTextNode("co.shift.ejb.api"))
		
		jarModule.appendChild(jarGI)
		jarModule.appendChild(jarAI)
		modules.appendChild(jarModule)
		
		earPlugins.appendChild(modules)
		
		writeXML(doc, filePath)
	}

	def private static writeXML(Document document, String filePath){
		 // write the XML document to disk
	
	      // create DOMSource for source XML document
	      var Source xmlSource = new DOMSource(document);
	
	      // create StreamResult for transformation result
	      var Result result = new StreamResult(new FileOutputStream(filePath));
	
	      // create TransformerFactory
	      var TransformerFactory transformerFactory = TransformerFactory.newInstance();
	
	      // create Transformer for transformation
	      var Transformer transformer = transformerFactory.newTransformer();
	
	      transformer.setOutputProperty("indent", "yes");
	
	      // transform and deliver content to client
	      transformer.transform(xmlSource, result);
	}
	
	def private static void copySourceCode(String packageName) {
		//var basePath = System.getProperty("user.dir")+"/src-gen"
		var basePath = SRC_DIR
		//System.err.println("basepath en copysourcecode: "+basePath);
//		var Path source = Paths.get(basePath) 
//		var Path target = Paths.get(GENERATION_DIR+"/co.shift.root/co.shift.ejb/src") 
		
		var File folder = new File(GENERATION_DIR+"/co.shift.root/co.shift.ejb/src/main/java")
		deleteFolder(folder)
//		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)
		
		val Path srcDir = Paths.get(basePath)
		val Path dstDir = Paths.get(GENERATION_DIR+"/co.shift.root/co.shift.ejb/src/main/java")
		Files.walkFileTree(srcDir, new SimpleFileVisitor<Path>() {
		    override public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
		        return copy(file);
		    }
		    override public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) throws IOException {
		        return copy(dir);
		    }
		    def private FileVisitResult copy( Path fileOrDir ) throws IOException {
		        Files.copy( fileOrDir, dstDir.resolve( srcDir.relativize( fileOrDir ) ) );
		        return FileVisitResult.CONTINUE;
		    }
		});

		var File targetFile = new File(GENERATION_DIR+"/co.shift.root/co.shift.ejb/src/main/java")
		deleteFolder(targetFile, "web", true)
		deleteFolder(targetFile, "util", true)
		deleteFolder(targetFile, "/to", true)
		var File interfaces = new File(GENERATION_DIR+"/co.shift.root/co.shift.ejb/src/main/java/")
		deleteInterfaces(interfaces)
		
		var File persistenceOPath = new File(basePath+"/co/shift/"+packageName+"/ejb/persistence/persistence.xml")
		var File persistencePath = new File(GENERATION_DIR+"/co.shift.root/co.shift.ejb/src/main/resources/META-INF/persistence.xml")
		copyFileUsingFileStreams(persistenceOPath, persistencePath)
//JCifuentes: cambio aquí porque meparece que los parametros estan en orden incorrecto
//		copyFileUsingFileStreams(persistencePath, persistenceOPath)
		deleteFolder(targetFile, "/ejb", true)
		
		
		var File folder1 = new File(GENERATION_DIR+"/co.shift.root/co.shift.web/src/main/java")
		deleteFolder(folder1)
		val Path dstDir1 = Paths.get(GENERATION_DIR+"/co.shift.root/co.shift.web/src/main/java")
		Files.walkFileTree(srcDir, new SimpleFileVisitor<Path>() {
		    override public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
		        return copy(file);
		    }
		    override public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) throws IOException {
		        return copy(dir);
		    }
		    def private FileVisitResult copy( Path fileOrDir ) throws IOException {
		        Files.copy( fileOrDir, dstDir1.resolve( srcDir.relativize( fileOrDir ) ) );
		        return FileVisitResult.CONTINUE;
		    }
		});
		
		var File targetFile1 = new File(GENERATION_DIR+"/co.shift.root/co.shift.web/src/main/java/co/shift/"+packageName)
		deleteFolder(targetFile1, "/web:/util", false)
//		deleteFolder(targetFile1, "persistence", true)

		//---
		var File folder2 = new File(GENERATION_DIR+"/co.shift.root/co.shift.ejb.api/src/main/java")
		deleteFolder(folder2)
		
		val Path srcDir2 = Paths.get(basePath)
		val Path dstDir2 = Paths.get(GENERATION_DIR+"/co.shift.root/co.shift.ejb.api/src/main/java")
		Files.walkFileTree(srcDir2, new SimpleFileVisitor<Path>() {
		    override public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
		        return copy(file);
		    }
		    override public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) throws IOException {
		        return copy(dir);
		    }
		    def private FileVisitResult copy( Path fileOrDir ) throws IOException {
		        Files.copy( fileOrDir, dstDir2.resolve( srcDir.relativize( fileOrDir ) ) );
		        return FileVisitResult.CONTINUE;
		    }
		});
		
		var File targetFile2 = new File(GENERATION_DIR+"/co.shift.root/co.shift.ejb.api/src/main/java")
		deleteFolder(targetFile2, "web", true)
		deleteFolder(targetFile2, "util", true)
		deleteFolder(targetFile2, "entity", true)
		deleteFolder(targetFile2, "/ejb", true)
		var File classes = new File(GENERATION_DIR+"/co.shift.root/co.shift.ejb.api/src/main/java")
		deleteClases(classes)
	}
	
	def private static void copyFileUsingFileStreams(File source, File dest)
        throws IOException {
	    var InputStream input = null;
	    var OutputStream output = null;
	    try {
	        input = new FileInputStream(source);
	        output = new FileOutputStream(dest);
	        var byte[] buf = newByteArrayOfSize(1024);
	        var int bytesRead;
	        while ((bytesRead = input.read(buf)) > 0) {
	            output.write(buf, 0, bytesRead);
	        }
	    } finally {
	        input.close();
	        output.close();
	    }
	}
	
	
	def private static void deleteFolder(File folder, String prefix, boolean containsPrefix) {
	    var File[] files = folder.listFiles();
	    var String[] prefixs = prefix.split(":")
	    if(containsPrefix) {
		    if(files!=null) { //some JVMs return null for empty dirs
		        for(File f: files) {
		            if(f.isDirectory()) {
		            	if (f.absolutePath.contains(prefix)) {
		                	deleteFolder(f);
		                } else { 
		                	deleteFolder(f, prefix, containsPrefix)
		               	}
		            } 
		        }
		    }
	    }else{
	    	if(files!=null) { //some JVMs return null for empty dirs
		        for(File f: files) {
		            if(f.isDirectory()) {
		            	if (!f.absolutePath.contains(prefixs.get(0)) && !f.absolutePath.contains(prefixs.get(1))) {
		                	deleteFolder(f);
		                } else { 
		                	deleteFolder(f, prefix, containsPrefix)
		               	}
		            } 
		        }
		    }
	    }
	}
	
	def private static void deleteFolder(File folder) {
	    var File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    folder.delete();
	}
	
	def private static void deleteInterfaces(File folder) {
	    var File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isFile() && f.absolutePath.contains("/I")) {
	                f.delete();
	            } else {
	                deleteInterfaces(f)
	            }
	        }
	    }
	}
	
	def private static void deleteClases(File folder) {
	    var File[] files = folder.listFiles();
	    if(files!=null) { //some JVMs return null for empty dirs
	        for(File f: files) {
	            if(f.isFile() && !f.absolutePath.contains("/to") && !f.absolutePath.contains("/I")) {
	                f.delete();
	            } else {
	                deleteClases(f)
	            }
	        }
	    }
	}
	
	def static void mergeDBScripts(String packageName) {
//		var basePath = System.getProperty("user.dir")+"/src-gen/co/shift/"+packageName+"/web/database"
		var genPath = GENERATION_DIR+"/co.shift.root/co.shift.web/src/main/java/co/shift/"+packageName+"/web/database"
		var File mergedScripts = new File(genPath+"/DBScript.sql")
		var BufferedWriter writter = new BufferedWriter(new FileWriter(mergedScripts))
		var File fileOne = new File(genPath+"/ScriptOne.sql")
		var File fileTwo = new File(genPath+"/ScriptTwo.sql")
		var File fileThree = new File(genPath+"/ScriptThree.sql")
		var File fileFour = new File(genPath+"/InsertsScript.sql")
		copyFile(genPath, fileOne, writter)
		copyFile(genPath, fileTwo, writter)
		copyFile(genPath, fileThree, writter)
		copyFile(genPath, fileFour, writter)
		writter.flush
		writter.close
		fileOne.delete
		fileTwo.delete
		fileThree.delete
		fileFour.delete
	}
	
	def private static void copyFile(String basePath, File file, BufferedWriter writter) {
		if(file.exists) {
			var BufferedReader readOne = new BufferedReader(new FileReader(file))
			var String line = readOne.readLine
			while(line != null) {
				writter.write(line)
				writter.newLine
				line = readOne.readLine
			}
			readOne.close
		}		
	}
	
}
