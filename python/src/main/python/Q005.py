from src.main.python.Solution import Solution

# Given a string S, find the longest palindromic substring in S.
# You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.


class Q005(Solution):
    def expand_center(self, s, i, j):
        while i >= 0 and j < len(s) and s[i] == s[j]:
            i -= 1; j += 1
        return s[i+1:j]

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        longest = ""
        if s:
            for i in range(len(s)):
                str1 = self.expand_center(s, i, i)
                longest = str1 if len(str1) > len(longest) else longest
                str2 = self.expand_center(s, i, i+1)
                longest = str2 if len(str2) > len(longest) else longest
        return longest
