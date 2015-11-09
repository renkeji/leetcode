from src.main.python.Solution import Solution

# Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
#
# Do not allocate extra space for another array, you must do this in place with constant memory.
#
# For example,
#   Given input array nums = [1,1,2],
#
# Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
# It doesn't matter what you leave beyond the new length.


class Q026(Solution):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        len = 0
        if nums:
            for i, item in enumerate(nums):
                if not i or item != nums[i-1]:
                    nums[len] = item
                    len += 1
        return len
