package co.shift.pcs.basic.ext.users;

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

public class UserManagerForm extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button button_2;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private TextField textField_1;
	@AutoGenerated
	private ComboBox comboBox_1;
	public static final String ID = "UMF";

	private int projectID;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public UserManagerForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		textField_1.setEnabled(false);
		comboBox_1.setInvalidAllowed(false);
		comboBox_1.setMultiSelect(false);
		comboBox_1.setNullSelectionAllowed(false);
		comboBox_1.setTextInputAllowed(false);
		comboBox_1.setImmediate(true);

		comboBox_1.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
//				UserTO user = (UserTO) comboBox_1.getValue();
//				if (user != null) {
//					textField_1.setValue(user.getName());
//				}
				UserFormController.getInstance().updateManagerFormFields();
			}
		});

		button_1.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UserFormController.getInstance()
						.setProjectManager(projectID);
			}
		});

		button_2.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				((PCSUI) Registry.get(PCSUI.UI)).closeSubWindow();
			}
		});
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public TextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(TextField textField_1) {
		this.textField_1 = textField_1;
	}

	public ComboBox getComboBox_1() {
		return comboBox_1;
	}

	public void setComboBox_1(ComboBox comboBox_1) {
		this.comboBox_1 = comboBox_1;
	}

	public void clearManagerFields() {
		textField_1.setValue("");
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("200px");
		mainLayout.setHeight("130px");

		// top-level component properties
		setWidth("200px");
		setHeight("130px");

		// comboBox_1
		comboBox_1 = new ComboBox();
		comboBox_1.setCaption("Manager ID");
		comboBox_1.setImmediate(false);
		comboBox_1.setWidth("-1px");
		comboBox_1.setHeight("-1px");
		mainLayout.addComponent(comboBox_1, "top:21.0px;left:20.0px;");

		// textField_1
		textField_1 = new TextField();
		textField_1.setCaption("Manager Name");
		textField_1.setImmediate(false);
		textField_1.setWidth("156px");
		textField_1.setHeight("-1px");
		mainLayout.addComponent(textField_1, "top:61.0px;left:20.0px;");

		// button_1
		button_1 = new Button();
		button_1.setCaption("Set");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		mainLayout.addComponent(button_1, "top:92.0px;left:34.0px;");

		// button_2
		button_2 = new Button();
		button_2.setCaption("Cancel");
		button_2.setImmediate(true);
		button_2.setWidth("-1px");
		button_2.setHeight("-1px");
		mainLayout.addComponent(button_2, "top:92.0px;left:92.0px;");

		return mainLayout;
	}
}
