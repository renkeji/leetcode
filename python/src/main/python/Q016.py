from src.main.python.Solution import Solution

# Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
# Return the sum of the three integers. You may assume that each input would have exactly one solution.
#
# For example, given array S = {-1 2 1 -4}, and target = 1.
#
# The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


class Q016(Solution):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        ans = None
        if nums and len(nums) >= 3:
            nums.sort()
            diff = None
            i = 0
            while i < len(nums)-2:
                j, k = i+1, len(nums)-1
                while j < k:
                    sum = nums[i] + nums[j] + nums[k]
                    diff = target-sum if diff is None or abs(target-sum) < abs(diff) else diff
                    if sum == target:
                        return target
                    elif sum < target:
                        j += 1
                    else:
                        k -= 1
                i += 1
                while i < len(nums)-2 and nums[i] == nums[i-1]:
                    i += 1
            ans = target - diff
        return ans
