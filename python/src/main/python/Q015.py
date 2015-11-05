from src.main.python.Solution import Solution

# Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
# Find all unique triplets in the array which gives the sum of zero.
#
# Note:
#   Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
#   The solution set must not contain duplicate triplets.
#
# For example, given array S = {-1 0 1 2 -1 -4},
#   A solution set is:
#   (-1, 0, 1)
#   (-1, -1, 2)


class Q015(Solution):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = []
        if nums and len(nums) >= 3:
            nums.sort()
            i = 0
            while i < len(nums)-2:
                j, k = i+1, len(nums)-1
                while j < k:
                    sum = nums[i] + nums[j] + nums[k]
                    if sum == 0:
                        ans.append([nums[i], nums[j], nums[k]])
                        k -= 1
                        while j < k < len(nums)-1 and nums[k] == nums[k+1]:
                            k -= 1
                        j += 1
                        while k > j and nums[j] == nums[j-1]:
                            j += 1
                    elif sum < 0:
                        j += 1
                    else:
                        k -= 1
                i += 1
                while i < len(nums)-2 and nums[i] == nums[i-1]:
                    i += 1
        return ans
