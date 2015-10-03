package solutions;

import junit.framework.TestCase;

public class Q190Test extends TestCase {

    public void testReverseBits() throws Exception {
        Q190 solution = new Q190();
        int n = 43261596;
        int expected = 964176192;
        int actual = solution.reverseBits(n);
        assertEquals(expected, actual);
    }

}