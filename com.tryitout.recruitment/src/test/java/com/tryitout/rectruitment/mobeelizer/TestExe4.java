package com.tryitout.rectruitment.mobeelizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExe4 {
    @Test
    public void test2() {
        // given
        int[] a = new int[]{2, 3, 1, 1, 3};
        int c = -1;

        // when
        c = new Exe4().cycle_length(a);

        // then
        int expected = 2;
        assertEquals(expected, c);

    }
	@Test
	public void test3() {
		// given
        int[] a = new int[]{2, 3, 1, 4, 1};
        int c = -1;

        // when
		c = new Exe4().cycle_length(a);

		// then
		int expected = 3;
		assertEquals(expected, c);

	}

}
