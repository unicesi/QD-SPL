package co.shift.generators.domain;

import co.shift.generators.domain.DomainCodeUtilities;
import co.shift.generators.domain.DomainParams;
import co.shift.qualiyatributes.ImplMapping;
import domainmetamodel.Association;
import domainmetamodel.Business;
import domainmetamodel.BusinessEntity;
import java.util.ArrayList;
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
        }
      }
    }
    DomainCodeUtilities.CURRENT_TEMPLATE = DomainParams.TPL_ROOT;
    DomainCodeUtilities.CURRENT_SECTION = DomainParams.SECTION_GENERATE;
    DomainCodeUtilities.contribute(DomainParams.CONF_AUTHENTIC_LOCKOUT, 1, fsa, appName, authEntity);
    DomainCodeUtilities.contribute(DomainParams.CONF_AUTHORIZATION, 1, fsa, appName, authEntity);
    DomainCodeUtilities.end();
  }
}
