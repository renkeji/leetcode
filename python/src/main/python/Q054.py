from src.main.python.Solution import Solution

# Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
#
# For example,
#   Given the following matrix:
#
#   [
#     [ 1, 2, 3 ],
#     [ 4, 5, 6 ],
#     [ 7, 8, 9 ]
#   ]
#   You should return [1,2,3,6,9,8,7,4,5].


class Q054(Solution):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        def spiral_order(matrix, row, col, offset, ans):
            if row <= 0 or col <= 0:
                return
            elif row == 1:
                for j in range(col):
                    ans.append(matrix[offset][offset+j])
            elif col == 1:
                for i in range(row):
                    ans.append(matrix[offset+i][offset])
            else:
                for j in range(col-1):
                    ans.append(matrix[offset][offset+j])
                for i in range(row-1):
                    ans.append(matrix[offset+i][offset+col-1])
                for j in range(col-1):
                    ans.append(matrix[offset+row-1][offset+col-1-j])
                for i in range(row-1):
                    ans.append(matrix[offset+row-1-i][offset])
                spiral_order(matrix, row-2, col-2, offset+1, ans)

        ans = []
        if matrix and matrix[0]:
            spiral_order(matrix, len(matrix), len(matrix[0]), 0, ans)
        return ans
