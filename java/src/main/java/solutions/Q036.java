package solutions;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

public class Q036 extends Solution {

    public boolean isValidSudoku(char[][] board) {
        return isValidSudoku(board, 0, 0);
    }

    private boolean isValidSudoku(char[][] board, int row, int col) {
        if (col >= 9) {
            return true;
        } else {
            char num = board[row][col];
            if (num == '.' || isSafe(board, row, col, num - '0')) {
                int nextRow = row == 8 ? 0 : row + 1;
                int nextCol = row == 8 ? col + 1 : col;
                return isValidSudoku(board, nextRow, nextCol);
            } else {
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
