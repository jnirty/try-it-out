package com.tryitout.rectruitment.amg;

/**
 * 
 * Given 2 arrays of integers: t1 & t2 of size respectively n1 & n2 which are
 * sorted descending write program that will create array t composed of elements
 * of t1 and t2 also sorted descending. Only using of mathematical operations
 * and structures (arrays, primitives) i allowed.
 * 
 */
public class Exec1 {

	/*
	 * Creates c from a and b sorted descending.
	 */
	public static int[] build(int[] a, int[] b) {
		int n1 = a.length;
		int n2 = b.length;

		int[] c = new int[n1 + n2];
		int i = 0, j = 0, indx = 0;

		while (true) {
			int x = a[i];
			int y = b[j];
			if (x > y) {
				c[indx++] = x;
				i++;
			} else if (y > x) {
				c[indx++] = y;
				j++;
			} else {
				c[indx++] = x;
				c[indx++] = y;
				i++;
				j++;
			}
			if (i == n1 || j == n2) {
				for (int n = i; n < a.length; n++) {
					c[indx++] = a[n];
				}
				for (int w = j; w < b.length; w++) {
					c[indx++] = b[w];
				}
				break;
			}

		}
		return c;

	}

}
