package solutions;

import junit.framework.TestCase;

public class Q233Test extends TestCase {

    public void testCountDigitOne() throws Exception {
        Q233 solution = new Q233();
        int n = 13;
        int expected = 6;
        int actual = solution.countDigitOne(n);
        assertEquals(expected, actual);

        n = 1410065408;
        expected = 1737167499;
        actual = solution.countDigitOne(n);
        assertEquals(expected, actual);
    }

}