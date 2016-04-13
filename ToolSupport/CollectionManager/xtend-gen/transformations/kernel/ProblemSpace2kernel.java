package transformations.kernel;

import domainmetamodel.Characteristic;
import domainmetamodel.Entity;
import domainmetamodel.ProblemSpace;
import java.util.ArrayList;
import java.util.HashMap;
import kernelmetamodel.Attribute;
import kernelmetamodel.Element;
import kernelmetamodel.Kernel;
import kernelmetamodel.KernelmetamodelFactory;
import kernelmetamodel.Sort;
import kernelmetamodel.SortAlgorithm;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class ProblemSpace2kernel {
  public Kernel problemSpace2kernel(final ProblemSpace ps) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(ps);
    final Kernel _result;
    synchronized (_createCache_problemSpace2kernel) {
      if (_createCache_problemSpace2kernel.containsKey(_cacheKey)) {
        return _createCache_problemSpace2kernel.get(_cacheKey);
      }
      Kernel _createKernel = KernelmetamodelFactory.eINSTANCE.createKernel();
      _result = _createKernel;
      _createCache_problemSpace2kernel.put(_cacheKey, _result);
    }
    _init_problemSpace2kernel(_result, ps);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Kernel> _createCache_problemSpace2kernel = CollectionLiterals.newHashMap();
  
  private void _init_problemSpace2kernel(final Kernel it, final ProblemSpace ps) {
    it.setName("kernel");
    this.problemSpace2System(it, ps);
  }
  
  public kernelmetamodel.System problemSpace2System(final Kernel k, final ProblemSpace ps) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(k, ps);
    final kernelmetamodel.System _result;
    synchronized (_createCache_problemSpace2System) {
      if (_createCache_problemSpace2System.containsKey(_cacheKey)) {
        return _createCache_problemSpace2System.get(_cacheKey);
      }
      kernelmetamodel.System _createSystem = KernelmetamodelFactory.eINSTANCE.createSystem();
      _result = _createSystem;
      _createCache_problemSpace2System.put(_cacheKey, _result);
    }
    _init_problemSpace2System(_result, k, ps);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, kernelmetamodel.System> _createCache_problemSpace2System = CollectionLiterals.newHashMap();
  
  private void _init_problemSpace2System(final kernelmetamodel.System it, final Kernel k, final ProblemSpace ps) {
    String _name = ps.getName();
    it.setName(_name);
    k.setSystem(it);
    Entity _entity = ps.getEntity();
    this.entity2Element(it, _entity);
  }
  
  public Element entity2Element(final kernelmetamodel.System s, final Entity e) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(s, e);
    final Element _result;
    synchronized (_createCache_entity2Element) {
      if (_createCache_entity2Element.containsKey(_cacheKey)) {
        return _createCache_entity2Element.get(_cacheKey);
      }
      Element _createElement = KernelmetamodelFactory.eINSTANCE.createElement();
      _result = _createElement;
      _createCache_entity2Element.put(_cacheKey, _result);
    }
    _init_entity2Element(_result, s, e);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Element> _createCache_entity2Element = CollectionLiterals.newHashMap();
  
  private void _init_entity2Element(final Element it, final kernelmetamodel.System s, final Entity e) {
    String _name = e.getName();
    it.setName(_name);
    for (int i = 0; (i < e.getCharacteristic().size()); i++) {
      EList<Characteristic> _characteristic = e.getCharacteristic();
      Characteristic _get = _characteristic.get(i);
      this.characteristic2Attribute(s, it, _get);
    }
    s.setElement(it);
  }
  
  public Attribute characteristic2Attribute(final kernelmetamodel.System s, final Element e, final Characteristic c) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(s, e, c);
    final Attribute _result;
    synchronized (_createCache_characteristic2Attribute) {
      if (_createCache_characteristic2Attribute.containsKey(_cacheKey)) {
        return _createCache_characteristic2Attribute.get(_cacheKey);
      }
      Attribute _createAttribute = KernelmetamodelFactory.eINSTANCE.createAttribute();
      _result = _createAttribute;
      _createCache_characteristic2Attribute.put(_cacheKey, _result);
    }
    _init_characteristic2Attribute(_result, s, e, c);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Attribute> _createCache_characteristic2Attribute = CollectionLiterals.newHashMap();
  
  private void _init_characteristic2Attribute(final Attribute it, final kernelmetamodel.System s, final Element e, final Characteristic c) {
    String _name = c.getName();
    it.setName(_name);
    boolean _xifexpression = false;
    String _name_1 = c.getName();
    boolean _matches = _name_1.matches("name");
    if (_matches) {
      _xifexpression = true;
    } else {
      _xifexpression = false;
    }
    it.setIsIdentifier(_xifexpression);
    this.createBubbleSort(it, s);
    this.createInsertSort(it, s);
    EList<Attribute> _attribute = e.getAttribute();
    _attribute.add(it);
  }
  
  public Sort createBubbleSort(final Attribute a, final kernelmetamodel.System s) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(a, s);
    final Sort _result;
    synchronized (_createCache_createBubbleSort) {
      if (_createCache_createBubbleSort.containsKey(_cacheKey)) {
        return _createCache_createBubbleSort.get(_cacheKey);
      }
      Sort _createSort = KernelmetamodelFactory.eINSTANCE.createSort();
      _result = _createSort;
      _createCache_createBubbleSort.put(_cacheKey, _result);
    }
    _init_createBubbleSort(_result, a, s);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Sort> _createCache_createBubbleSort = CollectionLiterals.newHashMap();
  
  private void _init_createBubbleSort(final Sort it, final Attribute a, final kernelmetamodel.System s) {
    String _name = a.getName();
    it.setName(_name);
    it.setAlgorithm(SortAlgorithm.BUBBLE);
    EList<Sort> _sort = s.getSort();
    _sort.add(it);
  }
  
  public Sort createInsertSort(final Attribute a, final kernelmetamodel.System s) {
    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(a, s);
    final Sort _result;
    synchronized (_createCache_createInsertSort) {
      if (_createCache_createInsertSort.containsKey(_cacheKey)) {
        return _createCache_createInsertSort.get(_cacheKey);
      }
      Sort _createSort = KernelmetamodelFactory.eINSTANCE.createSort();
      _result = _createSort;
      _createCache_createInsertSort.put(_cacheKey, _result);
    }
    _init_createInsertSort(_result, a, s);
    return _result;
  }
  
  private final HashMap<ArrayList<?>, Sort> _createCache_createInsertSort = CollectionLiterals.newHashMap();
  
  private void _init_createInsertSort(final Sort it, final Attribute a, final kernelmetamodel.System s) {
    String _name = a.getName();
    it.setName(_name);
    it.setAlgorithm(SortAlgorithm.INSERTION);
    EList<Sort> _sort = s.getSort();
    _sort.add(it);
  }
}
