/**
 * TDD tests with Junit
 * @author Attilio Caravelli
 *
 */
package app.models;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.experimental.results.PrintableResult.testResult;
import static org.junit.experimental.results.ResultMatchers.hasFailureContaining;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.results.PrintableResult;
import org.junit.rules.ErrorCollector;


import app.models.Triangle;
import app.models.TriangleType;

public class TriangleTest {

	@Test
	public void basicsTest() {
		assertThat("Wrong basic test",TriangleType.EQUILATERAL, equalTo(new Triangle("1", "1", "1").getType()));
		assertThat("Wrong basic test",TriangleType.ISOSCELES, equalTo(new Triangle("1", "2", "1").getType()));
		assertThat("Wrong basic test",TriangleType.SCALENE, equalTo(new Triangle("1", "2", "3").getType()));

		assertThat("Wrong basic test",TriangleType.EQUILATERAL, equalTo(new Triangle("1.0", "1", "1").getType()));
		assertThat("Wrong basic test",TriangleType.ISOSCELES, equalTo(new Triangle("1", "2.0", "1").getType()));
		assertThat("Wrong basic test",TriangleType.SCALENE, equalTo(new Triangle("1", "2", "3.0").getType()));

		assertThat("Wrong basic test",TriangleType.EQUILATERAL, equalTo(new Triangle("1.01", "1.012", "1.016").getType()));
		assertThat("Wrong basic test",TriangleType.ISOSCELES, equalTo(new Triangle("1.02", "2.0", "1.0222222222").getType()));
		assertThat("Wrong basic test",TriangleType.SCALENE, equalTo(new Triangle("1", "2", "3.0").getType()));
	}

	@Test 
	public void edgeCaseTest_Result() {
		PrintableResult testResult= testResult(TriangleEdgeCaseTest.class);
		assertEquals(19, testResult.failureCount());
		assertThat(testResult, hasFailureContaining(Triangle.ERR_NULL_EMPTY_SIDE));
		assertThat(testResult, hasFailureContaining(Triangle.ERR_NUMERIC_SIDE));
		assertThat(testResult, hasFailureContaining(Triangle.ERR_NEGATIVE_OR_ZERO_LENGHT_SIDE));
		assertThat(testResult, hasFailureContaining(Triangle.ERR_INEQUALITY_VIOLATED));
	}	
	
	public static class TriangleEdgeCaseTest {

		@Rule
		public ErrorCollector collector= new ErrorCollector();

		@Test 
		public void edgeCaseTests() {
			// 19 Failures + 1 Correct
			//ERR_NULL_EMPTY_SIDE
			collector.checkSucceeds(() ->  equalTo(new Triangle(null, "1", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("", "1", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", null, "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("2", "1", null).getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("2", "1", "").getType()));
			
			//ERR_NUMERIC_SIDE
			collector.checkSucceeds(() -> equalTo(new Triangle("a", "1", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "a", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "2", "a").getType()));
			
			//ERR_NEGATIVE_OR_ZERO_LENGHT_SIDE
			collector.checkSucceeds(() ->  equalTo(new Triangle("-1", "1", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "-1", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "2", "-2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("-1.01", "1", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "-1.90", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "2", "-2.0988").getType()));
			
			//ERR_INEQUALITY_VIOLATED
			collector.checkSucceeds(() ->  equalTo(new Triangle("4", "1", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "4", "2").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "2", "4").getType()));
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "2", "3.01").getType()));
			
			//Correct -Rounded to the 2nd decimal digit
			collector.checkSucceeds(() ->  equalTo(new Triangle("1", "2", "3.001").getType()));
		}
	}
}
