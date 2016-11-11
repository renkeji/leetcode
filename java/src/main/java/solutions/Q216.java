package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Ensure that numbers within the set are sorted in ascending order.
 *
 * Example 1:
 *  Input:  k = 3, n = 7
 *  Output: [[1,2,4]]
 *
 * Example 2:
 *  Input:  k = 3, n = 9
 *  Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

public class Q216 extends Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > 0 && n > 0) {
            combinationSum3(k, n, new ArrayList<>(), ans);
        }
        return ans;
    }

    private void combinationSum3(int k, int n, List<Integer> path, List<List<Integer>> ans) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
        } else {
            int start = path.isEmpty() ? 1 : path.get(path.size() - 1) + 1;
            for (int i = start; i <= 9; ++i) {
                path.add(i);
                combinationSum3(k - 1, n - i, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

}
