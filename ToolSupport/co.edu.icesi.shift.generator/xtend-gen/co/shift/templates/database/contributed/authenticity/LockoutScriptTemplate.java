package co.shift.templates.database.contributed.authenticity;

import co.shift.generators.domain.DomainCodeUtilities;
import domainmetamodel.Attribute;
import domainmetamodel.BusinessEntity;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class LockoutScriptTemplate {
  public static CharSequence generate(final String packageName, final BusinessEntity authBe) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("USE `");
    _builder.append(packageName, "");
    _builder.append("` ;");
    _builder.newLineIfNotEmpty();
    Attribute authID = DomainCodeUtilities.getID(authBe);
    _builder.newLineIfNotEmpty();
    _builder.append("-- -----------------------------------------------------");
    _builder.newLine();
    _builder.append("-- Table `");
    _builder.append(packageName, "");
    _builder.append("`.`Attempts`");
    _builder.newLineIfNotEmpty();
    _builder.append("-- -----------------------------------------------------");
    _builder.newLine();
    _builder.append("DROP TABLE IF EXISTS `");
    _builder.append(packageName, "");
    _builder.append("`.`Attempts` ;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("CREATE TABLE IF NOT EXISTS `");
    _builder.append(packageName, "");
    _builder.append("`.`Attempts` (");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("`");
    String _name = authBe.getName();
    String _lowerCase = _name.toLowerCase();
    _builder.append(_lowerCase, "  ");
    _builder.append("` VARCHAR(100) NOT NULL,");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("`attempts` INT NOT NULL,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("PRIMARY KEY (`");
    String _name_1 = authBe.getName();
    String _lowerCase_1 = _name_1.toLowerCase();
    _builder.append(_lowerCase_1, "  ");
    _builder.append("`),");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("CONSTRAINT `fk_Attempts_");
    String _name_2 = authBe.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_2);
    _builder.append(_firstUpper, "  ");
    _builder.append("`");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("FOREIGN KEY (`");
    String _name_3 = authBe.getName();
    String _lowerCase_2 = _name_3.toLowerCase();
    _builder.append(_lowerCase_2, "    ");
    _builder.append("`)");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("REFERENCES `");
    _builder.append(packageName, "    ");
    _builder.append("`.`");
    String _name_4 = authBe.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper_1, "    ");
    _builder.append("` (`");
    String _name_5 = authID.getName();
    String _lowerCase_3 = _name_5.toLowerCase();
    _builder.append(_lowerCase_3, "    ");
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
    return _builder;
  }
}
