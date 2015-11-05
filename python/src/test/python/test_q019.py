from unittest import TestCase

from src.main.python.Q019 import Q019
from src.main.python.datastructures.ListNode import ListNode


class TestQ019(TestCase):
    def test_removeNthFromEnd(self):
        solution = Q019()
        head = ListNode(1)
        n = 1
        expected = None
        actual = solution.removeNthFromEnd(head, n)
        self.assertEqual(expected, actual)