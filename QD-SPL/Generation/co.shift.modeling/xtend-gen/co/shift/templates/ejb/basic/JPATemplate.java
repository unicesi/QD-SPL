package co.shift.templates.ejb.basic;

import co.shift.generators.domain.DomainCodeGenerator;
import co.shift.templates.ejb.basic.JPAPKEncapTemplate;
import co.shift.templates.ejb.basic.JPAPKTemplate;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;
import domainmetamodel.Delete;
import domainmetamodel.ListAll;
import domainmetamodel.Simple;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class JPATemplate {
  public static CharSequence generate(final BusinessEntity be, final String packageName, final List<Association> associations, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".");
    String _name = be.getName();
    String _lowerCase_1 = _name.toLowerCase();
    _builder.append(_lowerCase_1, "");
    _builder.append(".entity;");
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
    _builder.append("import javax.persistence.*;");
    _builder.newLine();
    _builder.append("import java.io.Serializable;");
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
    _builder.append("@Entity");
    _builder.newLine();
    _builder.append("@Table(name = \"");
    String _name_2 = be.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper_1, "");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("@NamedQueries({");
    _builder.newLine();
    _builder.append("\t");
    int coma = 0;
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Contracts> _contracts = be.getContracts();
    int size = _contracts.size();
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Attribute id = DomainCodeGenerator.getID(be);
    _builder.newLineIfNotEmpty();
    {
      EList<Contracts> _contracts_1 = be.getContracts();
      for(final Contracts contract : _contracts_1) {
        {
          if ((contract instanceof Delete)) {
            _builder.append("\t");
            int putComa = coma++;
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("@NamedQuery(name = \"");
            String _name_3 = be.getName();
            String _lowerCase_3 = _name_3.toLowerCase();
            _builder.append(_lowerCase_3, "\t");
            _builder.append(".delete");
            String _name_4 = be.getName();
            String _firstUpper_2 = StringExtensions.toFirstUpper(_name_4);
            _builder.append(_firstUpper_2, "\t");
            _builder.append("\", query = \"DELETE FROM ");
            String _name_5 = be.getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_5);
            _builder.append(_firstUpper_3, "\t");
            _builder.append(" p WHERE p.");
            String _name_6 = id.getName();
            _builder.append(_name_6, "\t");
            _builder.append("=:id\")");
            {
              if ((coma < (size - 1))) {
                _builder.append(",");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((contract instanceof ListAll)) {
            _builder.append("\t");
            int putComa_1 = coma++;
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            ListAll c = ((ListAll)contract);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("@NamedQuery(name = \"");
            String _name_7 = be.getName();
            String _lowerCase_4 = _name_7.toLowerCase();
            _builder.append(_lowerCase_4, "\t");
            _builder.append(".");
            String _name_8 = c.getName();
            _builder.append(_name_8, "\t");
            _builder.append("\", query = \"SELECT p FROM ");
            String _name_9 = be.getName();
            String _firstUpper_4 = StringExtensions.toFirstUpper(_name_9);
            _builder.append(_firstUpper_4, "\t");
            _builder.append(" p\")");
            {
              if ((coma < (size - 1))) {
                _builder.append(",");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if (((!(contract instanceof ListAll)) && (!(contract instanceof Delete)))) {
            _builder.append("\t");
            int sizeM = size--;
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    int comaDos = 0;
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    List<Association> _detailMultipleAssociations = DomainCodeGenerator.getDetailMultipleAssociations(be, associations);
    int sizeDos = _detailMultipleAssociations.size();
    _builder.newLineIfNotEmpty();
    {
      boolean _isDetail = DomainCodeGenerator.isDetail(be);
      if (_isDetail) {
        {
          if ((sizeDos > 0)) {
            _builder.append("\t");
            _builder.append(",");
            _builder.newLine();
          }
        }
        {
          List<Association> _detailMultipleAssociations_1 = DomainCodeGenerator.getDetailMultipleAssociations(be, associations);
          for(final Association association : _detailMultipleAssociations_1) {
            _builder.append("\t");
            int putComa_2 = comaDos++;
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            EObject _eContainer = association.eContainer();
            final BusinessEntity container = ((BusinessEntity) _eContainer);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("@NamedQuery(name = \"");
            String _name_10 = be.getName();
            String _lowerCase_5 = _name_10.toLowerCase();
            _builder.append(_lowerCase_5, "\t");
            _builder.append(".get");
            String _name_11 = container.getName();
            String _firstUpper_5 = StringExtensions.toFirstUpper(_name_11);
            _builder.append(_firstUpper_5, "\t");
            String _name_12 = be.getName();
            String _firstUpper_6 = StringExtensions.toFirstUpper(_name_12);
            _builder.append(_firstUpper_6, "\t");
            _builder.append("\", query = \"SELECT r FROM ");
            String _name_13 = be.getName();
            String _firstUpper_7 = StringExtensions.toFirstUpper(_name_13);
            _builder.append(_firstUpper_7, "\t");
            _builder.append(" r WHERE r.");
            String _name_14 = container.getName();
            String _lowerCase_6 = _name_14.toLowerCase();
            _builder.append(_lowerCase_6, "\t");
            _builder.append("=:id\")");
            {
              if ((comaDos < (sizeDos - 1))) {
                _builder.append(",");
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("})");
    _builder.newLine();
    _builder.append("public class ");
    String _name_15 = be.getName();
    String _firstUpper_8 = StringExtensions.toFirstUpper(_name_15);
    _builder.append(_firstUpper_8, "");
    _builder.append(" implements Serializable {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final long serialVersionUID = 1L;");
    _builder.newLine();
    {
      EList<Attribute> _attributes = be.getAttributes();
      for(final Attribute attribute : _attributes) {
        {
          String _name_16 = attribute.getName();
          String _name_17 = id.getName();
          boolean _equals = _name_16.equals(_name_17);
          if (_equals) {
            _builder.append("@Id");
            _builder.newLine();
          }
        }
        {
          String _type = DomainCodeGenerator.getType(attribute);
          boolean _equals_1 = _type.equals("Date");
          if (_equals_1) {
            _builder.append("@Temporal(TemporalType.DATE)");
            _builder.newLine();
          }
        }
        _builder.append("private ");
        String _type_1 = DomainCodeGenerator.getType(attribute);
        _builder.append(_type_1, "");
        _builder.append(" ");
        String _name_18 = attribute.getName();
        String _lowerCase_7 = _name_18.toLowerCase();
        _builder.append(_lowerCase_7, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("public ");
        String _type_2 = DomainCodeGenerator.getType(attribute);
        _builder.append(_type_2, "");
        _builder.append(" get");
        String _name_19 = attribute.getName();
        String _firstUpper_9 = StringExtensions.toFirstUpper(_name_19);
        _builder.append(_firstUpper_9, "");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return this.");
        String _name_20 = attribute.getName();
        String _lowerCase_8 = _name_20.toLowerCase();
        _builder.append(_lowerCase_8, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("public void set");
        String _name_21 = attribute.getName();
        String _firstUpper_10 = StringExtensions.toFirstUpper(_name_21);
        _builder.append(_firstUpper_10, "");
        _builder.append("(");
        String _type_3 = DomainCodeGenerator.getType(attribute);
        _builder.append(_type_3, "");
        _builder.append(" ");
        String _name_22 = attribute.getName();
        String _lowerCase_9 = _name_22.toLowerCase();
        _builder.append(_lowerCase_9, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("this.");
        String _name_23 = attribute.getName();
        String _lowerCase_10 = _name_23.toLowerCase();
        _builder.append(_lowerCase_10, "\t");
        _builder.append(" = ");
        String _name_24 = attribute.getName();
        String _lowerCase_11 = _name_24.toLowerCase();
        _builder.append(_lowerCase_11, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("}\t\t\t\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Association> _associations = be.getAssociations();
      for(final Association association_1 : _associations) {
        {
          if ((association_1 instanceof Simple)) {
            _builder.append("\t");
            final BusinessEntity relatedEntity = ((Simple)association_1).getRelatedEntity();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("private ");
            Attribute _iD = DomainCodeGenerator.getID(relatedEntity);
            String _type_4 = DomainCodeGenerator.getType(_iD);
            _builder.append(_type_4, "\t");
            _builder.append(" ");
            String _name_25 = ((Simple)association_1).getName();
            String _lowerCase_12 = _name_25.toLowerCase();
            _builder.append(_lowerCase_12, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            Attribute _iD_1 = DomainCodeGenerator.getID(relatedEntity);
            String _type_5 = DomainCodeGenerator.getType(_iD_1);
            _builder.append(_type_5, "\t");
            _builder.append(" get");
            String _name_26 = ((Simple)association_1).getName();
            String _firstUpper_11 = StringExtensions.toFirstUpper(_name_26);
            _builder.append(_firstUpper_11, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return this.");
            String _name_27 = ((Simple)association_1).getName();
            String _lowerCase_13 = _name_27.toLowerCase();
            _builder.append(_lowerCase_13, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _name_28 = ((Simple)association_1).getName();
            String _firstUpper_12 = StringExtensions.toFirstUpper(_name_28);
            _builder.append(_firstUpper_12, "\t");
            _builder.append("(");
            Attribute _iD_2 = DomainCodeGenerator.getID(relatedEntity);
            String _type_6 = DomainCodeGenerator.getType(_iD_2);
            _builder.append(_type_6, "\t");
            _builder.append(" ");
            String _name_29 = ((Simple)association_1).getName();
            String _lowerCase_14 = _name_29.toLowerCase();
            _builder.append(_lowerCase_14, "\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_30 = ((Simple)association_1).getName();
            String _lowerCase_15 = _name_30.toLowerCase();
            _builder.append(_lowerCase_15, "\t\t");
            _builder.append(" = ");
            String _name_31 = ((Simple)association_1).getName();
            String _lowerCase_16 = _name_31.toLowerCase();
            _builder.append(_lowerCase_16, "\t\t");
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
      List<Association> _detailMultipleAssociations_2 = DomainCodeGenerator.getDetailMultipleAssociations(be, associations);
      for(final Association association_2 : _detailMultipleAssociations_2) {
        _builder.append("\t");
        _builder.append("\t");
        EObject _eContainer_1 = association_2.eContainer();
        final BusinessEntity container_1 = ((BusinessEntity) _eContainer_1);
        _builder.newLineIfNotEmpty();
        {
          boolean _isDetail_1 = DomainCodeGenerator.isDetail(be);
          if (_isDetail_1) {
            _builder.append("\t");
            _builder.append("private ");
            Attribute _iD_3 = DomainCodeGenerator.getID(container_1);
            String _type_7 = DomainCodeGenerator.getType(_iD_3);
            _builder.append(_type_7, "\t");
            _builder.append(" ");
            String _name_32 = container_1.getName();
            String _lowerCase_17 = _name_32.toLowerCase();
            _builder.append(_lowerCase_17, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public ");
            Attribute _iD_4 = DomainCodeGenerator.getID(container_1);
            String _type_8 = DomainCodeGenerator.getType(_iD_4);
            _builder.append(_type_8, "\t");
            _builder.append(" get");
            String _name_33 = container_1.getName();
            String _firstUpper_13 = StringExtensions.toFirstUpper(_name_33);
            _builder.append(_firstUpper_13, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return this.");
            String _name_34 = container_1.getName();
            String _lowerCase_18 = _name_34.toLowerCase();
            _builder.append(_lowerCase_18, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _name_35 = container_1.getName();
            String _firstUpper_14 = StringExtensions.toFirstUpper(_name_35);
            _builder.append(_firstUpper_14, "\t");
            _builder.append("(");
            Attribute _iD_5 = DomainCodeGenerator.getID(container_1);
            String _type_9 = DomainCodeGenerator.getType(_iD_5);
            _builder.append(_type_9, "\t");
            _builder.append(" ");
            String _name_36 = container_1.getName();
            String _lowerCase_19 = _name_36.toLowerCase();
            _builder.append(_lowerCase_19, "\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_37 = container_1.getName();
            String _lowerCase_20 = _name_37.toLowerCase();
            _builder.append(_lowerCase_20, "\t\t");
            _builder.append(" = ");
            String _name_38 = container_1.getName();
            String _lowerCase_21 = _name_38.toLowerCase();
            _builder.append(_lowerCase_21, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("\t");
            _builder.append("@OneToMany(mappedBy = \"");
            String _name_39 = be.getName();
            String _lowerCase_22 = _name_39.toLowerCase();
            _builder.append(_lowerCase_22, "\t");
            _builder.append("Bean\", orphanRemoval = true)");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("private List<");
            String _name_40 = container_1.getName();
            String _firstUpper_15 = StringExtensions.toFirstUpper(_name_40);
            _builder.append(_firstUpper_15, "\t");
            String _name_41 = be.getName();
            String _firstUpper_16 = StringExtensions.toFirstUpper(_name_41);
            _builder.append(_firstUpper_16, "\t");
            _builder.append("> ");
            String _name_42 = container_1.getName();
            String _lowerCase_23 = _name_42.toLowerCase();
            _builder.append(_lowerCase_23, "\t");
            String _name_43 = be.getName();
            String _firstUpper_17 = StringExtensions.toFirstUpper(_name_43);
            _builder.append(_firstUpper_17, "\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public List<");
            String _name_44 = container_1.getName();
            String _firstUpper_18 = StringExtensions.toFirstUpper(_name_44);
            _builder.append(_firstUpper_18, "\t");
            String _name_45 = be.getName();
            String _firstUpper_19 = StringExtensions.toFirstUpper(_name_45);
            _builder.append(_firstUpper_19, "\t");
            _builder.append("> get");
            String _name_46 = container_1.getName();
            String _firstUpper_20 = StringExtensions.toFirstUpper(_name_46);
            _builder.append(_firstUpper_20, "\t");
            String _name_47 = be.getName();
            String _firstUpper_21 = StringExtensions.toFirstUpper(_name_47);
            _builder.append(_firstUpper_21, "\t");
            _builder.append("() {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("return this.");
            String _name_48 = container_1.getName();
            String _lowerCase_24 = _name_48.toLowerCase();
            _builder.append(_lowerCase_24, "\t\t");
            String _name_49 = be.getName();
            String _firstUpper_22 = StringExtensions.toFirstUpper(_name_49);
            _builder.append(_firstUpper_22, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void set");
            String _name_50 = container_1.getName();
            String _firstUpper_23 = StringExtensions.toFirstUpper(_name_50);
            _builder.append(_firstUpper_23, "\t");
            String _name_51 = be.getName();
            String _firstUpper_24 = StringExtensions.toFirstUpper(_name_51);
            _builder.append(_firstUpper_24, "\t");
            _builder.append("(List<");
            String _name_52 = container_1.getName();
            String _firstUpper_25 = StringExtensions.toFirstUpper(_name_52);
            _builder.append(_firstUpper_25, "\t");
            String _name_53 = be.getName();
            String _firstUpper_26 = StringExtensions.toFirstUpper(_name_53);
            _builder.append(_firstUpper_26, "\t");
            _builder.append("> ");
            String _name_54 = container_1.getName();
            String _lowerCase_25 = _name_54.toLowerCase();
            _builder.append(_lowerCase_25, "\t");
            String _name_55 = be.getName();
            String _firstUpper_27 = StringExtensions.toFirstUpper(_name_55);
            _builder.append(_firstUpper_27, "\t");
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("this.");
            String _name_56 = container_1.getName();
            String _lowerCase_26 = _name_56.toLowerCase();
            _builder.append(_lowerCase_26, "\t\t");
            String _name_57 = be.getName();
            String _firstUpper_28 = StringExtensions.toFirstUpper(_name_57);
            _builder.append(_firstUpper_28, "\t\t");
            _builder.append(" = ");
            String _name_58 = container_1.getName();
            String _lowerCase_27 = _name_58.toLowerCase();
            _builder.append(_lowerCase_27, "\t\t");
            String _name_59 = be.getName();
            String _firstUpper_29 = StringExtensions.toFirstUpper(_name_59);
            _builder.append(_firstUpper_29, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("\t");
            String _lowerCase_28 = packageName.toLowerCase();
            String _plus = ("/co/shift/" + _lowerCase_28);
            String _plus_1 = (_plus + "/");
            String _name_60 = be.getName();
            String _lowerCase_29 = _name_60.toLowerCase();
            String _plus_2 = (_plus_1 + _lowerCase_29);
            String _plus_3 = (_plus_2 + "/entity/");
            String _name_61 = container_1.getName();
            String _firstUpper_30 = StringExtensions.toFirstUpper(_name_61);
            String _plus_4 = (_plus_3 + _firstUpper_30);
            String _name_62 = be.getName();
            String _firstUpper_31 = StringExtensions.toFirstUpper(_name_62);
            String _plus_5 = (_plus_4 + _firstUpper_31);
            String _plus_6 = (_plus_5 + ".java");
            String _name_63 = container_1.getName();
            String _firstUpper_32 = StringExtensions.toFirstUpper(_name_63);
            String _name_64 = be.getName();
            String _firstUpper_33 = StringExtensions.toFirstUpper(_name_64);
            String _plus_7 = (_firstUpper_32 + _firstUpper_33);
            CharSequence _generate = JPAPKEncapTemplate.generate(be, packageName, _plus_7, associations, fsa);
            fsa.generateFile(_plus_6, _generate);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _lowerCase_30 = packageName.toLowerCase();
            String _plus_8 = ("/co/shift/" + _lowerCase_30);
            String _plus_9 = (_plus_8 + "/");
            String _name_65 = be.getName();
            String _lowerCase_31 = _name_65.toLowerCase();
            String _plus_10 = (_plus_9 + _lowerCase_31);
            String _plus_11 = (_plus_10 + "/entity/");
            String _name_66 = container_1.getName();
            String _firstUpper_34 = StringExtensions.toFirstUpper(_name_66);
            String _plus_12 = (_plus_11 + _firstUpper_34);
            String _name_67 = be.getName();
            String _firstUpper_35 = StringExtensions.toFirstUpper(_name_67);
            String _plus_13 = (_plus_12 + _firstUpper_35);
            String _plus_14 = (_plus_13 + "PK.java");
            CharSequence _generate_1 = JPAPKTemplate.generate(be, packageName, container_1, associations, fsa);
            fsa.generateFile(_plus_14, _generate_1);
            _builder.newLineIfNotEmpty();
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
    String _name_68 = be.getName();
    String _firstUpper_36 = StringExtensions.toFirstUpper(_name_68);
    _builder.append(_firstUpper_36, "\t\t");
    _builder.append(" o = (");
    String _name_69 = be.getName();
    String _firstUpper_37 = StringExtensions.toFirstUpper(_name_69);
    _builder.append(_firstUpper_37, "\t\t");
    _builder.append(") obj;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (o != null)");
    _builder.newLine();
    {
      Attribute _iD_6 = DomainCodeGenerator.getID(be);
      String _type_10 = DomainCodeGenerator.getType(_iD_6);
      boolean _equals_2 = _type_10.equals("String");
      if (_equals_2) {
        _builder.append("\t\t");
        _builder.append("return ");
        Attribute _iD_7 = DomainCodeGenerator.getID(be);
        String _name_70 = _iD_7.getName();
        String _lowerCase_32 = _name_70.toLowerCase();
        _builder.append(_lowerCase_32, "\t\t");
        _builder.append(".equals(o.");
        Attribute _iD_8 = DomainCodeGenerator.getID(be);
        String _name_71 = _iD_8.getName();
        String _lowerCase_33 = _name_71.toLowerCase();
        _builder.append(_lowerCase_33, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Attribute _iD_9 = DomainCodeGenerator.getID(be);
      String _type_11 = DomainCodeGenerator.getType(_iD_9);
      boolean _equals_3 = _type_11.equals("int");
      if (_equals_3) {
        _builder.append("\t\t");
        _builder.append("return ");
        Attribute _iD_10 = DomainCodeGenerator.getID(be);
        String _name_72 = _iD_10.getName();
        String _lowerCase_34 = _name_72.toLowerCase();
        _builder.append(_lowerCase_34, "\t\t");
        _builder.append(" == o.");
        Attribute _iD_11 = DomainCodeGenerator.getID(be);
        String _name_73 = _iD_11.getName();
        String _lowerCase_35 = _name_73.toLowerCase();
        _builder.append(_lowerCase_35, "\t\t");
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
    _builder.append("public ");
    String _name_74 = be.getName();
    String _firstUpper_38 = StringExtensions.toFirstUpper(_name_74);
    _builder.append(_firstUpper_38, "\t");
    _builder.append("TO toTO() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_75 = be.getName();
    String _firstUpper_39 = StringExtensions.toFirstUpper(_name_75);
    _builder.append(_firstUpper_39, "\t\t");
    _builder.append("TO to = new ");
    String _name_76 = be.getName();
    String _firstUpper_40 = StringExtensions.toFirstUpper(_name_76);
    _builder.append(_firstUpper_40, "\t\t");
    _builder.append("TO();");
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_1 = be.getAttributes();
      for(final Attribute attribute_1 : _attributes_1) {
        _builder.append("\t\t");
        _builder.append("to.set");
        String _name_77 = attribute_1.getName();
        String _firstUpper_41 = StringExtensions.toFirstUpper(_name_77);
        _builder.append(_firstUpper_41, "\t\t");
        _builder.append("(");
        String _name_78 = attribute_1.getName();
        String _lowerCase_36 = _name_78.toLowerCase();
        _builder.append(_lowerCase_36, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("return to;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
