package co.shift.templates.database.basic;

import co.shift.contributors.confidentiality.PBECryptographyManager;
import co.shift.generators.domain.DomainCodeUtilities;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import java.util.TreeSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class InsertsScriptTemplate {
  public static CharSequence generate(final String packageName, final BusinessEntity authBe) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-- -----------------------------------------------------");
    _builder.newLine();
    _builder.append("-- Inserts");
    _builder.newLine();
    _builder.append("-- -----------------------------------------------------");
    _builder.newLine();
    _builder.append("INSERT INTO `");
    _builder.append(packageName, "");
    _builder.append("`.`");
    String _name = authBe.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("` (");
    _builder.newLineIfNotEmpty();
    PBECryptographyManager pbe = new PBECryptographyManager();
    _builder.newLineIfNotEmpty();
    EList<Attribute> _attributes = authBe.getAttributes();
    int size = _attributes.size();
    _builder.newLineIfNotEmpty();
    int c = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_1 = authBe.getAttributes();
      for(final Attribute att : _attributes_1) {
        _builder.append("`");
        String _name_1 = att.getName();
        String _lowerCase = _name_1.toLowerCase();
        _builder.append(_lowerCase, "");
        _builder.append("`");
        {
          if ((c < (size - 1))) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        int dd = c++;
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(") VALUES (");
    _builder.newLine();
    int cc = c = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<Attribute> _attributes_2 = authBe.getAttributes();
      for(final Attribute att_1 : _attributes_2) {
        {
          boolean _isQASelected = DomainCodeUtilities.isQASelected("_r_2_10_12_13");
          if (_isQASelected) {
            {
              String _type = DomainCodeUtilities.getType(att_1);
              boolean _equals = _type.equals("String");
              if (_equals) {
                _builder.append("\'");
                char[] _doFinal = pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin");
                String _string = new String(_doFinal);
                _builder.append(_string, "");
              } else {
                {
                  String _type_1 = DomainCodeUtilities.getType(att_1);
                  boolean _equals_1 = _type_1.equals("Date");
                  if (_equals_1) {
                    _builder.append("sysdate()");
                  } else {
                    _builder.append("0");
                  }
                }
              }
            }
            _builder.append("\'");
            _builder.newLineIfNotEmpty();
          } else {
            {
              String _type_2 = DomainCodeUtilities.getType(att_1);
              boolean _equals_2 = _type_2.equals("String");
              if (_equals_2) {
                _builder.append("\'admin\'");
              } else {
                {
                  String _type_3 = DomainCodeUtilities.getType(att_1);
                  boolean _equals_3 = _type_3.equals("Date");
                  if (_equals_3) {
                    _builder.append("sysdate()");
                  } else {
                    _builder.append("0");
                  }
                }
              }
            }
            _builder.newLineIfNotEmpty();
          }
        }
        {
          if ((c < (size - 1))) {
            _builder.append(",");
          }
        }
        int dd_1 = c++;
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _isQASelected_1 = DomainCodeUtilities.isQASelected("_r_2_11_15_16");
      if (_isQASelected_1) {
        _builder.append("INSERT INTO `");
        _builder.append(packageName, "");
        _builder.append("`.`Roles`");
        _builder.newLineIfNotEmpty();
        _builder.append("(`name`,");
        _builder.newLine();
        _builder.append("`description`)");
        _builder.newLine();
        _builder.append("VALUES");
        _builder.newLine();
        _builder.append("(\'");
        {
          boolean _isQASelected_2 = DomainCodeUtilities.isQASelected("_r_2_10_12_13");
          if (_isQASelected_2) {
            char[] _doFinal_1 = pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin");
            String _string_1 = new String(_doFinal_1);
            _builder.append(_string_1, "");
          } else {
            _builder.append("admin");
          }
        }
        _builder.append("\',");
        _builder.newLineIfNotEmpty();
        _builder.append("\'");
        {
          boolean _isQASelected_3 = DomainCodeUtilities.isQASelected("_r_2_10_12_13");
          if (_isQASelected_3) {
            char[] _doFinal_2 = pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin role");
            String _string_2 = new String(_doFinal_2);
            _builder.append(_string_2, "");
          } else {
            _builder.append("admin role");
          }
        }
        _builder.append("\');");
        _builder.newLineIfNotEmpty();
        _builder.append("INSERT INTO `");
        _builder.append(packageName, "");
        _builder.append("`.`");
        String _name_2 = authBe.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
        _builder.append(_firstUpper_1, "");
        _builder.append("Role`");
        _builder.newLineIfNotEmpty();
        _builder.append("(`");
        String _name_3 = authBe.getName();
        String _lowerCase_1 = _name_3.toLowerCase();
        _builder.append(_lowerCase_1, "");
        _builder.append("`,");
        _builder.newLineIfNotEmpty();
        _builder.append("`role`)");
        _builder.newLine();
        _builder.append("VALUES (");
        _builder.newLine();
        _builder.append("\'");
        {
          boolean _isQASelected_4 = DomainCodeUtilities.isQASelected("_r_2_10_12_13");
          if (_isQASelected_4) {
            char[] _doFinal_3 = pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin");
            String _string_3 = new String(_doFinal_3);
            _builder.append(_string_3, "");
          } else {
            _builder.append("admin");
          }
        }
        _builder.append("\',");
        _builder.newLineIfNotEmpty();
        _builder.append("\'");
        {
          boolean _isQASelected_5 = DomainCodeUtilities.isQASelected("_r_2_10_12_13");
          if (_isQASelected_5) {
            char[] _doFinal_4 = pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin");
            String _string_4 = new String(_doFinal_4);
            _builder.append(_string_4, "");
          } else {
            _builder.append("admin");
          }
        }
        _builder.append("\');");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          TreeSet<String> _services = DomainCodeUtilities.getServices();
          for(final String s : _services) {
            _builder.append("INSERT INTO `");
            _builder.append(packageName, "");
            _builder.append("`.`Services`");
            _builder.newLineIfNotEmpty();
            _builder.append("(`name`,");
            _builder.newLine();
            _builder.append("`description`)");
            _builder.newLine();
            _builder.append("VALUES (\'");
            {
              boolean _isQASelected_6 = DomainCodeUtilities.isQASelected("_r_2_10_12_13");
              if (_isQASelected_6) {
                char[] _doFinal_5 = pbe.doFinal(PBECryptographyManager.ENCRYPT, (("" + s) + ""));
                String _string_5 = new String(_doFinal_5);
                _builder.append(_string_5, "");
              } else {
                _builder.append(s, "");
              }
            }
            _builder.append("\', \'");
            {
              boolean _isQASelected_7 = DomainCodeUtilities.isQASelected("_r_2_10_12_13");
              if (_isQASelected_7) {
                char[] _doFinal_6 = pbe.doFinal(PBECryptographyManager.ENCRYPT, (("" + s) + ""));
                String _string_6 = new String(_doFinal_6);
                _builder.append(_string_6, "");
              } else {
                _builder.append(s, "");
              }
            }
            _builder.append("\');");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
}
