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

    // Trivial solution -- O(n) time + O(max(logn, k)) space
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>(k);
        if (root != null) {
            Stack<TreeNode> s = new Stack<>();
            PriorityQueue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            TreeNode curr = root;
            while (curr != null || !s.isEmpty()) {
                if (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                } else {
                    curr = s.pop();
                    if (q.size() < k) {
                        q.offer(curr.val);
                    } else if (Math.abs(q.peek() - target) > Math.abs(curr.val - target)) {
                        q.poll();
                        q.offer(curr.val);
                    }
                    curr = curr.right;
                }
            }
            for (int i : q) {
                ans.add(i);
            }
        }
        return ans;
    }

}
