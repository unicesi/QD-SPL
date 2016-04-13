package templates.kernel;

import kernelmetamodel.Element;
import kernelmetamodel.Kernel;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Kernel2Text {
  public static String doGenerate(final Kernel k) {
    String _xblockexpression = null;
    {
      kernelmetamodel.System _system = k.getSystem();
      final String systemName = _system.getName();
      kernelmetamodel.System _system_1 = k.getSystem();
      Element _element = _system_1.getElement();
      final String elementName = _element.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package unicesi.driso.");
      String _lowerCase = systemName.toLowerCase();
      _builder.append(_lowerCase, "");
      _builder.append(".kernel;");
      _builder.newLineIfNotEmpty();
      _builder.append("import java.util.observable;");
      _builder.newLine();
      _builder.append("...");
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(systemName, "");
      _builder.append(" extends Observable{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
