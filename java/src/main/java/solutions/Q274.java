package solutions;

import java.util.Arrays;

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
