package co.edu.icesi.shift.planner.generator.handlers;

import java.io.FileNotFoundException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

import com.google.inject.Injector;

import co.edu.icesi.shift.planner.generator.domain.PlannerSetup;
import co.edu.icesi.shift.planner.generator.domain.PlannerGenerator;
import co.edu.icesi.shift.planner.generator.domain.PlannerUtilities;
import co.shift.qualiyatributes.QAParser;

public class PlannerGeneratorHandler implements IHandler {
/*	@Inject
    DomainCodeGenerator generator;
	@Inject
    IResourceSetProvider resourceSetProvider;
	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;
*/
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	
	/*
	 * Adaptado del generador de QD-SPL. 
	 */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
 	 try{
    	String basePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
   
    	//Obtiene el project
    	ISelection s = HandlerUtil.getCurrentSelection(event);
    	//Si la seleccion no es un elemento de estructura, no hace nada
    	if(!(s instanceof IStructuredSelection)) return null;
    	IStructuredSelection ss = (IStructuredSelection) s;
    	Object firstElement = ss.getFirstElement();
    	//Si el elemento no es un project, no hace nada.
    	if(!(firstElement instanceof IProject)) return null;

		//IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("David");
    	IProject project = (IProject)firstElement;
        IFolder srcGenFolder = project.getFolder("src-gen");
        //DomainCodeUtilities.GENERATION_DIR = "/Users/daviddurangiraldo/Desktop/";
        //Usar PlannerUtilities.GENERATION_DIR = "/Users/daviddurangiraldo/Desktop/generatedPlanner/";
        //DomainCodeUtilities.SRC_DIR = basePath+srcGenFolder.getFullPath().toString();
        PlannerUtilities.SRC_DIR = basePath+srcGenFolder.getFullPath().toString();
        IFile fileD = project.getFile("models/EcommerceCaseStudy.applicabilitymodel");
        IFile fileCS = project.getFile("models/EcommerceCaseStudy.componentsetsmodel");
        
        //Establece la ruta del archivo de qa en el Parser de QAs
//        IFile fileqa = project.getFile("models/xxx.qaconfig");
//        IFile fileQS = project.getFile("models/QScenarioEcommerceInitial.qasvariabilitymodel");
        IFile fileQS = project.getFile("models/QScenarioEcommerceTimeBeh.qasvariabilitymodel");
        //QAParser.setQaFullPath(basePath+fileqa.getFullPath().toString());
        

        //Obtiene el injector Guice (como lo hace en la clase DomainCodeSetup del generador
		Injector injector = new PlannerSetup().createInjectorAndDoEMFRegistration();
//		System.err.println("Pasó 1");
		ResourceSet rs = injector.getInstance(ResourceSet.class);
		Resource rApplicabilityModel = rs.getResource(URI.createPlatformResourceURI(fileD.getFullPath().toString(), true), true);
		//Establece el quality model que será leido durante el proceso de resolución
		PlannerUtilities.rQualityScenario = rs.getResource(URI.createPlatformResourceURI(fileQS.getFullPath().toString(), true), true);

//		System.err.println("Pasó 2 file fullpath: "+file.getFullPath().toString());
		//Con el injector obtiene el fsa, que es uno de los parametros requeridos por el doGenerate
		//final InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
		final JavaIoFileSystemAccess fsa = injector.getInstance(JavaIoFileSystemAccess.class);
//		IOutputConfigurationProvider ocp = injector.getInstance(IOutputConfigurationProvider.class);
	//	Set<OutputConfiguration> outputs = ocp.getOutputConfigurations();
		//Map<String, OutputConfiguration>
		//fsa.setOutputConfigurations(outputs);
		//Configura el output path del fsa
		fsa.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, basePath+srcGenFolder.getFullPath().toString());
//		System.err.println("Pasó 3 outputpath fsa: "+basePath+srcGenFolder.getFullPath().toString());
		
		//Borra los archivos generados con anterioridad
		DirectoryCleaner dc = new DirectoryCleaner();
		dc.setDirectory(basePath+srcGenFolder.getFullPath().toString());

		dc.cleanFolder(basePath+srcGenFolder.getFullPath().toString());
		
		PlannerGenerator generator = injector.getInstance(PlannerGenerator.class);
		
		generator.doGenerate(rApplicabilityModel, fsa);
System.err.println("EJECUTADO EL PLANNER!!");

        return null;
  	  }
	  catch(FileNotFoundException e){
		  System.err.println("Error intentando borrar el directorio: "+e.getMessage());
		  return null;
	  }
	  catch(Exception e){
		  System.err.println("Error no controlado: "+e.getMessage());
		  e.printStackTrace();
		  System.err.println("FIN StackTrace Error no controlado");
		  return null;
	  }
    }

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
