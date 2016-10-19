package solutions;

import junit.framework.TestCase;

public class Q367Test extends TestCase {

    public void testIsPerfectSquare() throws Exception {
        Q367 solution = new Q367();
        int num = 16;
        assertTrue(solution.isPerfectSquare(num));

        num = 14;
        assertFalse(solution.isPerfectSquare(num));

        num = 3;
        assertFalse(solution.isPerfectSquare(num));

        num = 4;
        assertTrue(solution.isPerfectSquare(num));
    }

}