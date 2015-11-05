from unittest import TestCase

from src.main.python.Q017 import Q017


class TestQ017(TestCase):
    def test_letterCombinations(self):
        solution = Q017()
        digits = "23"
        expected = ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        actual = solution.letterCombinations(digits)
        self.assertEqual(expected, actual)
