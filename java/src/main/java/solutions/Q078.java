package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * Note:
 *  Elements in a subset must be in non-descending order.
 *  The solution set must not contain duplicate subsets.
 *
 * For example,
 *  If nums = [1,2,3], a solution is:
 *  [
 *      [3],
 *      [1],
 *      [2],
 *      [1,2,3],
 *      [1,3],
 *      [2,3],
 *      [1,2],
 *      []
 *  ]
 */

public class Q078 extends Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void subsets(int[] nums, int index, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; ++i) {
            path.add(nums[i]);
            subsets(nums, i+1, path, ans);
            path.remove(path.size()-1);
        }
    }

}
