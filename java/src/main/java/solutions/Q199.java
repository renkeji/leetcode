package solutions;

import solutions.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 *  Given the following binary tree,
 *          1            <---
 *        /   \
 *       2     3         <---
 *        \     \
 *         5     4       <---
 *  You should return [1, 3, 4].
 */

public class Q199 extends Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            List<TreeNode> currLevel = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();
            currLevel.add(root);
            while (!currLevel.isEmpty()) {
                for (int i = 0; i < currLevel.size(); ++i) {
                    TreeNode curr = currLevel.get(i);
                    if (curr.left != null) {
                        nextLevel.add(curr.left);
                    }
                    if (curr.right != null) {
                        nextLevel.add(curr.right);
                    }
                    if (i == currLevel.size() - 1) {
                        ans.add(curr.val);
                    }
                }
                currLevel = nextLevel;
                nextLevel = new ArrayList<>();
            }
        }
        return ans;
    }

}
