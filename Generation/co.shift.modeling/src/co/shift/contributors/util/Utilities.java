package co.shift.contributors.util;

public class Utilities {

	public static String toFisrtUpper(String s) {
		char[] array = s.toCharArray();
		array[0] = Character.toUpperCase(array[0]);
		return new String(array);
	}
}
