package solutions;

import solutions.datastructures.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class Q002 extends Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0), prev = dummy;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            prev.next = new ListNode(sum);
            prev = prev.next;
            l1 = l1 == null ? null: l1.next;
            l2 = l2 == null ? null: l2.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return dummy.next;
    }

}
