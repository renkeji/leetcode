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

    private int maxLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideView(root, 1, ans);
        return ans;
    }

    private void rightSideView(TreeNode root, int level, List<Integer> ans) {
        if (root != null) {
            if (maxLevel < level) {
                ans.add(root.val);
                maxLevel = level;
            }
            rightSideView(root.right, level+1, ans);
            rightSideView(root.left, level+1, ans);
        }
    }

//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if (root != null) {
//            List<TreeNode> currLevel = new ArrayList<>();
//            List<TreeNode> nextLevel = new ArrayList<>();
//            currLevel.add(root);
//            while (!currLevel.isEmpty()) {
//                for (int i = 0; i < currLevel.size(); ++i) {
//                    TreeNode curr = currLevel.get(i);
//                    if (curr.left != null) {
//                        nextLevel.add(curr.left);
//                    }
//                    if (curr.right != null) {
//                        nextLevel.add(curr.right);
//                    }
//                    if (i == currLevel.size() - 1) {
//                        ans.add(curr.val);
//                    }
//                }
//                currLevel = nextLevel;
//                nextLevel = new ArrayList<>();
//            }
//        }
//        return ans;
//    }

}
