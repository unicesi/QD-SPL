package co.shift.templates.web.basic

import domainmetamodel.BusinessEntity
import co.shift.generators.domain.DomainCodeUtilities

class PopUpMasterDetailTemplate {
	
	def static generate(String appName, String packageName, BusinessEntity masterBe, BusinessEntity detailBe, String controllerName, String contractName, String className, String action) '''
		package co.shift.«appName.toLowerCase()».web.ext.«packageName.toLowerCase»;
		
		import co.shift.«appName.toLowerCase()».web.«appName.toUpperCase»UI;
		import co.shift.«appName.toLowerCase()».web.Registry;
		
		import com.vaadin.annotations.AutoGenerated;
		import com.vaadin.data.Property.ValueChangeEvent;
		import com.vaadin.data.Property.ValueChangeListener;
		import com.vaadin.ui.AbsoluteLayout;
		import com.vaadin.ui.Button;
		import com.vaadin.ui.Button.ClickEvent;
		import com.vaadin.ui.Button.ClickListener;
		import com.vaadin.ui.ComboBox;
		import com.vaadin.ui.CustomComponent;
		import com.vaadin.ui.TextField;
		
		public class «className»Form extends CustomComponent {
			
			@AutoGenerated
			private AbsoluteLayout mainLayout;
			@AutoGenerated
			private ComboBox comboBox_1;
			@AutoGenerated
			private Button button_2;
			@AutoGenerated
			private Button button_1;
			
			«var n= 1»
			«FOR att : detailBe.attributes»
			@AutoGenerated
			private TextField textField_«n++»;
			«ENDFOR»
			
			public static final String ID = "«className»Form";
			
			private «DomainCodeUtilities.getType(DomainCodeUtilities.getID(masterBe))» «masterBe.name.toLowerCase»;
			
			public «DomainCodeUtilities.getType(DomainCodeUtilities.getID(masterBe))» get«masterBe.name.toFirstUpper»() {
				return «masterBe.name.toLowerCase»;
			}
			
			public void set«masterBe.name.toFirstUpper»(«DomainCodeUtilities.getType(DomainCodeUtilities.getID(masterBe))» «masterBe.name.toLowerCase») {
				this.«masterBe.name.toLowerCase» = «masterBe.name.toLowerCase»;
			}
			
			public «className»Form() {
			
				buildMainLayout();
				setCompositionRoot(mainLayout);
				
				button_1.addClickListener(new ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						«controllerName.toFirstUpper».getInstance().«contractName»(«masterBe.name.toLowerCase»);
					}
				});
				
				button_2.addClickListener(new ClickListener() {

					@Override
					public void buttonClick(ClickEvent event) {
						clearFormFields();
						((«appName.toUpperCase»UI) Registry.get(«appName.toUpperCase»UI.UI)).closeSubWindow();
					}
				});
				«var tt = 1»
				«FOR att : detailBe.attributes»
				textField_«tt++».setEnabled(false);
				«ENDFOR»
				
				comboBox_1.setInvalidAllowed(false);
				comboBox_1.setMultiSelect(false);
				comboBox_1.setNullSelectionAllowed(false);
				comboBox_1.setTextInputAllowed(false);
				comboBox_1.setImmediate(true);
		
				comboBox_1.addValueChangeListener(new ValueChangeListener() {
		
					@Override
					public void valueChange(ValueChangeEvent event) {
						«controllerName.toFirstUpper».getInstance()
								.«action»();
					}
				});
			}
			
			«var l = 1»
			«FOR att : detailBe.attributes»
			public TextField getTextField_«l»() {
				return textField_«l++»;
			}
			«ENDFOR»
			
			public ComboBox getComboBox_1(){
				return comboBox_1;			
			}
			
			«var t = 1»
			public void clearFormFields() {
				«FOR att : detailBe.attributes»
				textField_«t++».setValue("");
				«ENDFOR»
			}
			
			«var height = 80»
			«FOR att : detailBe.attributes»
			«var cc = (height += 40)»
			«ENDFOR»
			@AutoGenerated
			private AbsoluteLayout buildMainLayout() {
				// common part: create layout
				mainLayout = new AbsoluteLayout();
				mainLayout.setImmediate(false);
				mainLayout.setWidth("200px");
				mainLayout.setHeight("«height»px");
				
				// top-level component properties
				setWidth("200px");
				setHeight("«height»px");
				
				// comboBox_1
				comboBox_1 = new ComboBox();
				comboBox_1.setCaption("«detailBe.name.toFirstUpper»s");
				comboBox_1.setImmediate(false);
				comboBox_1.setWidth("-1px");
				comboBox_1.setHeight("-1px");
				mainLayout.addComponent(comboBox_1, "top:10.0px;left:20.0px;");
				
				«var pos = 1»
				«var cPos = 45»
				«FOR att : detailBe.attributes»
				// textField_«pos»
				textField_«pos» = new TextField();
				textField_«pos».setCaption("«att.name.toFirstUpper»");
				textField_«pos».setImmediate(false);
				textField_«pos».setWidth("-1px");
				textField_«pos».setHeight("-1px");
				textField_«pos».setRequired(true);
				mainLayout.addComponent(textField_«pos++», "top:«cPos»px;left:20.0px;");
				«var cPosP = (cPos += 40)»
				«ENDFOR»
				
				// button_1
				button_1 = new Button();
				button_1.setCaption("Add");
				button_1.setImmediate(true);
				button_1.setWidth("-1px");
				button_1.setHeight("-1px");
				mainLayout.addComponent(button_1, "top:«cPos»px;left:24.0px;");
				
				// button_2
				button_2 = new Button();
				button_2.setCaption("Cancel");
				button_2.setImmediate(true);
				button_2.setWidth("-1px");
				button_2.setHeight("-1px");
				mainLayout.addComponent(button_2, "top:«cPos»px;left:84.0px;");
				
				return mainLayout;
			}
		}
	'''
}