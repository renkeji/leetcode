package solutions;

import solutions.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example,
 *  given the following binary tree:
 *          1
 *        /   \
 *       2     3
 *        \
 *         5
 *
 *  All root-to-leaf paths are:
 *      ["1->2->5", "1->3"]
 */

public class Q257 extends Solution {

    private void binaryTreePaths(TreeNode node, List<TreeNode> path, List<String> ans) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                String s = "";
                for (TreeNode n : path)
                    s += n.val + "->";
                s += node.val;
                ans.add(s);
            } else {
                path.add(node);
                binaryTreePaths(node.left, path, ans);
                binaryTreePaths(node.right, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), ans);
        return ans;
    }

}
