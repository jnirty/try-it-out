package com.tryitout.rectruitment.mobeelizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExe3 {

	@Test
	public void test() {
		// given
        int[] a = new int[]{1, 8, -3, 0, 1, 3, -2, 4, 5};
        int K = 6;
        int c = -1;

        // when
		c = new Exe3().complementary_pairs(K, a);

		// then
		int expected = 7;
		assertEquals(expected, c);

	}

}
