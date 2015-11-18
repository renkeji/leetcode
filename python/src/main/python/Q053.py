from src.main.python.Solution import Solution

# Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
#
# For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
# the contiguous subarray [4,−1,2,1] has the largest sum = 6.


class Q053(Solution):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = 0
        if nums:
            ans = -(1 << 31)
            sum = 0
            for i in nums:
                if sum + i > i:
                    sum += i
                else:
                    sum = i
                ans = max(ans, sum)
        return ans
