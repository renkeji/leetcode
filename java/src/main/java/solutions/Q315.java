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
        List<Integer> ans = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            Node root = new Node(nums[nums.length - 1]);
            ans.add(0);
            for (int i = nums.length - 2; i >= 0; --i) {
                ans.add(insert(root, nums[i]));
            }
            Collections.reverse(ans);
        }
        return ans;
    }

    private int insert(Node root, int num) {
        int count = 0;
        while (true) {
            if (root.val >= num) {
                root.count++;
                if (root.left == null) {
                    root.left = new Node(num);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                count += root.count;
                if (root.right == null) {
                    root.right = new Node(num);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return count;
    }

    private class Node {
        int val;
        Node left;
        Node right;
        int count;
        Node(int value) {
            this.val = value;
            this.count = 1;
        }
    }

}
