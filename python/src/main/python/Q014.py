from src.main.python.Solution import Solution

# Write a function to find the longest common prefix string amongst an array of strings.


class Q014(Solution):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        prefix = ""
        if strs:
            for i in range(len(strs[0])):
                p = strs[0][:i+1]
                for s in strs[1:]:
                    if i == len(s) or p != s[:i+1]:
                        return prefix
                prefix = p
        return prefix
