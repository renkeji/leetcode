from src.main.python.Solution import Solution

# Merge two sorted linked lists and return it as a new list.
# The new list should be made by splicing together the nodes of the first two lists.


class Q021(Solution):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        prev, curr, head = None, None, None
        while l1 or l2:
            if not l1 or (l2 and l1.val > l2.val):
                curr = l2
                l2 = l2.next
            elif not l2 or (l1 and l1.val <= l2.val):
                curr = l1
                l1 = l1.next
            if not prev:
                head = curr
            else:
                prev.next = curr
            prev = curr
        return head
