package solutions;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class Q198 extends Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        } else {
            int dp_2 = nums[0];
            int dp_1 = nums[1];
            int dp = Math.max(dp_2, dp_1);
            for (int i = 2; i < nums.length; ++i) {
                dp = Math.max(dp_2 + nums[i], dp_1);
                dp_2 = dp_1;
                dp_1 = dp;
            }
            return dp;
        }
    }

}
