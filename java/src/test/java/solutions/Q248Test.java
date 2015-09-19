package solutions;

import junit.framework.TestCase;

public class Q248Test extends TestCase {

    public void testStrobogrammaticInRange() throws Exception {
        Q248 solution = new Q248();

        String low = "50";
        String high = "100";
        int expected = 3;
        int actual = solution.strobogrammaticInRange(low, high);
        assertEquals(expected, actual);
    }

}