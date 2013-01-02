package com.tryitout.rectruitment.mobeelizer;

/**
 * Write a function:
 * class Solution { public int ones_in_arith_seq(int N); }
 * that, given an integer N, returns the number of times the digit 1 occurs in decimal representations of all positive integers not exceeding N.
 * For example, given N = 13 the function should return 6, because:
 * all the positive integers that do not exceed 13 are 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 and 13;
 * digit 1 occurs six times altogether: once in number 1, once in number 10, twice in number 11, once in number 12 and once in number 13.
 * Assume that:
 * N is an integer within the range [−100,000,000..100,000,000].
 * Complexity:
 * expected worst-case time complexity is O(log(N)2);
 * expected worst-case space complexity is O(log(N)).
 */
public class Exe5 {


    public int ones_in_arith_seq(int N) {
        if (N > 100000000 || N < -100000000) {
            return -1;
        }
        int res = 0;

        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            res += s.split("1",-1).length-1;
        }
        return res;
    }

}
