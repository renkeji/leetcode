package solutions;

/**
 * Note: This is an extension of House Robber.
 *
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class Q213 extends Solution {

    public int rob(int[] nums) {
        int includeFirst = rob(nums, 0, nums.length - 1);
        int includeLast = rob(nums, 1, nums.length);
        return Math.max(includeFirst, includeLast);
    }

    private int rob(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start >= nums.length) {
            return 0;
        } else {
            int dp_2 = nums[start];
            int dp_1 = end - start > 1 ? Math.max(nums[start], nums[start + 1]) : 0;
            int dp = Math.max(dp_2, dp_1);
            for (int i = start + 2; i < end; ++i) {
                dp = Math.max(dp_2 + nums[i], dp_1);
                dp_2 = dp_1;
                dp_1 = dp;
            }
            return dp;
        }
    }

}
