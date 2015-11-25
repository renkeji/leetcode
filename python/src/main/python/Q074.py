from src.main.python.Solution import Solution

# Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
#
#   Integers in each row are sorted from left to right.
#   The first integer of each row is greater than the last integer of the previous row.
#
# For example,
#
#   Consider the following matrix:
#
#   [
#     [1,   3,  5,  7],
#     [10, 11, 16, 20],
#     [23, 30, 34, 50]
#   ]
#   Given target = 3, return true.


class Q074(Solution):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row, col = 0, len(matrix[0])-1
        while row < len(matrix) and col >= 0:
            if target == matrix[row][col]:
                return True
            elif target < matrix[row][col]:
                col -= 1
            else:
                row += 1
        return False
