package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * Note:
 *  A subtree must include all of its descendants.
 *
 * Here's an example:
 *      10
 *      / \
 *     5  15
 *    / \   \
 *   1   8   7
 *
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 *
 * Follow up:
 *  Can you figure out ways to solve it with O(n) time complexity?
 */

public class Q333 extends Solution {

    private class IntMutable {
        int val;
        public IntMutable(int val) {
            this.val = val;
        }
    }

    private class Triplet {
        int min;
        int max;
        int cnt;
        public Triplet(int min, int max, int cnt) {
            this.min = min;
            this.max = max;
            this.cnt = cnt;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        IntMutable max = new IntMutable(0);
        largestBSTSubtree(root, max);
        return max.val;
    }

    private Triplet largestBSTSubtree(TreeNode root, IntMutable maxNode) {
        if (root == null) {
            return new Triplet(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        } else {
            Triplet left = largestBSTSubtree(root.left, maxNode);
            Triplet right = largestBSTSubtree(root.right, maxNode);
            if (left.cnt != -1 && right.cnt != -1 && root.val > left.max && root.val < right.min) {
                int nodes = 1 + left.cnt + right.cnt;
                maxNode.val = Math.max(maxNode.val, nodes);
                int minValue = Math.min(root.val, left.min);
                int maxValue = Math.max(root.val, right.max);
                return new Triplet(minValue, maxValue, nodes);
            } else {
                return new Triplet(0, 0, -1);
            }
        }
    }

}
