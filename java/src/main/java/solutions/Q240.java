package solutions;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  Integers in each row are sorted in ascending from left to right.
 *  Integers in each column are sorted in ascending from top to bottom.
 *
 * For example,
 *  Consider the following matrix:
 *  [
 *      [1,   4,  7, 11, 15],
 *      [2,   5,  8, 12, 19],
 *      [3,   6,  9, 16, 22],
 *      [10, 13, 14, 17, 24],
 *      [18, 21, 23, 26, 30]
 *  ]
 *
 *  Given target = 5, return true.
 *  Given target = 20, return false.
 */

public class Q240 extends Solution {


    // O(colLen + rowLen) time + O(1) space
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int row = 0, col = matrix[0].length - 1;
//        while (row < matrix.length && col >= 0) {
//            if (target == matrix[row][col]) {
//                return true;
//            } else if (target < matrix[row][col]) {
//                --col;
//            } else {
//                ++row;
//            }
//        }
//        return false;
//    }

    // O(rowLen*log colLen) time
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int upperRow, int upperCol, int lowerRow, int lowerCol) {
        if (lowerCol < upperCol || lowerRow < upperRow) {
            return false;
        } else if (target < matrix[upperRow][upperCol] || target > matrix[lowerRow][lowerCol]) {
            return false;
        } else {
            int midCol = upperCol + (lowerCol - upperCol) / 2;
            int row = upperRow;
            while (row <= lowerRow && matrix[row][midCol] <= target) {
                if (matrix[row][midCol] == target) {
                    return true;
                } else {
                    ++row;
                }
            }
            return searchMatrix(matrix, target, upperRow, midCol+1, row-1, lowerCol)
                || searchMatrix(matrix, target, row, upperCol, lowerRow, midCol-1);

        }
    }

}
