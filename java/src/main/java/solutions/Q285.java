package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 */

public class Q285 extends Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            if (left != null) {
                return left;
            }
            if (p.val < root.val) {
                return root;
            }
            return inorderSuccessor(root.right, p);
        }
    }

}
