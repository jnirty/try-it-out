package com.tryitout.rectruitment.mobeelizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExe5 {

	@Test
	public void test13() {
		// given
        int N = 13;
        int c = -1;

        // when
		c = new Exe5().ones_in_arith_seq(N);

		// then
		int expected = 6;
		assertEquals(expected, c);

	}

    @Test
    public void test21() {
        // given
        int N = 21;
        int c = -1;

        // when
        c = new Exe5().ones_in_arith_seq(N);

        // then
        int expected = 13;
        assertEquals(expected, c);

    }
}
