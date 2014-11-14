package co.shift.templates.ejb.basic;

import co.shift.generators.domain.DomainCodeGenerator;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Simple;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DTOTemplate {
  public static CharSequence generate(final BusinessEntity be, final String packageName, final List<Association> associations) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".to;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.io.Serializable;");
    _builder.newLine();
    _builder.append("import java.util.Date;");
    _builder.newLine();
    _builder.append("import java.math.BigDecimal;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name = be.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("TO implements Serializable {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final long serialVersionUID = 1L;");
    _builder.newLine();
    {
      EList<Attribute> _attributes = be.getAttributes();
      for(final Attribute attribute : _attributes) {
        _builder.newLine();
        _builder.append("\t");
        _builder.append("private ");
        String _type = DomainCodeGenerator.getType(attribute);
        _builder.append(_type, "\t");
        _builder.append(" ");
        String _name_1 = attribute.getName();
        String _lowerCase_1 = _name_1.toLowerCase();
        _builder.append(_lowerCase_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public ");
        String _type_1 = DomainCodeGenerator.getType(attribute);
        _builder.append(_type_1, "\t");
        _builder.append(" get");
        String _name_2 = attribute.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("return this.");
        String _name_3 = attribute.getName();
        String _lowerCase_2 = _name_3.toLowerCase();
        _builder.append(_lowerCase_2, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _name_4 = attribute.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_4);
        _builder.append(_firstUpper_2, "\t");
        _builder.append("(");
        String _type_2 = DomainCodeGenerator.getType(attribute);
        _builder.append(_type_2, "\t");
        _builder.append(" ");
        String _name_5 = attribute.getName();
        String _lowerCase_3 = _name_5.toLowerCase();
        _builder.append(_lowerCase_3, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("this.");
        String _name_6 = attribute.getName();
        String _lowerCase_4 = _name_6.toLowerCase();
        _builder.append(_lowerCase_4, "\t\t");
        _builder.append(" = ");
        String _name_7 = attribute.getName();
        String _lowerCase_5 = _name_7.toLowerCase();
        _builder.append(_lowerCase_5, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}\t\t\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Association> _associations = be.getAssociations();
      for(final Association association : _associations) {
        {
          if ((association instanceof Simple)) {
            _builder.append("\t");
            final BusinessEntity relatedEntity = ((Simple)association).getRelatedEntity();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("private ");
            Attribute _iD = DomainCodeGenerator.getID(relatedEntity);
            String _type_3 = DomainCodeGenerator.getType(_iD);
            _builder.append(_type_3, "\t");
            _builder.append(" ");
            String _name_8 = ((Simple)association).getName();
            String _lowerCase_6 = _name_8.toLowerCase();
            _builder.append(_lowerCase_6, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            Attribute _iD_1 = DomainCodeGenerator.getID(relatedEntity);
            String _type_4 = DomainCodeGenerator.getType(_iD_1);
            _builder.append(_type_4, "\t");
            _builder.append(" get");
            String _name_9 = ((Simple)association).getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_9);
            _builder.append(_firstUpper_3, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return this.");
            String _name_10 = ((Simple)association).getName();
            String _lowerCase_7 = _name_10.toLowerCase();
            _builder.append(_lowerCase_7, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _name_11 = ((Simple)association).getName();
            String _firstUpper_4 = StringExtensions.toFirstUpper(_name_11);
            _builder.append(_firstUpper_4, "\t");
            _builder.append("(");
            Attribute _iD_2 = DomainCodeGenerator.getID(relatedEntity);
            String _type_5 = DomainCodeGenerator.getType(_iD_2);
            _builder.append(_type_5, "\t");
            _builder.append(" ");
            String _name_12 = ((Simple)association).getName();
            String _lowerCase_8 = _name_12.toLowerCase();
            _builder.append(_lowerCase_8, "\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_13 = ((Simple)association).getName();
            String _lowerCase_9 = _name_13.toLowerCase();
            _builder.append(_lowerCase_9, "\t\t");
            _builder.append(" = ");
            String _name_14 = ((Simple)association).getName();
            String _lowerCase_10 = _name_14.toLowerCase();
            _builder.append(_lowerCase_10, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isDetail = DomainCodeGenerator.isDetail(be);
      if (_isDetail) {
        {
          List<Association> _detailMultipleAssociations = DomainCodeGenerator.getDetailMultipleAssociations(be, associations);
          for(final Association association_1 : _detailMultipleAssociations) {
            _builder.append("\t");
            EObject _eContainer = association_1.eContainer();
            final BusinessEntity container = ((BusinessEntity) _eContainer);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("private ");
            Attribute _iD_3 = DomainCodeGenerator.getID(container);
            String _type_6 = DomainCodeGenerator.getType(_iD_3);
            _builder.append(_type_6, "\t");
            _builder.append(" ");
            String _name_15 = container.getName();
            String _lowerCase_11 = _name_15.toLowerCase();
            _builder.append(_lowerCase_11, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            Attribute _iD_4 = DomainCodeGenerator.getID(container);
            String _type_7 = DomainCodeGenerator.getType(_iD_4);
            _builder.append(_type_7, "\t");
            _builder.append(" get");
            String _name_16 = container.getName();
            String _firstUpper_5 = StringExtensions.toFirstUpper(_name_16);
            _builder.append(_firstUpper_5, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return this.");
            String _name_17 = container.getName();
            String _lowerCase_12 = _name_17.toLowerCase();
            _builder.append(_lowerCase_12, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _name_18 = container.getName();
            String _firstUpper_6 = StringExtensions.toFirstUpper(_name_18);
            _builder.append(_firstUpper_6, "\t");
            _builder.append("(");
            Attribute _iD_5 = DomainCodeGenerator.getID(container);
            String _type_8 = DomainCodeGenerator.getType(_iD_5);
            _builder.append(_type_8, "\t");
            _builder.append(" ");
            String _name_19 = container.getName();
            String _lowerCase_13 = _name_19.toLowerCase();
            _builder.append(_lowerCase_13, "\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_20 = container.getName();
            String _lowerCase_14 = _name_20.toLowerCase();
            _builder.append(_lowerCase_14, "\t\t");
            _builder.append(" = ");
            String _name_21 = container.getName();
            String _lowerCase_15 = _name_21.toLowerCase();
            _builder.append(_lowerCase_15, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean equals(Object obj) {");
    _builder.newLine();
    _builder.append("\t\t");
    String _name_22 = be.getName();
    String _firstUpper_7 = StringExtensions.toFirstUpper(_name_22);
    _builder.append(_firstUpper_7, "\t\t");
    _builder.append("TO o = (");
    String _name_23 = be.getName();
    String _firstUpper_8 = StringExtensions.toFirstUpper(_name_23);
    _builder.append(_firstUpper_8, "\t\t");
    _builder.append("TO) obj;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (o != null)");
    _builder.newLine();
    {
      Attribute _iD_6 = DomainCodeGenerator.getID(be);
      String _type_9 = DomainCodeGenerator.getType(_iD_6);
      boolean _equals = _type_9.equals("String");
      if (_equals) {
        _builder.append("\t\t");
        _builder.append("return ");
        Attribute _iD_7 = DomainCodeGenerator.getID(be);
        String _name_24 = _iD_7.getName();
        String _lowerCase_16 = _name_24.toLowerCase();
        _builder.append(_lowerCase_16, "\t\t");
        _builder.append(".equals(o.");
        Attribute _iD_8 = DomainCodeGenerator.getID(be);
        String _name_25 = _iD_8.getName();
        String _lowerCase_17 = _name_25.toLowerCase();
        _builder.append(_lowerCase_17, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Attribute _iD_9 = DomainCodeGenerator.getID(be);
      String _type_10 = DomainCodeGenerator.getType(_iD_9);
      boolean _equals_1 = _type_10.equals("int");
      if (_equals_1) {
        _builder.append("\t\t");
        _builder.append("return ");
        Attribute _iD_10 = DomainCodeGenerator.getID(be);
        String _name_26 = _iD_10.getName();
        String _lowerCase_18 = _name_26.toLowerCase();
        _builder.append(_lowerCase_18, "\t\t");
        _builder.append(" == o.");
        Attribute _iD_11 = DomainCodeGenerator.getID(be);
        String _name_27 = _iD_11.getName();
        String _lowerCase_19 = _name_27.toLowerCase();
        _builder.append(_lowerCase_19, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("return false;");
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
    _builder.append("public String toString() {");
    _builder.newLine();
    {
      Attribute _iD_12 = DomainCodeGenerator.getID(be);
      String _type_11 = DomainCodeGenerator.getType(_iD_12);
      boolean _equals_2 = _type_11.equals("String");
      boolean _not = (!_equals_2);
      if (_not) {
        _builder.append("\t\t");
        _builder.append("return \"\" + ");
        Attribute _iD_13 = DomainCodeGenerator.getID(be);
        String _name_28 = _iD_13.getName();
        String _lowerCase_20 = _name_28.toLowerCase();
        _builder.append(_lowerCase_20, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("\t\t");
        _builder.append("return ");
        Attribute _iD_14 = DomainCodeGenerator.getID(be);
        String _name_29 = _iD_14.getName();
        String _lowerCase_21 = _name_29.toLowerCase();
        _builder.append(_lowerCase_21, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
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
