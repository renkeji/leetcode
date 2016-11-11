package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */

public class Q222 extends Solution {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode curr = root;
        int count = 1;
        while (curr.left != null) {
            if (getHeight(curr.left) > getHeight(curr.right)) {
                curr = curr.left;
                count *= 2;
            } else {
                curr = curr.right;
                count = count * 2 + 1;
            }
        }
        return count;
    }

    private int getHeight(TreeNode root) {
        int height = -1;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }

}
