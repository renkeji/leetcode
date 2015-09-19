package solutions;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 *  You must do this in-place without making a copy of the array.
 *  Minimize the total number of operations.
 */

public class Q283 extends Solution {

    // This algorithm moves the zeros to back
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0, j = 0; j < nums.length; ++j) {
            if (nums[j] != 0) {
                while (i < j && nums[i] != 0) {
                    ++i;
                }
                if (i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

    // This algorithm moves the zeros to front
    public void moveZerosToFront(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = nums.length - 1, j = nums.length - 1; j >= 0; --j) {
            if (nums[j] != 0) {
                while (i > j && nums[i] != 0) {
                    --i;
                }
                if (i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

}