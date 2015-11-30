from src.main.python.Solution import Solution

# Implement int sqrt(int x).
#
# Compute and return the square root of x.


class Q069(Solution):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 2:
            return x
        epsilon = 0.000001
        left, right = 0, x

        while True:
            ans = (left + right) / 2.0
            sqr = ans ** 2
            if x-epsilon <= sqr <= x+epsilon:
                return int(ans)
            elif sqr > x+epsilon:
                right = ans
            else:
                left = ans
