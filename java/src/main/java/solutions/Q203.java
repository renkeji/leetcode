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
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, p = head;
        while (p != null) {
            if (p.val != val) {
                prev.next = p;
                prev = p;
            }
            p = p.next;
        }
        prev.next = null;
        return dummy.next;
    }

}
