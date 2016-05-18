package co.shift.generators.domain;

import co.shift.contributors.Contribution;
import co.shift.generators.domain.DomainCodeSetup;
import co.shift.qualiyatributes.QAParser;
import com.google.common.base.Objects;
import com.google.inject.Injector;
import domainmetamodel.Association;
import domainmetamodel.Attribute;
import domainmetamodel.Business;
import domainmetamodel.BusinessEntity;
import domainmetamodel.Contracts;
import domainmetamodel.DataType;
import domainmetamodel.DeleteElement;
import domainmetamodel.Multiple;
import domainmetamodel.Simple;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

@SuppressWarnings("all")
public class DomainCodeUtilities {
  public static String GENERATION_DIR = "";
  
  public static String SRC_DIR = "";
  
  public final static String CONTRIBUTE_TO_BI = "BusinessInterface";
  
  public final static String CONTRIBUTE_TO_BIMPL = "BusinessImplementation";
  
  public final static String CONTRIBUTE_TO_WEB_IMPL = "WebImpl";
  
  public final static String CONTRIBUTE_TO_WEB_ATTRIBUTE = "WebAtt";
  
  public final static String CONTRIBUTE_TO_WEB_IMPORT = "WebImport";
  
  public final static String CONTRIBUTE_TO_BUSINESS_IMPORT = "Imports";
  
  public final static String CONTRIBUTE_TO_BUSINESS_ATTRIBUTE = "Attributes";
  
  public final static String CONTRIBUTE_TO_GENERATION = "Generate";
  
  public static Connection connection;
  
  public static Injector injector;
  
  public static String CURRENT_TEMPLATE = "";
  
  public static String CURRENT_SECTION = "";
  
  public static String CURRENT_QACONFIG = "";
  
  private static List<String> selectedFeatures;
  
  private static HashMap<String, Contribution> selectedContributors;
  
  private static HashSet<BusinessEntity> businessEntities;
  
  private static TreeSet<String> entityNames;
  
  private static TreeSet<String> services;
  
  private static List<BusinessEntity[]> manyToMany;
  
  public static HashSet<BusinessEntity> getBusinessEntities() {
    return DomainCodeUtilities.businessEntities;
  }
  
  public static void addBusinessEntity(final BusinessEntity be) {
    DomainCodeUtilities.businessEntities.add(be);
  }
  
  public static TreeSet<String> getEntityNames() {
    return DomainCodeUtilities.entityNames;
  }
  
  public static void addEntityName(final String name) {
    DomainCodeUtilities.entityNames.add(name);
  }
  
  public static TreeSet<String> getServices() {
    return DomainCodeUtilities.services;
  }
  
  public static void addService(final String name) {
    DomainCodeUtilities.services.add(name);
  }
  
  public static List<BusinessEntity[]> getManyToManyAssociations() {
    return DomainCodeUtilities.manyToMany;
  }
  
  public static void addManyToManyAssociation(final BusinessEntity[] asso) {
    DomainCodeUtilities.manyToMany.add(asso);
  }
  
