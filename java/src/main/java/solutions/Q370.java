package solutions;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of
 * subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 *
 * Return the modified array after all k operations were executed.
 *
 * Example:
 *
 *  Given:
 *  length = 5,
 *  updates = [
 *      [1,  3,  2],
 *      [2,  4,  3],
 *      [0,  2, -2]
 *  ]
 *
 *  Output:
 *  [-2, 0, 3, 5, 3]
 *
 *  Explanation:
 *  Initial state:
 *  [ 0, 0, 0, 0, 0 ]
 *
 *  After applying operation [1, 3, 2]:
 *  [ 0, 2, 2, 2, 0 ]
 *
 *  After applying operation [2, 4, 3]:
 *  [ 0, 2, 5, 5, 3 ]
 *
 *  After applying operation [0, 2, -2]:
 *  [-2, 0, 3, 5, 3 ]
 */

public class Q370 extends Solution {

    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0) {
            return new int[]{};
        } else {
            int[] ans = new int[length];
            int[] changes = processUpdates(length, updates);
            int accum = 0;
            for (int i = 0; i < length; ++i) {
                accum += changes[i];
                ans[i] = accum;
            }
            return ans;
        }
    }

    private int[] processUpdates(int length, int[][] updates) {
        int[] changes = new int[length];
        for (int[] update : updates) {
            int start = update[0], end = update[1], inc = update[2];
            changes[start] += inc;
            if (end + 1 < length) {
                changes[end + 1] += -inc;
            }
        }
        return changes;
    }

}
