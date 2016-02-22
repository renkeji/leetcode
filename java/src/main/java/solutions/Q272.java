package solutions;

import solutions.datastructures.TreeNode;

import java.util.*;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *  Given target value is a floating point.
 *  You may assume k is always valid, that is: k ≤ total nodes.
 *  You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 * Follow up:
 *  Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */

public class Q272 extends Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null) {
            return new ArrayList<>();
        } else {
            Stack<TreeNode> s = new Stack<>();
            Integer[] temp = new Integer[k];
            TreeNode curr = root;
            int i = 0, count = 0;
            while (curr != null || !s.isEmpty()) {
                if (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                } else {
                    curr = s.pop();
                    if (count < k) {
                        temp[count++] = curr.val;
                    } else {    // ans.size() >= k
                        int front = temp[i];
                        if (Math.abs(curr.val - target) < Math.abs(front - target)) {
                            temp[i] = curr.val;
                            i = (i+1) % k;
                        } else {
                            return Arrays.asList(temp);
                        }
                    }
                    curr = curr.right;
                }
            }
            return Arrays.asList(temp);
        }
    }

}
