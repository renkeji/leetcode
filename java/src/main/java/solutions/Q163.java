package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 *
 * For example,
 *  given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */

public class Q163 extends Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                ans.add(String.valueOf(lower));
            } else {
                ans.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
        } else {
            // process the lower to nums[0]
            if (nums[0] != lower) {
                if (nums[0] - lower == 1) {
                    ans.add(String.valueOf(lower));
                } else {
                    ans.add(String.valueOf(lower) + "->" + String.valueOf(nums[0] - 1));
                }
            }
            // process the array
            for (int i = 0; i < nums.length - 1; ++i) {
                if (nums[i + 1] - nums[i] == 2) {
                    ans.add(String.valueOf(nums[i] + 1));
                } else if (nums[i + 1] - nums[i] > 2) {
                    ans.add(String.valueOf(nums[i] + 1) + "->" + String.valueOf(nums[i + 1] - 1));
                }
            }
            // process nums[nums.length - 1] to upper
            int last = nums[nums.length - 1];
            if (upper - last > 1) {
                ans.add(String.valueOf(last + 1) + "->" + String.valueOf(upper));
            } else if (upper - last == 1) {
                ans.add(String.valueOf(upper));
            }
        }
        return ans;
    }


}
