package co.edu.icesi.shift.planner.generator.domain

import applicabilitymodel.Decision
import co.edu.icesi.shift.planner.templates.ResolutionTemplate
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.chocosolver.solver.Solver
import org.chocosolver.solver.variables.IntVar
import org.chocosolver.solver.variables.VariableFactory
import org.chocosolver.solver.constraints.IntConstraintFactory
import org.chocosolver.solver.search.strategy.IntStrategyFactory
import org.chocosolver.solver.trace.Chatterbox
import com.google.inject.Injector
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import qasvariabilitymodel.QAGroup

class PlannerGenerator implements IGenerator {

	private static String className = new Object(){}.class.enclosingClass.simpleName

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		var i = 0

		var List<List<String>> decisionModel = new ArrayList<List<String>>()
		for (d : input.allContents.toIterable) {
			if (d instanceof Decision) {
				decisionModel.add(new ArrayList<String>) //Nuevo C*
				for(rv : d.requiredVariants){
					decisionModel.get(i).add(rv.selectionRequired+"") //Nueva V* para el C*
				}
			}
		}
		
		var List<String> qualityScenario = new ArrayList<String>()
		for (qs : PlannerUtilities.rQualityScenario.allContents.toIterable){
			if (qs instanceof QAGroup){
				for(v : qs.children){
					if (v.selected)
						qualityScenario.add("2")
					else
						qualityScenario.add("1")
				}
			}
		}
		
/*		// Crear el solver
		var Solver solver = new Solver("Solver PISCIS")
		var IntVar sj = VariableFactory.enumerated("Sj", 0, 1, solver)
		var IntVar dij = VariableFactory.enumerated("Dij", 0, 2, solver)
		//1) Deployment constraint.
		//A componentset must be deployed satisfying the respective deployment condition in the decision model
		// (Sj = 1) => ( (D(i,j) = 0) || [(D(i,j) != 0) ^ (D(i,j) = vi)])
		// Reescrito:
		// (Sj = 1) => ( (D(i,j) = 0) || (D(i,j) = vi))
		//solver.post(IntConstraintFactory.arithm(x,"+",y, "<", 5))
		//solver.post
		
		//2) Non-exclusion constraint.
		//Two deployable componentsets must not exclude each other.
		// ((Sj1 = Sj2 = 1) ^ (j1 != j2)) => ((D(j1,i) = 0) || (D(j2,i) = 0) || (D(j1,i) = D(j2,i)))

		//3) Completeness constraint.
		//All deployable componentsets must take into account all the quality scenarios’ states in the quality configuration
		// Para todo i existe j tal que ((Sj = 1) ^ (D(i,j) != 1))

		//Define the search strategy
		solver.set(IntStrategyFactory.lexico_LB(x, y))
		//Launch the resolution process
		solver.findSolution
		//Print search statistics
		Chatterbox.printStatistics(solver)*/
//		fsa.generateFile("/co/shift/PISCIS/ResolutionPlan.txt",	ResolutionTemplate::generate())
		fsa.generateFile("ResolutionPlan.txt",	ResolutionTemplate::generate(decisionModel, qualityScenario))
	}
}
