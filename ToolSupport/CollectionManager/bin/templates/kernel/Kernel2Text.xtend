package templates.kernel

class Kernel2Text {
	def static String doGenerate(kernelmetamodel.Kernel k){
		val systemName = k.system.name
		val elementName = k.system.element.name
		'''
		package unicesi.driso.«systemName.toLowerCase».kernel;
		import java.util.observable;
		...
		public class «systemName» extends Observable{
			
		}
		'''
	}
	
}