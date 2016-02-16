package co.shift.pcs.web.ext.authorizer;

import co.shift.pcs.to.RoleTO;
import co.shift.pcs.to.UserTO;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.Table;

public class AuthorizerForm extends CustomComponent {
	@AutoGenerated
	private AbsoluteLayout mainLayout;

	@AutoGenerated
	private AbsoluteLayout absoluteLayout_4;

	@AutoGenerated
	private TabSheet tsData;

	@AutoGenerated
	private AbsoluteLayout absoluteLayout_3;

	@AutoGenerated
	private TabSheet tsDetails;

	@AutoGenerated
	private Button button_7;

	@AutoGenerated
	private Button button_6;

	private Table tableUsers;
	
	private Button buttonAddRole;
	private Button buttonRemoveRole;

	private Table tableRolesData;
	private Table tableRolesDetails;

	private Table tableServicesData;
	private Table tableServicesDetails;

	public static final String ID = "AF";
	
	public AuthorizerForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		tableUsers = new Table();
		tableUsers.setImmediate(true);
		tableUsers.setWidth("498px");
		tableUsers.setHeight("164px");
		tableUsers.addContainerProperty("CC", String.class, null);
		tableUsers.addContainerProperty("Name", String.class, null);
		tableUsers.setSelectable(true);
		tableUsers.setMultiSelect(false);
		tableUsers.setImmediate(true);

