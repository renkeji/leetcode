from src.main.python.Solution import Solution

# Given an array of non-negative integers, you are initially positioned at the first index of the array.
#
# Each element in the array represents your maximum jump length at that position.
#
# Your goal is to reach the last index in the minimum number of jumps.
#
# For example:
# Given array A = [2,3,1,1,4]
#
# The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)


class Q045(Solution):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        if nums:
            has_reached, can_reach = 0, 0
            for i in range(len(nums)):
                if i > has_reached:
                    has_reached = can_reach
                    ans += 1
                can_reach = max(can_reach, nums[i]+i)
        return ans
