package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 *  -1 - A wall or an obstacle.
 *   0 - A gate.
 * INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 *      INF  -1  0  INF
 *      INF INF INF  -1
 *      INF  -1 INF  -1
 *        0  -1 INF INF
 *
 *  After running your function, the 2D grid should be:
 *      3  -1   0   1
 *      2   2   1  -1
 *      1  -1   2  -1
 *      0  -1   3   4
 */

public class Q286 extends Solution {

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = rooms.length;
        if (rows == 0) {
            return;
        }
        int cols = rooms[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            for (int[] dir : dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[top[0]][top[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }

    // BFS from the '0's
//    public void wallsAndGates(int[][] rooms) {
//        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
//            return;
//        }
//        int row = rooms.length;
//        int col = rooms[0].length;
//        Queue<Node> q = new LinkedList<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (rooms[i][j] == 0) {
//                    q.offer(new Node(i, j));
//                }
//            }
//        }
//        int INF = Integer.MAX_VALUE;
//        while (!q.isEmpty()) {
//            Node p = q.poll();
//            int i = p.i;
//            int j = p.j;
//            int num = rooms[i][j];
//            if (i - 1 >= 0 && rooms[i - 1][j] == INF) {
//                rooms[i - 1][j] = num + 1;
//                q.offer(new Node(i - 1, j));
//            }
//            if (i + 1 < row && rooms[i + 1][j] == INF) {
//                rooms[i + 1][j] = num + 1;
//                q.offer(new Node(i + 1, j));
//            }
//            if (j - 1 >= 0 && rooms[i][j - 1] == INF) {
//                rooms[i][j - 1] = num + 1;
//                q.offer(new Node(i, j - 1));
//            }
//            if (j + 1 < col && rooms[i][j + 1] == INF) {
//                rooms[i][j + 1] = num + 1;
//                q.offer(new Node(i, j + 1));
//            }
//        }
//    }
//
//    private class Node {
//        int i;
//        int j;
//        Node(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//    }
}
