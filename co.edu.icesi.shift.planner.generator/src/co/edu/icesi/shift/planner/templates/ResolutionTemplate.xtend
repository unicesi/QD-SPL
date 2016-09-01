package co.edu.icesi.shift.planner.templates

import java.util.List

class ResolutionTemplate {
	
//	def static generate(DecisionModel dm, String string, List<Association> associations) '''
	def static generate(List<List<String>> decisionModel, List<String> qualityScenario, String solverMeasures) '''
		Quality Scenario:
«««		«FOR v : qualityScenario»
«««			Variant: «v»
«««		«ENDFOR»
		Decision Model:
«««		«FOR decisions : decisionModel»
«««			Decision: «decisions»
«««			«FOR requiredVariant : decisions»
«««				ReqVariant: «requiredVariant»
«««			«ENDFOR»
«««		«ENDFOR»
		Solver statistics:
			«solverMeasures»
	'''
	
}