from src.main.python.Solution import Solution

# Given an array of strings, group anagrams together.
#
# For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
#   Return:
#
#   [
#     ["ate", "eat","tea"],
#     ["nat","tan"],
#     ["bat"]
#   ]

# Note:
#   For the return value, each inner list's elements must follow the lexicographic order.
#   All inputs will be in lower-case.


class Q049(Solution):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        ans = []
        if strs:
            table = {}
            for str in strs:
                key = ''.join(sorted(str))
                anagrams = table.get(key, [])
                anagrams.append(str)
                table[key] = anagrams
            for key in table:
                ans.append(sorted(table[key]))
        return ans
