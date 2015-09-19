package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example,
 *  given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

public class Q279 extends Solution {

    // Top-down HashMap Cache solution -- StackOverflowException
//    private int numSquares(int sum, Map<Integer, Integer> hm) {
//        if (hm.containsKey(sum)) {
//            return hm.get(sum);
//        } else if (sum <= 0) {
//            return 0;
//        } else {
//            int min = Integer.MAX_VALUE;
//            for (int i = 1; i * i <= sum; ++i) {
//                int ans = numSquares(sum - i * i, hm) + 1;
//                min = Math.min(min, ans);
//            }
//            hm.put(sum, min);
//            return min;
//        }
//    }
//
//    public int numSquares(int n) {
//        if (n <= 0) {
//            return 0;
//        } else {
//            return numSquares(n, new HashMap<Integer, Integer>());
//        }
//    }

    // Bottom-up one dimension array solution
    // O(n^2) time & O(n) space
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i*i <= n; ++i) {
            dp[i*i] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; i+j*j <= n; ++j) {
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1);
            }
        }

        return dp[n];
    }

}
