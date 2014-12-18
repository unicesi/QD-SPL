package co.shift.templates.database.contributed.authenticity

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities

class AuthenticatorScriptTemplate {
	
	def static generate(String packageName, BusinessEntity authBe) '''
		USE `«packageName»` ;
		
		-- -----------------------------------------------------
		-- Table `«packageName»`.`Roles`
		-- -----------------------------------------------------
		DROP TABLE IF EXISTS `«packageName»`.`Roles` ;
		
		CREATE TABLE IF NOT EXISTS `«packageName»`.`Roles` (
		  `name` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  `description` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  PRIMARY KEY (`name`))
		ENGINE = InnoDB;
		
		
		-- -----------------------------------------------------
		-- Table `«packageName»`.`Services`
		-- -----------------------------------------------------
		DROP TABLE IF EXISTS `«packageName»`.`Services` ;
		
		CREATE TABLE IF NOT EXISTS `«packageName»`.`Services` (
		  `name` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  `description` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  PRIMARY KEY (`name`))
		ENGINE = InnoDB;
		
		
		-- -----------------------------------------------------
		-- Table `«packageName»`.`Rights`
		-- -----------------------------------------------------
		DROP TABLE IF EXISTS `«packageName»`.`Rights` ;
		
		CREATE TABLE IF NOT EXISTS `«packageName»`.`Rights` (
		  `role` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  `service` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  PRIMARY KEY (`role`, `service`),
		  INDEX `fk_Roles_has_Services_Services1_idx` (`service` ASC),
		  INDEX `fk_Roles_has_Services_Roles1_idx` (`role` ASC),
		  CONSTRAINT `fk_Roles_has_Services_Roles1`
		    FOREIGN KEY (`role`)
		    REFERENCES `«packageName»`.`Roles` (`name`)
		    ON DELETE NO ACTION
		    ON UPDATE NO ACTION,
		  CONSTRAINT `fk_Roles_has_Services_Services1`
		    FOREIGN KEY (`service`)
		    REFERENCES `«packageName»`.`Services` (`name`)
		    ON DELETE NO ACTION
		    ON UPDATE NO ACTION)
		ENGINE = InnoDB;
		
		-- -----------------------------------------------------
		-- Table `«packageName»`.`«authBe.name.toFirstUpper»Role`
		-- -----------------------------------------------------
		DROP TABLE IF EXISTS `«packageName»`.`«authBe.name.toFirstUpper»Role` ;
		«var authID = DomainCodeUtilities.getID(authBe)»
		CREATE TABLE IF NOT EXISTS `«packageName»`.`«authBe.name.toFirstUpper»Role` (
		  `«authBe.name.toLowerCase»` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  `role` «DomainCodeUtilities.getMySqlEquivalent("String")» NOT NULL,
		  PRIMARY KEY (`«authBe.name.toLowerCase»`, `role`),
		  INDEX `fk_«authBe.name.toFirstUpper»_has_Role_Role_idx` (`role` ASC),
		  INDEX `fk_U«authBe.name.toFirstUpper»_has_Role_«authBe.name.toFirstUpper»_idx` (`«authBe.name.toLowerCase»` ASC),
		  CONSTRAINT `fk_«authBe.name.toFirstUpper»_has_Role_«authBe.name.toFirstUpper»`
		    FOREIGN KEY (`«authBe.name.toLowerCase»`)
		    REFERENCES `«packageName»`.`«authBe.name.toFirstUpper»` (`«authID.name.toLowerCase»`)
		    ON DELETE NO ACTION
		    ON UPDATE NO ACTION,
		  CONSTRAINT `fk_«authBe.name.toFirstUpper»_has_Role_Role`
		    FOREIGN KEY (`role`)
		    REFERENCES `«packageName»`.`Roles` (`name`)
		    ON DELETE NO ACTION
		    ON UPDATE NO ACTION)
		ENGINE = InnoDB;
	'''
}