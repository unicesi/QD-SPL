package co.shift.templates.database.contributed.authenticity

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities

class LockoutScriptTemplate {
	
	def static generate(String packageName, BusinessEntity authBe) '''
		USE `«packageName»` ;
		«var authID = DomainCodeUtilities.getID(authBe)»
		-- -----------------------------------------------------
		-- Table `«packageName»`.`Attempts`
		-- -----------------------------------------------------
		DROP TABLE IF EXISTS `«packageName»`.`Attempts` ;
		
		CREATE TABLE IF NOT EXISTS `«packageName»`.`Attempts` (
		  `«authBe.name.toLowerCase»` VARCHAR(100) NOT NULL,
		  `attempts` INT NOT NULL,
		  PRIMARY KEY (`«authBe.name.toLowerCase»`),
		  CONSTRAINT `fk_Attempts_«authBe.name.toFirstUpper»`
		    FOREIGN KEY (`«authBe.name.toLowerCase»`)
		    REFERENCES `«packageName»`.`«authBe.name.toFirstUpper»` (`«authID.name.toLowerCase»`)
		    ON DELETE NO ACTION
		    ON UPDATE NO ACTION)
		ENGINE = InnoDB;
	'''
}