package co.shift.generators.domain;

import co.shift.generators.domain.DomainCodeGenerator;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

public class DomainCodeModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return "domainmetamodel.presentation.DomainEditorID";
	}

	@Override
	protected String getFileExtensions() {
		return "xmi";
	}

	public Class<? extends IGenerator> bindIGenerator() {
		return DomainCodeGenerator.class;
	}

	public Class<? extends ResourceSet> bindResourceSet() {
		return ResourceSetImpl.class;
	}

}

