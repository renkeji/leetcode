package solutions;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number.
 */

/**
 * @see <a href="http://www.geeksforgeeks.org/ugly-numbers/">Reference on GeeksforGeeks</a>
 */
public class Q264 extends Solution {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int i = 0, j = 0, k = 0;
        int ugly2 = 2, ugly3 = 3, ugly5 = 5;
        int ugly = 1;
        for (int m = 1; m < n; ++m) {
            ugly = Math.min(Math.min(ugly2, ugly3), ugly5);
            dp[m] = ugly;
            if (ugly == ugly2) {
                ugly2 = dp[++i] * 2;
            }
            if (ugly == ugly3) {
                ugly3 = dp[++j] * 3;
            }
            if (ugly == ugly5) {
                ugly5 = dp[++k] * 5;
            }
        }
        return ugly;
    }

}
