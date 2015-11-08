from src.main.python.Solution import Solution

# Given a linked list, swap every two adjacent nodes and return its head.
#
# For example,
#   Given 1->2->3->4, you should return the list as 2->1->4->3.
#
# Your algorithm should use only constant space.
# You may not modify the values in the list, only nodes itself can be changed.


class Q024(Solution):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        p1 = head
        p2 = p1.next if p1 else None
        prev, new_head = None, None
        while p1:
            next = p2.next if p2 else None
            if p2:
                p2.next = p1
            if prev:
                prev.next = p2 if p2 else p1
            else:
                new_head = p2 if p2 else p1
            prev = p1
            p1 = next
            p2 = p1.next if p1 else None
        if prev:
            prev.next = None
        return new_head
