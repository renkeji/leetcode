package solutions;

import solutions.datastructures.ListNode;

/**
 * Reverse a singly linked list.
 */

public class Q206 extends Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
