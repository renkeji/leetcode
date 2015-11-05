from unittest import TestCase

from src.main.python.Q016 import Q016


class TestQ016(TestCase):
    def test_threeSumClosest(self):
        solution = Q016()
        nums = [1, 2, 4, 8, 16, 32, 64, 128]
        target = 82
        expected = 82
        actual = solution.threeSumClosest(nums, target)
        self.assertEqual(expected, actual)
