package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 *  Given the following matrix:
 *
 *  [
 *      [ 1, 2, 3 ],
 *      [ 4, 5, 6 ],
 *      [ 7, 8, 9 ]
 *  ]
 *
 *  You should return [1,2,3,6,9,8,7,4,5].
 */

public class Q054 extends Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
            spiralOrder(matrix, matrix.length, matrix[0].length, 0, ans);
        }
        return ans;
    }

    private void spiralOrder(int[][] matrix, int m, int n, int k, List<Integer> ans) {
        if (m > 0 && n > 0) {
            if (m == 1) {
                for (int j = 0; j < n; ++j) {
                    ans.add(matrix[k][j+k]);
                }
            } else if (n == 1) {
                for (int i = 0; i < m; ++i) {
                    ans.add(matrix[k+i][k]);
                }
            } else {
                for (int j = 0; j < n - 1; ++j) {
                    ans.add(matrix[k][k+j]);
                }
                for (int i = 0; i < m - 1; ++i) {
                    ans.add(matrix[k+i][k+n-1]);
                }
                for (int j = 0; j < n - 1; ++j) {
                    ans.add(matrix[k+m-1][k+n-1-j]);
                }
                for (int i = 0; i < m - 1; ++i) {
                    ans.add(matrix[k+m-1-i][k]);
                }
                spiralOrder(matrix, m-2, n-2, k+1, ans);
            }
        }
    }

}
