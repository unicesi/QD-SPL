/**
 * 
 */
package co.edu.uniandes.mdspl.util.resource;

import java.util.ResourceBundle;

/**
 * @author aromero
 *
 */
public class PropertiesManager {

	/** */
	private static ResourceBundle textResource;
	
	private static ResourceBundle errorMessageResource;
	
	private static boolean isPropertiesLoaded;
	
	/**
	 * 
	 */
	public PropertiesManager() {
		isPropertiesLoaded = false;
	}

	/**
	 * 
	 */
	private static void loadProperties(){
		textResource = ResourceBundle.getBundle("co.edu.uniandes.mdspl.resources.textLabels");
		errorMessageResource = ResourceBundle.getBundle("co.edu.uniandes.mdspl.resources.errorMessages");
		
		isPropertiesLoaded = true;
	}
	
	/**
	 * 
	 * @return
	 */
	private static boolean isLoadedProperties(){
		if(isPropertiesLoaded == false){
			loadProperties();
		}
		return isPropertiesLoaded;
	}
	
	/**
	 * 
	 * @param propertie
	 * @return
	 */
	public static String getTextPropertie(String propertie){
		if(isLoadedProperties()){
			return (String)textResource.getObject(propertie);
		}
		return null;
	}
	
	/**
	 * 
	 * @param propertie
	 * @return
	 */
	public static String getErrorMessage(String errorType){
		if(isLoadedProperties()){
			return (String)errorMessageResource.getObject(errorType);
		}
		return null;
	}
}
