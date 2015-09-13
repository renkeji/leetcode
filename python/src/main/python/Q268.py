class Q268:
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        expected_sum = int(len(nums) * (len(nums) + 1) / 2)
        actual_sum = 0
        for i in nums:
            actual_sum = actual_sum + i
        return expected_sum - actual_sum