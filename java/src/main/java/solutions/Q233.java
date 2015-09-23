package solutions;

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * For example:
 *  Given n = 13,
 *  Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */

public class Q233 extends Solution {

    public int countDigitOne(int n) {
        int count = 0;
        int len = String.valueOf(n).length();
        for (int i = 0; i < len; ++i) {
            count += countDigitNumbers(n, i, 1);
        }
        return count;
    }

    // This is generic method for counting the number of 'digit' at position d counting from RHS and starting from 0
    private int countDigitNumbers(int n, int d, int digit) {
        long powerOf10 = (int)Math.pow(10, d);
        long nextPowerOf10 = powerOf10 * 10;
        long right = n % powerOf10;

        long roundDown = n - n % nextPowerOf10;
        long roundUp = roundDown + nextPowerOf10;

        int currDigit = (int)(n / powerOf10) % 10;
        if (currDigit < digit) {
            return (int)roundDown / 10;
        } else if (currDigit > digit) {
            return (int)roundUp / 10;
        } else {
            return (int)(roundDown / 10 + right + 1);
        }
    }
}
