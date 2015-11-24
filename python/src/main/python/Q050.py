from src.main.python.Solution import Solution

# Implement pow(x, n).


class Q050(Solution):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        ans = 1
        acc = x if n > 0 else 1/x
        n = abs(n)
        while n != 0:
            if n % 2 == 1:
                ans *= acc
            acc *= acc
            n //= 2
        return ans
