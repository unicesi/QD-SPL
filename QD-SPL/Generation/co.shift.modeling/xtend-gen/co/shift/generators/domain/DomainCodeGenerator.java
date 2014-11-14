package co.shift.generators.domain;

import co.shift.contributors.Contribution;
import co.shift.qualiyatributes.ImplMapping;
import co.shift.qualiyatributes.QAParser;
import co.shift.templates.ejb.basic.BoundaryImplTemplate;
import co.shift.templates.ejb.basic.BoundaryInterfaceTemplate;
import co.shift.templates.ejb.basic.DAOImplTemplate;
import co.shift.templates.ejb.basic.DAOInterfaceTemplate;
import co.shift.templates.ejb.basic.DTOTemplate;
import co.shift.templates.ejb.basic.JPATemplate;
import co.shift.templates.web.basic.AbstractControllerTemplate;
import co.shift.templates.web.basic.ContentPanelTemplate;
import co.shift.templates.web.basic.MenuPaneTemplate;
import co.shift.templates.web.basic.ProcessContributorTemplate;
import co.shift.templates.web.basic.RegistryTemplate;
import co.shift.templates.web.basic.UIContributorTemplate;
import co.shift.templates.web.basic.UIControllerTemplate;
import co.shift.templates.web.basic.UITemplate;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.Business;
import domainmetamodel.BusinessEntity;
import domainmetamodel.DataType;
import domainmetamodel.Multiple;
import domainmetamodel.Simple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DomainCodeGenerator implements IGenerator {
  public final static String CONTRIBUTE_TO_BI = "BusinessInterface";
  
  public final static String CONTRIBUTE_TO_BIMPL = "BusinessImplementation";
  
  public final static String CONTRIBUTE_TO_WEB = "Web";
  
  public final static String CONTRIBUTE_TO_IMPORT = "Imports";
  
  public final static String CONTRIBUTE_TO_ATTRIBUTE = "Attributes";
  
  public final static String CONTRIBUTE_TO_GENERATION = "Generate";
  
  private static HashMap<String, Contribution> selectedContributors;
  
  private List<BusinessEntity> businessEntities;
  
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    ImplMapping.performMapping();
    final QAParser qas = new QAParser();
    BusinessEntity authEntity = null;
    HashMap<String, Contribution> _parseSelectedFeatures = qas.parseSelectedFeatures();
    DomainCodeGenerator.selectedContributors = _parseSelectedFeatures;
    ArrayList<BusinessEntity> _arrayList = new ArrayList<BusinessEntity>();
    this.businessEntities = _arrayList;
    String appName = "";
    String name = "";
    List<Association> associations = new ArrayList<Association>();
    TreeIterator<EObject> _allContents = input.getAllContents();
    Iterable<EObject> _iterable = IteratorExtensions.<EObject>toIterable(_allContents);
    for (final EObject k : _iterable) {
      {
        if ((k instanceof Business)) {
          final Business b = ((Business) k);
          String _name = b.getName();
          appName = _name;
          List<Association> _businessAssociations = this.getBusinessAssociations(b);
          associations = _businessAssociations;
        }
        if ((k instanceof BusinessEntity)) {
          final BusinessEntity be = ((BusinessEntity) k);
          boolean _isIsAuthenticable = be.isIsAuthenticable();
          if (_isIsAuthenticable) {
            authEntity = be;
          } else {
            this.addBusinessEntity(be);
          }
          String _name_1 = be.getName();
          String _firstUpper = StringExtensions.toFirstUpper(_name_1);
          name = _firstUpper;
          String _lowerCase = appName.toLowerCase();
          String _plus = ("/co/shift/" + _lowerCase);
          String _plus_1 = (_plus + "/to/");
          String _plus_2 = (_plus_1 + name);
          String _plus_3 = (_plus_2 + "TO.java");
          CharSequence _generate = DTOTemplate.generate(be, appName, associations);
          fsa.generateFile(_plus_3, _generate);
          String _lowerCase_1 = appName.toLowerCase();
          String _plus_4 = ("/co/shift/" + _lowerCase_1);
          String _plus_5 = (_plus_4 + "/");
          String _lowerCase_2 = name.toLowerCase();
          String _plus_6 = (_plus_5 + _lowerCase_2);
          String _plus_7 = (_plus_6 + "/boundary/I");
          String _plus_8 = (_plus_7 + name);
          String _plus_9 = (_plus_8 + "Manager.java");
          CharSequence _generate_1 = BoundaryInterfaceTemplate.generate(be, appName, associations, fsa);
          fsa.generateFile(_plus_9, _generate_1);
          String _lowerCase_3 = appName.toLowerCase();
          String _plus_10 = ("/co/shift/" + _lowerCase_3);
          String _plus_11 = (_plus_10 + "/");
          String _lowerCase_4 = name.toLowerCase();
          String _plus_12 = (_plus_11 + _lowerCase_4);
          String _plus_13 = (_plus_12 + "/boundary/");
          String _plus_14 = (_plus_13 + name);
          String _plus_15 = (_plus_14 + "Manager.java");
          CharSequence _generate_2 = BoundaryImplTemplate.generate(be, appName, associations, fsa);
          fsa.generateFile(_plus_15, _generate_2);
          String _lowerCase_5 = appName.toLowerCase();
          String _plus_16 = ("/co/shift/" + _lowerCase_5);
          String _plus_17 = (_plus_16 + "/");
          String _lowerCase_6 = name.toLowerCase();
          String _plus_18 = (_plus_17 + _lowerCase_6);
          String _plus_19 = (_plus_18 + "/entity/");
          String _plus_20 = (_plus_19 + name);
          String _plus_21 = (_plus_20 + ".java");
          CharSequence _generate_3 = JPATemplate.generate(be, appName, associations, fsa);
          fsa.generateFile(_plus_21, _generate_3);
          boolean _and = false;
          List<Association> _detailMultipleAssociations = DomainCodeGenerator.getDetailMultipleAssociations(be, associations);
          int _size = _detailMultipleAssociations.size();
          boolean _greaterThan = (_size > 0);
          if (!_greaterThan) {
            _and = false;
          } else {
            boolean _isDetail = DomainCodeGenerator.isDetail(be);
            boolean _not = (!_isDetail);
            _and = _not;
          }
          if (_and) {
            String _lowerCase_7 = appName.toLowerCase();
            String _plus_22 = ("/co/shift/" + _lowerCase_7);
            String _plus_23 = (_plus_22 + "/");
            String _lowerCase_8 = name.toLowerCase();
            String _plus_24 = (_plus_23 + _lowerCase_8);
            String _plus_25 = (_plus_24 + "/control/I");
            String _plus_26 = (_plus_25 + name);
            String _plus_27 = (_plus_26 + "DAO.java");
            CharSequence _generate_4 = DAOInterfaceTemplate.generate(be, appName, associations);
            fsa.generateFile(_plus_27, _generate_4);
            String _lowerCase_9 = appName.toLowerCase();
            String _plus_28 = ("/co/shift/" + _lowerCase_9);
            String _plus_29 = (_plus_28 + "/");
            String _lowerCase_10 = name.toLowerCase();
            String _plus_30 = (_plus_29 + _lowerCase_10);
            String _plus_31 = (_plus_30 + "/control/");
            String _plus_32 = (_plus_31 + name);
            String _plus_33 = (_plus_32 + "DAO.java");
            CharSequence _generate_5 = DAOImplTemplate.generate(be, appName, associations);
            fsa.generateFile(_plus_33, _generate_5);
          }
        }
      }
    }
    DomainCodeGenerator.extendContribution("_r_2_11", DomainCodeGenerator.CONTRIBUTE_TO_GENERATION, fsa, appName, authEntity);
    String _lowerCase = appName.toLowerCase();
    String _plus = ("/co/shift/" + _lowerCase);
    String _plus_1 = (_plus + "/web/AbstractController.java");
    CharSequence _generate = AbstractControllerTemplate.generate(appName);
    fsa.generateFile(_plus_1, _generate);
    String _lowerCase_1 = appName.toLowerCase();
    String _plus_2 = ("/co/shift/" + _lowerCase_1);
    String _plus_3 = (_plus_2 + "/web/");
    String _upperCase = appName.toUpperCase();
    String _plus_4 = (_plus_3 + _upperCase);
    String _plus_5 = (_plus_4 + "UI.java");
    CharSequence _generate_1 = UITemplate.generate(appName);
    fsa.generateFile(_plus_5, _generate_1);
    String _lowerCase_2 = appName.toLowerCase();
    String _plus_6 = ("/co/shift/" + _lowerCase_2);
    String _plus_7 = (_plus_6 + "/web/ProcessContributor.java");
    CharSequence _generate_2 = ProcessContributorTemplate.generate(appName);
    fsa.generateFile(_plus_7, _generate_2);
    String _lowerCase_3 = appName.toLowerCase();
    String _plus_8 = ("/co/shift/" + _lowerCase_3);
    String _plus_9 = (_plus_8 + "/web/Registry.java");
    CharSequence _generate_3 = RegistryTemplate.generate(appName);
    fsa.generateFile(_plus_9, _generate_3);
    String _lowerCase_4 = appName.toLowerCase();
    String _plus_10 = ("/co/shift/" + _lowerCase_4);
    String _plus_11 = (_plus_10 + "/web/UIContributor.java");
    CharSequence _generate_4 = UIContributorTemplate.generate(appName);
    fsa.generateFile(_plus_11, _generate_4);
    String _lowerCase_5 = appName.toLowerCase();
    String _plus_12 = ("/co/shift/" + _lowerCase_5);
    String _plus_13 = (_plus_12 + "/web/UIController.java");
    CharSequence _generate_5 = UIControllerTemplate.generate(appName, authEntity, this.businessEntities);
    fsa.generateFile(_plus_13, _generate_5);
    String _lowerCase_6 = appName.toLowerCase();
    String _plus_14 = ("/co/shift/" + _lowerCase_6);
    String _plus_15 = (_plus_14 + "/web/client/ContentPanel.java");
    CharSequence _generate_6 = ContentPanelTemplate.generate(appName);
    fsa.generateFile(_plus_15, _generate_6);
    String _lowerCase_7 = appName.toLowerCase();
    String _plus_16 = ("/co/shift/" + _lowerCase_7);
    String _plus_17 = (_plus_16 + "/web/client/MenuPanel.java");
    CharSequence _generate_7 = MenuPaneTemplate.generate(appName);
    fsa.generateFile(_plus_17, _generate_7);
  }
  
  public List<BusinessEntity> getBusinessEntities() {
    return this.businessEntities;
  }
  
  public void addBusinessEntity(final BusinessEntity be) {
    this.businessEntities.add(be);
  }
  
  public List<Association> getBusinessAssociations(final Business b) {
    List<Association> _xblockexpression = null;
    {
      List<Association> associations = new ArrayList<Association>();
      EList<BusinessEntity> _entities = b.getEntities();
      for (final BusinessEntity be : _entities) {
        EList<Association> _associations = be.getAssociations();
        for (final Association a : _associations) {
          associations.add(a);
        }
      }
      _xblockexpression = associations;
    }
    return _xblockexpression;
  }
  
  public static String extendContribution(final String id, final String phase, final Object... data) {
    final List<Contribution> contributors = DomainCodeGenerator.getSelectedVariants(id);
    String rules = "";
    boolean _equals = phase.equals(DomainCodeGenerator.CONTRIBUTE_TO_BI);
    if (_equals) {
      for (final Contribution c : contributors) {
        String _rules = rules;
        String _contributeToBusinessInterface = c.contributeToBusinessInterface(data);
        String _plus = (_contributeToBusinessInterface + "\n\n");
        rules = (_rules + _plus);
      }
    }
    boolean _equals_1 = phase.equals(DomainCodeGenerator.CONTRIBUTE_TO_BIMPL);
    if (_equals_1) {
      for (final Contribution c_1 : contributors) {
        String _rules_1 = rules;
        String _contributeToBusinessImpl = c_1.contributeToBusinessImpl(data);
        String _plus_1 = (_contributeToBusinessImpl + "\n\n");
        rules = (_rules_1 + _plus_1);
      }
    }
    boolean _equals_2 = phase.equals(DomainCodeGenerator.CONTRIBUTE_TO_WEB);
    if (_equals_2) {
      for (final Contribution c_2 : contributors) {
        String _rules_2 = rules;
        String _contributeToWeb = c_2.contributeToWeb(data);
        String _plus_2 = (_contributeToWeb + "\n\n");
        rules = (_rules_2 + _plus_2);
      }
    }
    boolean _equals_3 = phase.equals(DomainCodeGenerator.CONTRIBUTE_TO_ATTRIBUTE);
    if (_equals_3) {
      for (final Contribution c_3 : contributors) {
        String _rules_3 = rules;
        String _contributeToAtribute = c_3.contributeToAtribute(data);
        String _plus_3 = (_contributeToAtribute + "\n\n");
        rules = (_rules_3 + _plus_3);
      }
    }
    boolean _equals_4 = phase.equals(DomainCodeGenerator.CONTRIBUTE_TO_IMPORT);
    if (_equals_4) {
      for (final Contribution c_4 : contributors) {
        String _rules_4 = rules;
        String _contributeToImport = c_4.contributeToImport(data);
        String _plus_4 = (_contributeToImport + "\n\n");
        rules = (_rules_4 + _plus_4);
      }
    }
    boolean _equals_5 = phase.equals(DomainCodeGenerator.CONTRIBUTE_TO_GENERATION);
    if (_equals_5) {
      for (final Contribution c_5 : contributors) {
        c_5.generate(data);
      }
    }
    return rules;
  }
  
  public static boolean isQASelected(final String prefixId) {
    Set<String> _keySet = DomainCodeGenerator.selectedContributors.keySet();
    final Iterator<String> i = _keySet.iterator();
    while (i.hasNext()) {
      {
        final String c = i.next();
        boolean _equals = c.equals(prefixId);
        if (_equals) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static List<Contribution> getSelectedVariants(final String variationPointPrefix) {
    List<Contribution> _xblockexpression = null;
    {
      final List<Contribution> foundVariants = new ArrayList<Contribution>();
      Set<String> _keySet = DomainCodeGenerator.selectedContributors.keySet();
      final Iterator<String> i = _keySet.iterator();
      while (i.hasNext()) {
        {
          final String c = i.next();
          boolean _startsWith = c.startsWith(variationPointPrefix);
          if (_startsWith) {
            Contribution _get = DomainCodeGenerator.selectedContributors.get(c);
            foundVariants.add(_get);
          }
        }
      }
      _xblockexpression = foundVariants;
    }
    return _xblockexpression;
  }
  
  public static Attribute getID(final BusinessEntity be) {
    Object _xblockexpression = null;
    {
      EList<Attribute> _attributes = be.getAttributes();
      List<Attribute> _list = IterableExtensions.<Attribute>toList(_attributes);
      for (final Attribute a : _list) {
        boolean _isIsDefault = a.isIsDefault();
        boolean _equals = (_isIsDefault == true);
        if (_equals) {
          return a;
        }
      }
      _xblockexpression = null;
    }
    return ((Attribute)_xblockexpression);
  }
  
  public static String getType(final String literal) {
    boolean _equals = literal.equals("string");
    if (_equals) {
      return "String";
    }
    boolean _equals_1 = literal.equals("date");
    if (_equals_1) {
      return "Date";
    }
    boolean _equals_2 = literal.equals("object");
    if (_equals_2) {
      return "Object";
    }
    boolean _equals_3 = literal.equals("collection");
    if (_equals_3) {
      return "List";
    }
    return literal;
  }
  
  public static String getType(final Attribute attribute) {
    DataType _dataType = attribute.getDataType();
    final String literal = _dataType.getLiteral();
    boolean _equals = literal.equals("string");
    if (_equals) {
      return "String";
    }
    boolean _equals_1 = literal.equals("date");
    if (_equals_1) {
      return "Date";
    }
    boolean _equals_2 = literal.equals("object");
    if (_equals_2) {
      return "Object";
    }
    boolean _equals_3 = literal.equals("collection");
    if (_equals_3) {
      return "List";
    }
    return literal;
  }
  
  public static List<Association> getDetailSimpleAssociations(final BusinessEntity be, final List<Association> list) {
    List<Association> _xblockexpression = null;
    {
      final List<Association> associations = new ArrayList<Association>();
      for (final Association a : list) {
        if ((a instanceof Simple)) {
          BusinessEntity _relatedEntity = ((Simple)a).getRelatedEntity();
          String _name = _relatedEntity.getName();
          String _name_1 = be.getName();
          boolean _equals = _name.equals(_name_1);
          if (_equals) {
            associations.add(a);
          }
        }
      }
      _xblockexpression = associations;
    }
    return _xblockexpression;
  }
  
  public static List<Association> getDetailMultipleAssociations(final BusinessEntity be, final List<Association> list) {
    List<Association> _xblockexpression = null;
    {
      final List<Association> associations = new ArrayList<Association>();
      for (final Association a : list) {
        if ((a instanceof Multiple)) {
          BusinessEntity _entity = ((Multiple)a).getEntity();
          String _name = _entity.getName();
          String _name_1 = be.getName();
          boolean _equals = _name.equals(_name_1);
          if (_equals) {
            associations.add(a);
          }
        }
      }
      _xblockexpression = associations;
    }
    return _xblockexpression;
  }
  
  public static boolean isDetail(final BusinessEntity be) {
    EList<Association> _associations = be.getAssociations();
    int _size = _associations.size();
    return (_size == 0);
  }
  
  public static boolean isMaster(final BusinessEntity be) {
    EList<Association> _associations = be.getAssociations();
    for (final Association ass : _associations) {
      if ((ass instanceof Multiple)) {
        return true;
      }
    }
    return false;
  }
}
