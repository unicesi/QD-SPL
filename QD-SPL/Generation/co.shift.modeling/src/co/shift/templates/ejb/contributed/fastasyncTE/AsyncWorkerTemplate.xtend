package co.shift.templates.ejb.contributed.fastasyncTE

import domainmetamodel.BusinessEntity
import domainmetamodel.ListAll
import co.shift.generators.domain.DomainCodeGenerator

class AsyncWorkerTemplate {
	
	def static generate (BusinessEntity be, String packageName) '''
		package co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».control;
		
		import java.sql.Connection;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		import java.util.ArrayList;
		import java.util.List;
		import java.util.Date;
		import java.util.concurrent.Future;
		
		import javax.annotation.Resource;
		import javax.ejb.AsyncResult;
		import javax.ejb.Asynchronous;
		import javax.ejb.Stateless;
		import javax.sql.DataSource;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_IMPORT, packageName, be.name)»
		
		@Stateless
		public class «be.name.toFirstUpper»AsyncWorker {
		
		@Resource(name = "«packageName.toLowerCase()»")
		private DataSource ds;
		
		«val attribute2 = DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_ATTRIBUTE)»
		«IF (attribute2 != null && !attribute2.equals(""))»
			«attribute2»
		«ENDIF»
		
		«FOR contract : be.contracts»
			«IF (contract instanceof ListAll)»
				public Future<List<«be.name.toFirstUpper»TO>> «contract.name»(int start, int maxResults) throws Exception {					
					List<«be.name.toFirstUpper»TO> «be.name.toLowerCase»s = new ArrayList<>();
					Connection con = null;
					Statement stmt = null;
					ResultSet resultSet = null;
					try {
						con = ds.getConnection();
						stmt = con.createStatement();
						resultSet = stmt.executeQuery("SELECT p.* FROM «be.name.toFirstUpper» p");
						if (start != 0)
							resultSet.absolute(start);
						int i = 0;
						«be.name.toFirstUpper»TO p;
						while (resultSet.next()  && i < maxResults) {
							p = new «be.name.toFirstUpper»TO();
							«var i=1»
							«FOR attribute : be.attributes»
								«DomainCodeGenerator.getType(attribute)» t«attribute.name.toFirstUpper» = resultSet.get«DomainCodeGenerator.getType(attribute)»(«i»);
								«var c = i++»
							«ENDFOR»
							«DomainCodeGenerator.extendContribution("_r_2_10", DomainCodeGenerator.CONTRIBUTE_TO_BIMPL, null, be, null, null, null, null, null, 2)»
							«FOR attribute : be.attributes»
								p.set«attribute.name.toFirstUpper»(t«attribute.name.toFirstUpper»);
							«ENDFOR»
							«be.name.toLowerCase»s.add(p);
							i++;
						}
						return new AsyncResult<List<«be.name.toFirstUpper»TO>>(«be.name.toLowerCase»s);
					} catch (SQLException ex) {
						return null;
					}
				}
			«ENDIF»
		«ENDFOR»
		}
	'''
}