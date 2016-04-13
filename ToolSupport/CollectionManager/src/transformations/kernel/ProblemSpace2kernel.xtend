package transformations.kernel

import domainmetamodel.Characteristic
import domainmetamodel.Entity
import domainmetamodel.ProblemSpace
import kernelmetamodel.Attribute
import kernelmetamodel.Element
import kernelmetamodel.Kernel
import kernelmetamodel.KernelmetamodelFactory
import kernelmetamodel.Sort
import kernelmetamodel.SortAlgorithm
import kernelmetamodel.System
import org.eclipse.emf.common.util.ECollections

class ProblemSpace2kernel {
	
	//Crea el kernel y recursivamente crea el System
	def Kernel create KernelmetamodelFactory::eINSTANCE.createKernel() problemSpace2kernel(ProblemSpace ps){
		name = "kernel"
		problemSpace2System(it, ps)
	}
	
	//Crea el System a partir del ProblemSpace y recursivamente crea el Element y los Sort
	def System create KernelmetamodelFactory::eINSTANCE.createSystem() problemSpace2System(Kernel k, ProblemSpace ps){
		name = ps.name
		k.system = it

		entity2Element(it, ps.entity)
		//for(var i=0;i<it.element.attribute.size; i++){
		    //println("i= "+i+":"+it.element.attribute.get(i))
		    //it.sort.add(createBubbleSort(it.element.attribute.get(0)))
		//}
		//val sorts = it.element.attribute.map[createBubbleSort]
		//sorts.last.toString
		//println(sorts)
		//for(var i=0;i<sorts.size; i++)
		  //  println(sorts.get(i))
		//ECollections.setEList(it.sort, sorts)
		
		//Agrega dos sort (bubble e insert) a cada attribute del element de este system
		//Luego agrega todos los bubble y todos los insert al system.
		//ECollections.setEList(it.sort, it.element.attribute.map[createBubbleSort])
		//ECollections.setEList(it.sort, it.element.attribute.map[createInsertSort])
		//it.sort.clear
		//it.sort.addAll(it.element.attribute.map[createBubbleSort])
		//it.sort.addAll(it.element.attribute.map[createInsertSort])
	}
	
	//Crea el Element a partir del Entity y recursivamente crea los atributos
	def Element create KernelmetamodelFactory::eINSTANCE.createElement() entity2Element(System s, Entity e){
		name = e.name
		//val atts = e.characteristic.map[characteristic2Attribute]
		for(var i=0;i<e.characteristic.size; i++){
			characteristic2Attribute(s, it, e.characteristic.get(i))
		}
		//ECollections.setEList(it.attribute, atts)
		s.element = it		
	}
	
	//Crea un Attribute a partir de un Characteristic.
	//Recursivamente Crea un BubbleSort y un InsertSort y los asocia al Attribute 
	def Attribute create KernelmetamodelFactory::eINSTANCE.createAttribute() characteristic2Attribute(System s, Element e, Characteristic c){
		name = c.name
		isIdentifier = if (c.name.matches("name")) true else false
		createBubbleSort(it, s)
		createInsertSort(it, s)
		e.attribute.add(it)
	}

    //Crea un BubbleSort, asociado al Attribute dado. Este sort se incluye en la lista de sorts 
    // relacionados con el System que contiene al atributo a 
	def Sort create KernelmetamodelFactory::eINSTANCE.createSort() createBubbleSort( kernelmetamodel.Attribute a, System s){
		setName(a.name)
		algorithm = SortAlgorithm::BUBBLE
		//setAttribute(a)
		s.sort.add(it)
	}

    //Crea un elemento sort de tipo insert, asociado al atributo a. Este sort se incluye en la lista de sorts 
    // relacionados con el System que contiene al atributo a 
	def Sort create KernelmetamodelFactory::eINSTANCE.createSort() createInsertSort( kernelmetamodel.Attribute a, System s){
		setName(a.name)
		algorithm = SortAlgorithm::INSERTION
		//setAttribute(a)
		s.sort.add(it)
	}

}