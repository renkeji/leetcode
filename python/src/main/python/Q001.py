from src.main.python.Solution import Solution

# Given an array of integers, find two numbers such that they add up to a specific target number.
#
# The function twoSum should return indices of the two numbers such that they add up to the target,
# where index1 must be less than index2.
# Please note that your returned answers (both index1 and index2) are not zero-based.
#
# You may assume that each input would have exactly one solution.
#
# Input: numbers={2, 7, 11, 15}, target=9
# Output: index1=1, index2=2


class Q001(Solution):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        numbers = [(n, i+1) for i, n in enumerate(nums)]
        numbers.sort(key=lambda t: t[0])
        i, j = 0, len(numbers) - 1
        while i < j:
            sum = numbers[i][0] + numbers[j][0]
            if sum == target:
                return [numbers[i][1], numbers[j][1]] if numbers[i][1] <= numbers[j][1] \
                    else [numbers[j][1], numbers[i][1]]
            elif sum < target:
                i += 1
            else:
                j -= 1
        return []
