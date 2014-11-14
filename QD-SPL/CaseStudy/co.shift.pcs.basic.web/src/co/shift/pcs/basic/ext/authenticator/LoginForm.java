package co.shift.pcs.basic.ext.authenticator;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class LoginForm extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private PasswordField passwordField_1;
	@AutoGenerated
	private TextField textField_1;
	
	public static final String ID = "LF";
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public LoginForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		button_1.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				LoginFormController.getInstance().authenticate();
			}
		});
	}

	public PasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public void setPasswordField_1(PasswordField passwordField_1) {
		this.passwordField_1 = passwordField_1;
	}

	public TextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(TextField textField_1) {
		this.textField_1 = textField_1;
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("170px");
		mainLayout.setHeight("140px");
		
		// top-level component properties
		setWidth("170px");
		setHeight("140px");
		
		// textField_1
		textField_1 = new TextField();
		textField_1.setCaption("User ID");
		textField_1.setImmediate(false);
		textField_1.setWidth("-1px");
		textField_1.setHeight("-1px");
		textField_1.setRequired(true);
		mainLayout.addComponent(textField_1, "top:20.0px;left:19.0px;");
		
		// passwordField_1
		passwordField_1 = new PasswordField();
		passwordField_1.setCaption("Password");
		passwordField_1.setImmediate(false);
		passwordField_1.setWidth("-1px");
		passwordField_1.setHeight("-1px");
		passwordField_1.setRequired(true);
		mainLayout.addComponent(passwordField_1, "top:60.0px;left:19.0px;");
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Login");
		button_1.setImmediate(false);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		mainLayout.addComponent(button_1, "top:94.0px;left:20.0px;");
		
		return mainLayout;
	}

}
