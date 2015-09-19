package solutions;

/**
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 *
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 *
 * Find the minimum cost to paint all houses.
 */

public class Q265 extends Solution {

    private int findMin(int[] a, int index) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (i != index) {
                min = Math.min(min, a[i]);
            }
        }
        return min;
    }

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int[] dp = new int[k];
        int[] temp = new int[k];
        for (int i = 0; i < k; ++i) {
            dp[i] = costs[0][i];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
                temp[j] = dp[j];
            }
            for (int j = 0; j < k; ++j) {
                dp[j] = costs[i][j] + findMin(temp, j);
            }
        }
        return findMin(dp, -1);
    }

}