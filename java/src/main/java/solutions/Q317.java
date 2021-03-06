package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 *
 *  Each 0 marks an empty land which you can pass by freely.
 *  Each 1 marks a building which you cannot pass through.
 *  Each 2 marks an obstacle which you cannot pass through.
 *
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 *  1 - 0 - 2 - 0 - 1
 *  |   |   |   |   |
 *  0 - 0 - 0 - 0 - 0
 *  |   |   |   |   |
 *  0 - 0 - 1 - 0 - 0
 *
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 *
 * Note:
 *  There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */

public class Q317 extends Solution {

    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return -1;
        }
        int cols = grid[0].length;

        int[][] dist = new int[rows][cols];
        int[][] nums = new int[rows][cols];
        int buildingNum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, i, j, dist, nums);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }

        if (min < Integer.MAX_VALUE) {
            return min;
        }

        return -1;
    }

    public void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        boolean[][] visited = new boolean[rows][cols];
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] top = q.remove();
                for (int[] dir : dirs) {
                    int x = top[0] + dir[0];
                    int y = top[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        dist[x][y] += level;
                        nums[x][y]++;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }

}
