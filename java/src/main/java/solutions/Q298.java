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

    private class IntMutable {
        int val;
        public IntMutable(int val) {
            this.val = val;
        }
    }

    public int longestConsecutive(TreeNode root) {
        IntMutable max = new IntMutable(0);
        longestConsecutive(root, max);
        return max.val;
    }

    private int longestConsecutive(TreeNode root, IntMutable max) {
        if (root == null) {
            return 0;
        } else {
            int left = longestConsecutive(root.left, max);
            if (root.left != null && root.left.val == root.val + 1) {
                ++left;
            } else {
                left = 1;
            }
            max.val = Math.max(left, max.val);

            int right = longestConsecutive(root.right, max);
            if (root.right != null && root.right.val == root.val + 1) {
                ++right;
            } else {
                right = 1;
            }
            max.val = Math.max(right, max.val);

            return Math.max(left, right);
        }
    }

}
