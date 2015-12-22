package co.shift.templates.web.basic;

import co.shift.generators.domain.DomainCodeUtilities;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import java.util.HashSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class UIControllerTemplate {
  public static CharSequence generate(final String packageName, final BusinessEntity authEntity, final HashSet<BusinessEntity> bes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".web;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.vaadin.ui.Component;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import co.shift.");
    String _lowerCase_1 = packageName.toLowerCase();
    _builder.append(_lowerCase_1, "");
    _builder.append(".web.ext.authenticator.LoginController;");
    _builder.newLineIfNotEmpty();
    _builder.append("import co.shift.");
    String _lowerCase_2 = packageName.toLowerCase();
    _builder.append(_lowerCase_2, "");
    _builder.append(".web.client.MenuPanel;");
    _builder.newLineIfNotEmpty();
    _builder.append("import co.shift.");
    String _lowerCase_3 = packageName.toLowerCase();
    _builder.append(_lowerCase_3, "");
    _builder.append(".to.");
    String _name = authEntity.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("TO;");
    _builder.newLineIfNotEmpty();
    boolean e = bes.add(authEntity);
    _builder.newLineIfNotEmpty();
    {
      for(final BusinessEntity be : bes) {
        _builder.append("import co.shift.");
        String _lowerCase_4 = packageName.toLowerCase();
        _builder.append(_lowerCase_4, "");
        _builder.append(".web.ext.");
        String _name_1 = be.getName();
        String _lowerCase_5 = _name_1.toLowerCase();
        _builder.append(_lowerCase_5, "");
        _builder.append(".");
        String _name_2 = be.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
        _builder.append(_firstUpper_1, "");
        _builder.append("Controller;");
        _builder.newLineIfNotEmpty();
      }
    }
    boolean authorizerSelected = DomainCodeUtilities.isQASelected("_r_2_11_15_16");
    _builder.newLineIfNotEmpty();
    {
      if (authorizerSelected) {
        _builder.append("import co.shift.");
        String _lowerCase_6 = packageName.toLowerCase();
        _builder.append(_lowerCase_6, "");
        _builder.append(".web.ext.authorizer.AuthorizerController;");
        _builder.newLineIfNotEmpty();
        _builder.append("import co.shift.");
        String _lowerCase_7 = packageName.toLowerCase();
        _builder.append(_lowerCase_7, "");
        _builder.append(".to.ServiceTO;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class UIController implements UIContributor {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static UIController controller;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private UIController() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("init();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private void init() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/********** Controller Instantiation ***********/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LoginController.getInstance().showLoginForm();");
    _builder.newLine();
    _builder.newLine();
    {
      for(final BusinessEntity be_1 : bes) {
        _builder.append("\t\t");
        String _name_3 = be_1.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
        _builder.append(_firstUpper_2, "\t\t");
        _builder.append("Controller.getInstance();");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      if (authorizerSelected) {
        _builder.append("\t\t");
        _builder.append("AuthorizerController authController = AuthorizerController");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t");
        _builder.append(".getInstance();");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("/********** Contributors Configuration ***********/");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// Adds menu UI contributor to Login");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("LoginController.getInstance().addContributor(this);");
    _builder.newLine();
    _builder.newLine();
    {
      if (authorizerSelected) {
        _builder.append("\t\t");
        _builder.append("// Adds authorization check for every action");
        _builder.newLine();
        {
          for(final BusinessEntity be_2 : bes) {
            _builder.append("\t\t");
            String _name_4 = be_2.getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
            _builder.append(_firstUpper_3, "\t\t");
            _builder.append("Controller.getInstance().addContributor(");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append("AuthorizerController.ID, authController);");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static UIController getInstance() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (controller == null)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("controller = new UIController();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return controller;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void contributeUITo(Component component, Object data)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    String _name_5 = authEntity.getName();
    String _firstUpper_4 = StringExtensions.toFirstUpper(_name_5);
    _builder.append(_firstUpper_4, "\t\t");
    _builder.append("TO user = Registry.get(");
    String _upperCase = packageName.toUpperCase();
    _builder.append(_upperCase, "\t\t");
    _builder.append("UI.USER);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("MenuPanel menu = (MenuPanel) component;");
    _builder.newLine();
    _builder.append("\t\t");
    int isFirst = 0;
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    boolean t = bes.add(authEntity);
    _builder.newLineIfNotEmpty();
    {
      for(final BusinessEntity be_3 : bes) {
        {
          boolean _isMaster = DomainCodeUtilities.isMaster(be_3);
          if (_isMaster) {
            {
              if ((isFirst == 0)) {
                _builder.append("\t\t");
                String _name_6 = be_3.getName();
                String _firstUpper_5 = StringExtensions.toFirstUpper(_name_6);
                _builder.append(_firstUpper_5, "\t\t");
                _builder.append("Controller.getInstance().show");
                String _name_7 = be_3.getName();
                String _firstUpper_6 = StringExtensions.toFirstUpper(_name_7);
                _builder.append(_firstUpper_6, "\t\t");
                _builder.append("Form();");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                int c = isFirst++;
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append("menu.addMenu(\"");
            String _name_8 = be_3.getName();
            String _firstUpper_7 = StringExtensions.toFirstUpper(_name_8);
            _builder.append(_firstUpper_7, "\t\t");
            _builder.append("\", ");
            String _name_9 = be_3.getName();
            String _firstUpper_8 = StringExtensions.toFirstUpper(_name_9);
            _builder.append(_firstUpper_8, "\t\t");
            _builder.append("Controller.getInstance()");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("\t\t");
            _builder.append(".get");
            String _name_10 = be_3.getName();
            String _firstUpper_9 = StringExtensions.toFirstUpper(_name_10);
            _builder.append(_firstUpper_9, "\t\t\t\t");
            _builder.append("Command(), true);");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      if (authorizerSelected) {
        _builder.append("\t\t");
        _builder.append("if (AuthorizerController.getInstance().hasAdminRole(user.get");
        Attribute _iD = DomainCodeUtilities.getID(authEntity);
        String _name_11 = _iD.getName();
        String _firstUpper_10 = StringExtensions.toFirstUpper(_name_11);
        _builder.append(_firstUpper_10, "\t\t");
        _builder.append("())) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("menu.addMenu(\"Authorizer\", AuthorizerController.getInstance()");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t\t\t");
        _builder.append(".getAuthCommand(), true);\t");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
