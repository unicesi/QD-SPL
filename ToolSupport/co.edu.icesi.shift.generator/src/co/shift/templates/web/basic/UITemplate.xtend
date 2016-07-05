package co.shift.templates.web.basic

class UITemplate {
	
	def static generate(String packageName) '''
		package co.shift.«packageName.toLowerCase()».web;
		
		import co.shift.«packageName.toLowerCase()».web.client.ContentPanel;
		import co.shift.«packageName.toLowerCase()».web.client.MenuPanel;
		
		import javax.servlet.annotation.WebServlet;
		
		import com.vaadin.annotations.Theme;
		import com.vaadin.annotations.VaadinServletConfiguration;
		import com.vaadin.server.VaadinRequest;
		import com.vaadin.server.VaadinServlet;
		import com.vaadin.ui.Component;
		import com.vaadin.ui.Notification.Type;
		import com.vaadin.ui.Notification;
		import com.vaadin.ui.UI;
		import com.vaadin.ui.VerticalLayout;
		import com.vaadin.ui.Window;
		
		/**
		 * Main UI class
		 */
		@SuppressWarnings("serial")
		public class «packageName.toUpperCase»UI extends UI {
		
			public static final String UI = "UI";
			public static final String USER = "USER";
			public static final String USER_SERVICES = "USER_SERVICES";
			public static final String MSG_NOT = "Notification";
			public static final String MSG_ERR = "Error";
			public static final String MENU_PANEL = "MenuPanel";
			public static final String CONTENT_PANEL = "ContentPanel";
		
			private Window subWindow;
			
			@WebServlet(value = "/*", asyncSupported = true)
		    @VaadinServletConfiguration(productionMode = false, ui = «packageName.toUpperCase»UI.class)
		    public static class Servlet extends VaadinServlet {
		    }

			@Override
			protected void init(VaadinRequest request) {
				final VerticalLayout layout = new VerticalLayout();
				layout.setMargin(true);
				layout.setSpacing(true);
		
				// Menu Panel
				MenuPanel menuPanel = new MenuPanel();
				layout.addComponent(menuPanel);
				Registry.register(MENU_PANEL, menuPanel);
		
				// Content Panel
				ContentPanel contentPanel = new ContentPanel();
				contentPanel.setImmediate(true);
				layout.addComponent(contentPanel);
				Registry.register(CONTENT_PANEL, contentPanel);
		
				setContent(layout);
		
				// SubWindow
				subWindow = new Window();
				VerticalLayout subContent = new VerticalLayout();
				subContent.setMargin(true);
				subWindow.setContent(subContent);
		
				Registry.register(UI, this);
		
				UIController.getInstance();
			}
		
			public void showNotification(String title, String message) {
				Notification.show(title, message, Type.TRAY_NOTIFICATION);
			}
		
			public void openSubWindow(String caption, Component component) {
				subWindow.setCaption(caption);
				VerticalLayout subContent = (VerticalLayout) subWindow.getContent();
				subContent.removeAllComponents();
				subContent.addComponent(component);
				subWindow.center();
				addWindow(subWindow);
			}
		
			public void closeSubWindow() {
				removeWindow(subWindow);
			}
		}
	'''
}