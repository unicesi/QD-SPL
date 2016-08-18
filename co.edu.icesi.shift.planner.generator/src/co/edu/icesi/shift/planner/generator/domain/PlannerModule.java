package co.edu.icesi.shift.planner.generator.domain;

import co.edu.icesi.shift.planner.generator.domain.PlannerGenerator;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

public class PlannerModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return "domainmetamodel.presentation.DomainEditorID";
	}

	@Override
	protected String getFileExtensions() {
		return "xmi";
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return PlannerGenerator.class;
	}

	public Class<? extends ResourceSet> bindResourceSet() {
		return ResourceSetImpl.class;
	}

}

