package co.shift.templates.ejb.contributed.fastsyncTE;

import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;
import domainmetamodel.ListAll;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class OptimizedFLRInterfaceTemplate {
  public static CharSequence generate(final BusinessEntity be, final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".");
    String _name = be.getName();
    String _lowerCase_1 = _name.toLowerCase();
    _builder.append(_lowerCase_1, "");
    _builder.append(".control;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import javax.ejb.Remote;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import co.shift.");
    String _lowerCase_2 = packageName.toLowerCase();
    _builder.append(_lowerCase_2, "");
    _builder.append(".to.");
    String _name_1 = be.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("TO;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@Remote");
    _builder.newLine();
    _builder.append("public interface I");
    String _name_2 = be.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper_1, "");
    _builder.append("OptimizedFLR {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Contracts> _contracts = be.getContracts();
      for(final Contracts contract : _contracts) {
        {
          if ((contract instanceof ListAll)) {
            _builder.append("public List<");
            String _name_3 = be.getName();
            String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
            _builder.append(_firstUpper_2, "");
            _builder.append("TO> ");
            String _name_4 = ((ListAll)contract).getName();
            _builder.append(_name_4, "");
            _builder.append("(int start, int maxResults) throws Exception;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
