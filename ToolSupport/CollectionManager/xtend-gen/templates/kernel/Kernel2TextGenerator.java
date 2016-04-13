package templates.kernel;

import kernelmetamodel.Kernel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import templates.kernel.Kernel2Text;

@SuppressWarnings("all")
public class Kernel2TextGenerator implements IGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    String _doGenerate = Kernel2Text.doGenerate(((Kernel) _get));
    fsa.generateFile("src-gen/prueba.java", _doGenerate);
  }
}
