package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 *
 *  0          3
 *  |          |
 *  1 --- 2    4
 *
 *  Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 *
 * Example 2:
 *
 *  0           4
 *  |           |
 *  1 --- 2 --- 3
 *
 *  Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 *
 * Note:
 *  You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same
 *  as [1, 0] and thus will not appear together in edges.
 */

public class Q323 extends Solution {

    public int countComponents(int n, int[][] edges) {
        if (n <= 0 || edges == null) {
            return 0;
        } else {
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                uf.union(edge[0], edge[1]);
            }
            return uf.count;
        }
    }

    private class UnionFind {
        private int[] ids;
        private int[] sz;
        int count;

        public UnionFind(int n) {
            ids = new int[n];
            sz = new int[n];
            count = n;
            for (int i = 0; i < n; ++i) {
                ids[i] = i;
                sz[i] = 1;
            }
        }

        public int find(int i) {
            while (i != ids[i]) {
                ids[i] = ids[ids[i]];
                i = ids[i];
            }
            return i;
        }

        public void union(int i, int j) {
            i = find(i);
            j = find(j);

            if (i != j) {
                if (sz[i] <= sz[j]) {
                    ids[i] = j;
                    sz[j] += sz[i];
                } else {
                    ids[j] = i;
                    sz[i] += sz[j];
                }
                --count;
            }
        }
    }


//    public int countComponents(int n, int[][] edges) {
//        int ans = 0;
//        boolean[][] connected = new boolean[n][n];
//        boolean[] visited = new boolean[n];
//        for (int[] edge : edges) {
//            connected[edge[0]][edge[1]] = true;
//        }
//        for (int i = 0; i < n; ++i) {
//            if (!visited[i]) {
//                dfs(i, n, connected, visited);
//                ans++;
//            }
//        }
//        return ans;
//    }
//
//    private void dfs(int node, int n, boolean[][] connected, boolean[] visited) {
//        if (!visited[node]) {
//            visited[node] = true;
//            for (int i = 0; i < n; ++i) {
//                if (connected[node][i] || connected[i][node]) {
//                    dfs(i, n, connected, visited);
//                }
//            }
//        }
//    }

}
