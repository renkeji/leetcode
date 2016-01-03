package solutions;

import junit.framework.TestCase;

public class Q313Test extends TestCase {

    public void testNthSuperUglyNumber() throws Exception {
        Q313 solution = new Q313();
        int[] primes = {2, 7, 13, 19};
        int expected = 32;
        int actual = solution.nthSuperUglyNumber(12, primes);
        assertEquals(expected, actual);
    }

}