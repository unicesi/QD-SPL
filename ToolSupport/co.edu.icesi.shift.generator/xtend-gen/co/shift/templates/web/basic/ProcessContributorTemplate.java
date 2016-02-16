package co.shift.templates.web.basic;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ProcessContributorTemplate {
  public static CharSequence generate(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".web;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ProcessContributor {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Contributes a process using the specified data (optional).");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param data required by the extension process (optional)");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @throws Exception if there was a problem extending the process");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void contributeProcess(Object data) throws Exception;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
