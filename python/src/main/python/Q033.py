from src.main.python.Solution import Solution

# Suppose a sorted array is rotated at some pivot unknown to you beforehand.
#
# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
#
# You are given a target value to search. If found in the array return its index, otherwise return -1.
#
# You may assume no duplicate exists in the array.


class Q033(Solution):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if nums:
            left, right = 0, len(nums)-1
            while left <= right:
                mid = (left + right)//2
                if nums[mid] == target:
                    return mid
                elif nums[mid] >= nums[left]:
                    if nums[left] <= target < nums[mid]:
                        right = mid-1
                    else:
                        left = mid+1
                else:
                    if nums[mid] < target <= nums[right]:
                        left = mid+1
                    else:
                        right = mid-1
        return -1
