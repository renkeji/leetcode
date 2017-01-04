package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 *
 * Example:
 *
 *  A = [
 *    [ 1, 0, 0],
 *    [-1, 0, 3]
 *  ]
 *
 *  B = [
 *    [ 7, 0, 0 ],
 *    [ 0, 0, 0 ],
 *    [ 0, 0, 1 ]
 *  ]
 *
 *       |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 *  AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *       |  0 0 1 |
 */

public class Q311 extends Solution {

//    public int[][] multiply(int[][] A, int[][] B) {
//        int n = A.length;
//        int m = A[0].length;
//        int p = B[0].length;
//        int[][] C = new int[n][p];
//
//        for (int i = 0; i < n; ++i) {
//            for (int k = 0; k < m; ++k) {
//                if (A[i][k] != 0) {
//                    for (int j = 0; j < p; ++j) {
//                        C[i][j] += A[i][k] * B[k][j];
//                    }
//                }
//            }
//        }
//        return C;
//    }

    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length, m = A[0].length, p = B[0].length;
        int[][] C = new int[n][p];

        List[] indexA = new List[n];
        for (int i = 0; i < n; i++) {
            List<Integer> numsA = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (A[i][j] != 0) {
                    numsA.add(j);
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }

        for (int i = 0; i < n; i++) {
            List<Integer> numsA = indexA[i];
            for (int k = 0; k < numsA.size() - 1; k += 2) {
                int colA = numsA.get(k);
                int valA = numsA.get(k + 1);
                for (int j = 0; j < k; j++) {
                    int valB = B[colA][j];
                    C[i][j] += valA * valB;
                }
            }
        }

        return C;
    }

}
