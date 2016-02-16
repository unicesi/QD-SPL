package co.shift.pcs.web;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry implementation class.
 */
public class Registry {

	/**
	 * Default constructor.
	 */
	private Registry() {
	}
	
	/**
	 * Map where the objects are stored.
	 */
	private static Map<String, Object> map = new HashMap<>();

	/**
	 * Returns the object with the given id.
	 * 
	 * @param key
	 *            the identifier
	 * @return the object or <code>null</code> if no match
	 */
	@SuppressWarnings("unchecked")
	public static <X> X get(String key) {
		return (X) map.get(key);
	}

	/**
	 * Returns a map of all registered objects.
	 * 
	 * @return the object map
	 */
	public static Map<String, Object> getAll() {
		return map;
	}

	/**
	 * Registers an object.
	 * 
	 * @param key
	 *            the identifier
	 * @param value
	 *            the object to be registered
	 */
	public static void register(String key, Object value) {
		map.put(key, value);
	}

	/**
	 * Unregisters an object.
	 * 
	 * @param key
	 *            the identifier
	 */
	public static void unregister(String key) {
		map.remove(key);
	}

	/**
	 * Unregisters all registered objects.
	 */
	public static void unregisterAll() {
		map.clear();
	}

}
