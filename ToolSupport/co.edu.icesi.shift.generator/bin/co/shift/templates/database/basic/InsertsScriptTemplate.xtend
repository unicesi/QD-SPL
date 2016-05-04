package co.shift.templates.database.basic

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities
import co.shift.contributors.confidentiality.PBECryptographyManager

class InsertsScriptTemplate {
	
	def static generate(String packageName, BusinessEntity authBe) '''
		-- -----------------------------------------------------
		-- Inserts
		-- -----------------------------------------------------
		INSERT INTO `«packageName»`.`«authBe.name.toFirstUpper»` (
		«var pbe = new PBECryptographyManager()»
		«var size = authBe.attributes.size»
		«var c = 0»
		«FOR att : authBe.attributes»
		`«att.name.toLowerCase»`«IF c<size-1»,«ENDIF»
		«var dd = c++»
		«ENDFOR»
		) VALUES (
		«var cc = (c = 0)»
		«FOR att : authBe.attributes»
		«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»
		«IF DomainCodeUtilities.getType(att).equals("String")»'«new String(pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin"))»«ELSE»«IF DomainCodeUtilities.getType(att).equals("Date")»sysdate()«ELSE»0«ENDIF»«ENDIF»'
		«ELSE»
		«IF DomainCodeUtilities.getType(att).equals("String")»'admin'«ELSE»«IF DomainCodeUtilities.getType(att).equals("Date")»sysdate()«ELSE»0«ENDIF»«ENDIF»
		«ENDIF»
		«IF c<size-1»,«ENDIF»«var dd = c++»
		«ENDFOR»);
			
		«IF DomainCodeUtilities.isQASelected("_r_2_11_15_16")»
		INSERT INTO `«packageName»`.`Roles`
		(`name`,
		`description`)
		VALUES
		('«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»«new String(pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin"))»«ELSE»admin«ENDIF»',
		'«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»«new String(pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin role"))»«ELSE»admin role«ENDIF»');
		INSERT INTO `«packageName»`.`«authBe.name.toFirstUpper»Role`
		(`«authBe.name.toLowerCase»`,
		`role`)
		VALUES (
		'«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»«new String(pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin"))»«ELSE»admin«ENDIF»',
		'«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»«new String(pbe.doFinal(PBECryptographyManager.ENCRYPT, "admin"))»«ELSE»admin«ENDIF»');
		
		«FOR s : DomainCodeUtilities.getServices»
		INSERT INTO `«packageName»`.`Services`
		(`name`,
		`description`)
		VALUES ('«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»«new String(pbe.doFinal(PBECryptographyManager.ENCRYPT, ""+s+""))»«ELSE»«s»«ENDIF»', '«IF DomainCodeUtilities.isQASelected("_r_2_10_12_13")»«new String(pbe.doFinal(PBECryptographyManager.ENCRYPT, ""+s+""))»«ELSE»«s»«ENDIF»');
		«ENDFOR»
		«ENDIF»
	'''
}