package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * For example, given three people living at (0,0), (0,4), and (2,2):
 *
 *  1 - 0 - 0 - 0 - 1
 *  |   |   |   |   |
 *  0 - 0 - 0 - 0 - 0
 *  |   |   |   |   |
 *  0 - 0 - 1 - 0 - 0
 *
 *  The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 */

public class Q296 extends Solution {

    public int minTotalDistance(int[][] grid) {
        int min = 0;
        if (grid != null && grid.length != 0 && grid[0].length != 0) {
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == 1) {
                        x.add(i);
                        y.add(j);
                    }
                }
            }
            int xMedian = findMedian(x);
            int yMedian = findMedian(y);
            return calcDistance(xMedian, x) + calcDistance(yMedian, y);
        }
        return min;
    }

    private int findMedian(List<Integer> values) {
        if (values.isEmpty()) {
            return 0;
        } else {
            Collections.sort(values);
            int size = values.size();
            if (size % 2 == 1) {
                return values.get(size / 2);
            } else {
                int value1 = values.get(size / 2 - 1);
                int value2 = values.get(size / 2);
                return (value1 + value2) / 2;
            }
        }
    }

    private int calcDistance(int median, List<Integer> values) {
        int sum = 0;
        for (int value : values) {
            sum += Math.abs(value - median);
        }
        return sum;
    }

}
