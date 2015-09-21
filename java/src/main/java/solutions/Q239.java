package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * For example,
 *  Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *  Window position                Max
 *  ---------------               -----
 *  [1  3  -1] -3  5  3  6  7       3
 *   1 [3  -1  -3] 5  3  6  7       3
 *   1  3 [-1  -3  5] 3  6  7       5
 *   1  3  -1 [-3  5  3] 6  7       5
 *   1  3  -1  -3 [5  3  6] 7       6
 *   1  3  -1  -3  5 [3  6  7]      7
 *
 *  Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note:
 *  You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 *  Could you solve it in linear time?
 */

public class Q239 extends Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        } else {
            int[] ans = new int[nums.length - k + 1];
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < k; ++i) {
                while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            for (int i = k; i < nums.length; ++i) {
                ans[i-k] = nums[q.get(0)];
                while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                    q.removeLast();
                }
                while (!q.isEmpty() && q.getFirst() <= i - k) {
                    q.removeFirst();
                }
                q.addLast(i);
            }
            ans[nums.length-k] = nums[q.getFirst()];
            return ans;
        }
    }

}
