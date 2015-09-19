package solutions;

import solutions.datastructures.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *  Given target value is a floating point.
 *  You are guaranteed to have only one unique value in the BST that is closest to the target.
 */

public class Q270 extends Solution {

    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        double diff = Math.abs(ans - target);
        if (root.left != null) {
            int left = closestValue(root.left, target);
            ans = Math.abs(left - target) < diff ? left : ans;
            diff = Math.abs(ans - target);
        }
        if (root.right != null) {
            int right = closestValue(root.right, target);
            ans = Math.abs(right - target) < diff ? right : ans;
        }
        return ans;
    }

}
