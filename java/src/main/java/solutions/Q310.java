package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph,
 * write a function to find all the MHTs and return a list of their root labels.
 *
 * Format
 *  The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 *  You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1:
 *  Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *      0
 *      |
 *      1
 *     / \
 *    2   3
 *  return [1]
 *
 * Example 2:
 *  Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *   0  1  2
 *    \ | /
 *      3
 *      |
 *      4
 *      |
 *      5
 *  return [3, 4]
 */

public class Q310 extends Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaf = new ArrayList<>();
        if (n <= 1) {
            leaf.add(0);
            return leaf;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; ++i){
            graph.put(i, new ArrayList<Integer>());
        }

        int[] neighbors = new int[n];
        for (int[] edge : edges) {
            neighbors[edge[0]]++;
            neighbors[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() == 1) {
                leaf.add(i);
            }
        }

        while (n > 2) {
            List<Integer> newLeaf = new ArrayList<>();
            for (int l : leaf) {
                --n;
                for (int nb : graph.get(l)) {
                    if(--neighbors[nb] == 1){
                        newLeaf.add(nb);
                    }
                }
            }
            leaf = newLeaf;
        }
        return leaf;
    }

}
