package co.shift.templates.database.basic;

import co.shift.generators.domain.DomainCodeUtilities;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Simple;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class MERScriptTemplate {
  public static CharSequence generate(final String packageName, final BusinessEntity authBe, final List<Association> associations) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("DROP SCHEMA IF EXISTS `");
    _builder.append(packageName, "");
    _builder.append("` ;");
    _builder.newLineIfNotEmpty();
    _builder.append("CREATE SCHEMA IF NOT EXISTS `");
    _builder.append(packageName, "");
    _builder.append("` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;");
    _builder.newLineIfNotEmpty();
    _builder.append("USE `");
    _builder.append(packageName, "");
    _builder.append("` ;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    List<String> fks = new ArrayList<String>();
    _builder.newLineIfNotEmpty();
    HashSet<BusinessEntity> entities = DomainCodeUtilities.getBusinessEntities();
    _builder.newLineIfNotEmpty();
    boolean add = entities.add(authBe);
    _builder.newLineIfNotEmpty();
    {
      for(final BusinessEntity entity : entities) {
        Attribute entityId = DomainCodeUtilities.getID(entity);
        _builder.newLineIfNotEmpty();
        _builder.append("-- -----------------------------------------------------");
        _builder.newLine();
        _builder.append("-- Table `");
        _builder.append(packageName, "");
        _builder.append("`.`");
        String _name = entity.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        _builder.append(_firstUpper, "");
        _builder.append("`");
        _builder.newLineIfNotEmpty();
        _builder.append("-- -----------------------------------------------------");
        _builder.newLine();
        _builder.append("DROP TABLE IF EXISTS `");
        _builder.append(packageName, "");
        _builder.append("`.`");
        String _name_1 = entity.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
        _builder.append(_firstUpper_1, "");
        _builder.append("` ;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("CREATE TABLE IF NOT EXISTS `");
        _builder.append(packageName, "");
        _builder.append("`.`");
        String _name_2 = entity.getName();
        String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
        _builder.append(_firstUpper_2, "");
        _builder.append("` (");
        _builder.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes = entity.getAttributes();
          for(final Attribute att : _attributes) {
            _builder.append("`");
            String _name_3 = att.getName();
            String _lowerCase = _name_3.toLowerCase();
            _builder.append(_lowerCase, "");
            _builder.append("` ");
            String _type = DomainCodeUtilities.getType(att);
            String _mySqlEquivalent = DomainCodeUtilities.getMySqlEquivalent(_type);
            _builder.append(_mySqlEquivalent, "");
            _builder.append(" ");
            String _isMySqlNull = DomainCodeUtilities.isMySqlNull(att);
            _builder.append(_isMySqlNull, "");
            _builder.append(",");
            _builder.newLineIfNotEmpty();
          }
        }
        boolean endComma = false;
        _builder.newLineIfNotEmpty();
        {
          EList<Association> _associations = entity.getAssociations();
          for(final Association association : _associations) {
            {
              if ((association instanceof Simple)) {
                BusinessEntity _relatedEntity = ((Simple)association).getRelatedEntity();
                BusinessEntity relEntity = ((BusinessEntity) _relatedEntity);
                _builder.newLineIfNotEmpty();
                Attribute relEntityId = DomainCodeUtilities.getID(relEntity);
                _builder.newLineIfNotEmpty();
                {
                  if (endComma) {
                    _builder.append(",");
                  }
                }
                _builder.append("`");
                String _name_4 = ((Simple)association).getName();
                String _lowerCase_1 = _name_4.toLowerCase();
                _builder.append(_lowerCase_1, "");
                _builder.append("` ");
                String _type_1 = DomainCodeUtilities.getType(relEntityId);
                String _mySqlEquivalent_1 = DomainCodeUtilities.getMySqlEquivalent(_type_1);
                _builder.append(_mySqlEquivalent_1, "");
                _builder.append(" NULL,");
                _builder.newLineIfNotEmpty();
                _builder.append("INDEX `fk_");
                String _name_5 = entity.getName();
                String _firstUpper_3 = StringExtensions.toFirstUpper(_name_5);
                _builder.append(_firstUpper_3, "");
                _builder.append("_");
                String _name_6 = relEntity.getName();
                String _firstUpper_4 = StringExtensions.toFirstUpper(_name_6);
                _builder.append(_firstUpper_4, "");
                _builder.append("_");
                String _name_7 = ((Simple)association).getName();
                String _firstUpper_5 = StringExtensions.toFirstUpper(_name_7);
                _builder.append(_firstUpper_5, "");
                _builder.append("` (`");
                String _name_8 = ((Simple)association).getName();
                String _lowerCase_2 = _name_8.toLowerCase();
                _builder.append(_lowerCase_2, "");
                _builder.append("` ASC)");
                _builder.append("\t\t");
                String _name_9 = entity.getName();
                String _firstUpper_6 = StringExtensions.toFirstUpper(_name_9);
                String _plus = ("ALTER TABLE " + _firstUpper_6);
                String _plus_1 = (_plus + " ADD CONSTRAINT ");
                String _plus_2 = (_plus_1 + 
                  "`c_fk_");
                String _name_10 = entity.getName();
                String _firstUpper_7 = StringExtensions.toFirstUpper(_name_10);
                String _plus_3 = (_plus_2 + _firstUpper_7);
                String _plus_4 = (_plus_3 + "_");
                String _name_11 = relEntity.getName();
                String _firstUpper_8 = StringExtensions.toFirstUpper(_name_11);
                String _plus_5 = (_plus_4 + _firstUpper_8);
                String _plus_6 = (_plus_5 + "` FOREIGN KEY (`");
                String _name_12 = ((Simple)association).getName();
                String _lowerCase_3 = _name_12.toLowerCase();
                String _plus_7 = (_plus_6 + _lowerCase_3);
                String _plus_8 = (_plus_7 + "`) REFERENCES `");
                String _plus_9 = (_plus_8 + packageName);
                String _plus_10 = (_plus_9 + "`.`");
                String _name_13 = relEntity.getName();
                String _firstUpper_9 = StringExtensions.toFirstUpper(_name_13);
                String _plus_11 = (_plus_10 + _firstUpper_9);
                String _plus_12 = (_plus_11 + 
                  "` (`");
                Attribute _iD = DomainCodeUtilities.getID(relEntity);
                String _name_14 = _iD.getName();
                String _lowerCase_4 = _name_14.toLowerCase();
                String _plus_13 = (_plus_12 + _lowerCase_4);
                String _plus_14 = (_plus_13 + "`) ON DELETE NO ACTION ON UPDATE NO ACTION;");
                boolean addFk = fks.add(_plus_14);
                _builder.newLineIfNotEmpty();
                boolean modEndComma = endComma = true;
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          List<Association> _detailMultipleAssociations = DomainCodeUtilities.getDetailMultipleAssociations(entity, associations);
          for(final Association association_1 : _detailMultipleAssociations) {
            {
              boolean _hasZeroAssociations = DomainCodeUtilities.hasZeroAssociations(entity);
              if (_hasZeroAssociations) {
                EObject _eContainer = association_1.eContainer();
                BusinessEntity relEntity_1 = ((BusinessEntity) _eContainer);
                _builder.newLineIfNotEmpty();
                Attribute relEntityId_1 = DomainCodeUtilities.getID(relEntity_1);
                _builder.newLineIfNotEmpty();
                {
                  if (endComma) {
                    _builder.append(",");
                  }
                }
                _builder.append("`");
                String _name_15 = relEntity_1.getName();
                String _lowerCase_5 = _name_15.toLowerCase();
                _builder.append(_lowerCase_5, "");
                _builder.append("` ");
                String _type_2 = DomainCodeUtilities.getType(relEntityId_1);
                String _mySqlEquivalent_2 = DomainCodeUtilities.getMySqlEquivalent(_type_2);
                _builder.append(_mySqlEquivalent_2, "");
                _builder.append(" ");
                String _isMySqlNull_1 = DomainCodeUtilities.isMySqlNull(relEntityId_1);
                _builder.append(_isMySqlNull_1, "");
                _builder.append(",");
                _builder.newLineIfNotEmpty();
                _builder.append("INDEX `fk_");
                String _name_16 = entity.getName();
                String _firstUpper_10 = StringExtensions.toFirstUpper(_name_16);
                _builder.append(_firstUpper_10, "");
                _builder.append("_");
                String _name_17 = relEntity_1.getName();
                String _firstUpper_11 = StringExtensions.toFirstUpper(_name_17);
                _builder.append(_firstUpper_11, "");
                _builder.append("_");
                String _name_18 = association_1.getName();
                String _firstUpper_12 = StringExtensions.toFirstUpper(_name_18);
                _builder.append(_firstUpper_12, "");
                _builder.append("` (`");
                String _name_19 = relEntity_1.getName();
                String _lowerCase_6 = _name_19.toLowerCase();
                _builder.append(_lowerCase_6, "");
                _builder.append("` ASC)");
                _builder.append("\t\t");
                String _name_20 = entity.getName();
                String _firstUpper_13 = StringExtensions.toFirstUpper(_name_20);
                String _plus_15 = ("ALTER TABLE " + _firstUpper_13);
                String _plus_16 = (_plus_15 + " ADD CONSTRAINT ");
                String _plus_17 = (_plus_16 + 
                  "`c_fk_");
                String _name_21 = entity.getName();
                String _firstUpper_14 = StringExtensions.toFirstUpper(_name_21);
                String _plus_18 = (_plus_17 + _firstUpper_14);
                String _plus_19 = (_plus_18 + "_");
                String _name_22 = relEntity_1.getName();
                String _firstUpper_15 = StringExtensions.toFirstUpper(_name_22);
                String _plus_20 = (_plus_19 + _firstUpper_15);
                String _plus_21 = (_plus_20 + "` FOREIGN KEY (`");
                String _name_23 = relEntity_1.getName();
                String _lowerCase_7 = _name_23.toLowerCase();
                String _plus_22 = (_plus_21 + _lowerCase_7);
                String _plus_23 = (_plus_22 + "`) REFERENCES `");
                String _plus_24 = (_plus_23 + packageName);
                String _plus_25 = (_plus_24 + "`.`");
                String _name_24 = relEntity_1.getName();
                String _firstUpper_16 = StringExtensions.toFirstUpper(_name_24);
                String _plus_26 = (_plus_25 + _firstUpper_16);
                String _plus_27 = (_plus_26 + 
                  "` (`");
                Attribute _iD_1 = DomainCodeUtilities.getID(relEntity_1);
                String _name_25 = _iD_1.getName();
                String _lowerCase_8 = _name_25.toLowerCase();
                String _plus_28 = (_plus_27 + _lowerCase_8);
                String _plus_29 = (_plus_28 + "`) ON DELETE NO ACTION ON UPDATE NO ACTION;");
                boolean addFk_1 = fks.add(_plus_29);
                _builder.newLineIfNotEmpty();
                boolean modEndComma_1 = endComma = true;
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        {
          if (endComma) {
            _builder.append(",");
          }
        }
        _builder.append("PRIMARY KEY (`");
        String _name_26 = entityId.getName();
        String _lowerCase_9 = _name_26.toLowerCase();
        _builder.append(_lowerCase_9, "");
        _builder.append("`))");
        _builder.newLineIfNotEmpty();
        _builder.append("ENGINE = InnoDB;");
        _builder.newLine();
      }
    }
    {
      List<BusinessEntity[]> _manyToManyAssociations = DomainCodeUtilities.getManyToManyAssociations();
      for(final BusinessEntity[] mTm : _manyToManyAssociations) {
        BusinessEntity a = mTm[0];
        _builder.newLineIfNotEmpty();
        BusinessEntity b = mTm[1];
        _builder.newLineIfNotEmpty();
        Attribute aID = DomainCodeUtilities.getID(a);
        _builder.newLineIfNotEmpty();
        Attribute bID = DomainCodeUtilities.getID(b);
        _builder.newLineIfNotEmpty();
        String _name_27 = a.getName();
        String _firstUpper_17 = StringExtensions.toFirstUpper(_name_27);
        String _name_28 = b.getName();
        String _firstUpper_18 = StringExtensions.toFirstUpper(_name_28);
        String mTmName = (_firstUpper_17 + _firstUpper_18);
        _builder.newLineIfNotEmpty();
        _builder.append("-- -----------------------------------------------------");
        _builder.newLine();
        _builder.append("-- Table `");
        _builder.append(packageName, "");
        _builder.append("`.`");
        _builder.append(mTmName, "");
        _builder.append("`");
        _builder.newLineIfNotEmpty();
        _builder.append("-- -----------------------------------------------------");
        _builder.newLine();
        _builder.append("DROP TABLE IF EXISTS `");
        _builder.append(packageName, "");
        _builder.append("`.`");
        _builder.append(mTmName, "");
        _builder.append("` ;");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("CREATE TABLE IF NOT EXISTS `");
        _builder.append(packageName, "");
        _builder.append("`.`");
        _builder.append(mTmName, "");
        _builder.append("` (");
        _builder.newLineIfNotEmpty();
        _builder.append("`");
        String _name_29 = a.getName();
        String _lowerCase_10 = _name_29.toLowerCase();
        _builder.append(_lowerCase_10, "");
        String _name_30 = aID.getName();
        String _firstUpper_19 = StringExtensions.toFirstUpper(_name_30);
        _builder.append(_firstUpper_19, "");
        _builder.append("` ");
        String _type_3 = DomainCodeUtilities.getType(aID);
        String _mySqlEquivalent_3 = DomainCodeUtilities.getMySqlEquivalent(_type_3);
        _builder.append(_mySqlEquivalent_3, "");
        _builder.append(" NOT NULL,");
        _builder.newLineIfNotEmpty();
        _builder.append("`");
        String _name_31 = b.getName();
        String _lowerCase_11 = _name_31.toLowerCase();
        _builder.append(_lowerCase_11, "");
        String _name_32 = bID.getName();
        String _firstUpper_20 = StringExtensions.toFirstUpper(_name_32);
        _builder.append(_firstUpper_20, "");
        _builder.append("` ");
        String _type_4 = DomainCodeUtilities.getType(bID);
        String _mySqlEquivalent_4 = DomainCodeUtilities.getMySqlEquivalent(_type_4);
        _builder.append(_mySqlEquivalent_4, "");
        _builder.append(" NOT NULL,");
        _builder.newLineIfNotEmpty();
        _builder.append("PRIMARY KEY (`");
        String _name_33 = a.getName();
        String _lowerCase_12 = _name_33.toLowerCase();
        _builder.append(_lowerCase_12, "");
        String _name_34 = aID.getName();
        String _firstUpper_21 = StringExtensions.toFirstUpper(_name_34);
        _builder.append(_firstUpper_21, "");
        _builder.append("`, `");
        String _name_35 = b.getName();
        String _lowerCase_13 = _name_35.toLowerCase();
        _builder.append(_lowerCase_13, "");
        String _name_36 = bID.getName();
        String _firstUpper_22 = StringExtensions.toFirstUpper(_name_36);
        _builder.append(_firstUpper_22, "");
        _builder.append("`),");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("INDEX `fk_");
        String _name_37 = a.getName();
        String _firstUpper_23 = StringExtensions.toFirstUpper(_name_37);
        _builder.append(_firstUpper_23, "  ");
        _builder.append("_has_");
        String _name_38 = b.getName();
        String _firstUpper_24 = StringExtensions.toFirstUpper(_name_38);
        _builder.append(_firstUpper_24, "  ");
        _builder.append("_");
        String _name_39 = b.getName();
        String _firstUpper_25 = StringExtensions.toFirstUpper(_name_39);
        _builder.append(_firstUpper_25, "  ");
        _builder.append("_idx` (`");
        String _name_40 = a.getName();
        String _lowerCase_14 = _name_40.toLowerCase();
        _builder.append(_lowerCase_14, "  ");
        String _name_41 = aID.getName();
        String _firstUpper_26 = StringExtensions.toFirstUpper(_name_41);
        _builder.append(_firstUpper_26, "  ");
        _builder.append("` ASC),");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("INDEX `fk_");
        String _name_42 = a.getName();
        String _firstUpper_27 = StringExtensions.toFirstUpper(_name_42);
        _builder.append(_firstUpper_27, "  ");
        _builder.append("_has_");
        String _name_43 = b.getName();
        String _firstUpper_28 = StringExtensions.toFirstUpper(_name_43);
        _builder.append(_firstUpper_28, "  ");
        _builder.append("_");
        String _name_44 = a.getName();
        String _firstUpper_29 = StringExtensions.toFirstUpper(_name_44);
        _builder.append(_firstUpper_29, "  ");
        _builder.append("_idx` (`");
        String _name_45 = b.getName();
        String _lowerCase_15 = _name_45.toLowerCase();
        _builder.append(_lowerCase_15, "  ");
        String _name_46 = bID.getName();
        String _firstUpper_30 = StringExtensions.toFirstUpper(_name_46);
        _builder.append(_firstUpper_30, "  ");
        _builder.append("` ASC),");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("CONSTRAINT `fk_");
        String _name_47 = a.getName();
        String _firstUpper_31 = StringExtensions.toFirstUpper(_name_47);
        _builder.append(_firstUpper_31, "  ");
        _builder.append("_has_");
        String _name_48 = b.getName();
        String _firstUpper_32 = StringExtensions.toFirstUpper(_name_48);
        _builder.append(_firstUpper_32, "  ");
        _builder.append("_");
        String _name_49 = a.getName();
        String _firstUpper_33 = StringExtensions.toFirstUpper(_name_49);
        _builder.append(_firstUpper_33, "  ");
        _builder.append("`");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("FOREIGN KEY (`");
        String _name_50 = a.getName();
        String _lowerCase_16 = _name_50.toLowerCase();
        _builder.append(_lowerCase_16, "    ");
        String _name_51 = aID.getName();
        String _firstUpper_34 = StringExtensions.toFirstUpper(_name_51);
        _builder.append(_firstUpper_34, "    ");
        _builder.append("`)");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("REFERENCES `");
        _builder.append(packageName, "    ");
        _builder.append("`.`");
        String _name_52 = a.getName();
        String _firstUpper_35 = StringExtensions.toFirstUpper(_name_52);
        _builder.append(_firstUpper_35, "    ");
        _builder.append("` (`");
        String _name_53 = aID.getName();
        String _lowerCase_17 = _name_53.toLowerCase();
        _builder.append(_lowerCase_17, "    ");
        _builder.append("`)");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("ON DELETE NO ACTION");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("ON UPDATE NO ACTION,");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("CONSTRAINT `fk_");
        String _name_54 = a.getName();
        String _firstUpper_36 = StringExtensions.toFirstUpper(_name_54);
        _builder.append(_firstUpper_36, "  ");
        _builder.append("_has_");
        String _name_55 = b.getName();
        String _firstUpper_37 = StringExtensions.toFirstUpper(_name_55);
        _builder.append(_firstUpper_37, "  ");
        _builder.append("_");
        String _name_56 = b.getName();
        String _firstUpper_38 = StringExtensions.toFirstUpper(_name_56);
        _builder.append(_firstUpper_38, "  ");
        _builder.append("`");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("FOREIGN KEY (`");
        String _name_57 = b.getName();
        String _lowerCase_18 = _name_57.toLowerCase();
        _builder.append(_lowerCase_18, "    ");
        String _name_58 = bID.getName();
        String _firstUpper_39 = StringExtensions.toFirstUpper(_name_58);
        _builder.append(_firstUpper_39, "    ");
        _builder.append("`)");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("REFERENCES `");
        _builder.append(packageName, "    ");
        _builder.append("`.`");
        String _name_59 = b.getName();
        String _firstUpper_40 = StringExtensions.toFirstUpper(_name_59);
        _builder.append(_firstUpper_40, "    ");
        _builder.append("` (`");
        String _name_60 = bID.getName();
        String _lowerCase_19 = _name_60.toLowerCase();
        _builder.append(_lowerCase_19, "    ");
        _builder.append("`)");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("ON DELETE NO ACTION");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("ON UPDATE NO ACTION)");
        _builder.newLine();
        _builder.append("ENGINE = InnoDB;");
        _builder.newLine();
      }
    }
    _builder.append("-- -----------------------------------------------------");
    _builder.newLine();
    _builder.append("-- Foreign Keys");
    _builder.newLine();
    _builder.append("-- -----------------------------------------------------");
    _builder.newLine();
    {
      for(final String fk : fks) {
        _builder.append(fk, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
