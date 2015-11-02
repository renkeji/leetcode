from unittest import TestCase
from src.main.python.Q007 import Q007


class TestQ007(TestCase):
  def test_reverse(self):
    solution = Q007()
    x = -1234
    expected = -4321
    actual = solution.reverse(x)
    self.assertEqual(expected, actual)
