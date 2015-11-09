from src.main.python.Solution import Solution

# Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
#
# If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
#
# The replacement must be in-place, do not allocate extra memory.
#
# Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
#   1,2,3 → 1,3,2
#   3,2,1 → 1,2,3
#   1,1,5 → 1,5,1


class Q031(Solution):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        def inplace_reverse(nums, start, end):
            i, j = start, end
            while i < j:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1; j -= 1

        if nums:
            index1, index2 = -1, -1
            for i in range(len(nums)-2, -1, -1):
                if nums[i] < nums[i+1]:
                    index1 = i; break
            if index1 == -1:
                inplace_reverse(nums, 0, len(nums)-1)
                return
            for i in range(len(nums)-1, -1, -1):
                if nums[i] > nums[index1]:
                    index2 = i; break
            nums[index1], nums[index2] = nums[index2], nums[index1]
            inplace_reverse(nums, index1+1, len(nums)-1)