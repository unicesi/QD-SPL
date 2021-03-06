package co.shift.generators.domain

import java.util.HashMap
import co.shift.contributors.Contribution
import java.util.List
import domainmetamodel.BusinessEntity
import domainmetamodel.Multiple
import java.util.ArrayList
import domainmetamodel.Association
import domainmetamodel.Simple
import domainmetamodel.Attribute
import domainmetamodel.Business
import co.shift.qualiyatributes.QAParser
import domainmetamodel.DeleteElement
import domainmetamodel.Contracts
import java.util.HashSet
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.DocumentBuilder
import java.io.FileInputStream
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.NodeList
import org.w3c.dom.Node
import org.w3c.dom.Attr
import javax.xml.transform.Source
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.Result
import javax.xml.transform.stream.StreamResult
import java.io.FileOutputStream
import javax.xml.transform.TransformerFactory
import javax.xml.transform.Transformer
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.nio.file.SimpleFileVisitor
import java.nio.file.FileVisitResult
import java.nio.file.attribute.BasicFileAttributes
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.TreeSet
import java.io.BufferedReader
import java.io.FileReader

class DomainCodeUtilities {
	
	private val final static GENERATION_DIR = "/Users/daviddurangiraldo/Desktop/"

	public val final static CONTRIBUTE_TO_BI = "BusinessInterface";
	public val final static CONTRIBUTE_TO_BIMPL = "BusinessImplementation";
	public val final static CONTRIBUTE_TO_WEB_IMPL = "WebImpl";
	public val final static CONTRIBUTE_TO_WEB_ATTRIBUTE = "WebAtt";
	public val final static CONTRIBUTE_TO_WEB_IMPORT = "WebImport";
	public val final static CONTRIBUTE_TO_BUSINESS_IMPORT = "Imports";
	public val final static CONTRIBUTE_TO_BUSINESS_ATTRIBUTE = "Attributes";
	public val final static CONTRIBUTE_TO_GENERATION = "Generate";

	private var static HashMap<String, Contribution> selectedContributors;
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
		selectedContributors = qas.parseSelectedFeatures
		businessEntities = new HashSet
		entityNames = new TreeSet
		services = new TreeSet
		manyToMany = newArrayList()
	}

	def static String extendContribution(String id, String phase, Object ... data) {

		val List<Contribution> contributors = getSelectedVariants(id)
		var String rules = ""

		if (phase.equals(CONTRIBUTE_TO_BI)) {
			for (c : contributors) {
				rules += c.contributeToBusinessInterface(data) + "\n\n"
			}
		}
		if (phase.equals(CONTRIBUTE_TO_BIMPL)) {
			for (c : contributors) {
				rules += c.contributeToBusinessImpl(data) + "\n\n"
			}
		}
		if (phase.equals(CONTRIBUTE_TO_WEB_IMPORT)) {
			for (c : contributors) {
				rules += c.contributeToWebImport(data) + "\n\n"
			}
		}
		if (phase.equals(CONTRIBUTE_TO_WEB_ATTRIBUTE)) {
			for (c : contributors) {
				rules += c.contributeToWebAttribute(data) + "\n\n"
			}
		}
		if (phase.equals(CONTRIBUTE_TO_WEB_IMPL)) {
			for (c : contributors) {
				rules += c.contributeToWebImpl(data) + "\n\n"
			}
		}
		if (phase.equals(CONTRIBUTE_TO_BUSINESS_ATTRIBUTE)) {
			for (c : contributors) {
				rules += c.contributeToBusinessAtribute(data) + "\n\n"
			}
		}
		if (phase.equals(CONTRIBUTE_TO_BUSINESS_IMPORT)) {
			for (c : contributors) {
				rules += c.contributeToBusinessImport(data) + "\n\n"
			}
		}
		if (phase.equals(CONTRIBUTE_TO_GENERATION)) {
			for (c : contributors) {
				c.generate(data);
			}
		}

		return rules
	}

	public def static boolean isQASelected(String prefixId) {
		val i = selectedContributors.keySet.iterator
		while (i.hasNext) {
			val c = i.next
			if (c.equals(prefixId))
				return true
		}
		return false
	}

	private def static List<Contribution> getSelectedVariants(String variationPointPrefix) {
		val List<Contribution> foundVariants = new ArrayList
		val i = selectedContributors.keySet.iterator
		while (i.hasNext) {
			val c = i.next
			if (c.startsWith(variationPointPrefix))
				foundVariants.add(selectedContributors.get(c))
		}
		foundVariants
	}

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
		var basePath = System.getProperty("user.dir")
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
		var basePath = System.getProperty("user.dir")+"/src-gen"
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