  public static List<Association> getBusinessAssociations(final Business b) {
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
  
  public static boolean hasRemoveContract(final BusinessEntity be, final BusinessEntity relBe) {
    EList<Contracts> _contracts = be.getContracts();
    for (final Contracts c : _contracts) {
      if ((c instanceof DeleteElement)) {
        Multiple _association = ((DeleteElement)c).getAssociation();
        BusinessEntity en = _association.getEntity();
        String _name = en.getName();
        String _name_1 = relBe.getName();
        boolean _equals = _name.equals(_name_1);
        if (_equals) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static List<Contracts> getContract(final BusinessEntity be, final Class contractClass) {
    List<Contracts> list = new ArrayList<Contracts>();
    EList<Contracts> _contracts = be.getContracts();
    for (final Contracts c : _contracts) {
      {
        Class<? extends Contracts> _class = c.getClass();
        String _name = _class.getName();
        String[] _split = _name.split("[.]");
        String cName = _split[2];
        int _indexOf = cName.indexOf("Impl");
        String cName2 = cName.substring(0, _indexOf);
        String _name_1 = contractClass.getName();
        String[] _split_1 = _name_1.split("[.]");
        String ccName = _split_1[1];
        boolean _equals = cName2.equals(ccName);
        if (_equals) {
          list.add(c);
        }
      }
    }
    return list;
  }
  
  public static Attribute getSecondAttribute(final BusinessEntity be) {
    Attribute beId = DomainCodeUtilities.getID(be);
    EList<Attribute> _attributes = be.getAttributes();
    for (final Attribute a : _attributes) {
      String _name = a.getName();
      String _name_1 = beId.getName();
      boolean _equals = _name.equals(_name_1);
      boolean _not = (!_equals);
      if (_not) {
        return a;
      }
    }
    return null;
  }
  
  public static Connection GetConnection() {
    try {
      Connection _xblockexpression = null;
      {
        Class.forName("com.mysql.jdbc.Driver");
        _xblockexpression = DriverManager.getConnection("jdbc:mysql://localhost:3306/ReferenceModel", "root", "root");
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static List<String> init() {
    List<String> _xblockexpression = null;
    {
      final QAParser qas = new QAParser();
      HashMap<String, Contribution> _parseSelectedFeatures = qas.parseSelectedFeatures();
      DomainCodeUtilities.selectedContributors = _parseSelectedFeatures;
      HashSet<BusinessEntity> _hashSet = new HashSet<BusinessEntity>();
      DomainCodeUtilities.businessEntities = _hashSet;
      TreeSet<String> _treeSet = new TreeSet<String>();
      DomainCodeUtilities.entityNames = _treeSet;
      TreeSet<String> _treeSet_1 = new TreeSet<String>();
      DomainCodeUtilities.services = _treeSet_1;
      ArrayList<BusinessEntity[]> _newArrayList = CollectionLiterals.<BusinessEntity[]>newArrayList();
      DomainCodeUtilities.manyToMany = _newArrayList;
      Connection _GetConnection = DomainCodeUtilities.GetConnection();
      DomainCodeUtilities.connection = _GetConnection;
      DomainCodeSetup _domainCodeSetup = new DomainCodeSetup();
      Injector _createInjectorAndDoEMFRegistration = _domainCodeSetup.createInjectorAndDoEMFRegistration();
      DomainCodeUtilities.injector = _createInjectorAndDoEMFRegistration;
      List<String> _selectedFeatures = qas.getSelectedFeatures();
      _xblockexpression = DomainCodeUtilities.selectedFeatures = _selectedFeatures;
    }
    return _xblockexpression;
  }
  
  public static void end() {
    try {
      DomainCodeUtilities.connection.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Inicio Jcifuentes
   * //Se requiere la plantilla
   * //Se requiere el id del qa para saber cual contribuyente usar
   * //Se requiere la seccion para saber cual metodo del contribuyente ejecutar
   * //El método busca en la configuracion los QAs seleccionados para el prefijo dado y obtiene el contribuyente.metodo(parametros) a ejecutar
   * //ArchitectureFragment {String contributor, String method, String data}
   * def static String extendContribution(String templateId, String sectionId, String variationPointId) {
   * val List<ArchitectureFragment> fragments = loadFromConfig(templateId, sectionId, variationPointId) //Load from DB given template, section and VP
   * for (f : fragments){
   * f.contributor+"."+f.method
   * val c = Class.forName(f.contributor);
   * val o = c.newInstance();
   * val m = c.getDeclaredMethod(f.method, Object... data); //Validar qué se debe pasar aquí
   * val s = m.invoke(?, f.data)
   * s.toString //validar cómo retornar el verdadero valor que queda en el Object s
   * }
   * 
   * }
   */
  public static String contribute(final Object... data) {
    try {
      Object[] _array = DomainCodeUtilities.selectedFeatures.toArray();
      String stringSelectedFeatures = ((List<Object>)Conversions.doWrapArray(_array)).toString();
      System.err.println(("selectedFeatures: " + stringSelectedFeatures));
      String rules = "";
      Statement s = DomainCodeUtilities.connection.createStatement();
      ResultSet rs = s.executeQuery((((("select 1 from dual where \'" + stringSelectedFeatures) + "\'\n\t\t\t\t\t\t\t\tlike (select group_concat(selected separator \',\') selected\n\t\t\t\t\t\t\t\tfrom ReferenceModel.CONFIGURATION_X_VARIANT\n\t\t\t\t\t\t\t\twhere configuration_id = ") + DomainCodeUtilities.CURRENT_QACONFIG) + ")"));
      boolean _next = rs.next();
      boolean _not = (!_next);
      if (_not) {
        return rules;
      }
      ResultSet _executeQuery = s.executeQuery((((((("select B.FULL_CLASS_NAME, B.METHOD_NAME\n\t\t\t\t\t\t\tfrom ReferenceModel.TMPLT_X_CONF_X_FRAGM A, ReferenceModel.FRAGMENT B\n\t\t\t\t\t\t\twhere A.TEMPLATE = " + DomainCodeUtilities.CURRENT_TEMPLATE) + "\n\t\t\t\t\t\t\tand A.SECTION = ") + DomainCodeUtilities.CURRENT_SECTION) + "\n\t\t\t\t\t\t\tand A.CONFIGURATION_ID = ") + DomainCodeUtilities.CURRENT_QACONFIG) + "\n\t\t\t\t\t\t\tand A.FRAGMENT_ID = B.FRAGMENT_ID"));
      rs = _executeQuery;
      while (rs.next()) {
        {
          String _string = rs.getString(1);
          final Class<?> c = Class.forName(_string);
          System.err.println(("Clase " + c));
          final Object o = c.newInstance();
          String _string_1 = rs.getString(2);
          String _plus = ((("Ejecutar " + c) + ".") + _string_1);
          System.err.println(_plus);
        }
      }
      return rules;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String extendContribution(final String id, final String phase, final Object... data) {
    final List<Contribution> contributors = DomainCodeUtilities.getSelectedVariants(id);
    String rules = "";
    boolean _equals = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_BI);
    if (_equals) {
      for (final Contribution c : contributors) {
        String _rules = rules;
        String _contributeToBusinessInterface = c.contributeToBusinessInterface(data);
        String _plus = (_contributeToBusinessInterface + "\n\n");
        rules = (_rules + _plus);
      }
    }
    boolean _equals_1 = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_BIMPL);
    if (_equals_1) {
      for (final Contribution c_1 : contributors) {
        String _rules_1 = rules;
        String _contributeToBusinessImpl = c_1.contributeToBusinessImpl(data);
        String _plus_1 = (_contributeToBusinessImpl + "\n\n");
        rules = (_rules_1 + _plus_1);
      }
    }
    boolean _equals_2 = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPORT);
    if (_equals_2) {
      for (final Contribution c_2 : contributors) {
        String _rules_2 = rules;
        String _contributeToWebImport = c_2.contributeToWebImport(data);
        String _plus_2 = (_contributeToWebImport + "\n\n");
        rules = (_rules_2 + _plus_2);
      }
    }
    boolean _equals_3 = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_WEB_ATTRIBUTE);
    if (_equals_3) {
      for (final Contribution c_3 : contributors) {
        String _rules_3 = rules;
        String _contributeToWebAttribute = c_3.contributeToWebAttribute(data);
        String _plus_3 = (_contributeToWebAttribute + "\n\n");
        rules = (_rules_3 + _plus_3);
      }
    }
    boolean _equals_4 = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL);
    if (_equals_4) {
      for (final Contribution c_4 : contributors) {
        String _rules_4 = rules;
        String _contributeToWebImpl = c_4.contributeToWebImpl(data);
        String _plus_4 = (_contributeToWebImpl + "\n\n");
        rules = (_rules_4 + _plus_4);
      }
    }
    boolean _equals_5 = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_ATTRIBUTE);
    if (_equals_5) {
      for (final Contribution c_5 : contributors) {
        String _rules_5 = rules;
        String _contributeToBusinessAtribute = c_5.contributeToBusinessAtribute(data);
        String _plus_5 = (_contributeToBusinessAtribute + "\n\n");
        rules = (_rules_5 + _plus_5);
      }
    }
    boolean _equals_6 = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_BUSINESS_IMPORT);
    if (_equals_6) {
      for (final Contribution c_6 : contributors) {
        String _rules_6 = rules;
        String _contributeToBusinessImport = c_6.contributeToBusinessImport(data);
        String _plus_6 = (_contributeToBusinessImport + "\n\n");
        rules = (_rules_6 + _plus_6);
      }
    }
    boolean _equals_7 = phase.equals(DomainCodeUtilities.CONTRIBUTE_TO_GENERATION);
    if (_equals_7) {
      for (final Contribution c_7 : contributors) {
        c_7.generate(data);
      }
    }
    return rules;
  }
  
  public static boolean isQASelected(final String prefixId) {
    Set<String> _keySet = DomainCodeUtilities.selectedContributors.keySet();
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
      Set<String> _keySet = DomainCodeUtilities.selectedContributors.keySet();
      final Iterator<String> i = _keySet.iterator();
      while (i.hasNext()) {
        {
          final String c = i.next();
          boolean _startsWith = c.startsWith(variationPointPrefix);
          if (_startsWith) {
            Contribution _get = DomainCodeUtilities.selectedContributors.get(c);
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
  
  public static String getWrapperType(final Attribute attribute) {
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
    boolean _equals_4 = literal.equals("int");
    if (_equals_4) {
      return "Integer";
    }
    boolean _equals_5 = literal.equals("double");
    if (_equals_5) {
      return "Double";
    }
    return literal;
  }
  
  public static boolean isDetailOf(final BusinessEntity be, final BusinessEntity relBe) {
    EList<Association> _associations = relBe.getAssociations();
    for (final Association ass : _associations) {
      if ((ass instanceof Multiple)) {
        BusinessEntity _entity = ((Multiple)ass).getEntity();
        String _name = _entity.getName();
        String _name_1 = be.getName();
        boolean _equals = _name.equals(_name_1);
        if (_equals) {
          return true;
        }
      }
    }
    return false;
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
  
  public static boolean hasZeroAssociations(final BusinessEntity be) {
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
  
  public static String removeAttributeContracts(final String c) {
    String changes = "";
    String _replace = c.replace("int", "");
    changes = _replace;
    String _replace_1 = changes.replace("double", "");
    changes = _replace_1;
    String _replace_2 = changes.replace("char", "");
    changes = _replace_2;
    String _replace_3 = changes.replace("String", "");
    changes = _replace_3;
    String _replace_4 = changes.replace("Object", "");
    changes = _replace_4;
    String _replace_5 = changes.replace("Integer", "");
    changes = _replace_5;
    String _replace_6 = changes.replace("Double", "");
    changes = _replace_6;
    String _replace_7 = changes.replace("long", "");
    changes = _replace_7;
    String _replace_8 = changes.replace("Long", "");
    changes = _replace_8;
    String _replace_9 = changes.replace("byte", "");
    changes = _replace_9;
    String _replace_10 = changes.replace("Byte", "");
    changes = _replace_10;
    return changes;
  }
  
  public static String getMySqlEquivalent(final String dataType) {
    boolean _equals = dataType.equals("String");
    if (_equals) {
      return "VARCHAR(200)";
    }
    boolean _equals_1 = dataType.equals("int");
    if (_equals_1) {
      return "INT";
    }
    boolean _equals_2 = dataType.equals("Date");
    if (_equals_2) {
      return "DATE";
    }
    boolean _equals_3 = dataType.equals("double");
    if (_equals_3) {
      return "DOUBLE";
    }
    return "";
  }
  
  public static String isMySqlNull(final Attribute att) {
    boolean _isIsRequired = att.isIsRequired();
    if (_isIsRequired) {
      return "NOT NULL";
    } else {
      return "NULL";
    }
  }
  
  private static boolean isOneToMany(final BusinessEntity master, final BusinessEntity detail) {
    EList<Association> _associations = master.getAssociations();
    for (final Association a : _associations) {
      if ((a instanceof Multiple)) {
        BusinessEntity relBe = ((Multiple)a).getEntity();
        String _name = relBe.getName();
        String _name_1 = detail.getName();
        boolean _equals = _name.equals(_name_1);
        if (_equals) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void runScript(final String packageName) {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      IPath _location = _root.getLocation();
      String _string = _location.toString();
      String basePath = (_string + "/../workspace/co.edu.icesi.shift.generator");
      System.err.println(("workspace: " + basePath));
      File _file = new File((basePath + "/files/rootProject.sh"));
      FileWriter _fileWriter = new FileWriter(_file);
      BufferedWriter rootProjectWriter = new BufferedWriter(_fileWriter);
      rootProjectWriter.write("#!/bin/bash");
      rootProjectWriter.newLine();
      rootProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=1.1");
      rootProjectWriter.flush();
      rootProjectWriter.close();
      FileWriter _fileWriter_1 = new FileWriter((basePath + "/files/rootProjectInput.txt"));
      BufferedWriter rootProjectInputWriter = new BufferedWriter(_fileWriter_1);
      rootProjectInputWriter.write("co.shift");
      rootProjectInputWriter.newLine();
      rootProjectInputWriter.write("co.shift.root");
      rootProjectInputWriter.newLine();
      rootProjectInputWriter.newLine();
      rootProjectInputWriter.newLine();
      rootProjectInputWriter.newLine();
      rootProjectInputWriter.flush();
      rootProjectInputWriter.close();
      File _file_1 = new File((basePath + "/files/vaadinProject.sh"));
      FileWriter _fileWriter_2 = new FileWriter(_file_1);
      BufferedWriter vaadinProjectWriter = new BufferedWriter(_fileWriter_2);
      vaadinProjectWriter.write("#!/bin/bash");
      vaadinProjectWriter.newLine();
      vaadinProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=com.vaadin -DarchetypeArtifactId=vaadin-archetype-application -DarchetypeVersion=7.3.5");
      vaadinProjectWriter.flush();
      vaadinProjectWriter.close();
      FileWriter _fileWriter_3 = new FileWriter((basePath + "/files/vaadinProjectInput.txt"));
      BufferedWriter vaadinProjectInputWriter = new BufferedWriter(_fileWriter_3);
      vaadinProjectInputWriter.write("co.shift");
      vaadinProjectInputWriter.newLine();
      vaadinProjectInputWriter.write("co.shift.web");
      vaadinProjectInputWriter.newLine();
      vaadinProjectInputWriter.newLine();
      vaadinProjectInputWriter.newLine();
      vaadinProjectInputWriter.newLine();
      vaadinProjectInputWriter.flush();
      vaadinProjectInputWriter.close();
      File _file_2 = new File((basePath + "/files/ejbProject.sh"));
      FileWriter _fileWriter_4 = new FileWriter(_file_2);
      BufferedWriter ejbProjectWriter = new BufferedWriter(_fileWriter_4);
      ejbProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=ejb-javaee6 -DarchetypeVersion=1.5");
      ejbProjectWriter.newLine();
      ejbProjectWriter.flush();
      ejbProjectWriter.close();
      File _file_3 = new File((basePath + "/files/ejbProjectInput.txt"));
      FileWriter _fileWriter_5 = new FileWriter(_file_3);
      BufferedWriter ejbProjectInputWriter = new BufferedWriter(_fileWriter_5);
      ejbProjectInputWriter.write("co.shift");
      ejbProjectInputWriter.newLine();
      ejbProjectInputWriter.write("co.shift.ejb");
      ejbProjectInputWriter.newLine();
      ejbProjectInputWriter.newLine();
      ejbProjectInputWriter.newLine();
      ejbProjectInputWriter.newLine();
      ejbProjectInputWriter.flush();
      ejbProjectInputWriter.close();
      File _file_4 = new File((basePath + "/files/ejbCProject.sh"));
      FileWriter _fileWriter_6 = new FileWriter(_file_4);
      BufferedWriter ejbCProjectWriter = new BufferedWriter(_fileWriter_6);
      ejbCProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.1");
      ejbCProjectWriter.newLine();
      ejbCProjectWriter.flush();
      ejbCProjectWriter.close();
      File _file_5 = new File((basePath + "/files/ejbProjectCInput.txt"));
      FileWriter _fileWriter_7 = new FileWriter(_file_5);
      BufferedWriter ejbProjectCInputWriter = new BufferedWriter(_fileWriter_7);
      ejbProjectCInputWriter.write("co.shift");
      ejbProjectCInputWriter.newLine();
      ejbProjectCInputWriter.write("co.shift.ejb.api");
      ejbProjectCInputWriter.newLine();
      ejbProjectCInputWriter.newLine();
      ejbProjectCInputWriter.newLine();
      ejbProjectCInputWriter.newLine();
      ejbProjectCInputWriter.flush();
      ejbProjectCInputWriter.close();
      File _file_6 = new File((basePath + "/files/earProject.sh"));
      FileWriter _fileWriter_8 = new FileWriter(_file_6);
      BufferedWriter earProjectWriter = new BufferedWriter(_fileWriter_8);
      earProjectWriter.write("mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=ear-javaee6 -DarchetypeVersion=1.5");
      earProjectWriter.newLine();
      earProjectWriter.flush();
      earProjectWriter.close();
      File _file_7 = new File((basePath + "/files/earProjectInput.txt"));
      FileWriter _fileWriter_9 = new FileWriter(_file_7);
      BufferedWriter earProjectInputWriter = new BufferedWriter(_fileWriter_9);
      earProjectInputWriter.write("co.shift");
      earProjectInputWriter.newLine();
      earProjectInputWriter.write("co.shift.ear");
      earProjectInputWriter.newLine();
      earProjectInputWriter.newLine();
      earProjectInputWriter.newLine();
      earProjectInputWriter.newLine();
      earProjectInputWriter.flush();
      earProjectInputWriter.close();
      File _file_8 = new File((basePath + "/files/genScript.sh"));
      FileWriter _fileWriter_10 = new FileWriter(_file_8);
      BufferedWriter genScriptWriter = new BufferedWriter(_fileWriter_10);
      genScriptWriter.write(("cd " + DomainCodeUtilities.GENERATION_DIR));
      genScriptWriter.newLine();
      String _replace = basePath.replace(" ", "\\ ");
      basePath = _replace;
      genScriptWriter.write((((basePath + "/files/rootProject.sh < ") + basePath) + "/files/rootProjectInput.txt"));
      genScriptWriter.newLine();
      genScriptWriter.write((("cd " + DomainCodeUtilities.GENERATION_DIR) + "co.shift.root/"));
      genScriptWriter.newLine();
      genScriptWriter.write((((basePath + "/files/vaadinProject.sh < ") + basePath) + "/files/vaadinProjectInput.txt"));
      genScriptWriter.newLine();
      genScriptWriter.write((((basePath + "/files/ejbProject.sh < ") + basePath) + "/files/ejbProjectInput.txt"));
      genScriptWriter.newLine();
      genScriptWriter.write((((basePath + "/files/ejbCProject.sh < ") + basePath) + "/files/ejbProjectCInput.txt"));
      genScriptWriter.newLine();
      genScriptWriter.write((((basePath + "/files/earProject.sh < ") + basePath) + "/files/earProjectInput.txt"));
      genScriptWriter.newLine();
      genScriptWriter.write("killall Terminal");
      genScriptWriter.flush();
      genScriptWriter.close();
      String _replace_1 = basePath.replace("\\ ", " ");
      basePath = _replace_1;
      String scriptPath = (basePath + "/files/genScript.sh");
      List<String> list = new ArrayList<String>();
      list.add("open");
      list.add("-W");
      list.add("-a");
      list.add("Terminal");
      list.add(scriptPath);
      String[] data = ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList(), String.class));
      Runtime _runtime = Runtime.getRuntime();
      String[] _array = list.<String>toArray(data);
      Process p = _runtime.exec(_array);
      p.waitFor();
      DomainCodeUtilities.fixWebPom((DomainCodeUtilities.GENERATION_DIR + "co.shift.root/co.shift.web/pom.xml"));
      DomainCodeUtilities.fixEARPom((DomainCodeUtilities.GENERATION_DIR + "co.shift.root/co.shift.ear/pom.xml"));
      DomainCodeUtilities.fixEJBPom((DomainCodeUtilities.GENERATION_DIR + "co.shift.root/co.shift.ejb/pom.xml"));
      DomainCodeUtilities.fixAPIPom((DomainCodeUtilities.GENERATION_DIR + "co.shift.root/co.shift.ejb.api/pom.xml"));
      DomainCodeUtilities.copySourceCode(packageName);
      DomainCodeUtilities.mergeDBScripts(packageName);
      System.err.println("Projects Generation Completed");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void fixWebPom(final String filePath) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      FileInputStream _fileInputStream = new FileInputStream(filePath);
      Document doc = db.parse(_fileInputStream);
      Element docEle = doc.getDocumentElement();
      NodeList nl = docEle.getElementsByTagName("dependencies");
      Element dep = doc.createElement("dependency");
      Element depGI = doc.createElement("groupId");
      Text _createTextNode = doc.createTextNode("co.shift");
      depGI.appendChild(_createTextNode);
      Element depAI = doc.createElement("artifactId");
      Text _createTextNode_1 = doc.createTextNode("co.shift.ejb");
      depAI.appendChild(_createTextNode_1);
      Element depV = doc.createElement("version");
      Text _createTextNode_2 = doc.createTextNode("1.0-SNAPSHOT");
      depV.appendChild(_createTextNode_2);
      Element depT = doc.createElement("type");
      Text _createTextNode_3 = doc.createTextNode("ejb");
      depT.appendChild(_createTextNode_3);
      Element depS = doc.createElement("scope");
      Text _createTextNode_4 = doc.createTextNode("provided");
      depS.appendChild(_createTextNode_4);
      dep.appendChild(depGI);
      dep.appendChild(depAI);
      dep.appendChild(depV);
      dep.appendChild(depT);
      dep.appendChild(depS);
      Node _item = nl.item(0);
      _item.appendChild(dep);
      Element depGF = doc.createElement("dependency");
      Element depGFGI = doc.createElement("groupId");
      Text _createTextNode_5 = doc.createTextNode("javax");
      depGFGI.appendChild(_createTextNode_5);
      Element depGFAI = doc.createElement("artifactId");
      Text _createTextNode_6 = doc.createTextNode("javaee-api");
      depGFAI.appendChild(_createTextNode_6);
      Element depGFV = doc.createElement("version");
      Text _createTextNode_7 = doc.createTextNode("6.0");
      depGFV.appendChild(_createTextNode_7);
      Element depGFS = doc.createElement("scope");
      Text _createTextNode_8 = doc.createTextNode("provided");
      depGFS.appendChild(_createTextNode_8);
      depGF.appendChild(depGFGI);
      depGF.appendChild(depGFAI);
      depGF.appendChild(depGFV);
      depGF.appendChild(depGFS);
      Node _item_1 = nl.item(0);
      _item_1.appendChild(depGF);
      Element depAPI = doc.createElement("dependency");
      Element depAGI = doc.createElement("groupId");
      Text _createTextNode_9 = doc.createTextNode("co.shift");
      depAGI.appendChild(_createTextNode_9);
      Element depAAI = doc.createElement("artifactId");
      Text _createTextNode_10 = doc.createTextNode("co.shift.ejb.api");
      depAAI.appendChild(_createTextNode_10);
      Element depAV = doc.createElement("version");
      Text _createTextNode_11 = doc.createTextNode("${pom.version}");
      depAV.appendChild(_createTextNode_11);
      depAPI.appendChild(depAGI);
      depAPI.appendChild(depAAI);
      depAPI.appendChild(depAV);
      Node _item_2 = nl.item(0);
      _item_2.appendChild(depAPI);
      NodeList source = docEle.getElementsByTagName("source");
      Node _item_3 = source.item(0);
      _item_3.setTextContent("1.7");
      NodeList target = docEle.getElementsByTagName("target");
      Node _item_4 = target.item(0);
      _item_4.setTextContent("1.7");
      DomainCodeUtilities.writeXML(doc, filePath);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void fixEJBPom(final String filePath) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      FileInputStream _fileInputStream = new FileInputStream(filePath);
      Document doc = db.parse(_fileInputStream);
      Element docEle = doc.getDocumentElement();
      NodeList nl = docEle.getElementsByTagName("dependencies");
      Element depEL = doc.createElement("dependency");
      Element depGI = doc.createElement("groupId");
      Text _createTextNode = doc.createTextNode("org.eclipse.persistence");
      depGI.appendChild(_createTextNode);
      Element depAI = doc.createElement("artifactId");
      Text _createTextNode_1 = doc.createTextNode("eclipselink");
      depAI.appendChild(_createTextNode_1);
      Element depV = doc.createElement("version");
      Text _createTextNode_2 = doc.createTextNode("2.4.2");
      depV.appendChild(_createTextNode_2);
      depEL.appendChild(depGI);
      depEL.appendChild(depAI);
      depEL.appendChild(depV);
      Node _item = nl.item(0);
      _item.appendChild(depEL);
      Element depAPI = doc.createElement("dependency");
      Element depAPIGI = doc.createElement("groupId");
      Text _createTextNode_3 = doc.createTextNode("co.shift");
      depAPIGI.appendChild(_createTextNode_3);
      Element depAPIAI = doc.createElement("artifactId");
      Text _createTextNode_4 = doc.createTextNode("co.shift.ejb.api");
      depAPIAI.appendChild(_createTextNode_4);
      Element depAPIV = doc.createElement("version");
      Text _createTextNode_5 = doc.createTextNode("1.0-SNAPSHOT");
      depAPIV.appendChild(_createTextNode_5);
      depAPI.appendChild(depAPIGI);
      depAPI.appendChild(depAPIAI);
      depAPI.appendChild(depAPIV);
      Node _item_1 = nl.item(0);
      _item_1.appendChild(depAPI);
      Element depSec = doc.createElement("dependency");
      Element depSecGI = doc.createElement("groupId");
      Text _createTextNode_6 = doc.createTextNode("commons-codec");
      depSecGI.appendChild(_createTextNode_6);
      Element depSecAI = doc.createElement("artifactId");
      Text _createTextNode_7 = doc.createTextNode("commons-codec");
      depSecAI.appendChild(_createTextNode_7);
      Element depSecV = doc.createElement("version");
      Text _createTextNode_8 = doc.createTextNode("1.9");
      depSecV.appendChild(_createTextNode_8);
      depSec.appendChild(depSecGI);
      depSec.appendChild(depSecAI);
      depSec.appendChild(depSecV);
      Node _item_2 = nl.item(0);
      _item_2.appendChild(depSec);
      NodeList source = docEle.getElementsByTagName("source");
      Node _item_3 = source.item(0);
      _item_3.setTextContent("1.7");
      NodeList target = docEle.getElementsByTagName("target");
      Node _item_4 = target.item(0);
      _item_4.setTextContent("1.7");
      DomainCodeUtilities.writeXML(doc, filePath);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void fixAPIPom(final String filePath) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      FileInputStream _fileInputStream = new FileInputStream(filePath);
      Document doc = db.parse(_fileInputStream);
      Element docEle = doc.getDocumentElement();
      NodeList nl = docEle.getElementsByTagName("dependencies");
      Element jar = doc.createElement("packaging");
      Text _createTextNode = doc.createTextNode("jar");
      jar.appendChild(_createTextNode);
      docEle.appendChild(jar);
      Element depGF = doc.createElement("dependency");
      Element depGFGI = doc.createElement("groupId");
      Text _createTextNode_1 = doc.createTextNode("javax");
      depGFGI.appendChild(_createTextNode_1);
      Element depGFAI = doc.createElement("artifactId");
      Text _createTextNode_2 = doc.createTextNode("javaee-api");
      depGFAI.appendChild(_createTextNode_2);
      Element depGFV = doc.createElement("version");
      Text _createTextNode_3 = doc.createTextNode("6.0");
      depGFV.appendChild(_createTextNode_3);
      Element depGFS = doc.createElement("scope");
      Text _createTextNode_4 = doc.createTextNode("provided");
      depGFS.appendChild(_createTextNode_4);
      depGF.appendChild(depGFGI);
      depGF.appendChild(depGFAI);
      depGF.appendChild(depGFV);
      depGF.appendChild(depGFS);
      Node _item = nl.item(0);
      _item.appendChild(depGF);
      DomainCodeUtilities.writeXML(doc, filePath);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void fixEARPom(final String filePath) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      FileInputStream _fileInputStream = new FileInputStream(filePath);
      Document doc = db.parse(_fileInputStream);
      Element docEle = doc.getDocumentElement();
      Element dependencies = doc.createElement("dependencies");
      Element dep = doc.createElement("dependency");
      Element depGI = doc.createElement("groupId");
      Text _createTextNode = doc.createTextNode("co.shift");
      depGI.appendChild(_createTextNode);
      Element depAI = doc.createElement("artifactId");
      Text _createTextNode_1 = doc.createTextNode("co.shift.ejb");
      depAI.appendChild(_createTextNode_1);
      Element depV = doc.createElement("version");
      Text _createTextNode_2 = doc.createTextNode("1.0-SNAPSHOT");
      depV.appendChild(_createTextNode_2);
      Element depT = doc.createElement("type");
      Text _createTextNode_3 = doc.createTextNode("ejb");
      depT.appendChild(_createTextNode_3);
      dep.appendChild(depGI);
      dep.appendChild(depAI);
      dep.appendChild(depV);
      dep.appendChild(depT);
      dependencies.appendChild(dep);
      docEle.appendChild(dependencies);
      Element dep2 = doc.createElement("dependency");
      Element dep2GI = doc.createElement("groupId");
      Text _createTextNode_4 = doc.createTextNode("co.shift");
      dep2GI.appendChild(_createTextNode_4);
      Element dep2AI = doc.createElement("artifactId");
      Text _createTextNode_5 = doc.createTextNode("co.shift.ejb.api");
      dep2AI.appendChild(_createTextNode_5);
      Element dep2V = doc.createElement("version");
      Text _createTextNode_6 = doc.createTextNode("1.0-SNAPSHOT");
      dep2V.appendChild(_createTextNode_6);
      Element dep2T = doc.createElement("type");
      Text _createTextNode_7 = doc.createTextNode("jar");
      dep2T.appendChild(_createTextNode_7);
      dep2.appendChild(dep2GI);
      dep2.appendChild(dep2AI);
      dep2.appendChild(dep2V);
      dep2.appendChild(dep2T);
      dependencies.appendChild(dep2);
      docEle.appendChild(dependencies);
      NodeList nl = docEle.getElementsByTagName("configuration");
      Node earPlugins = nl.item(1);
      Element modules = doc.createElement("modules");
      Element ejbModule = doc.createElement("ejbModule");
      Element ejbGI = doc.createElement("groupId");
      Text _createTextNode_8 = doc.createTextNode("co.shift");
      ejbGI.appendChild(_createTextNode_8);
      Element ejbAI = doc.createElement("artifactId");
      Text _createTextNode_9 = doc.createTextNode("co.shift.ejb");
      ejbAI.appendChild(_createTextNode_9);
      Element ejbBFN = doc.createElement("bundleFileName");
      Text _createTextNode_10 = doc.createTextNode("co.shift.ejb");
      ejbBFN.appendChild(_createTextNode_10);
      ejbModule.appendChild(ejbGI);
      ejbModule.appendChild(ejbAI);
      ejbModule.appendChild(ejbBFN);
      modules.appendChild(ejbModule);
      Element jarModule = doc.createElement("jarModule");
      Element jarGI = doc.createElement("groupId");
      Text _createTextNode_11 = doc.createTextNode("co.shift");
      jarGI.appendChild(_createTextNode_11);
      Element jarAI = doc.createElement("artifactId");
      Text _createTextNode_12 = doc.createTextNode("co.shift.ejb.api");
      jarAI.appendChild(_createTextNode_12);
      jarModule.appendChild(jarGI);
      jarModule.appendChild(jarAI);
      modules.appendChild(jarModule);
      earPlugins.appendChild(modules);
      DomainCodeUtilities.writeXML(doc, filePath);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void writeXML(final Document document, final String filePath) {
    try {
      Source xmlSource = new DOMSource(document);
      FileOutputStream _fileOutputStream = new FileOutputStream(filePath);
      Result result = new StreamResult(_fileOutputStream);
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty("indent", "yes");
      transformer.transform(xmlSource, result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void copySourceCode(final String packageName) {
    abstract class __DomainCodeUtilities_1 extends SimpleFileVisitor<Path> {
      abstract FileVisitResult copy(final Path fileOrDir) throws IOException;
    }
    
    abstract class __DomainCodeUtilities_2 extends SimpleFileVisitor<Path> {
      abstract FileVisitResult copy(final Path fileOrDir) throws IOException;
    }
    
    abstract class __DomainCodeUtilities_3 extends SimpleFileVisitor<Path> {
      abstract FileVisitResult copy(final Path fileOrDir) throws IOException;
    }
    
    try {
      String basePath = DomainCodeUtilities.SRC_DIR;
      File folder = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb/src/main/java"));
      DomainCodeUtilities.deleteFolder(folder);
      final Path srcDir = Paths.get(basePath);
      final Path dstDir = Paths.get((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb/src/main/java"));
      __DomainCodeUtilities_1 ___DomainCodeUtilities_1 = new __DomainCodeUtilities_1() {
        @Override
        public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
          return this.copy(file);
        }
        
        @Override
        public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
          return this.copy(dir);
        }
        
        FileVisitResult copy(final Path fileOrDir) throws IOException {
          Path _relativize = srcDir.relativize(fileOrDir);
          Path _resolve = dstDir.resolve(_relativize);
          Files.copy(fileOrDir, _resolve);
          return FileVisitResult.CONTINUE;
        }
      };
      Files.walkFileTree(srcDir, ___DomainCodeUtilities_1);
      File targetFile = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb/src/main/java"));
      DomainCodeUtilities.deleteFolder(targetFile, "web", true);
      DomainCodeUtilities.deleteFolder(targetFile, "util", true);
      DomainCodeUtilities.deleteFolder(targetFile, "/to", true);
      File interfaces = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb/src/main/java/"));
      DomainCodeUtilities.deleteInterfaces(interfaces);
      File persistenceOPath = new File((((basePath + "/co/shift/") + packageName) + "/ejb/persistence/persistence.xml"));
      File persistencePath = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb/src/main/resources/META-INF/persistence.xml"));
      DomainCodeUtilities.copyFileUsingFileStreams(persistenceOPath, persistencePath);
      DomainCodeUtilities.deleteFolder(targetFile, "/ejb", true);
      File folder1 = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.web/src/main/java"));
      DomainCodeUtilities.deleteFolder(folder1);
      final Path dstDir1 = Paths.get((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.web/src/main/java"));
      __DomainCodeUtilities_2 ___DomainCodeUtilities_2 = new __DomainCodeUtilities_2() {
        @Override
        public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
          return this.copy(file);
        }
        
        @Override
        public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
          return this.copy(dir);
        }
        
        FileVisitResult copy(final Path fileOrDir) throws IOException {
          Path _relativize = srcDir.relativize(fileOrDir);
          Path _resolve = dstDir1.resolve(_relativize);
          Files.copy(fileOrDir, _resolve);
          return FileVisitResult.CONTINUE;
        }
      };
      Files.walkFileTree(srcDir, ___DomainCodeUtilities_2);
      File targetFile1 = new File(((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.web/src/main/java/co/shift/") + packageName));
      DomainCodeUtilities.deleteFolder(targetFile1, "/web:/util", false);
      File folder2 = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb.api/src/main/java"));
      DomainCodeUtilities.deleteFolder(folder2);
      final Path srcDir2 = Paths.get(basePath);
      final Path dstDir2 = Paths.get((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb.api/src/main/java"));
      __DomainCodeUtilities_3 ___DomainCodeUtilities_3 = new __DomainCodeUtilities_3() {
        @Override
        public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
          return this.copy(file);
        }
        
        @Override
        public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) throws IOException {
          return this.copy(dir);
        }
        
        FileVisitResult copy(final Path fileOrDir) throws IOException {
          Path _relativize = srcDir.relativize(fileOrDir);
          Path _resolve = dstDir2.resolve(_relativize);
          Files.copy(fileOrDir, _resolve);
          return FileVisitResult.CONTINUE;
        }
      };
      Files.walkFileTree(srcDir2, ___DomainCodeUtilities_3);
      File targetFile2 = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb.api/src/main/java"));
      DomainCodeUtilities.deleteFolder(targetFile2, "web", true);
      DomainCodeUtilities.deleteFolder(targetFile2, "util", true);
      DomainCodeUtilities.deleteFolder(targetFile2, "entity", true);
      DomainCodeUtilities.deleteFolder(targetFile2, "/ejb", true);
      File classes = new File((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.ejb.api/src/main/java"));
      DomainCodeUtilities.deleteClases(classes);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void copyFileUsingFileStreams(final File source, final File dest) throws IOException {
    InputStream input = null;
    OutputStream output = null;
    try {
      FileInputStream _fileInputStream = new FileInputStream(source);
      input = _fileInputStream;
      FileOutputStream _fileOutputStream = new FileOutputStream(dest);
      output = _fileOutputStream;
      byte[] buf = new byte[1024];
      int bytesRead = 0;
      while (((bytesRead = input.read(buf)) > 0)) {
        output.write(buf, 0, bytesRead);
      }
    } finally {
      input.close();
      output.close();
    }
  }
  
  private static void deleteFolder(final File folder, final String prefix, final boolean containsPrefix) {
    File[] files = folder.listFiles();
    String[] prefixs = prefix.split(":");
    if (containsPrefix) {
      boolean _notEquals = (!Objects.equal(files, null));
      if (_notEquals) {
        for (final File f : files) {
          boolean _isDirectory = f.isDirectory();
          if (_isDirectory) {
            String _absolutePath = f.getAbsolutePath();
            boolean _contains = _absolutePath.contains(prefix);
            if (_contains) {
              DomainCodeUtilities.deleteFolder(f);
            } else {
              DomainCodeUtilities.deleteFolder(f, prefix, containsPrefix);
            }
          }
        }
      }
    } else {
      boolean _notEquals_1 = (!Objects.equal(files, null));
      if (_notEquals_1) {
        for (final File f_1 : files) {
          boolean _isDirectory_1 = f_1.isDirectory();
          if (_isDirectory_1) {
            boolean _and = false;
            String _absolutePath_1 = f_1.getAbsolutePath();
            CharSequence _get = prefixs[0];
            boolean _contains_1 = _absolutePath_1.contains(_get);
            boolean _not = (!_contains_1);
            if (!_not) {
              _and = false;
            } else {
              String _absolutePath_2 = f_1.getAbsolutePath();
              CharSequence _get_1 = prefixs[1];
              boolean _contains_2 = _absolutePath_2.contains(_get_1);
              boolean _not_1 = (!_contains_2);
              _and = _not_1;
            }
            if (_and) {
              DomainCodeUtilities.deleteFolder(f_1);
            } else {
              DomainCodeUtilities.deleteFolder(f_1, prefix, containsPrefix);
            }
          }
        }
      }
    }
  }
  
  private static void deleteFolder(final File folder) {
    File[] files = folder.listFiles();
    boolean _notEquals = (!Objects.equal(files, null));
    if (_notEquals) {
      for (final File f : files) {
        boolean _isDirectory = f.isDirectory();
        if (_isDirectory) {
          DomainCodeUtilities.deleteFolder(f);
        } else {
          f.delete();
        }
      }
    }
    folder.delete();
  }
  
  private static void deleteInterfaces(final File folder) {
    File[] files = folder.listFiles();
    boolean _notEquals = (!Objects.equal(files, null));
    if (_notEquals) {
      for (final File f : files) {
        boolean _and = false;
        boolean _isFile = f.isFile();
        if (!_isFile) {
          _and = false;
        } else {
          String _absolutePath = f.getAbsolutePath();
          boolean _contains = _absolutePath.contains("/I");
          _and = _contains;
        }
        if (_and) {
          f.delete();
        } else {
          DomainCodeUtilities.deleteInterfaces(f);
        }
      }
    }
  }
  
  private static void deleteClases(final File folder) {
    File[] files = folder.listFiles();
    boolean _notEquals = (!Objects.equal(files, null));
    if (_notEquals) {
      for (final File f : files) {
        boolean _and = false;
        boolean _and_1 = false;
        boolean _isFile = f.isFile();
        if (!_isFile) {
          _and_1 = false;
        } else {
          String _absolutePath = f.getAbsolutePath();
          boolean _contains = _absolutePath.contains("/to");
          boolean _not = (!_contains);
          _and_1 = _not;
        }
        if (!_and_1) {
          _and = false;
        } else {
          String _absolutePath_1 = f.getAbsolutePath();
          boolean _contains_1 = _absolutePath_1.contains("/I");
          boolean _not_1 = (!_contains_1);
          _and = _not_1;
        }
        if (_and) {
          f.delete();
        } else {
          DomainCodeUtilities.deleteClases(f);
        }
      }
    }
  }
  
  public static void mergeDBScripts(final String packageName) {
    try {
      String genPath = (((DomainCodeUtilities.GENERATION_DIR + "/co.shift.root/co.shift.web/src/main/java/co/shift/") + packageName) + "/web/database");
      File mergedScripts = new File((genPath + "/DBScript.sql"));
      FileWriter _fileWriter = new FileWriter(mergedScripts);
      BufferedWriter writter = new BufferedWriter(_fileWriter);
      File fileOne = new File((genPath + "/ScriptOne.sql"));
      File fileTwo = new File((genPath + "/ScriptTwo.sql"));
      File fileThree = new File((genPath + "/ScriptThree.sql"));
      File fileFour = new File((genPath + "/InsertsScript.sql"));
      DomainCodeUtilities.copyFile(genPath, fileOne, writter);
      DomainCodeUtilities.copyFile(genPath, fileTwo, writter);
      DomainCodeUtilities.copyFile(genPath, fileThree, writter);
      DomainCodeUtilities.copyFile(genPath, fileFour, writter);
      writter.flush();
      writter.close();
      fileOne.delete();
      fileTwo.delete();
      fileThree.delete();
      fileFour.delete();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static void copyFile(final String basePath, final File file, final BufferedWriter writter) {
    try {
      boolean _exists = file.exists();
      if (_exists) {
        FileReader _fileReader = new FileReader(file);
        BufferedReader readOne = new BufferedReader(_fileReader);
        String line = readOne.readLine();
        while ((!Objects.equal(line, null))) {
          {
            writter.write(line);
            writter.newLine();
            String _readLine = readOne.readLine();
            line = _readLine;
          }
        }
        readOne.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
