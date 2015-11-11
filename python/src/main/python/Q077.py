import copy

from src.main.python.Solution import Solution

# Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
#
# For example,
#   If n = 4 and k = 2, a solution is:
#
#   [
#     [2,4],
#     [3,4],
#     [2,3],
#     [1,2],
#     [1,3],
#     [1,4],
#   ]


class Q077(Solution):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        def _combine(n, k, path, ans):
            if not k:
                ans.append(copy.copy(path))
            else:
                start = 1 if not path else path[-1]+1
                for i in range(start, n+1):
                    path.append(i)
                    _combine(n, k-1, path, ans)
                    path.pop()

        ans = []
        if n and k:
            _combine(n, k, [], ans)
        return ans
