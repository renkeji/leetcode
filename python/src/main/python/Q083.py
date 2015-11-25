from src.main.python.Solution import Solution

# Given a sorted linked list, delete all duplicates such that each element appear only once.
#
# For example,
#   Given 1->1->2, return 1->2.
#   Given 1->1->2->3->3, return 1->2->3.


class Q083(Solution):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        p = head
        while p:
            if p.next and p.val == p.next.val:
                p.next = p.next.next
            else:
                p = p.next
        return head
