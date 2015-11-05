from src.main.python.Solution import Solution

# Given a linked list, remove the nth node from the end of list and return its head.
#
# For example,
#
# Given linked list: 1->2->3->4->5, and n = 2.
#
# After removing the second node from the end, the linked list becomes 1->2->3->5.

# Note:
#   Given n will always be valid.
#   Try to do this in one pass.
from src.main.python.datastructures.ListNode import ListNode


class Q019(Solution):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        p1 = p2 = dummy
        for i in range(n):
            p1 = p1.next
        while p1.next:
            p1, p2 = p1.next, p2.next
        p2.next = p2.next.next
        return dummy.next
