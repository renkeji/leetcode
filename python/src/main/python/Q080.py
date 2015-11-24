from src.main.python.Solution import Solution

# Follow up for "Remove Duplicates":
#     What if duplicates are allowed at most twice?
#
# For example,
#   Given sorted array nums = [1,1,1,2,2,3],
#
#   Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
#   It doesn't matter what you leave beyond the new length.


class Q080(Solution):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        len, cnt = 0, 0
        if nums:
            for i, item in enumerate(nums):
                if not i or item != nums[i-1]:
                    nums[len] = item
                    len += 1
                    cnt = 1
                else:
                    cnt += 1
                    if cnt <= 2:
                        nums[len] = item
                        len += 1
        return len