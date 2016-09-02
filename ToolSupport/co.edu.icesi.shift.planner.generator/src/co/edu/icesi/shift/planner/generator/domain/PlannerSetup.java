package co.edu.icesi.shift.planner.generator.domain;

import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class PlannerSetup implements ISetup {

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		return Guice.createInjector(new PlannerModule());
	}

}
