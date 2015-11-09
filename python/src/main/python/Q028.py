from src.main.python.Solution import Solution

# Implement strStr().
#
# Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


class Q028(Solution):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        # trivial O(m * n) solution
        if not needle:
            return 0
        else:
            if haystack:
                for i in range(len(haystack)-len(needle)+1):
                    if haystack[i] == needle[0] and haystack[i:i+len(needle)] == needle:
                        return i
            return -1

        # TODO: KMP solution