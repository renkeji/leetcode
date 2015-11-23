from src.main.python.Solution import Solution

# Given a collection of numbers, return all possible permutations.
#
# For example,
#   [1,2,3] have the following permutations:
#   [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


class Q046(Solution):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def permute(nums, index, ans):
            if index == len(nums):
                ans.append(nums[:])
            else:
                for i in range(index, len(nums)):
                    nums[index], nums[i] = nums[i], nums[index]
                    permute(nums, index+1, ans)
                    nums[index], nums[i] = nums[i], nums[index]

        ans = []
        if nums:
            permute(nums, 0, ans)
        return ans
