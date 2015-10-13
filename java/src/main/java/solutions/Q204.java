package solutions;

import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */

public class Q204 extends Solution {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        if (n > 2) {
            Arrays.fill(isPrime, 2, n, true);
        }
        for (int i = 2; i * i < n; ++i) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

}
