package com.tryitout.rectruitment.mobeelizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExe2 {

	@Test
	public void test() {
		// given
        int[] a = new int[]{0,3,3,7,5,3,11,1};
		int c = -1;

		// when
		c = new Exe2().adjacent_point_pairs_count(a);

		// then
		int expected = 12;
		assertEquals(expected, c);

	}

}
