package solutions;

import solutions.datastructures.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 *  Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 *  Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class Q203 extends Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode newHead = null;
        while (head != null) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            // head == null || head.val != val
            if (prev != null) {
                prev.next = head;
            }
            prev = head;
            if (newHead == null) {
                newHead = prev;
            }
            head = head != null ? head.next : null;
        }
        return newHead;
    }

}
