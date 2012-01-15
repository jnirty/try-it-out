package com.tryitout.rectruitment.amg;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestExec3 {

	@Test
	public void testFindMaxOccurenceValue() {
		// given
		int[] a = { 1, 2, 6, 6, 6, 6, 2, 4, 4, 2, 3, 2, 2 };

		// when
		int maxOccurValue = Exec3.getMax(a);

		// then
		int expected = 6;
		assertEquals(expected, maxOccurValue);
	}

	@Test
	public void testFindMaxOccurenceValueWhenTwoSeriesOfEqualOccurence() {
		// given
		int[] a = { 1, 2, 6, 6, 6, 6, 2, 4, 4, 4, 4, 2, 3, 2, 2 };

		// when
		int maxOccurValue = Exec3.getMax(a);

		// then
		int expected = 6;
		assertEquals(expected, maxOccurValue);
	}
}
