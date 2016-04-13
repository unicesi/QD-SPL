package transformations.gui;

import domainmetamodel.ProblemSpace;
import guimetamodel.CreateView;
import guimetamodel.GUI;
import guimetamodel.GuimetamodelFactory;
import guimetamodel.InfoSingleView;
import guimetamodel.ListView;
import guimetamodel.MainView;
import guimetamodel.OrderView;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ProblemSpace2gui {
  public GUI problemSpace2gui(final ProblemSpace ps) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(ps);
    final GUI _result;
    synchronized (_createCache_problemSpace2gui) {
      if (_createCache_problemSpace2gui.containsKey(_cacheKey)) {
        return _createCache_problemSpace2gui.get(_cacheKey);
      }
      GUI _createGUI = GuimetamodelFactory.eINSTANCE.createGUI();
      _result = _createGUI;
      _createCache_problemSpace2gui.put(_cacheKey, _result);
    }
    _init_problemSpace2gui(_result, ps);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, GUI> _createCache_problemSpace2gui = CollectionLiterals.newHashMap();
  
  private void _init_problemSpace2gui(final GUI it, final ProblemSpace ps) {
    it.setName("GUI");
    String _name = ps.getName();
    it.setSystemName(_name);
    this.crMainView(it);
  }
  
  public MainView crMainView(final GUI gui) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(gui);
    final MainView _result;
    synchronized (_createCache_crMainView) {
      if (_createCache_crMainView.containsKey(_cacheKey)) {
        return _createCache_crMainView.get(_cacheKey);
      }
      MainView _createMainView = GuimetamodelFactory.eINSTANCE.createMainView();
      _result = _createMainView;
      _createCache_crMainView.put(_cacheKey, _result);
    }
    _init_crMainView(_result, gui);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, MainView> _createCache_crMainView = CollectionLiterals.newHashMap();
  
  private void _init_crMainView(final MainView it, final GUI gui) {
    String _systemName = gui.getSystemName();
    it.setTitle(_systemName);
    String _name = gui.getName();
    it.setName(_name);
    gui.setMainview(it);
    this.crListView(it);
    this.crOrderView(it);
    this.crInfoSingleView(it);
  }
  
  public ListView crListView(final MainView mv) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(mv);
    final ListView _result;
    synchronized (_createCache_crListView) {
      if (_createCache_crListView.containsKey(_cacheKey)) {
        return _createCache_crListView.get(_cacheKey);
      }
      ListView _createListView = GuimetamodelFactory.eINSTANCE.createListView();
      _result = _createListView;
      _createCache_crListView.put(_cacheKey, _result);
    }
    _init_crListView(_result, mv);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, ListView> _createCache_crListView = CollectionLiterals.newHashMap();
  
  private void _init_crListView(final ListView it, final MainView mv) {
    it.setTitle("Songs");
    mv.setListview(it);
    this.crCreateView(it);
  }
  
  public OrderView crOrderView(final MainView mv) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(mv);
    final OrderView _result;
    synchronized (_createCache_crOrderView) {
      if (_createCache_crOrderView.containsKey(_cacheKey)) {
        return _createCache_crOrderView.get(_cacheKey);
      }
      OrderView _createOrderView = GuimetamodelFactory.eINSTANCE.createOrderView();
      _result = _createOrderView;
      _createCache_crOrderView.put(_cacheKey, _result);
    }
    _init_crOrderView(_result, mv);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, OrderView> _createCache_crOrderView = CollectionLiterals.newHashMap();
  
  private void _init_crOrderView(final OrderView it, final MainView mv) {
    it.setTitle("Order by");
    mv.setOrderview(it);
  }
  
  public InfoSingleView crInfoSingleView(final MainView mv) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(mv);
    final InfoSingleView _result;
    synchronized (_createCache_crInfoSingleView) {
      if (_createCache_crInfoSingleView.containsKey(_cacheKey)) {
        return _createCache_crInfoSingleView.get(_cacheKey);
      }
      InfoSingleView _createInfoSingleView = GuimetamodelFactory.eINSTANCE.createInfoSingleView();
      _result = _createInfoSingleView;
      _createCache_crInfoSingleView.put(_cacheKey, _result);
    }
    _init_crInfoSingleView(_result, mv);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, InfoSingleView> _createCache_crInfoSingleView = CollectionLiterals.newHashMap();
  
  private void _init_crInfoSingleView(final InfoSingleView it, final MainView mv) {
    it.setTitle("Song information");
    mv.setInfoview(it);
  }
  
  public CreateView crCreateView(final ListView lv) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(lv);
    final CreateView _result;
    synchronized (_createCache_crCreateView) {
      if (_createCache_crCreateView.containsKey(_cacheKey)) {
        return _createCache_crCreateView.get(_cacheKey);
      }
      CreateView _createCreateView = GuimetamodelFactory.eINSTANCE.createCreateView();
      _result = _createCreateView;
      _createCache_crCreateView.put(_cacheKey, _result);
    }
    _init_crCreateView(_result, lv);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, CreateView> _createCache_crCreateView = CollectionLiterals.newHashMap();
  
  private void _init_crCreateView(final CreateView it, final ListView lv) {
    it.setTitle("Add Song");
    lv.setCreateview(it);
  }
}
