package solutions;

import solutions.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 *  Given n = 3, there are a total of 5 unique BST's.
 *
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */

public class Q095 extends Solution {

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? new ArrayList<TreeNode>() : generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> ans = new ArrayList<>();
        if (left > right) {
            ans.add(null);
            return ans;
        } else {
            for (int i = left; i <= right; ++i) {
                List<TreeNode> leftNodes = generateTrees(left, i-1);
                List<TreeNode> rightNodes = generateTrees(i+1, right);
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        ans.add(root);
                    }
                }
            }
            return ans;
        }
    }

}
