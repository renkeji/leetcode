package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */

public class Q228 extends Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums != null && nums.length != 0) {
            int len = nums.length;
            int start = nums[0];
            for (int i = 1; i < len; ++i) {
                if (nums[i] != nums[i - 1] + 1) {
                    if (nums[i - 1] != start) {
                        String range = String.valueOf(start) + "->" + String.valueOf(nums[i - 1]);
                        ans.add(range);
                    } else {
                        ans.add(String.valueOf(nums[i - 1]));
                    }
                    start = nums[i];
                }
            }
            if (nums[len - 1] != start) {
                String range = String.valueOf(start) + "->" + String.valueOf(nums[len - 1]);
                ans.add(range);
            } else {
                ans.add(String.valueOf(start));
            }
        }
        return ans;
    }

}
