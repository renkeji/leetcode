package solutions;

import junit.framework.TestCase;

public class Q400Test extends TestCase {

    public void testFindNthDigit() throws Exception {
        Q400 solution = new Q400();
        int actual = solution.findNthDigit(3);
        assertEquals(3, actual);

        actual = solution.findNthDigit(11);
        assertEquals(0, actual);
    }

}