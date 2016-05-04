package transformations.gui

import domainmetamodel.ProblemSpace
import guimetamodel.CreateView
import guimetamodel.GUI
import guimetamodel.GuimetamodelFactory
import guimetamodel.InfoSingleView
import guimetamodel.ListView
import guimetamodel.MainView
import guimetamodel.OrderView

class ProblemSpace2gui {
	
	//Crea el kernel y recursivamente crea el System
	def GUI create GuimetamodelFactory::eINSTANCE.createGUI() problemSpace2gui(ProblemSpace ps){
		name = "GUI"
		systemName = ps.name
		crMainView(it)
	}
	
	//Crea el MainView a partir del GUI
	def MainView create GuimetamodelFactory::eINSTANCE.createMainView() crMainView(GUI gui){
		title = gui.systemName
		name = gui.name
		gui.mainview = it
		crListView(it)
		crOrderView(it)
		crInfoSingleView(it)
	}
	
	//Crea el ListView a partir del MainView
	def ListView create GuimetamodelFactory::eINSTANCE.createListView() crListView(MainView mv){
		title = 'Songs'
		mv.listview = it
		crCreateView(it)
	}
	
	//Crea el ListView a partir del MainView
	def OrderView create GuimetamodelFactory::eINSTANCE.createOrderView() crOrderView(MainView mv){
		title = 'Order by'
		mv.orderview = it
	}

	//Crea el ListView a partir del MainView
	def InfoSingleView create GuimetamodelFactory::eINSTANCE.createInfoSingleView() crInfoSingleView(MainView mv){
		title = 'Song information'
		mv.infoview = it
	}

	//Crea el CreateView a partir del ListView (crea un addView)
	def CreateView create GuimetamodelFactory::eINSTANCE.createCreateView() crCreateView(ListView lv){
		title = 'Add Song'
		lv.createview = it
	}

}