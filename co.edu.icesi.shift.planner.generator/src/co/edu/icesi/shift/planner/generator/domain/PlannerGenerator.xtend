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
import org.chocosolver.solver.constraints.LogicalConstraintFactory
import org.chocosolver.solver.constraints.Constraint
import org.chocosolver.solver.constraints.nary.alldifferent.conditions.Condition
import org.chocosolver.solver.search.strategy.SetStrategyFactory
import org.chocosolver.solver.search.measure.IMeasures
import org.chocosolver.solver.search.solution.ISolutionRecorder
import org.chocosolver.solver.search.solution.Solution

class PlannerGenerator implements IGenerator {

	private static String className = new Object(){}.class.enclosingClass.simpleName

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		//var i = 0
		var index = 0;
		var solutionString = "";

		var List<List<String>> decisionModel = new ArrayList<List<String>>()
		for (d : input.allContents.toIterable) {
			if (d instanceof Decision) {
				decisionModel.add(new ArrayList<String>) //Nuevo C*
				for(rv : d.requiredVariants){
					decisionModel.get(index).add(rv.selectionRequired+"") //Nueva V* para el C*
				}
				index++
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
		
		var m = decisionModel.size //number of component sets. Iterated with j
		var n1 = decisionModel.get(0).size //should be equal to n
		var n = qualityScenario.size //number of quality scenarios. Iterated with i
		System.out.println("m:"+m)
		System.out.println("n1:"+n1)
		System.out.println("n:"+n)
		
		// Create the solver
		var Solver solver = new Solver("Solver PISCIS")
		var Constraint c1
		var Constraint c2
		var Constraint c3
		var Constraint c4
		var Constraint c5


		//Definition X (quality scenario): n-tuple
		//Array for the quality scenario
		var IntVar[] V = VariableFactory.enumeratedArray("V", n, 1, 2, solver)
		//Each position is constrained with the values from the input model (qualityModel)
		for(i:0..<n){
			solver.post(IntConstraintFactory.arithm(V.get(i), "=", Integer.parseInt(qualityScenario.get(i))))
		}

		//Definition 3 (decision model): finite set of n x m decisions.
		//Each dij relates component set cj with quality scenario vi
		var IntVar[][] D = VariableFactory.enumeratedMatrix("D", m, n, 0, 2, solver)
		for(j:0..<m){
			for(i:0..<n){
				solver.post(IntConstraintFactory.arithm(D.get(j).get(i), "=", Integer.parseInt(decisionModel.get(j).get(i))))
			}
		}

		//Definition 4 (resolution model): finite set of m component set deployments
		var IntVar[] S = VariableFactory.enumeratedArray("S", m, 0, 1, solver)
		
		//Definition 5 (Deployment constraint):
		//A componentset must be deployed satisfying the respective deployment condition in the decision model
		// (Sj = 1) => ( (D(j,i) = 0) || [(D(j,i) != 0) ^ (D(j,i) = vi)])
		// Se puede reescribir así, ya que dji = vi implica que dji!=0:
		// (Sj = 1) => ( (Dj,i = 0) || (Dj,i = vi))
		for(j:0..<m){
			//c1: (S(j) = 1)
			c1 = IntConstraintFactory.arithm(S.get(j), "=", 1)
			for(i:0..<n){
				//c2: D(j,i) = 0
				c2 = IntConstraintFactory.arithm(D.get(j).get(i), "=", 0)
				//c3: D(j,i) != 0
				c3 = IntConstraintFactory.arithm(D.get(j).get(i), "!=", 0)
				//c4: D(j,i) = V(i)
				c4 = IntConstraintFactory.arithm(D.get(j).get(i), "=", V.get(i))
				//c1 => (c2 OR (c3 AND c4))
				//LogicalConstraintFactory.ifThen(c1, LogicalConstraintFactory.or(c2,LogicalConstraintFactory.and(c3,c4)))
				LogicalConstraintFactory.ifThen(c1, LogicalConstraintFactory.or(c2,c4))
			}
		}


		//2) Non-exclusion constraint.
		//Two deployable componentsets must not exclude each other.
		// ((Sj1 = Sj2 = 1) ^ (j1 != j2)) => ((D(j1,i) = 0) || (D(j2,i) = 0) || (D(j1,i) = D(j2,i)))
		//c1 solver.post(IntConstraintFactory.arithm(sj[j1], "=", sj[j2], "=", 1))
		// solver.post(IntConstraintFactory.arithm(j1, "!=", j2))
		//c2 solver.post(IntConstraintFactory.arithm(dji[j1][i], "=", 0))
		//c3 solver.post(IntConstraintFactory.arithm(dji[j2][i], "=", 0)) 
		//c4 solver.post(IntConstraintFactory.arithm(dji[j1][i], "=", dji[j2][i]))
		//TODO ifThen(AND(c1,c2), OR(c3,c4,c5))
		for(j1:0..<m){
			for(j2:0..<m){
				if(j1 != j2){
					c1 = IntConstraintFactory.arithm(S.get(j1), "=", 1)
					c2 = IntConstraintFactory.arithm(S.get(j2), "=", 1)
					for(i:0..<n){
						c3 = IntConstraintFactory.arithm(D.get(j1).get(i), "=", 0)
						c4 = IntConstraintFactory.arithm(D.get(j2).get(i), "=", 0)
						c5 = IntConstraintFactory.arithm(D.get(j1).get(i), "=", D.get(j2).get(i))
						LogicalConstraintFactory.ifThen(LogicalConstraintFactory.and(c1,c2), LogicalConstraintFactory.or(c3,c4,c5))
					}
				}
			}
		}
		

		//3) Completeness constraint.
		//All deployable componentsets must take into account all the quality scenarios’ states in the quality configuration
		// Para todo i existe j tal que ((Sj = 1) ^ (D(i,j) != 1))
		//c1 solver.post(IntConstraintFactory.arithm(sj, "=", 1))
		//c2 solver.post(IntConstraintFactory.arithm(dji, "!=", 1))
		//TODO AND(c1,c2)
		for(i:0..<n){
			for(j:0..<m){
				c1 = IntConstraintFactory.arithm(S.get(j), "=", 1)
				c2 = IntConstraintFactory.arithm(D.get(j).get(i), "!=", 1)
				LogicalConstraintFactory.and(c1,c2)
			}
		}

		//Define the search strategy
		//solver.set(IntStrategyFactory.lexico_LB(V, D, S))
		solver.set(IntStrategyFactory.lexico_LB(S))

		
		//Launch the resolution process
		solver.findSolution
		var ISolutionRecorder solRec = solver.solutionRecorder
		var List<Solution> solutions = solRec.solutions

		solutionString += "\n solutions.size: "+solutions.size
		solutionString += "\nsolver.solutionRecorder.solutions.get(0).toString: "+solutions.get(0).toString(solver)
		for (j:0..<m)
			solutionString += "\nsolver.solutionRecorder.solutions.get(0).S("+j+"): "+solutions.get(0).getIntVal(S.get(j))

		while(solver.nextSolution){
			solRec = solver.solutionRecorder
			solutions = solRec.solutions
			solutionString += "\nA new solution has been found"
			solutionString += "\n solutions.size: "+solutions.size
			solutionString += "\nsolver.solutionRecorder.solutions.get(0).toString: "+solutions.get(0).toString(solver)
			for (j:0..<m)
				solutionString += "\nsolver.solutionRecorder.solutions.get(0).S("+j+"): "+solutions.get(0).getIntVal(S.get(j))
				
		}

		fsa.generateFile("ResolutionPlan.txt",	ResolutionTemplate::generate(decisionModel, qualityScenario, solutionString))
	}
	
	
}
