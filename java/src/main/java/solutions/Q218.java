package solutions;

import java.util.*;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 *
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
 * and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 *
 * Notes:
 *  1. The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 *  2. The input list is already sorted in ascending order by the left x position Li.
 *  3. The output list must be sorted by the x position.
 *  4. There must be no consecutive horizontal lines of equal height in the output skyline.
 *     For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable;
 *     the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */

public class Q218 extends Solution {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>();
        if (buildings != null && buildings.length != 0 && buildings[0].length != 0) {
            List<Height> heights = new ArrayList<>();
            for (int[] building : buildings) {
                heights.add(new Height(building[0], -building[2]));
                heights.add(new Height(building[1], building[2]));
            }
            Collections.sort(heights, new Comparator<Height>() {
                @Override
                public int compare(Height o1, Height o2) {
                    return o1.index != o2.index ? o1.index - o2.index : o1.height - o2.height;
                }
            });
            PriorityQueue<Integer> pq = new PriorityQueue<>(1000, Collections.<Integer>reverseOrder());
            pq.offer(0);
            int prev = 0;
            for (Height h : heights) {
                if (h.height < 0) {
                    pq.offer(-h.height);
                } else {
                    pq.remove(h.height);
                }
                int curr = pq.peek();
                if (curr != prev) {
                    ans.add(new int[]{h.index, curr});
                    prev = curr;
                }
            }
        }
        return ans;
    }

    private class Height {
        int index;
        int height;
        public Height(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

}
