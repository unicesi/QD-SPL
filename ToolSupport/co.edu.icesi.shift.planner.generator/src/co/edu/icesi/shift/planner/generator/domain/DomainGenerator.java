package co.edu.icesi.shift.planner.generator.domain;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import co.shift.generators.workflows.AbstractGenerator;
import domainmetamodel.Business;




public class DomainGenerator extends AbstractGenerator implements IWorkflowComponent {

	@Override
	public void invoke(IWorkflowContext arg0) {
		Business domainModel = loadDomainMetamodel();
		persistDomainModel(domainModel);
	}

	@Override
	public void postInvoke() {

	}

	@Override
	public void preInvoke() {
		// TODO Auto-generated method stub

	}

	public void persistDomainModel(Business business){
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		
		ResourceSet resSet = new ResourceSetImpl();

		Resource resource = resSet.createResource(URI.createURI("models/ConfiguredModel.xmi"));

		resource.getContents().add(business);

		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
