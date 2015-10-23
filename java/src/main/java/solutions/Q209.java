package solutions;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 *
 * For example
 *  given the array [2,3,1,2,4,3] and s = 7,
 *  the subarray [4,3] has the minimal length under the problem constraint.
 *
 * More practice:
 *  If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */

public class Q209 extends Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int min = 0;
        if (nums != null && nums.length != 0) {
            int i = 0, j = 0;
            int sum = 0;
            while (j < nums.length) {
                while (j < nums.length && sum < s) {
                    sum += nums[j++];
                }
                while (sum >= s) {
                    int len = j - i;
                    if (min == 0) {
                        min = len;
                    } else {
                        min = len < min ? len : min;
                    }
                    sum -= nums[i++];
                }
            }
        }
        return min;
    }

}
