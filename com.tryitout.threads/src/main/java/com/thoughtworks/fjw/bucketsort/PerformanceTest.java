package com.thoughtworks.fjw.bucketsort;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.fjw.utils.LargeInts;
import com.thoughtworks.fjw.utils.ListGenerator;

public class PerformanceTest {
	private static final Logger LOGGER = Logger.getLogger(PerformanceTest.class.getCanonicalName());
	private ListGenerator listGenerator;
	private int bucketCount;

	@Before
	public void setUp() {
		listGenerator = new ListGenerator();
		bucketCount = 23;
	}

	@Test
	public void testSynchronuousSort() {
		BucketSorter bucketSorter = new BucketSorter(new SequentialBucketSortHelper(), bucketCount);
		LOGGER.fine(bucketSorter.toString());

		List<Integer> input = listGenerator.createListOfNonNegativeIntegers(LargeInts.ONE_HUNDRED_THOUSAND, Integer.MAX_VALUE);
		LOGGER.fine(input.toString());

		long timeBefore = System.nanoTime();
		List<Integer> output = bucketSorter.sort(input);
		long timeAfter = System.nanoTime();
		System.out.println("Synch. sort, Delta time = " + (timeAfter - timeBefore) + "ns.");
	}

	@Test
	public void testParallelSort() {
		BucketSorter bucketSorter = new BucketSorter(new SequentialBucketSortHelper(), bucketCount);
		LOGGER.fine(bucketSorter.toString());

		List<Integer> input = listGenerator.createListOfNonNegativeIntegers(LargeInts.ONE_HUNDRED_THOUSAND, Integer.MAX_VALUE);
		LOGGER.fine(input.toString());

		long timeBefore = System.nanoTime();
		List<Integer> outputList = bucketSorter.sort(input);
		long timeAfter = System.nanoTime();
		System.out.println("Synch. sort, Delta time = " + (timeAfter - timeBefore) + "ns.");
	}
}
