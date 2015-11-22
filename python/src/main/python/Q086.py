from src.main.python.Solution import Solution

# Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
#
# You should preserve the original relative order of the nodes in each of the two partitions.
#
# For example,
#   Given 1->4->3->2->5->2 and x = 3,
#   return 1->2->2->4->3->5.


class Q086(Solution):
    def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        before_start, before_end, after_start, after_end = None, None, None, None
        while head:
            if head.val < x:
                if not before_start:
                    before_start = head
                else:
                    before_end.next = head
                before_end = head
            else:
                if not after_start:
                    after_start = head
                else:
                    after_end.next = head
                after_end = head
            head = head.next
        if before_end:
            before_end.next = after_start
        if after_end:
            after_end.next = None
        return before_start if before_start else after_start
