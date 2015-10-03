package solutions;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 *
 * For example, the 32-bit integer '11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */

public class Q191 extends Solution {

    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            ++cnt;
            n &= (n - 1);
        }
        return cnt;
    }

}
