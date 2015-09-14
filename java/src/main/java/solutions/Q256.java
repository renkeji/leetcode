package solutions;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * Note:
 *      All costs are positive integers.
 */

public class Q256 extends Solution {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length != 3) {
            return 0;
        }
        int[] dp = new int[3];
        dp[0] = costs[0][0];
        dp[1] = costs[0][1];
        dp[2] = costs[0][2];
        for (int i = 1; i < costs.length; ++i) {
            int temp0 = dp[0];
            int temp1 = dp[1];
            int temp2 = dp[2];
            dp[0] = costs[i][0] + Math.min(temp1, temp2);
            dp[1] = costs[i][1] + Math.min(temp0, temp2);
            dp[2] = costs[i][2] + Math.min(temp0, temp1);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }

}
