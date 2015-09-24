package solutions;

import solutions.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getTreeHeight(root, true);
            int rightHeight = getTreeHeight(root, false);
            if (leftHeight == rightHeight) {
                return (1 << leftHeight) - 1;
            } else {
                return countNodes(root.left) + countNodes(root.right) + 1;
            }
        }
    }

    private int getTreeHeight(TreeNode root, boolean isLeft) {
        int count = 0;
        while (root != null) {
            ++count;
            root = isLeft ? root.left : root.right;
        }
        return count;
    }

}
