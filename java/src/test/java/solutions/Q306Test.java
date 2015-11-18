package solutions;

import junit.framework.TestCase;

public class Q306Test extends TestCase {

    public void testIsAdditiveNumber() throws Exception {
        Q306 solution = new Q306();
        String num = "112358";
        assertTrue(solution.isAdditiveNumber(num));

        num = "199100199";
        assertTrue(solution.isAdditiveNumber(num));

        num = "1023";
        assertFalse(solution.isAdditiveNumber(num));

        num = "198019823962";
        assertTrue(solution.isAdditiveNumber(num));

        num = "101";
        assertTrue(solution.isAdditiveNumber(num));
    }

}