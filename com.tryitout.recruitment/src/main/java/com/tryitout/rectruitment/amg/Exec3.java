package com.tryitout.rectruitment.amg;

/**
 * Given an array of integers t, find an integer which has maximum number of
 * occurrences within a series, e.g.: {1, 2, 3, 3, 3, 2, 4, 4, 2, 2 } => 3
 */
public class Exec3 {
	// TODO: This method doe snot take into account scenario when there are more
	// then one series of equal occurrences, then only integer of the first series is returned
	public static int getMax(int[] array) {

		int actualMaxValue = -1;
		int actualMaxOccur = -1;

		Stack stack = new Stack(array.length);

		for (int i = 0; i < array.length; i++) {

			int thisInt = array[i];

			if (i > 0 && stack.size() > 0) {
				int lastInt = stack.getTop();
				if (lastInt == thisInt) {
					stack.put(thisInt);
				} else {
					int[] occurencesNumAndValue = stack.compress();
					int occur = occurencesNumAndValue[1];
					int value = occurencesNumAndValue[0];
					if (actualMaxOccur < occur) {
						actualMaxOccur = occur;
						actualMaxValue = value;
					}
				}
			} else {
				stack.put(thisInt);
			}
			stack.put(array[i]);

		}

		return actualMaxValue;
	}
}

class Stack {
	int[] arr = null;
	int index = 0;

	Stack(int size) {
		arr = new int[size];
	}

	public int[] compress() {
		if (size() == 0) {
			throw new RuntimeException("Stack is empty, cannot compress.");
		}
		int occur = size();
		int value = arr[0];
		index = 0;
		return new int[] { value, occur };
	}

	public void put(int x) {
		arr[index++] = x;
	}

	public int pop() {
		return arr[index--];
	}

	public int getTop() {

		int ret = 0;
		if (index > 0) {
			ret = arr[index - 1];
		} else {
			throw new RuntimeException("Stack is empty, cannot get top.");
		}
		return ret;
	}

	public int size() {
		return index;
	}
}