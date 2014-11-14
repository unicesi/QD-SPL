package co.shift.pcs.basic.ext.authorizer;

import co.shift.pcs.basic.web.PCSUI;
import co.shift.pcs.basic.web.Registry;

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

public class PopUpUserRoleForm extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private ComboBox comboBox_1;
	@AutoGenerated
	private Button button_2;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private TextField textField_2;
	@AutoGenerated
	private TextField textField_1;
	public static final String ID = "PURF";

	private String userID;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public PopUpUserRoleForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		button_1.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				AuthorizerController.getInstance().addRoleToUser(userID);
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

		comboBox_1.setInvalidAllowed(false);
		comboBox_1.setMultiSelect(false);
		comboBox_1.setNullSelectionAllowed(false);
		comboBox_1.setTextInputAllowed(false);
		comboBox_1.setImmediate(true);

		comboBox_1.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				AuthorizerController.getInstance().updateUserRolesFormFields();
			}
		});
	}

	public String getUserId() {
		return userID;
	}

	public void setUserId(String userId) {
		this.userID = userId;
	}

	public ComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(ComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public TextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(TextField textField_2) {
		this.textField_2 = textField_2;
	}

	public TextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(TextField textField_1) {
		this.textField_1 = textField_1;
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
		mainLayout.setWidth("180px");
		mainLayout.setHeight("220px");

		// top-level component properties
		setWidth("180px");
		setHeight("220px");

		// textField_1
		textField_1 = new TextField();
		textField_1.setCaption("Name");
		textField_1.setImmediate(false);
		textField_1.setWidth("-1px");
		textField_1.setHeight("-1px");
		textField_1.setRequired(true);
		mainLayout.addComponent(textField_1, "top:64.0px;left:20.0px;");

		// textField_2
		textField_2 = new TextField();
		textField_2.setCaption("Description");
		textField_2.setImmediate(false);
		textField_2.setWidth("-1px");
		textField_2.setHeight("-1px");
		textField_2.setRequired(true);
		mainLayout.addComponent(textField_2, "top:105.0px;left:20.0px;");

		// button_1
		button_1 = new Button();
		button_1.setCaption("Add");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		mainLayout.addComponent(button_1, "top:176.0px;left:24.0px;");

		// button_2
		button_2 = new Button();
		button_2.setCaption("Cancel");
		button_2.setImmediate(true);
		button_2.setWidth("-1px");
		button_2.setHeight("-1px");
		mainLayout.addComponent(button_2, "top:176.0px;left:84.0px;");

		// comboBox_1
		comboBox_1 = new ComboBox();
		comboBox_1.setCaption("Roles");
		comboBox_1.setImmediate(false);
		comboBox_1.setWidth("-1px");
		comboBox_1.setHeight("-1px");
		mainLayout.addComponent(comboBox_1, "top:20.0px;left:19.0px;");

		return mainLayout;
	}

}
