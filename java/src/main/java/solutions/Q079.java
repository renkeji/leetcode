package solutions;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 *  Given board =
 *  [
 *      ['A','B','C','E'],
 *      ['S','F','C','S'],
 *      ['A','D','E','E']
 *  ]
 *
 *  word = "ABCCED", -> returns true,
 *  word = "SEE", -> returns true,
 *  word = "ABCB", -> returns false.
 */

public class Q079 extends Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0)
            return false;
        if (board.length * board[0].length < word.length())
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (exist(board, visited, word, i, j)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, boolean[][] visited, String word, int row, int col) {
        if (word.length() == 0) return true;
        if (row >= board.length || row < 0) return false;
        if (col >= board[0].length || col < 0) return false;
        if (visited[row][col]) return false;

        if (board[row][col] == word.charAt(0)) {
            visited[row][col] = true;
            if (exist(board, visited, word.substring(1), row + 1, col)) return true;
            if (exist(board, visited, word.substring(1), row - 1, col)) return true;
            if (exist(board, visited, word.substring(1), row, col + 1)) return true;
            if (exist(board, visited, word.substring(1), row, col - 1)) return true;
        }

        visited[row][col] = false;
        return false;
    }

}
