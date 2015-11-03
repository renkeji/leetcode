import math

from src.main.python.Solution import Solution

# Determine whether an integer is a palindrome. Do this without extra space.
#
# Some hints:
# Could negative integers be palindromes? (ie, -1)
#
# If you are thinking of converting the integer to string, note the restriction of using extra space.
#
# You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
# you know that the reversed integer might overflow. How would you handle such case?
#
# There is a more generic way of solving this problem.


class Q009(Solution):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        def get_num_digits(x):
            ans = 1
            while x >= 10:
                x //= 10
                ans += 1
            return ans

        if x < 0:
            return False

        num_digits = get_num_digits(x)
        for i in range(num_digits // 2):
            left = x // math.pow(10, num_digits - i - 1)
            right = x % math.pow(10, i + 1) // math.pow(10, i)
            if left != right:
                return False
            x -= left * math.pow(10, num_digits - i - 1) + right * math.pow(10, i)
        return True
