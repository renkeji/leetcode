package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * For example:
 *  Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *  Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * Note:
 *  you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */

public class Q261 extends Solution {

    public boolean validTree(int n, int[][] edges) {
        int[] id = new int[n], sz = new int[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
            sz[i] = 1;
        }

        // perform union find
        for (int[] edge : edges) {
            int x = find(id, edge[0]);
            int y = find(id, edge[1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            if (sz[x] <= sz[y]) {
                id[x] = y;
                sz[y] += sz[x];
            } else {
                id[y] = x;
                sz[x] += sz[y];
            }
        }

        return edges.length == n - 1;
    }

    private int find(int[] ids, int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

//    public boolean validTree(int n, int[][] edges) {
//        List<List<Integer>> neighbors = constructNeighbors(n, edges);
//        boolean[] visited = new boolean[n];
//        if (hasCycle(neighbors, 0, -1, visited)) {
//            return false;
//        }
//        for (boolean v : visited) {
//            if (!v) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private List<List<Integer>> constructNeighbors(int n, int[][] edges) {
//        List<List<Integer>> neighbors = new ArrayList<>(n);
//        for (int i = 0; i < n; ++i) {
//            neighbors.add(new ArrayList<Integer>());
//        }
//        for (int[] edge : edges) {
//            neighbors.get(edge[0]).add(edge[1]);
//            neighbors.get(edge[1]).add(edge[0]);
//        }
//        return neighbors;
//    }
//
//    private boolean hasCycle(List<List<Integer>> neighbors, int v, int parent, boolean[] visited) {
//        visited[v] = true;
//        for (int n : neighbors.get(v)) {
//            if (!visited[n]) {
//                if (hasCycle(neighbors, n, v, visited)) {
//                    return true;
//                }
//            } else if (n != parent) {
//                return true;
//            }
//        }
//        return false;
//    }

}
