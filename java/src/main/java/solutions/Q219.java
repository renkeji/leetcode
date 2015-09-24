package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 */

public class Q219 extends Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i  = 0; i < nums.length; ++i) {
            if (hm.containsKey(nums[i])) {
                if (i - hm.get(nums[i]) <= k) {
                    return true;
                }
            }
            hm.put(nums[i], i);
        }
        return false;
    }

}
