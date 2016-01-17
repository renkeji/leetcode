package solutions;

import solutions.datastructures.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 *  Given 1->2->3->4->5->NULL,
 *  return 1->3->5->2->4->NULL.
 *
 * Note:
 *  The relative order inside both the even and odd groups should remain as it was in the input.
 *  The first node is considered odd, the second node even and so on ...
 */

public class Q328 extends Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
            ListNode odd = head, prevOdd = null;
            ListNode evenHead = head.next, prevEven = null;
            while (odd != null) {
                ListNode even = odd.next;
                if (prevOdd != null) {
                    prevOdd.next = odd;
                }
                if (prevEven != null) {
                    prevEven.next = even;
                }
                prevOdd = odd;
                prevEven = even;
                odd = even == null ? null : even.next;
            }
            prevOdd.next = evenHead;
        }
        return head;
    }

}
