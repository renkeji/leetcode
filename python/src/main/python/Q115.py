from src.main.python.Solution import Solution

# Given a string S and a string T, count the number of distinct subsequences of T in S.
#
# A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
# the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
# "ABCDE" while "AEC" is not).
#
# Here is an example:
#   S = "rabbbit", T = "rabbit"
#
#   Return 3.


class Q115(Solution):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        ans = 0
        if s and t:
            dp = [1] + [0] * len(t)
            for i in range(len(s)):
                for j in reversed(range(1, len(t)+1)):
                    if s[i] == t[j-1]:
                        dp[j] += dp[j-1]
            ans = dp[-1]
        return ans