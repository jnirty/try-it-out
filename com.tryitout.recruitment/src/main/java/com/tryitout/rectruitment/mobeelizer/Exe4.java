package com.tryitout.rectruitment.mobeelizer;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The array consists only of integers in the range [0..N−1]. Each element of the array can be treated as a pointer to another element of the array: if A[K] = M then element A[K] points to A[M].
 * The array defines a sequence of jumps of a pawn as follows:
 * initially, the pawn is located at position 0;
 * on each jump the pawn moves from its current position K to A[K];
 * the pawn jumps forever.
 * Since the number of possible positions of the pawn is finite, eventually, after some initial sequence of jumps, the pawn enters a cycle. Compute the length of this cycle.
 * For example, for the following array A:
 * A[0] = 2    A[1] = 3    A[2] = 1
 * A[3] = 1    A[4] = 3
 * <p/>
 * consecutive positions of the pawn are: 0, 2, 1, 3, 1, 3, 1, 3, ..., and the length of the cycle is 2.
 * Write a function:
 * class Solution { public int cycle_length(int[] A); }
 * that, given a non-empty zero-indexed array A consisting of N integers in the range [0..N−1], returns the length of the cycle that the pawn eventually enters, as described above. For example, given the array shown above, the function should return 2.
 * Assume that:
 * N is an integer within the range [1..200,000];
 * each element of array A is an integer within the range [0..N−1].
 * Complexity:
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class Exe4 {


    public int cycle_length(int[] A) {
        if (A.length > 200000) {
            return -1;
        }
        return countLength(A, 0, 0); // start counting from index=0, initial step = 0
    }

    int countLength(int[] A, int ind, int step) {
        // replace element that was already passed with negative count, e.g. -1, -2, -3...
        // when negative value found means this path is starting to cycle then count difference between step and negative count
        if (A[ind] > 0) {
            int nextIndex = A[ind];
            A[ind]=0-step-1;  // first step = 0 so we want negative value therefore subtract one
            return countLength(A, nextIndex, ++step);
        }
        return step+1+A[ind];
    }
}
