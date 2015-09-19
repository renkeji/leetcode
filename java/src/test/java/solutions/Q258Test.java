package solutions;

import junit.framework.TestCase;

public class Q258Test extends TestCase {

    public void testAddDigits() throws Exception {
        Q258 solution = new Q258();
        int num = 38;
        int expected = 2;
        int actual = solution.addDigits(num);
        assertEquals(expected, actual);
    }

}