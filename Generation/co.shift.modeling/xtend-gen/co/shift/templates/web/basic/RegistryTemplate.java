package co.shift.templates.web.basic;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class RegistryTemplate {
  public static CharSequence generate(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".web;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.HashMap;");
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Registry implementation class.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public class Registry {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Default constructor.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Registry() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Map where the objects are stored.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static Map<String, Object> map = new HashMap<>();");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Returns the object with the given id.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param key");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*            the identifier");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @return the object or <code>null</code> if no match");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@SuppressWarnings(\"unchecked\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static <X> X get(String key) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return (X) map.get(key);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Returns a map of all registered objects.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @return the object map");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static Map<String, Object> getAll() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return map;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Registers an object.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param key");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*            the identifier");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param value");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*            the object to be registered");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void register(String key, Object value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("map.put(key, value);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Unregisters an object.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param key");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*            the identifier");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void unregister(String key) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("map.remove(key);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Unregisters all registered objects.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void unregisterAll() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("map.clear();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
