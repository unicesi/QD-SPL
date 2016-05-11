package co.shift.generators.domain;

import co.shift.generators.domain.DomainCodeUtilities;
import co.shift.qualiyatributes.ImplMapping;
import co.shift.templates.database.basic.InsertsScriptTemplate;
import co.shift.templates.database.basic.MERScriptTemplate;
import co.shift.templates.ejb.basic.BoundaryImplTemplate;
import co.shift.templates.ejb.basic.BoundaryInterfaceTemplate;
import co.shift.templates.ejb.basic.DAOImplTemplate;
import co.shift.templates.ejb.basic.DAOInterfaceTemplate;
import co.shift.templates.ejb.basic.DTOTemplate;
import co.shift.templates.ejb.basic.JPATemplate;
import co.shift.templates.web.basic.AbstractControllerTemplate;
import co.shift.templates.web.basic.BeanLocatorTemplate;
import co.shift.templates.web.basic.ContentPanelTemplate;
import co.shift.templates.web.basic.FormTemplate;
import co.shift.templates.web.basic.GlobalJNDITemplate;
import co.shift.templates.web.basic.MenuPaneTemplate;
import co.shift.templates.web.basic.PersistenceTemplate;
import co.shift.templates.web.basic.ProcessContributorTemplate;
import co.shift.templates.web.basic.RegistryTemplate;
import co.shift.templates.web.basic.UIContributorTemplate;
import co.shift.templates.web.basic.UIControllerTemplate;
import co.shift.templates.web.basic.UITemplate;
import co.shift.templates.web.basic.WebControllerTemplate;
import co.shift.templates.web.contributed.authenticity.LoginControllerTemplate;
import co.shift.templates.web.contributed.authenticity.LoginFormTemplate;
import domainmetamodel.Association;
import domainmetamodel.Business;
import domainmetamodel.BusinessEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class DomainCodeGenerator implements IGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess fsa) {
    ImplMapping.performMapping();
    BusinessEntity authEntity = null;
    DomainCodeUtilities.init();
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
          List<Association> _businessAssociations = DomainCodeUtilities.getBusinessAssociations(b);
          associations = _businessAssociations;
        }
        if ((k instanceof BusinessEntity)) {
          final BusinessEntity be = ((BusinessEntity) k);
          boolean _isIsAuthenticable = be.isIsAuthenticable();
          if (_isIsAuthenticable) {
            authEntity = be;
          } else {
            DomainCodeUtilities.addBusinessEntity(be);
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
          boolean _or = false;
          boolean _and = false;
          List<Association> _detailMultipleAssociations = DomainCodeUtilities.getDetailMultipleAssociations(be, associations);
          int _size = _detailMultipleAssociations.size();
          boolean _greaterThan = (_size > 0);
          if (!_greaterThan) {
            _and = false;
          } else {
            boolean _hasZeroAssociations = DomainCodeUtilities.hasZeroAssociations(be);
            boolean _not = (!_hasZeroAssociations);
            _and = _not;
          }
          if (_and) {
            _or = true;
          } else {
            List<Association> _detailSimpleAssociations = DomainCodeUtilities.getDetailSimpleAssociations(be, associations);
            int _size_1 = _detailSimpleAssociations.size();
            boolean _greaterThan_1 = (_size_1 > 0);
            _or = _greaterThan_1;
          }
          if (_or) {
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
          boolean _isMaster = DomainCodeUtilities.isMaster(be);
          if (_isMaster) {
            String _lowerCase_11 = appName.toLowerCase();
            String _plus_34 = ("/co/shift/" + _lowerCase_11);
            String _plus_35 = (_plus_34 + "/web/ext/");
            String _name_2 = be.getName();
            String _lowerCase_12 = _name_2.toLowerCase();
            String _plus_36 = (_plus_35 + _lowerCase_12);
            String _plus_37 = (_plus_36 + "/");
            String _plus_38 = (_plus_37 + name);
            String _plus_39 = (_plus_38 + "Form.java");
            CharSequence _generate_6 = FormTemplate.generate(appName, be);
            fsa.generateFile(_plus_39, _generate_6);
          }
          String _lowerCase_13 = appName.toLowerCase();
          String _plus_40 = ("/co/shift/" + _lowerCase_13);
          String _plus_41 = (_plus_40 + "/web/ext/");
          String _name_3 = be.getName();
          String _lowerCase_14 = _name_3.toLowerCase();
          String _plus_42 = (_plus_41 + _lowerCase_14);
          String _plus_43 = (_plus_42 + "/");
          String _plus_44 = (_plus_43 + name);
          String _plus_45 = (_plus_44 + "Controller.java");
          CharSequence _generate_7 = WebControllerTemplate.generate(appName, be, associations, fsa);
          fsa.generateFile(_plus_45, _generate_7);
        }
      }
    }
    DomainCodeUtilities.extendContribution("root", "general", fsa, appName, authEntity);
    DomainCodeUtilities.extendContribution(DomainCodeUtilities.VP_CONFIDENTIALITY, DomainCodeUtilities.CONTRIBUTE_TO_GENERATION, fsa, appName);
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
    HashSet<BusinessEntity> _businessEntities = DomainCodeUtilities.getBusinessEntities();
    CharSequence _generate_5 = UIControllerTemplate.generate(appName, authEntity, _businessEntities);
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
    String _lowerCase_8 = appName.toLowerCase();
    String _plus_18 = ("/co/shift/" + _lowerCase_8);
    String _plus_19 = (_plus_18 + "/util/beanlocator/BeanLocator.java");
    CharSequence _generate_8 = BeanLocatorTemplate.generate(appName);
    fsa.generateFile(_plus_19, _generate_8);
    String _lowerCase_9 = appName.toLowerCase();
    String _plus_20 = ("/co/shift/" + _lowerCase_9);
    String _plus_21 = (_plus_20 + "/util/beanlocator/GlobalJNDIName.java");
    CharSequence _generate_9 = GlobalJNDITemplate.generate(appName);
    fsa.generateFile(_plus_21, _generate_9);
    String _lowerCase_10 = appName.toLowerCase();
    String _plus_22 = ("/co/shift/" + _lowerCase_10);
    String _plus_23 = (_plus_22 + "/web/ext/authenticator/LoginForm.java");
    CharSequence _generate_10 = LoginFormTemplate.generate(appName);
    fsa.generateFile(_plus_23, _generate_10);
    String _lowerCase_11 = appName.toLowerCase();
    String _plus_24 = ("/co/shift/" + _lowerCase_11);
    String _plus_25 = (_plus_24 + "/web/ext/authenticator/LoginController.java");
    CharSequence _generate_11 = LoginControllerTemplate.generate(appName, authEntity);
    fsa.generateFile(_plus_25, _generate_11);
    String _lowerCase_12 = appName.toLowerCase();
    String _plus_26 = ("/co/shift/" + _lowerCase_12);
    String _plus_27 = (_plus_26 + "/ejb/persistence/persistence.xml");
    CharSequence _generate_12 = PersistenceTemplate.generate(appName);
    fsa.generateFile(_plus_27, _generate_12);
    String _lowerCase_13 = appName.toLowerCase();
    String _plus_28 = ("/co/shift/" + _lowerCase_13);
    String _plus_29 = (_plus_28 + "/web/database/ScriptOne.sql");
    CharSequence _generate_13 = MERScriptTemplate.generate(appName, authEntity, associations);
    fsa.generateFile(_plus_29, _generate_13);
    String _lowerCase_14 = appName.toLowerCase();
    String _plus_30 = ("/co/shift/" + _lowerCase_14);
    String _plus_31 = (_plus_30 + "/web/database/InsertsScript.sql");
    CharSequence _generate_14 = InsertsScriptTemplate.generate(appName, authEntity);
    fsa.generateFile(_plus_31, _generate_14);
    DomainCodeUtilities.runScript(appName);
    DomainCodeUtilities.end();
  }
}
