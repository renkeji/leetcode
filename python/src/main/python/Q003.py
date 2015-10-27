from src.main.python.Solution import Solution

# Given a string, find the length of the longest substring without repeating characters. For example,
# the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
#
# For "bbbbb" the longest substring is "b", with the length of 1.


class Q003(Solution):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        max_len = 0
        if s:
            i, j = 0, 0
            table = [False] * 256
            while j < len(s):
                if table[ord(s[j])]:
                    max_len = max(max_len, j - i)
                    while i < j and s[i] != s[j]:
                        table[ord(s[i])] = False
                        i += 1
                    i += 1
                else:
                    table[ord(s[j])] = True
                j += 1
            max_len = max(max_len, j - i)
        return max_len
