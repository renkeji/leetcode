package solutions;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 *  1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 *  2. Any live cell with two or three live neighbors lives on to the next generation.
 *  3. Any live cell with more than three live neighbors dies, as if by over-population..
 *  4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given its current state.
 *
 * Follow up:
 *  1.  Could you solve it in-place? Remember that the board needs to be updated at the same time:
 *      You cannot update some cells first and then use their updated values to update other cells.
 *  2.  In this question, we represent the board using a 2D array. In principle, the board is infinite,
 *      which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */

public class Q289 extends Solution {

    public void gameOfLife(int[][] board) {
        int[][] update = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int liveCells = getNumberOfLiveCells(board, i, j);
                update[i][j] = board[i][j];
                if (board[i][j] == 1) { // live cell
                    if (liveCells < 2 || liveCells > 3) {
                        update[i][j] = 0;
                    }
                } else {    // dead cell
                    if (liveCells == 3) {
                        update[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; ++i) {
            System.arraycopy(update[i], 0, board[i], 0, update[0].length);
        }
    }

    private int getNumberOfLiveCells(int[][] board, int row, int col) {
        int ans = 0;
        if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 1) {
            ans++;
        }
        if (row - 1 >= 0 && board[row - 1][col] == 1) {
            ans++;
        }
        if (row - 1 >= 0 && col + 1 < board[0].length && board[row - 1][col + 1] == 1) {
            ans++;
        }
        if (col + 1 < board[0].length && board[row][col + 1] == 1) {
            ans++;
        }
        if (row + 1 < board.length && col + 1 < board[0].length && board[row + 1][col + 1] == 1) {
            ans++;
        }
        if (row + 1 < board.length && board[row + 1][col] == 1) {
            ans++;
        }
        if (row + 1 < board.length && col - 1 >= 0 && board[row + 1][col - 1] == 1) {
            ans++;
        }
        if (col - 1 >= 0 && board[row][col - 1] == 1) {
            ans++;
        }
        return ans;
    }

}
