package solutions;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example,
 *  given nums = [-2, 0, 1, 3], and target = 2.
 *  Return 2. Because there are two triplets which sums are less than 2:
 *      [-2, 0, 1]
 *      [-2, 0, 3]
 *
 * Follow up:
 *  Could you solve it in O(n2) runtime?
 */

public class Q259 extends Solution {

    // Naive O(n^3) solution
//    public int threeSumSmaller(int[] nums, int target) {
//        if (nums == null || nums.length < 3) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int count = 0;
//        for (int i = 0; i < nums.length - 2; ++i) {
//            for (int j = i + 1; j < nums.length - 1; ++j) {
//                for (int k = j + 1; k < nums.length; ++k) {
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if (sum < target) {
//                        ++count;
//                    }
//                }
//            }
//        }
//        return count;
//    }

    // O(n^2) solution -- i + k only needs to traverse O(n) length
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int k = nums.length - 1;
            for (int j = i + 1; j < k; ++j) {
                while (k > j && nums[i] + nums[j] + nums[k] >= target) {
                    --k;
                }
                count += k - j;
            }
        }
        return count;
    }

}
