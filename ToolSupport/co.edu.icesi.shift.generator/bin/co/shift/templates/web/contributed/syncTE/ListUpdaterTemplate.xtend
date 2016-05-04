package co.shift.templates.web.contributed.syncTE

import domainmetamodel.BusinessEntity

class ListUpdaterTemplate {
	
	def static generate (BusinessEntity be, String packageName) '''
		package co.shift.«packageName.toLowerCase()».web.ext.«be.name.toLowerCase»;
		
		import java.util.List;
		
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		
		public class «be.name.toFirstUpper»ListUpdater extends Thread{

			private «be.name.toFirstUpper»Form pF;
			private List<«be.name.toFirstUpper»TO> «be.name.toLowerCase»s;
			
			public «be.name.toFirstUpper»ListUpdater(«be.name.toFirstUpper»Form pF, List<«be.name.toFirstUpper»TO> «be.name.toLowerCase»s){
				this.pF = pF;
				this.«be.name.toLowerCase»s = «be.name.toLowerCase»s;
			}
			
			@Override
			public void run() {
				if («be.name.toLowerCase»s.size() > 0) {
					for («be.name.toFirstUpper»TO to : «be.name.toLowerCase»s) {
						Object data[] = { 
							«var size = be.attributes.size»
							«var c = 0»
							«FOR a : be.attributes»
							«IF c < size - 1»
							to.get«a.name.toFirstUpper»(), 
							«ELSE»
							to.get«a.name.toFirstUpper»()
							«ENDIF»
							«var sd = c++»
							«ENDFOR»
						};
						pF.getTable_1().addItem(data, to);
					}
				}
			}
		}
	'''
}