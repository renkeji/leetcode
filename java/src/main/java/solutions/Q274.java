package solutions;

import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * For example,
 *  given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 *  Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 *
 * Note:
 *  If there are several possible values for h, the maximum one is taken as the h-index.
 */

public class Q274 extends Solution {

    // Solution using sorting
    // Time and space complexities bounded by the sorting algorithm
//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) {
//            return 0;
//        }
//        Arrays.sort(citations);
//        int h = 1;
//        for (int i = 0; i < citations.length; ++i) {
//            if (citations[citations.length - h] >= h) {
//                h++;
//            }
//        }
//        return h - 1;
//    }

    // Solution using extra space
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int N = citations.length;
        int[] count = new int[N + 1]; // count[i] means number of articles which citations >= i
        for (int i = 0; i < N; i++) {
            if (citations[i] > N) {
                count[N] += 1;
            } else {
                count[citations[i]] += 1;
            }
        }
        int sum = 0;
        for (int i = N; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

}
