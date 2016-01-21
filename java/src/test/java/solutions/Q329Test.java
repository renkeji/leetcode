package solutions;

import junit.framework.TestCase;

public class Q329Test extends TestCase {

    public void testLongestIncreasingPath() throws Exception {
        Q329 solution = new Q329();
        int[][] matrix = new int[][]{
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        };
        int expected = 4;
        int actual = solution.longestIncreasingPath(matrix);
        assertEquals(expected, actual);

        matrix = new int[][]{
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        };
        expected = 4;
        actual = solution.longestIncreasingPath(matrix);
        assertEquals(expected, actual);
    }

}