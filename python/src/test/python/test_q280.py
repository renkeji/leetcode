from unittest import TestCase
from src.main.python.Q280 import Q280


class TestQ280(TestCase):
    def test_wiggleSort(self):
        solution = Q280()
        nums = [3, 5, 2, 1, 6, 4]
        solution.wiggleSort(nums)
        self.assertListEqual([1, 3, 2, 5, 4, 6], nums)