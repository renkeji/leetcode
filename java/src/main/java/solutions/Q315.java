package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property
 * where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *  Given nums = [5, 2, 6, 1]
 *
 *  To the right of 5 there are 2 smaller elements (2 and 1).
 *  To the right of 2 there is only 1 smaller element (1).
 *  To the right of 6 there is 1 smaller element (1).
 *  To the right of 1 there is 0 smaller element.
 *  Return the array [2, 1, 1, 0].
 */

public class Q315 extends Solution {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>(Collections.nCopies(n, 0));
        Collections.fill(ans, 0);
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new Pair(nums[i], i);
        }
        sort(pairs, 0, n-1, ans);
        return ans;
    }

    private void sort(Pair[] pairs, int low, int high, List<Integer> ans) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sort(pairs, low, mid, ans);
            sort(pairs, mid+1, high, ans);
            merge(pairs, low, mid, high, ans);
        }
    }

    private void merge(Pair[] pairs, int low, int mid, int high, List<Integer> ans) {
        int n = high - low + 1;
        int i = mid, k = n - 1, j = high;
        Pair[] temp = new Pair[n];
        System.arraycopy(pairs, low, temp, 0, n);
        while (i >= low && j > mid) {
            if (pairs[i].val > pairs[j].val) {
                int index = pairs[i].index;
                int value = ans.get(index) + (j - mid);
                ans.set(index, value);
                temp[k--] = pairs[i--];
            } else {
                temp[k--] = pairs[j--];
            }
        }
        while (j > mid) {
            temp[k--] = pairs[j--];
        }
        System.arraycopy(temp, 0, pairs, low, n);
    }

    private class Pair {
        int val;
        int index;
        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> ans = new ArrayList<>();
//        if (nums != null && nums.length > 0) {
//            Node root = new Node(nums[nums.length - 1]);
//            ans.add(0);
//            for (int i = nums.length - 2; i >= 0; --i) {
//                ans.add(insert(root, nums[i]));
//            }
//            Collections.reverse(ans);
//        }
//        return ans;
//    }
//
//    private int insert(Node root, int num) {
//        int count = 0;
//        while (true) {
//            if (root.val >= num) {
//                root.count++;
//                if (root.left == null) {
//                    root.left = new Node(num);
//                    break;
//                } else {
//                    root = root.left;
//                }
//            } else {
//                count += root.count;
//                if (root.right == null) {
//                    root.right = new Node(num);
//                    break;
//                } else {
//                    root = root.right;
//                }
//            }
//        }
//        return count;
//    }
//
//    private class Node {
//        int val;
//        Node left;
//        Node right;
//        int count;
//        Node(int value) {
//            this.val = value;
//            this.count = 1;
//        }
//    }

}
