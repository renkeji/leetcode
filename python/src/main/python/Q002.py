from src.main.python.Solution import Solution
from src.main.python.datastructures.ListNode import ListNode

# You are given two linked lists representing two non-negative numbers.
# The digits are stored in reverse order and each of their nodes contain a single digit.
# Add the two numbers and return it as a linked list.
#
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8


class Q002(Solution):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        prev, curr, head = None, None, None
        carry = 0
        while l1 is not None or l2 is not None:
            l1_val = 0 if l1 is None else l1.val
            l2_val = 0 if l2 is None else l2.val
            sum = (l1_val + l2_val + carry) % 10
            carry = (l1_val + l2_val + carry) / 10
            curr = ListNode(sum)
            if head is None:
                head = curr
            else:
                prev.next = curr
            prev = curr
        if carry == 1:
            prev.next = ListNode(1)
        return head
