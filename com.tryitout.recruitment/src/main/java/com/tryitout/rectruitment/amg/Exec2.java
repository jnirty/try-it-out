package com.tryitout.rectruitment.amg;

/*
 * Given a single dimension array t or integers print its aliments from end to beginning without iterating through array
 */
public class Exec2 {

	public static final char BLANK_CHAR = ' ';

	public static void print(int[] a, StringBuffer str) {

		print(a, a.length - 1, str);
	}

	private static void print(int[] a, int index, StringBuffer str) {

		if (index >= 0) {

			str.append(a[index]).append(BLANK_CHAR);
			print(a, --index, str);
		}
	}

}
