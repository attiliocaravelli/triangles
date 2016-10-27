package app.models;

import java.math.BigDecimal;

import app.utils.MathUtil;
import app.utils.StringUtil;

/**
 * Triangle class
 * 
 * @author Attilio Caravelli
 *
 */
public class Triangle {
	
	public static final String ERR_NULL_EMPTY_SIDE = "Empty or NULL sides are not permitted.";
	public static final String ERR_NUMERIC_SIDE = "Any side must be numeric.";
	public static final String ERR_NEGATIVE_OR_ZERO_LENGHT_SIDE = "Length of sides cannot be equal to or less than zero";
	public static final String ERR_INEQUALITY_VIOLATED = "Sum of any two sides must be larger than the remaining side";
	
	
	private final BigDecimal sideA, sideB, sideC;

	/**
	 * Constructs a triangle
	 * @param sideA
	 * @param sideB
	 * @param sideC
	 * @throws IllegalArgumentException
	 */
	public Triangle(String a, String b, String c) throws IllegalArgumentException {
		if (StringUtil.hasNotContent(a) || StringUtil.hasNotContent(b) || StringUtil.hasNotContent(c)) 
			throw new IllegalArgumentException(ERR_NULL_EMPTY_SIDE);
		
		try {
			this.sideA = MathUtil.format(new BigDecimal(a));
			this.sideB = MathUtil.format(new BigDecimal(b));
			this.sideC = MathUtil.format(new BigDecimal(c));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERR_NUMERIC_SIDE);
		}

		if (MathUtil.isNotPositive(sideA) || MathUtil.isNotPositive(sideB) || 
				MathUtil.isNotPositive(sideC)) 
			throw new IllegalArgumentException(ERR_NEGATIVE_OR_ZERO_LENGHT_SIDE);
	}

	public TriangleType getType() {
		if (isInequalityViolated(sideA, sideB, sideC) || 
			isInequalityViolated(sideB, sideA, sideC) || 
			isInequalityViolated(sideC, sideA, sideB)) { 
				throw new IllegalArgumentException(ERR_INEQUALITY_VIOLATED);
		}
		if (isEquilateral()) return TriangleType.EQUILATERAL;
		if (isIsosceles()) return TriangleType.ISOSCELES;
		return TriangleType.SCALENE;
	}

	private boolean isEquilateral() {
		return MathUtil.areEqual(sideA,sideB) && MathUtil.areEqual(sideB,sideC);
	}

	private boolean isIsosceles() {
		return MathUtil.areEqual(sideA,sideB) || 
				MathUtil.areEqual(sideB,sideC) || 
				MathUtil.areEqual(sideC,sideA);
	}

	private boolean isInequalityViolated(BigDecimal a, BigDecimal b, BigDecimal c) {
		return a.compareTo(b.add(c)) > 0;
	}
}
