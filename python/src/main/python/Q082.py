from src.main.python.Solution import Solution

# Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
#
# For example,
#   Given 1->2->3->3->4->4->5, return 1->2->5.
#   Given 1->1->1->2->3, return 2->3.


class Q082(Solution):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        p, prev, head = head, None, None
        while p:
            next = p.next
            while next and next.val == p.val:
                next = next.next
            if p.next is next:
                if not head:
                    head = p
                else:
                    prev.next = p
                prev = p
            p = next
        if prev:
            prev.next = None
        return head
