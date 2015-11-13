from src.main.python.Solution import Solution

# A message containing letters from A-Z is being encoded to numbers using the following mapping:
#
# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
#
# Given an encoded message containing digits, determine the total number of ways to decode it.
#
# For example,
#   Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
#
#   The number of ways decoding "12" is 2.


class Q091(Solution):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        ans = 0
        if s:
            dp = [0] * len(s)
            for i in range(len(s)-1, -1, -1):
                if s[i] == '0':
                    dp[i] = 0
                elif i == len(s)-1:
                    dp[i] = 1
                else:
                    if 0 < int(s[i:i+2]) < 27:
                        if i == len(s)-2:
                            dp[i] = dp[i+1] + 1
                        else:
                            dp[i] = dp[i+1] + dp[i+2]
                    else:
                        dp[i] = dp[i+1]

            ans = dp[0]
        return ans