package co.shift.contributors;

import org.eclipse.xtext.generator.IFileSystemAccess;

public interface Contribution {

	public String contributeToBusinessInterface(Object ... data);

	public String contributeToBusinessImpl(Object ... data);
	
	public String contributeToImport(Object ... data);
	
	public String contributeToAtribute(Object ... data);

	public String contributeToWeb(Object ... data);

	public void generate(Object ... data);
}
