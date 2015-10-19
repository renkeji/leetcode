package solutions;

import solutions.datastructures.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

public class Q173 extends Solution {

    public class BSTIterator {

        Stack<TreeNode> stack;
        TreeNode curr;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            curr = root;
            populateStack();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode top = stack.pop();
            curr = top.right;
            populateStack();
            return top.val;
        }

        private void populateStack() {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }

    }

}
