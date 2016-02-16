package co.edu.uniandes.mdspl.util;


import java.io.InputStream;

import javax.xml.parsers.*;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

//JC:import com.sun.resolver.tools.CatalogResolver;
//import com.sun.org.apache.xml.internal.resolver.tools.*;

public class DocumentLoader
{

//JC:	CatalogResolver catalogResolver = new CatalogResolver();


    public Document loadDocumentJAXP(InputStream in) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
//JC:        builder.setEntityResolver(catalogResolver);
        Document document = builder.parse(new InputSource(in));
        document.normalize();
        return document;
    }

}
