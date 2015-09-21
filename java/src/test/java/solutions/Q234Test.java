package solutions;

import junit.framework.TestCase;
import solutions.datastructures.ListNode;

public class Q234Test extends TestCase {

    public void testIsPalindrome() throws Exception {
        Q234 solution = new Q234();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        boolean actual = solution.isPalindrome(node1);
        assertTrue(actual);

        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        actual = solution.isPalindrome(node1);
        assertTrue(actual);
    }
}