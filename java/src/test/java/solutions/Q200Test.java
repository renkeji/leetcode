package solutions;

import junit.framework.TestCase;

public class Q200Test extends TestCase {

    public void testNumIslands() throws Exception {
        Q200 solution = new Q200();
        char[][] grid = new char[][] {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        int actual = solution.numIslands(grid);
        assertEquals(expected, actual);

        grid = new char[][] {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        expected = 3;
        actual = solution.numIslands(grid);
        assertEquals(expected, actual);
    }

}