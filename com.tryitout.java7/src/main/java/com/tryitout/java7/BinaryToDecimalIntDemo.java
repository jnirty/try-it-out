package com.tryitout.java7;

//http://jlaskowski.blogspot.com/2011/12/kod-uzupenien-do-dwoch-w-javie.html?showComment=1325078096356#comment-c2865540978210516152
public class BinaryToDecimalIntDemo {

	static final char ZERO = '0';
	static final char ONE = '1';

	public static void main(String[] args) {
		for (int number = Integer.MIN_VALUE; number <= Integer.MIN_VALUE + 0xFFFF; number++) {
			String negativeNumber = Integer.toBinaryString(number);
			int intInDecimal = getIntInDecimal(negativeNumber);
			assert number == intInDecimal;
		}
		for (int number = Integer.MAX_VALUE; number >= Integer.MAX_VALUE - 0xFFFF; number--) {
			String negativeNumber = Integer.toBinaryString(number);
			int intInDecimal = getIntInDecimal(negativeNumber);
			assert number == intInDecimal;
		}
	}

	static int getIntInDecimal(String binary) {
		int sum = 0;
		boolean negative = false;
		char[] bits = binary.toCharArray();
		if (bits.length == Integer.SIZE) {
			if (isNegative(bits)) {
				negative = true;
				bits = subtractOne(invertBits(removeSignBit(bits)));
			}
		}
		for (int i = bits.length - 1, j = 0; i >= 0; i--, j++) {
			sum += calculateValueInBinaryRepAt(j, bits[i]);
		}
		return negative ? (sum == 0 ? Integer.MIN_VALUE : -sum) : sum;
	}

	private static char[] subtractOne(final char[] bits) {
		char[] newBits = new char[bits.length];
		System.arraycopy(bits, 0, newBits, 0, newBits.length);
		int i = newBits.length - 1;
		if (newBits[i] == ONE) {
			newBits[i] = ZERO;
		} else {
			newBits[i] = ONE;
			for (int j = i - 1; j >= 0; j--) {
				if (newBits[j] == ZERO) {
					newBits[j] = ONE;
				} else {
					newBits[j] = ZERO;
					break;
				}
			}
		}
		return newBits;
	}

	private static char[] invertBits(char[] bits) {
		char[] newBits = new char[bits.length];
		System.arraycopy(bits, 0, newBits, 0, newBits.length);
		for (int i = 0; i < newBits.length; i++) {
			newBits[i] = (newBits[i] == ZERO ? ONE : ZERO);
		}
		return newBits;
	}

	private static char[] removeSignBit(char[] bits) {
		char[] newBits = new char[bits.length - 1];
		System.arraycopy(bits, 1, newBits, 0, newBits.length);
		return newBits;
	}

	private static boolean isNegative(char[] bits) {
		return bits.length == Integer.SIZE && bits[0] == ONE;
	}

	private static double calculateValueInBinaryRepAt(int i, char c) {
		return Math.pow(2, i) * Character.getNumericValue(c);
	}

}