from src.main.python.Solution import Solution

# Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
# Find all unique quadruplets in the array which gives the sum of target.
#
# Note:
#   Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
#   The solution set must not contain duplicate quadruplets.
#
# For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
#
#   A solution set is:
#       (-1,  0, 0, 1)
#       (-2, -1, 1, 2)
#       (-2,  0, 0, 2)


class Q018(Solution):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ans = []
        if nums:
            nums.sort()
            a = 0
            while a < len(nums)-3:
                b = a+1
                while b < len(nums)-2:
                    c, d = b+1, len(nums)-1
                    while c < d:
                        sum = nums[a]+nums[b]+nums[c]+nums[d]
                        if sum == target:
                            ans.append([nums[a], nums[b], nums[c], nums[d]])
                            c += 1
                            while c < d and nums[c] == nums[c-1]:
                                c += 1
                            d -= 1
                            while c < d and nums[d] == nums[d+1]:
                                d -= 1
                        elif sum < target:
                            c += 1
                        else:
                            d -= 1
                    b += 1
                    while b < len(nums)-2 and nums[b] == nums[b-1]:
                        b += 1
                a += 1
                while a < len(nums)-3 and nums[a] == nums[a-1]:
                    a += 1
        return ans
