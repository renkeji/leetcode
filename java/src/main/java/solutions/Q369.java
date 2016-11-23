package solutions;

import solutions.datastructures.ListNode;

/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 *  Input:
 *  1->2->3
 *
 *  Output:
 *  1->2->4
 */

public class Q369 extends Solution {

    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        } else {
            int carry = plusOneHelper(head);
            if (carry == 1) {
                ListNode newHead = new ListNode(1);
                newHead.next = head;
                return newHead;
            } else {
                return head;
            }
        }
    }

    private int plusOneHelper(ListNode node) {
        if (node == null) {
            return 1;
        } else {
            int carry = plusOneHelper(node.next);
            int sum = node.val + carry;
            node.val = sum % 10;
            return sum / 10;
        }
    }

}
