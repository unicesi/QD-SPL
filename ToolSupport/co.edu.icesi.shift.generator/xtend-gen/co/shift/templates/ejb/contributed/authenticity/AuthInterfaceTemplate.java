package co.shift.templates.ejb.contributed.authenticity;

import co.shift.generators.domain.DomainCodeUtilities;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AuthInterfaceTemplate {
  public static CharSequence generate(final String packageName, final BusinessEntity authEntity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".authorization.boundary;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ejb.Remote;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import co.shift.");
    String _lowerCase_1 = packageName.toLowerCase();
    _builder.append(_lowerCase_1, "");
    _builder.append(".to.RoleTO;");
    _builder.newLineIfNotEmpty();
    _builder.append("import co.shift.");
    String _lowerCase_2 = packageName.toLowerCase();
    _builder.append(_lowerCase_2, "");
    _builder.append(".to.ServiceTO;");
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
    _builder.newLine();
    _builder.append("@Remote");
    _builder.newLine();
    _builder.append("public interface IAuthorizationManager {");
    _builder.newLine();
    _builder.newLine();
    Attribute authId = DomainCodeUtilities.getID(authEntity);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public List<RoleTO> get");
    String _name_1 = authEntity.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper_1, "\t");
    _builder.append("Roles(");
    String _type = DomainCodeUtilities.getType(authId);
    _builder.append(_type, "\t");
    _builder.append(" ");
    String _name_2 = authId.getName();
    String _lowerCase_4 = _name_2.toLowerCase();
    _builder.append(_lowerCase_4, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<RoleTO> getAllRoles();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<ServiceTO> getAllServices();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<ServiceTO> getRoleServices(String roleName);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean createRole (RoleTO role) throws Exception;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean updateRole (RoleTO newRole) throws Exception;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean deleteRole (RoleTO role) throws Exception;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean addRoleTo");
    String _name_3 = authEntity.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_2, "\t");
    _builder.append(" (");
    String _type_1 = DomainCodeUtilities.getType(authId);
    _builder.append(_type_1, "\t");
    _builder.append(" user, RoleTO role) throws Exception;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean removeRoleFrom");
    String _name_4 = authEntity.getName();
    String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper_3, "\t");
    _builder.append(" (");
    String _name_5 = authEntity.getName();
    String _firstUpper_4 = StringExtensions.toFirstUpper(_name_5);
    _builder.append(_firstUpper_4, "\t");
    _builder.append("TO user, RoleTO role) throws Exception;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean addServiceToRole (String roleName, ServiceTO service) throws Exception;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean removeServiceFromRole (RoleTO role, ServiceTO service) throws Exception;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<ServiceTO> get");
    String _name_6 = authEntity.getName();
    String _firstUpper_5 = StringExtensions.toFirstUpper(_name_6);
    _builder.append(_firstUpper_5, "\t");
    _builder.append("Services (");
    String _type_2 = DomainCodeUtilities.getType(authId);
    _builder.append(_type_2, "\t");
    _builder.append(" ");
    String _name_7 = authId.getName();
    String _lowerCase_5 = _name_7.toLowerCase();
    _builder.append(_lowerCase_5, "\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
