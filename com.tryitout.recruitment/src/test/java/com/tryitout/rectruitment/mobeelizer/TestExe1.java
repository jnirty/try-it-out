package com.tryitout.rectruitment.mobeelizer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestExe1 {

	@Test
	public void test() {
		// given
        int[] a = new int[]{-7, 1, 5, 2, -4, 3, 0};
		int c = -1;

		// when
		c = new Exe1().equi(a);

		// then
		int expected = 3;
		assertEquals(expected, c);

	}
    /*
  test	time	result
  example
  Test from the task description	0.260 s.	OK
  simple	0.270 s.	WRONG ANSWER
  got 1, but it is not equilibrium point, sum[0..0]=1, sum[2..5]=9
  extreme_large_numbers
  Sequence with extremly large numbers testing arithmetic overflow.	0.260 s.	WRONG ANSWER
  got 2, but it is not equilibrium point, sum[0..1]=4294967294, sum[3..3]=-2
  overflow_tests	0.270 s.	WRONG ANSWER
  got 2, but it is not equilibrium point, sum[0..1]=-2147483648, right sum (empty set)=0
  one_large
  one large number at the end of the sequence	0.260 s.	WRONG ANSWER
  got 4, but it is not equilibrium point, sum[0..3]=498, right sum (empty set)=0
  sum_0
  sequence with sum=0	0.260 s.	WRONG ANSWER
  got 2, but it is not equilibrium point, sum[0..1]=3, right sum (empty set)=0
  single
  single number	0.260 s.	OK
  empty
  Empty array	0.260 s.	OK
  combinations_of_two
  multiple runs, all combinations of {-1,0,1}^2	0.260 s.	WRONG ANSWER
  got 1, but it is not equilibrium point, sum[0..0]=-1, right sum (empty set)=0
  combinations_of_three
  multiple runs, all combinations of {-1,0,1}^3	0.260 s.	WRONG ANSWER
  got 2, but it is not equilibrium point, sum[0..1]=-2, right sum (empty set)=0
  small_pyramid	0.260 s.	WRONG ANSWER
  got 444, but it is not equilibrium point, sum[0..443]=99, right sum (empty set)=0
  large_long_sequence_of_ones	0.270 s.	WRONG ANSWER
  got 100003, but it is not equilibrium point, sum[0..100002]=100001, right sum (empty set)=0
  large_long_sequence_of_minus_ones	0.270 s.	WRONG ANSWER
  got 100002, but it is not equilibrium point, sum[0..100001]=-100000, right sum (empty set)=0
  medium_pyramid	0.270 s.	WRONG ANSWER
  got 40404, but it is not equilibrium point, sum[0..40403]=9999, right sum (empty set)=0
  large_pyramid
  Large performance test, O(n^2) solutions should fail.	0.300 s.	WRONG ANSWER
  got 201604, but it is not equilibrium point, sum[0..201603]=50175, right sum (empty set)=0
    */
}
