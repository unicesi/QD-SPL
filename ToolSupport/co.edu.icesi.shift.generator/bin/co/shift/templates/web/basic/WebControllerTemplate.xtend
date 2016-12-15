package co.shift.templates.web.basic

import co.shift.generators.domain.DomainCodeUtilities
import domainmetamodel.AddElement
import domainmetamodel.Association
import domainmetamodel.Attribute
import domainmetamodel.BusinessEntity
import domainmetamodel.ContractElements
import domainmetamodel.Create
import domainmetamodel.Delete
import domainmetamodel.DeleteElement
import domainmetamodel.ListAll
import domainmetamodel.Multiple
import domainmetamodel.Simple
import domainmetamodel.Update
import java.util.ArrayList
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
import co.shift.generators.domain.DomainParams

class WebControllerTemplate {
	
	private static String className = new Object(){}.class.enclosingClass.simpleName
	def static generate(String packageName, BusinessEntity be, List<Association> associations, IFileSystemAccess fsa) '''
		««« Establece la plantilla actual para contribución.
		«DomainCodeUtilities.beginTemplate(className)»
		package co.shift.«packageName.toLowerCase()».web.ext.«be.name.toLowerCase»;
		
		«DomainCodeUtilities.beginSection(DomainParams.SECT_IMPORTS)»
		import java.math.BigDecimal;
		import java.util.Date;
		import java.util.List;
		import java.util.ArrayList;
		
		import com.vaadin.event.ItemClickEvent;
		import com.vaadin.ui.ComboBox;
		import com.vaadin.ui.Component;
		import com.vaadin.ui.MenuBar.Command;
		import com.vaadin.ui.MenuBar.MenuItem;
		import com.vaadin.ui.TabSheet;
		import com.vaadin.ui.TextField;
		import com.vaadin.ui.PopupDateField;
		
««« Jcifuentes: Comentado
«««		«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPORT, packageName)»
		«DomainCodeUtilities.contribute2Template(1, packageName)»
		«FOR ass : be.associations»
		«IF ass instanceof Simple»
		«var relBe = ass.relatedEntity»		
		import co.shift.«packageName.toLowerCase()».web.ext.«relBe.name.toLowerCase».«relBe.name.toFirstUpper»Controller;
		import co.shift.«packageName.toLowerCase()».web.ext.«relBe.name.toLowerCase».«relBe.name.toFirstUpper»«ass.name.toFirstUpper»Form;
		import co.shift.«packageName.toLowerCase()».to.«relBe.name.toFirstUpper»TO;
		«ELSE»
		«var relBe = (ass as Multiple).entity»
		import co.shift.«packageName.toLowerCase()».web.ext.«relBe.name.toLowerCase».«relBe.name.toFirstUpper»Controller;
		import co.shift.«packageName.toLowerCase()».to.«relBe.name.toFirstUpper»TO;
		«ENDIF»
		«ENDFOR»
		«FOR ass : DomainCodeUtilities.getDetailSimpleAssociations(be, associations)»
		«val container = ass.eContainer as BusinessEntity»
		import co.shift.«packageName.toLowerCase()».web.ext.«container.name.toLowerCase».«container.name.toFirstUpper»Controller;
		«ENDFOR»
		«FOR ass : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
		«val container = ass.eContainer as BusinessEntity»
		import co.shift.«packageName.toLowerCase()».web.ext.«container.name.toLowerCase».«container.name.toFirstUpper»Controller;
		«ENDFOR»
		«FOR con : DomainCodeUtilities.getContract(be, AddElement)»
		«var contract = ""»
		«var conI = con as ContractElements»
		«var relBe = conI.association.entity»
		«var ddf = (contract += conI.name)»
		«IF !DomainCodeUtilities.hasZeroAssociations(relBe)»
		import co.shift.«packageName.toLowerCase()».web.ext.«relBe.name.toLowerCase».PopUp«be.name.toFirstUpper»«relBe.name.toFirstUpper»Form;
		«ELSE»
		import co.shift.«packageName.toLowerCase()».web.ext.«relBe.name.toLowerCase».PopUp«relBe.name.toFirstUpper»Form;
		«ENDIF»
		«ENDFOR»
		import co.shift.«packageName.toLowerCase()».web.AbstractController;
		import co.shift.«packageName.toLowerCase()».web.«packageName.toUpperCase»UI;
		import co.shift.«packageName.toLowerCase()».web.Registry;
		import co.shift.«packageName.toLowerCase()».web.UIContributor;
		import co.shift.«packageName.toLowerCase()».web.ProcessContributor;
		import co.shift.«packageName.toLowerCase()».web.client.ContentPanel;
		import co.shift.«packageName.toLowerCase()».web.client.MenuPanel;
		import co.shift.«packageName.toLowerCase()».«be.name.toLowerCase».boundary.I«be.name.toFirstUpper»Manager;
		import co.shift.«packageName.toLowerCase()».util.beanlocator.BeanLocator;
		import co.shift.«packageName.toLowerCase()».to.«be.name.toFirstUpper»TO;
		«DomainCodeUtilities.endSection»
		
		
		public class «be.name.toFirstUpper»Controller extends AbstractController {
			
			private static «be.name.toFirstUpper»Controller controller;
			«var n = 0»
			«FOR ass : be.associations»
			«IF ass instanceof Multiple»
			private static final int TAB_«ass.entity.name.toUpperCase» = «n++»;
			«ENDIF»
			«ENDFOR»
			
			private I«be.name.toFirstUpper»Manager «be.name.toLowerCase»Manager;
			
		«DomainCodeUtilities.beginSection(DomainParams.SECT_METHODS)»
			private «be.name.toFirstUpper»Controller() {
				doLookup();
			}
			
			private void doLookup() {
				«be.name.toLowerCase»Manager = BeanLocator.lookup(
						I«be.name.toFirstUpper»Manager.class,
						new BeanLocator().getGlobalJNDIName()
								.withAppName("co.shift.ear")
								.withModuleName("co.shift.ejb")
								.withBeanName("«be.name.toFirstUpper»Manager")
								.withBusinessInterface(I«be.name.toFirstUpper»Manager.class)
								.asString());
			}
			«IF DomainCodeUtilities.isMaster(be)»
			public void show«be.name.toFirstUpper»Form() {
				«be.name.toFirstUpper»Form «be.name.toLowerCase»Form = Registry.get(«be.name.toFirstUpper»Form.ID);
				«var conListAll = DomainCodeUtilities.getContract(be, ListAll).get(0)»
««« Jcifuentes: Comentado
«««				«var con0 = DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, conListAll, be, 0)»
				«var con0 = DomainCodeUtilities.contribute2Template(1, conListAll, be, 0)»
				«var con1 = con0.substring(con0.indexOf(" ")+1)»
				«var con2 = con1.substring(con1.indexOf(" ")+1)»
				«var con3 = con2.substring(0, con2.indexOf(")")+1)»
				
				«DomainCodeUtilities.removeAttributeContracts(con3)»;
		
				ContentPanel panel = Registry.get(«packageName.toUpperCase»UI.CONTENT_PANEL);
				panel.removeContent();
				panel.setContent(«be.name.toLowerCase»Form);
			}
			
			public void removeDetailRecord() {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
					«be.name.toFirstUpper»TO «be.name.toLowerCase» = («be.name.toFirstUpper»TO) pF.getTable_1().getValue();
					TabSheet tS = pF.getTabSheet_1();
					int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
					switch (selectedTab) {
					«var index = 2»
					«FOR ass : be.associations»
					«IF ass instanceof Multiple && DomainCodeUtilities.hasRemoveContract(be, (ass as Multiple).entity)»
					«var relBe = (ass as Multiple).entity»
					case TAB_«relBe.name.toUpperCase»:
						try {
							// String obtained from ClassName - MethodName
««« Jcifuentes: Comentado
«««							«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, be.name.toFirstUpper+" - Remove"+relBe.name.toFirstUpper)»
							«DomainCodeUtilities.contribute2Template(2, be.name.toFirstUpper+" - Remove"+relBe.name.toFirstUpper)»
							«DomainCodeUtilities.addService(be.name.toFirstUpper+" - Remove"+relBe.name.toFirstUpper)»
							«relBe.name.toFirstUpper»TO «relBe.name.toLowerCase» = («relBe.name.toFirstUpper»TO) pF.getTable_«index++»().getValue();
							if («relBe.name.toLowerCase» != null) {
								«var contract = ""»
								«FOR con : DomainCodeUtilities.getContract(be, DeleteElement)»
								«var conI = con as ContractElements»
								«IF conI.association.entity.name.equals(relBe.name)»
								«var ddf = (contract += conI.name)»
								«ENDIF»
								«ENDFOR»
								«IF (DomainCodeUtilities.isMaster(relBe) && DomainCodeUtilities.getDetailMultipleAssociations(relBe, associations) != null)»
								«contract»(ui, «be.name.toLowerCase», «relBe.name.toLowerCase»);
								«ELSE»
								«contract»(ui, «relBe.name.toLowerCase»);
								«ENDIF»
							} else
								((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(
										«packageName.toUpperCase»UI.MSG_ERR,
										"Please select the «relBe.name.toLowerCase» to be removed");
						} catch (Exception e) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
						}
						break;
					«ENDIF»
					«ENDFOR»
					default:
						break;
					}
		
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
			«ENDIF»
			
			public static «be.name.toFirstUpper»Controller getInstance() {
				if (controller == null) {
					controller = new «be.name.toFirstUpper»Controller();
					«IF DomainCodeUtilities.isMaster(be)»
					«be.name.toFirstUpper»Form pF = new «be.name.toFirstUpper»Form();
					Registry.register(«be.name.toFirstUpper»Form.ID, pF);
					«ENDIF»
					«FOR ass : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
					«var relBe = ass.eContainer as BusinessEntity»
					«var contract = ""»
					«FOR con : DomainCodeUtilities.getContract(relBe, AddElement)»
					«var conI = con as ContractElements»
					«IF conI.association.entity.name.equals(be.name)»
					«var ddf = (contract += conI.name)»
					«ENDIF»
					«ENDFOR»
					«IF !contract.equals("")»
					«IF !DomainCodeUtilities.hasZeroAssociations(be)»
					PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form uF = new PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form();
					Registry.register(PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form.ID, uF);
					«ELSE»
					PopUp«be.name.toFirstUpper»Form uF = new PopUp«be.name.toFirstUpper»Form();
					Registry.register(PopUp«be.name.toFirstUpper»Form.ID, uF);
					«ENDIF»
					«ENDIF»
					«ENDFOR»
					«FOR a : DomainCodeUtilities.getDetailSimpleAssociations(be, associations)»
					«be.name.toFirstUpper»«a.name.toFirstUpper»Form uMF = new «be.name.toFirstUpper»«a.name.toFirstUpper»Form();
					Registry.register(«be.name.toFirstUpper»«a.name.toFirstUpper»Form.ID, uMF);
					«ENDFOR»
				}
				return controller;
			}
			
			«FOR association : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeUtilities.getID(container).dataType.literal»
				public List<«be.name»TO> get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«DomainCodeUtilities.getType(type)» «container.name.
				toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper») {
					return «be.name.toLowerCase»Manager.get«be.name.toFirstUpper»From«container.name.toFirstUpper»(«container.name.
				toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»);
				}
				
				«var contract = ""»
				«FOR con : DomainCodeUtilities.getContract(container, AddElement)»
				«var conI = con as ContractElements»
				«IF conI.association.entity.name.equals(be.name)»
				«var ddf = (contract += conI.name)»
				«ENDIF»
				«ENDFOR»
				«IF !contract.equals("")»
				«IF !DomainCodeUtilities.hasZeroAssociations(be)»
					«fsa.generateFile("/co/shift/"+packageName.toLowerCase+"/web/ext/"+be.name.toLowerCase+"/PopUp"+container.name.toFirstUpper+be.name.toFirstUpper+"Form.java", PopUpMasterDetailTemplate
						.generate(packageName, be.name.toLowerCase, container, be, be.name.toFirstUpper+"Controller", "add"+be.name.toFirstUpper+"To"+container.name.toFirstUpper, "PopUp"+container.name.toFirstUpper+be.name.toFirstUpper, "update"+container.name.toFirstUpper+be.name.toFirstUpper+"sFormFields"))»				
				«ELSE»
					«fsa.generateFile("/co/shift/"+packageName.toLowerCase+"/web/ext/"+be.name.toLowerCase+"/PopUp"+be.name.toFirstUpper+"Form.java", MasterWithDetailTemplate
						.generate(packageName, be.name.toLowerCase, be, be.name.toFirstUpper+"Controller", container))»				
				«ENDIF»
				«ENDIF»
			«ENDFOR»
			
			«FOR association : DomainCodeUtilities.getDetailSimpleAssociations(be, associations)»
				«val container = association.eContainer as BusinessEntity»
				«val type = DomainCodeUtilities.getID(container).dataType.literal»
				public «be.name»TO get«container.name.toFirstUpper»«association.name.toFirstUpper»(«DomainCodeUtilities.getType(type)» «container.name.
				toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper») {
					return «be.name.toLowerCase»Manager.get«container.name.toFirstUpper»«association.name.toFirstUpper»(«container.name.
					toLowerCase»«DomainCodeUtilities.getID(container).name.toFirstUpper»);
				}
			«ENDFOR»
			
			«FOR con : DomainCodeUtilities.getContract(be, ListAll)»
««« Jcifuentes: Comentado
«««			«DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, con, be, 1)»
			«DomainCodeUtilities.contribute2Template(1, con, be, 1)»
			«ENDFOR»
			
			«FOR c : be.contracts»
			«IF c instanceof ListAll»
««« Jcifuentes: Comentado
«««			«DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, c, be, 0)»
			«DomainCodeUtilities.contribute2Template(1, c, be, 0)»
			«ENDIF»
			«ENDFOR»
			
			«IF DomainCodeUtilities.isMaster(be)»
			public void listAllDetailsFrom«be.name.toFirstUpper»(ItemClickEvent event) {
				«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
				«be.name.toFirstUpper»TO «be.name.toLowerCase» = («be.name.toFirstUpper»TO) event.getItemId();
				if («be.name.toLowerCase» != null) {
					«FOR a : be.attributes»
					«IF DomainCodeUtilities.getType(a).equals("Date")»
					pF.getTxtD«a.name.toFirstUpper»().setValue(«be.name.toLowerCase».get«a.name.toFirstUpper»());
					«ELSE»
					pF.getTxt«a.name.toFirstUpper»().setValue(""+«be.name.toLowerCase».get«a.name.toFirstUpper»());
					«ENDIF»
					«ENDFOR»
					«FOR ass : be.associations»
					«IF ass instanceof Multiple»
					«var relBe = ass.entity»
					list«be.name.toFirstUpper»«relBe.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
					«ELSE»
					«var relBe = (ass as Simple).relatedEntity»
					«relBe.name.toFirstUpper»TO «ass.name.toLowerCase» = «relBe.name.toFirstUpper»Controller.getInstance()
							.get«be.name.toFirstUpper»«ass.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
					if («ass.name.toLowerCase» != null)
						pF.update«ass.name.toFirstUpper»Fields(«ass.name.toLowerCase»);
					else
						pF.clear«ass.name.toFirstUpper»Fields();
					«ENDIF»
					«ENDFOR»
				} else
					pF.clearFormFields();
			}
			«var pp = 2»
			«FOR ass : be.associations»
			«IF ass instanceof Multiple»
			«var relBe = ass.entity»
			public void list«be.name.toFirstUpper»«relBe.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(be))» «be.name.toLowerCase»ID) {
				List<«relBe.name.toFirstUpper»TO> «relBe.name.toLowerCase»s = «relBe.name.toFirstUpper»Controller.getInstance()
						.get«relBe.name.toFirstUpper»From«be.name.toFirstUpper»(«be.name.toLowerCase»ID);
				«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
				pF.getTable_«pp»().removeAllItems();

				for («relBe.name.toFirstUpper»TO to : «relBe.name.toLowerCase»s) {
					Object data[] = { 
						«var size = relBe.attributes.size»
						«var c = 0»
						«FOR a : relBe.attributes»
						«IF c < size - 1»
						to.get«a.name.toFirstUpper»(), 
						«ELSE»
						to.get«a.name.toFirstUpper»()
						«ENDIF»
						«var sd = c++»
						«ENDFOR»
					};
					pF.getTable_«pp++»().addItem(data, to);
				}
			}
			«ENDIF»
			«ENDFOR»
			«ENDIF»
			
			«FOR c : be.contracts»
			«IF DomainCodeUtilities.isMaster(be)»
			«IF c instanceof Create»
			public void create«be.name.toFirstUpper»() {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					// String obtained from ClassName - MethodName
««« Jcifuentes: Comentado
«««					«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, be.name.toFirstUpper+" - Create")»
					«DomainCodeUtilities.contribute2Template(2, be.name.toFirstUpper+" - Create")»
					«DomainCodeUtilities.addService(be.name.toFirstUpper+" - Create")»
					«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
					«FOR a : be.attributes»
					«IF DomainCodeUtilities.getType(a).equals("Date")»
					«DomainCodeUtilities.getType(a)» «a.name.toLowerCase» = pF.getTxtD«a.name.toFirstUpper»().getValue();
					«ELSE»
					«IF DomainCodeUtilities.getType(a).equals("int")»
					«DomainCodeUtilities.getType(a)» «a.name.toLowerCase» = Integer.parseInt(pF.getTxt«a.name.toFirstUpper»().getValue());
					«ELSE»
					«DomainCodeUtilities.getType(a)» «a.name.toLowerCase» = pF.getTxt«a.name.toFirstUpper»().getValue();
					«ENDIF»
					«ENDIF»
					«ENDFOR»
		
					if (
					«var c1 = 0»
					«var List<Attribute> atts = new ArrayList»
					«FOR a : be.attributes»
					«IF (DomainCodeUtilities.getType(a).equals("Date") || DomainCodeUtilities.getType(a).equals("String"))»
					«var add = atts.add(a)»
					«ENDIF»
					«ENDFOR»
					«var l1 = atts.size»
					«FOR a : atts»
					«IF DomainCodeUtilities.getType(a).equals("Date")»
					«a.name.toLowerCase» != null
					«ENDIF»
					«IF DomainCodeUtilities.getType(a).equals("String")»
					«a.name.toLowerCase» != null && !«a.name.toLowerCase».equals("")
					«ENDIF»
					«IF (DomainCodeUtilities.getType(a).equals("Date") || DomainCodeUtilities.getType(a).equals("String")) && c1 < l1 - 1»
					&&
					«ENDIF»
					«var ff = c1++»
					«ENDFOR») {
						«be.name.toFirstUpper»TO «be.name.toLowerCase» = new «be.name.toFirstUpper»TO();
						«FOR a : be.attributes»
						«be.name.toLowerCase».set«a.name.toFirstUpper»(«a.name.toLowerCase»);
						«ENDFOR»
		
						if («be.name.toLowerCase»Manager.create«be.name.toFirstUpper»(«be.name.toLowerCase»)) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT,
									"Creation process executed successfully");
							«var conListAll = DomainCodeUtilities.getContract(be, ListAll).get(0)»
««« Jcifuentes: Comentado
«««							«var con = DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, conListAll, be, 0)»
							«var con = DomainCodeUtilities.contribute2Template(1, conListAll, be, 0)»
							«var con1 = con.substring(con.indexOf(" ")+1)»
							«var con2 = con1.substring(con1.indexOf(" ")+1)»
							«var con3 = con2.substring(0, con2.indexOf(")")+1)»
							
							«DomainCodeUtilities.removeAttributeContracts(con3)»;
«««							«c.name»();
							«be.name.toFirstUpper»Form «be.name.toLowerCase»Form = Registry.get(«be.name.toFirstUpper»Form.ID);
							«be.name.toLowerCase»Form.clearFormFields();
						} else
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Creation process failed");
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI))
								.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
										"Please fill in all required fields (*)");
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
			«ENDIF»
			«IF c instanceof Update»
			public void update«be.name.toFirstUpper»() {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					// String obtained from ClassName - MethodName
««« Jcifuentes: Comentado
«««					«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, be.name.toFirstUpper+" - Update")»
					«DomainCodeUtilities.contribute2Template(2, be.name.toFirstUpper+" - Update")»
					«DomainCodeUtilities.addService(be.name.toFirstUpper+" - Update")»
					«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
					«be.name.toFirstUpper»TO «be.name.toLowerCase» = («be.name.toFirstUpper»TO) pF.getTable_1().getValue();
					if («be.name.toLowerCase» != null) {
						«FOR a : be.attributes»
						«IF DomainCodeUtilities.getType(a).equals("Date")»
						«be.name.toLowerCase».set«a.name.toFirstUpper»(pF.getTxtD«a.name.toFirstUpper»().getValue());
						«ELSE»
						«IF DomainCodeUtilities.getType(a).equals("int")»
						«be.name.toLowerCase».set«a.name.toFirstUpper»(Integer.parseInt(pF.getTxt«a.name.toFirstUpper»().getValue()));
						«ELSE»
						«be.name.toLowerCase».set«a.name.toFirstUpper»(pF.getTxt«a.name.toFirstUpper»().getValue());
						«ENDIF»
						«ENDIF»
						«ENDFOR»
		
						if («be.name.toLowerCase»Manager.update«be.name.toFirstUpper»(«be.name.toLowerCase»))
							ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT,
									"Updating process executed successfully");
						else
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"Updating process failed");
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(
								«packageName.toUpperCase»UI.MSG_ERR, "Please select a «be.name.toLowerCase» to update");
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
			«ENDIF»
			«IF c instanceof Delete»
			public void delete«be.name.toFirstUpper»() {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					// String obtained from ClassName - MethodName
««« Jcifuentes: Comentado
«««					«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, be.name.toFirstUpper+" - Delete")»
					«DomainCodeUtilities.contribute2Template(2, be.name.toFirstUpper+" - Delete")»
					«DomainCodeUtilities.addService(be.name.toFirstUpper+" - Delete")»
					«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
					«be.name.toFirstUpper»TO «be.name.toLowerCase» = («be.name.toFirstUpper»TO) pF.getTable_1().getValue();
					if («be.name.toLowerCase» != null) {
						if («be.name.toLowerCase»Manager.delete«be.name.toFirstUpper»(«be.name.toLowerCase»)) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT,
									"Delete process executed successfully");
							«var conListAll = DomainCodeUtilities.getContract(be, ListAll).get(0)»
««« Jcifuentes: Comentado
«««							«var con = DomainCodeUtilities.extendContribution("_r_1", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, conListAll, be, 0)»
							«var con = DomainCodeUtilities.contribute2Template(1, conListAll, be, 0)»
							«var con1 = con.substring(con.indexOf(" ")+1)»
							«var con2 = con1.substring(con1.indexOf(" ")+1)»
							«var con3 = con2.substring(0, con2.indexOf(")")+1)»
							
							«DomainCodeUtilities.removeAttributeContracts(con3)»;
							«be.name.toFirstUpper»Form «be.name.toLowerCase»Form = Registry.get(«be.name.toFirstUpper»Form.ID);
							«be.name.toLowerCase»Form.clearFormFields();
						} else
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Delete process failed");
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(
								«packageName.toUpperCase»UI.MSG_ERR, "Please select a «be.name.toLowerCase» to delete");
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
			«ENDIF»
			«IF (c instanceof AddElement)»
			«val relatedEntity = (c as ContractElements).association.entity»
			«IF !DomainCodeUtilities.hasZeroAssociations(relatedEntity)»
			«val type = DomainCodeUtilities.getID(be).dataType.literal»
			public boolean «(c as ContractElements).name»(«relatedEntity.name»TO «relatedEntity.name.toLowerCase», «DomainCodeUtilities.getType(
			type)» «be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper») {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					if («be.name.toLowerCase»Manager.«(c as ContractElements).name»(«relatedEntity.name.toLowerCase», «be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper»)) {
						ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT, "«relatedEntity.name.toFirstUpper» " + «relatedEntity.name.toLowerCase».get«DomainCodeUtilities.getID(relatedEntity).name.toFirstUpper»()
								+ " added to «be.name.toFirstUpper» " + «be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper»);
						ui.closeSubWindow();
						list«be.name.toFirstUpper»«relatedEntity.name.toFirstUpper»(«be.name.toLowerCase»«DomainCodeUtilities.getID(be).name.toFirstUpper»);
						return true;
					} else {
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
								"«relatedEntity.name.toFirstUpper» cannot be added to «be.name.toLowerCase»");
						return false;
					}
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
					return false;
				}
			}
			«ENDIF»
			«ENDIF»
			«IF (c instanceof DeleteElement)»
			«val relatedEntity = (c as ContractElements).association.entity»
			«IF (DomainCodeUtilities.isMaster(relatedEntity) && DomainCodeUtilities.getDetailMultipleAssociations(relatedEntity, associations) != null)»
			public void «(c as ContractElements).name»(«packageName.toUpperCase»UI ui, «be.name.toFirstUpper»TO «be.name.toLowerCase», «relatedEntity.name»TO «relatedEntity.name.toLowerCase») {
				try {
					if («be.name.toLowerCase»Manager.remove«relatedEntity.name.toFirstUpper»From«be.name.toFirstUpper»(«relatedEntity.name.toLowerCase», «be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»())) {
						ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT, "«relatedEntity.name.toFirstUpper» " + «relatedEntity.name.toLowerCase».get«DomainCodeUtilities.getID(relatedEntity).name.toFirstUpper»()
							+ " removed from «be.name.toFirstUpper» " + «be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
					ui.closeSubWindow();
					list«be.name.toFirstUpper»«relatedEntity.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
				} else {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
							"«relatedEntity.name.toFirstUpper» cannot be removed from «be.name.toLowerCase»");
				}
			} catch (Exception e) {
				ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
			}
			«ELSE»
			public void «(c as ContractElements).name»(«packageName.toUpperCase»UI ui, «relatedEntity.name»TO «relatedEntity.name.toLowerCase») {
				try {
					if («relatedEntity.name.toFirstUpper»Controller.getInstance().delete«relatedEntity.name.toFirstUpper»(«relatedEntity.name.toLowerCase»)) {
						ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT, "«relatedEntity.name.toFirstUpper» " + «relatedEntity.name.toLowerCase».get«DomainCodeUtilities.getID(relatedEntity).name.toFirstUpper»()
							+ " removed from «be.name.toFirstUpper» " + «relatedEntity.name.toLowerCase».get«be.name.toFirstUpper»());
					ui.closeSubWindow();
					list«be.name.toFirstUpper»«relatedEntity.name.toFirstUpper»(«relatedEntity.name.toLowerCase».get«be.name.toFirstUpper»());
					} else {
						ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
							"«relatedEntity.name.toFirstUpper» cannot be removed from «be.name.toLowerCase»");
					}
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			«ENDIF»
			}
			«ENDIF»
			«ENDIF»
			«ENDFOR»
			
			«FOR ass : be.associations»
			«IF ass instanceof Simple»
			«var relBe = ass.relatedEntity»
			public void set«be.name.toFirstUpper»«ass.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(be))» «be.name.toLowerCase») {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					«relBe.name.toFirstUpper»«ass.name.toFirstUpper»Form uMF = Registry.get(«relBe.name.toFirstUpper»«ass.name.toFirstUpper»Form.ID);
					ComboBox combo = uMF.getComboBox_1();
					«relBe.name.toFirstUpper»TO «ass.name.toLowerCase» = («relBe.name.toFirstUpper»TO) combo.getValue();
					if («ass.name.toLowerCase» != null) {
						if («be.name.toLowerCase»Manager.set«be.name.toFirstUpper»«ass.name.toFirstUpper»(«ass.name.toLowerCase», «be.name.toLowerCase»)) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT,
									"«relBe.name.toFirstUpper» " + «ass.name.toLowerCase».get«DomainCodeUtilities.getID(relBe).name.toFirstUpper»()
											+ " was set as «ass.name.toFirstUpper» of «be.name.toFirstUpper» "
											+ «be.name.toLowerCase»);
							ui.closeSubWindow();
							«be.name.toFirstUpper»Form «be.name.toLowerCase»Form = Registry.get(«be.name.toFirstUpper»Form.ID);
							«be.name.toLowerCase»Form.update«ass.name.toFirstUpper»Fields(«ass.name.toLowerCase»);
						} else {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									"«relBe.name.toFirstUpper» cannot be added to «be.name.toLowerCase»");
						}
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(
								«packageName.toUpperCase»UI.MSG_ERR, "Please select the «ass.name.toLowerCase»");
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
			
			public void popUp«ass.name.toFirstUpper»Form() {
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
				try {
					// String obtained from ClassName - MethodName
««« Jcifuentes: Comentado
«««					«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, be.name.toFirstUpper+" - Set"+ass.name.toFirstUpper)»
					«DomainCodeUtilities.contribute2Template(2, be.name.toFirstUpper+" - Set"+ass.name.toFirstUpper)»
					«DomainCodeUtilities.addService(be.name.toFirstUpper+" - Set"+ass.name.toFirstUpper)»
					«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
					«be.name.toFirstUpper»TO «be.name.toLowerCase» = («be.name.toFirstUpper»TO) pF.getTable_1().getValue();
					if («be.name.toLowerCase» != null) {
						«relBe.name.toFirstUpper»«ass.name.toFirstUpper»Form uMF = Registry.get(«relBe.name.toFirstUpper»«ass.name.toFirstUpper»Form.ID);
						List<«relBe.name.toFirstUpper»TO> «relBe.name.toLowerCase»s = «relBe.name.toFirstUpper»Controller.getInstance()
								.get«relBe.name.toFirstUpper»From«be.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
						uMF.set«be.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
						uMF.clearFormFields();
						«relBe.name.toFirstUpper»TO «ass.name.toLowerCase» = «relBe.name.toFirstUpper»Controller.getInstance()
								.get«be.name.toFirstUpper»«ass.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
						// uMF.populateUsers(users, manager);
						«relBe.name.toFirstUpper»Controller.getInstance().populate«relBe.name.toFirstUpper»«ass.name.toFirstUpper»Combo(
								«relBe.name.toLowerCase»s, «ass.name.toLowerCase»);
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).openSubWindow(
								"«be.name.toFirstUpper» «ass.name.toFirstUpper»", uMF);
					} else
						((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(
								«packageName.toUpperCase»UI.MSG_ERR,
								"Please select a «be.name.toLowerCase» to set its «ass.name.toLowerCase»");
				} catch (Exception e) {
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
				}
			}
			«ENDIF»
			«ENDFOR»
			
			«IF DomainCodeUtilities.isMaster(be)»
			public void popUpAddDetailForm() {
				«be.name.toFirstUpper»Form pF = Registry.get(«be.name.toFirstUpper»Form.ID);
				«be.name.toFirstUpper»TO «be.name.toLowerCase» = («be.name.toFirstUpper»TO) pF.getTable_1().getValue();
				«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
		
				if («be.name.toLowerCase» != null) {
					TabSheet tS = pF.getTabSheet_1();
					int selectedTab = tS.getTabPosition(tS.getTab(tS.getSelectedTab()));
					switch (selectedTab) {
					«var index = 2»
					«FOR ass : be.associations»
					«IF ass instanceof Multiple»
					«var relBe = ass.entity»
					«var contract = ""»
					«FOR con : DomainCodeUtilities.getContract(be, AddElement)»
					«var conI = con as ContractElements»
					«IF conI.association.entity.name.equals(relBe.name)»
					«var ddf = (contract += conI.name)»
					«ENDIF»
					«ENDFOR»
					«IF !contract.equals("")»
					case TAB_«relBe.name.toUpperCase»:
						try {
							// String obtained from ClassName - MethodName
««« Jcifuentes: Comentado
«««							«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, be.name.toFirstUpper+" - Add"+relBe.name.toFirstUpper)»
							«DomainCodeUtilities.contribute2Template(2, be.name.toFirstUpper+" - Add"+relBe.name.toFirstUpper)»
							«DomainCodeUtilities.addService(be.name.toFirstUpper+" - Add"+relBe.name.toFirstUpper)»
							«IF DomainCodeUtilities.hasZeroAssociations(relBe) && !DomainCodeUtilities.isMaster(relBe)»
					
							PopUp«relBe.name.toFirstUpper»Form rF = Registry.get(PopUp«relBe.name.toFirstUpper»Form.ID);
							rF.set«be.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
							((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).openSubWindow("«relBe.name.toFirstUpper»", rF);
							«ELSE»
		
							PopUp«be.name.toFirstUpper»«relBe.name.toFirstUpper»Form uF = Registry.get(PopUp«be.name.toFirstUpper»«relBe.name.toFirstUpper»Form.ID);
							«var con = DomainCodeUtilities.getContract(relBe, ListAll).get(0)»
							List<«relBe.name.toFirstUpper»TO> «relBe.name.toLowerCase»s = «relBe.name.toFirstUpper»Controller.getInstance()
									.«con.name»();
							// uF.populateUsers(users);
							«relBe.name.toFirstUpper»Controller.getInstance().populate«relBe.name.toFirstUpper»Combo(«relBe.name.toLowerCase»s);
							uF.set«be.name.toFirstUpper»(«be.name.toLowerCase».get«DomainCodeUtilities.getID(be).name.toFirstUpper»());
							((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).openSubWindow("«relBe.name.toFirstUpper»", uF);
							«ENDIF»
						} catch (Exception e) {
							ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, e.getMessage());
						}
						break;
					«ENDIF»
					«ENDIF»
					«ENDFOR»
					default:
						break;
					}
				} else
					ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR, "Please select a «be.name.toLowerCase»");
			}
		
			public Command get«be.name.toFirstUpper»Command() {
				return new Command() {
		
					private static final long serialVersionUID = 1L;
		
					@Override
					public void menuSelected(MenuItem selectedItem) {
						show«be.name.toFirstUpper»Form();
					}
				};
			}
			«ENDIF»
			
			«IF DomainCodeUtilities.hasZeroAssociations(be)»
			public boolean delete«be.name.toFirstUpper»(«be.name.toFirstUpper»TO «be.name.toLowerCase») throws Exception {
					try {
						«var con = DomainCodeUtilities.getContract(be, Delete).get(0)»
						return «be.name.toLowerCase»Manager.«con.name»(«be.name.toLowerCase»);
				} catch (Exception e) {
					throw e;
				}
			}
			«ENDIF»
			
			«FOR ass : DomainCodeUtilities.getDetailMultipleAssociations(be, associations)»
			«var relBe = ass.eContainer as BusinessEntity»
			«var contract = ""»
			«FOR con : DomainCodeUtilities.getContract(relBe, AddElement)»
			«var conI = con as ContractElements»
			«IF conI.association.entity.name.equals(be.name)»
			«var ddf = (contract += conI.name)»
			«ENDIF»
			«ENDFOR»
«««			«IF (!contract.equals("") || (DomainCodeUtilities.isDetailOf(be, relBe) && DomainCodeUtilities.isDetail(be)))»
			«IF (!contract.equals("") && !DomainCodeUtilities.hasZeroAssociations(relBe))»
			public void add«be.name.toFirstUpper»To«relBe.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(relBe))» «relBe.name.toLowerCase») {
				«IF !DomainCodeUtilities.hasZeroAssociations(be)»
				PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form pF = Registry.get(PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form.ID);
				«ELSE»
				PopUp«be.name.toFirstUpper»Form pF = Registry.get(PopUp«be.name.toFirstUpper»Form.ID);
				«ENDIF»
				try{		
					// String obtained from ClassName - MethodName
««« Jcifuentes: Comentado
«««					«DomainCodeUtilities.extendContribution("_r_2_11_15_16", DomainCodeUtilities.CONTRIBUTE_TO_WEB_IMPL, relBe.name.toFirstUpper+" - Add"+be.name.toFirstUpper)»
					«DomainCodeUtilities.contribute2Template(2, relBe.name.toFirstUpper+" - Add"+be.name.toFirstUpper)»
					«DomainCodeUtilities.addService(relBe.name.toFirstUpper+" - Add"+be.name.toFirstUpper)»
					«var tF = 1»
					«FOR a : be.attributes»
					«IF DomainCodeUtilities.getType(a).equals("Date")»
					Date «a.name.toLowerCase» = pF.getPopupDateField_«tF++»().getValue();
					«ELSE»
					«IF DomainCodeUtilities.getType(a).equals("int")»
					int «a.name.toLowerCase» = Integer.parseInt(pF.getTextField_«tF++»().getValue());
					«ELSE»
					«IF DomainCodeUtilities.getType(a).equals("double")»
					double «a.name.toLowerCase» = Double.parseDouble(pF.getTextField_«tF++»().getValue());
					«ELSE»
					«DomainCodeUtilities.getType(a)» «a.name.toLowerCase» = pF.getTextField_«tF++»().getValue();
					«ENDIF»
					«ENDIF»
					«ENDIF»
					«ENDFOR»
					
					if (
						«var c1 = 0»
						«var List<Attribute> atts = new ArrayList»
						«FOR a : be.attributes»
						«IF (DomainCodeUtilities.getType(a).equals("Date") || DomainCodeUtilities.getType(a).equals("String"))»
						«var add = atts.add(a)»
						«ENDIF»
						«ENDFOR»
						«var l1 = atts.size»
						«FOR a : atts»
						«IF DomainCodeUtilities.getType(a).equals("Date")»
						«a.name.toLowerCase» != null
						«ENDIF»
						«IF DomainCodeUtilities.getType(a).equals("String")»
						«a.name.toLowerCase» != null && !«a.name.toLowerCase».equals("")
						«ENDIF»
						«IF (DomainCodeUtilities.getType(a).equals("Date") || DomainCodeUtilities.getType(a).equals("String")) && c1 < l1 - 1»
						&&
						«ENDIF»
						«var ff = c1++»
						«ENDFOR») {
							«be.name.toFirstUpper»TO «be.name.toLowerCase» = new «be.name.toFirstUpper»TO();
							«FOR a : be.attributes»
	«««						«IF DomainCodeUtilities.getWrapperType(a).equals("BigDecimal")»
	«««						BigDecimal «a.name.toLowerCase»D = new BigDecimal(«a.name.toLowerCase»);
	«««						«be.name.toLowerCase».set«a.name.toFirstUpper»(«a.name.toLowerCase»D);
	«««						«ELSE»
							«be.name.toLowerCase».set«a.name.toFirstUpper»(«a.name.toLowerCase»);						
	«««						«ENDIF»
							«ENDFOR»
							«IF DomainCodeUtilities.isDetailOf(be, relBe) && DomainCodeUtilities.hasZeroAssociations(be)»
							«be.name.toLowerCase».set«relBe.name.toFirstUpper»(«relBe.name.toLowerCase»);
							if (add«be.name.toFirstUpper»To«relBe.name.toFirstUpper»(«be.name.toLowerCase»))
								pF.clearFormFields();
							«ELSE»
							if («relBe.name.toFirstUpper»Controller.getInstance().«contract»(«be.name.toLowerCase», «relBe.name.toLowerCase»))
								pF.clearFormFields();
							«ENDIF»
						} else
							((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(«packageName.toUpperCase»UI.MSG_ERR,
								"Please fill in all required fields (*)");
						} catch (Exception e) {
							((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(«packageName.toUpperCase»UI.MSG_ERR,
								"Please fill in all required fields (*)");
						}
					}
					
					«IF DomainCodeUtilities.isDetailOf(be, relBe) && DomainCodeUtilities.hasZeroAssociations(be) && !DomainCodeUtilities.hasZeroAssociations(relBe)»
					private boolean add«be.name.toFirstUpper»To«relBe.name.toFirstUpper»(«be.name.toFirstUpper»TO «be.name.toLowerCase») {
						«packageName.toUpperCase»UI ui = Registry.get(«packageName.toUpperCase»UI.UI);
						try {
							if («be.name.toLowerCase»Manager.add«be.name.toFirstUpper»(«be.name.toLowerCase»)) {
								ui.showNotification(«packageName.toUpperCase»UI.MSG_NOT, "«be.name.toFirstUpper» added to «relBe.name.toFirstUpper» "
										+ «be.name.toLowerCase».get«relBe.name.toFirstUpper»());
								ui.closeSubWindow();
								«relBe.name.toFirstUpper»Controller.getInstance().list«relBe.name.toFirstUpper»«be.name.toFirstUpper»(
										«be.name.toLowerCase».get«relBe.name.toFirstUpper»());
								return true;
						} else {
								ui.showNotification(«packageName.toUpperCase»UI.MSG_ERR,
										"«be.name.toFirstUpper» cannot be added to «relBe.name.toFirstUpper»");
								return false;
							}
						} catch (Exception e) {
							((«packageName.toUpperCase»UI) Registry.get(«packageName.toUpperCase»UI.UI)).showNotification(«packageName.toUpperCase»UI.MSG_ERR,
									e.getMessage());
							return false;
						}
					}
					«ENDIF»
					
			«ENDIF»
«««			«IF DomainCodeUtilities.isDetailOf(be, relBe) && !DomainCodeUtilities.isDetail(be)»
			«IF !contract.equals("")»
			«IF !DomainCodeUtilities.hasZeroAssociations(be)»
			public void populate«be.name.toFirstUpper»Combo(List<«be.name.toFirstUpper»TO> list) {
				«IF !DomainCodeUtilities.hasZeroAssociations(be)»
				PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form uF = Registry.get(PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form.ID);
				«ELSE»
				PopUp«be.name.toFirstUpper»Form uF = Registry.get(PopUp«be.name.toFirstUpper»Form.ID);
				«ENDIF»
				ComboBox combo = uF.getComboBox_1();
				combo.removeAllItems();
				
				for («be.name.toFirstUpper»TO to : list) {
					combo.addItem(to);
				}
			}
			
«««			«IF !contract.equals("")»
			public void update«relBe.name.toFirstUpper»«be.name.toFirstUpper»sFormFields() {
				«IF !DomainCodeUtilities.hasZeroAssociations(be)»
				PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form uF = Registry.get(PopUp«relBe.name.toFirstUpper»«be.name.toFirstUpper»Form.ID);
				«ELSE»
				PopUp«be.name.toFirstUpper»Form uF = Registry.get(PopUp«be.name.toFirstUpper»Form.ID);
				«ENDIF»
				ComboBox combo = uF.getComboBox_1();
				«be.name.toFirstUpper»TO «be.name.toLowerCase» = («be.name.toFirstUpper»TO) combo.getValue();
				if («be.name.toLowerCase» != null) {
					«var tF = 1»
					«FOR a : be.attributes»
					«IF DomainCodeUtilities.getType(a).equals("Date")»
					TextField txt«a.name.toFirstUpper» = uF.getTextField_«tF++»();
					txt«a.name.toFirstUpper».setValue(«be.name.toLowerCase».get«a.name.toFirstUpper»().toString());
					«ELSE»
					«IF DomainCodeUtilities.getType(a).equals("int") || DomainCodeUtilities.getType(a).equals("double")»
					TextField txt«a.name.toFirstUpper» = uF.getTextField_«tF++»();
					txt«a.name.toFirstUpper».setValue(""+«be.name.toLowerCase».get«a.name.toFirstUpper»());
					«ELSE»
					TextField txt«a.name.toFirstUpper» = uF.getTextField_«tF++»();
					txt«a.name.toFirstUpper».setValue(«be.name.toLowerCase».get«a.name.toFirstUpper»());
					«ENDIF»
					«ENDIF»
					«ENDFOR»
				}
			}
			«ENDIF»
			«ENDIF»
			«ENDFOR»
			
			«FOR ass : DomainCodeUtilities.getDetailSimpleAssociations(be, associations)»
			«var relBe = ass.eContainer as BusinessEntity»
			public void update«ass.name.toFirstUpper»FormFields() {
				«be.name.toFirstUpper»«ass.name.toFirstUpper»Form uMF = Registry.get(«be.name.toFirstUpper»«ass.name.toFirstUpper»Form.ID);
				ComboBox combo = uMF.getComboBox_1();
				«be.name.toFirstUpper»TO «be.name.toLowerCase()» = («be.name.toFirstUpper»TO) combo.getValue();
				if («be.name.toLowerCase» != null) {
					«var tF = 1»
					«FOR a : be.attributes»
					«IF DomainCodeUtilities.getType(a).equals("Date")»
					uMF.getTextField_«tF++»().setValue(«be.name.toLowerCase».get«a.name.toFirstUpper»().toString());
					«ELSE»
					«IF DomainCodeUtilities.getType(a).equals("int") || DomainCodeUtilities.getType(a).equals("double")»
					uMF.getTextField_«tF++»().setValue(""+«be.name.toLowerCase».get«a.name.toFirstUpper»());
					«ELSE»
					uMF.getTextField_«tF++»().setValue(«be.name.toLowerCase».get«a.name.toFirstUpper»());
					«ENDIF»
					«ENDIF»
					«ENDFOR»
«««					uMF.getTextField_1().setValue(«be.name.toLowerCase».get«DomainCodeUtilities.getSecondAttribute(be).name.toFirstUpper»());
				}
			}
		
			public void set«relBe.name.toFirstUpper»«ass.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(relBe))» «relBe.name.toLowerCase») {
				«relBe.name.toFirstUpper»Controller.getInstance().set«relBe.name.toFirstUpper»«ass.name.toFirstUpper»(«relBe.name.toLowerCase»);
			}
		
			public void populate«be.name.toFirstUpper»«ass.name.toFirstUpper»Combo(List<«be.name.toFirstUpper»TO> list, «be.name.toFirstUpper»TO «ass.name.toLowerCase») {
				«be.name.toFirstUpper»«ass.name.toFirstUpper»Form uMF = Registry.get(«be.name.toFirstUpper»«ass.name.toFirstUpper»Form.ID);
				ComboBox combo = uMF.getComboBox_1();
				combo.removeAllItems();
				«be.name.toFirstUpper»TO u«ass.name.toFirstUpper» = null;
				for («be.name.toFirstUpper»TO to : list) {
					if (to.equals(«ass.name.toLowerCase»))
						u«ass.name.toFirstUpper» = to;
					combo.addItem(to);
				}
				
				«var type = DomainCodeUtilities.getType(DomainCodeUtilities.getID(relBe))»
				«IF type.equals("int")»
				if (uMF.get«relBe.name.toFirstUpper»() > 0) {
				«ELSE»
				«IF type.equals("String")»
				if (!uMF.get«relBe.name.toFirstUpper»().equals("")) {
				«ENDIF»
				«ENDIF»
					if (u«ass.name.toFirstUpper» != null)
						combo.setValue(u«ass.name.toFirstUpper»);
				}
			}
			
			«fsa.generateFile("/co/shift/"+packageName.toLowerCase+"/web/ext/"+be.name.toLowerCase+"/"+be.name.toFirstUpper+ass.name.toFirstUpper+"Form.java", PopUpMasterDetailTemplate
						.generate(packageName, be.name.toLowerCase, relBe, be, be.name.toFirstUpper+"Controller", "set"+relBe.name.toFirstUpper+""+ass.name.toFirstUpper, be.name.toFirstUpper+ass.name.toFirstUpper, "update"+ass.name.toFirstUpper+"FormFields"))»
			«ENDFOR»
		}
		«DomainCodeUtilities.endSection»
		«DomainCodeUtilities.endTemplate»
	'''
}