package solutions;

import solutions.datastructures.TreeNode;

import java.util.*;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *         1
 *        / \
 *       2   3
 *          / \
 *         4   5
 *
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note:
 *  Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

public class Q297 extends Solution {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            while (!s.isEmpty()) {
                TreeNode top = s.pop();
                if (top == null) {
                    sb.append("#,");
                } else {
                    if (top.left == null && top.right == null) {
                        sb.append(top.val).append(",");
                    } else {
                        sb.append(top.val).append("*,");
                        s.push(top.right);
                        s.push(top.left);
                    }
                }
            }
            String ans = sb.toString();
            return ans.endsWith(",") ? ans.substring(0, ans.length() - 1) : ans;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) {
                return null;
            } else {
                Iterator<String> it = Arrays.asList(data.split(",")).iterator();
                return deserialize(it);
            }
        }

        private TreeNode deserialize(Iterator<String> it) {
            if (!it.hasNext()) {
                return null;
            } else {
                String val = it.next();
                if ("#".equals(val)) {
                    return null;
                } else if (!val.endsWith("*")) {
                    return new TreeNode(Integer.parseInt(val));
                } else {
                    TreeNode node = new TreeNode(Integer.parseInt(val.substring(0, val.length() - 1)));
                    node.left = deserialize(it);
                    node.right = deserialize(it);
                    return node;
                }
            }
        }

    }

}
