package app.utils;

/**
 * Utility for string
 * @author Attilio Caravelli
 *
 */
public class StringUtil {

	/**
	 * Check if the string in input is NULL or empty
	 * @param str
	 * @return TRUE if the string is NULL or empty, otherwise FALSE
	 */
	public static boolean hasNotContent(String str) {
		return str == null || str.isEmpty();
	}
}
