package co.shift.templates.ejb.basic;

import co.shift.generators.domain.DomainCodeUtilities;
import com.google.common.base.Objects;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.DataType;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DAOImplTemplate {
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
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.Date;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ejb.EJB;");
    _builder.newLine();
    _builder.append("import javax.ejb.Stateless;");
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManager;");
    _builder.newLine();
    _builder.append("import javax.persistence.NoResultException;");
    _builder.newLine();
    _builder.append("import javax.persistence.PersistenceContext;");
    _builder.newLine();
    _builder.append("import javax.persistence.Query;");
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
    final String attribute2 = DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_ATTRIBUTE);
    _builder.newLineIfNotEmpty();
    {
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(attribute2, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _equals = attribute2.equals("");
        boolean _not = (!_equals);
        _and = _not;
      }
      if (_and) {
        _builder.append("import java.io.UnsupportedEncodingException;");
        _builder.newLine();
        _builder.append("import java.security.InvalidAlgorithmParameterException;");
        _builder.newLine();
        _builder.append("import java.security.InvalidKeyException;");
        _builder.newLine();
        _builder.append("import java.security.NoSuchAlgorithmException;");
        _builder.newLine();
        _builder.append("import java.security.spec.InvalidKeySpecException;");
        _builder.newLine();
        _builder.append("import javax.crypto.BadPaddingException;");
        _builder.newLine();
        _builder.append("import javax.crypto.Cipher;");
        _builder.newLine();
        _builder.append("import javax.crypto.IllegalBlockSizeException;");
        _builder.newLine();
        _builder.append("import javax.crypto.NoSuchPaddingException;");
        _builder.newLine();
        _builder.append("import javax.crypto.SecretKey;");
        _builder.newLine();
        _builder.append("import javax.crypto.SecretKeyFactory;");
        _builder.newLine();
        _builder.append("import javax.crypto.spec.PBEKeySpec;");
        _builder.newLine();
        _builder.append("import javax.crypto.spec.PBEParameterSpec;");
        _builder.newLine();
        _builder.append("import org.apache.commons.codec.binary.Base64;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("@Stateless");
    _builder.newLine();
    _builder.append("public class ");
    String _name_2 = be.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper_1, "");
    _builder.append("DAO implements I");
    String _name_3 = be.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
    _builder.append(_firstUpper_2, "");
    _builder.append("DAO {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@PersistenceContext(unitName = \"");
    _builder.append(packageName, "\t");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private EntityManager em;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    {
      List<Association> _detailSimpleAssociations = DomainCodeUtilities.getDetailSimpleAssociations(be, associations);
      for(final Association association : _detailSimpleAssociations) {
        _builder.append("\t");
        EObject _eContainer = association.eContainer();
        final BusinessEntity container = ((BusinessEntity) _eContainer);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Attribute _iD = DomainCodeUtilities.getID(container);
        DataType _dataType = _iD.getDataType();
        final String type = _dataType.getLiteral();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public ");
        String _name_4 = be.getName();
        _builder.append(_name_4, "\t");
        _builder.append("TO get");
        String _name_5 = container.getName();
        String _firstUpper_3 = StringExtensions.toFirstUpper(_name_5);
        _builder.append(_firstUpper_3, "\t");
        String _name_6 = association.getName();
        String _firstUpper_4 = StringExtensions.toFirstUpper(_name_6);
        _builder.append(_firstUpper_4, "\t");
        _builder.append("(");
        String _type = DomainCodeUtilities.getType(type);
        _builder.append(_type, "\t");
        _builder.append(" ");
        String _name_7 = container.getName();
        String _lowerCase_3 = _name_7.toLowerCase();
        _builder.append(_lowerCase_3, "\t");
        Attribute _iD_1 = DomainCodeUtilities.getID(container);
        String _name_8 = _iD_1.getName();
        String _firstUpper_5 = StringExtensions.toFirstUpper(_name_8);
        _builder.append(_firstUpper_5, "\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _and_1 = false;
          boolean _notEquals_1 = (!Objects.equal(attribute2, null));
          if (!_notEquals_1) {
            _and_1 = false;
          } else {
            boolean _equals_1 = attribute2.equals("");
            boolean _not_1 = (!_equals_1);
            _and_1 = _not_1;
          }
          if (_and_1) {
            _builder.append("PBECryptographyManager.init();");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Query query = em");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append(".createNativeQuery(\"SELECT u.* FROM ");
        String _name_9 = be.getName();
        String _firstUpper_6 = StringExtensions.toFirstUpper(_name_9);
        _builder.append(_firstUpper_6, "\t\t");
        _builder.append(" u, ");
        String _name_10 = container.getName();
        String _firstUpper_7 = StringExtensions.toFirstUpper(_name_10);
        _builder.append(_firstUpper_7, "\t\t");
        _builder.append(" p WHERE p.");
        String _name_11 = association.getName();
        String _lowerCase_4 = _name_11.toLowerCase();
        _builder.append(_lowerCase_4, "\t\t");
        _builder.append(" = u.");
        Attribute _iD_2 = DomainCodeUtilities.getID(be);
        String _name_12 = _iD_2.getName();
        String _lowerCase_5 = _name_12.toLowerCase();
        _builder.append(_lowerCase_5, "\t\t");
        _builder.append(" AND p.");
        Attribute _iD_3 = DomainCodeUtilities.getID(container);
        String _name_13 = _iD_3.getName();
        String _lowerCase_6 = _name_13.toLowerCase();
        _builder.append(_lowerCase_6, "\t\t");
        _builder.append(" = \"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("+ ");
        String _name_14 = container.getName();
        String _lowerCase_7 = _name_14.toLowerCase();
        _builder.append(_lowerCase_7, "\t\t\t\t");
        Attribute _iD_4 = DomainCodeUtilities.getID(container);
        String _name_15 = _iD_4.getName();
        String _firstUpper_8 = StringExtensions.toFirstUpper(_name_15);
        _builder.append(_firstUpper_8, "\t\t\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("Object[] ");
        String _name_16 = association.getName();
        String _lowerCase_8 = _name_16.toLowerCase();
        _builder.append(_lowerCase_8, "\t\t\t");
        _builder.append(" = (Object[]) query.getSingleResult();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        String _name_17 = be.getName();
        String _firstUpper_9 = StringExtensions.toFirstUpper(_name_17);
        _builder.append(_firstUpper_9, "\t\t\t");
        _builder.append("TO u = new ");
        String _name_18 = be.getName();
        String _firstUpper_10 = StringExtensions.toFirstUpper(_name_18);
        _builder.append(_firstUpper_10, "\t\t\t");
        _builder.append("TO();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        int i = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes = be.getAttributes();
          for(final Attribute attribute : _attributes) {
            _builder.append("\t");
            _builder.append("\t\t");
            String _type_1 = DomainCodeUtilities.getType(attribute);
            _builder.append(_type_1, "\t\t\t");
            _builder.append(" t");
            String _name_19 = attribute.getName();
            String _firstUpper_11 = StringExtensions.toFirstUpper(_name_19);
            _builder.append(_firstUpper_11, "\t\t\t");
            _builder.append(" = (");
            String _type_2 = DomainCodeUtilities.getType(attribute);
            _builder.append(_type_2, "\t\t\t");
            _builder.append(") ");
            String _name_20 = association.getName();
            String _lowerCase_9 = _name_20.toLowerCase();
            _builder.append(_lowerCase_9, "\t\t\t");
            _builder.append("[");
            _builder.append(i, "\t\t\t");
            _builder.append("];");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            int c = i++;
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        String _extendContribution = DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, Integer.valueOf(3));
        _builder.append(_extendContribution, "\t\t\t");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_1 = be.getAttributes();
          for(final Attribute attribute_1 : _attributes_1) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("u.set");
            String _name_21 = attribute_1.getName();
            String _firstUpper_12 = StringExtensions.toFirstUpper(_name_21);
            _builder.append(_firstUpper_12, "\t\t\t");
            _builder.append("(t");
            String _name_22 = attribute_1.getName();
            String _firstUpper_13 = StringExtensions.toFirstUpper(_name_22);
            _builder.append(_firstUpper_13, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return u;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (NoResultException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return null;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      List<Association> _detailMultipleAssociations = DomainCodeUtilities.getDetailMultipleAssociations(be, associations);
      for(final Association association_1 : _detailMultipleAssociations) {
        _builder.append("\t");
        EObject _eContainer_1 = association_1.eContainer();
        final BusinessEntity container_1 = ((BusinessEntity) _eContainer_1);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Attribute _iD_5 = DomainCodeUtilities.getID(container_1);
        String contType = DomainCodeUtilities.getType(_iD_5);
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        Attribute _iD_6 = DomainCodeUtilities.getID(container_1);
        DataType _dataType_1 = _iD_6.getDataType();
        final String type_1 = _dataType_1.getLiteral();
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public List<");
        String _name_23 = be.getName();
        String _firstUpper_14 = StringExtensions.toFirstUpper(_name_23);
        _builder.append(_firstUpper_14, "\t");
        _builder.append("TO> get");
        String _name_24 = be.getName();
        String _firstUpper_15 = StringExtensions.toFirstUpper(_name_24);
        _builder.append(_firstUpper_15, "\t");
        _builder.append("From");
        String _name_25 = container_1.getName();
        String _firstUpper_16 = StringExtensions.toFirstUpper(_name_25);
        _builder.append(_firstUpper_16, "\t");
        _builder.append("(");
        String _type_3 = DomainCodeUtilities.getType(type_1);
        _builder.append(_type_3, "\t");
        _builder.append(" ");
        String _name_26 = container_1.getName();
        String _lowerCase_10 = _name_26.toLowerCase();
        _builder.append(_lowerCase_10, "\t");
        Attribute _iD_7 = DomainCodeUtilities.getID(container_1);
        String _name_27 = _iD_7.getName();
        String _firstUpper_17 = StringExtensions.toFirstUpper(_name_27);
        _builder.append(_firstUpper_17, "\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("List<");
        String _name_28 = be.getName();
        String _firstUpper_18 = StringExtensions.toFirstUpper(_name_28);
        _builder.append(_firstUpper_18, "\t\t");
        _builder.append("TO> ");
        String _name_29 = be.getName();
        String _lowerCase_11 = _name_29.toLowerCase();
        _builder.append(_lowerCase_11, "\t\t");
        _builder.append("s = new ArrayList<>();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("Query query;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("List<Object[]> found");
        String _name_30 = be.getName();
        String _firstUpper_19 = StringExtensions.toFirstUpper(_name_30);
        _builder.append(_firstUpper_19, "\t\t");
        _builder.append("s;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("query = em");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append(".createNativeQuery(\"SELECT u.* FROM ");
        String _name_31 = be.getName();
        String _firstUpper_20 = StringExtensions.toFirstUpper(_name_31);
        _builder.append(_firstUpper_20, "\t\t\t\t\t");
        _builder.append(" u, ");
        String _name_32 = container_1.getName();
        String _firstUpper_21 = StringExtensions.toFirstUpper(_name_32);
        _builder.append(_firstUpper_21, "\t\t\t\t\t");
        String _name_33 = be.getName();
        String _firstUpper_22 = StringExtensions.toFirstUpper(_name_33);
        _builder.append(_firstUpper_22, "\t\t\t\t\t");
        _builder.append(" pu WHERE u.");
        Attribute _iD_8 = DomainCodeUtilities.getID(be);
        String _name_34 = _iD_8.getName();
        String _lowerCase_12 = _name_34.toLowerCase();
        _builder.append(_lowerCase_12, "\t\t\t\t\t");
        _builder.append(" = pu.");
        String _name_35 = be.getName();
        String _lowerCase_13 = _name_35.toLowerCase();
        _builder.append(_lowerCase_13, "\t\t\t\t\t");
        Attribute _iD_9 = DomainCodeUtilities.getID(be);
        String _name_36 = _iD_9.getName();
        String _firstUpper_23 = StringExtensions.toFirstUpper(_name_36);
        _builder.append(_firstUpper_23, "\t\t\t\t\t");
        _builder.append(" AND pu.");
        String _name_37 = container_1.getName();
        String _lowerCase_14 = _name_37.toLowerCase();
        _builder.append(_lowerCase_14, "\t\t\t\t\t");
        Attribute _iD_10 = DomainCodeUtilities.getID(container_1);
        String _name_38 = _iD_10.getName();
        String _firstUpper_24 = StringExtensions.toFirstUpper(_name_38);
        _builder.append(_firstUpper_24, "\t\t\t\t\t");
        _builder.append(" = ");
        {
          boolean _equals_2 = contType.equals("String");
          if (_equals_2) {
            _builder.append("\'");
          }
        }
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t\t");
        _builder.append("+ ");
        String _name_39 = container_1.getName();
        String _lowerCase_15 = _name_39.toLowerCase();
        _builder.append(_lowerCase_15, "\t\t\t\t\t\t\t");
        Attribute _iD_11 = DomainCodeUtilities.getID(container_1);
        String _name_40 = _iD_11.getName();
        String _firstUpper_25 = StringExtensions.toFirstUpper(_name_40);
        _builder.append(_firstUpper_25, "\t\t\t\t\t\t\t");
        {
          boolean _equals_3 = contType.equals("String");
          if (_equals_3) {
            _builder.append("+\"\'\"");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("found");
        String _name_41 = be.getName();
        String _firstUpper_26 = StringExtensions.toFirstUpper(_name_41);
        _builder.append(_firstUpper_26, "\t\t\t");
        _builder.append("s = query.getResultList();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (Exception e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("query = em");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append(".createNativeQuery(\"SELECT u.* FROM ");
        String _name_42 = be.getName();
        String _firstUpper_27 = StringExtensions.toFirstUpper(_name_42);
        _builder.append(_firstUpper_27, "\t\t\t\t\t");
        _builder.append(" u, ");
        String _name_43 = be.getName();
        String _firstUpper_28 = StringExtensions.toFirstUpper(_name_43);
        _builder.append(_firstUpper_28, "\t\t\t\t\t");
        String _name_44 = container_1.getName();
        String _firstUpper_29 = StringExtensions.toFirstUpper(_name_44);
        _builder.append(_firstUpper_29, "\t\t\t\t\t");
        _builder.append(" pu WHERE u.");
        Attribute _iD_12 = DomainCodeUtilities.getID(be);
        String _name_45 = _iD_12.getName();
        String _lowerCase_16 = _name_45.toLowerCase();
        _builder.append(_lowerCase_16, "\t\t\t\t\t");
        _builder.append(" = pu.");
        String _name_46 = be.getName();
        String _lowerCase_17 = _name_46.toLowerCase();
        _builder.append(_lowerCase_17, "\t\t\t\t\t");
        Attribute _iD_13 = DomainCodeUtilities.getID(be);
        String _name_47 = _iD_13.getName();
        String _firstUpper_30 = StringExtensions.toFirstUpper(_name_47);
        _builder.append(_firstUpper_30, "\t\t\t\t\t");
        _builder.append(" AND pu.");
        String _name_48 = container_1.getName();
        String _lowerCase_18 = _name_48.toLowerCase();
        _builder.append(_lowerCase_18, "\t\t\t\t\t");
        Attribute _iD_14 = DomainCodeUtilities.getID(container_1);
        String _name_49 = _iD_14.getName();
        String _firstUpper_31 = StringExtensions.toFirstUpper(_name_49);
        _builder.append(_firstUpper_31, "\t\t\t\t\t");
        _builder.append(" = ");
        {
          boolean _equals_4 = contType.equals("String");
          if (_equals_4) {
            _builder.append("\'");
          }
        }
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t\t\t\t\t");
        _builder.append("+ ");
        String _name_50 = container_1.getName();
        String _lowerCase_19 = _name_50.toLowerCase();
        _builder.append(_lowerCase_19, "\t\t\t\t\t\t\t");
        Attribute _iD_15 = DomainCodeUtilities.getID(container_1);
        String _name_51 = _iD_15.getName();
        String _firstUpper_32 = StringExtensions.toFirstUpper(_name_51);
        _builder.append(_firstUpper_32, "\t\t\t\t\t\t\t");
        {
          boolean _equals_5 = contType.equals("String");
          if (_equals_5) {
            _builder.append("+\"\'\"");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("found");
        String _name_52 = be.getName();
        String _firstUpper_33 = StringExtensions.toFirstUpper(_name_52);
        _builder.append(_firstUpper_33, "\t\t\t");
        _builder.append("s = query.getResultList();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        String _name_53 = be.getName();
        String _firstUpper_34 = StringExtensions.toFirstUpper(_name_53);
        _builder.append(_firstUpper_34, "\t\t");
        _builder.append("TO u = null;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _and_2 = false;
          boolean _notEquals_2 = (!Objects.equal(attribute2, null));
          if (!_notEquals_2) {
            _and_2 = false;
          } else {
            boolean _equals_6 = attribute2.equals("");
            boolean _not_2 = (!_equals_6);
            _and_2 = _not_2;
          }
          if (_and_2) {
            _builder.append("PBECryptographyManager.init();");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("for (Object[] ");
        String _name_54 = be.getName();
        String _lowerCase_20 = _name_54.toLowerCase();
        _builder.append(_lowerCase_20, "\t\t");
        _builder.append(" : found");
        String _name_55 = be.getName();
        String _firstUpper_35 = StringExtensions.toFirstUpper(_name_55);
        _builder.append(_firstUpper_35, "\t\t");
        _builder.append("s) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("u = new ");
        String _name_56 = be.getName();
        String _firstUpper_36 = StringExtensions.toFirstUpper(_name_56);
        _builder.append(_firstUpper_36, "\t\t\t");
        _builder.append("TO();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        int i_1 = 0;
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_2 = be.getAttributes();
          for(final Attribute attribute_2 : _attributes_2) {
            _builder.append("\t");
            _builder.append("\t\t");
            String _type_4 = DomainCodeUtilities.getType(attribute_2);
            _builder.append(_type_4, "\t\t\t");
            _builder.append(" t");
            String _name_57 = attribute_2.getName();
            String _firstUpper_37 = StringExtensions.toFirstUpper(_name_57);
            _builder.append(_firstUpper_37, "\t\t\t");
            _builder.append(" = (");
            String _type_5 = DomainCodeUtilities.getType(attribute_2);
            _builder.append(_type_5, "\t\t\t");
            _builder.append(") ");
            String _name_58 = be.getName();
            String _lowerCase_21 = _name_58.toLowerCase();
            _builder.append(_lowerCase_21, "\t\t\t");
            _builder.append("[");
            _builder.append(i_1, "\t\t\t");
            _builder.append("];");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t\t");
            int c_1 = i_1++;
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        String _extendContribution_1 = DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, Integer.valueOf(3));
        _builder.append(_extendContribution_1, "\t\t\t");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_3 = be.getAttributes();
          for(final Attribute attribute_3 : _attributes_3) {
            _builder.append("\t");
            _builder.append("\t\t");
            _builder.append("u.set");
            String _name_59 = attribute_3.getName();
            String _firstUpper_38 = StringExtensions.toFirstUpper(_name_59);
            _builder.append(_firstUpper_38, "\t\t\t");
            _builder.append("(t");
            String _name_60 = attribute_3.getName();
            String _firstUpper_39 = StringExtensions.toFirstUpper(_name_60);
            _builder.append(_firstUpper_39, "\t\t\t");
            _builder.append(");");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("\t\t");
        String _name_61 = be.getName();
        String _lowerCase_22 = _name_61.toLowerCase();
        _builder.append(_lowerCase_22, "\t\t\t");
        _builder.append("s.add(u);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        String _name_62 = be.getName();
        String _lowerCase_23 = _name_62.toLowerCase();
        _builder.append(_lowerCase_23, "\t\t");
        _builder.append("s;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      boolean _and_3 = false;
      boolean _notEquals_3 = (!Objects.equal(attribute2, null));
      if (!_notEquals_3) {
        _and_3 = false;
      } else {
        boolean _equals_7 = attribute2.equals("");
        boolean _not_3 = (!_equals_7);
        _and_3 = _not_3;
      }
      if (_and_3) {
        _builder.append("\t");
        _builder.append("class PBECryptographyManager {");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("private static PBEKeySpec pbeKeySpec;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("private static PBEParameterSpec pbeParamSpec;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("private static SecretKeyFactory keyFac;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("private static SecretKey pbeKey;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("private static Cipher pbeCipher;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("public static final int ENCRYPT = Cipher.ENCRYPT_MODE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("public static final int DECRYPT = Cipher.DECRYPT_MODE;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// Salt");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("private static byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("(byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("// Iteration count");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("private static final int COUNT = 20;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("public static void init() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("// Create PBE parameter set");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("pbeParamSpec = new PBEParameterSpec(salt, COUNT);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("pbeKeySpec = new PBEKeySpec(\"PCSUI\".toCharArray());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("keyFac = SecretKeyFactory.getInstance(\"PBEWithMD5AndDES\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("pbeKey = keyFac.generateSecret(pbeKeySpec);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("// Create PBE Cipher");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("pbeCipher = Cipher.getInstance(\"PBEWithMD5AndDES\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (NoSuchAlgorithmException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("// TODO Auto-generated catch block");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("e.printStackTrace();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (InvalidKeySpecException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("// TODO Auto-generated catch block");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("e.printStackTrace();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("} catch (NoSuchPaddingException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("// TODO Auto-generated catch block");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("e.printStackTrace();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("public static char[] doFinal(int mode, String text) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("switch (mode) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("case ENCRYPT:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("byte[] encryptedData = pbeCipher.doFinal(text.getBytes(\"UTF-8\"));");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("return new String(Base64.encodeBase64(encryptedData)).toCharArray();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("case DECRYPT:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("byte[] decodedData = Base64.decodeBase64(text);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("pbeCipher.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("byte[] utf8 = pbeCipher.doFinal(decodedData);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("return new String(utf8, \"UTF8\").toCharArray();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("default:");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("break;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("} catch (InvalidKeyException | InvalidAlgorithmParameterException");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t\t");
        _builder.append("| IllegalBlockSizeException | BadPaddingException  e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("// TODO Auto-generated catch block");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("e.printStackTrace();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("}catch (UnsupportedEncodingException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("// TODO Auto-generated catch block");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t\t");
        _builder.append("e.printStackTrace();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("} ");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("return null;\t\t\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
}
