package solutions;

import solutions.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 *  Given binary tree {1,#,2,3},
 *      1
 *       \
 *        2
 *       /
 *      3
 *  return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class Q144 extends Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            TreeNode curr = s.pop();
            ans.add(curr.val);
            if (curr.right != null) {
                s.push(curr.right);
            }
            if (curr.left != null) {
                s.push(curr.left);
            }
        }
        return ans;
    }

}
