package co.shift.templates.database.basic

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities
import domainmetamodel.Simple
import domainmetamodel.Association
import java.util.List
import java.util.ArrayList

class MERScriptTemplate {
	
	def static generate(String packageName, BusinessEntity authBe, List<Association> associations) '''
		DROP SCHEMA IF EXISTS `«packageName»` ;
		CREATE SCHEMA IF NOT EXISTS `«packageName»` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
		USE `«packageName»` ;
		
		«var List<String> fks = new ArrayList»
		«var entities = DomainCodeUtilities.getBusinessEntities»
		«var add = entities.add(authBe)»
		«FOR entity : entities»
		«var entityId = DomainCodeUtilities.getID(entity)»
		-- -----------------------------------------------------
		-- Table `«packageName»`.`«entity.name.toFirstUpper»`
		-- -----------------------------------------------------
		DROP TABLE IF EXISTS `«packageName»`.`«entity.name.toFirstUpper»` ;

		CREATE TABLE IF NOT EXISTS `«packageName»`.`«entity.name.toFirstUpper»` (
		«FOR att : entity.attributes»
		`«att.name.toLowerCase»` «DomainCodeUtilities.getMySqlEquivalent(DomainCodeUtilities.getType(att))» «DomainCodeUtilities.isMySqlNull(att)»,
		«ENDFOR»
		«var endComma = false»
«««		Simple Detail Associations
		«FOR association : entity.associations»
		«IF (association instanceof Simple)»
		«var relEntity = association.relatedEntity as BusinessEntity»
		«var relEntityId = DomainCodeUtilities.getID(relEntity)»
		«IF endComma»,«ENDIF»`«association.name.toLowerCase»` «DomainCodeUtilities.getMySqlEquivalent(DomainCodeUtilities.getType(relEntityId))» NULL,
		INDEX `fk_«entity.name.toFirstUpper»_«relEntity.name.toFirstUpper»_«association.name.toFirstUpper»` (`«association.name.toLowerCase»` ASC)«««,
«««		 CONSTRAINT `c_fk_«entity.name.toFirstUpper»_«relEntity.name.toFirstUpper»`
«««		   FOREIGN KEY (`«association.name.toLowerCase»`)
«««		   REFERENCES `«packageName»`.`«relEntity.name.toFirstUpper»` (`«DomainCodeUtilities.getID(relEntity).name.toLowerCase»`)
«««		   ON DELETE NO ACTION
«««		   ON UPDATE NO ACTION
		«var addFk = fks.add("ALTER TABLE "+entity.name.toFirstUpper+" ADD CONSTRAINT "+
					"`c_fk_"+entity.name.toFirstUpper+"_"+relEntity.name.toFirstUpper+"` FOREIGN KEY (`"+
					association.name.toLowerCase+"`) REFERENCES `"+packageName+"`.`"+relEntity.name.toFirstUpper+
					"` (`"+DomainCodeUtilities.getID(relEntity).name.toLowerCase+"`) ON DELETE NO ACTION ON UPDATE NO ACTION;")»
		«var modEndComma = (endComma = true)»
		«ENDIF»
		«ENDFOR»
«««		Multiple Detail Associations
		«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(entity, associations)»
		«IF DomainCodeUtilities.hasZeroAssociations(entity)»
		«var relEntity = association.eContainer as BusinessEntity»
		«var relEntityId = DomainCodeUtilities.getID(relEntity)»
		«IF endComma»,«ENDIF»`«relEntity.name.toLowerCase»` «DomainCodeUtilities.getMySqlEquivalent(DomainCodeUtilities.getType(relEntityId))» «DomainCodeUtilities.isMySqlNull(relEntityId)»,
		INDEX `fk_«entity.name.toFirstUpper»_«relEntity.name.toFirstUpper»_«association.name.toFirstUpper»` (`«relEntity.name.toLowerCase»` ASC)«««,
«««		 CONSTRAINT `c_fk_«entity.name.toFirstUpper»_«relEntity.name.toFirstUpper»`
«««		   FOREIGN KEY (`«relEntity.name.toLowerCase»`)
«««		   REFERENCES `«packageName»`.`«relEntity.name.toFirstUpper»` (`«DomainCodeUtilities.getID(relEntity).name.toLowerCase»`)
«««		   ON DELETE NO ACTION
«««		   ON UPDATE NO ACTION
		«var addFk = fks.add("ALTER TABLE "+entity.name.toFirstUpper+" ADD CONSTRAINT "+
					"`c_fk_"+entity.name.toFirstUpper+"_"+relEntity.name.toFirstUpper+"` FOREIGN KEY (`"+
					relEntity.name.toLowerCase+"`) REFERENCES `"+packageName+"`.`"+relEntity.name.toFirstUpper+
					"` (`"+DomainCodeUtilities.getID(relEntity).name.toLowerCase+"`) ON DELETE NO ACTION ON UPDATE NO ACTION;")»
		«var modEndComma = (endComma = true)»
		«ENDIF»
		«ENDFOR»
«««		Primary Key Statement
		«IF endComma»,«ENDIF»PRIMARY KEY (`«entityId.name.toLowerCase»`))
		ENGINE = InnoDB;
		«ENDFOR»
«««		ManyToMany Associations
«««		«FOR mTm : DomainCodeUtilities.getManyToManyAssociations(entities)»
		«FOR mTm : DomainCodeUtilities.getManyToManyAssociations()»
		«var a = mTm.get(0)»
		«var b = mTm.get(1)»
		«var aID = DomainCodeUtilities.getID(a)»
		«var bID = DomainCodeUtilities.getID(b)»
		«var mTmName = a.name.toFirstUpper+b.name.toFirstUpper»
		-- -----------------------------------------------------
		-- Table `«packageName»`.`«mTmName»`
		-- -----------------------------------------------------
		DROP TABLE IF EXISTS `«packageName»`.`«mTmName»` ;
		
		CREATE TABLE IF NOT EXISTS `«packageName»`.`«mTmName»` (
		`«a.name.toLowerCase»«aID.name.toFirstUpper»` «DomainCodeUtilities.getMySqlEquivalent(DomainCodeUtilities.getType(aID))» NOT NULL,
		`«b.name.toLowerCase»«bID.name.toFirstUpper»` «DomainCodeUtilities.getMySqlEquivalent(DomainCodeUtilities.getType(bID))» NOT NULL,
		PRIMARY KEY (`«a.name.toLowerCase»«aID.name.toFirstUpper»`, `«b.name.toLowerCase»«bID.name.toFirstUpper»`),
		  INDEX `fk_«a.name.toFirstUpper»_has_«b.name.toFirstUpper»_«b.name.toFirstUpper»_idx` (`«a.name.toLowerCase»«aID.name.toFirstUpper»` ASC),
		  INDEX `fk_«a.name.toFirstUpper»_has_«b.name.toFirstUpper»_«a.name.toFirstUpper»_idx` (`«b.name.toLowerCase»«bID.name.toFirstUpper»` ASC),
		  CONSTRAINT `fk_«a.name.toFirstUpper»_has_«b.name.toFirstUpper»_«a.name.toFirstUpper»`
		    FOREIGN KEY (`«a.name.toLowerCase»«aID.name.toFirstUpper»`)
		    REFERENCES `«packageName»`.`«a.name.toFirstUpper»` (`«aID.name.toLowerCase»`)
		    ON DELETE NO ACTION
		    ON UPDATE NO ACTION,
		  CONSTRAINT `fk_«a.name.toFirstUpper»_has_«b.name.toFirstUpper»_«b.name.toFirstUpper»`
		    FOREIGN KEY (`«b.name.toLowerCase»«bID.name.toFirstUpper»`)
		    REFERENCES `«packageName»`.`«b.name.toFirstUpper»` (`«bID.name.toLowerCase»`)
		    ON DELETE NO ACTION
		    ON UPDATE NO ACTION)
		ENGINE = InnoDB;
		«ENDFOR»
«««		Foreign Keys
		-- -----------------------------------------------------
		-- Foreign Keys
		-- -----------------------------------------------------
		«FOR fk : fks»
		«fk»
		«ENDFOR»
	'''
}