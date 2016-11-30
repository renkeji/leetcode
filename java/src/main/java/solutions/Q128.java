package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 *  Given [100, 4, 200, 1, 3, 2],
 *  The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */

public class Q128 extends Solution {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int ans = 0;
        for (int i : nums) {
            if (set.contains(i)) {
                ans = Math.max(ans, getCount(set, i, false) + getCount(set, i+1, true));
            }
        }
        return ans;
    }

    private int getCount(Set<Integer> set, int num, boolean asc) {
        int count = 0;
        while (set.contains(num)) {
            count++;
            set.remove(num);
            if (asc) {
                num++;
            } else {
                num--;
            }
        }
        return count;
    }

}
