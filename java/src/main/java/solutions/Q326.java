package solutions;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 *  Could you do it without using any loop / recursion?
 */

public class Q326 extends Solution {

    public boolean isPowerOfThree(int n) {
//        if (n <= 0) {
//            return false;
//        } else {
//            while (n != 1) {
//                if (n % 3 != 0) {
//                    return false;
//                } else {
//                    n /= 3;
//                }
//            }
//            return true;
//        }
        return n > 0 && (long)n == (long)Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }

}
