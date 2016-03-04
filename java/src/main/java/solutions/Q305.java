package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which
 * turns the water at position (row, col) into a land. Given a list of positions to operate,
 * count the number of islands after each addLand operation. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 *
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 *
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 *
 * Challenge:
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */

public class Q305 extends Solution {

    // Inspired by the other union find solution, I set array of a size(m*n+1) to avoid the initialization,
    // Set the union function to return a boolean instead of void, just to make the code cleaner,
    // Personally I think realistically, it's better to create a class of something like
    // "class island{int parent, int rank}", I didn't do that just for the speed.

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[] parent = new int[m*n+1], rank = new int[m*n+1];
        int numIslands = 0;

        for (int[] p : positions) {
            int x = p[0];
            int y = p[1];
            int offset = x * n + y + 1;
            parent[offset] = offset;
            numIslands++;

            if (x > 0 && parent[offset-n] != 0 && union(parent, rank, offset, offset-n)) {
                numIslands--;    //check the grid on top of current grid
            }
            if (x < m-1 && parent[offset+n] != 0 && union(parent, rank, offset, offset+n) ) {
                numIslands--; // check the grid below current grid
            }
            if (y > 0 && parent[offset-1] != 0 && union(parent, rank, offset, offset-1) ) {
                numIslands--; // check the grid to the left of the current grid
            }
            if (y < n-1 && parent[offset+1] != 0 && union(parent, rank, offset, offset+1) ) {
                numIslands--; // check the grid to the right of the current grid
            }
            ans.add(numIslands);
        }
        return ans;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    private boolean union(int[] parent, int[] rank, int x, int y) {
        int xparent = find(parent, x);
        int yparent = find(parent, y);
        if (xparent == yparent) {
            return false;
        }
        if (rank[xparent] <= rank[yparent]) {
            parent[xparent] = yparent;
            rank[yparent]++;
        } else {
            parent[yparent] = xparent;
        }
        return true;
    }

}