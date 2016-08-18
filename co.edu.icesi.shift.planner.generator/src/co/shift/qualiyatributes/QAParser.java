package co.shift.qualiyatributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class QAParser {

	private Document doc;
	private static String qaFullPath;

	public static void setQaFullPath(String s) {
		qaFullPath = s;
	}

	public QAParser() {
		init();
	}

	private void init() {
		// get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			// Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			// parse using builder to get DOM representation of the XML file
			//doc = db.parse(new FileInputStream("models/QAsConfig.xml"));
			doc = db.parse(new FileInputStream(qaFullPath));
			//doc = db.parse(new FileInputStream("/Users/daviddurangiraldo/Dropbox/JulianC/Maestria/201502/FabricasDeSoftware/152/runtime-EclipseApplication/David/models/QAsConfig.xml"));
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}


	//Inicio Jcifuentes
	/**
	 * Return a List<String> with the selected features on the Quality Attributes
	 * model, the features of interest are given in the input parameter 
	 * <code>groupedFeatures</code>.
	 * For example, if the input contains {"_r_1_3_4","_r_1_3_6_7_8"}, the output
	 * would be {"1","0"}, meaning that "_r_1_3_4" is selected and "_r_1_3_6_7_8"
	 * is unselected
	 * 
	 * @return the list of feature values: "1" when selected, "0" otherwise
	 */
	public List<String> getSelectedFeatures(List<String> groupedFeatures) {
		List<String> selectedFeatures = new ArrayList();

		// get the root element
		Element docEle = doc.getDocumentElement();

		// get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName("feature");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// get the feature element
				Element el = (Element) nl.item(i);

				// get the Feature object
				Feature f = getFeature(el);
//				 System.err.println("feature: "+f.getName()+"-"+f.getType());
				//If the feature from model is configured on database, obtain its value
				//e.g., _r_1_3_4 is on database, but _r_1 is not
				if (groupedFeatures.contains(f.getId().toLowerCase()))
					selectedFeatures.add(""+f.getValue());
			}
		}
		return selectedFeatures;
	}
	//Fin Jcifuentes
	
	private Feature getFeature(Element empEl) {

		// for each <feature> element get text or int values of
		// name and value
		String id = empEl.getAttribute("id");
		String name = getTextValue(empEl, "name");
		int value = getIntValue(empEl, "value");
		String type = getTextValue(empEl, "type");

		// Create a new Feature with the value read from the xml nodes
		Feature feature = new Feature(id, name, value, type);

		return feature;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	private int getIntValue(Element ele, String tagName) {
		// in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele, tagName));
	}
}
