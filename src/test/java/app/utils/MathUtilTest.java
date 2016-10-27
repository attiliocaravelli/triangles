package app.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class MathUtilTest {
	
	@Test
	public void isNotPositiveTest() {
		assertTrue(MathUtil.isNotPositive(new BigDecimal("-1")));
		assertTrue(MathUtil.isNotPositive(new BigDecimal("-1.03")));
		assertTrue(MathUtil.isNotPositive(new BigDecimal("0")));
		assertTrue(MathUtil.isNotPositive(new BigDecimal("0.0")));
		assertFalse(MathUtil.isNotPositive(new BigDecimal("1")));
		assertFalse(MathUtil.isNotPositive(new BigDecimal("1.3")));
	}
	
	@Test
	public void areEqualTest() {
		assertTrue(MathUtil.areEqual(new BigDecimal("-1"),new BigDecimal("-1")));
		assertTrue(MathUtil.areEqual(new BigDecimal("-1.03"),new BigDecimal("-1.03")));
		assertTrue(MathUtil.areEqual(new BigDecimal("1.03"),new BigDecimal("1.03")));
		assertTrue(MathUtil.areEqual(new BigDecimal("0.0"),new BigDecimal("0")));
		assertFalse(MathUtil.areEqual(new BigDecimal("-1.03"),new BigDecimal("-1.033")));
	}
	
	@Test
	public void formatTest() {
		assertEquals("-1.00", MathUtil.format(new BigDecimal("-1")).toString());
		assertEquals("1.00", MathUtil.format(new BigDecimal("1")).toString());
		assertEquals("1.03", MathUtil.format(new BigDecimal("1.033")).toString());
		assertEquals("1.09", MathUtil.format(new BigDecimal("1.099")).toString());
	}
}
