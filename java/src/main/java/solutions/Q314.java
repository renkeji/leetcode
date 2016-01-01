package solutions;

import solutions.datastructures.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples:
 *  Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 *
 *  return its vertical order traversal as:
 *  [
 *      [9],
 *      [3,15],
 *      [20],
 *      [7]
 *  ]
 *
 *  Given binary tree [3,9,20,4,5,2,7],
 *      _3_
 *     /   \
 *    9    20
 *   / \   / \
 *  4   5 2   7
 *
 *  return its vertical order traversal as:
 *  [
 *      [4],
 *      [9],
 *      [3,5,2],
 *      [20],
 *      [7]
 *  ]
 */

public class Q314 extends Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
            LinkedList<Pair> curr = new LinkedList<>();
            LinkedList<Pair> next = new LinkedList<>();
            curr.add(new Pair(0, root));
            while (!curr.isEmpty()) {
                while (!curr.isEmpty()) {
                    Pair p = curr.removeFirst();
                    if (!tm.containsKey(p.col)) {
                        tm.put(p.col, new ArrayList<Integer>());
                    }
                    tm.get(p.col).add(p.node.val);
                    if (p.node.left != null) {
                        next.add(new Pair(p.col-1, p.node.left));
                    }
                    if (p.node.right != null) {
                        next.add(new Pair(p.col+1, p.node.right));
                    }
                }
                curr = next;
                next = new LinkedList<>();
            }
            for (Map.Entry<Integer, List<Integer>> entry : tm.entrySet()) {
                ans.add(entry.getValue());
            }
        }
        return ans;
    }

    private class Pair {
        int col;
        TreeNode node;
        Pair(int col, TreeNode node) {
            this.col = col;
            this.node = node;
        }
    }

}
