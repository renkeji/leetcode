package solutions;

import junit.framework.TestCase;

public class Q265Test extends TestCase {

    public void testMinCostII() throws Exception {
        Q265 solution = new Q265();
        int[][] costs = { {1, 5, 3}, {2, 9, 4} };
        int expected = 5;
        int actual = solution.minCostII(costs);
        assertEquals(expected, actual);
    }

}