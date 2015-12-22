package co.shift.templates.ejb.contributed.mediumTE

import domainmetamodel.BusinessEntity
import domainmetamodel.ListAll
import co.shift.generators.domain.DomainCodeUtilities

class FLRImplTemplate {
	
	def static generate (BusinessEntity be, String packageName) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;
		
		import java.sql.Connection;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		import java.util.ArrayList;
		import java.util.List;
		import java.util.Date;
		
		import javax.annotation.Resource;
		import javax.ejb.EJB;
		import javax.ejb.Stateless;
		import javax.sql.DataSource;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		«DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_IMPORT, packageName, be.name)»
		
		@Stateless
		public class «be.name.toFirstUpper»BasicFLR implements I«be.name.toFirstUpper»BasicFLR {
		
		@Resource(name = "«packageName.toLowerCase()»")
		private DataSource ds;
		
		«val attribute2 = DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_ATTRIBUTE)»
		«IF (attribute2 != null && !attribute2.equals(""))»
			«attribute2»
		«ENDIF»
		
		«FOR contract : be.contracts»
			«IF (contract instanceof ListAll)»
				public List<«be.name.toFirstUpper»TO> «contract.name»() throws Exception {					
					List<«be.name.toFirstUpper»TO> «be.name.toLowerCase»s = new ArrayList<>();
					Connection con = null;
					Statement stmt = null;
					ResultSet resultSet = null;
					try {
						con = ds.getConnection();
						stmt = con.createStatement();
						resultSet = stmt.executeQuery("SELECT p.* FROM «be.name.toFirstUpper» p");
						«be.name.toFirstUpper»TO p;
						while (resultSet.next()) {
							p = new «be.name.toFirstUpper»TO();
							«var i=1»
							«FOR attribute : be.attributes»
								«DomainCodeUtilities.getType(attribute)» t«attribute.name.toFirstUpper» = resultSet.get«DomainCodeUtilities.getType(attribute).toFirstUpper»(«i»);
								«var c = i++»
							«ENDFOR»
							«DomainCodeUtilities.extendContribution("_r_2_10", DomainCodeUtilities.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 2)»
							«FOR attribute : be.attributes»
								p.set«attribute.name.toFirstUpper»(t«attribute.name.toFirstUpper»);
							«ENDFOR»
							«be.name.toLowerCase»s.add(p);
						}
						return «be.name.toLowerCase»s;
					} catch (SQLException ex) {
						throw new Exception(ex.getMessage());
					}
				}
			«ENDIF»
		«ENDFOR»
		}
	'''
}