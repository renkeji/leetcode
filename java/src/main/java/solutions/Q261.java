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
        List<List<Integer>> neighbors = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            neighbors.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        boolean[] onPath = new boolean[n];
        boolean[] visited = new boolean[n];
        if (hasCycle(neighbors, 0, -1, onPath, visited)) {
            return false;
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> neighbors, int child, int parent, boolean[] onPath, boolean[] visited) {
        if (onPath[child]) {
            return true;
        }
        onPath[child] = true;
        visited[child] = true;
        for (int n : neighbors.get(child)) {
            if (n != parent && hasCycle(neighbors, n, child, onPath, visited)) {
                return true;
            }
        }
        onPath[child] = false;
        return false;
    }

}
