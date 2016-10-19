package solutions;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 *
 * Example:
 *  Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */

public class Q357 extends Solution {

    public int countNumbersWithUniqueDigits(int n) {
        assert(n >= 0);

        int ans = 1, accum = 0;
        for (int i = 1; i <= Math.min(10, n); ++i) {
            accum = i == 1 ? 9 : accum * (9 - i + 2);
            ans += accum;
        }
        return ans;
    }

}
