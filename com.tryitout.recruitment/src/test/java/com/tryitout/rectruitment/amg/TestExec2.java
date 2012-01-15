package com.tryitout.rectruitment.amg;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestExec2 {

	@Test
	public void testReverseDisplay() {
		// given
		int[] a = { 1, 2, 3, 4, 5, 6 };
		StringBuffer str = new StringBuffer();

		// when
		Exec2.print(a, str);

		// then
		String expected = "6 5 4 3 2 1 ";
		assertEquals(expected, str.toString());
	}
}
