package co.shift.contributors;

import org.eclipse.xtext.generator.IFileSystemAccess;

public interface Contribution {

	public String contributeToBusinessInterface(Object ... data);

	public String contributeToBusinessImpl(Object ... data);
	
	public String contributeToBusinessImport(Object ... data);
	
	public String contributeToBusinessAtribute(Object ... data);

	public void generate(Object ... data);
	
	public String contributeToWebImport(Object ... data);

	public String contributeToWebAttribute(Object ... data);
	
	public String contributeToWebImpl(Object ... data);
}
