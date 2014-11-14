package co.shift.generators.domain;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

public class DomainCodeSupport extends AbstractGenericResourceSupport{

	@Override
	protected Module createGuiceModule() {
		return new DomainCodeModule();
	}

}

