package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 *
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */

public class Q313 extends Solution {

//    public int nthSuperUglyNumber(int n, int[] primes) {
//        int[] dp = new int[n];
//        int[] indexes = new int[primes.length];
//        int[] uglyNumbers = new int[primes.length];
//        System.arraycopy(primes, 0, uglyNumbers, 0, primes.length);
//        int ugly = 1;
//        for (int i = 1; i < n; ++i) {
//            ugly = findMin(uglyNumbers);
//            dp[i] = ugly;
//            for (int j = 0; j < primes.length; ++j) {
//                if (ugly == uglyNumbers[j]) {
//                    uglyNumbers[j] = dp[++indexes[j]] * primes[j];
//                }
//            }
//        }
//        return ugly;
//    }
//
//    private int findMin(int[] a) {
//        int min = a[0];
//        for (int num : a) {
//            if (num < min) {
//                min = num;
//            }
//        }
//        return min;
//    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] indexes = new int[primes.length];
        int[] uglyNumbers = new int[primes.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(primes.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.arraycopy(primes, 0, uglyNumbers, 0, primes.length);
        for (int ugly : uglyNumbers) {
            minHeap.offer(ugly);
        }
        int ugly = 1;
        for (int i = 1; i < n; ++i) {
            ugly = minHeap.poll();
            while (!minHeap.isEmpty() && minHeap.peek() == ugly) {
                minHeap.poll();
            }
            dp[i] = ugly;
            for (int j = 0; j < primes.length; ++j) {
                if (ugly == uglyNumbers[j]) {
                    uglyNumbers[j] = dp[++indexes[j]] * primes[j];
                    minHeap.offer(uglyNumbers[j]);
                }
            }
        }
        return ugly;
    }

}
