from src.main.python.Solution import Solution

# Given an unsorted integer array, find the first missing positive integer.
#
# For example,
#   Given [1,2,0] return 3,
#   and [3,4,-1,1] return 2.
#
# Your algorithm should run in O(n) time and uses constant space.


class Q041(Solution):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 1
        if nums:
            for i in range(len(nums)):
                while 0 <= nums[i] < len(nums) and nums[nums[i]] != nums[i]:
                    nums[nums[i]], nums[i] = nums[i], nums[nums[i]]

            for i in range(1, len(nums)):
                if nums[i] != i:
                    return i

            ans = len(nums)+1 if nums[0] == len(nums) else len(nums)
        return ans
