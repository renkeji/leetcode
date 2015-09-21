package solutions;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class Q169 extends Solution {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int majority = nums[0];
            int count = 0;
            for (int i : nums) {
                if (i == majority) {
                    ++count;
                } else {
                    if (--count == 0) {
                        majority = i;
                        count = 1;
                    }
                }
            }
            return majority;
        }
    }

}
