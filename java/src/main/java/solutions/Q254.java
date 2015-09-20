package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 *
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *  1. Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 *  2. You may assume that n is always positive.
 *  3. Factors should be greater than 1 and less than n.
 *
 * Examples:
 *  input: 1
 *  output: []
 *
 *  input: 37
 *  output: []
 *
 *  input: 12
 *  output:
 *      [
 *          [2, 6],
 *          [2, 2, 3],
 *          [3, 4]
 *      ]
 *
 *  input: 32
 *  output:
 *      [
 *          [2, 16],
 *          [2, 2, 8],
 *          [2, 2, 2, 4],
 *          [2, 2, 2, 2, 2],
 *          [2, 4, 4],
 *          [4, 8]
 *      ]
 */

public class Q254 extends Solution {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        getFactors(n, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void getFactors(int n, List<Integer> path, List<List<Integer>> ans) {
        if (n == 1 && path.size() > 1) {
            ans.add(new ArrayList<>(path));
        } else {
            int start = path.isEmpty() ? 2 : path.get(path.size() - 1);
            for (int i = start; i <= n; ++i) {
                if (n % i == 0) {
                    path.add(i);
                    getFactors(n/i, path, ans);
                    path.remove(path.size()-1);
                }
            }
        }
    }

}
