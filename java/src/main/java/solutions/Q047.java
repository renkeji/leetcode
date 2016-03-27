package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 *  [1,1,2] have the following unique permutations:
 *  [1,1,2], [1,2,1], and [2,1,1].
 */

public class Q047 extends Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums != null) {
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            permuteUnique(nums, 0, new ArrayList<Integer>(), visited, ans);
        }
        return ans;
    }

    private void permuteUnique(int[] nums, int index, List<Integer> path, boolean[] visited, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (!visited[i]) {
                    if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                        continue;
                    }
                    path.add(nums[i]);
                    visited[i] = true;
                    permuteUnique(nums, index+1, path, visited, ans);
                    path.remove(path.size()-1);
                    visited[i] = false;
                }
            }
        }
    }

}
