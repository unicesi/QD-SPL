package templates.kernel

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.emf.ecore.resource.Resource
import kernelmetamodel.Kernel

class Kernel2TextGenerator implements IGenerator {
	override void doGenerate(Resource resource, IFileSystemAccess fsa){
		fsa.generateFile("src-gen/prueba.java", Kernel2Text::doGenerate(resource.getContents().get(0) as Kernel))
    }
}