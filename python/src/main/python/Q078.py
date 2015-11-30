from src.main.python.Solution import Solution

# Given a set of distinct integers, nums, return all possible subsets.
#
# Note:
#   Elements in a subset must be in non-descending order.
#   The solution set must not contain duplicate subsets.
#
# For example,
#   If nums = [1,2,3], a solution is:
#
#   [
#     [3],
#     [1],
#     [2],
#     [1,2,3],
#     [1,3],
#     [2,3],
#     [1,2],
#     []
#   ]


class Q078(Solution):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def __subsets(nums, index, path, ans):
            ans.append(path[:])
            for i in range(index, len(nums)):
                path.append(nums[i])
                __subsets(nums, i+1, path, ans)
                path.pop()

        ans = []
        if nums:
            nums.sort()
            __subsets(nums, 0, [], ans)
        return ans
