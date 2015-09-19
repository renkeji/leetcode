package solutions;

import solutions.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 *  Given binary tree {1,#,2,3},
 *
 *        1
 *         \
 *          2
 *         /
 *        3
 *
 *  return [1,3,2].
 *
 * Note:
 *  Recursive solution is trivial, could you do it iteratively?
 */

public class Q094 extends Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans;
    }

}
