import copy

from src.main.python.Solution import Solution

# The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
#
# Given an integer n, return all distinct solutions to the n-queens puzzle.
#
# Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
# queen and an empty space respectively.
#
# For example,
#   There exist two distinct solutions to the 4-queens puzzle:
#
#   [
#     [".Q..",  // Solution 1
#      "...Q",
#      "Q...",
#      "..Q."],
#
#     ["..Q.",  // Solution 2
#      "Q...",
#      "...Q",
#      ".Q.."]
#   ]


class Q051(Solution):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        ans = []
        if n > 0:
            board = [['.' for j in range(n)] for i in range(n)]
            self.solve_n_queens(0, n, board, ans)
        return ans

    def solve_n_queens(self, col, n, board, ans):
        if col == n:
            one = [(lambda x: ''.join(x))(row) for row in board]
            ans.append(one)
        else:
            for i in range(n):
                board[i][col] = 'Q'
                if self.is_safe(board, i, col):
                    self.solve_n_queens(col+1, n, board, ans)
                board[i][col] = '.'

    def is_safe(self, board, row, col):
        for j in range(col):
            if board[row][j] == 'Q':
                return False

        i, j = row-1, col-1
        while i >= 0 and j >= 0:
            if board[i][j] == 'Q':
                return False
            i -= 1
            j -= 1

        i, j = row+1, col-1
        while i < len(board) and j >= 0:
            if board[i][j] == 'Q':
                return False
            i += 1
            j -= 1

        return True
