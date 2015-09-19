package solutions;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * For example:
 *  Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 *  The order of the result is not important. So in the above example, [5, 3] is also correct.
 *  Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

public class Q260 extends Solution {

    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        if (nums == null || nums.length < 2) {
            return ans;
        }
        int xor = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            xor ^= nums[i];
        }
        int diffBit = xor & (~(xor - 1));
        int one = 0, two = 0;
        for (int num : nums) {
            if ((num & diffBit) != 0) {
                one ^= num;
            } else {
                two ^= num;
            }
        }
        ans[0] = one;
        ans[1] = two;
        return ans;
    }

}
