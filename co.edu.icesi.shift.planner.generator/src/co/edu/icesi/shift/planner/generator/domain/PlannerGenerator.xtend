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
		
		var m = decisionModel.size //number of component sets
		var n = qualityScenario.size //number of quality scenarios
		
		// Crear el solver
		var Solver solver = new Solver("Solver PISCIS")
		//Definition 3 (decision model): finite set of m x n decisions.
		//Each dij relates component set cj with quality scenario vi
		var IntVar[] vi = VariableFactory.boundedArray("Vi", n, 1, 2, solver)

		//Definition 3 (decision model): finite set of m x n decisions.
		//Each dij relates component set cj with quality scenario vi
		var IntVar[][] dji = VariableFactory.boundedMatrix("Dji", m, n, 0, 2, solver)

		//Definition 4 (resolution model): finite set of m component set deployments
		var IntVar[] sj = VariableFactory.boundedArray("Sj", m, 0, 1, solver)
		
		//Definition 5 (Deployment constraint):
		//A componentset must be deployed satisfying the respective deployment condition in the decision model
		// (Sj = 1) => ( (D(j,i) = 0) || [(D(j,i) != 0) ^ (D(j,i) = vi)])
		// Reescrito:
		// (Sj = 1) => ( (D(j,i) = 0) || (D(j,i) = vi))
		//c1 solver.post(IntConstraintFactory.arithm(sj,"=",1))
		//c2 solver.post(IntConstraintFactory.arithm(dji,"=",0))
		//c3 solver.post(IntConstraintFactory.arithm(dji,"=",vi))
		//TODO ifthen(c1, OR(c2,c3))

		//2) Non-exclusion constraint.
		//Two deployable componentsets must not exclude each other.
		// ((Sj1 = Sj2 = 1) ^ (j1 != j2)) => ((D(j1,i) = 0) || (D(j2,i) = 0) || (D(j1,i) = D(j2,i)))
		//c1 solver.post(IntConstraintFactory.arithm(sj[j1], "=", sj[j2], "=", 1))
		//c2 solver.post(IntConstraintFactory.arithm(j1, "!=", j2))
		//c3 solver.post(IntConstraintFactory.arithm(dji[j1][i], "=", 0))
		//c4 solver.post(IntConstraintFactory.arithm(dji[j2][i], "=", 0)) 
		//c5 solver.post(IntConstraintFactory.arithm(dji[j1][i], "=", dji[j2][i]))
		//TODO ifThen(AND(c1,c2), OR(c3,c4,c5))

		//3) Completeness constraint.
		//All deployable componentsets must take into account all the quality scenarios’ states in the quality configuration
		// Para todo i existe j tal que ((Sj = 1) ^ (D(i,j) != 1))
		//c1 solver.post(IntConstraintFactory.arithm(sj, "=", 1))
		//c2 solver.post(IntConstraintFactory.arithm(dji, "!=", 1))
		//TODO AND(c1,c2)

		//Define the search strategy
/*		solver.set(IntStrategyFactory.lexico_LB(x, y))
		//Launch the resolution process
		solver.findSolution
		//Print search statistics
		Chatterbox.printStatistics(solver)*/
//		fsa.generateFile("/co/shift/PISCIS/ResolutionPlan.txt",	ResolutionTemplate::generate())
		fsa.generateFile("ResolutionPlan.txt",	ResolutionTemplate::generate(decisionModel, qualityScenario))
	}
}
