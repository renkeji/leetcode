package solutions;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 *
 * Given [3, 1, 5, 8]
 *
 * Return 167
 *
 *  nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class Q312 extends Solution {

    public int maxCoins(int[] nums) {
        int ans = 0;
        if (nums != null && nums.length != 0) {
            int n = nums.length;
            int[] arr = new int[n+2];
            System.arraycopy(nums, 0, arr, 1, n);
            arr[0] = arr[n+1] = 1;
            int[][] dp = new int[n+2][n+2];
            for (int k = 1; k <= n; ++k) {
                for (int i = 1; i <= n-k+1; ++i) {
                    int j = i + k - 1;
                    for (int x = i; x <= j; ++x) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][x-1] + arr[i-1] * arr[x] * arr[j+1] + dp[x+1][j]);
                    }
                }
            }
            ans = dp[1][n];
        }
        return ans;
    }

}
