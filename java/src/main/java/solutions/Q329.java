package solutions;

import scala.Int;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 *  nums = [
 *      [9,9,4],
 *      [6,6,8],
 *      [2,1,1]
 *  ]
 *  Return 4
 *  The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 *  nums = [
 *      [3,4,5],
 *      [3,2,6],
 *      [2,2,1]
 *  ]
 *  Return 4
 *  The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */

public class Q329 extends Solution {

    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int [rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                ans = Math.max(ans, dfs(i, j, rows, cols, matrix, dp));
            }
        }
        return ans;
    }

    private int dfs(int x, int y, int m,int n,int[][] matrix, int[][] dp) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] > matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny, m, n, matrix, dp));
            }
        }
        dp[x][y]++;
        return dp[x][y];
    }

}
