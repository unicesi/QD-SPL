package templates.test;

import java.io.IOException;
import java.util.Collections;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

import domainmetamodel.DomainmetamodelFactory;
import domainmetamodel.DomainmetamodelPackage;
import domainmetamodel.ProblemSpace;
import guimetamodel.GUI;
import kernelmetamodel.Kernel;
import kernelmetamodel.KernelmetamodelFactory;
import kernelmetamodel.KernelmetamodelPackage;
import templates.kernel.Kernel2Text;
import templates.kernel.Kernel2TextGenerator;
import transformations.gui.ProblemSpace2gui;

public class TestKernel2Text {

    private static InMemoryFileSystemAccess ifsa;

	public static Kernel loadKernel(){
		//Inicializa el modelo
		KernelmetamodelFactory.eINSTANCE.eClass();

		//Para crear el recurso xmi, se requiere un resource factory registrado
		//Se registra el recurso xmi para la extensión .xmi
		//Si el modelo tiene otra extensión, se registra dicha extensión
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		//Registra el package del metamodelo de dominio. Esto evita el error "package with uri * not found"
		EPackage.Registry.INSTANCE.put(KernelmetamodelPackage.eNS_URI, KernelmetamodelPackage.eINSTANCE);
			
		//Crea un nuevo arbol de documentos
		ResourceSet resSet = new ResourceSetImpl();
		//Carga el documento Kernel
		Resource resource = resSet.getResource(URI.createURI("model/Kernel.xmi"), true);
		//Obtiene el primer elemento y lo convierte al tipo Kernel
		Kernel k = (Kernel)resource.getContents().get(0);
		return k;
	}
	
/*	public static void writeText(GUI g){
		//Crea un nuevo arbol de documentos
		ResourceSet resSet = new ResourceSetImpl();
		//Crea un documento
		Resource resource = resSet.createResource(URI.createURI("model/GUI.xmi"));
		//Carga el kernel en el documento
		resource.getContents().add(g);
		//Guarda el contenido
		try{
			resource.save(Collections.EMPTY_MAP);
		} catch(IOException e){
			e.printStackTrace();
		}
	}*/

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IFileSystemAccess ifsa = null;
		//ifsa = IFileSystemAccess.class.newInstance();
		//ifsa = new InMemoryFileSystemAccess();
		//Carga el xmi en la clase
		Kernel k = loadKernel();

		//Crea nueva instancia de la transformación
		System.out.println(Kernel2Text.doGenerate(k));
		//Ejecuta la transformación y obtiene el resultado
		//k2t.doGenerate(r, ifsa);
		
	}

}
