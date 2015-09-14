package solutions;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 * Follow up:
 *      Could you do it using only constant space complexity?
 */

public class Q255 extends Solution {

    public boolean verifyPreorder(int[] preorder) {
        return !(preorder == null || preorder.length == 0)
            && verifyPreorder(preorder, 0, preorder.length - 1);
    }

    private boolean verifyPreorder(int[] preorder, int left, int right) {
        if (left >= right) {
            return true;
        } else {    // left < right -- at least two nodes
            int i = left + 1;
            while (i <= right && preorder[i] < preorder[left]) {
                ++i;
            }
            // Need to check the right subtree is valid
            for (int j = i; j <= right; ++j) {
                if (preorder[j] < preorder[left]) {
                    return false;
                }
            }
            // i > right || preorder[i] > preorder[left]
            return verifyPreorder(preorder, left + 1, i - 1)
                && verifyPreorder(preorder, i, right);
        }
    }

}
