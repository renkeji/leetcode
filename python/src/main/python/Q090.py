from src.main.python.Solution import Solution

# Given a collection of integers that might contain duplicates, nums, return all possible subsets.
#
# Note:
#   Elements in a subset must be in non-descending order.
#   The solution set must not contain duplicate subsets.
#
# For example,
#   If nums = [1,2,2], a solution is:
#
#   [
#     [2],
#     [1],
#     [1,2,2],
#     [2,2],
#     [1,2],
#     []
#   ]


class Q090(Solution):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def subsets_with_dup(nums, index, path, ans):
            ans.append(path[:])
            i = index
            while i < len(nums):
                path.append(nums[i])
                subsets_with_dup(nums, i+1, path, ans)
                path.pop()
                while i+1 < len(nums) and nums[i+1] == nums[i]:
                    i += 1
                i += 1

        ans = []
        if nums:
            nums.sort()
            subsets_with_dup(nums, 0, [], ans)
        return ans
