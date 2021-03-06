package co.shift.pcs.web.ext.user;

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

public class PopUpProjectUserForm extends CustomComponent {
	
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private ComboBox comboBox_1;
	@AutoGenerated
	private Button button_2;
	@AutoGenerated
	private Button button_1;
	
	@AutoGenerated
	private TextField textField_1;
	@AutoGenerated
	private TextField textField_2;
	@AutoGenerated
	private TextField textField_3;
	@AutoGenerated
	private TextField textField_4;
	
	public static final String ID = "PopUpProjectUserForm";
	
	private int project;
	
	public int getProject() {
		return project;
	}
	
	public void setProject(int project) {
		this.project = project;
	}
	
	public PopUpProjectUserForm() {
	
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		button_1.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UserController.getInstance().addUserToProject(project);
			}
		});
		
		button_2.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				clearFormFields();
				((PCSUI) Registry.get(PCSUI.UI)).closeSubWindow();
			}
		});
		textField_1.setEnabled(false);
		textField_2.setEnabled(false);
		textField_3.setEnabled(false);
		textField_4.setEnabled(false);
		
		comboBox_1.setInvalidAllowed(false);
		comboBox_1.setMultiSelect(false);
		comboBox_1.setNullSelectionAllowed(false);
		comboBox_1.setTextInputAllowed(false);
		comboBox_1.setImmediate(true);

		comboBox_1.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				UserController.getInstance()
						.updateProjectUsersFormFields();
			}
		});
	}
	
	public TextField getTextField_1() {
		return textField_1;
	}
	public TextField getTextField_2() {
		return textField_2;
	}
	public TextField getTextField_3() {
		return textField_3;
	}
	public TextField getTextField_4() {
		return textField_4;
	}
	
	public ComboBox getComboBox_1(){
		return comboBox_1;			
	}
	
	public void clearFormFields() {
		textField_1.setValue("");
		textField_2.setValue("");
		textField_3.setValue("");
		textField_4.setValue("");
	}
	
	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("200px");
		mainLayout.setHeight("240px");
		
		// top-level component properties
		setWidth("200px");
		setHeight("240px");
		
		// comboBox_1
		comboBox_1 = new ComboBox();
		comboBox_1.setCaption("Users");
		comboBox_1.setImmediate(false);
		comboBox_1.setWidth("-1px");
		comboBox_1.setHeight("-1px");
		mainLayout.addComponent(comboBox_1, "top:10.0px;left:20.0px;");
		
		// textField_1
		textField_1 = new TextField();
		textField_1.setCaption("Cc");
		textField_1.setImmediate(false);
		textField_1.setWidth("-1px");
		textField_1.setHeight("-1px");
		textField_1.setRequired(true);
		mainLayout.addComponent(textField_1, "top:45px;left:20.0px;");
		// textField_2
		textField_2 = new TextField();
		textField_2.setCaption("Name");
		textField_2.setImmediate(false);
		textField_2.setWidth("-1px");
		textField_2.setHeight("-1px");
		textField_2.setRequired(true);
		mainLayout.addComponent(textField_2, "top:85px;left:20.0px;");
		// textField_3
		textField_3 = new TextField();
		textField_3.setCaption("Cellphone");
		textField_3.setImmediate(false);
		textField_3.setWidth("-1px");
		textField_3.setHeight("-1px");
		textField_3.setRequired(true);
		mainLayout.addComponent(textField_3, "top:125px;left:20.0px;");
		// textField_4
		textField_4 = new TextField();
		textField_4.setCaption("Password");
		textField_4.setImmediate(false);
		textField_4.setWidth("-1px");
		textField_4.setHeight("-1px");
		textField_4.setRequired(true);
		mainLayout.addComponent(textField_4, "top:165px;left:20.0px;");
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Add");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		mainLayout.addComponent(button_1, "top:205px;left:24.0px;");
		
		// button_2
		button_2 = new Button();
		button_2.setCaption("Cancel");
		button_2.setImmediate(true);
		button_2.setWidth("-1px");
		button_2.setHeight("-1px");
		mainLayout.addComponent(button_2, "top:205px;left:84.0px;");
		
		return mainLayout;
	}
}
