package solutions;

import java.util.ArrayList;
import java.util.List;

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
