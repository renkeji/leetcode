from unittest import TestCase

from src.main.python.Q020 import Q020


class TestQ020(TestCase):
    def test_isValid(self):
        solution = Q020()
        s = "()"
        self.assertTrue(solution.isValid(s))

        s = "()[]{}"
        self.assertTrue(solution.isValid(s))

        s = "(]"
        self.assertFalse(solution.isValid(s))

        s = "([)]"
        self.assertFalse(solution.isValid(s))

        s = "([]"
        self.assertFalse(solution.isValid(s))
