package co.shift.templates.web.basic;

import co.shift.generators.domain.DomainCodeUtilities;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class MasterWithDetailTemplate {
  public static CharSequence generate(final String appName, final String packageName, final BusinessEntity be, final String controllerName, final BusinessEntity masterBe) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = appName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".web.ext.");
    String _lowerCase_1 = packageName.toLowerCase();
    _builder.append(_lowerCase_1, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import co.shift.");
    String _lowerCase_2 = appName.toLowerCase();
    _builder.append(_lowerCase_2, "");
    _builder.append(".web.");
    String _upperCase = appName.toUpperCase();
    _builder.append(_upperCase, "");
    _builder.append("UI;");
    _builder.newLineIfNotEmpty();
    _builder.append("import co.shift.");
    String _lowerCase_3 = appName.toLowerCase();
    _builder.append(_lowerCase_3, "");
    _builder.append(".web.Registry;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import com.vaadin.annotations.AutoGenerated;");
    _builder.newLine();
    _builder.append("import com.vaadin.data.Property.ValueChangeEvent;");
    _builder.newLine();
    _builder.append("import com.vaadin.data.Property.ValueChangeListener;");
    _builder.newLine();
    _builder.append("import com.vaadin.ui.AbsoluteLayout;");
    _builder.newLine();
    _builder.append("import com.vaadin.ui.Button;");
    _builder.newLine();
    _builder.append("import com.vaadin.ui.Button.ClickEvent;");
    _builder.newLine();
    _builder.append("import com.vaadin.ui.Button.ClickListener;");
    _builder.newLine();
    _builder.append("import com.vaadin.ui.ComboBox;");
    _builder.newLine();
    _builder.append("import com.vaadin.ui.CustomComponent;");
    _builder.newLine();
    _builder.append("import com.vaadin.ui.TextField;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class PopUp");
    String _name = be.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("Form extends CustomComponent {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AutoGenerated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private AbsoluteLayout mainLayout;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AutoGenerated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Button button_2;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@AutoGenerated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Button button_1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    int n = 1;
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes = be.getAttributes();
      for(final Attribute att : _attributes) {
        _builder.append("\t");
        _builder.append("@AutoGenerated");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private TextField textField_");
        int _plusPlus = n++;
        _builder.append(_plusPlus, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static final String ID = \"PopUp");
    String _name_1 = be.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper_1, "\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private ");
    Attribute _iD = DomainCodeUtilities.getID(masterBe);
    String _type = DomainCodeUtilities.getType(_iD);
    _builder.append(_type, "\t");
    _builder.append(" ");
    String _name_2 = masterBe.getName();
    String _lowerCase_4 = _name_2.toLowerCase();
    _builder.append(_lowerCase_4, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    Attribute _iD_1 = DomainCodeUtilities.getID(masterBe);
    String _type_1 = DomainCodeUtilities.getType(_iD_1);
    _builder.append(_type_1, "\t");
    _builder.append(" get");
    String _name_3 = masterBe.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_2, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return ");
    String _name_4 = masterBe.getName();
    String _lowerCase_5 = _name_4.toLowerCase();
    _builder.append(_lowerCase_5, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void set");
    String _name_5 = masterBe.getName();
    String _firstUpper_3 = StringExtensions.toFirstUpper(_name_5);
    _builder.append(_firstUpper_3, "\t");
    _builder.append("(");
    Attribute _iD_2 = DomainCodeUtilities.getID(masterBe);
    String _type_2 = DomainCodeUtilities.getType(_iD_2);
    _builder.append(_type_2, "\t");
    _builder.append(" ");
    String _name_6 = masterBe.getName();
    String _lowerCase_6 = _name_6.toLowerCase();
    _builder.append(_lowerCase_6, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("this.");
    String _name_7 = masterBe.getName();
    String _lowerCase_7 = _name_7.toLowerCase();
    _builder.append(_lowerCase_7, "\t\t");
    _builder.append(" = ");
    String _name_8 = masterBe.getName();
    String _lowerCase_8 = _name_8.toLowerCase();
    _builder.append(_lowerCase_8, "\t\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public PopUp");
    String _name_9 = be.getName();
    String _firstUpper_4 = StringExtensions.toFirstUpper(_name_9);
    _builder.append(_firstUpper_4, "\t");
    _builder.append("Form() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("buildMainLayout();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setCompositionRoot(mainLayout);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_1.addClickListener(new ClickListener() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public void buttonClick(ClickEvent event) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    String _firstUpper_5 = StringExtensions.toFirstUpper(controllerName);
    _builder.append(_firstUpper_5, "\t\t\t\t");
    _builder.append(".getInstance().add");
    String _name_10 = be.getName();
    String _firstUpper_6 = StringExtensions.toFirstUpper(_name_10);
    _builder.append(_firstUpper_6, "\t\t\t\t");
    _builder.append("To");
    String _name_11 = masterBe.getName();
    String _firstUpper_7 = StringExtensions.toFirstUpper(_name_11);
    _builder.append(_firstUpper_7, "\t\t\t\t");
    _builder.append("(");
    String _name_12 = masterBe.getName();
    String _lowerCase_9 = _name_12.toLowerCase();
    _builder.append(_lowerCase_9, "\t\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_2.addClickListener(new ClickListener() {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("public void buttonClick(ClickEvent event) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("clearFormFields();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("((");
    String _upperCase_1 = appName.toUpperCase();
    _builder.append(_upperCase_1, "\t\t\t\t");
    _builder.append("UI) Registry.get(");
    String _upperCase_2 = appName.toUpperCase();
    _builder.append(_upperCase_2, "\t\t\t\t");
    _builder.append("UI.UI)).closeSubWindow();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("});");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    int l = 1;
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_1 = be.getAttributes();
      for(final Attribute att_1 : _attributes_1) {
        _builder.append("\t");
        _builder.append("public TextField getTextField_");
        _builder.append(l, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return textField_");
        int _plusPlus_1 = l++;
        _builder.append(_plusPlus_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    int t = 1;
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void clearFormFields() {");
    _builder.newLine();
    {
      EList<Attribute> _attributes_2 = be.getAttributes();
      for(final Attribute att_2 : _attributes_2) {
        _builder.append("\t\t");
        _builder.append("textField_");
        int _plusPlus_2 = t++;
        _builder.append(_plusPlus_2, "\t\t");
        _builder.append(".setValue(\"\");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    int height = 40;
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_3 = be.getAttributes();
      for(final Attribute att_3 : _attributes_3) {
        _builder.append("\t");
        int _height = height;
        int cc = height = (_height + 40);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("@AutoGenerated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private AbsoluteLayout buildMainLayout() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// common part: create layout");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mainLayout = new AbsoluteLayout();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mainLayout.setImmediate(false);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mainLayout.setWidth(\"200px\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mainLayout.setHeight(\"");
    _builder.append(height, "\t\t");
    _builder.append("px\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// top-level component properties");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setWidth(\"200px\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("setHeight(\"");
    _builder.append(height, "\t\t");
    _builder.append("px\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    int pos = 1;
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    int cPos = 35;
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_4 = be.getAttributes();
      for(final Attribute att_4 : _attributes_4) {
        _builder.append("\t\t");
        _builder.append("// textField_");
        _builder.append(pos, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("textField_");
        _builder.append(pos, "\t\t");
        _builder.append(" = new TextField();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("textField_");
        _builder.append(pos, "\t\t");
        _builder.append(".setCaption(\"");
        String _name_13 = att_4.getName();
        String _firstUpper_8 = StringExtensions.toFirstUpper(_name_13);
        _builder.append(_firstUpper_8, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("textField_");
        _builder.append(pos, "\t\t");
        _builder.append(".setImmediate(false);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("textField_");
        _builder.append(pos, "\t\t");
        _builder.append(".setWidth(\"-1px\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("textField_");
        _builder.append(pos, "\t\t");
        _builder.append(".setHeight(\"-1px\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("textField_");
        _builder.append(pos, "\t\t");
        _builder.append(".setRequired(true);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("mainLayout.addComponent(textField_");
        int _plusPlus_3 = pos++;
        _builder.append(_plusPlus_3, "\t\t");
        _builder.append(", \"top:");
        _builder.append(cPos, "\t\t");
        _builder.append("px;left:20.0px;\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        int _cPos = cPos;
        int cPosP = cPos = (_cPos + 35);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// button_1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_1 = new Button();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_1.setCaption(\"Add\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_1.setImmediate(true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_1.setWidth(\"-1px\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_1.setHeight(\"-1px\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mainLayout.addComponent(button_1, \"top:");
    _builder.append(cPos, "\t\t");
    _builder.append("px;left:24.0px;\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// button_2");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_2 = new Button();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_2.setCaption(\"Cancel\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_2.setImmediate(true);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_2.setWidth(\"-1px\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("button_2.setHeight(\"-1px\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("mainLayout.addComponent(button_2, \"top:");
    _builder.append(cPos, "\t\t");
    _builder.append("px;left:84.0px;\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return mainLayout;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
