package co.shift.pcs.basic.ext.projects;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import co.shift.pcs.basic.ext.users.UserFormController;
import co.shift.pcs.basic.ext.users.UserManagerForm;
import co.shift.pcs.basic.web.PCSUI;
import co.shift.pcs.basic.web.Registry;
import co.shift.pcs.to.ProjectTO;
import co.shift.pcs.to.UserTO;

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

public class ProjectForm extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,15","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":true,"snappingDistance":5} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;

	@AutoGenerated
	private AbsoluteLayout absoluteLayout_4;

	@AutoGenerated
	private Button button_4;

	@AutoGenerated
	private TextField textField_3;

	@AutoGenerated
	private TextField textField_2;

	@AutoGenerated
	private AbsoluteLayout absoluteLayout_3;

	@AutoGenerated
	private Button button_7;

	@AutoGenerated
	private Button button_6;

	@AutoGenerated
	private TabSheet tabSheet_1;

	@AutoGenerated
	private Table table_3;

	@AutoGenerated
	private Table table_2;

	@AutoGenerated
	private Label label_1;

	@AutoGenerated
	private AbsoluteLayout absoluteLayout_2;

	@AutoGenerated
	private Button button_3;

	@AutoGenerated
	private Button button_2;

	@AutoGenerated
	private Button button_1;

	@AutoGenerated
	private TextField textField_1;

	@AutoGenerated
	private TextArea textArea_1;

	@AutoGenerated
	private PopupDateField popupDateField_1;

	@AutoGenerated
	private Table table_1;

	public static final String ID = "PF";

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor.
	 */
	public ProjectForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		table_1.addContainerProperty("ID", Integer.class, null);
		table_1.addContainerProperty("Name", String.class, null);
		table_1.setSelectable(true);
		table_1.setMultiSelect(false);
		table_1.setImmediate(true);

		table_1.addItemClickListener(new ItemClickListener() {

			@Override
			public void itemClick(ItemClickEvent event) {
				ProjectFormController.getInstance().listAllDetailsFromProject(
						event);
			}
		});

		button_1.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ProjectFormController.getInstance().createProject();
			}
		});

		table_2.addContainerProperty("Name", String.class, null);
		table_2.addContainerProperty("C.C.", String.class, null);
		table_2.addContainerProperty("Cellphone", String.class, null);
		table_2.setSelectable(true);
		table_2.setMultiSelect(false);
		table_2.setImmediate(true);

		table_3.addContainerProperty("ID", Integer.class, null);
		table_3.addContainerProperty("Name", String.class, null);
		table_3.addContainerProperty("Description", String.class, null);
		table_3.addContainerProperty("Impact %", BigDecimal.class, null);
		table_3.addContainerProperty("Probability %", BigDecimal.class, null);
		table_3.setSelectable(true);
		table_3.setMultiSelect(false);
		table_3.setImmediate(true);

		tabSheet_1.addTab(table_2, "Users", null);
		tabSheet_1.addTab(table_3, "Risks", null);

		button_2.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ProjectFormController.getInstance().updateProject();
			}
		});

		button_3.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ProjectFormController.getInstance().deleteProject();
			}
		});

		textField_2.setEnabled(false);
		textField_3.setEnabled(false);

		button_4.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ProjectFormController.getInstance().popUpManagerForm();
			}
		});

		button_6.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ProjectFormController.getInstance().popUpAddDetailForm();
			}
		});

		button_7.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ProjectFormController.getInstance().removeDetailRecord();
			}
		});
	}

	public void clearFormFields() {
		textField_1.setValue("");
		textArea_1.setValue("");
		popupDateField_1.setValue(null);
	}

	public void clearManagerFields() {
		textField_2.setValue("");
		textField_3.setValue("");
	}

	public void updateManagerFields(UserTO manager) {
		textField_2.setValue(manager.getIdNumber());
		textField_3.setValue(manager.getName());
	}

	public PopupDateField getPopupDateField_1() {
		return popupDateField_1;
	}

	public void setPopupDateField_1(PopupDateField popupDateField_1) {
		this.popupDateField_1 = popupDateField_1;
	}

	public TextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(TextField textField_3) {
		this.textField_3 = textField_3;
	}

	public TextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(TextField textField_2) {
		this.textField_2 = textField_2;
	}

	public TabSheet getTabSheet_1() {
		return tabSheet_1;
	}

	public void setTabSheet_1(TabSheet tabSheet_1) {
		this.tabSheet_1 = tabSheet_1;
	}

	public Table getTable_3() {
		return table_3;
	}

	public void setTable_3(Table table_3) {
		this.table_3 = table_3;
	}

	public Table getTable_2() {
		return table_2;
	}

	public void setTable_2(Table table_2) {
		this.table_2 = table_2;
	}

	public TextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(TextField textField_1) {
		this.textField_1 = textField_1;
	}

	public TextArea getTextArea_1() {
		return textArea_1;
	}

	public void setTextArea_1(TextArea textArea_1) {
		this.textArea_1 = textArea_1;
	}

	public Table getTable_1() {
		return table_1;
	}

	public void setTable_1(Table table_1) {
		this.table_1 = table_1;
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
		table_1.setWidth("120px");
		table_1.setHeight("100.0%");
		mainLayout.addComponent(table_1,
				"top:18.0px;bottom:-18.0px;left:0.0px;");

		// absoluteLayout_2
		absoluteLayout_2 = buildAbsoluteLayout_2();
		mainLayout.addComponent(absoluteLayout_2, "top:17.0px;left:140.0px;");

		// label_1
		label_1 = new Label();
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("18px");
		label_1.setValue("Projects");
		mainLayout.addComponent(label_1, "top:0.0px;left:36.0px;");

		// absoluteLayout_3
		absoluteLayout_3 = buildAbsoluteLayout_3();
		mainLayout.addComponent(absoluteLayout_3, "top:280.0px;left:139.0px;");

		// absoluteLayout_4
		absoluteLayout_4 = buildAbsoluteLayout_4();
		mainLayout.addComponent(absoluteLayout_4, "top:17.0px;left:495.0px;");

		return mainLayout;
	}

	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_2() {
		// common part: create layout
		absoluteLayout_2 = new AbsoluteLayout();
		absoluteLayout_2.setCaption("Project");
		absoluteLayout_2.setImmediate(false);
		absoluteLayout_2.setWidth("340px");
		absoluteLayout_2.setHeight("238px");

		// popupDateField_1
		popupDateField_1 = new PopupDateField();
		popupDateField_1.setCaption("Start Date");
		popupDateField_1.setImmediate(false);
		popupDateField_1.setWidth("-1px");
		popupDateField_1.setHeight("-1px");
		popupDateField_1.setRequired(true);
		absoluteLayout_2.addComponent(popupDateField_1,
				"top:62.0px;left:0.0px;");

		// textArea_1
		textArea_1 = new TextArea();
		textArea_1.setCaption("Description");
		textArea_1.setImmediate(false);
		textArea_1.setWidth("100.0%");
		textArea_1.setHeight("79px");
		textArea_1.setRequired(true);
		absoluteLayout_2.addComponent(textArea_1,
				"top:102.0px;right:0.0px;left:0.0px;");

		// textField_1
		textField_1 = new TextField();
		textField_1.setCaption("Name");
		textField_1.setImmediate(false);
		textField_1.setWidth("175px");
		textField_1.setHeight("-1px");
		textField_1.setRequired(true);
		absoluteLayout_2.addComponent(textField_1, "top:22.0px;left:0.0px;");

		// button_1
		button_1 = new Button();
		button_1.setCaption("Add");
		button_1.setImmediate(true);
		button_1.setWidth("-1px");
		button_1.setHeight("-1px");
		absoluteLayout_2.addComponent(button_1, "top:195.0px;left:0.0px;");

		// button_2
		button_2 = new Button();
		button_2.setCaption("Update");
		button_2.setImmediate(true);
		button_2.setWidth("-1px");
		button_2.setHeight("-1px");
		absoluteLayout_2.addComponent(button_2, "top:195.0px;left:62.0px;");

		// button_3
		button_3 = new Button();
		button_3.setCaption("Delete");
		button_3.setImmediate(true);
		button_3.setWidth("-1px");
		button_3.setHeight("-1px");
		absoluteLayout_2.addComponent(button_3, "top:195.0px;left:141.0px;");

		return absoluteLayout_2;
	}

	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_3() {
		// common part: create layout
		absoluteLayout_3 = new AbsoluteLayout();
		absoluteLayout_3.setCaption("Details");
		absoluteLayout_3.setImmediate(false);
		absoluteLayout_3.setWidth("505px");
		absoluteLayout_3.setHeight("200px");

		// tabSheet_1
		tabSheet_1 = buildTabSheet_1();
		absoluteLayout_3.addComponent(tabSheet_1, "top:2.0px;left:0.0px;");

		// button_6
		button_6 = new Button();
		button_6.setCaption("Add");
		button_6.setImmediate(false);
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

		return absoluteLayout_3;
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

		// table_3
		table_3 = new Table();
		table_3.setImmediate(false);
		table_3.setWidth("409px");
		table_3.setHeight("-1px");

		return tabSheet_1;
	}

	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout_4() {
		// common part: create layout
		absoluteLayout_4 = new AbsoluteLayout();
		absoluteLayout_4.setCaption("Manager");
		absoluteLayout_4.setImmediate(false);
		absoluteLayout_4.setWidth("150px");
		absoluteLayout_4.setHeight("238px");

		// textField_2
		textField_2 = new TextField();
		textField_2.setCaption("Manager ID");
		textField_2.setImmediate(false);
		textField_2.setWidth("-1px");
		textField_2.setHeight("-1px");
		absoluteLayout_4.addComponent(textField_2, "top:22.0px;left:7.0px;");

		// textField_3
		textField_3 = new TextField();
		textField_3.setCaption("Manager Name");
		textField_3.setImmediate(false);
		textField_3.setWidth("-1px");
		textField_3.setHeight("-1px");
		absoluteLayout_4.addComponent(textField_3, "top:61.0px;left:7.0px;");

		// button_4
		button_4 = new Button();
		button_4.setCaption("Set Manager");
		button_4.setImmediate(true);
		button_4.setWidth("-1px");
		button_4.setHeight("-1px");
		absoluteLayout_4.addComponent(button_4, "top:93.0px;left:24.0px;");

		return absoluteLayout_4;
	}
}
