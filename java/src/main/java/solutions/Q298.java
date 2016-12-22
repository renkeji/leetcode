package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *
 *      1
 *       \
 *        3
 *       / \
 *      2   4
 *           \
 *            5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *      2
 *       \
 *        3
 *       /
 *      2
 *     /
 *    1
 * Longest consecutive sequence path is 2-3, not3-2-1, so return 2.
 */

public class Q298 extends Solution {

    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) return length;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
    }

//    private class IntMutable {
//        int val;
//        public IntMutable(int val) {
//            this.val = val;
//        }
//    }
//
//    public int longestConsecutive(TreeNode root) {
//        IntMutable max = new IntMutable(0);
//        longestConsecutive(root, max);
//        return max.val;
//    }
//
//    private int longestConsecutive(TreeNode root, IntMutable max) {
//        if (root == null) {
//            return 0;
//        } else {
//            int left = longestConsecutive(root.left, max);
//            left = (root.left != null && root.left.val == root.val + 1) ? left + 1 : 1;
//
//            int right = longestConsecutive(root.right, max);
//            right = (root.right != null && root.right.val == root.val + 1) ? right + 1: 1;
//
//            max.val = Math.max(right, Math.max(left, max.val));
//
//            return Math.max(left, right);
//        }
//    }

}
