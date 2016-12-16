package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 *
 * Example 1:
 *  Given points = [[1,1],[-1,1]], return true.
 *
 * Example 2:
 *  Given points = [[1,1],[-1,-1]], return false.
 *
 * Follow up:
 *  Could you do better than O(n^2)?
 *
 * Hint:
 *  1. Find the smallest and largest x-value for all points.
 *  2. If there is a line then it should be at y = (minX + maxX) / 2.
 *  3. For each point, make sure that it has a reflected point in the opposite side.
 */

public class Q356 extends Solution {

    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            String str = p[0] + "," + p[1];
            set.add(str);
        }
        int sum = max + min;
        for (int[] p : points) {
            String str = (sum - p[0]) + "," + p[1];
            if (!set.contains(str)) {
                return false;
            }
        }
        return true;
    }

}
