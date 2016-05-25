package co.edu.icesi.shift.generator.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import co.shift.generators.domain.DomainCodeGenerator;
import co.shift.generators.domain.DomainCodeModule;
import co.shift.generators.domain.DomainCodeSetup;
import co.shift.generators.domain.DomainCodeSupport;
import co.shift.generators.domain.DomainCodeUtilities;
import co.shift.generators.domain.DomainGenerator;
import co.shift.generators.workflows.AbstractGenerator;
import co.shift.qualiyatributes.QAParser;
import domainmetamodel.Business;

import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class WorkflowHandler implements IHandler {
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

	//Versión inicial del execute que intenta ejecutar el workflow WF.mwe2
/*	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		//IProject project = root.getProject("prueba2");
		

		//org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher launcher = new Mwe2Launcher();
		//String[] args = {root.getLocation().toOSString()+"/prueba2/src/co/shift/generators/workflows/WF.mwe2"};
		//String[] args = new String[]{"classpath:/co.edu.icesi.shift.generator/src/co/shift/generators/workflows/WF.mwe2"};
		URL wfhandlerlocation = co.shift.generators.workflows.AbstractGenerator.class.getProtectionDomain().getCodeSource().getLocation();
		System.err.println(wfhandlerlocation.toString());
		//String[] args = new String[]{wfhandlerlocation.toString()+"src/co/shift/generators/workflows/WF.mwe2"}; // ejecuta el wf de este eclipse
		String[] args = new String[]{"/David/src/WF.mwe2"};//Ejecuta el wf del eclipse que está ejecutándose
		//String[] args = {"co.shift.generators.workflows.WF.mwe2"};
		//String[] args = {"generators.workflows.WF.mwe2"};
		
		//MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Generar Enterprise APP", "opción ejecutada: Mwe2Launcher "+args[0]);
		//IQualifiedNameConverter. 
		new org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher().run(args);
		//new org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher().run(URI.createURI("classpath:src/co/shift/generators/workflows/WF.mwe2"));
		System.err.println("EJECUTADO EL WF!!");

		return null;
	}*/
	
	/*
	 * Este método ha sido desarrollado debido a las dificultades técnicas intentando ejecutar directamente
	 * el workflow. El método lleva a cabo los pasos del workflow, reemplazando su ejecución. 
	 */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
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
        DomainCodeUtilities.GENERATION_DIR = "/Users/daviddurangiraldo/Desktop/";
        DomainCodeUtilities.SRC_DIR = basePath+srcGenFolder.getFullPath().toString();
//        IFile file = project.getFile("models/ConfiguredModel.xmi");
        IFile file = project.getFile("models/ProjectsModel.domainmetamodel");
        
        //Establece la ruta del archivo de qa en el Parser de QAs
        IFile fileqa = project.getFile("models/QAsConfig.xml");
        QAParser.setQaFullPath(basePath+fileqa.getFullPath().toString());
        

        //Obtiene el injector Guice (como lo hace en la clase DomainCodeSetup del generador
		Injector injector = new DomainCodeSetup().createInjectorAndDoEMFRegistration();
//		System.err.println("Pasó 1");
		ResourceSet rs = injector.getInstance(ResourceSet.class);
		Resource r = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
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
		try{
			dc.cleanFolder(basePath+srcGenFolder.getFullPath().toString());
		}
		catch(FileNotFoundException e){
			System.err.println("Error intentando borrar el directorio: "+e.getMessage());
		}
		
		DomainCodeGenerator generator = injector.getInstance(DomainCodeGenerator.class);
		
		generator.doGenerate(r, fsa);
System.err.println("EJECUTADO EL WF!!");

        return null;
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
	//org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher src/co/shift/generators/workflows/WF.mwe2

}
