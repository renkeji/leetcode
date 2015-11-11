from src.main.python.Solution import Solution

# Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
#
# Each number in C may only be used once in the combination.
#
# Note:
#   All numbers (including target) will be positive integers.
#   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
#   The solution set must not contain duplicate combinations.
#
# For example, given candidate set 10,1,2,7,6,1,5 and target 8,
#   A solution set is:
#   [1, 7]
#   [1, 2, 5]
#   [2, 6]
#   [1, 1, 6]


class Q040(Solution):
    def combinationSum2(self, candidates, target):
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
                i = 0 if not path else path[-1]+1
                while i < len(candidates):
                    path.append(i)
                    combination_sum(candidates, sum-candidates[i], path, ans)
                    path.pop()
                    i += 1
                    while i < len(candidates) and candidates[i] == candidates[i-1]:
                        i += 1

        ans = []
        if candidates:
            candidates.sort()
            combination_sum(candidates, target, [], ans)
        return ans
