package solutions;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output
 * such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 *  Could you solve it with constant space complexity?
 *
 * Note:
 *  The output array does not count as extra space for the purpose of space complexity analysis.
 */

public class Q238 extends Solution {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        } else {
            int[] ans = new int[nums.length];
            Arrays.fill(ans, 1);
            int left = 1, right = 1;
            for (int i = 0; i < nums.length; ++i) {
                ans[i] *= left;
                ans[nums.length - 1 - i] *= right;
                left *= nums[i];
                right *= nums[nums.length - 1 - i];
            }
            return ans;
        }
    }

}
