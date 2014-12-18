package co.shift.templates.web.basic;

import co.shift.generators.domain.DomainCodeUtilities;
import java.util.TreeSet;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PersistenceTemplate {
  public static CharSequence generate(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<persistence version=\"2.0\" xmlns=\"http://java.sun.com/xml/ns/persistence\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<persistence-unit name=\"");
    _builder.append(packageName, "\t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<jta-data-source>");
    _builder.append(packageName, "\t\t");
    _builder.append("</jta-data-source>");
    _builder.newLineIfNotEmpty();
    {
      TreeSet<String> _entityNames = DomainCodeUtilities.getEntityNames();
      for(final String name : _entityNames) {
        _builder.append("\t\t");
        _builder.append("<class>");
        _builder.append(name, "\t\t");
        _builder.append("</class>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("</persistence-unit>");
    _builder.newLine();
    _builder.append("</persistence>");
    _builder.newLine();
    return _builder;
  }
}
