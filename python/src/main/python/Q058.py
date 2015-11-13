from src.main.python.Solution import Solution

# Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
# return the length of last word in the string.
#
# If the last word does not exist, return 0.
#
# Note: A word is defined as a character sequence consists of non-space characters only.
#
# For example,
# Given s = "Hello World",
# return 5.


class Q058(Solution):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = 0
        if s:
            s = s.strip()
            for i in reversed(range(len(s))):
                if s[i] == ' ':
                    return count
                count += 1
        return count
