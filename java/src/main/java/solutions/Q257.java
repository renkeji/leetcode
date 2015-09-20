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
            path.add(node);
            if (node.left == null && node.right == null) {
                String s = "";
                for (int i = 0; i < path.size() - 1; ++i) {
                    s += path.get(i).val + "->";
                }
                s += path.get(path.size() - 1).val;
                ans.add(s);
            } else {
                binaryTreePaths(node.left, path, ans);
                binaryTreePaths(node.right, path, ans);
            }
            path.remove(path.size() - 1);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root != null) {
            binaryTreePaths(root, new ArrayList<TreeNode>(), ans);
        }
        return ans;
    }

}
