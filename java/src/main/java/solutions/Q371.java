package solutions;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example:
 *  Given a = 1 and b = 2, return 3.
 */

public class Q371 extends Solution {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }

}
