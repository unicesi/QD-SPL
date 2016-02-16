package co.shift.templates.web.basic

class GlobalJNDITemplate {
	
	def static generate(String packageName) '''
		package co.shift.«packageName.toLowerCase()».util.beanlocator;
		
		import java.util.Properties;

		import javax.ejb.Singleton;
		import javax.ejb.Stateful;
		import javax.ejb.Stateless;
		
		public class GlobalJNDIName {

			private StringBuilder builder;
			private final static String PREFIX = "java:global";
			private final static String SEPARATOR = "/";
			private final static String PROPERTY_FILE = "/global.jndi";
			private final static String MODULE_NAME_KEY = "module.name";
			private final static String APP_NAME_KEY = "application.name";
			private Properties globalConfiguration;
			private String appName;
			private String moduleName;
			private String beanName;
			private String businessInterfaceName;
		
			public GlobalJNDIName() {
				this.builder = new StringBuilder();
				this.builder.append(PREFIX).append(SEPARATOR);
				this.globalConfiguration = new Properties();
				try {
					this.globalConfiguration.load(this.getClass().getResourceAsStream(
							PROPERTY_FILE));
				} catch (Exception ex) {
					System.out.println("Cannot load configuration: " + ex);
				}
				this.appName = this.globalConfiguration.getProperty(APP_NAME_KEY);
				this.moduleName = this.globalConfiguration.getProperty(MODULE_NAME_KEY);
			}
		
			public GlobalJNDIName withAppName(String appName) {
				this.appName = appName;
				return this;
			}
		
			public GlobalJNDIName withModuleName(String moduleName) {
				this.moduleName = moduleName;
				return this;
			}
		
			public GlobalJNDIName withBeanName(String beanName) {
				this.beanName = beanName;
				return this;
			}
		
			public GlobalJNDIName withBeanName(Class beanClass) {
				return withBeanName(computeBeanName(beanClass));
			}
		
			public GlobalJNDIName withBusinessInterface(Class interfaze) {
				this.businessInterfaceName = interfaze.getName();
				return this;
			}
		
			String computeBeanName(Class beanClass) {
				Stateless stateless = (Stateless) beanClass
						.getAnnotation(Stateless.class);
				if (stateless != null && isNotEmpty(stateless.name())) {
					return stateless.name();
				}
				Stateful stateful = (Stateful) beanClass.getAnnotation(Stateful.class);
				if (stateful != null && isNotEmpty(stateful.name())) {
					return stateful.name();
				}
				Singleton singleton = (Singleton) beanClass
						.getAnnotation(Singleton.class);
				if (singleton != null && isNotEmpty(singleton.name())) {
					return singleton.name();
				}
				return beanClass.getSimpleName();
			}
		
			private boolean isNotEmpty(String name) {
				return (name != null && !name.isEmpty());
			}
		
			public String asString() {
				if (appName != null) {
					this.builder.append(appName).append(SEPARATOR);
				}
				if (moduleName != null)
					this.builder.append(moduleName).append(SEPARATOR);
				if (beanName != null)
					this.builder.append(beanName);
				if (businessInterfaceName != null) {
					this.builder.append("!").append(businessInterfaceName);
				}
				return this.builder.toString();
			}
		
			public <T> T locate(Class<T> clazz) {
				return BeanLocator.lookup(clazz, asString());
			}
		
			public Object locate() {
				return BeanLocator.lookup(asString());
			}
		}
	'''
}