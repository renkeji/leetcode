package solutions;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * For example,
 *  Given [10, 9, 2, 5, 3, 7, 101, 18],
 *  The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 *
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n^2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 */

public class Q300 extends Solution {

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        if (nums != null && nums.length != 0) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                int max = 0;
                for (int j = i - 1; j >= 0; --j) {
                    if (nums[i] > nums[j]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + 1;
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

}
