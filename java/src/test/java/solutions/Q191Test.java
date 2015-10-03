package solutions;

import junit.framework.TestCase;

public class Q191Test extends TestCase {

    public void testHammingWeight() throws Exception {
        Q191 solution = new Q191();
        int n = 11;
        int expected = 3;
        int actual = solution.hammingWeight(n);
        assertEquals(expected, actual);
    }

}