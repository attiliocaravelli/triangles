package app.utils;

import java.math.BigDecimal;

/**
 * Utility for mathematical operations with decimal numbers
 * @author Attilio Caravelli
 *
 */
public class MathUtil {
	
	/**
	 * Check if the number in input is negative or zero 
	 * @param a
	 * @return TRUE if the number is negative or zero, otherwise FALSE 
	 */
	public static boolean isNotPositive(BigDecimal a) {
		return a.compareTo(BigDecimal.ZERO) <= 0;
	}
	
	/**
	 * Compare two numbers
	 * @param a
	 * @param b
	 * @return TRUE if the two numbers are equal, otherwise FALSE
	 */
	public static boolean areEqual(BigDecimal a, BigDecimal b) {
		return a.compareTo(b) == 0;
	}
	
	/**
	 * Formatting the decimal number in input
	 * @param x
	 * @return A new BigDecimal formatted with 2 decimal digits in rounding down
	 */
	public static BigDecimal format(BigDecimal x) {
		return x.setScale(2, BigDecimal.ROUND_DOWN);
	}
}
