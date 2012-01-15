package com.tryitout.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Compare LinkedList vs. ArrayList. Conclusions:
 * <ul>
 * <li>populating a list quicker for array list even given smal initial capacity
 * - getting n-th element quicker for array list</li>
 * <li>direct access to n-th index, no need to loop on linked like in linked
 * list.</li>
 * <li>putting n-th element slowlier in array list - need to switch all elements
 * from n+1 to the right, in linked list only dereference neighbouring links.</li>
 * </ul>
 */
public class Lists {
	private static final int INITIAL_ARRAY_SIZE = 10;
	private static final int ELEMENTS_NUM = 10000000;

	public static void main(String[] args) {

		List linkedList = new LinkedList();
		List arrayList = new ArrayList(INITIAL_ARRAY_SIZE);

		populateList(linkedList, "linked list");
		populateList(arrayList, "array list");

		findNthElement(linkedList);
		findNthElement(arrayList);

		insertNthElement(linkedList);
		insertNthElement(arrayList);
	}

	private static void populateList(List list, String msg) {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < ELEMENTS_NUM; i++) {
			list.add(new Object());
		}
		long delta = System.currentTimeMillis() - t1;
		System.out.println("Populating " + msg + " took [ms]: " + delta);
	}

	private static void findNthElement(List list) {
		final int INDEX = 10000;
		long t1 = System.nanoTime();

		list.get(INDEX);

		long delta = System.nanoTime() - t1;
		System.out.println("Getting n-th element took [nano s]: " + delta);
	}

	private static void insertNthElement(List list) {
		final int INDEX = 10000;
		long t1 = System.nanoTime();

		list.add(INDEX, new Object());

		long delta = System.nanoTime() - t1;
		System.out.println("Putting n-th element took [nano s]: " + delta);
	}
}
