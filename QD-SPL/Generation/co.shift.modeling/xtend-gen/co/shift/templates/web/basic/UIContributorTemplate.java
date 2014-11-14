package co.shift.templates.web.basic;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class UIContributorTemplate {
  public static CharSequence generate(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".web;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.vaadin.ui.Component;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public interface UIContributor {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Contributes new UI elements to the specified component using the specified data (optional).");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param component to be extended");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param data required for the contribution (optional)");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @throws Exception if there was a problem extending the component.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void contributeUITo(Component component, Object data) throws Exception;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
