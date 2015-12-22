package co.shift.templates.web.basic

import co.shift.generators.domain.DomainCodeUtilities

class PersistenceTemplate {
	
	def static generate (String packageName) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
			<persistence-unit name="«packageName»">
				<jta-data-source>«packageName»</jta-data-source>
				«FOR name : DomainCodeUtilities.getEntityNames»
				<class>«name»</class>
				«ENDFOR»
				</persistence-unit>
		</persistence>
	'''
}