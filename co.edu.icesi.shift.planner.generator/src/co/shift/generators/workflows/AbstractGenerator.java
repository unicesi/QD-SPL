package co.shift.generators.workflows;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import domainmetamodel.Business;
import domainmetamodel.DomainmetamodelPackage;


public abstract class AbstractGenerator {

	public Business loadDomainMetamodel() {
		// Initialize the domainmetamodel singleton instance
		DomainmetamodelPackage.eINSTANCE.eClass();

		// Register the .domainmetamodel extension in the XMIResourceFactory
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("domainmetamodel", new XMIResourceFactoryImpl());

		// Obtain a new co.edu.uniandes.mdspl.util.resource set
		ResourceSet resSet = new ResourceSetImpl();

		// Get the co.edu.uniandes.mdspl.util.resource
		Resource resource = resSet.getResource(
				URI.createURI("models/ProjectsModel.domainmetamodel"), true);
		Business problemSpace = (Business) resource.getContents()
				.get(0);
		return problemSpace;
	}
}
