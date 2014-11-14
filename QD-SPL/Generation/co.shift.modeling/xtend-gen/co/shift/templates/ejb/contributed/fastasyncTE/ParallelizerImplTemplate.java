package co.shift.templates.ejb.contributed.fastasyncTE;

import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;
import domainmetamodel.ListAll;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class ParallelizerImplTemplate {
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
    _builder.append("import java.util.LinkedList;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.ExecutionException;");
    _builder.newLine();
    _builder.append("import java.util.concurrent.Future;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ejb.EJB;");
    _builder.newLine();
    _builder.append("import javax.ejb.Stateless;");
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
    _builder.append("@Stateless");
    _builder.newLine();
    _builder.append("public class ");
    String _name_2 = be.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper_1, "");
    _builder.append("Parallelizer implements I");
    String _name_3 = be.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_2, "");
    _builder.append("Parallelizer {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@EJB");
    _builder.newLine();
    String _name_4 = be.getName();
    String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper_3, "");
    _builder.append("AsyncWorker worker;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Contracts> _contracts = be.getContracts();
      for(final Contracts contract : _contracts) {
        {
          if ((contract instanceof ListAll)) {
            _builder.append("public List<");
            String _name_5 = be.getName();
            String _firstUpper_4 = StringExtensions.toFirstUpper(_name_5);
            _builder.append(_firstUpper_4, "");
            _builder.append("TO> ");
            String _name_6 = ((ListAll)contract).getName();
            _builder.append(_name_6, "");
            _builder.append("(long pCount) throws Exception {\t\t\t\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("List<Future<List<");
            String _name_7 = be.getName();
            String _firstUpper_5 = StringExtensions.toFirstUpper(_name_7);
            _builder.append(_firstUpper_5, "\t");
            _builder.append("TO>>> futures = new LinkedList<>();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("List<");
            String _name_8 = be.getName();
            String _firstUpper_6 = StringExtensions.toFirstUpper(_name_8);
            _builder.append(_firstUpper_6, "\t");
            _builder.append("TO> ");
            String _name_9 = be.getName();
            String _lowerCase_3 = _name_9.toLowerCase();
            _builder.append(_lowerCase_3, "\t");
            _builder.append("s = new LinkedList<>();");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("int start = 0;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("int maxResults = 1;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("int iterations = (int) (pCount / maxResults);");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("for (int i = 0; i < iterations; i++) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("futures.add(worker.getAll");
            String _name_10 = be.getName();
            String _firstUpper_7 = StringExtensions.toFirstUpper(_name_10);
            _builder.append(_firstUpper_7, "\t\t");
            _builder.append("(start, maxResults));");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("start += maxResults;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("for (Future<List<");
            String _name_11 = be.getName();
            String _firstUpper_8 = StringExtensions.toFirstUpper(_name_11);
            _builder.append(_firstUpper_8, "\t");
            _builder.append("TO>> future : futures) {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("try {");
            _builder.newLine();
            _builder.append("\t\t\t");
            String _name_12 = be.getName();
            String _lowerCase_4 = _name_12.toLowerCase();
            _builder.append(_lowerCase_4, "\t\t\t");
            _builder.append("s.addAll(future.get());");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("} catch (InterruptedException e) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("// TODO Auto-generated catch block");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("e.printStackTrace();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("} catch (ExecutionException e) {");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("// TODO Auto-generated catch block");
            _builder.newLine();
            _builder.append("\t\t\t");
            _builder.append("e.printStackTrace();");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("return ");
            String _name_13 = be.getName();
            String _lowerCase_5 = _name_13.toLowerCase();
            _builder.append(_lowerCase_5, "\t");
            _builder.append("s;");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
