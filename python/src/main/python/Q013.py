from src.main.python.Solution import Solution

# Given a roman numeral, convert it to an integer.
#
# Input is guaranteed to be within the range from 1 to 3999.


class Q013(Solution):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        numerals = {"M": 1000, "D": 500, "C": 100, "L": 50, "X": 10, "V": 5, "I": 1}
        integer = 0
        s = s[::-1]
        last = None
        for x in s:
            if last and numerals[x] < last:
                integer -= 2 * numerals[x]
            integer += numerals[x]
            last = numerals[x]
        return integer
