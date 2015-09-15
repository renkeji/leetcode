package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 *      Given binary tree,
 *
 *            5
 *           / \
 *          1   5
 *         / \   \
 *        5   5   5
 *
 * return 4.
*/

public class Q250 extends Solution {

    private class BooleanMutable {

        private boolean val;

        public BooleanMutable(boolean val) {
            this.val = val;
        }

        public boolean getVal() {
            return val;
        }

        public void setVal(boolean val) {
            this.val = val;
        }

    }

    public int countUnivalSubtrees(TreeNode root) {
        return countUnivalSubtrees(root, new BooleanMutable(true));
    }

    private int countUnivalSubtrees(TreeNode node, BooleanMutable isUniSubtree) {
        if (node == null) {
            return 0;
        } else {
            int count = 0;
            if (node.left != null) {
                BooleanMutable isLeftUniSubtree = new BooleanMutable(true);
                count += countUnivalSubtrees(node.left, isLeftUniSubtree);
                if (!isLeftUniSubtree.getVal() || node.val != node.left.val) {
                    isUniSubtree.setVal(false);
                }
            }
            if (node.right != null) {
                BooleanMutable isRightUniSubtree = new BooleanMutable(true);
                count += countUnivalSubtrees(node.right, isRightUniSubtree);
                if (isUniSubtree.getVal() && (!isRightUniSubtree.getVal() || node.val != node.right.val)) {
                    isUniSubtree.setVal(false);
                }
            }
            return isUniSubtree.getVal() ? count + 1 : count;
        }
    }

}
