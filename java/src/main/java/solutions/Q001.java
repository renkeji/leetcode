package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 *
 * UPDATE (2016/2/13):
 *  The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */

public class Q001 extends Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (hm.containsKey(target-num)) {
                return new int[]{hm.get(target-num), i};
            }
            hm.put(num, i);
        }
        return null;
    }
}
