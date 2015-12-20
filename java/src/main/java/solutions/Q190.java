package solutions;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 *  If this function is called many times, how would you optimize it?
 */

public class Q190 extends Solution {

    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }
        return n;
    }

    public int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

//    public int reverseBits(int n) {
//        n = (n & 0x55555555) << 1 | (n >>> 1) & 0x55555555;
//        n = (n & 0x33333333) << 2 | (n >>> 2) & 0x33333333;
//        n = (n & 0x0f0f0f0f) << 4 | (n >>> 4) & 0x0f0f0f0f;
//        n = (n << 24) | ((n & 0xff00) << 8) | ((n >>> 8) & 0xff00) | (n >>> 24);
//        return n;
//    }

}
