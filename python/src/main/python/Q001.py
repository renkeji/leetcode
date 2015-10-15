from src.main.python.Solution import Solution


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
                return [numbers[i][1], numbers[j][1]] if numbers[i][1] <= numbers[j][1] else [numbers[j][1], numbers[i][1]]
            elif sum < target:
                i += 1
            else:
                j -= 1
        return []