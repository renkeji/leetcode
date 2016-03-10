package solutions;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 *  Given sorted array nums = [1,1,1,2,2,3],
 *
 *  Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 *  It doesn't matter what you leave beyond the new length.
 */

public class Q080 extends Solution {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        boolean isFirst = true;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[index] != nums[i] || isFirst) {
                isFirst = nums[index] != nums[i];
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

}
