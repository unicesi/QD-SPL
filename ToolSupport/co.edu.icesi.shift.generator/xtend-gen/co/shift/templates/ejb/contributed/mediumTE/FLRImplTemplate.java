package co.shift.templates.ejb.contributed.mediumTE;

import co.shift.generators.domain.DomainCodeUtilities;
import co.shift.generators.domain.DomainParams;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;
import domainmetamodel.ListAll;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class FLRImplTemplate {
  private static String className = new Object() {
  }.getClass().getEnclosingClass().getSimpleName();
  
  public static CharSequence generate(final BusinessEntity be, final String packageName) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t\t");
      String _beginTemplate = DomainCodeUtilities.beginTemplate(FLRImplTemplate.className);
      _builder.append(_beginTemplate, "\t\t");
      _builder.newLineIfNotEmpty();
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
      _builder.append("import java.sql.Connection;");
      _builder.newLine();
      _builder.append("import java.sql.ResultSet;");
      _builder.newLine();
      _builder.append("import java.sql.SQLException;");
      _builder.newLine();
      _builder.append("import java.sql.Statement;");
      _builder.newLine();
      _builder.append("import java.util.ArrayList;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import javax.annotation.Resource;");
      _builder.newLine();
      _builder.append("import javax.ejb.EJB;");
      _builder.newLine();
      _builder.append("import javax.ejb.Stateless;");
      _builder.newLine();
      _builder.append("import javax.sql.DataSource;");
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
      String _beginSection = DomainCodeUtilities.beginSection(DomainParams.SECT_IMPORTS);
      _builder.append(_beginSection, "");
      _builder.newLineIfNotEmpty();
      String _name_2 = be.getName();
      String _contribute2Template = DomainCodeUtilities.contribute2Template(1, packageName, _name_2);
      _builder.append(_contribute2Template, "");
      _builder.newLineIfNotEmpty();
      String _endSection = DomainCodeUtilities.endSection();
      _builder.append(_endSection, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("@Stateless");
      _builder.newLine();
      _builder.append("public class ");
      String _name_3 = be.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_3);
      _builder.append(_firstUpper_1, "");
      _builder.append("BasicFLR implements I");
      String _name_4 = be.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_4);
      _builder.append(_firstUpper_2, "");
      _builder.append("BasicFLR {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("@Resource(name = \"");
      String _lowerCase_3 = packageName.toLowerCase();
      _builder.append(_lowerCase_3, "");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("private DataSource ds;");
      _builder.newLine();
      _builder.newLine();
      String _beginSection_1 = DomainCodeUtilities.beginSection(DomainParams.SECT_ATTRIBUTES);
      _builder.append(_beginSection_1, "");
      _builder.newLineIfNotEmpty();
      String _contribute2Template_1 = DomainCodeUtilities.contribute2Template(1, packageName);
      _builder.append(_contribute2Template_1, "");
      _builder.newLineIfNotEmpty();
      String _endSection_1 = DomainCodeUtilities.endSection();
      _builder.append(_endSection_1, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      String _beginSection_2 = DomainCodeUtilities.beginSection(DomainParams.SECT_METHODS);
      _builder.append(_beginSection_2, "");
      _builder.newLineIfNotEmpty();
      {
        EList<Contracts> _contracts = be.getContracts();
        for(final Contracts contract : _contracts) {
          {
            if ((contract instanceof ListAll)) {
              _builder.append("public List<");
              String _name_5 = be.getName();
              String _firstUpper_3 = StringExtensions.toFirstUpper(_name_5);
              _builder.append(_firstUpper_3, "");
              _builder.append("TO> ");
              String _name_6 = ((ListAll)contract).getName();
              _builder.append(_name_6, "");
              _builder.append("() throws Exception {\t\t\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("List<");
              String _name_7 = be.getName();
              String _firstUpper_4 = StringExtensions.toFirstUpper(_name_7);
              _builder.append(_firstUpper_4, "\t");
              _builder.append("TO> ");
              String _name_8 = be.getName();
              String _lowerCase_4 = _name_8.toLowerCase();
              _builder.append(_lowerCase_4, "\t");
              _builder.append("s = new ArrayList<>();");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("Connection con = null;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("Statement stmt = null;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("ResultSet resultSet = null;");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("try {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("con = ds.getConnection();");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("stmt = con.createStatement();");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("resultSet = stmt.executeQuery(\"SELECT p.* FROM ");
              String _name_9 = be.getName();
              String _firstUpper_5 = StringExtensions.toFirstUpper(_name_9);
              _builder.append(_firstUpper_5, "\t\t");
              _builder.append(" p\");");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              String _name_10 = be.getName();
              String _firstUpper_6 = StringExtensions.toFirstUpper(_name_10);
              _builder.append(_firstUpper_6, "\t\t");
              _builder.append("TO p;");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("while (resultSet.next()) {");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("p = new ");
              String _name_11 = be.getName();
              String _firstUpper_7 = StringExtensions.toFirstUpper(_name_11);
              _builder.append(_firstUpper_7, "\t\t\t");
              _builder.append("TO();");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              int i = 1;
              _builder.newLineIfNotEmpty();
              {
                EList<Attribute> _attributes = be.getAttributes();
                for(final Attribute attribute : _attributes) {
                  _builder.append("\t\t\t");
                  String _type = DomainCodeUtilities.getType(attribute);
                  _builder.append(_type, "\t\t\t");
                  _builder.append(" t");
                  String _name_12 = attribute.getName();
                  String _firstUpper_8 = StringExtensions.toFirstUpper(_name_12);
                  _builder.append(_firstUpper_8, "\t\t\t");
                  _builder.append(" = resultSet.get");
                  String _type_1 = DomainCodeUtilities.getType(attribute);
                  String _firstUpper_9 = StringExtensions.toFirstUpper(_type_1);
                  _builder.append(_firstUpper_9, "\t\t\t");
                  _builder.append("(");
                  _builder.append(i, "\t\t\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t\t");
                  int c = i++;
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t");
              String _contribute2Template_2 = DomainCodeUtilities.contribute2Template(1, null, be, null, null, null, null, null, Integer.valueOf(2));
              _builder.append(_contribute2Template_2, "\t\t\t");
              _builder.newLineIfNotEmpty();
              {
                EList<Attribute> _attributes_1 = be.getAttributes();
                for(final Attribute attribute_1 : _attributes_1) {
                  _builder.append("\t\t\t");
                  _builder.append("p.set");
                  String _name_13 = attribute_1.getName();
                  String _firstUpper_10 = StringExtensions.toFirstUpper(_name_13);
                  _builder.append(_firstUpper_10, "\t\t\t");
                  _builder.append("(t");
                  String _name_14 = attribute_1.getName();
                  String _firstUpper_11 = StringExtensions.toFirstUpper(_name_14);
                  _builder.append(_firstUpper_11, "\t\t\t");
                  _builder.append(");");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("\t\t\t");
              String _name_15 = be.getName();
              String _lowerCase_5 = _name_15.toLowerCase();
              _builder.append(_lowerCase_5, "\t\t\t");
              _builder.append("s.add(p);");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("return ");
              String _name_16 = be.getName();
              String _lowerCase_6 = _name_16.toLowerCase();
              _builder.append(_lowerCase_6, "\t\t");
              _builder.append("s;");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("} catch (SQLException ex) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("throw new Exception(ex.getMessage());");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("}");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("}");
      _builder.newLine();
      String _endSection_2 = DomainCodeUtilities.endSection();
      _builder.append(_endSection_2, "");
      _builder.newLineIfNotEmpty();
      String _endTemplate = DomainCodeUtilities.endTemplate();
      _builder.append(_endTemplate, "");
      _builder.newLineIfNotEmpty();
      return _builder;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
