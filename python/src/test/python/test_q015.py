from unittest import TestCase

from src.main.python.Q015 import Q015


class TestQ015(TestCase):
    def test_threeSum(self):
        solution = Q015()
        nums = [-1, 0, 1, 2, -1, -4]
        expected = [[-1, -1, 2], [-1, 0, 1]]
        actual = solution.threeSum(nums)
        self.assertEqual(expected, actual)
