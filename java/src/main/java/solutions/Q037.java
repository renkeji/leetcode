package solutions;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 */

public class Q037 extends Solution {

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        if (col >= 9) {
            return true;
        } else {
            int nextRow = row == 8 ? 0 : row + 1;
            int nextCol = row == 8 ? col + 1 : col;
            if (board[row][col] != '.') {
                return solveSudoku(board, nextRow, nextCol);
            } else {
                for (int i = 1; i <= 9; ++i) {
                    board[row][col] = (char)(i + '0');
                    if (isSafe(board, row, col, i) && solveSudoku(board, nextRow, nextCol)) {
                        return true;
                    }
                }
                board[row][col] = '.';
                return false;
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == '.') continue;
            if (board[i][col] - '0' == num && i != row) return false;
        }
        for (int j = 0; j < 9; ++j) {
            if (board[row][j] == '.') continue;
            if (board[row][j] - '0' == num && j != col) return false;
        }
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;
        for (int i = x; i < x + 3; ++i) {
            for (int j = y; j < y + 3; ++j) {
                if (board[i][j] == '.') continue;
                if (board[i][j] - '0' == num && i != row && j != col) return false;
            }
        }
        return true;
    }

}