		tableUsers.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				UserTO user = (UserTO) tableUsers.getValue();
				if (user != null)
					AuthorizerController.getInstance().listUserRoles(
							user.getCc());
			}
		});

		tsData.addTab(tableUsers, "Users");

		AbsoluteLayout absoluteLayoutRoles = new AbsoluteLayout();
		absoluteLayoutRoles.setImmediate(false);
		absoluteLayoutRoles.setWidth("498px");
		absoluteLayoutRoles.setHeight("164px");

		tableRolesData = new Table();
		tableRolesData.setImmediate(true);
		tableRolesData.setWidth("380px");
		tableRolesData.setHeight("164px");
		tableRolesData.addContainerProperty("Name", String.class, null);
		tableRolesData.addContainerProperty("Description", String.class, null);
		tableRolesData.setSelectable(true);
		tableRolesData.setMultiSelect(false);
		tableRolesData.setImmediate(true);

		tableRolesData.addValueChangeListener(new ValueChangeListener() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				RoleTO role = (RoleTO) tableRolesData.getValue();
				if (role != null)
					AuthorizerController.getInstance().listRoleServices(
							role.getName());
			}
		});

		buttonAddRole = new Button();
		buttonAddRole.setCaption("Add");
		buttonAddRole.setImmediate(true);
		buttonAddRole.setWidth("73px");
		buttonAddRole.setHeight("-1px");

		buttonAddRole.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				AuthorizerController.getInstance().popUpRoleForm();
			}
		});

		buttonRemoveRole = new Button();
		buttonRemoveRole.setCaption("Remove");
		buttonRemoveRole.setImmediate(true);
		buttonRemoveRole.setWidth("-1px");
		buttonRemoveRole.setHeight("-1px");

		buttonRemoveRole.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				AuthorizerController.getInstance().deleteRole();
			}
		});

		tableRolesDetails = new Table();
		tableRolesDetails.setImmediate(true);
		tableRolesDetails.setWidth("406px");
		tableRolesDetails.setHeight("163px");
		tableRolesDetails.addContainerProperty("Name", String.class, null);
		tableRolesDetails.addContainerProperty("Description", String.class,
				null);
		tableRolesDetails.setSelectable(true);
		tableRolesDetails.setMultiSelect(false);
		tableRolesDetails.setImmediate(true);

		absoluteLayoutRoles.addComponent(tableRolesData);
		absoluteLayoutRoles.addComponent(buttonAddRole,
				"top:36.0px;left:400.0px;");
		absoluteLayoutRoles.addComponent(buttonRemoveRole,
				"top:65.0px;left:400.0px;");

		tsData.addTab(absoluteLayoutRoles, "Roles");
		tsDetails.addTab(tableRolesDetails, "User Roles");

		tableServicesData = new Table();
		tableServicesData.setImmediate(true);
		tableServicesData.setWidth("498px");
		tableServicesData.setHeight("164px");
		tableServicesData.addContainerProperty("Name", String.class, null);
		tableServicesData.addContainerProperty("Description", String.class,
				null);

		tableServicesDetails = new Table();
		tableServicesDetails.setImmediate(true);
		tableServicesDetails.setWidth("406px");
		tableServicesDetails.setHeight("163px");
		tableServicesDetails.addContainerProperty("Name", String.class, null);
		tableServicesDetails.addContainerProperty("Description", String.class,
				null);
		tableServicesDetails.setSelectable(true);
		tableServicesDetails.setMultiSelect(false);
		tableServicesDetails.setImmediate(true);

		tsData.addTab(tableServicesData, "Services");
		tsDetails.addTab(tableServicesDetails, "Role Services");

		tsData.addSelectedTabChangeListener(new SelectedTabChangeListener() {

			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {
				AuthorizerController.getInstance().dataTableSheetEvent();
			}
		});

		tsData.setSelectedTab(0);
		tsDetails.getTab(0).setEnabled(true);
		tsDetails.getTab(1).setEnabled(false);

		button_6.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				AuthorizerController.getInstance().popUpAddDetailForm();
			}
		});

		button_7.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				AuthorizerController.getInstance().removeDetailRecord();
			}
		});
	}
	
	public Button getButton_7() {
		return button_7;
	}

	public Button getButton_6() {
		return button_6;
	}

	public Table getTableUsers() {
		return tableUsers;
	}

	public void setTableUsers(Table tableUsers) {
		this.tableUsers = tableUsers;
	}

	public Table getTableRolesData() {
		return tableRolesData;
	}

	public void setTableRolesData(Table tableRolesData) {
		this.tableRolesData = tableRolesData;
	}

	public Table getTableRolesDetails() {
		return tableRolesDetails;
	}

	public void setTableRolesDetails(Table tableRolesDetails) {
		this.tableRolesDetails = tableRolesDetails;
	}

	public Table getTableServicesData() {
		return tableServicesData;
	}

	public void setTableServicesData(Table tableServicesData) {
		this.tableServicesData = tableServicesData;
	}

	public Table getTableServicesDetails() {
		return tableServicesDetails;
	}

	public void setTableServicesDetails(Table tableServicesDetails) {
		this.tableServicesDetails = tableServicesDetails;
	}

	public TabSheet getTsData() {
		return tsData;
	}

	public void setTsData(TabSheet tsData) {
		this.tsData = tsData;
	}

	public TabSheet getTsDetails() {
		return tsDetails;
	}

	public void setTsDetails(TabSheet tsDetails) {
		this.tsDetails = tsDetails;
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

		// absoluteLayout_3
		absoluteLayout_3 = buildAbsoluteLayout_3();
		mainLayout.addComponent(absoluteLayout_3, "top:240.0px;left:15.0px;");

		// absoluteLayout_4
		absoluteLayout_4 = buildAbsoluteLayout_4();
		mainLayout.addComponent(absoluteLayout_4, "top:15.0px;left:15.0px;");

		return mainLayout;
	}

	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_3() {
		// common part: create layout
		absoluteLayout_3 = new AbsoluteLayout();
		absoluteLayout_3.setCaption("Details");
		absoluteLayout_3.setImmediate(false);
		absoluteLayout_3.setWidth("505px");
		absoluteLayout_3.setHeight("200px");

		// button_6
		button_6 = new Button();
		button_6.setCaption("Add");
		button_6.setImmediate(true);
		button_6.setWidth("73px");
		button_6.setHeight("-1px");
		absoluteLayout_3.addComponent(button_6, "top:36.0px;left:419.0px;");

		// button_7
		button_7 = new Button();
		button_7.setCaption("Remove");
		button_7.setImmediate(true);
		button_7.setWidth("-1px");
		button_7.setHeight("-1px");
		absoluteLayout_3.addComponent(button_7, "top:65.0px;left:419.0px;");

		// tsDetails
		tsDetails = new TabSheet();
		tsDetails.setImmediate(true);
		tsDetails.setWidth("409px");
		tsDetails.setHeight("198px");
		absoluteLayout_3.addComponent(tsDetails);

		return absoluteLayout_3;
	}

	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_4() {
		// common part: create layout
		absoluteLayout_4 = new AbsoluteLayout();
		absoluteLayout_4.setCaption("Data");
		absoluteLayout_4.setImmediate(false);
		absoluteLayout_4.setWidth("505px");
		absoluteLayout_4.setHeight("200px");

		// tsData
		tsData = new TabSheet();
		tsData.setImmediate(true);
		tsData.setWidth("501px");
		tsData.setHeight("198px");
		absoluteLayout_4.addComponent(tsData, "top:2.0px;left:0.0px;");

		return absoluteLayout_4;
	}
}
