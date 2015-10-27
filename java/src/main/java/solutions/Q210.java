package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *
 * For example:
 *  2, [[1,0]]
 *  There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 *
 *  4, [[1,0],[2,0],[3,1],[3,2]]
 *  There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 *  Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
 *  Another correct ordering is[0,2,1,3].
 */

public class Q210 extends Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<Integer>();
        int[] preCount = new int[numCourses];
        for (int[] p : prerequisites) {
            preCount[p[0]]++;
        }

        for (int i = 0; i < preCount.length; ++i) {
            if (preCount[i] == 0) {
                order.add(i);
            }
        }

        int i = 0;
        int numCompleted = order.size();
        while (i != order.size()) {
            int course = order.get(i++);
            for (int[] p : prerequisites) {
                if (p[1] == course) {
                    preCount[p[0]]--;
                    if (preCount[p[0]] == 0) {
                        numCompleted++;
                        order.add(p[0]);
                    }
                }
            }
        }
        if (numCompleted == numCourses) {
            int[] ans = new int[order.size()];
            for (int j = 0; j < order.size(); ++j) {
                ans[j] = order.get(j);
            }
            return ans;
        } else {
            return new int[0];
        }
    }

}