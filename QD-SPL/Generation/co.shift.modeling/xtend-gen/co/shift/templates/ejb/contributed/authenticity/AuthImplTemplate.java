package co.shift.templates.ejb.contributed.authenticity;

import co.shift.generators.domain.DomainCodeGenerator;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AuthImplTemplate {
  public static CharSequence generate(final String packageName, final BusinessEntity authEntity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package co.shift.");
    String _lowerCase = packageName.toLowerCase();
    _builder.append(_lowerCase, "");
    _builder.append(".authorization.boundary;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.HashSet;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import java.util.Set;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ejb.Stateless;");
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManager;");
    _builder.newLine();
    _builder.append("import javax.persistence.NoResultException;");
    _builder.newLine();
    _builder.append("import javax.persistence.PersistenceContext;");
    _builder.newLine();
    _builder.append("import javax.persistence.TypedQuery;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.eclipse.persistence.exceptions.DatabaseException;");
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
    _builder.append("import co.shift.");
    String _lowerCase_4 = packageName.toLowerCase();
    _builder.append(_lowerCase_4, "");
    _builder.append(".authorization.entity.Role;");
    _builder.newLineIfNotEmpty();
    _builder.append("import co.shift.");
    String _lowerCase_5 = packageName.toLowerCase();
    _builder.append(_lowerCase_5, "");
    _builder.append(".authorization.entity.Service;");
    _builder.newLineIfNotEmpty();
    _builder.append("import co.shift.");
    String _lowerCase_6 = packageName.toLowerCase();
    _builder.append(_lowerCase_6, "");
    _builder.append(".authorization.entity.");
    String _name_1 = authEntity.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper_1, "");
    _builder.append("Role;");
    _builder.newLineIfNotEmpty();
    _builder.append("import co.shift.");
    String _lowerCase_7 = packageName.toLowerCase();
    _builder.append(_lowerCase_7, "");
    _builder.append(".authorization.entity.");
    String _name_2 = authEntity.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper_2, "");
    _builder.append("RolePK;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@Stateless");
    _builder.newLine();
    _builder.append("public class AuthorizationManager implements IAuthorizationManager {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PersistenceContext(unitName = \"co.shift.");
    String _lowerCase_8 = packageName.toLowerCase();
    _builder.append(_lowerCase_8, "\t");
    _builder.append(".authorization\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private EntityManager em;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    Attribute authId = DomainCodeGenerator.getID(authEntity);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public List<RoleTO> get");
    String _name_3 = authEntity.getName();
    String _firstUpper_3 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_3, "\t");
    _builder.append("Roles(");
    String _type = DomainCodeGenerator.getType(authId);
    _builder.append(_type, "\t");
    _builder.append(" ");
    String _name_4 = authId.getName();
    String _lowerCase_9 = _name_4.toLowerCase();
    _builder.append(_lowerCase_9, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("List<RoleTO> ");
    String _name_5 = authEntity.getName();
    String _lowerCase_10 = _name_5.toLowerCase();
    _builder.append(_lowerCase_10, "\t\t");
    _builder.append("Roles = new ArrayList<>();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("TypedQuery<Role> query = em.createNamedQuery(\"auth.get");
    String _name_6 = authEntity.getName();
    String _firstUpper_4 = StringExtensions.toFirstUpper(_name_6);
    _builder.append(_firstUpper_4, "\t\t");
    _builder.append("Roles\",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("Role.class);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("query.setParameter(\"");
    String _name_7 = authEntity.getName();
    String _lowerCase_11 = _name_7.toLowerCase();
    _builder.append(_lowerCase_11, "\t\t");
    _builder.append("id\", ");
    String _name_8 = authId.getName();
    String _lowerCase_12 = _name_8.toLowerCase();
    _builder.append(_lowerCase_12, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("List<Role> found");
    String _name_9 = authEntity.getName();
    String _firstUpper_5 = StringExtensions.toFirstUpper(_name_9);
    _builder.append(_firstUpper_5, "\t\t");
    _builder.append("Roles = query.getResultList();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (Role role : found");
    String _name_10 = authEntity.getName();
    String _firstUpper_6 = StringExtensions.toFirstUpper(_name_10);
    _builder.append(_firstUpper_6, "\t\t");
    _builder.append("Roles) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    String _name_11 = authEntity.getName();
    String _lowerCase_13 = _name_11.toLowerCase();
    _builder.append(_lowerCase_13, "\t\t\t");
    _builder.append("Roles.add(role.toTO());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return ");
    String _name_12 = authEntity.getName();
    String _lowerCase_14 = _name_12.toLowerCase();
    _builder.append(_lowerCase_14, "\t\t");
    _builder.append("Roles;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<RoleTO> getAllRoles() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<RoleTO> roles = new ArrayList<>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TypedQuery<Role> query = em.createNamedQuery(\"auth.getAllRoles\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Role.class);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<Role> foundRoles = query.getResultList();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (Role role : foundRoles) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("roles.add(role.toTO());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return roles;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<ServiceTO> getAllServices() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<ServiceTO> services = new ArrayList<>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("TypedQuery<Service> query = em.createNamedQuery(\"auth.getAllServices\",");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Service.class);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<Service> foundServices = query.getResultList();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("for (Service service : foundServices) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("services.add(service.toTO());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return services;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<ServiceTO> getRoleServices(String roleName) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<ServiceTO> roleServices = new ArrayList<>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Role foundRole = em.find(Role.class, roleName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (foundRole != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("List<Service> foundServices = foundRole.getServices();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (Service service : foundServices) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("roleServices.add(service.toTO());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return roleServices;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean createRole (RoleTO role) throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Role newRole = new Role();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newRole.setDescription(role.getDescription());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newRole.setName(role.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newRole.setServices(null);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("newRole.set");
    String _name_13 = authEntity.getName();
    String _firstUpper_7 = StringExtensions.toFirstUpper(_name_13);
    _builder.append(_firstUpper_7, "\t\t");
    _builder.append("Roles(null);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("em.persist(newRole);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("em.flush();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (DatabaseException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean updateRole (RoleTO newRole) throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Role foundRole = em.find(Role.class, newRole.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (foundRole == null)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new Exception(\"Role Doesn\'t Exists\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("foundRole.setDescription(newRole.getDescription());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.merge(foundRole);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.flush();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (DatabaseException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean deleteRole (RoleTO role) throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Role foundRole = em.find(Role.class, role.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (foundRole == null)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new Exception(\"Role Doesn\'t Exists\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("TypedQuery<Role> query = em.createNamedQuery(\"auth.deleteRole\",");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Role.class);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("query.setParameter(\"rid\", role.getName());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("query.executeUpdate();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (NoResultException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("throw new Exception(\"Role Cannot Be Found\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean addRoleTo");
    String _name_14 = authEntity.getName();
    String _firstUpper_8 = StringExtensions.toFirstUpper(_name_14);
    _builder.append(_firstUpper_8, "\t");
    _builder.append(" (");
    String _type_1 = DomainCodeGenerator.getType(authId);
    _builder.append(_type_1, "\t");
    _builder.append(" user, RoleTO role) throws Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Role foundRole = em.find(Role.class, role.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    String _name_15 = authEntity.getName();
    String _firstUpper_9 = StringExtensions.toFirstUpper(_name_15);
    _builder.append(_firstUpper_9, "\t\t");
    _builder.append("RolePK pk = new ");
    String _name_16 = authEntity.getName();
    String _firstUpper_10 = StringExtensions.toFirstUpper(_name_16);
    _builder.append(_firstUpper_10, "\t\t");
    _builder.append("RolePK();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("pk.setRole(role.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pk.set");
    String _name_17 = authEntity.getName();
    String _firstUpper_11 = StringExtensions.toFirstUpper(_name_17);
    _builder.append(_firstUpper_11, "\t\t");
    _builder.append("(user);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    String _name_18 = authEntity.getName();
    String _firstUpper_12 = StringExtensions.toFirstUpper(_name_18);
    _builder.append(_firstUpper_12, "\t\t");
    _builder.append("Role uR = em.find(");
    String _name_19 = authEntity.getName();
    String _firstUpper_13 = StringExtensions.toFirstUpper(_name_19);
    _builder.append(_firstUpper_13, "\t\t");
    _builder.append("Role.class, pk);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (uR == null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("uR = new ");
    String _name_20 = authEntity.getName();
    String _firstUpper_14 = StringExtensions.toFirstUpper(_name_20);
    _builder.append(_firstUpper_14, "\t\t\t");
    _builder.append("Role();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("uR.setId(pk);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("uR.setRoleBean(foundRole);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("foundRole.get");
    String _name_21 = authEntity.getName();
    String _firstUpper_15 = StringExtensions.toFirstUpper(_name_21);
    _builder.append(_firstUpper_15, "\t\t\t");
    _builder.append("Roles().add(uR);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.merge(foundRole);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.flush();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (DatabaseException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new Exception(\"Role alredy related to ");
    String _name_22 = authEntity.getName();
    String _lowerCase_15 = _name_22.toLowerCase();
    _builder.append(_lowerCase_15, "\t\t\t");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean removeRoleFrom");
    String _name_23 = authEntity.getName();
    String _firstUpper_16 = StringExtensions.toFirstUpper(_name_23);
    _builder.append(_firstUpper_16, "\t");
    _builder.append(" (");
    String _name_24 = authEntity.getName();
    String _firstUpper_17 = StringExtensions.toFirstUpper(_name_24);
    _builder.append(_firstUpper_17, "\t");
    _builder.append("TO user, RoleTO role) throws Exception {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Role foundRole = em.find(Role.class, role.getName());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    String _name_25 = authEntity.getName();
    String _firstUpper_18 = StringExtensions.toFirstUpper(_name_25);
    _builder.append(_firstUpper_18, "\t\t");
    _builder.append("RolePK pk = new ");
    String _name_26 = authEntity.getName();
    String _firstUpper_19 = StringExtensions.toFirstUpper(_name_26);
    _builder.append(_firstUpper_19, "\t\t");
    _builder.append("RolePK();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("pk.setRole(role.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("pk.set");
    String _name_27 = authEntity.getName();
    String _firstUpper_20 = StringExtensions.toFirstUpper(_name_27);
    _builder.append(_firstUpper_20, "\t\t");
    _builder.append("(");
    String _name_28 = authEntity.getName();
    String _lowerCase_16 = _name_28.toLowerCase();
    _builder.append(_lowerCase_16, "\t\t");
    _builder.append(".get");
    Attribute _iD = DomainCodeGenerator.getID(authEntity);
    String _name_29 = _iD.getName();
    String _firstUpper_21 = StringExtensions.toFirstUpper(_name_29);
    _builder.append(_firstUpper_21, "\t\t");
    _builder.append("());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_30 = authEntity.getName();
    String _firstUpper_22 = StringExtensions.toFirstUpper(_name_30);
    _builder.append(_firstUpper_22, "\t\t");
    _builder.append("Role uR = em.find(");
    String _name_31 = authEntity.getName();
    String _firstUpper_23 = StringExtensions.toFirstUpper(_name_31);
    _builder.append(_firstUpper_23, "\t\t");
    _builder.append("Role.class, pk);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("foundRole.get");
    String _name_32 = authEntity.getName();
    String _firstUpper_24 = StringExtensions.toFirstUpper(_name_32);
    _builder.append(_firstUpper_24, "\t\t");
    _builder.append("Roles().remove(uR);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("em.merge(foundRole);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("em.flush();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (DatabaseException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean addServiceToRole (String roleName, ServiceTO service) throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Role foundRole = em.find(Role.class, roleName);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Service foundService = em.find(Service.class, service.getName());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (!foundRole.getServices().contains(foundService)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("foundRole.getServices().add(foundService);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.merge(foundRole);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.flush();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (DatabaseException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new Exception(\"Service alredy related to role\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public boolean removeServiceFromRole (RoleTO role, ServiceTO service) throws Exception {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Role foundRole = em.find(Role.class, role.getName());");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Service foundService = em.find(Service.class, service.getName());");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (foundRole.getServices().contains(foundService)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("foundRole.getServices().remove(foundService);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.merge(foundRole);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("em.flush();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} catch (DatabaseException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return false;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new Exception(\"Service is not related to role\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public List<ServiceTO> get");
    String _name_33 = authEntity.getName();
    String _firstUpper_25 = StringExtensions.toFirstUpper(_name_33);
    _builder.append(_firstUpper_25, "\t");
    _builder.append("Services (");
    String _type_2 = DomainCodeGenerator.getType(authId);
    _builder.append(_type_2, "\t");
    _builder.append(" ");
    String _name_34 = authId.getName();
    String _lowerCase_17 = _name_34.toLowerCase();
    _builder.append(_lowerCase_17, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("List<RoleTO> ");
    String _name_35 = authEntity.getName();
    String _lowerCase_18 = _name_35.toLowerCase();
    _builder.append(_lowerCase_18, "\t\t");
    _builder.append("Roles = get");
    String _name_36 = authEntity.getName();
    String _firstUpper_26 = StringExtensions.toFirstUpper(_name_36);
    _builder.append(_firstUpper_26, "\t\t");
    _builder.append("Roles(");
    String _name_37 = authId.getName();
    String _lowerCase_19 = _name_37.toLowerCase();
    _builder.append(_lowerCase_19, "\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Set<ServiceTO> ");
    String _name_38 = authEntity.getName();
    String _lowerCase_20 = _name_38.toLowerCase();
    _builder.append(_lowerCase_20, "\t\t");
    _builder.append("ServicesHash = new HashSet<>();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (RoleTO roleTO : ");
    String _name_39 = authEntity.getName();
    String _lowerCase_21 = _name_39.toLowerCase();
    _builder.append(_lowerCase_21, "\t\t");
    _builder.append("Roles) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    String _name_40 = authEntity.getName();
    String _lowerCase_22 = _name_40.toLowerCase();
    _builder.append(_lowerCase_22, "\t\t\t");
    _builder.append("ServicesHash.addAll(getRoleServices(roleTO.getName()));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new ArrayList<>(");
    String _name_41 = authEntity.getName();
    String _lowerCase_23 = _name_41.toLowerCase();
    _builder.append(_lowerCase_23, "\t\t");
    _builder.append("ServicesHash);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
