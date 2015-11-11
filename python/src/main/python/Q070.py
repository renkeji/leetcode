from src.main.python.Solution import Solution

# You are climbing a stair case. It takes n steps to reach to the top.
#
# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


class Q070(Solution):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp, dp_1, dp_2 = 0, 1, 0
        for i in range(1, n+1):
            dp = 0
            if i >= 1:
                dp += dp_1
            if i >= 2:
                dp += dp_2
            dp_2, dp_1 = dp_1, dp
        return dp
