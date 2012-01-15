package com.tryitout.rectruitment.amg;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestExec1 {

	@Test
	public void testBuildArrayFromArraysOfSameSize() {
		// given
		int[] a = { 9, 7, 6, 4, 2 };
		int[] b = { 8, 5, 3, 1, 0 };
		int[] c = null;

		// when
		c = Exec1.build(a, b);

		// then
		int[] expected = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		assertArrayEquals(expected, c);

	}

	@Test
	public void testBuildArrayFromArraysOfDiffrentSize() {
		// given
		int[] a = { 10, 9, 7, 6, 4, 2 };
		int[] b = { 8, 5, 3, 1 };
		int[] c = null;

		// when
		c = Exec1.build(a, b);

		// then
		int[] expected = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		assertArrayEquals(expected, c);

	}

	@Test
	public void testBuildArrayFromArraysOfDiffrentSizeAndElementsRepeat() {
		// given
		int[] a = { 10, 9, 7, 6, 4, 4, 2 };
		int[] b = { 9, 9, 8, 5, 3, 1, 1 };
		int[] c = null;

		// when
		c = Exec1.build(a, b);

		// then
		int[] expected = { 10, 9, 9, 9, 8, 7, 6, 5, 4, 4, 3, 2, 1, 1 };
		assertArrayEquals(expected, c);

	}
}
