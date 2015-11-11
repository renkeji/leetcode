from src.main.python.Solution import Solution

# Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
#
# The same repeated number may be chosen from C unlimited number of times.
#
# Note:
#   All numbers (including target) will be positive integers.
#   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
#   The solution set must not contain duplicate combinations.
#
# For example, given candidate set 2,3,6,7 and target 7,
#   A solution set is:
#   [7]
#   [2, 2, 3]


class Q039(Solution):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def combination_sum(candidates, sum, path, ans):
            if sum < 0:
                return
            elif sum == 0:
                ans.append([candidates[i] for i in path])
            else:
                start = 0 if not path else path[-1]
                for i in range(start, len(candidates)):
                    path.append(i)
                    combination_sum(candidates, sum-candidates[i], path, ans)
                    path.pop()

        ans = []
        if candidates:
            candidates.sort()
            combination_sum(candidates, target, [], ans)
        return ans
