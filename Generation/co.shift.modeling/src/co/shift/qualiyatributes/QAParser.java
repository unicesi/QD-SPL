package co.shift.qualiyatributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import co.shift.contributors.Contribution;


public class QAParser {

	private Document doc;

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
			doc = db.parse(new FileInputStream("models/QAsConfig.xml"));

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public HashMap<String, Contribution> parseSelectedFeatures() {
		HashMap<String, Contribution> selectedFeatures = new HashMap();

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
				if (f.getValue() == 1
						&& ImplMapping.getContributorImpl(f.getId()) != null) {
					selectedFeatures.put(f.getId(),
							ImplMapping.getContributorImpl(f.getId()));
				}
			}
		}
		return selectedFeatures;
	}

	private Feature getFeature(Element empEl) {

		// for each <feature> element get text or int values of
		// name and value
		String id = empEl.getAttribute("id");
		String name = getTextValue(empEl, "name");
		int value = getIntValue(empEl, "value");

		// Create a new Feature with the value read from the xml nodes
		Feature feature = new Feature(id, name, value);

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
