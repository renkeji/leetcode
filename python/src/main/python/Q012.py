from src.main.python.Solution import Solution

# Given an integer, convert it to a roman numeral.
#
# Input is guaranteed to be within the range from 1 to 3999.


class Q012(Solution):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        roman_numeral_map = (('M',  1000),
                             ('CM', 900),
                             ('D',  500),
                             ('CD', 400),
                             ('C',  100),
                             ('XC', 90),
                             ('L',  50),
                             ('XL', 40),
                             ('X',  10),
                             ('IX', 9),
                             ('V',  5),
                             ('IV', 4),
                             ('I',  1))

        result = ""
        for numeral, integer in roman_numeral_map:
            while num >= integer:
                result += numeral
                num -= integer
        return result
