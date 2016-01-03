package solutions;

import java.util.HashMap;
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
//                if (A[i][k] == 0) continue;
//                for (int j = 0; j < p; ++j) {
//                    C[i][j] += A[i][k] * B[k][j];
//                }
//            }
//        }
//        return C;
//    }

    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null) return null;
        int n = A.length, m = A[0].length, p = B[0].length;
        int[][] C = new int[n][p];
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();

        for(int k = 0; k < m; ++k) {
            hm.put(k, new HashMap<Integer, Integer>());
            for(int j = 0; j < p; ++j) {
                if (B[k][j] != 0){
                    hm.get(k).put(j, B[k][j]);
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            for(int k = 0; k < m; ++k) {
                if (A[i][k] != 0){
                    for (Integer j: hm.get(k).keySet()) {
                        C[i][j] += A[i][k] * hm.get(k).get(j);
                    }
                }
            }
        }
        return C;
    }

}
