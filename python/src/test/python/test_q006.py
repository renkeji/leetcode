from unittest import TestCase
from src.main.python.Q006 import Q006


class TestQ006(TestCase):
  def test_convert(self):
    solution = Q006()
    s = "PAYPALISHIRING"
    numRows = 3
    expected = "PAHNAPLSIIGYIR"
    actual = solution.convert(s, numRows)
    self.assertEqual(expected, actual)
