/**
 * 
 */
package co.edu.uniandes.mdspl.util.resource;

import java.io.InputStream;
import java.util.ArrayList;


import org.apache.xpath.XPathAPI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import co.edu.uniandes.mdspl.util.XMLUtil;

/**
 * @author AndreS
 *
 */
public class ProjectStrutureLoader {

	//public static final String FILE_NAME = "src/project_structure.xml";
	public static final String FILE_NAME = "project_structure.xml";
	
	private Document document;
	
	/**
	 * @throws Exception 
	 * 
	 */
	public ProjectStrutureLoader(InputStream in) throws Exception {
		document = null;
		loadDocument(in);
	}
	
	private void loadDocument(InputStream in) throws Exception{
		XMLUtil util = new XMLUtil();
		document = util.loadXML(in);
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] getNatures() throws Exception{
		String xpath = "//nature";
		return getTexts(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] getBuildCommands() throws Exception{
		String xpath = "//buildCommand/name";
		return getTexts(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] getLibJars() throws Exception{
		String xpath = "//jar";
		return getTexts(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] getFolders() throws Exception{
		String xpath = "//folder";
		return getTexts(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] getSourceFolders() throws Exception{
		String xpath = "//sourcefolder";
		return getTexts(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getOutputFolder() throws Exception{
		String xpath = "//outputfolder/text()";
		return getTextValue(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] getContainerLibraries() throws Exception{
		String xpath = "//container";
		return getTexts(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String[] getLibraries() throws Exception{
		String xpath = "//lib";
		return getTexts(xpath);
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public File[] getFiles() throws Exception{
		String xpath = "//file";

		ArrayList<File> list = new ArrayList<File>();  
		
		NodeList nodes = XPathAPI.selectNodeList(document, xpath);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element)node;
				
				File file = new File(element.getAttribute("src"),element.getAttribute("dst"),element.getAttribute("support"));
				list.add(file);
			}
		}
		
		File[] fils = new File[list.size()];
		list.toArray(fils);
		return fils;
	}
	
	/**
	 * 
	 * @param xpathExpression
	 * @return
	 * @throws Exception
	 */
	public String getTextValue(String xpathExpression)throws Exception{
		Text node = (Text)XPathAPI.selectNodeList(document, xpathExpression).item(0);
		return node.getNodeValue();
	}
	
	/**
	 * 
	 * @param xpathExpression
	 * @return
	 * @throws Exception
	 */
	public String[] getTexts(String xpathExpression)throws Exception{
		ArrayList<String> list = new ArrayList<String>();  
		
		NodeList nodes = XPathAPI.selectNodeList(document, xpathExpression);
		for (int i = 0; i < nodes.getLength(); i++) {
			Node nodeNature = nodes.item(i);
			Node nodeText = nodeNature.getFirstChild();
			
			if(nodeText.getNodeType() == Node.TEXT_NODE){
				Text nature = (Text)nodeText;
				list.add(nature.getNodeValue());
			}
		}
		
		String[] texts = new String[list.size()];
		list.toArray(texts);
		return texts;
	}
}
