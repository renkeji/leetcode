package solutions;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 *  Given nums = [-2, 0, 3, -5, 2, -1]
 *
 *  sumRange(0, 2) -> 1
 *  sumRange(2, 5) -> -1
 *  sumRange(0, 5) -> -3
 *
 * Note:
 *  You may assume that the array does not change.
 *  There are many calls to sumRange function.
 */

public class Q303 extends Solution {

    public class NumArray {

        int[] table;

        public NumArray(int[] nums) {
            table = new int[nums.length + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                table[i+1] = sum;
            }
        }

        public int sumRange(int i, int j) {
            return table[j+1] - table[i];
        }

    }

}
