package transformations.test;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import domainmetamodel.DomainmetamodelFactory;
import domainmetamodel.DomainmetamodelPackage;
import domainmetamodel.ProblemSpace;
import kernelmetamodel.Kernel;
import transformations.kernel.ProblemSpace2kernel;

public class TestKernelTransformation {

	public static ProblemSpace loadProblemSpace(){
		//Inicializa el modelo
		DomainmetamodelFactory.eINSTANCE.eClass();

		//Para crear el recurso xmi, se requiere un resource factory registrado
		//Se registra el recurso xmi para la extensión .xmi
		//Si el modelo tiene otra extensión, se registra dicha extensión
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		//Registra el package del metamodelo de dominio. Esto evita el error "package with uri * not found"
		EPackage.Registry.INSTANCE.put(DomainmetamodelPackage.eNS_URI, DomainmetamodelPackage.eINSTANCE);
			
		//Crea un nuevo arbol de documentos
		ResourceSet resSet = new ResourceSetImpl();
		//Carga el documento ProblemSpace
		Resource resource = resSet.getResource(URI.createURI("model/ProblemSpace.xmi"), true);
		//Obtiene el primer elemento y lo convierte al tipo ProblemSpace
		ProblemSpace ps = (ProblemSpace)resource.getContents().get(0);
		return ps;
	}
	
	public static void writeKernel(Kernel k){
		//Inicializa el modelo
		//DomainmetamodelFactory.eINSTANCE.eClass();
		//Para crear el recurso xmi, se requiere un resource factory registrado
		//Se registra el recurso xmi para la extensión .xmi
		//Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

		//Se registra el metamodelo
		//EPackage.Registry.INSTANCE.put("domainmetamodel", DomainmetamodelFactory.eINSTANCE);
		//Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

		//Crea un nuevo arbol de documentos
		ResourceSet resSet = new ResourceSetImpl();
		//Crea un documento
		Resource resource = resSet.createResource(URI.createURI("model/Kernel.xmi"));
		//Carga el kernel en el documento
		resource.getContents().add(k);
		//Guarda el contenido
		try{
			resource.save(Collections.EMPTY_MAP);
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Carga el xmi en la clase
		ProblemSpace ps = loadProblemSpace();

		//Crea nueva instancia de la transformación
		ProblemSpace2kernel transformation = new ProblemSpace2kernel();
		
		//Ejecuta la transformación y obtiene el resultado
		Kernel newKernel = transformation.problemSpace2kernel(ps);
		
		//Escribe la clase en un nuevo archivo xmi
		writeKernel(newKernel);
	}

}
