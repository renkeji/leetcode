package solutions;

import java.util.LinkedList;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * For example:
 *  2, [[1,0]]
 *  There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 *
 *  2, [[1,0],[0,1]]
 *  There are a total of 2 courses to take. To take course 1 you should have finished course 0,
 *  and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * Note:
 *  The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 */

public class Q207 extends Solution {

    // BFS
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (numCourses == 0 || prerequisites.length == 0) {
//            return true;
//        }
//
//        int[] preCount = new int[numCourses];
//        for (int[] p : prerequisites) {
//            preCount[p[0]]++;
//        }
//
//        LinkedList<Integer> q = new LinkedList<>();
//        for (int i = 0; i < preCount.length; ++i) {
//            if (preCount[i] == 0) {
//                q.add(i);
//            }
//        }
//
//        int completeCourses = q.size();
//        while (!q.isEmpty()) {
//            int course = q.remove();
//            for (int[] p : prerequisites) {
//                if (p[1] == course) {
//                    preCount[p[0]]--;
//                    if (preCount[p[0]] == 0) {
//                        completeCourses++;
//                        q.add(p[0]);
//                    }
//                }
//            }
//        }
//
//        return completeCourses == numCourses;
//    }

    // DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        int[][] matrix = new int[numCourses][numCourses];
        for (int[] p : prerequisites) {
            matrix[p[1]][p[0]] = 1;
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0) {
                if (!dfs(i, matrix, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int[][] matrix, int[] visited) {
        if (visited[node] == 1) {
            return false;
        } else if (visited[node] == 2) {
            return true;
        }
        visited[node] = 1;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[node][i] == 1 && !dfs(i, matrix, visited)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }

}
