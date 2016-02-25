package solutions;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *  Return true if there exists i, j, k
 *  such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 *
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Examples:
 *  Given [1, 2, 3, 4, 5],
 *  return true.
 *
 *  Given [5, 4, 3, 2, 1],
 *  return false.
 */

public class Q334 extends Solution {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        } else {
            int i = 0, j = 1;
            while (j < nums.length && nums[j] <= nums[i]) {
                ++i;
                ++j;
            }
            for (int k = j + 1; k < nums.length; ++k) {
                if (nums[k] > nums[j]) {
                    return true;
                } else { // nums[k] <= nums[j]
                    j = (nums[k] > nums[i] || nums[k-1] < nums[i]) ? k : j;
                    i = nums[k-1] < nums[i] ? k-1 : i;
                }
            }
            return false;
        }
    }

}
