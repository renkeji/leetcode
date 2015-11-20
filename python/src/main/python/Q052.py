from src.main.python.Solution import Solution

# Follow up for N-Queens problem.
#
# Now, instead outputting board configurations, return the total number of distinct solutions.


class Q052(Solution):
    def totalNQueens(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = 0
        if n > 0:
            board = [['.' for j in range(n)] for i in range(n)]
            ans = self.total_n_queens(0, n, board)
        return ans

    def total_n_queens(self, col, n, board):
        if col == n:
            return 1
        else:
            num = 0
            for i in range(n):
                board[i][col] = 'Q'
                if self.is_safe(board, i, col):
                    num += self.total_n_queens(col+1, n, board)
                board[i][col] = '.'
            return num

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
