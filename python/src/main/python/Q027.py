from src.main.python.Solution import Solution

# Given an array and a value, remove all instances of that value in place and return the new length.
#
# The order of elements can be changed. It doesn't matter what you leave beyond the new length.


class Q027(Solution):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        len = 0
        if nums:
            for num in nums:
                if num != val:
                    nums[len] = num
                    len += 1
        return len