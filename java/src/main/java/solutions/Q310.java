package solutions;

import java.util.ArrayList;
import java.util.List;

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
        List<List<Integer>> graph = constructGraph(n, edges);

        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() <= 1) {
                leaf.add(i);
            }
        }

        while (n > 2) {
            List<Integer> newLeaf = new ArrayList<>();
            for (int l : leaf) {
                --n;
                for (int nb : graph.get(l)) {
                    graph.get(nb).remove(new Integer(l));
                    if(graph.get(nb).size() == 1){
                        newLeaf.add(nb);
                    }
                }
            }
            leaf = newLeaf;
        }
        return leaf;
    }

    private List<List<Integer>> constructGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i){
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

}
