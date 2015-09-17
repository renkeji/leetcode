package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 *
 * For example:
 *  Given a binary tree {1,2,3,4,5},
 *            1
 *           / \
 *          2   3
 *         / \
 *        4   5
 *
 *  return the root of the binary tree [4,5,2,#,#,3,1].
 *            4
 *           / \
 *          5   2
 *             / \
 *            3   1
 */

public class Q156 extends Solution {

    private TreeNode upsideDownBinaryTree(TreeNode node, TreeNode parent) {
        if (node == null) {
            return null;
        } else {
            TreeNode newRoot = upsideDownBinaryTree(node.left, node);
            if (parent == null) {
                node.left = null;
                node.right = null;
            } else {
                node.left = parent.right;
                node.right = parent;
            }
            return newRoot == null ? node : newRoot;
        }
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return upsideDownBinaryTree(root, null);
    }

}
