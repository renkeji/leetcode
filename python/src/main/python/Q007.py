import math
from src.main.python.Solution import Solution

# Reverse digits of an integer.
#
# Example1: x = 123, return 321
# Example2: x = -123, return -321
#
# Have you thought about this?
# Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
#
# If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
#
# Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
# then the reverse of 1000000003 overflows. How should you handle such cases?
#
# For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
#
# Update (2014-11-10):
# Test cases had been added to test the overflow behavior.


class Q007(Solution):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        upper, lower = (1 << 31) - 1, -(1 << 31)
        is_negative = x < 0
        x = abs(x)
        ans = 0
        l = len(str(x))
        for i in range(l // 2):
            left_num = x // math.pow(10, l - i - 1)
            right_num = (x % math.pow(10, i + 1)) // math.pow(10, i)
            ans += left_num * math.pow(10, i) + right_num * math.pow(10, l - i - 1)
            x -= left_num * math.pow(10, l - i - 1) + right_num * math.pow(10, i)
        ans = ans + x if l % 2 == 1 else -ans if is_negative else ans
        return int(ans) if lower <= ans <= upper else 0
