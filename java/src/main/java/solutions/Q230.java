package solutions;

import solutions.datastructures.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 *  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up:
 *  What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 *  How would you optimize the kthSmallest routine?
 */

public class Q230 extends Solution {

//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> s = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !s.isEmpty()) {
//            if (curr != null) {
//                s.push(curr);
//                curr = curr.left;
//            } else {
//                curr = s.pop();
//                if (--k == 0) {
//                    return curr.val;
//                }
//                curr = curr.right;
//            }
//        }
//        return 0;
//    }

     /*
     For follow-up: we can use two heaps:
      one maxHeap of size k
      one minHeap dynamic size

     When adding a new node, we insert it to tree and heaps in parallel:
      if newNode.val < maxHeap.peek then
          minHeap.offer(maxHeap.pull());
          maxHeap.offer(newNode.val);
      else
          minHeap.offer(newNode.val);

     When removing a node, we also delete it from tree and heaps in parallel:
      if deleteNode.val < maxHeap.peek then
          maxHeap.remove(deleteNode.val);
          maxHeap.offer(minHeap.pull());
      else
          minHeap.remove(deleteNode.val)
    */
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        inOrder(root, maxHeap, minHeap, k);
        return maxHeap.peek();
    }

    private void inOrder(TreeNode root, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int k) {
        if (root != null) {
            inOrder(root.left, maxHeap, minHeap, k);
            if (maxHeap.size() < k) {
                maxHeap.offer(root.val);
            } else {
                minHeap.offer(root.val);
            }
            inOrder(root.right, maxHeap, minHeap, k);
        }
    }

}
