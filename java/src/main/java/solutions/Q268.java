package solutions;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * For example,
 *  Given nums = [0, 1, 3] return 2.
 *
 * Note:
 *  Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class Q268 extends Solution {

    // TODO: need to consider the overflow case
    public int missingNumber(int[] nums) {
        int expectedSum = (nums.length + 1) * nums.length / 2;
        int actualSum = 0;
        for (int i : nums) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }

}
