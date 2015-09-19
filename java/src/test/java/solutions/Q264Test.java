package solutions;

import junit.framework.TestCase;

public class Q264Test extends TestCase {

    public void testNthUglyNumber() throws Exception {
        Q264 solution = new Q264();
        int n = 10;
        int expected = 12;
        int actual = solution.nthUglyNumber(n);
        assertEquals(expected, actual);
    }

}