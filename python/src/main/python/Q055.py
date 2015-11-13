from src.main.python.Solution import Solution

# Given an array of non-negative integers, you are initially positioned at the first index of the array.
#
# Each element in the array represents your maximum jump length at that position.
#
# Determine if you are able to reach the last index.
#
# For example:
#   A = [2,3,1,1,4], return true.
#
#   A = [3,2,1,0,4], return false.


class Q055(Solution):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if nums:
            can_reach = 0
            for i in range(len(nums)):
                if i <= can_reach:
                    can_reach = max(can_reach, nums[i]+i)
                    if can_reach >= len(nums)-1:
                        return True
        return False
