package co.shift.templates.ejb.basic;

import co.shift.generators.domain.DomainCodeGenerator;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.DataType;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DAOInterfaceTemplate {
  public static CharSequence generate(final BusinessEntity be, final String packageName, final List<Association> associations) {
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
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import javax.ejb.Remote;");
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
    _builder.append("@Remote");
    _builder.newLine();
    _builder.append("public interface I");
    String _name_2 = be.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper_1, "");
    _builder.append("DAO {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      List<Association> _detailSimpleAssociations = DomainCodeGenerator.getDetailSimpleAssociations(be, associations);
      for(final Association association : _detailSimpleAssociations) {
        _builder.append("\t");
        EObject _eContainer = association.eContainer();
        final BusinessEntity container = ((BusinessEntity) _eContainer);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Attribute _iD = DomainCodeGenerator.getID(container);
        DataType _dataType = _iD.getDataType();
        final String type = _dataType.getLiteral();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        String _name_3 = be.getName();
        _builder.append(_name_3, "\t");
        _builder.append("TO get");
        String _name_4 = container.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_4);
        _builder.append(_firstUpper_2, "\t");
        String _name_5 = association.getName();
        String _firstUpper_3 = StringExtensions.toFirstUpper(_name_5);
        _builder.append(_firstUpper_3, "\t");
        _builder.append("(");
        String _type = DomainCodeGenerator.getType(type);
        _builder.append(_type, "\t");
        _builder.append(" ");
        String _name_6 = container.getName();
        String _lowerCase_3 = _name_6.toLowerCase();
        _builder.append(_lowerCase_3, "\t");
        Attribute _iD_1 = DomainCodeGenerator.getID(container);
        String _name_7 = _iD_1.getName();
        String _firstUpper_4 = StringExtensions.toFirstUpper(_name_7);
        _builder.append(_firstUpper_4, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Association> _detailMultipleAssociations = DomainCodeGenerator.getDetailMultipleAssociations(be, associations);
      for(final Association association_1 : _detailMultipleAssociations) {
        _builder.append("\t");
        EObject _eContainer_1 = association_1.eContainer();
        final BusinessEntity container_1 = ((BusinessEntity) _eContainer_1);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Attribute _iD_2 = DomainCodeGenerator.getID(container_1);
        DataType _dataType_1 = _iD_2.getDataType();
        final String type_1 = _dataType_1.getLiteral();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_8 = be.getName();
        _builder.append(_name_8, "\t");
        _builder.append("TO> get");
        String _name_9 = be.getName();
        String _firstUpper_5 = StringExtensions.toFirstUpper(_name_9);
        _builder.append(_firstUpper_5, "\t");
        _builder.append("From");
        String _name_10 = container_1.getName();
        String _firstUpper_6 = StringExtensions.toFirstUpper(_name_10);
        _builder.append(_firstUpper_6, "\t");
        _builder.append("(");
        String _type_1 = DomainCodeGenerator.getType(type_1);
        _builder.append(_type_1, "\t");
        _builder.append(" ");
        String _name_11 = container_1.getName();
        String _lowerCase_4 = _name_11.toLowerCase();
        _builder.append(_lowerCase_4, "\t");
        Attribute _iD_3 = DomainCodeGenerator.getID(container_1);
        String _name_12 = _iD_3.getName();
        String _firstUpper_7 = StringExtensions.toFirstUpper(_name_12);
        _builder.append(_firstUpper_7, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
