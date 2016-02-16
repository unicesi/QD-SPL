package co.shift.pcs.web.ext.authorizer;

import co.shift.pcs.web.PCSUI;
import co.shift.pcs.web.Registry;

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

public class PopUpRoleForm extends CustomComponent {
	
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button button_2;
	@AutoGenerated
	private Button button_1;
	
	@AutoGenerated
	private TextField textField_1;
	@AutoGenerated
	private TextField textField_2;
	
	public static final String ID = "PopUpRole";
	
	
	
	public PopUpRoleForm() {
	
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		button_1.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				AuthorizerController.getInstance().createRole();
			}
		});
		
		button_2.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				clearFormFields();
				((PCSUI) Registry.get(PCSUI.UI)).closeSubWindow();
			}
		});
	}
	
	public TextField getTextField_1() {
		return textField_1;
	}
	public TextField getTextField_2() {
		return textField_2;
	}
	
	public void clearFormFields() {
		textField_1.setValue("");
		textField_2.setValue("");
	}
	
	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("200px");
		mainLayout.setHeight("120px");
		
		// top-level component properties
		setWidth("200px");
		setHeight("120px");
		
		// textField_1
		textField_1 = new TextField();
		textField_1.setCaption("Name");
		textField_1.setImmediate(false);
		textField_1.setWidth("-1px");
		textField_1.setHeight("-1px");
		textField_1.setRequired(true);
		mainLayout.addComponent(textField_1, "top:35px;left:20.0px;");
		// textField_2
		textField_2 = new TextField();
		textField_2.setCaption("Description");
		textField_2.setImmediate(false);
		textField_2.setWidth("-1px");
		textField_2.setHeight("-1px");
		textField_2.setRequired(true);
		mainLayout.addComponent(textField_2, "top:70px;left:20.0px;");
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Add");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		mainLayout.addComponent(button_1, "top:105px;left:24.0px;");
		
		// button_2
		button_2 = new Button();
		button_2.setCaption("Cancel");
		button_2.setImmediate(true);
		button_2.setWidth("-1px");
		button_2.setHeight("-1px");
		mainLayout.addComponent(button_2, "top:105px;left:84.0px;");
		
		return mainLayout;
	}
}
