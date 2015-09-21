package solutions;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */

public class Q231 extends Solution {

    public boolean isPowerOfTwo(int n) {
        return n != 0 && Integer.MIN_VALUE < n && n < Integer.MAX_VALUE && ((n & (n - 1)) == 0);
    }

}
