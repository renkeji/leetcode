package solutions;

import junit.framework.TestCase;

public class Q356Test extends TestCase {

    public void testIsReflected() throws Exception {
        Q356 solution = new Q356();
        int[][] points = new int[][]{{1, 1}, {-1, 1}};
        assertTrue(solution.isReflected(points));

        points = new int[][]{{1, 1}, {-1, -1}};
        assertFalse(solution.isReflected(points));

        points = new int[][]{{0, 0}};
        assertTrue(solution.isReflected(points));

        points = new int[][]{{-16, 1}, {16, 1}, {16, 1}};
        assertTrue(solution.isReflected(points));
    }

}