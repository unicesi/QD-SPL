package co.shift.templates.ejb.basic;

import co.shift.generators.domain.DomainCodeUtilities;
import domainmetamodel.AddElement;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.ContractElements;
import domainmetamodel.Contracts;
import domainmetamodel.Create;
import domainmetamodel.DataType;
import domainmetamodel.Delete;
import domainmetamodel.DeleteElement;
import domainmetamodel.ListAll;
import domainmetamodel.ListElements;
import domainmetamodel.Multiple;
import domainmetamodel.Simple;
import domainmetamodel.Update;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class BoundaryInterfaceTemplate {
  private static ArrayList<String> importTOs = new ArrayList<String>();
  
  public static CharSequence generate(final BusinessEntity be, final String packageName, final List<Association> associations, final IFileSystemAccess fsa) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".");
    String _name = be.getName();
    String _lowerCase_1 = _name.toLowerCase();
    _builder.append(_lowerCase_1, "");
    _builder.append(".boundary;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import javax.ejb.Remote;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import co.shift.");
    String _lowerCase_2 = packageName.toLowerCase();
    _builder.append(_lowerCase_2, "");
    _builder.append(".to.");
    String _name_1 = be.getName();
    _builder.append(_name_1, "");
    _builder.append("TO;");
    _builder.newLineIfNotEmpty();
    {
      EList<Contracts> _contracts = be.getContracts();
      for(final Contracts contract : _contracts) {
        {
          boolean _or = false;
          if (((contract instanceof AddElement) || (contract instanceof DeleteElement))) {
            _or = true;
          } else {
            _or = (contract instanceof ListElements);
          }
          if (_or) {
            Multiple _association = ((ContractElements) contract).getAssociation();
            final BusinessEntity relatedEntity = _association.getEntity();
            _builder.newLineIfNotEmpty();
            {
              String _name_2 = relatedEntity.getName();
              boolean _contains = BoundaryInterfaceTemplate.importTOs.contains(_name_2);
              boolean _not = (!_contains);
              if (_not) {
                _builder.append("import co.shift.");
                String _lowerCase_3 = packageName.toLowerCase();
                _builder.append(_lowerCase_3, "");
                _builder.append(".to.");
                String _name_3 = relatedEntity.getName();
                _builder.append(_name_3, "");
                _builder.append("TO;");
                _builder.newLineIfNotEmpty();
                String _name_4 = relatedEntity.getName();
                final boolean result = BoundaryInterfaceTemplate.importTOs.add(_name_4);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.newLine();
    _builder.append("@Remote");
    _builder.newLine();
    _builder.append("public interface I");
    String _name_5 = be.getName();
    _builder.append(_name_5, "");
    _builder.append("Manager {");
    _builder.newLineIfNotEmpty();
    {
      EList<Contracts> _contracts_1 = be.getContracts();
      for(final Contracts contract_1 : _contracts_1) {
        _builder.append("\t");
        _builder.newLine();
        {
          boolean _or_1 = false;
          if (((contract_1 instanceof Create) || (contract_1 instanceof Update))) {
            _or_1 = true;
          } else {
            _or_1 = (contract_1 instanceof Delete);
          }
          if (_or_1) {
            _builder.append("\t");
            _builder.append("public boolean ");
            String _name_6 = ((Contracts) contract_1).getName();
            _builder.append(_name_6, "\t");
            _builder.append("(");
            String _name_7 = be.getName();
            _builder.append(_name_7, "\t");
            _builder.append("TO ");
            String _name_8 = be.getName();
            String _lowerCase_4 = _name_8.toLowerCase();
            _builder.append(_lowerCase_4, "\t");
            _builder.append(") throws Exception;");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((contract_1 instanceof ListAll)) {
            _builder.append("\t");
            String _extendContribution = DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_BI, contract_1, be);
            _builder.append(_extendContribution, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            String _extendContribution_1 = DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, packageName, be);
            _builder.append(_extendContribution_1, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _or_2 = false;
          if ((contract_1 instanceof AddElement)) {
            _or_2 = true;
          } else {
            _or_2 = (contract_1 instanceof DeleteElement);
          }
          if (_or_2) {
            _builder.append("\t");
            Multiple _association_1 = ((ContractElements) contract_1).getAssociation();
            final BusinessEntity relatedEntity_1 = _association_1.getEntity();
            _builder.newLineIfNotEmpty();
            {
              boolean _hasZeroAssociations = DomainCodeUtilities.hasZeroAssociations(relatedEntity_1);
              boolean _not_1 = (!_hasZeroAssociations);
              if (_not_1) {
                _builder.append("\t");
                Attribute _iD = DomainCodeUtilities.getID(be);
                DataType _dataType = _iD.getDataType();
                final String type = _dataType.getLiteral();
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("public boolean ");
                String _name_9 = ((ContractElements) contract_1).getName();
                _builder.append(_name_9, "\t");
                _builder.append("(");
                String _name_10 = relatedEntity_1.getName();
                _builder.append(_name_10, "\t");
                _builder.append("TO ");
                String _name_11 = relatedEntity_1.getName();
                String _lowerCase_5 = _name_11.toLowerCase();
                _builder.append(_lowerCase_5, "\t");
                _builder.append(", ");
                String _type = DomainCodeUtilities.getType(type);
                _builder.append(_type, "\t");
                _builder.append(" ");
                String _name_12 = be.getName();
                String _lowerCase_6 = _name_12.toLowerCase();
                _builder.append(_lowerCase_6, "\t");
                Attribute _iD_1 = DomainCodeUtilities.getID(be);
                String _name_13 = _iD_1.getName();
                String _firstUpper = StringExtensions.toFirstUpper(_name_13);
                _builder.append(_firstUpper, "\t");
                _builder.append(") throws Exception;");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    {
      EList<Association> _associations = be.getAssociations();
      for(final Association association : _associations) {
        _builder.append("\t");
        _builder.newLine();
        {
          if ((association instanceof Simple)) {
            _builder.append("\t");
            final BusinessEntity relatedEntity_2 = ((Simple)association).getRelatedEntity();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            Attribute _iD_2 = DomainCodeUtilities.getID(be);
            DataType _dataType_1 = _iD_2.getDataType();
            final String type_1 = _dataType_1.getLiteral();
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("public boolean set");
            String _name_14 = be.getName();
            String _firstUpper_1 = StringExtensions.toFirstUpper(_name_14);
            _builder.append(_firstUpper_1, "\t");
            String _name_15 = ((Simple)association).getName();
            String _firstUpper_2 = StringExtensions.toFirstUpper(_name_15);
            _builder.append(_firstUpper_2, "\t");
            _builder.append("(");
            String _name_16 = relatedEntity_2.getName();
            _builder.append(_name_16, "\t");
            _builder.append("TO ");
            String _name_17 = ((Simple)association).getName();
            String _lowerCase_7 = _name_17.toLowerCase();
            _builder.append(_lowerCase_7, "\t");
            _builder.append(", ");
            String _type_1 = DomainCodeUtilities.getType(type_1);
            _builder.append(_type_1, "\t");
            _builder.append(" ");
            String _name_18 = be.getName();
            String _lowerCase_8 = _name_18.toLowerCase();
            _builder.append(_lowerCase_8, "\t");
            Attribute _iD_3 = DomainCodeUtilities.getID(be);
            String _name_19 = _iD_3.getName();
            String _firstUpper_3 = StringExtensions.toFirstUpper(_name_19);
            _builder.append(_firstUpper_3, "\t");
            _builder.append(") throws Exception;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      List<Association> _detailSimpleAssociations = DomainCodeUtilities.getDetailSimpleAssociations(be, associations);
      for(final Association association_1 : _detailSimpleAssociations) {
        _builder.append("\t");
        EObject _eContainer = association_1.eContainer();
        final BusinessEntity container = ((BusinessEntity) _eContainer);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Attribute _iD_4 = DomainCodeUtilities.getID(container);
        DataType _dataType_2 = _iD_4.getDataType();
        final String type_2 = _dataType_2.getLiteral();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        String _name_20 = be.getName();
        _builder.append(_name_20, "\t");
        _builder.append("TO get");
        String _name_21 = container.getName();
        String _firstUpper_4 = StringExtensions.toFirstUpper(_name_21);
        _builder.append(_firstUpper_4, "\t");
        String _name_22 = association_1.getName();
        String _firstUpper_5 = StringExtensions.toFirstUpper(_name_22);
        _builder.append(_firstUpper_5, "\t");
        _builder.append("(");
        String _type_2 = DomainCodeUtilities.getType(type_2);
        _builder.append(_type_2, "\t");
        _builder.append(" ");
        String _name_23 = container.getName();
        String _lowerCase_9 = _name_23.toLowerCase();
        _builder.append(_lowerCase_9, "\t");
        Attribute _iD_5 = DomainCodeUtilities.getID(container);
        String _name_24 = _iD_5.getName();
        String _firstUpper_6 = StringExtensions.toFirstUpper(_name_24);
        _builder.append(_firstUpper_6, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Association> _detailMultipleAssociations = DomainCodeUtilities.getDetailMultipleAssociations(be, associations);
      for(final Association association_2 : _detailMultipleAssociations) {
        _builder.append("\t");
        EObject _eContainer_1 = association_2.eContainer();
        final BusinessEntity container_1 = ((BusinessEntity) _eContainer_1);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Attribute _iD_6 = DomainCodeUtilities.getID(container_1);
        DataType _dataType_3 = _iD_6.getDataType();
        final String type_3 = _dataType_3.getLiteral();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_25 = be.getName();
        _builder.append(_name_25, "\t");
        _builder.append("TO> get");
        String _name_26 = be.getName();
        String _firstUpper_7 = StringExtensions.toFirstUpper(_name_26);
        _builder.append(_firstUpper_7, "\t");
        _builder.append("From");
        String _name_27 = container_1.getName();
        String _firstUpper_8 = StringExtensions.toFirstUpper(_name_27);
        _builder.append(_firstUpper_8, "\t");
        _builder.append("(");
        String _type_3 = DomainCodeUtilities.getType(type_3);
        _builder.append(_type_3, "\t");
        _builder.append(" ");
        String _name_28 = container_1.getName();
        String _lowerCase_10 = _name_28.toLowerCase();
        _builder.append(_lowerCase_10, "\t");
        Attribute _iD_7 = DomainCodeUtilities.getID(container_1);
        String _name_29 = _iD_7.getName();
        String _firstUpper_9 = StringExtensions.toFirstUpper(_name_29);
        _builder.append(_firstUpper_9, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isIsAuthenticable = be.isIsAuthenticable();
      if (_isIsAuthenticable) {
        _builder.append("\t");
        Attribute _iD_8 = DomainCodeUtilities.getID(be);
        DataType _dataType_4 = _iD_8.getDataType();
        final String type_4 = _dataType_4.getLiteral();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        String _name_30 = be.getName();
        _builder.append(_name_30, "\t");
        _builder.append("TO authenticate(");
        String _type_4 = DomainCodeUtilities.getType(type_4);
        _builder.append(_type_4, "\t");
        _builder.append(" ");
        String _name_31 = be.getName();
        String _lowerCase_11 = _name_31.toLowerCase();
        _builder.append(_lowerCase_11, "\t");
        Attribute _iD_9 = DomainCodeUtilities.getID(be);
        String _name_32 = _iD_9.getName();
        String _firstUpper_10 = StringExtensions.toFirstUpper(_name_32);
        _builder.append(_firstUpper_10, "\t");
        _builder.append(", String password) throws Exception;");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
