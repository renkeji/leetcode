package solutions;

import solutions.datastructures.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 *  Could you do it in O(n) time and O(1) space?
 */

public class Q234 extends Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = (head != null && head.next != null) ? head.next.next : null;
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next != null ? p2.next.next : null;
        }
        ListNode secondHalf = null;
        if (p1 != null) {
            secondHalf = reverse(p1.next);
            p1.next = null;
        }
        return checkPalindrome(head, secondHalf);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private boolean checkPalindrome(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            } else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        if (head1 == null && head2 == null) {
            return true;
        } else if (head1 != null) {
            return head1.next == null;
        } else {
            return head2.next == null;
        }
    }
}
