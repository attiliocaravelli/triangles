package app.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilTest {
	
	@Test
	public void hasNotContentTest() {
		assertTrue(StringUtil.hasNotContent(null));
		assertTrue(StringUtil.hasNotContent(""));
		assertFalse(StringUtil.hasNotContent("x"));
		assertFalse(StringUtil.hasNotContent(" "));
	}
}
