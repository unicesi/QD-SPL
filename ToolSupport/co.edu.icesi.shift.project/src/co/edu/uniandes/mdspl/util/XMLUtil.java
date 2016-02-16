/**
 * 
 */
package co.edu.uniandes.mdspl.util;

import java.io.InputStream;

import org.w3c.dom.Document;

/**
 * @author AndreS
 * 
 */
public class XMLUtil {

	/**
	 * 
	 */
	public XMLUtil() {
	}

	/**
	 * 
	 * @param xmlFile
	 * @return
	 * @throws Exception
	 */
	public Document loadXML(InputStream in) throws Exception {

		DocumentLoader documentLoader = new DocumentLoader();
		Document loadedDocument = documentLoader.loadDocumentJAXP(in);
		
		return loadedDocument;
	}

}
