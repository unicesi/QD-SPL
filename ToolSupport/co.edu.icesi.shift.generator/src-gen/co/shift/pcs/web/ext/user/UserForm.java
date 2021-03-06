package co.shift.pcs.web.ext.user;

import java.util.Date;


import com.vaadin.annotations.AutoGenerated;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class UserForm extends CustomComponent {
	
	@AutoGenerated
	private AbsoluteLayout mainLayout;
	
	@AutoGenerated
	private AbsoluteLayout absoluteLayout_1;
	@AutoGenerated
	private AbsoluteLayout absoluteLayout_2;
	
	
	@AutoGenerated
	private Button buttonDetailForm;

	@AutoGenerated
	private Button buttonRemoveDetail;

	@AutoGenerated
	private TabSheet tabSheet_1;
	
	public TabSheet getTabSheet_1() {
		return tabSheet_1;
	}

	@AutoGenerated
	private Label label_1;
	
	@AutoGenerated
	private Button buttonCreateUser;

	@AutoGenerated
	private TextField txtCc;
	
	public TextField getTxtCc() {
		return txtCc;
	}
	@AutoGenerated
	private TextField txtName;
	
	public TextField getTxtName() {
		return txtName;
	}
	@AutoGenerated
	private TextField txtCellphone;
	
	public TextField getTxtCellphone() {
		return txtCellphone;
	}
	@AutoGenerated
	private TextField txtPassword;
	
	public TextField getTxtPassword() {
		return txtPassword;
	}

	@AutoGenerated
	private Table table_1;
	
	public Table getTable_1() {
		return table_1;
	}
	
	@AutoGenerated
	private Table table_2;
	
	public Table getTable_2() {
		return table_2;
	}
	
	public static final String ID = "UserForm";
	
	public UserForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		table_1.addContainerProperty("Cc", String.class, null);
		table_1.addContainerProperty("Name", String.class, null);
		table_1.addContainerProperty("Cellphone", String.class, null);
		table_1.addContainerProperty("Password", String.class, null);
		table_1.setSelectable(true);
		table_1.setMultiSelect(false);
		table_1.setImmediate(true);
		
		table_1.addItemClickListener(new ItemClickListener() {

		@Override
		public void itemClick(ItemClickEvent event) {
			UserController.getInstance().listAllDetailsFromUser(
					event);
			}
		});
		table_2.addContainerProperty("Id", Integer.class, null);
		table_2.addContainerProperty("Description", String.class, null);
		table_2.addContainerProperty("Name", String.class, null);
		table_2.addContainerProperty("StartDate", Date.class, null);
		table_2.setSelectable(true);
		table_2.setMultiSelect(false);
		table_2.setImmediate(true);
		
		tabSheet_1.addTab(table_2, "Projects", null);
		
		buttonCreateUser.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UserController.getInstance().createUser();
			}
		});
		
		
		buttonDetailForm.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UserController.getInstance().popUpAddDetailForm();
			}
		});

		buttonRemoveDetail.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				UserController.getInstance().removeDetailRecord();
			}
		});
	}
	
	public void clearFormFields() {
		txtCc.setValue("");
		txtName.setValue("");
		txtCellphone.setValue("");
		txtPassword.setValue("");
	}
	
	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_1() {
		// common part: create layout
		absoluteLayout_1 = new AbsoluteLayout();
		absoluteLayout_1.setCaption("User");
		absoluteLayout_1.setImmediate(false);
		absoluteLayout_1.setWidth("340px");
		absoluteLayout_1.setHeight("230px");
		
		// txtCc
		txtCc = new TextField();
		txtCc.setCaption("Cc");
		txtCc.setImmediate(false);
		txtCc.setWidth("175px");
		txtCc.setHeight("-1px");
		txtCc.setRequired(true);
		absoluteLayout_1.addComponent(txtCc,
				"top:40px;left:0.0px;");
		// txtName
		txtName = new TextField();
		txtName.setCaption("Name");
		txtName.setImmediate(false);
		txtName.setWidth("175px");
		txtName.setHeight("-1px");
		txtName.setRequired(true);
		absoluteLayout_1.addComponent(txtName,
				"top:80px;left:0.0px;");
		// txtCellphone
		txtCellphone = new TextField();
		txtCellphone.setCaption("Cellphone");
		txtCellphone.setImmediate(false);
		txtCellphone.setWidth("175px");
		txtCellphone.setHeight("-1px");
		txtCellphone.setRequired(true);
		absoluteLayout_1.addComponent(txtCellphone,
				"top:120px;left:0.0px;");
		// txtPassword
		txtPassword = new TextField();
		txtPassword.setCaption("Password");
		txtPassword.setImmediate(false);
		txtPassword.setWidth("175px");
		txtPassword.setHeight("-1px");
		txtPassword.setRequired(true);
		absoluteLayout_1.addComponent(txtPassword,
				"top:160px;left:0.0px;");
		
		buttonCreateUser = new Button();
		buttonCreateUser.setCaption("Add");
		buttonCreateUser.setImmediate(true);
		buttonCreateUser.setWidth("65px");
		buttonCreateUser.setHeight("-1px");
		absoluteLayout_1.addComponent(buttonCreateUser, "top:200px;left:0px;");
		
		return absoluteLayout_1;
	}
	
	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("1024px");
		mainLayout.setHeight("500px");
		
		// top-level component properties
		setWidth("1024px");
		setHeight("500px");
		
		// table_1
		table_1 = new Table();
		table_1.setImmediate(false);
		table_1.setWidth("150px");
		table_1.setHeight("100.0%");
		mainLayout.addComponent(table_1,
				"top:18.0px;bottom:-18.0px;left:0.0px;");
				
		// absoluteLayout_1
		absoluteLayout_1 = buildAbsoluteLayout_1();
		mainLayout.addComponent(absoluteLayout_1, "top:17.0px;left:170.0px;");
		
		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("18px");
		label_1.setValue("User");
		mainLayout.addComponent(label_1, "top:0.0px;left:36.0px;");
		
		// absoluteLayout_2
		absoluteLayout_2 = buildAbsoluteLayout_2();
		mainLayout.addComponent(absoluteLayout_2, "top:255px;left:170.0px;");


		return mainLayout;
	}
	
	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_2() {
		// common part: create layout
		absoluteLayout_2 = new AbsoluteLayout();
		absoluteLayout_2.setCaption("Details");
		absoluteLayout_2.setImmediate(false);
		absoluteLayout_2.setWidth("505px");
		absoluteLayout_2.setHeight("200px");
		
		// tabSheet_1
		tabSheet_1 = buildTabSheet_1();
		absoluteLayout_2.addComponent(tabSheet_1, "top:2.0px;left:0.0px;");
		
		// buttonDetailForm
		buttonDetailForm = new Button();
		buttonDetailForm.setCaption("Add");
		buttonDetailForm.setImmediate(true);
		buttonDetailForm.setWidth("73px");
		buttonDetailForm.setHeight("-1px");
		absoluteLayout_2.addComponent(buttonDetailForm, "top:36.0px;left:419.0px;");

		// buttonRemoveDetail
		buttonRemoveDetail = new Button();
		buttonRemoveDetail.setCaption("Remove");
		buttonRemoveDetail.setImmediate(true);
		buttonRemoveDetail.setWidth("-1px");
		buttonRemoveDetail.setHeight("-1px");
		absoluteLayout_2.addComponent(buttonRemoveDetail, "top:65.0px;left:419.0px;");

		return absoluteLayout_2;
	}
	
	@AutoGenerated
	private TabSheet buildTabSheet_1() {
		// common part: create layout
		tabSheet_1 = new TabSheet();
		tabSheet_1.setImmediate(true);
		tabSheet_1.setWidth("409px");
		tabSheet_1.setHeight("198px");
		
		// table_2
		table_2 = new Table();
		table_2.setImmediate(false);
		table_2.setWidth("409px");
		table_2.setHeight("-1px");

		return tabSheet_1;
	}
	
}
