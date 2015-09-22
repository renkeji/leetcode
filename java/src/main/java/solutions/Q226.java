package solutions;

import solutions.datastructures.TreeNode;

/**
 * Invert a binary tree.
 *
 *       4
 *     /   \
 *    2     7
 *   / \   / \
 *  1   3 6   9
 *
 * to
 *       4
 *     /   \
 *    7     2
 *   / \   / \
 *  9   6 3   1
 */

public class Q226 extends Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
            return root;
        }
    }

}
