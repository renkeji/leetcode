from src.main.python.Solution import Solution

# Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
# n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
# Find two lines, which together with x-axis forms a container, such that the container contains the most water.
#
# Note: You may not slant the container.


class Q011(Solution):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        max_area = 0
        i, j = 0, len(height) - 1
        while i < j:
            min_height = min(height[i], height[j])
            area = min_height * (j - i)
            max_area = max(max_area, area)
            if min_height == height[i]:
                while i < j and height[i] <= min_height:
                    i += 1
            else:
                while i < j and height[j] <= min_height:
                    j -= 1
        return max_area
