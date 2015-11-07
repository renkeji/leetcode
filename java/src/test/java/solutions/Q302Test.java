package solutions;

import junit.framework.TestCase;

public class Q302Test extends TestCase {

    public void testMinArea() throws Exception {
        Q302 solution = new Q302();
        char[][] image = {
            {'0', '0', '1', '0'},
            {'0', '1', '1', '0'},
            {'0', '1', '0', '0'}
        };
        int x = 0;
        int y = 2;
        int expected = 6;
        int actual = solution.minArea(image, x, y);
        assertEquals(expected, actual);
    }

}