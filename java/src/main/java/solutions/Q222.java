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
        if (root == null) return 0;
        TreeNode cur = root;
        int count = 1;
        while (cur.left != null) {
            if (getHeight(cur.left) > getHeight(cur.right)) {
                cur = cur.left;
                count *= 2;
            } else {
                cur = cur.right;
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
