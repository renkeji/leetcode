package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
 *
 * Especially, this path can be either increasing or decreasing.
 * For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
 * On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
 *
 * Example 1:
 *
 * Input:
 *      1
 *     / \
 *    2   3
 * Output: 2
 * Explanation: The longest consecutive path is [1, 2] or [2, 1].
 *
 * Example 2:
 *
 * Input:
 *      2
 *     / \
 *    1   3
 * Output: 3
 * Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 *
 * Note: All the values of tree nodes are in the range of [-1e7, 1e7].
 */

public class Q549 extends Solution {

    private class IntMutable {
        int val;
        IntMutable(int val) {
            this.val = val;
        }
    }

    public int longestConsecutive(TreeNode root) {
        IntMutable max = new IntMutable(0);
        longestPath(root, max);
        return max.val;
    }

    private int[] longestPath(TreeNode root, IntMutable max) {
        if (root == null) return new int[]{0, 0};
        int inc = 1, desc = 1;
        if (root.left != null) {
            int[] left = longestPath(root.left, max);
            if (root.val == root.left.val + 1)
                desc = left[1] + 1;
            else if (root.val == root.left.val - 1)
                inc = left[0] + 1;
        }

        if (root.right != null) {
            int[] right = longestPath(root.right, max);
            if (root.val == root.right.val + 1)
                desc = Math.max(desc, right[1] + 1);
            else if (root.val == root.right.val - 1)
                inc = Math.max(inc, right[0] + 1);
        }

        max.val = Math.max(max.val, desc + inc - 1);
        return new int[] {inc, desc};
    }

}
